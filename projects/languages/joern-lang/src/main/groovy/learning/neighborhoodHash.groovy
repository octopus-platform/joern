/**
   Implementation of the explicit Neighborhood Hash Kernel for joern.
   ------------------------------------------------------------------
   
   See:
   * http://ieeexplore.ieee.org/xpls/abs_all.jsp?arnumber=5360243&tag=1
   * http://user.informatik.uni-goettingen.de/~krieck/docs/2013b-aisec.pdf
   
*/


LABEL_MASK = 0xffff
LABEL_WIDTH = 16 // TODO: calculate this from mask


/**
   Create sparse feature vectors for ASTs rooted at the
   given AST nodes. Currently, we perform two iterations of
   neighborhood hashing, meaning that we characterize each node
   of the AST by its children up to depth 2.
*/

featureVectors = {
	_().transform{
		def vec = [:]
		labels = NH(NH(NHGraph(it)))[1]
		labels.values().each { vec[it] = (vec[it] ?: 0) + 1 }
		libsvmString(vec)
	}
}

/**
   Transform a dictionary ("sparse vector") into
   a corresponding libsvm line.
*/

libsvmString = { vec ->
  vec.entrySet().sort{ x,y -> x.getKey() <=> y.getKey() }.
  inject(""){ acc, val -> acc + val.getKey() + ':' + val.getValue() + ' ' }
}

/**
 Create an initial graph for the neighborhood hash kernel starting
 from an AST root node
*/

NHGraph = { it ->
	
	def children = [:]
	def labels = [:]
	
	def X = it.astNodes().transform{ [it.id, it.astLabel().toList()[0],
			   it.children().id.toList() ] }.toList()
	for (x in X){
		nodeId = x[0]
		label = x[1]
		childIds = x[2]
		
		children[nodeId] = childIds
		labels[nodeId] = label
	}

	[children, labels]
}

/**
	Update an NH-graph, i.e., perform one iteration
	of neighborhood hashing.
*/

NH = { it ->
	
	def children = it[0]
	def labels = it[1]
	def newLabels = [:]
	
	def nodeIds = children.keySet()
	
	for(nodeId in nodeIds){
		nodeLabel = labels[nodeId]
		rotNodeLabel = rotate(nodeLabel)
		c = children[nodeId]
		newLabels[nodeId] = c.inject(rotNodeLabel) { acc, val -> acc ^ labels[val] }
	}
	
	[children, newLabels]
}

rotate = { label ->
	((label << 1) | ((label >>> (LABEL_WIDTH - 1) & 0x1 ))) & LABEL_MASK
}

hashVal = { s ->
	s.hashCode() & LABEL_MASK
}

astLabel = {
	_().transform{
		
		if(numChildren(it) != 0 || it.code == null)
		  hashVal(it.type)
		else{
			if(it.type == 'PrimaryExpression' && it.code.matches('[0-9]+'))
				return hashVal('A_NUMBER')
			
			hashVal(it.code)
			}
		}
}
