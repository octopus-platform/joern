
Object.metaClass.setSinkArgument =  { callRegex, argNum, argRegex = null ->
  x = _().getCallsToRegex(callRegex).callToArgumentN(argNum)
  if(argRegex != null) x = x.filter{ it.code.matches(argRegex) }
  return x
}

Object.metaClass.setSinkAssignment = { assignRegex ->
  getAssignmentsByRegex(assignRegex).sideEffect{ sink = it}
  .astNodeToBasicBlock().sideEffect{ sinkBlock = it}.back(2)
}

Gremlin.defineStep('reaches', [Vertex, Pipe], {
  _().out('REACHES').loop(1){ it.loops < 20}{true}
})

Gremlin.defineStep('reachesUnaltered', [Vertex, Pipe], {
  _().sideEffect{ val = it[1];}.transform{ it[0] }.outE('REACHES')
  .filter{if(!val) return true; else return it.var.equals(val)}.inV()
})

// TODO: eliminate copy/paste code. Optimize.

// For a given AST node (e.g., argument), get all sources connected to it by
// data flow, which match one of the supplied regular expressions.
// Returns list of (sourceId, sinkId) tuples.

Gremlin.defineStep('dataFlowFromRegex', [Vertex, Pipe], { Object [] s ->
  def sources = []
  
  for (aPattern in s){
    sources.add(Pattern.compile(aPattern))
  }
  
  _().astNodeToBasicBlock().sideEffect{ sinkId = it.id; }.back(2)
  .out('USE').sideEffect{ symbol = it.code }.back(2)
  .astNodeToBasicBlock().sideEffect{ firstRound = true }
  .as('loopStart').inE('REACHES').filter{ !firstRound || it.var == symbol }.outV().sideEffect{firstRound = false}
  .loop('loopStart'){it.loops < 10 && ! aRegexFound(it.object, sources)} { aRegexFound(it.object, sources) }
  .transform{ [it.id, sinkId] } 
  .dedup()
})


Gremlin.defineStep('dataFlowFrom', [Vertex, Pipe], { f ->
  def fil = f;
  
  _().astNodeToBasicBlock().sideEffect{ sinkId = it.id; }.back(2)
  .out('USE').sideEffect{ symbol = it.code }.back(2)
  .astNodeToBasicBlock().sideEffect{ firstRound = true }
  .as('loopStart').inE('REACHES').filter{ !firstRound || it.var == symbol }.outV().sideEffect{firstRound = false}
  .loop('loopStart'){it.loops < 10 && !exists(fil(it.object))}
  .transform{ [it.id, sinkId] }
  .dedup()
})

// Input is an AST-node such as a parameter:
// Expects:
// [astNode, symbol]

Gremlin.defineStep('dataFlowToRegex', [Vertex, Pipe], { Object [] s ->
  def sinks = s;
  
  _().sideEffect{ (astNode, sourceSymbol) = it }.transform{ astNode }
  .astNodeToBasicBlock().sideEffect{ sourceId = it.id; firstRound = true }
  .as('loopStart').ifThenElse{!firstRound}{it.inV()}{it}
  .outE('REACHES').filter{ !firstRound || it.var.equals(sourceSymbol) }
  .sideEffect{firstRound = false}
  .loop('loopStart'){it.loops < 10 }{ aRegexFound(it.object.inV().toList()[0], sinks) }
  .transform{ [sourceId, it.inV().toList()[0].id, it.var] } 
  .dedup()
})

// Expects:
// [astNode, sourceSymbol]

Gremlin.defineStep('dataFlowTo', [Vertex, Pipe], { f ->
  def fil = f;
  
  _().sideEffect{ (astNode, sourceSymbol) = it }.transform{ astNode }
  .astNodeToBasicBlock().sideEffect{ sourceId = it.id; firstRound = true }
  .as('loopStart').ifThenElse{!firstRound}{it.inV()}{it}
  .outE('REACHES').filter{ !firstRound || it.var.equals(sourceSymbol) }
  .sideEffect{firstRound = false}
  .loop('loopStart'){it.loops < 10 }{ exists(fil(it.object)) }
  .transform{ [sourceId, it.inV().toList()[0].id, it.var] } 
  .dedup()
})

// Expects:
// [astNode, sourceSymbol]


Gremlin.defineStep('directDataFlowTo', [Vertex, Pipe], { it ->
  _().sideEffect{ sourceSymbol = it[1] }.transform{ it[0] }
  .astNodeToBasicBlock().outE('REACHES').filter{ it.var.equals(sourceSymbol) }.inV()
})

Gremlin.defineStep('isNotSanitizedByRegex', [Vertex, Pipe], { Object [] san ->
  def sanitizers = san;
  
  _().sideEffect{ sourceId = it[0]; sinkId = it[1] }
  .transform{ g.v(sourceId)}
  .as('x').out('FLOWS_TO').simplePath()
  .loop('x'){ it.loops < 40 && it.object.id != sinkId && ! aRegexFound(it.object, sanitizers)}
  .filter{ it.id == sinkId }
  .dedup().transform{ [sourceId, sinkId] }
})

Gremlin.defineStep('isNotSanitizedBy', [Vertex, Pipe], { f ->
  def fil = f;

  _().sideEffect{ sourceId = it[0]; sinkId = it[1] }
  .transform{ g.v(sourceId)}
  .as('x').out('FLOWS_TO').simplePath()
  .loop('x'){ it.loops < 40 && it.object.id != sinkId && !exists(fil(it.object))}
  .filter{ it.id == sinkId }
  .dedup().transform{ [sourceId, sinkId] }

})

// interprocedural data flow

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


Gremlin.defineStep('ipIsNotSanitizedBy', [Vertex, Pipe], { san ->
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

Object.metaClass.aRegexFound = { it, sanitizers ->
  for(s in sanitizers){
      if(it.code.find(s))
	return true;
    }
  return false;
}

Object.metaClass.allRegexFound = { it, regex ->
  for(r in regexs){
    if(!it.code.find(r))
      return false;
  }
  return true;
}

Gremlin.defineStep('cfgPathsToExit', [Vertex,Pipe], {
 _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()
})

Gremlin.defineStep('cfgPathsFromEntry', [Vertex,Pipe], {
 _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()
}) 
