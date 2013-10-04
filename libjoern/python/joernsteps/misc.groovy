
Gremlin.defineStep('basicBlockToAST', [Vertex,Pipe], { _().out('IS_BASIC_BLOCK_OF') } );

Gremlin.defineStep('idToNode', [Vertex,Pipe], { _().transform{ g.v(it) }.scatter() })
Gremlin.defineStep('queryToNodes', [Vertex,Pipe], { _().transform{ queryNodeIndex(it) }.scatter() })

// Gremlin.defineStep('symbolToDecl', [Vertex, Pipe],{
//  _().in('DEF').filter{ it.type in ['IdentifierDecl', 'Parameter']}
// })

Gremlin.defineStep('symbolToDecl', [Vertex, Pipe],{
  _().in('DEF').filter{ it.type in ['IdentifierDecl']}
})

Gremlin.defineStep('nameToTypeDecl', [Vertex,Pipe], {
  _().transform{ getTypeDeclsByName(it) }.scatter()
})

Gremlin.defineStep('functionAndFilename', [Vertex, Pipe], { filterExpr ->
  x = _().astNodeToFunction()
  if(filterExpr != null){
    x = x.filter{ it.functionName.matches(filterExpr) }
  }  
  x.sideEffect{ funcName = it.functionName}
  .functionToFile().sideEffect{ fileName = it.filepath}.transform{ [funcName, fileName] }   
  
})


Object.metaClass.sinkCode = { it.astNodeToBasicBlock().code.next() }
Object.metaClass.sinkArgCode = { it.code }
Object.metaClass.parameterName = { it.parameterToName().code.next() }