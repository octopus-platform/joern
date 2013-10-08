
Gremlin.defineStep('parameterToName', [Vertex, Pipe], {
 _().out('IS_AST_PARENT').filter{ it.type == 'Identifier' }
})

Gremlin.defineStep('parameterToInitializedLocals', [Vertex, Pipe],{
    _().sideEffect{ parameterName = it.code; }.astNodeToFunction().functionToASTNodes()
  .filter{ it.type == 'AssignmentExpr'}.as('assign')
  .assignmentToRval().filter{ it.code == parameterName || isDirectCast(it, parameterName) }
  .back('assign').in('IS_AST_PARENT').filter{it.type == 'IdentifierDecl'}
})
