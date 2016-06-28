
/**
   (Optimized) Match-traversals for assignments
*/

lval = {
	_().out(AST_EDGE).filter{ it.childNum == "0" }
}

rval = {
	_().out(AST_EDGE).filter{ it.childNum == "1" }
}
