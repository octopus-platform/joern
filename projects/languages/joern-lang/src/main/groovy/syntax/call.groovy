/**
   (Optimized) Match-traversals for Calls.
*/

callToArguments = {
	 delegate.children()
	 .has(NODE_TYPE, TYPE_ARGLIST)
	 .children()
}

ithArguments = { def args -> 
	 delegate.callToArguments()
	 .has(NODE_CHILDNUM, args[0])
}

argToCall = {
	delegate.in(AST_EDGE).in(AST_EDGE)
}

calleeToCall = {
	delegate.in(AST_EDGE)
}

callToCallee = {
	delegate.out(AST_EDGE)
	.has(NODE_TYPE, TYPE_CALLEE)
}

// FIXME

callToAssigns = {
	_().matchParents{it.type == 'AssignmentExpr'}
}
