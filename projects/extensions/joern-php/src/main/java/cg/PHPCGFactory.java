package cg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ast.expressions.CallExpressionBase;
import ast.expressions.Identifier;
import ast.expressions.NewExpression;
import ast.expressions.StringExpression;
import ast.expressions.Variable;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.Method;
import ast.php.functionDef.FunctionDef;
import ast.php.functionDef.TopLevelFunctionDef;
import cg.CG;
import cg.CGEdge;
import cg.CGNode;
import inputModules.csv.PHPCSVNodeTypes;
import misc.MultiHashMap;

public class PHPCGFactory {

	// maintains a map of known function names (e.g., "B\foo" -> function foo() in namespace B)
	private static HashMap<String,FunctionDef> functionDefs = new HashMap<String,FunctionDef>();
	// maintains a list of function calls
	private static LinkedList<CallExpressionBase> functionCalls = new LinkedList<CallExpressionBase>();
	
	// maintains a map of known static method names (e.g., "B\A::foo" -> static function foo() in class A in namespace B)
	private static HashMap<String,Method> staticMethodDefs = new HashMap<String,Method>();
	// maintains a list of static method calls
	private static LinkedList<StaticCallExpression> staticMethodCalls = new LinkedList<StaticCallExpression>();
	
	// maintains a map of known constructors (e.g., "B\A" -> static function __construct() in class A in namespace B)
	private static HashMap<String,Method> constructorDefs = new HashMap<String,Method>();
	// maintains a list of static method calls
	private static LinkedList<NewExpression> constructorCalls = new LinkedList<NewExpression>();
	
	// maintains a map of known non-static method names (e.g., "foo" -> {function foo() in class A, function foo() in class C}
	// this is a MultiHashMap, as these names are not necessarily unique; we could in theory use a similar
	// mapping as for static method defs (e.g., "A->foo -> function foo() in class A, B->foo -> function foo() in class B),
	// however that would make it inefficient to lookup the methods when inspecting the method calls
	private static MultiHashMap<String,Method> nonStaticMethodDefs = new MultiHashMap<String,Method>();
	// maintains a list of non-static method calls
	private static LinkedList<MethodCallExpression> nonStaticMethodCalls = new LinkedList<MethodCallExpression>();

	
	/**
	 * Creates a new CG instance based on the lists of known function definitions and function calls.
	 * 
	 * Call this after all function definitions and calls have been added to the lists using
	 * addFunctionDef(FunctionDef) and addFunctionCall(CallExpression).
	 * 
	 * After a call graph has been constructed, these lists are automatically reset.
	 * 
	 * @return A new call graph instance.
	 */
	public static CG newInstance() {
		
		CG cg = new CG();

		createFunctionCallEdges(cg);
		createStaticMethodCallEdges(cg);
		createConstructorCallEdges(cg);
		createNonStaticMethodCallEdges(cg);
		
		reset();
		
		return cg;
	}

	private static void createFunctionCallEdges(CG cg) {
		
		for( CallExpressionBase functionCall : functionCalls) {

			// make sure the call target is statically known
			if( functionCall.getTargetFunc() instanceof Identifier) {
				
				Identifier callIdentifier = (Identifier)functionCall.getTargetFunc();
				
				// if call identifier is fully qualified,
				// just look for the function's definition right away
				if( callIdentifier.getFlags().contains( PHPCSVNodeTypes.FLAG_NAME_FQ)) {
					String functionKey = callIdentifier.getNameChild().getEscapedCodeStr();
					addCallEdgeIfDefinitionKnown(cg, functionDefs, functionCall, functionKey);
				}

				// otherwise, i.e., if the call identifier is not fully qualified,
				// first look in the current namespace, then if the function is not found,
				// look in the global namespace
				// (see http://php.net/manual/en/language.namespaces.rules.php)
				else {
					boolean found = false;
					// note that looking in the current namespace first only makes
					// sense if we are not already in the global namespace anyway
					if( !callIdentifier.getEnclosingNamespace().isEmpty()) {
						String functionKey = callIdentifier.getEnclosingNamespace() + "\\"
								+ callIdentifier.getNameChild().getEscapedCodeStr();
						found = addCallEdgeIfDefinitionKnown(cg, functionDefs, functionCall, functionKey);
					}
					
					// we did not find the function or were already in global namespace;
					// try to find the function in the global namespace
					if( !found) {
						String functionKey = callIdentifier.getNameChild().getEscapedCodeStr();
						addCallEdgeIfDefinitionKnown(cg, functionDefs, functionCall, functionKey);
					}
				}
			}
			else
				System.err.println("Statically unknown function call at node id " + functionCall.getNodeId() + "!");
		}
	}
	
	private static void createStaticMethodCallEdges(CG cg) {
		
		for( StaticCallExpression staticCall : staticMethodCalls) {
			
			// make sure the call target is statically known
			if( staticCall.getTargetClass() instanceof Identifier
					&& staticCall.getTargetFunc() instanceof StringExpression) {
				
				Identifier classIdentifier = (Identifier)staticCall.getTargetClass();
				StringExpression methodName = (StringExpression)staticCall.getTargetFunc();
				
				// if class identifier is fully qualified,
				// just look for the static method's definition right away
				if( classIdentifier.getFlags().contains( PHPCSVNodeTypes.FLAG_NAME_FQ)) {
					String staticMethodKey = classIdentifier.getNameChild().getEscapedCodeStr()
							+ "::" + methodName.getEscapedCodeStr();
					addCallEdgeIfDefinitionKnown(cg, staticMethodDefs, staticCall, staticMethodKey);
				}

				// otherwise, i.e., if the call identifier is not fully qualified,
				// prepend the current namespace first and look for it there
				// (see http://php.net/manual/en/language.namespaces.rules.php)
				else {

					// note that prepending the current namespace only makes
					// sense if there is one
					if( !classIdentifier.getEnclosingNamespace().isEmpty()) {
						String staticMethodKey = classIdentifier.getEnclosingNamespace() + "\\"
								+ classIdentifier.getNameChild().getEscapedCodeStr()
								+ "::" + methodName.getEscapedCodeStr();
						addCallEdgeIfDefinitionKnown(cg, staticMethodDefs, staticCall, staticMethodKey);
					}
					
					// if we are in the global namespace, we should not accidentally prepend a backslash
					else {
						String staticMethodKey = classIdentifier.getNameChild().getEscapedCodeStr()
								+ "::" + methodName.getEscapedCodeStr();
						addCallEdgeIfDefinitionKnown(cg, staticMethodDefs, staticCall, staticMethodKey);
					}
				}
			}
			else
				System.err.println("Statically unknown static method call at node id " + staticCall.getNodeId() + "!");
		}
	}

	private static void createConstructorCallEdges(CG cg) {
		
		for( NewExpression constructorCall : constructorCalls) {
			
			// make sure the call target is statically known
			if( constructorCall.getTargetClass() instanceof Identifier) {
				
				Identifier classIdentifier = (Identifier)constructorCall.getTargetClass();
				
				// if class identifier is fully qualified,
				// just look for the constructor's definition right away
				if( classIdentifier.getFlags().contains( PHPCSVNodeTypes.FLAG_NAME_FQ)) {
					String constructorKey = classIdentifier.getNameChild().getEscapedCodeStr();
					addCallEdgeIfDefinitionKnown(cg, constructorDefs, constructorCall, constructorKey);
				}

				// otherwise, i.e., if the call identifier is not fully qualified,
				// prepend the current namespace first and look for it there
				// (see http://php.net/manual/en/language.namespaces.rules.php)
				else {

					// note that prepending the current namespace only makes
					// sense if there is one
					if( !classIdentifier.getEnclosingNamespace().isEmpty()) {
						String constructorKey = classIdentifier.getEnclosingNamespace() + "\\"
								+ classIdentifier.getNameChild().getEscapedCodeStr();
						addCallEdgeIfDefinitionKnown(cg, constructorDefs, constructorCall, constructorKey);
					}
					
					// if we are in the global namespace, we should not accidentally prepend a backslash
					else {
						String constructorKey = classIdentifier.getNameChild().getEscapedCodeStr();
						addCallEdgeIfDefinitionKnown(cg, constructorDefs, constructorCall, constructorKey);
					}
				}
			}
			else
				System.err.println("Statically unknown constructor call at node id " + constructorCall.getNodeId() + "!");
		}
	}
	
	private static void createNonStaticMethodCallEdges(CG cg) {
		
		int successfullyMapped = 0;
		int ambiguousNotMapped = 0;
		
		for( MethodCallExpression methodCall : nonStaticMethodCalls) {
			
			// make sure the call target is statically known
			if( methodCall.getTargetFunc() instanceof StringExpression) {
				
				StringExpression methodName = (StringExpression)methodCall.getTargetFunc();
				String methodKey = methodName.getEscapedCodeStr();
				// let's count the dynamic methods that could be mapped, and those that cannot
				if( nonStaticMethodDefs.containsKey(methodKey)) {
						
					// check whether there is only one matching function definition
					if( nonStaticMethodDefs.get(methodKey).size() == 1) {
						addCallEdge( cg, methodCall, nonStaticMethodDefs.get(methodKey).get(0));
						successfullyMapped++;
					}
					else { // there is more than one matching function definition
						// we can still map $this->foo(), though, because we know what $this is
						if( methodCall.getTargetObject() instanceof Variable
							&& ((Variable)methodCall.getTargetObject()).getNameExpression() instanceof StringExpression
							&& ((StringExpression)((Variable)methodCall.getTargetObject()).getNameExpression()).getEscapedCodeStr().equals("this")) {
							
							String enclosingClass = methodCall.getEnclosingClass();
							for( Method methodDef : nonStaticMethodDefs.get(methodKey)) {
								if( enclosingClass.equals(methodDef.getEnclosingClass())) {
									addCallEdge( cg, methodCall, methodDef);
									successfullyMapped++;
									break;
								}
							}							
						}
						else
							ambiguousNotMapped++;
					}
				}
			}
			else
				System.err.println("Statically unknown non-static method call at node id " + methodCall.getNodeId() + "!");
		}
		
		System.err.println();
		System.err.println("Summary dynamic method call construction");
		System.err.println("----------------------------------------");
		System.err.println();
		
		/* Statistics on method calls */
		System.err.println("Successfully mapped dynamic method calls: " + successfullyMapped);
		System.err.println("Ambiguous non-mapped dynamic method calls: " + ambiguousNotMapped);
		float mappedMethodCallsPercent = (successfullyMapped + ambiguousNotMapped) == 0 ? 100 :
			((float)successfullyMapped/((float)successfullyMapped+(float)ambiguousNotMapped)) * 100;
		System.err.println( "=> " + mappedMethodCallsPercent + "% " +
				"of non-static method calls could be successfully mapped.");
		System.err.println();

		/* Statistics on method defs */
		int uniqueDefs = 0, ambiguousDefs = 0;
		for( List<Method> methodList : nonStaticMethodDefs.values()) {
			if( methodList.size() == 1)
				uniqueDefs++;
			else
				ambiguousDefs++;
		}
		System.err.println("Unique method names: " + uniqueDefs);
		System.err.println("Duplicate method names: " + ambiguousDefs);
		float uniqueMethodNamesPercent = (uniqueDefs + ambiguousDefs) == 0 ? 100 :
			((float)uniqueDefs/((float)uniqueDefs+(float)ambiguousDefs)) * 100;
		System.err.println( "=> " + uniqueMethodNamesPercent + "% of all method names were unique.");
	}
	
	/**
	 * Checks whether a given function key is known and if yes,
	 * adds a corresponding edge in the given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addCallEdgeIfDefinitionKnown(CG cg, HashMap<String,? extends FunctionDef> defSet, CallExpressionBase functionCall, String functionKey) {
		
		boolean ret = false;
		
		// check whether we know the called function
		if( defSet.containsKey(functionKey))		
			ret = addCallEdge( cg, functionCall, defSet.get(functionKey));
		
		return ret;
	}
	
	/**
	 * Adds an edge to a given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addCallEdge(CG cg, CallExpressionBase functionCall, FunctionDef functionDef) {
		
		boolean ret = false;
		
		CGNode caller = new CGNode(functionCall);
		CGNode callee = new CGNode(functionDef);
		ret = cg.addVertex(caller);
		// note that adding a callee node many times is perfectly fine:
		// CGNode overrides the equals() and hashCode() methods,
		// so it will actually only be added the first time
		cg.addVertex(callee);
		cg.addEdge(new CGEdge(caller, callee));
		
		return ret;
	}
	
	private static void reset() {
	
		functionDefs.clear();
		functionCalls.clear();
		
		staticMethodDefs.clear();
		staticMethodCalls.clear();
		
		constructorDefs.clear();
		constructorCalls.clear();
		
		nonStaticMethodDefs.clear();
		nonStaticMethodCalls.clear();
	}
	
	/**
	 * Adds a new known function definition.
	 * 
	 * @param functionDef A PHP function definition. If a function definition with the same
	 *                    name was previously added, then the new function definition will
	 *                    be used for that name and the old function definition will be returned.
	 * @return If there already exists a PHP function definition with the same name,
	 *         then returns that function definition. Otherwise, returns null. For non-static method
	 *         definitions, always returns null.
	 */
	public static FunctionDef addFunctionDef( FunctionDef functionDef) {

		// artificial toplevel functions wrapping toplevel code cannot be called
		if( functionDef instanceof TopLevelFunctionDef)
			return null;
		
		// we also ignore closures as they do not have a statically known reference
		else if( functionDef instanceof Closure)
			return null;
		
		// finally, abstract methods cannot be called either
		else if( functionDef instanceof Method
				&& functionDef.getFlags().contains(PHPCSVNodeTypes.FLAG_MODIFIER_ABSTRACT))
			return null;
		
		// it's a static method
		else if( functionDef instanceof Method
				&& functionDef.getFlags().contains(PHPCSVNodeTypes.FLAG_MODIFIER_STATIC)) {
			// use A\B\C::foo as key for a static method foo in class A\B\C
			String staticMethodKey = ((Method)functionDef).getEnclosingClass() + "::" + functionDef.getName();
			if( !functionDef.getEnclosingNamespace().isEmpty())
				staticMethodKey = functionDef.getEnclosingNamespace() + "\\" + staticMethodKey;
			
			if( staticMethodDefs.containsKey(staticMethodKey)) {
				System.err.println("Static method definition '" + staticMethodKey + "' ambiguous: There are at least two known " +
						" matching static method definitions (id " + staticMethodDefs.get(staticMethodKey).getNodeId() +
						" and id " + functionDef.getNodeId() + ")");
			}
			
			return staticMethodDefs.put( staticMethodKey, (Method)functionDef);
		}
		
		// it's a constructor
		// Note that a PHP constructor cannot be static, so the previous case for static methods evaluates to false;
		// also note that there are two possible constructor names: __construct() (recommended) and ClassName() (legacy)
		else if( functionDef instanceof Method
				&& (functionDef.getName().equals("__construct")
						|| functionDef.getName().equals(((Method)functionDef).getEnclosingClass()))) {
			// use A\B\C as key for the unique constructor of a class A\B\C
			String constructorKey = ((Method)functionDef).getEnclosingClass();
			if( !functionDef.getEnclosingNamespace().isEmpty())
				constructorKey = functionDef.getEnclosingNamespace() + "\\" + constructorKey;
			
			if( constructorDefs.containsKey(constructorKey)) {
				System.err.println("Constructor definition for '" + constructorKey + "' ambiguous: There are at least two known " +
						" constructor definitions (id " + constructorDefs.get(constructorKey).getNodeId() +
						" and id " + functionDef.getNodeId() + ")");
			}
			
			return constructorDefs.put( constructorKey, (Method)functionDef);
		}
		
		// other methods than the above are non-static methods
		else if( functionDef instanceof Method) {
			// use foo as key for a non-static method foo in any class in any namespace;
			// note that the enclosing namespace of a non-static method definition is irrelevant here,
			// as that is usually not known at the call site (neither is the class name, except
			// when the keyword $this is used)
			String methodKey = ((Method)functionDef).getName();

			if( nonStaticMethodDefs.containsKey(methodKey)) {
				System.err.println("Method definition for '" + methodKey + "' ambiguous: " +
						" already known method definitions are " + nonStaticMethodDefs.get(methodKey) +
						", now adding " + functionDef + ")");
			}
			
			nonStaticMethodDefs.add( methodKey, (Method)functionDef);
			
			return null;
		}
		
		// it's a function (i.e., not inside a class)
		else {
			// use A\B\foo as key for a function foo() in namespace \A\B
			String functionKey = functionDef.getName();
			if( !functionDef.getEnclosingNamespace().isEmpty())
				functionKey = functionDef.getEnclosingNamespace() + "\\" + functionKey;
		
			if( functionDefs.containsKey(functionKey)) {
				System.err.println("Function definition '" + functionKey + "' ambiguous: There are at least two known " +
						" matching function definitions (id " + functionDefs.get(functionKey).getNodeId() +
						" and id " + functionDef.getNodeId() + ")");
			}
			
			return functionDefs.put( functionKey, functionDef);
		}		
	}
	
	/**
	 * Adds a new function call.
	 * 
	 * @param functionCall A PHP function/method/constructor call. An arbitrary number of
	 *                     distinguished calls to the same function/method/constructor can
	 *                     be added.
	 */
	public static boolean addFunctionCall( CallExpressionBase callExpression) {
		
		// Note: we cannot access any of the CallExpression's getter methods here
		// because this method is called from the PHPCSVNodeInterpreter at the point
		// where it constructs the CallExpression. That is, this method is called for each
		// CallExpression *immediately* after its construction. At that point, the PHPCSVNodeInterpreter
		// has not called the CallExpression's setter methods  (as it has not yet interpreted the
		// corresponding CSV lines).
		// Hence, we only store the references to the CallExpression objects themselves.
	
		if( callExpression instanceof StaticCallExpression)
			return staticMethodCalls.add( (StaticCallExpression)callExpression);
		else if( callExpression instanceof NewExpression)
			return constructorCalls.add( (NewExpression)callExpression);
		else if( callExpression instanceof MethodCallExpression)
			return nonStaticMethodCalls.add( (MethodCallExpression)callExpression);
		else
			return functionCalls.add( callExpression);
	}
}
