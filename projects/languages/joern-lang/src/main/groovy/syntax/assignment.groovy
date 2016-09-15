
/**
   (Optimized) Match-traversals for assignments
*/

addStep("lval", {
	delegate.out(AST_EDGE).has(NODE_CHILDNUM, '0')
})

addStep("rval", {
	delegate.out(AST_EDGE).has(NODE_CHILDNUM, '1')
})
