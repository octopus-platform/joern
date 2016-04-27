package languages.php.cg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import ast.expressions.CallExpression;
import ast.expressions.Identifier;
import ast.expressions.NewExpression;
import ast.expressions.StringExpression;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.Method;
import ast.php.functionDef.PHPFunctionDef;
import ast.php.functionDef.TopLevelFunctionDef;
import cg.CG;
import cg.CGEdge;
import cg.CGNode;
import tools.php.ast2cfgddg.PHPCSVNodeTypes;

public class PHPCGFactory {

	// maintains a map of known function names
	private static HashMap<String,PHPFunctionDef> functionDefs = new HashMap<String,PHPFunctionDef>();
	// maintains a list of function calls
	private static LinkedList<CallExpression> functionCalls = new LinkedList<CallExpression>();
	
	// maintains a map of known static method names
	private static HashMap<String,Method> staticMethodDefs = new HashMap<String,Method>();
	// maintains a list of static method calls
	private static LinkedList<StaticCallExpression> staticMethodCalls = new LinkedList<StaticCallExpression>();
	
	// maintains a map of known constructors
	private static HashMap<String,Method> constructorDefs = new HashMap<String,Method>();
	// maintains a list of static method calls
	private static LinkedList<NewExpression> constructorCalls = new LinkedList<NewExpression>();
	
	// maintains a map of known non-static method names
	private static HashMap<String,Method> nonStaticMethodDefs = new HashMap<String,Method>();
	// maintains a list of non-static method calls
	private static LinkedList<MethodCallExpression> nonStaticMethodCalls = new LinkedList<MethodCallExpression>();
	// maintains a set of blacklisted non-static method names
	// (these are non-static method names that not unique, and so we do not construct any 
	// call edges pointing to them)
	private static HashSet<String> blacklistedMethodNames = new HashSet<String>();
	
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
		
		for( CallExpression functionCall : functionCalls) {

			// make sure the call target is statically known
			if( functionCall.getTargetFunc() instanceof Identifier) {
				
				Identifier callIdentifier = (Identifier)functionCall.getTargetFunc();
				
				// if call identifier is fully qualified,
				// just look for the function's definition right away
				if( callIdentifier.getFlags().contains( PHPCSVNodeTypes.FLAG_NAME_FQ)) {
					String functionKey = callIdentifier.getNameChild().getEscapedCodeStr();
					addFunctionCallEdgeIfFunctionKnown(cg, functionCall, functionKey);
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
						found = addFunctionCallEdgeIfFunctionKnown(cg, functionCall, functionKey);
					}
					
					// we did not find the function or were already in global namespace;
					// try to find the function in the global namespace
					if( !found) {
						String functionKey = callIdentifier.getNameChild().getEscapedCodeStr();
						addFunctionCallEdgeIfFunctionKnown(cg, functionCall, functionKey);
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
					addStaticCallEdgeIfMethodKnown(cg, staticCall, staticMethodKey);
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
						addStaticCallEdgeIfMethodKnown(cg, staticCall, staticMethodKey);
					}
					
					// if we are in the global namespace, we should not accidentally prepend a backslash
					else {
						String staticMethodKey = classIdentifier.getNameChild().getEscapedCodeStr()
								+ "::" + methodName.getEscapedCodeStr();
						addStaticCallEdgeIfMethodKnown(cg, staticCall, staticMethodKey);
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
					addConstructorCallEdgeIfConstructorKnown(cg, constructorCall, constructorKey);
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
						addConstructorCallEdgeIfConstructorKnown(cg, constructorCall, constructorKey);
					}
					
					// if we are in the global namespace, we should not accidentally prepend a backslash
					else {
						String constructorKey = classIdentifier.getNameChild().getEscapedCodeStr();
						addConstructorCallEdgeIfConstructorKnown(cg, constructorCall, constructorKey);
					}
				}
			}
			else
				System.err.println("Statically unknown constructor call at node id " + constructorCall.getNodeId() + "!");
		}
	}
	
	private static void createNonStaticMethodCallEdges(CG cg) {
		
		for( MethodCallExpression methodCall : nonStaticMethodCalls) {
			
			// make sure the call target is statically known
			if( methodCall.getTargetFunc() instanceof StringExpression) {
				
				StringExpression methodName = (StringExpression)methodCall.getTargetFunc();
				String methodKey = methodName.getEscapedCodeStr();
				addNonStaticCallEdgeIfMethodKnown(cg, methodCall, methodKey);
			}
			else
				System.err.println("Statically unknown non-static method call at node id " + methodCall.getNodeId() + "!");
		}
	}
	
	/**
	 * Checks whether a given function key is known and if yes,
	 * adds a corresponding edge in the given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addFunctionCallEdgeIfFunctionKnown(CG cg, CallExpression functionCall, String functionKey) {
		
		boolean ret = false;
		
		// check whether we know the called function
		if( functionDefs.containsKey(functionKey)) {
			
			CGNode caller = new CGNode(functionCall);
			CGNode callee = new CGNode(functionDefs.get(functionKey));
			ret = cg.addVertex(caller);
			// note that adding a callee node many times is perfectly fine:
			// CGNode overrides the equals() and hashCode() methods,
			// so it will actually only be added the first time
			cg.addVertex(callee);
			cg.addEdge(new CGEdge(caller, callee));
		}
		
		return ret;
	}
	
	/**
	 * Checks whether a given static method key is known and if yes,
	 * adds a corresponding edge in the given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addStaticCallEdgeIfMethodKnown(CG cg, StaticCallExpression staticCall, String staticMethodKey) {
		
		boolean ret = false;
		
		// check whether we know the called function
		if( staticMethodDefs.containsKey(staticMethodKey)) {
			
			CGNode caller = new CGNode(staticCall);
			CGNode callee = new CGNode(staticMethodDefs.get(staticMethodKey));
			ret = cg.addVertex(caller);
			// note that adding a callee node many times is perfectly fine:
			// CGNode overrides the equals() and hashCode() methods,
			// so it will actually only be added the first time
			cg.addVertex(callee);
			cg.addEdge(new CGEdge(caller, callee));
		}
		
		return ret;
	}
	
	/**
	 * Checks whether a given constructor key is known and if yes,
	 * adds a corresponding edge in the given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addConstructorCallEdgeIfConstructorKnown(CG cg, NewExpression constructorCall, String constructorKey) {
		
		boolean ret = false;
		
		// check whether we know the called function
		if( constructorDefs.containsKey(constructorKey)) {
			
			CGNode caller = new CGNode(constructorCall);
			CGNode callee = new CGNode(constructorDefs.get(constructorKey));
			ret = cg.addVertex(caller);
			// note that adding a callee node many times is perfectly fine:
			// CGNode overrides the equals() and hashCode() methods,
			// so it will actually only be added the first time
			cg.addVertex(callee);
			cg.addEdge(new CGEdge(caller, callee));
		}
		
		return ret;
	}
	
	/**
	 * Checks whether a given non-static method key is known and if yes,
	 * adds a corresponding edge in the given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addNonStaticCallEdgeIfMethodKnown(CG cg, MethodCallExpression methodCall, String methodKey) {
		
		boolean ret = false;
		
		// check whether we know the called function
		if( nonStaticMethodDefs.containsKey(methodKey)) {
			
			CGNode caller = new CGNode(methodCall);
			CGNode callee = new CGNode(nonStaticMethodDefs.get(methodKey));
			ret = cg.addVertex(caller);
			// note that adding a callee node many times is perfectly fine:
			// CGNode overrides the equals() and hashCode() methods,
			// so it will actually only be added the first time
			cg.addVertex(callee);
			cg.addEdge(new CGEdge(caller, callee));
		}
		
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
		blacklistedMethodNames.clear();
	}
	
	/**
	 * Adds a new known function definition.
	 * 
	 * @param functionDef A PHP function definition. If a function definition with the same
	 *                    name was previously added, then the new function definition will
	 *                    be used for that name and the old function definition will be returned.
	 * @return If there already exists a PHP function definition with the same name,
	 *         then returns that function definition. Otherwise, returns null.
	 */
	public static PHPFunctionDef addFunctionDef( PHPFunctionDef functionDef) {

		// artificial toplevel functions wrapping toplevel code cannot be called
		if( functionDef instanceof TopLevelFunctionDef)
			return null;
		
		// we also ignore closures as they do not have a statically known reference
		else if( functionDef instanceof Closure)
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
						" constructor definitions (id " + staticMethodDefs.get(constructorKey).getNodeId() +
						" and id " + functionDef.getNodeId() + ")");
			}
			
			return constructorDefs.put( constructorKey, (Method)functionDef);
		}
		
		// other methods than the above are non-static methods
		else if( functionDef instanceof Method) {
			// use foo as key for a static method foo in any class in any namespace;
			// note that we only deal with unique method names, and that the enclosing namespace
			// of a non-static method call is irrelevant here
			String methodKey = ((Method)functionDef).getName();
			
			if( nonStaticMethodDefs.containsKey(methodKey) || blacklistedMethodNames.contains(methodKey)) {
				// we do not output an error message here; non-unique non-static method names
				// should not be that uncommon. in this case we do not know which one is referenced,
				// and we blacklist it
				blacklistedMethodNames.add(methodKey);
				return nonStaticMethodDefs.remove(methodKey);
			}
			
			return nonStaticMethodDefs.put( methodKey, (Method)functionDef);
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
	public static boolean addFunctionCall( CallExpression callExpression) {
		
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
