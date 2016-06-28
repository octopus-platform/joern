
/**
   (Optimized) match-traversals for functions.
*/

functionToAST = {
	_().out(FUNCTION_TO_AST_EDGE)
}

functionToASTNodes = {
	_().functionToAST().astNodes()
}

functionToStatements = {
	_().transform{ queryNodeIndex('isCFGNode:True AND functionId:' + it.id) }
	 .scatter()
}

functionsToASTNodesOfType = { def args; def type = args[0];
	_().transform{ queryNodeIndex('functionId:' + it.id + " AND $NODE_TYPE:$type") }
	 .scatter()
}

functionToFile = {
	_().in(FILE_TO_FUNCTION_EDGE)
}

/**
 * For a function node, get callers using `name` property.
 **/

functionToCallers = {
	_().transform{

		funcName = it.name
		funcName = funcName.split(' ')[-1].trim()
	   	funcName = funcName.replace('*', '')

		getCallsTo(funcName)
	}.scatter()
}
