
// Returns true if the AST of the basic block contains a sub-tree that
// is either an EqualityExpression or RelationalExpression and one of
// its first children is the symbol.

Object.metaClass.checksSymbol = { it, s ->
  def symbol = s;
  it.basicBlockToAST()
  .subASTsOfType(['EqualityExpression', 'RelationalExpression'])
  .out('IS_AST_PARENT').filter{ containsSymbol(it, symbol) }
}

Object.metaClass.noConditionMatches = { it, filterExpr ->
  it.functionToConditions().filter(filterExpr).toList() == []
}


Object.metaClass.isDirectCast = { it, identifier ->
  it.type == 'CastExpression' &&
  exists(it.out('IS_AST_PARENT').filter{it.type == 'Identifier'}
	 .filter{it.code == identifier}) 
}