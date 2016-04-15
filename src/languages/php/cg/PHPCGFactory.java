package languages.php.cg;

import java.util.HashMap;
import java.util.LinkedList;

import ast.expressions.CallExpression;
import ast.expressions.Identifier;
import ast.php.functionDef.PHPFunctionDef;
import cg.CG;
import cg.CGEdge;
import cg.CGNode;

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
				String name = ((Identifier)functionCall.getTargetFunc()).getNameChild().getEscapedCodeStr();
				// check whether we know the called function
				if( functionDefs.containsKey(name)) {
					CGNode caller = new CGNode(functionCall);
					CGNode callee = new CGNode(functionDefs.get(name));
					// note that adding a callee node many times is perfectly fine:
					// CGNode overrides the equals() and hashCode() methods,
					// so it will actually only be added the first time
					cg.addVertex(caller);
					cg.addVertex(callee);
					cg.addEdge(new CGEdge(caller, callee));
				}
			}
			else
				System.err.println("Statically unknown function call at node id " + functionCall.getNodeId() + "!");
		}

		reset();
		
		return cg;
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
		
		String name = functionDef.getName();
		
		if( functionDefs.containsKey(name)) {
			System.err.println("Function name '" + name + "' ambiguous: There are at least two known " +
					" matching function definitions (id " + functionDefs.get(name).getNodeId() +
					" and id " + functionDef.getNodeId() + ")");
		}
		
		return functionDefs.put( name, functionDef);
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
