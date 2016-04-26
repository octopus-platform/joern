package languages.php.cg;

import java.util.HashMap;
import java.util.LinkedList;

import ast.expressions.CallExpression;
import ast.expressions.Identifier;
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

		for( CallExpression functionCall : functionCalls) {

			// make sure the call target is statically known
			if( functionCall.getTargetFunc() instanceof Identifier) {
				
				Identifier callIdentifier = (Identifier)functionCall.getTargetFunc();
				
				// if call identifier is fully qualified,
				// just look for the function's definition right away
				if( callIdentifier.getFlags().contains( PHPCSVNodeTypes.FLAG_NAME_FQ)) {
					String functionKey = callIdentifier.getNameChild().getEscapedCodeStr();
					addCallEdgeIfFunctionKnown(cg, functionCall, functionKey);
				}

				// otherwise, i.e., if the call identifier is not fully qualified,
				// first look in the current namespace, then if the function is not found,
				// look in the global namespace
				// (see http://php.net/manual/en/language.namespaces.rules.php)
				else {
					boolean found = false;
					// note that looking in the current namespace first only makes
					// sense if we are not already in the global namespace anyway
					if( !callIdentifier.getNamespace().isEmpty()) {
						String functionKey = callIdentifier.getNamespace() + "\\"
								+ callIdentifier.getNameChild().getEscapedCodeStr();
						found = addCallEdgeIfFunctionKnown(cg, functionCall, functionKey);
					}
					
					// we did not find the function or were already in global namespace;
					// try to find the function in the global namespace
					if( !found) {
						String functionKey = callIdentifier.getNameChild().getEscapedCodeStr();
						addCallEdgeIfFunctionKnown(cg, functionCall, functionKey);
					}
				}
	

			}
			else
				System.err.println("Statically unknown function call at node id " + functionCall.getNodeId() + "!");
		}

		reset();
		
		return cg;
	}

	/**
	 * Checks whether a given function key is known and if yes,
	 * adds a corresponding edge in the given call graph.
	 * 
	 * @return true if an edge was added, false otherwise
	 */
	private static boolean addCallEdgeIfFunctionKnown(CG cg, CallExpression functionCall, String functionKey) {
		
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
	
	private static void reset() {
	
		functionDefs.clear();
		functionCalls.clear();
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
		
		String functionKey = functionDef.getName();
		if( !functionDef.getNamespace().isEmpty())
			functionKey = functionDef.getNamespace() + "\\" + functionKey;
		
		if( functionDefs.containsKey(functionKey)) {
			System.err.println("Function definition '" + functionKey + "' ambiguous: There are at least two known " +
					" matching function definitions (id " + functionDefs.get(functionKey).getNodeId() +
					" and id " + functionDef.getNodeId() + ")");
		}
		
		return functionDefs.put( functionKey, functionDef);
	}
	
	/**
	 * Adds a new function call.
	 * 
	 * @param functionCall A PHP function call. An arbitrary number of distinguished calls
	 *                     to the same function can be added. This class maintains a list of
	 *                     PHP function call nodes for each called function name.
	 */
	public static boolean addFunctionCall( CallExpression callExpression) {
		
		// Note: we cannot access any of the CallExpression's getter methods here
		// because this method is called from the PHPCSVNodeInterpreter at the point
		// where it constructs the CallExpression. That is, this method is called for each
		// CallExpression *immediately* after its construction. At that point, the PHPCSVNodeInterpreter
		// has not called the CallExpression's setter methods  (as it has not yet interpreted the
		// corresponding CSV lines).
		// Hence, we only store the references to the CallExpression objects themselves.
	
		return functionCalls.add( callExpression);
	}
	


}
