import java.util.regex.*;
import com.tinkerpop.blueprints.pgm.impls.neo4j.util.*;

////////////////////////////////////////////
// (1) Selection of start nodes
////////////////////////////////////////////

/**
   Query the AST node index.
   
   @param query Lucene query
*/

Object.metaClass.queryNodeIndex = { query ->
  index = g.getRawGraph().index().forNodes("nodeIndex")
  new Neo4jVertexSequence(index.query(query), g)._()
}

Object.metaClass.START = { pipes ->
    
  np = []
  
  for(int i = 0; i < pipes.size(); i++){
    p = pipes[i]
    np.add( _().transform{ p }.scatter())
  }
  
  _().copySplit( *np ).exhaustMerge()
}

/**
   Retrieve all AST nodes of a specified type from
   the AST node index.
   
   @param typeName AST type
 */

Object.metaClass.astNodesByType = { typeName ->
  g.idx("nodeIndex")[[type:typeName]]
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
  getCallsTo(callee).getArgumentN(n)
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
  astNodesByType("CallExpression").filterCodeByCompiledRegex(Pattern.compile(callee))
}

////////////////////////////////////////
// (2) Steps to retrieve from the index
///////////////////////////////////////

Gremlin.defineStep('queryNodeIndex', [Vertex,Pipe], {
  _().transform{ queryNodeIndex(it) }.scatter()
})

Gremlin.defineStep('getTypeDeclsByName', [Vertex,Pipe], {
 _().transform{ getTypeDeclsByName(it) }.scatter()
})

// this should be renamed to 'getFunctionByName'
Gremlin.defineStep('resolveCallee', [Vertex,Pipe], {
   _().getCalleeFromCall().transform{ getFunctionByName(it.code) }.scatter()
})

Gremlin.defineStep('getNodeById', [Vertex,Pipe], {
   _().transform{ g.v(it) }.scatter()
})

Gremlin.defineStep('backToLastFunction', [Vertex,Pipe], {
   _().transform{ functionId }.getNodeById()
})

//////////////////////////////////////
// (3) Steps for AST nodes in general
/////////////////////////////////////

// For a given AST-node, get the function node

Gremlin.defineStep('function', [Vertex,Pipe],{ _().in('IS_AST_OF_AST_NODE').in().sideEffect{ functionId = it.id} });

Gremlin.defineStep('codeContains', [Vertex,Pipe], { x -> _().filter{ it.code.matches(x) } } )

Gremlin.defineStep('filterCodeByRegex', [Vertex,Pipe], { expr -> _().filter{ it.code.matches(expr) }} )
Gremlin.defineStep('filterCodeByCompiledRegex', [Vertex,Pipe], { regex -> _().filter{ regex.matcher(it.code).matches() }} )

////////////////////////////////
// (4) Steps for Function-nodes:
////////////////////////////////

Gremlin.defineStep("getSourceFile", [Vertex,Pipe], { _().in('IS_FILE_OF') })

Gremlin.defineStep("funcASTNodes", [Vertex,Pipe], { _().getFunctionAST().out('IS_AST_OF_AST_NODE')})
Gremlin.defineStep("funcBasicBlocks", [Vertex,Pipe], { _().out('IS_FUNCTION_OF_CFG').out('IS_CFG_OF_BASIC_BLOCK') })

Gremlin.defineStep("getFunctionAST", [Vertex,Pipe], { _().out('IS_FUNCTION_OF_AST') })
Gremlin.defineStep("getFunctionASTRoot", [Vertex,Pipe], { _().out('IS_FUNCTION_OF_AST').out('IS_AST_OF_AST_ROOT') })

Gremlin.defineStep("getParameterList", [Vertex,Pipe], { _().getFunctionASTRoot().outE('IS_AST_PARENT').filter{ it.n == '1'}.inV() })
Gremlin.defineStep("getParameterN", [Vertex,Pipe], { n -> _().getParameterList().outE('IS_AST_PARENT').filter{ it.n == n}.inV() })
Gremlin.defineStep("getParameterNType", [Vertex,Pipe], { n -> _().getParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()} )
Gremlin.defineStep("getParameterNName", [Vertex,Pipe], { n -> _().getParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '1'}.inV()} )

Gremlin.defineStep("getCalls", [Vertex,Pipe], { _().funcASTNodes().filter{ it.type == 'CallExpression'}})
Gremlin.defineStep("getCallsTo", [Vertex,Pipe], { x -> _().getCalls().filter{ it.code.startsWith(x + ' ')}  })

Gremlin.defineStep("getCallsToAnyOf", [Vertex,Pipe], { l ->
  _().getCalls().filter{ for(x in l){ if(it.code.startsWith(x + ' ')) return true; }; return false; }

})

Gremlin.defineStep('getCallsToRegex', [Vertex,Pipe], { callee -> _().funcASTNodes().filter{ it.type == 'CallExpression' && it.code.matches(callee) }} )

Gremlin.defineStep("getLocals", [Vertex,Pipe], { _().funcASTNodes().filter{it.type == 'IdentifierDecl'} })
Gremlin.defineStep("getTypeOfLocal", [Vertex,Pipe], { _().out('IS_AST_PARENT').filter{it.type == 'IdentifierDeclType'} } )
Gremlin.defineStep("getNameOfLocal", [Vertex,Pipe], { _().out('IS_AST_PARENT').filter{it.type == 'Identifier'} } )
Gremlin.defineStep("getLocalTypes", [Vertex,Pipe], { _().getLocals().getTypeOfLocal() } )
Gremlin.defineStep("getLocalNames", [Vertex,Pipe], { _().getLocals().getNameOfLocal() } )

Gremlin.defineStep("getLocationRow", [Vertex,Pipe], { _().getSourceFile().sideEffect{fname = it.filepath; }.back(2).transform{ [fname, it.location, it.signature] } })


// This part is horrible as we use a regex to parse the struct part from the type and chop off the postfix
Gremlin.defineStep("nameOfStructure", [Vertex,Pipe], { _().transform{ (it.code =~/struct ([^\s]+)/)[0][1] } } )

////////////////////////////////////
// (5) Steps for structures/classes
////////////////////////////////////

Gremlin.defineStep("getMemberDecls", [Vertex,Pipe], { _().out('IS_CLASS_OF').filter{it.type == 'DECL_STMT'}.out() } )

///////////////////////////////////////////
// (6) Steps for CallExpression AST-nodes:
//////////////////////////////////////////

Gremlin.defineStep('getCalleeFromCall', [Vertex, Pipe], { 
 _().outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()
} )

// Watchout: n needs to be a string for now

Gremlin.defineStep('getArgumentN', [Vertex,Pipe], { n ->
  x = _().out('IS_AST_PARENT').filter{it.type == 'ArgumentList'}
  x.outE('IS_AST_PARENT').filter{ it.n == n }.inV()
} )

//////////////////////
// (7) Control Flow
//////////////////////

Gremlin.defineStep('basicBlock', [Vertex,Pipe], { _().in('IS_AST_PARENT', 'IS_BASIC_BLOCK_OF').loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });
Gremlin.defineStep('markAsSink', [Vertex,Pipe], { _().basicBlock().sideEffect{ sinkId  = it.id; }.back(2) } )
Gremlin.defineStep('markAsSource', [Vertex,Pipe], { _().basicBlock().sideEffect{ sourceId  = it.id; }.back(2) } )

// Check if a flow from the current basic block
// to the sink exists

Gremlin.defineStep('flowsToSink', [Vertex,Pipe],
		   { _().out('FLOWS_TO').loop(1){it.loops < 30 && it.object.id != sinkId}.filter{it.id == sinkId }.dedup()
})

// Check if a flow to the current basic block
// from the source exists

Gremlin.defineStep('flowFromSource', [Vertex,Pipe],
		   { _().in('FLOWS_TO').loop(1){it.loops < 30 && it.object.id != sourceId}.filter{it.id == sourceId }.dedup()
})

// For a given basic block, get all paths into the exit direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsToExit', [Vertex,Pipe], { _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})

// For a given basic block, get all paths into the entry direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsFromEntry', [Vertex,Pipe], { _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    

/////////////////////////////////
// Assignments
/////////////////////////////////

Gremlin.defineStep('lval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("0") }.inV()});
Gremlin.defineStep('rval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("1") }.inV()});

////////////////////////////////
// Filter Expressions
////////////////////////////////

Object.metaClass.codeContains = { obj, x ->
  obj.code.contains(x)
}


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
Gremlin.defineStep('getASTNodesOfType', [Vertex,Pipe], { t -> _().getASTNodes().filter{ it.type == t} } );

Gremlin.defineStep('getIdentifiers', [Vertex,Pipe], { _().getASTNodesOfType('Identifier') })

///////////////////////////////
// Deprecated
///////////////////////////////

def getAST = {
  _().transform{ tree(0, [it] ) }
}

def tree = { parentId, vertices ->
  
  def results = []; 
  vertices.each()
  {    
    results << [it.id, it.type, it.code, parentId];
    def children = it.out().toList();
    
    if (children) {
      def child_tree = tree(it.id, children);
      results.addAll(child_tree);
    }
  }
  results;
}

Gremlin.defineStep("AST", [Vertex,Pipe], getAST);   

