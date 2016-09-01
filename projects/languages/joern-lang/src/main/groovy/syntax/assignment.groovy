
/**
   (Optimized) Match-traversals for assignments
*/

GraphTraversal.metaClass.lval = {
	delegate.out(AST_EDGE).has(TYPE_CHILDNUM, '0')
}

GraphTraversal.metaClass.rval = {
	delegate.out(AST_EDGE).has(TYPE_CHILDNUM, '1')
}
