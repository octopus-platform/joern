
Gremlin.defineStep("localToType", [Vertex,Pipe], {
 _().out('IS_AST_PARENT').filter{it.type == 'IdentifierDeclType'}
})

Gremlin.defineStep("localToName", [Vertex,Pipe], {
 _().out('IS_AST_PARENT').filter{it.type == 'Identifier'}
})

Gremlin.defineStep('localDeclToName', [Vertex, Pipe], {
 _().out().filter{it.type == 'Identifier'}
})

Gremlin.defineStep('localDeclToType', [Vertex, Pipe],{
  _().ifThenElse{ it.type == 'IdentifierDecl'}
  { it.out().filter{ it.type == 'IdentifierDeclType'} }
  // else: Parameter
  { it.out().filter{ it.type == 'ParameterType'} }
})

Gremlin.defineStep('localToInitAssignment', [Vertex, Pipe], { 
 _().out('IS_AST_PARENT').filter{ it.type == 'AssignmentExpr'}
})
