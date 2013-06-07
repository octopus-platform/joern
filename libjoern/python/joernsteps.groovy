import java.util.regex.*;

Object.metaClass.astNodesByType = { typeName ->
  g.idx("astNodeIndex")[[type:typeName]]
}
 

// This is more efficient than 'getCallsToRegex'
// but less powerful, allowing only exact
// matches of callee names

Object.metaClass.getCallsTo = { callee ->
  queryNodeIndex('type:"CallExpression" AND code:' + callee + '*').filter{ it.code.startsWith(callee + ' ') }
}
 
// To match a regex, we can only use the index
// to extract all CallExpressions. We then
// need to iterate over all call expressions
// to see where the regex matches.

Object.metaClass.getCallsToRegex = { callee ->
  astNodesByType("CallExpression").filterCodeByCompiledRegex(Pattern.compile(callee))
}

Object.metaClass.queryNodeIndex = { query ->
  new com.tinkerpop.blueprints.pgm.impls.neo4j.util.Neo4jVertexSequence(g.getRawGraph().index().forNodes("astNodeIndex").query(query), g)._()
}

///////////////////////////////////////
// Steps for CallExpression AST-nodes:
///////////////////////////////////////

// Get n'th parameter.
// Watchout: n needs to be a string for now

Gremlin.defineStep('getArgumentN', [Vertex,Pipe], { n -> _().out('IS_AST_PARENT').filter{it.type == 'ArgumentList'}.outE('IS_AST_PARENT').filter{ it.n == n }.inV() } )

// Get the callee, i.e. the name of the function called

Gremlin.defineStep('getCalleeFromCall', [Vertex, Pipe], { _().outE('IS_AST_PARENT').filter{ it.n == '0'}.inV() })

Gremlin.defineStep('resolveCallee', [Vertex,Pipe], { _().getCalleeFromCall().transform{ g.idx('astNodeIndex')[[functionName:it.code]] }} )

/////////////////////////////
// Steps for Function-nodes:
/////////////////////////////

Gremlin.defineStep('getCallsFromFuncToRegex', [Vertex,Pipe], { callee -> _().funcASTNodes().filter{ it.type == 'CallExpression' && it.code.matches(callee) }} )

// Get all basic blocks of a function

Gremlin.defineStep("funcBasicBlocks", [Vertex,Pipe], { _().outE('BASIC_BLOCK').inV()})

// Get all AST-nodes of a function

Gremlin.defineStep("funcASTNodes", [Vertex,Pipe], { _().outE('IS_FUNCTION_OF_AST_NODE').inV()})

Gremlin.defineStep("getSourceFile", [Vertex,Pipe], { _().in('IS_FILE_OF') })

Gremlin.defineStep("getLocationRow", [Vertex,Pipe], { _().getSourceFile().sideEffect{fname = it.filepath; }.back(2).transform{ [fname, it.location, it.signature] } })

///////////////////////////////////
// Steps for AST nodes in general
//////////////////////////////////

// For a given AST-node, get the function node

Gremlin.defineStep('function', [Vertex,Pipe],{ _().in('IS_FUNCTION_OF_AST_NODE') });

Gremlin.defineStep('basicBlock', [Vertex,Pipe], { _().in().loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });

Gremlin.defineStep('filterCodeByRegex', [Vertex,Pipe], { expr -> _().filter{ it.code.matches(expr) }} )

Gremlin.defineStep('filterCodeByCompiledRegex', [Vertex,Pipe], { regex -> _().filter{ regex.matcher(it.code).matches() }} )


//////////////////////////////////
// Flows from sources to sinks
//////////////////////////////////

Gremlin.defineStep('markAsSink', [Vertex,Pipe], { _().basicBlock().sideEffect{ sinkId  = it.id; }.back(2) } )

Gremlin.defineStep('markAsSource', [Vertex,Pipe], { _().basicBlock().sideEffect{ sourceId  = it.id; }.back(2) } )

// Check if a flow from the current basic block
// to the sink exists

Gremlin.defineStep('flowsToSink', [Vertex,Pipe],
		   { _().out('FLOWS_TO').loop(1){it.loops < 30 && it.object.id != sinkId}.filter{it.id == sinkId }.dedup()
		   }  )

Gremlin.defineStep('flowFromSource', [Vertex,Pipe],
		   { _().in('FLOWS_TO').loop(1){it.loops < 30 && it.object.id != sourceId}.filter{it.id == sourceId }.dedup()
		   }  )

// For a given basic block, get all paths into the exit direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsToExit', [Vertex,Pipe], { _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})

// For a given basic block, get all paths into the entry direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsFromEntry', [Vertex,Pipe], { _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    

/////////////////////////////////
// Assignments
/////////////////////////////////

// Get the left-value-node

Gremlin.defineStep('lval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("0") }inV()});

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

