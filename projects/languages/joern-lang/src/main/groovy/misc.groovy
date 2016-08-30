
hasRegex = { args ->
	property = args[0];
	regex = args[1];
	delegate.has(property, textRegex(regex))
}

In = { def args ->

 def edgeType = args[0];
 def key = args[1];
 def vals = args[2];

	if(Collection.isAssignableFrom(vals.getClass())){
		filterExpr = { it.getProperty(key) in vals }
	}else{
		filterExpr = {it.getProperty(key) == vals}
	}

	_().inE(edgeType).filter(filterExpr).outV()
}

Out = { def args ->

  def edgeType = args[0];
  def key = args[1];
  def vals = args[2];

	if(Collection.isAssignableFrom(vals.getClass())){
		filterExpr = { it.getProperty(key) in vals }
	}else{
		filterExpr = {it.getProperty(key) == vals}
	}

	_().outE(edgeType).filter(filterExpr).inV()
}


/**
   Map node ids to nodes
*/

idsToNodes = {
	_().transform{ g.v(it) }
}

keysToNodes = {
	delegate.map{ g.V.has('_key', it).toList()[0] }
}

/**
   Map node ids to nodes
*/

idsToEdges = {
	_().transform{ g.e(it) }.scatter()
}

/**
   Create nodes from a list of node ids
*/

idListToNodes = { listOfIds ->

  g.V(*listOfIds)

}

keyListToNodes = { listOfKeys ->

 _().transform{ listOfKeys }.scatter().keysToNodes()
}

/**
   Create nodes from a list of node ids
*/

idListToEdges = { def args -> def listOfIds  = args[0];
  _().transform{ listOfIds }.scatter().idsToEdges()
}

isCheck = { def args -> symbol = args[0];

   _().astNodes().filter{ it.type in ['EqualityExpression', 'RelationalExpression'] }
   .filter{ it.code.matches(symbol) }
}

codeContains = { def args -> symbol = args[0];
	_().filter{it.code != null}.filter{ it.code.matches(symbol) }
}

/**
 * Traverse to all API symbols from given AST nodes.
 **/

apiSyms = {
	_().match{it.type in ['Callee','IdentifierDeclType', 'Parameter']}.code
}

/**
 * Like 'flatten' but only flatten by one layer.
 * */

flattenByOne = { def args -> lst = args[0];
	lst.inject([]) {acc, val-> acc.plus(val)}
}


_or = { def args -> Object [] closures = args[0];

	_().transform{
		def ret = []
		closures.each{ cl ->
			def x = cl(it).toList()
			ret.addAll(x)
		}
		flattenByOne(ret.unique())
	}.scatter()
}


/**
 For a given list, create a reverse
 index that maps list items to the indices
 they occur at.
*/

createReverseIndex = { aList ->
	def reverseIndex = [:]
	aList.eachWithIndex{ item, i ->
		if (!reverseIndex.containsKey(item)){ reverseIndex[item] = [] }
		reverseIndex[item] << i
	}
	reverseIndex
}

compareLists = { x, y ->
	if(x == y) return 0
	return 1
}
