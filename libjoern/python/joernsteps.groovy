import java.util.regex.*;
import com.tinkerpop.blueprints.pgm.impls.neo4j.util.*;
	   
////////////////////////////////////////////
// (1) Selection of start nodes
////////////////////////////////////////////

/**
   Query the node index.   
   @param query Lucene query
*/

Object.metaClass.queryNodeIndex = { query ->
  index = g.getRawGraph().index().forNodes("nodeIndex")
  new Neo4jVertexSequence(index.query(query), g)._()
}

/**
   Retrieve all nodes of a specified type from
   the node index.
   @param typeName type
*/

Object.metaClass.getNodesByType = { typeName ->
  g.idx("nodeIndex")[[type:typeName]]
}

/**
   Allows more than one pipe to generate starting
   points. Acts as an AND.
*/

Object.metaClass.START = { pipes ->
  np = []
  for(int i = 0; i < pipes.size(); i++){
    p = pipes[i]
    np.add( _().transform{ p }.scatter())
  }
  _().copySplit( *np ).exhaustMerge()
}

/**
   Retrieve declaration by name.
   @param aName name
*/

Object.metaClass.getTypeDeclsByName = { aName ->
  g.idx('nodeIndex')[[name:aName]]
}

/**
   Retrieve function by name.
   @param aName name
*/

Object.metaClass.getFunctionByName = { aName ->
  g.idx('nodeIndex')[[functionName:aName]]
}

/**
   Retrieve all calls by callee.
   This is more efficient than 'getCallsToRegex'
   but less powerful, allowing only exact
   matches of callee names.

  @param callee identifier of the callee
*/

Object.metaClass.getCallsTo = { callee ->
  query = 'type:"CallExpression" AND code:' + callee + '*'
  queryNodeIndex(query).filter
  {
    it.code.startsWith(callee + ' ')
  }
}

Object.metaClass.getParametersOfType = { typeName ->
  query = 'type:"ParameterType" AND code:"' + typeName + '"'
  queryNodeIndex(query)
}

/**
   Retrieve n'th arguments to calls by callee.
   
   @param callee callee
   @param n the parameter number (a String)
*/

Object.metaClass.getArgumentNTo = { callee, n ->
  getCallsTo(callee).calleeToArgumentN(n)
}

/**
   Retrieve all calls by regular expression
   To match a regex, we can only use the index
   to extract all CallExpressions. We then
   need to iterate over all call expressions
   to see where the regex matches.

   @param callee regular expression callees must match.
   
 */
 
Object.metaClass.getCallsToRegex = { callee ->
  getNodesByType("CallExpression").filterCodeByCompiledRegex(Pattern.compile(callee))
}

/////////////////////////////////////////////
// (2) Steps
/////////////////////////////////////////////

Gremlin.defineStep('idToNode', [Vertex,Pipe], { _().transform{ g.v(it) }.scatter() })
Gremlin.defineStep('queryToNodes', [Vertex,Pipe], { _().transform{ queryNodeIndex(it) }.scatter() })
Gremlin.defineStep('nameToTypeDecl', [Vertex,Pipe], { _().transform{ getTypeDeclsByName(it) }.scatter() })
Gremlin.defineStep('calleeToFunctions', [Vertex,Pipe], { _().getCalleeFromCall().transform{ getFunctionByName(it.code) }.scatter() })

Gremlin.defineStep('astNodeToFunction', [Vertex,Pipe],{ _().functionId.idToNode() });
Gremlin.defineStep('astNodeToSymbol', [Vertex,Pipe], { _().transform{ queryNodeIndex('type:Symbol AND functionId:' + it.functionId + ' AND code:"' + it.code + '"') }.scatter() })

Gremlin.defineStep("functionToFile", [Vertex,Pipe], { _().in('IS_FILE_OF') })
Gremlin.defineStep("functionToASTNodes", [Vertex,Pipe], { _().transform{ queryNodeIndex('functionId:' + it.id)}.scatter().filter{ it.type != 'BasicBlock'} })
Gremlin.defineStep("functionToBasicBlocks", [Vertex,Pipe], { _().transform{ queryNodeIndex('type:BasicBlock AND functionId:' + it.id) }.scatter()})
Gremlin.defineStep("functionToAST", [Vertex,Pipe], { _().out('IS_FUNCTION_OF_AST') })
Gremlin.defineStep("functionToASTRoot", [Vertex,Pipe], { _().functionToAST().out('IS_AST_OF_AST_ROOT') })

Gremlin.defineStep("functionToParameterList", [Vertex,Pipe], { _().getFunctionASTRoot().outE('IS_AST_PARENT').filter{ it.n == '1'}.inV() })
Gremlin.defineStep("functionToParameterN", [Vertex,Pipe], { n -> _().functionToParameterList().outE('IS_AST_PARENT').filter{ it.n == n}.inV() })
Gremlin.defineStep("functionToParameterNType", [Vertex,Pipe], { n -> _().functionToParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()} )
Gremlin.defineStep("functionToParameterNName", [Vertex,Pipe], { n -> _().functionToParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '1'}.inV()} )

Gremlin.defineStep("functionToCalls", [Vertex,Pipe], { _().functionToASTNodes().filter{ it.type == 'CallExpression'}})
Gremlin.defineStep("functionToCallsTo", [Vertex,Pipe], { x -> _().functionToCalls().filter{ it.code.startsWith(x + ' ')}  })
Gremlin.defineStep("functionToCallsToAnyOf", [Vertex,Pipe], { l -> _().functionToCalls().filter{ for(x in l){ if(it.code.startsWith(x + ' ')) return true; }; return false; }})
Gremlin.defineStep('functionToCallsToRegex', [Vertex,Pipe], { callee -> _().functionToASTNodes().filter{ it.type == 'CallExpression' && it.code.matches(callee) }} )


Gremlin.defineStep("functionToLocals", [Vertex,Pipe], { _().functionToASTNodes().filter{it.type == 'IdentifierDecl'} })
Gremlin.defineStep("localToType", [Vertex,Pipe], { _().out('IS_AST_PARENT').filter{it.type == 'IdentifierDeclType'} } )
Gremlin.defineStep("localToName", [Vertex,Pipe], { _().out('IS_AST_PARENT').filter{it.type == 'Identifier'} } )
Gremlin.defineStep("functionToLocalTypes", [Vertex,Pipe], { _().functionToLocals().localToType() } )
Gremlin.defineStep("functionToLocalNames", [Vertex,Pipe], { _().functionToLocals().localToName() } )

Gremlin.defineStep("functionToLocationRow", [Vertex,Pipe], { _().functionToFile().sideEffect{fname = it.filepath; }.back(2).transform{ [fname, it.location, it.signature] } })


// This one is horrible as we use a regex to parse the struct part from the type and chop off the postfix
Gremlin.defineStep("structureToName", [Vertex,Pipe], { _().transform{ (it.code =~/struct ([^\s]+)/)[0][1] } } )
Gremlin.defineStep("structureToMemberDecls", [Vertex,Pipe], { _().out('IS_CLASS_OF').filter{it.type == 'DECL_STMT'}.out() } )


Gremlin.defineStep('callToCallee', [Vertex, Pipe], { _().outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()})

// Watchout: n needs to be a string for now
Gremlin.defineStep('calleeToArgumentN', [Vertex,Pipe], { n -> _().out('IS_AST_PARENT').filter{it.type == 'ArgumentList'}.outE('IS_AST_PARENT').filter{ it.n == n }.inV()} )


Gremlin.defineStep('argToCallee', [Vertex,Pipe], { _().in('IS_AST_PARENT').filter{ it.type == 'ArgumentList'}.in('IS_AST_PARENT').outE('IS_AST_PARENT').filter{ it.n == '0' }.inV()} )

Gremlin.defineStep('astNodeToBasicBlock', [Vertex,Pipe], { _().in('IS_AST_PARENT', 'IS_BASIC_BLOCK_OF').loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });

Gremlin.defineStep('basicBlockToAST', [Vertex,Pipe], { _().out('IS_BASIC_BLOCK_OF') } );

// For a given basic block, get all paths into the exit direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsToExit', [Vertex,Pipe], { _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})

// For a given basic block, get all paths into the entry direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsFromEntry', [Vertex,Pipe], { _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    

Gremlin.defineStep('assignToLval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("0") }.inV()});
Gremlin.defineStep('assignToRval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("1") }.inV()});

Object.metaClass.codeContains = { obj, x ->
  obj.code.contains(x)
}

Gremlin.defineStep('codeContains', [Vertex,Pipe], { x -> _().filter{ it.code.matches(x) } } )
Gremlin.defineStep('filterCodeByRegex', [Vertex,Pipe], { expr -> _().filter{ it.code.matches(expr) }} )
Gremlin.defineStep('filterCodeByCompiledRegex', [Vertex,Pipe], { regex -> _().filter{ regex.matcher(it.code).matches() }} )


// A data flow from a basic block to all basic blocks
// containing some expression

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


Gremlin.defineStep('dataFlowFrom', [Vertex, Pipe], { s ->
  def source = s;
  _().out('USE').sideEffect{ symbol = it.code }.back(3)
  .astNodeToBasicBlock().sideEffect{ firstRound = true }
  .as('loopStart').inE('REACHES').filter{ !firstRound || it.var == symbol }.outV().sideEffect{firstRound = false}
  .loop('loopStart'){it.loops < 10 && !it.object.code.contains(source)}{true}
  .filter{ it.code.contains(source) }.dedup()
})

Gremlin.defineStep('ipDataFlowFrom', [Vertex, Pipe], { s-> 
  def source = s;
  _().out('USE').sideEffect{ symbol = it.code }.back(3)
  .astNodeToBasicBlock().sideEffect{ firstRound = true }
  .as('loopStart')

  .basicBlockToAST()
  .ifThenElse{ return it.type == 'Parameter'}
  { it.out('IS_AST_PARENT').filter{ it.type == 'Identifier'}.in('IS_ARG').astNodeToBasicBlock() }
  { it.astNodeToBasicBlock().inE('REACHES').filter{ !firstRound || it.var == symbol }.outV().sideEffect{firstRound = false} }
  .loop('loopStart'){it.loops < 10 && !it.object.code.contains(source)}{true}
  .filter{ it.code.contains(source) }.dedup()
})

Gremlin.defineStep('subASTsOfType', [Vertex, Pipe], { t -> def type = t; _().out('IS_AST_PARENT').loop(1){ it.object.type != type} })


Gremlin.defineStep('markAsSink', [Vertex, Pipe], { _().sideEffect{ sinkId = it.id; } } )

Gremlin.defineStep('controlFlowToSink', [Vertex, Pipe], { san ->
  def sanitizer = san;
  _().out('FLOWS_TO').loop(1){ it.loops < 10 && it.object.id != sinkId &&
    !it.object.code.contains(sanitizer)}.filter{ it.id == sinkId } })
