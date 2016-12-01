
class Invocation{
	
	// Invocations are fully defined by their
	// graphletIds. All other members simply cache
	// information that can be deduced from the
	// the invocation.
	
	def graphletIds = []
	def allGraphlets;
	
	def defStmtsPerArg = []
	def checksPerArg = []

	Invocation(ids){
		graphletIds = ids.collect()
	}
}

/**
 Extract individual invocations as sub-sets of graphlets.
 */

/**
 Once a taint-graph has been constructed, extract individual
 invocations. An invocation is a subset of the graphlet set, i.e.,
 `taintGraph`.
 Property: Parameter-nodes are connected to at most one argument.
 */

decompressInitGraph = { tGraph ->
	
	def graphlets = tGraph.graphlets
	
	def invocs = invocations_(graphlets, 0).collect{ new Invocation(it) }
	invocs = invocs.unique{ x,y -> compareLists(x.graphletIds, y.graphletIds) }
	
	invocs.each{
		it.defStmtsPerArg = genDefStmtsPerArg(graphlets, it.graphletIds)
	}

	invocs = invocs.unique{ x,y -> compareLists(x.defStmtsPerArg, y.defStmtsPerArg) }
	

	invocs.each{ it.allGraphlets = graphlets }
	
	invocs
}

invocations_ = { def taintGraph, curGraphletId ->
	
	def ret = []

	def graphlet = taintGraph[curGraphletId]
	def args = graphlet.args
	def edges = graphlet.edges
	def extEdges = graphlet.extEdges
	def leaves = graphlet.leaves

	// If there are no external edges, add a list containing only this
	// graphlet to the accumulator.

	if(extEdges == [:]){ return [[curGraphletId]] }

	// Determine all graphlets that are reachable via an external edge
	// originating from this graphlet.

	// id[1] is the graphlet-id
	
	def outGraphlets = extEdges.values().inject([]){ a, val -> a.plus(val) }.collect{ it[1] }.unique()

	// For each reachable graphlet:

	outGraphlets.each{ def id ->

		// Determine its list of invocations. Note, that each entry in
		// this list is a set of graphlets.

		def invocs = invocations_(taintGraph, id)
		invocs.each{

			// Combine each of these entries with this graphlet and add the
			// resulting list to the accumulator.

			ret << [curGraphletId].plus(it)
		}
	}
	ret
}

/**
 * Utility function to iterative over all invocations
 * */

collectForInvocations = { closure ->
	def acc = []

	taintGraphs.each{ tGraph ->
		tGraph.invocations.each{
			acc << closure(it)
		}
	}
	acc
}
