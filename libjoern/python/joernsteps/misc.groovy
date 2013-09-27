
Gremlin.defineStep('basicBlockToAST', [Vertex,Pipe], { _().out('IS_BASIC_BLOCK_OF') } );

Gremlin.defineStep('idToNode', [Vertex,Pipe], { _().transform{ g.v(it) }.scatter() })
Gremlin.defineStep('queryToNodes', [Vertex,Pipe], { _().transform{ queryNodeIndex(it) }.scatter() })

Gremlin.defineStep('cfgPathsToExit', [Vertex,Pipe], {
 _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()
})

Gremlin.defineStep('cfgPathsFromEntry', [Vertex,Pipe], {
 _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()
}) 


// Data flow analysis

Gremlin.defineStep('reachesUnaltered', [Vertex, Pipe], {
  _().sideEffect{ val = it[1];}.transform{ it[0] }.outE('REACHES').filter{if(!val) return true; else return it.var.equals(val)}.inV()

})

Gremlin.defineStep('reaches', [Vertex, Pipe], {
  _().out('REACHES').loop(1){ it.loops < 20}{true}
})

// For a given function argument, get all sources connected to it by
// data flow, which match one of the supplied regular expressions.
// Returns list of (sourceId, sinkId) tuples.

Gremlin.defineStep('dataFlowFrom', [Vertex, Pipe], { Object [] s ->
  def sources = s;
  
  _().astNodeToBasicBlock().sideEffect{ sinkId = it.id; }.back(2)
  .out('USE').sideEffect{ symbol = it.code }.back(2)
  .astNodeToBasicBlock().sideEffect{ firstRound = true }
  .as('loopStart').inE('REACHES').filter{ !firstRound || it.var == symbol }.outV().sideEffect{firstRound = false}
  .loop('loopStart'){it.loops < 10 && ! aRegexFound(it.object, sources)}{true}
  .filter{ aRegexFound(it, sources)}
  .transform{ [it.id, sinkId] } 
  .dedup()
})

Gremlin.defineStep('ipDataFlowFrom', [Vertex, Pipe], { sx-> 
  def ipSource = sx;

  _().astNodeToBasicBlock().sideEffect{ sinkId = it.id; }.back(2)
  .out('USE').sideEffect{ ipSymbol = it.code }.back(2)
  .astNodeToBasicBlock().sideEffect{ firstRound = true; ipDstNode = it.id; ipNodeStack = []}
  
  .as('loopStart')
  .basicBlockToAST()
  
  .ifThenElse{ it.type == 'Parameter' }
  {
    it.out('IS_AST_PARENT')
    .filter{ it.type == 'Identifier'}.in('IS_ARG').astNodeToBasicBlock()
    .sideEffect{ ipNodeStack.add([ipCurNode, ipDstNode]); ipDstNode = it.id }
  }
  // else
  { 
    it.astNodeToBasicBlock().inE('REACHES').filter{ !firstRound || it.var == ipSymbol }.outV()
  }
  .sideEffect{firstRound = false; ipCurNode = it.id; }
  .loop('loopStart'){it.loops < 10 && !it.object.code.contains(ipSource)}{true}
  .filter{ it.code.contains(ipSource) }
  .sideEffect{ if(ipNodeStack.size() == 0){ ipNodeStack.add([it.id,ipDstNode]) }}
  .transform{ [it.id, sinkId] }
  .dedup()
  .transform{ [it[0], it[1], ipNodeStack] }
})

Object.metaClass.aRegexFound = { it, sanitizers ->
  for(s in sanitizers){
      if(it.code.find(s))
	return true;
    }
  return false;
}

Gremlin.defineStep('isNotSanitizedBy', [Vertex, Pipe], { Object [] san ->
  def sanitizers = san;
  
  _().sideEffect{ sourceId = it[0]; sinkId = it[1] }
  .transform{ g.v(sourceId)}
  .as('x').out('FLOWS_TO').simplePath()
  .loop('x'){ it.loops < 40 && it.object.id != sinkId && ! aRegexFound(it.object, sanitizers)}
  .filter{ it.id == sinkId }
  .dedup()
 })


Gremlin.defineStep('ipControlFlow', [Vertex, Pipe], { san ->
  def sanitizer = san;
  
  _().sideEffect{ nodeStack = it[2]; }
  .filter{
    for(x in nodeStack){ 
      def srcId = x[0];
      def dstId = x[1];      
      l = g.v(0).transform{ [srcId, dstId] }.isNotSanitizedBy(sanitizer).toList()
      if(l.size() == 0)
  	return false;
    }
    return true;
  }
})


Gremlin.defineStep('symbolToDecl', [Vertex, Pipe],{
  _().in('DEF').filter{ it.type in ['IdentifierDecl', 'Parameter']}
})

// This one is horrible as we use a regex to parse the
// struct part from the type and chop off the postfix

Gremlin.defineStep("structureToName", [Vertex,Pipe], {
  _().transform{ (it.code =~/struct ([^\s]+)/)[0][1] }
})

Gremlin.defineStep("structureToMemberDecls", [Vertex,Pipe], {
  _().out('IS_CLASS_OF').filter{it.type == 'DeclStmt'}.out()
})

Gremlin.defineStep('nameToTypeDecl', [Vertex,Pipe], {
  _().transform{ getTypeDeclsByName(it) }.scatter()
})

Object.metaClass.numTypesInStructure = {
  it.structureToMemberDecls().baseType.dedup().toList().size()
}

Object.metaClass.isStruct = {
  it.code.startsWith('struct ')
}

Object.metaClass.exists = { it ->  it.toList().size != 0 }

Object.metaClass.containsSymbol = { it, symbol ->
  it.code.matches(symbol + '(?!([a-zA-Z0-9_]))')  
}
