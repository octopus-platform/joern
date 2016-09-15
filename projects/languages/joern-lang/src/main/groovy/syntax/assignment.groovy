
/**
   (Optimized) Match-traversals for assignments
*/

GraphTraversal.metaClass.lval = {
	delegate.out(AST_EDGE).has(NODE_CHILDNUM, '0')
}

GraphTraversal.metaClass.rval = {
	delegate.out(AST_EDGE).has(NODE_CHILDNUM, '1')
}
