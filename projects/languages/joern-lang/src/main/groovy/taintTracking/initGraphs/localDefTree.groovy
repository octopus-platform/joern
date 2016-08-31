
// Referred to as `local def tree` in the paper

class Graphlet{
	def edges; 		// edges in the local def tree
	def extEdges;   // edges to other graphlets
	def leaves;
	def args;
	def conditions;
	def argToCnd;
	def cndIdToObject = [:]
}

/**
 Create a graphlet:

 argSet: set of argument ids
 vars: map from argIds to list of variables used
 defStmts: map from variables to def-statements

 The resulting tree is rooted at a callId-node
 that is linked to all argument nodes. These are
 in turn linked to variable nodes, which are linked
 to def-statements.

*/

createGraphlet = { argSet, callId ->

	(vars, defStmts) = varsAndDefStmts(argSet, callId)
	
	if(argSet.size() == 0) return;
	
	def graphlet = new Graphlet()
	
	// Note: 'symbolsUsed' are all symbols used by the condition,
	// not the sub-condition as usage information is not available
	// per sub-tree.
		
	// For each defStmt, get controlling conditions
	
	def cndUsesPairs = defStmts.values().flatten().collect{ g.v(it) }
				
				._().controllingConditions(1)
				.sideEffect{ symbolsUsed = it.usesFiltered().id.toList() }
				.transform{ subConditions(it.id) }.scatter()
				.transform{ [it, symbolsUsed.collect()] }.toList()
				.sort()
	
	
	// For call-site, get controlling conditions
				
	cndUsesPairs.addAll(g.v(argSet[0])
						._().controllingConditions(3)
						.sideEffect{ symbolsUsed = it.usesFiltered().id.toList() }
						.transform{ subConditions(it.id) }.scatter()
						.transform{ [it, symbolsUsed.collect()] }.toList()
						.sort())
	
	cndUsesPairs.sort()
	
	def conditions = cndUsesPairs.collect{ it[0] }
	
	
	def leafNodes = defStmts.values().flatten().sort().unique()
	def edges = [:]

	// create edges from conditions to variables
	// it uses.

	cndUsesPairs.each{ edges[it[0]] = it[1] }

	edges[(callId)] = []
	argSet.each{ edges[(callId)] << it }

	argSet.eachWithIndex{ arg, i ->
		if(!edges[(arg)]){ edges[(arg)] = [] }
		vars[i].each{ edges[(arg)] << it }
	}

	defStmts.each{ varId, stmtIds ->
		if(!edges[(varId)]){ edges[(varId)] = [] }
		stmtIds.each{ edges[(varId)] << it }
	}


	// create map from conditions to arguments that consume a variable
	// used in the condition

	def argToCnd = [:]

	argSet.each{ def arg ->
		argToCnd[arg] = []
		conditions.each{ def cond ->
			if(!edges[cond].disjoint(edges[arg])){
				argToCnd[arg] << cond
			}
		}
	}

	graphlet.args = argSet
	graphlet.edges = edges
	graphlet.leaves = leafNodes
	graphlet.conditions = conditions
	graphlet.argToCnd = argToCnd

	graphlet
}

varsAndDefStmts = { argSet, callId ->
	
	
	// For each argument, determine variables used.
	// (The .dedup is a precaution and should not be
	// neccessary.)

/*	def vars = argSet.collect{ g.v(it)._().usesFiltered().id.dedup().toList() }
	def varsCode = argSet.collect{ g.v(it)._().usesFiltered().code.dedup().toList() }.flatten()
	def defStmts = [:]

	// For each variable used, determine direct DEF-statements
	// (There can be several direct DEF statements for a variable)

	vars.flatten().eachWithIndex { varId, i ->
		X = directDefs(callId, varsCode[i])
	if(X.size() > 0){ defStmts[varId] = X }
	}
	[vars, defStmts]*/
	
	
	def vars = []
	def defStmts = [:]
	def visited = []
	def varsForArg = []
	
	// Perform depth-first traversal for each
	// argument independently
	
	argSet.each{ arg ->
		
		def nodes = [[arg, 0]]
		varsForArg = []
		visited = []
		
		while(nodes.size() > 0){
			def curNode = nodes.remove(0)
			def newNodes = varsAndDefExpand(curNode, varsForArg, defStmts, visited)
			nodes.addAll(newNodes.collect())
		}
			
		vars.add(varsForArg.collect())
	}
	
	[vars.collect(), defStmts]
}

varsAndDefExpand = { curNode, varsForArg, defStmts, visited ->
	
	def newDefs = []
	
	(nodeId, depth) = curNode
	
	if(depth == 1) // MAXDEPTH-parameter
		return newDefs
			
	if(nodeId in visited)
		return newDefs
	visited.add(nodeId)
	
	def node = g.v(nodeId)
	
	if(node.type == "Argument"){
		
		def symbolNodeIds = getSymbolNodeIds(node)
		varsForArg.addAll(symbolNodeIds.collect())
		varsForArg.unique()
		def statementId = getCallId(node.id)
		newDefs = expandSymbolNodes(symbolNodeIds, statementId, defStmts)
		
	}else{
	
		def symbolNodeIds = getSymbolNodeIds(node)
		varsForArg.addAll(symbolNodeIds.collect())
		varsForArg.unique()
		def statementId = node._().statements().id.toList()[0]
		newDefs = expandSymbolNodes(symbolNodeIds, statementId, defStmts)
	
	}
	
	return newDefs.collect{ [it, depth + 1] }
}

getSymbolNodeIds = {node ->
	node._().usesFiltered().id.dedup().toList()
}

expandSymbolNodes = { symbolNodeIds, statementId, defStmts ->
	
	def newDefs = []
	
	symbolNodeIds.each{ symbolNodeId ->
		def node = g.v(symbolNodeId)
		def varCode = node.code
		def defsForSymbol =  directDefs(statementId, varCode)
			
		defsForSymbol.each{ it ->
			if(defStmts[symbolNodeId] == null)
				defStmts[symbolNodeId] = []
			defStmts[symbolNodeId].add(it)
			defStmts[symbolNodeId].unique()
		}
		
		newDefs.addAll(defsForSymbol)
	}
	
	newDefs.unique()
	return newDefs
}


/**
 Get directly connected reaching definitions of
 variable `variable` and node with given id.
*/

directDefs = { id, variable ->
	g.v(id)._().statements()
	.sideEffect{ srcId = it.id; }
	.In("REACHES", "var", [variable] ).id.filter{ it != srcId}.toList().sort()
	// .backwardSlice([(variable)], 1, ['REACHES']).id.filter{ it != srcId}.toList()
}

