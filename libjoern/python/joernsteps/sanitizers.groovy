
// Returns true if the AST of the basic block contains a sub-tree that
// is either an EqualityExpression or RelationalExpression and one of
// its first children is the symbol.

Object.metaClass.checksSymbol = { it, s ->
  def symbol = s;
  it.basicBlockToAST()
  .subASTsOfType(['EqualityExpression', 'RelationalExpression'])
  .out('IS_AST_PARENT').filter{ it.code.equals(symbol) }
}