
Object.metaClass.astNodesByType = { typeName ->
  g.idx("astNodeIndex")[[type:typeName]]
}
  
// We may want to also index code-strings. It takes
// a while but it would allow us much faster
// getCallsTo calls

Object.metaClass.getCallsTo = { callee ->
  astNodesByType("CallExpression").filterCodeByRegex(callee)
}


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

// For a given CallExpression AST-node, get its n'th parameter
// Watchout: n needs to be a string for now

Gremlin.defineStep('getParameterN', [Vertex,Pipe], { n -> _().outE('IS_AST_PARENT').filter{it.n == n}.inV() } )

Gremlin.defineStep('filterCodeByRegex', [Vertex,Pipe], { expr -> _().filter{ it.code.matches(expr) }} )

Gremlin.defineStep('markAsSink', [Vertex,Pipe], { _().basicBlock().sideEffect{ sinkId  = it.id; }.back(2) } )

// Check if a flow from the current basic block
// to the basicBlock with id 'sinkId' exists.
// It would be much nicer if we could pass the
// id in as a variable

Gremlin.defineStep('flowsToSink', [Vertex,Pipe],
		   { _().out('FLOWS_TO').loop(1){it.loops < 100 && it.object.id != sinkId}.filter{it.id == sinkId }.dedup()
		   }  )

// {String label -> _().as('x').out(label).in(label).except('x')})

// For a given AST-node, get the function node

Gremlin.defineStep('function', [Vertex,Pipe],{ _().in('IS_FUNCTION_OF_AST_NODE') });

// For a given AST-node, get the basic-block this AST-node is part of

Gremlin.defineStep('basicBlock', [Vertex,Pipe], { _().in().loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });

// For an assignment AST-node, get the lval-node

Gremlin.defineStep('lval', [Vertex,Pipe], { _().outE('IS_AST_PARENT').filter{ it.n.equals("0") }inV()});

// For a given basic block, get all paths into the exit direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsToExit', [Vertex,Pipe], { _().out('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})

// For a given basic block, get all paths into the entry direction
// up to and inlcuding a length of 10

Gremlin.defineStep('pathsFromEntry', [Vertex,Pipe], { _().in('FLOWS_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    

// Starting from an AST-node, extract the AST rooted
// at that node

Gremlin.defineStep("AST", [Vertex,Pipe], getAST);   

// Get all basic blocks of a function

Gremlin.defineStep("funcBasicBlocks", [Vertex,Pipe], { _().outE('BASIC_BLOCK').inV()})

// Get all AST-nodes of a function

Gremlin.defineStep("funcASTNodes", [Vertex,Pipe], { _().outE('IS_FUNCTION_OF_AST_NODE').inV()})

