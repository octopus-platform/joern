/**
   (Optimized) Match-traversals for Calls.
*/

GraphTraversal.metaClass.callToArguments = {
	 delegate.children()
	 .has(NODE_TYPE, TYPE_ARGLIST)
	 .children()
}

GraphTraversal.metaClass.ithArguments = { def args -> 
	 delegate.callToArguments()
	 .has(NODE_CHILDNUM, args[0])
}

GraphTraversal.metaClass.argToCall = {
	delegate.in(AST_EDGE).in(AST_EDGE)
}

GraphTraversal.metaClass.calleeToCall = {
	delegate.in(AST_EDGE)
}

GraphTraversal.metaClass.callToCallee = {
	delegate.out(AST_EDGE)
	.has(NODE_TYPE, TYPE_CALLEE)
}

// FIXME

callToAssigns = {
	_().matchParents{it.type == 'AssignmentExpr'}
}
