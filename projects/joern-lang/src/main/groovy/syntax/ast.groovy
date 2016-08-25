/**
   Elementrary traversals starting at AST nodes.
*/

/** 
    Traverse from root of AST to all nodes it contains
    (including the node itself) This is refered to as 'TNODES' in the
    paper simply because otherwise its definition would not fit in a
    column ;)
*/


astNodes = {

_().transform{
	 def x = [] as Set;
	it._().children().loop(1){true}{true}
	.store(x).optional(2).transform{x+it}.scatter()
	}.scatter()
}

/**
   Traverse to parent-nodes of AST nodes.
*/

parents = {
	_().in(AST_EDGE)
}

/**
   Traverse to child-nodes of AST nodes.
*/

children = {
	_().out(AST_EDGE)
}

/**
   Traverse to i'th children.
   
   @param i The child index
*/

ithChildren = { i ->
	_().children().filter{ it.childNum == i}
}

isStatement = { it ->
  it.isCFGNode == 'True'
}


/**
 * Traverse to siblings.
 */
siblings = {
	_().sideEffect{ nodeId = it.id }
	.parents()
	.children()
	.filter{ it.id != nodeId }
}

/**
   Traverse to statements enclosing supplied AST nodes. This may be
   the node itself.
*/

statements = {
	   _().ifThenElse{isStatement(it)}
      	   { it }
      	   { it.in(AST_EDGE).loop(1){it.object.isCFGNode != 'True'} }
}

/**
   Get number of children of an AST node.
*/

numChildren = {
	_().transform{ numChildren(it)  }
}

numChildren = { it ->
	it.out('IS_AST_PARENT').toList().size()
}
