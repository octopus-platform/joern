/**
   (Optimized) Match-traversals for Calls.
*/

addStep("callToArguments", {
	 delegate.children()
	 .has(NODE_TYPE, TYPE_ARGLIST)
	 .children()
})

addStep("ithArguments", { def args ->
	 delegate.callToArguments()
	 .has(NODE_CHILDNUM, args[0])
})

addStep("argToCall", {
	delegate.in(AST_EDGE).in(AST_EDGE)
})

addStep("calleeToCall", {
	delegate.in(AST_EDGE)
})

addStep("callToCallee", {
	delegate.out(AST_EDGE)
	.has(NODE_TYPE, TYPE_CALLEE)
})

addStep("callToAssigns", {
	delegate.repeat( __.in(AST_EDGE) )
	.emit( has('type','AssignmentExpression') )
	.unfold()
})
