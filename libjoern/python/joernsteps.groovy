import java.util.regex.*;
import com.tinkerpop.blueprints.pgm.impls.neo4j.util.*;

////////////////////////////////////////////////////////////////////
// = User-defined Gremlin steps for code analysis. = The "language"
// joern offers on top of Gremlin to allow you to formulate complex
// queries without too much pain.  If you have a good idea for a
// custom step, for example from reoccuring patterns in your queries,
// make a proposal and I'm likely to include it.
///////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////
// The following are utility functions for Gremlin/Groovy scripts,
// which you can use to select start-nodes for your analysis. For
// example, you might want to start with all function definitions, all
// calls to a specific function or all instances of variables of a
// certain type.
//////////////////////////////////////////////////////////////////////

/**
   Allows more than one pipe to generate starting points. Acts as an
   AND.
*/

Object.metaClass.AND = { pipes ->
  np = []
  for(int i = 0; i < pipes.size(); i++){
    p = pipes[i]
    np.add( _().transform{ p }.scatter())
  }
  _().copySplit( *np ).exhaustMerge()
}

/**
   Query the node index.
   @param query Lucene query
*/

Object.metaClass.queryNodeIndex = { query ->
  index = g.getRawGraph().index().forNodes("nodeIndex")
  new Neo4jVertexSequence(index.query(query), g)._()
}

/**
   Retrieve all nodes of a specified type from the node index.
   @param typeName type
*/

Object.metaClass.getNodesByType = { typeName ->
  g.idx("nodeIndex")[[type:typeName]]
}

////////////////////////////////
///// Functions ///////
///////////////////////////////

/**
   Retrieve function by name.
   @param aName name
*/

Object.metaClass.getFunctionByName = { aName ->
  g.idx('nodeIndex')[[functionName:aName]]
}

/**
   Retrieve function by name matching regular
   expression.
   @param aNameRegex regular expression function names must match.
*/

Object.metaClass.getFunctionByNameRegex = { aNameRegex ->
  getNodesByType("Function").filter{ it.functionName.matches(aNameRegex) }
}

//////////////////////////////////
////// Parameters //////
/////////////////////////////////

Object.metaClass.getParametersOfType = { typeName ->
  query = 'type:"ParameterType" AND code:"' + typeName + '"'
  queryNodeIndex(query)
}

Object.metaClass.getParameterByRegex = { aNameRegex ->
  getNodesByType("Parameter").filter{ it.code.matches(aNameRegex) }
}

Object.metaClass.getParameterByNameRegex = { aNameRegex ->
  getNodesByType("Parameter").out('IS_AST_PARENT').filter{ it.type == 'Identifier' && it.code.matches(aNameRegex) }
}


/////////////////////////////
//////// Calls //////////
////////////////////////////

/**
   Retrieve all calls by callee.  This is more efficient than
   'getCallsToRegex' but less powerful, allowing only exact matches of
   callee names.

  @param callee identifier of the callee
*/

Object.metaClass.getCallsTo = { callee ->
  query = 'type:"CallExpression" AND code:' + callee + '*'
  queryNodeIndex(query).filter
  {
    it.code.startsWith(callee + ' ')
  }
}

/**
   Retrieve all calls by regular expression To match a regex, we can
   only use the index to extract all CallExpressions. We then need to
   iterate over all call expressions to see where the regex matches.

   @param callee regular expression callees must match.
   
 */
 
Object.metaClass.getCallsToRegex = { callee ->
  getNodesByType("CallExpression").filterCodeByCompiledRegex(Pattern.compile(callee))
}

//////////////////////////
//// Arguments to calls
//////////////////////////

/**
   Retrieve n'th arguments to calls by callee.
   
   @param callee callee
   @param n the parameter number (a String)
*/

Object.metaClass.getArgumentNTo = { callee, n ->
  getCallsTo(callee).callToArgumentN(n)
}


/**
   Retrieve declaration by name.
   @param aName name
*/

Object.metaClass.getTypeDeclsByName = { aName ->
  g.idx('nodeIndex')[[name:aName]]
}


Object.metaClass.exists = { it ->  it.toList().size != 0 }
//////////////////////////////////////////////////////////////////
// (2) Once start nodes have been selected, you can use the steps
// below to traverse the graph.
//////////////////////////////////////////////////////////////////

Gremlin.defineStep('idToNode', [Vertex,Pipe], { _().transform{ g.v(it) }.scatter() })
Gremlin.defineStep('queryToNodes', [Vertex,Pipe], { _().transform{ queryNodeIndex(it) }.scatter() })

Gremlin.defineStep('astNodeToFunction', [Vertex,Pipe],{ _().functionId.idToNode() });
Gremlin.defineStep('astNodeToSymbol', [Vertex,Pipe], { _().transform{ queryNodeIndex('type:Symbol AND functionId:' + it.functionId + ' AND code:"' + it.code + '"') }.scatter() })
Gremlin.defineStep('astNodeToBasicBlock', [Vertex,Pipe], { _().in('IS_AST_PARENT', 'IS_BASIC_BLOCK_OF').loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });
Gremlin.defineStep('astNodeToBasicBlockRoot', [Vertex, Pipe], { _().astNodeToBasicBlock().basicBlockToAST() })

Gremlin.defineStep("functionToAllNodesOfType", [Vertex, Pipe], { aType -> _().functionToASTNodes().filter{ it.type == aType}  })

Gremlin.defineStep("functionToFile", [Vertex,Pipe], { _().in('IS_FILE_OF') })
Gremlin.defineStep("functionToASTNodes", [Vertex,Pipe], { _().transform{ queryNodeIndex('functionId:' + it.id)}.scatter().filter{ it.type != 'BasicBlock' && it.type != 'Symbol'} })
Gremlin.defineStep("functionToBasicBlocks", [Vertex,Pipe], { _().transform{ queryNodeIndex('type:BasicBlock AND functionId:' + it.id) }.scatter()})
Gremlin.defineStep("functionToAST", [Vertex,Pipe], { _().out('IS_FUNCTION_OF_AST') })
Gremlin.defineStep("functionToASTRoot", [Vertex,Pipe], { _().functionToAST().out('IS_AST_OF_AST_ROOT') })
Gremlin.defineStep('basicBlockToAST', [Vertex,Pipe], { _().out('IS_BASIC_BLOCK_OF') } );

Gremlin.defineStep("functionToParameterList", [Vertex,Pipe], { _().getFunctionASTRoot().outE('IS_AST_PARENT').filter{ it.n == '1'}.inV() })
Gremlin.defineStep("functionToParameterN", [Vertex,Pipe], { n -> _().functionToParameterList().outE('IS_AST_PARENT').filter{ it.n == n}.inV() })
Gremlin.defineStep("functionToParameterNType", [Vertex,Pipe], { n -> _().functionToParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()} )
Gremlin.defineStep("functionToParameterNName", [Vertex,Pipe], { n -> _().functionToParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '1'}.inV()} )

Gremlin.defineStep("functionToCalls", [Vertex,Pipe], { _().functionToAllNodesOfType('CallExpression') } )
Gremlin.defineStep("functionToCallsTo", [Vertex,Pipe], { x -> _().functionToCalls().filter{ it.code.startsWith(x + ' ')}  })
Gremlin.defineStep("functionToCallsToAnyOf", [Vertex,Pipe], { l -> _().functionToCalls().filter{ for(x in l){ if(it.code.startsWith(x + ' ')) return true; }; return false; }})
Gremlin.defineStep('functionToCallsToRegex', [Vertex,Pipe], { callee -> _().functionToASTNodes().filter{ it.type == 'CallExpression' && it.code.matches(callee) }} )

Gremlin.defineStep("functionToConditions", [Vertex,Pipe], {

_().transform{
ret = []
ret = it.functionToAllNodesOfType('Condition').toList() 
ret.addAll(it.functionToAllNodesOfType('ConditionalExpression').outE('IS_AST_PARENT').filter{ it.n == "0"}.inV().toList())
ret;
}.scatter()

})

Gremlin.defineStep("functionToLocals", [Vertex,Pipe], { _().functionToASTNodes().filter{it.type == 'IdentifierDecl'} })
Gremlin.defineStep("localToType", [Vertex,Pipe], { _().out('IS_AST_PARENT').filter{it.type == 'IdentifierDeclType'} } )
Gremlin.defineStep("localToName", [Vertex,Pipe], { _().out('IS_AST_PARENT').filter{it.type == 'Identifier'} } )
Gremlin.defineStep("functionToLocalTypes", [Vertex,Pipe], { _().functionToLocals().localToType() } )
Gremlin.defineStep("functionToLocalNames", [Vertex,Pipe], { _().functionToLocals().localToName() } )


// Watchout: 'n' is a string parameter for now

Gremlin.defineStep('callToCallee', [Vertex, Pipe], { _().outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()})
Gremlin.defineStep('callToArgumentN', [Vertex,Pipe], { n -> _().out('IS_AST_PARENT').filter{it.type == 'ArgumentList'}.outE('IS_AST_PARENT').filter{ it.n == n }.inV()} )
Gremlin.defineStep('callToFunctions', [Vertex,Pipe], { _().callToCallee().transform{ getFunctionByName(it.code) }.scatter() })

Gremlin.defineStep('argToCallee', [Vertex,Pipe], { _().in('IS_AST_PARENT').filter{ it.type == 'ArgumentList'}.in('IS_AST_PARENT').outE('IS_AST_PARENT').filter{ it.n == '0' }.inV()} )

Gremlin.defineStep('cfgPathsToExit', [Vertex,Pipe], { _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})
Gremlin.defineStep('cfgPathsFromEntry', [Vertex,Pipe], { _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    

Gremlin.defineStep('assignmentToLval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("0") }.inV()});
Gremlin.defineStep('assignmentToRval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("1") }.inV()});

Object.metaClass.codeContains = { obj, x ->
  obj.code.contains(x)
}

Gremlin.defineStep('codeContains', [Vertex,Pipe], { x -> _().filter{ it.code.matches(x) } } )
Gremlin.defineStep('filterCodeByRegex', [Vertex,Pipe], { expr -> _().filter{ it.code.matches(expr) }} )
Gremlin.defineStep('filterCodeByCompiledRegex', [Vertex,Pipe], { regex -> _().filter{ regex.matcher(it.code).matches() }} )

public nodesOfTree(ArrayList vertices)
{
  def results = []; 
  vertices.each()
  { 
    results << it;
    def children = it.out('IS_AST_PARENT').toList();
    if(children){
      def childNodes = nodesOfTree(children);
      results.addAll(childNodes);
    }
  }
  results;
}

Gremlin.defineStep('getASTNodes', [Vertex,Pipe], { _().transform{ nodesOfTree([it]) }.scatter() } );
Gremlin.defineStep('functionToASTNodesOfType', [Vertex,Pipe], { t -> _().functionToASTNodes().filter{ it.type == t} } );
Gremlin.defineStep('functionToIdentifiers', [Vertex,Pipe], { _().functionToASTNodesOfType('Identifier') })

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

Gremlin.defineStep('subASTsOfType', [Vertex, Pipe], { t -> def types = t;		     
  _().copySplit(
    _().out('IS_AST_PARENT').loop(1){true}{ it.object.type in types },
    _().filter{ it.type in types}
).exhaustMerge()
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
  
  _().sideEffect{ sourceId = it[0]; sinkId = it[1] }.transform{ g.v(sourceId)}
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

/////////////////////////////////
// Type analysis
////////////////////////////////

Gremlin.defineStep('astNodeToTypesUsed', [Vertex, Pipe], {
  _().astNodeToLocalDeclsUsed().localDeclToType()
})

Gremlin.defineStep('localDeclToType', [Vertex, Pipe],{
  _().ifThenElse{ it.type == 'IdentifierDecl'}
  { it.out().filter{ it.type == 'IdentifierDeclType'} }
  // else: Parameter
  { it.out().filter{ it.type == 'ParameterType'} }
})

Gremlin.defineStep('localDeclToName', [Vertex, Pipe], {
 _().out().filter{it.type == 'Identifier'}
})

Gremlin.defineStep('astNodeToSymbolsUsed', [Vertex, Pipe], { 
  _().out('USE')
})

Gremlin.defineStep('astNodeToLocalDeclsUsed', [Vertex, Pipe], {
 _().astNodeToSymbolsUsed().symbolToDecl()
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
  _().out('IS_CLASS_OF').filter{it.type == 'DECL_STMT'}.out()
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

Gremlin.defineStep('astNodeToStructTypesUsed', [Vertex, Pipe], {
  _().astNodeToLocalDeclsUsed().as('localDecl')
  .localDeclToName().sideEffect{ symbol = it.code }.back('localDecl')
  .localDeclToType().filter{ isStruct(it) }.structureToName()
  .nameToTypeDecl().transform{ [it, symbol]  }
})

//////////////////////////
// Output steps
/////////////////////////

Gremlin.defineStep("functionToLocationRow", [Vertex,Pipe], {
  _().functionToFile()
  .sideEffect{fname = it.filepath; }.back(2).transform{ [fname, it.location, it.signature] }
})

/////

Object.metaClass.containsSymbol = { it, symbol ->
  it.code.matches(symbol + '(?!([a-zA-Z0-9_]))')  
}
