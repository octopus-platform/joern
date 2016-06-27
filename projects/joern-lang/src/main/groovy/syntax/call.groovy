/**
   (Optimized) Match-traversals for Calls.
*/

callToArguments = {
	 _().children().filter{it.nodeType == TYPE_ARGLIST}
	 .children()
}

ithArguments = { def args -> 
	 _().callToArguments()
	.filter{ it.childNum == args[0] }
}

argToCall = {
	_().in(AST_EDGE).in(AST_EDGE)
}

calleeToCall = {
	_().in(AST_EDGE)
}

callToCallee = {
	_().out(AST_EDGE).filter{it.type == 'Callee'}
}

callToAssigns = {
	_().matchParents{it.type == 'AssignmentExpr'}
}
