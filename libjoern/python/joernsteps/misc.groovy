
Gremlin.defineStep('basicBlockToAST', [Vertex,Pipe], { _().out('IS_BASIC_BLOCK_OF') } );

Gremlin.defineStep('idToNode', [Vertex,Pipe], { _().transform{ g.v(it) }.scatter() })
Gremlin.defineStep('queryToNodes', [Vertex,Pipe], { _().transform{ queryNodeIndex(it) }.scatter() })

Gremlin.defineStep('symbolToDecl', [Vertex, Pipe],{
  _().in('DEF').filter{ it.type in ['IdentifierDecl', 'Parameter']}
})

Gremlin.defineStep('nameToTypeDecl', [Vertex,Pipe], {
  _().transform{ getTypeDeclsByName(it) }.scatter()
})

Gremlin.defineStep('storeFunctionAndFilename', [Vertex, Pipe], { filterExpr ->
  x = _().as('originalNode').astNodeToFunction()
  if(filterExpr != null){
    x = x.filter{ it.functionName.matches(filterExpr) }
  }  
  x.sideEffect{ funcName = it.functionName}
  .functionToFile().sideEffect{ fileName = it.filepath}						     
  .back('originalNode')
})

Gremlin.defineStep('functionAndFilename', [Vertex, Pipe], { _().transform{ [funcName, fileName] }})