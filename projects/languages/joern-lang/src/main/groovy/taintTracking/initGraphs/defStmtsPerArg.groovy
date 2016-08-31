genDefStmtsPerArg = { taintGraph, invoc ->
	
	if(invoc.size() == 0) return
	
	def graphlet = taintGraph[invoc[0]]
	def args = graphlet.args
	
	defStmtsPerArg_(taintGraph, invoc, graphlet, args)
}

defStmtsPerArg_ = { def taintGraph, invoc, curGraphlet, args ->

	def edges = curGraphlet.edges
	def extEdges = curGraphlet.extEdges

	args.collect{ def arg ->
		
		def acc = []

		// walk to reachable defStmts in this graphlet

		edges[arg].each{ def var ->
			edges[var].each{ def stmt ->

				if( !extEdges.containsKey(stmt) ){
					acc << stmt
					return
				}

				def o = extEdges[stmt].findAll{ invoc.contains(it[1]) };

				if( o == []){
					acc << stmt;
					return
				}

				// For those, which are parameters, calculate result of calling
				// there's exactly one external link for this invoc

				def newGraphlet = taintGraph[o[0][1]]
				def newNode = o[0][0]
				def r = defStmtsPerArg_(taintGraph, invoc, newGraphlet, [newNode]).flatten()

				acc.addAll(r)

				if(r == [] ){
					acc << stmt
				}

			}
		}
		acc
	}
}
