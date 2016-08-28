
functionToLocationStr = {
  delegate.as('func')
  .functionToFile().as('file')
  .select('func', 'file')
  .map { it['file'].code + ':' +  it['func'].location }  
}

/**
   (Optimized) match-traversals for functions.
*/

functionToAST = {
	delegate.out(FUNCTION_TO_AST_EDGE)
}

functionToASTNodes = {
	delegate.functionToAST().astNodes()
}

functionToStatements = {
	delegate.transform{ queryNodeIndex('isCFGNode:True AND functionId:' + it.id) }
	 .scatter()
}

functionsToASTNodesOfType = { def args; def type = args[0];
	delegate.transform{ queryNodeIndex('functionId:' + it.id + " AND $NODE_TYPE:$type") }
	 .scatter()
}

functionToFile = {
	delegate.in(FILE_TO_FUNCTION_EDGE)
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
