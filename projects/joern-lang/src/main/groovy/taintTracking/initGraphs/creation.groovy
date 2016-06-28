
// Referred to as `initialization graph` in the paper

class TaintGraph{
	def graphlets = []
	def invocations = []
	def callSiteId;
	
	TaintGraph(gphLets){
		graphlets = gphLets.collect()
	}
	
}

/**
 Entry point for recursive creation of taint-graphs
 for a given call site. The function expects the id
 of the corresponding CallExpression database-node.
*/

createInitGraph = { callSiteId ->
	
	argSet = g.v(callSiteId)._().callToArguments().id.toList() //.sort()
	
	def tGraph = new TaintGraph(taintGraph_(argSet, [:], 0, 0));
	tGraph.callSiteId = callSiteId
	tGraph
}

/**
 * See algorithm for initialization graph creation in the paper.
 * */

taintGraph_ = { def argSet, visited, curIdOffset, depth ->

	def callId, vars, defStmts;

	// maximum depth is four.
	if(argSet.size() == 0 || depth == 4)
		return []

	callId = getCallId(argSet.head())
	if(callId in visited)
		return []

	// Create graphlet for this argument set
		
	def graphlet = createGraphlet(argSet, callId)

	// If there are no leaves, we may be dealing with a global variable
	// or a broken parse.

	// if(graphlet.leaves == [])
	//   return []

	def rLeaves = createReverseIndex(graphlet.leaves)
	def uniqLeaves = graphlet.leaves.unique(false);
	
	// Get all leaf nodes that are parameters
	// If there are none (termination criteria), return graph)

	def retval = []
	def extEdges = [:]

	def paramNodes = uniqLeaves.findAll{ g.v(it).type == 'Parameter' }
	def paramNums = paramNodes.collect{ g.v(it)._().childNum.toList().head() }
	
	if(paramNodes.size() == 0){
		graphlet.extEdges = [:]
		return [graphlet]
	}

	def callers = g.v(paramNodes[0])._().functions().functionToCallers().id.toList().sort()

	callers.each{ caller ->
  
		// transform parameterNodes to argumentNodes
		// and call taintGraph_ on set of argumentNodes

		def newArgNodes = paramNums.collect{
			def x = g.v(caller)._().ithArguments(it).id.toList()
			if(x.size() == 0) return null
			x.head()
		}
		
		// Unable to find args for all params, skip this caller.
		if(null in newArgNodes) return;
		
		def graphlets = taintGraph_(newArgNodes, visited.plus([(callId) : 1]), curIdOffset + 1, depth + 1)
  
		retval.addAll(graphlets)

		if(graphlets.size() == 0)
			return // continue
		
  
		// add edges from leaves to argument nodes
		paramNodes.eachWithIndex{ paramNode, i ->
		argNode = newArgNodes[i]
		graphlet.leaves[rLeaves[paramNode]].each{
			if(!extEdges[(it)]){ extEdges[(it)] = [] }
			extEdges[(it)] << [argNode,curIdOffset + 1]
			}
		}
		curIdOffset += graphlets.size()
	}
  
	graphlet.extEdges = extEdges
	graphlet.leaves = uniqLeaves
	
	retval.add(0, graphlet)

	return retval
}


/**
 * For a given node id, return node ids of all
 * sub-conditions. This includes the entire condition,
 * albeit the 'Condition'-root node is removed so that
 * it makes no difference whether a condition is part
 * of a larger condition or makes up the entire condition.
 * */

subConditions = { cnd ->
	
	def X = []
	def sConditions = g.v(cnd)._().match{it.type in ["OrExpression", "AndExpression"] }.children().id.toList().sort()
	def firstChild = g.v(cnd)._().children().id.toList()[0];
	
	X << firstChild;
	X.addAll(sConditions)
	X
}

getCallId = { arg ->
	g.v(arg).argToCall().id.toList()[0]
}
  