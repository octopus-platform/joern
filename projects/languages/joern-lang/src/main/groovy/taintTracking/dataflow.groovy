
/**
   Data producers of the statement enclosing an AST-node, limited to a
   set N of symbols.

   N A set of symbols of interest
*/

producers = { def args -> def N = args[0];
	_().statements().In(DATA_FLOW_EDGE, DATA_FLOW_SYMBOL, N )
}


/**
   Data users of the statement enclosing an AST-node, limited to a
   set N of symbols.

   N A set of symbols of interest
*/

users = { def args -> def N = args[0];
	_().statements().Out(DATA_FLOW_EDGE, DATA_FLOW_SYMBOL, N )
}

/**
   Data producers of the statement enclosing an AST-node.
*/

sources = {
	_().statements()
	.in(DATA_FLOW_EDGE)
}

/**
   Data consumers of the statement enclosing an AST-node.
*/

sinks = {
	_().statements()
	.out(DATA_FLOW_EDGE)
}

/**
   Data consumers of variables defined in the given ASTs.
*/

astSinks = {
	_().transform{ N = it.defines().code.toList(); it.users(N) }.scatter()
}

/**
   Data sources of variables used in the given ASTs.
*/

astSources = {
	_().transform{ N = it.used().code.toList(); it.producers(N) }.scatter()
}

/**
   For a set of destination nodes: all paths in the control flow graph
   from data sources where no node on the path redefines the produced
   symbol and no node on the path matches a sanitizer description.
   
   @return A pipe containing valid source nodes

*/

unsanitized = { def args -> def sanitizer = args[0]; def src = { [1]._() }; if(args.size() > 1) src= args[1];
  _().uPath(sanitizer, src).firstElem()
}

unsanitizedPaths = { def args -> def sanitizer = args[0]; def src = { [1]._() }; if(args.size() > 1) src= args[1];
	_().uPath(sanitizer, src)
}

firstElem = {
	_().transform{it[0]}
}

/**
   For a set of destination nodes: all paths in the control flow graph
   from data sources where no node on the path redefines the produced
   symbol and no node on the path matches a sanitizer description.
   
   @returns A pipe containing a set of paths for each destination
   
*/

uPath = { def args -> def sanitizer = args[0]; def src = { [1]._() }; if(args.size() > 1) src= args[1];

  _().sideEffect{ dst = it; }
  .usesFiltered().sideEffect{ symbol = it.code }
  // .uses().sideEffect{ symbol = it.code }
  .transform{ dst.producers([symbol]) }.scatter()
  .filter{ src(it).toList() != [] }
  .transform{ cfgPaths(symbol, sanitizer, it, dst.statements().toList()[0] ) }.scatter()
  
}

/**
   All paths in the control flow graph from src to dst where
   none of the nodes on the path match a sanitizer description and
   none of the nodes redefine a given symbol.
   
   This is `u` in the paper.

   @returns Returns a set of paths

*/

cfgPaths = { symbol, sanitizer, src, dst ->
  _cfgPaths(symbol, sanitizer,
	    src, dst, [:], [])
}

/**
   This is `g` in the paper
   
   @returns Returns a set of paths

*/

_cfgPaths = {symbol, sanitizer, curNode, dst, visited, path ->
  
  // return an empty set if this node is a sanitizer
  if( ( path != [] ) && isTerminationNode(symbol, sanitizer, curNode, visited)){
    return [] as Set
  }

  // return path when destination has been reached
  if(curNode == dst){
    return [path + curNode] as Set
  }
  
    
  // `h` in the paper is inlined here
  
  def children = g.V(curNode).out(CFG_EDGE).toList()
  def X = [] as Set
  def x;

  for(child in children){
      
    def curNodeId = curNode.id();
    
    x = _cfgPaths(symbol, sanitizer, child, dst,
		  visited + [ (curNodeId) : (visited.get(curNodeId, 0) + 1)],
		  path + curNode)  
    

    X += x

    // OPTIMIZATION!
    // If we find one path, there's no need to explore the others
    if(!x.isEmpty()){ return x }

    // Limit depth of CFG paths to 30
    if(path.size() > 30) return []
    
  }

  X
}

/**
   Determines whether the node is a termination ode.
   This is p(s, m, v, V) in the paper.

   @params symbol The symbol of interest (which the block must not define)
   @params sanitizer The sanitizer description (a traversal)
   @params curNode The node of interest
   @params The map (multiset) of visited nodes
*/

isTerminationNode = { symbol, sanitizer, curNode, visited ->
  
  def curNodeId = curNode.id()
  
  sanitizer(curNode, symbol).toList() != [] ||
    (g.V(curNode).out(DEFINES_EDGE).has('code', symbol).toList() != []) ||
    (visited.get(curNodeId) == 2)
}
