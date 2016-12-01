/**
   Elementrary traversals starting at AST nodes.
*/

/** 
    Traverse from root of AST to all nodes it contains
    (including the node itself) This is refered to as 'TNODES' in the
    paper simply because otherwise its definition would not fit in a
    column ;)
*/

addStep("astNodes", {
	delegate
	.identity()
	.emit()
	.repeat( out(AST_EDGE) )
	.unfold()
})

/**
   Traverse to parent-nodes of AST nodes.
*/

addStep("parents", {
	delegate.in(AST_EDGE)
})

/**
   Traverse to child-nodes of AST nodes.
*/

addStep("children", {
	delegate.out(AST_EDGE)
})

noMoreChildren = {
	__.start().outE(AST_EDGE).count().is(0)
}

/**
   Traverse to i'th children.
   
   @param i The child index
*/

addStep("ithChildren", { args ->
	i = args[0];
	delegate.children().has(NODE_CHILDNUM, i)
})

isStatement = { it ->
  it.isCFGNode == 'True'
}


/**
 * Traverse to siblings.
 */
addStep("siblings", {
	delegate
	.as('node')
	.parents()
	.children()
	.where(P.neq('node'))
})

/**
   Traverse to statements enclosing supplied AST nodes. This may be
   the node itself.
*/

addStep("statements", {
	delegate
	.identity()
	.until(has(NODE_ISCFGNODE, 'True'))
    .repeat(__.start().parents())
	.identity()
})

/**
   Get number of children of an AST node.
*/

numChildren = {
	_().transform{ numChildren(it)  }
}

numChildren = { it ->
	it.out('IS_AST_PARENT').toList().size()
}
