class ASTNode{
	def label;
	def children = [];
	def g;
	def id;
	def taintedSymbols;
	
	ASTNode(nodeId, symbols, graphObj)
	{
		taintedSymbols = symbols
		id = nodeId;
		g = graphObj;
		def chldren = initLabel(nodeId, symbols)
		children = chldren.collect{ new ASTNode(it, symbols, graphObj) }
	}
	
	/**
	 * This functions labels AST nodes. Labeling
	 * includes normalization.
	 * */
	
	def initLabel(nodeId, symbols)
	{
		def node = g.v(nodeId)
		
		// relabel tracked argument to '_ARG_'
		if(node.code in symbols){
			label = "QUERYGEN_ARG"
			return []
		}
		
		// Make sure not to walk into arguments.
		
		// if(node.type == 'CallExpression'){
		//	label = 'Callee: ' + node._().callToCallee.code.toList()[0]
		//	return []
		// }
		
		def chldren = node.children().id.toList()
		if(chldren.size() != 0 || node.code == null){
			label = node.type
		}else{
			label = node.code
			// Relabel numbers to '_NUM_'
			if(node.type == 'PrimaryExpression' && node.code.matches('[0-9]+'))
				label = 'QUERYGEN_NUM'
		}
		chldren
	}

	public String getCode()
	{
		
		def nodeCode = g.v(id).code
		taintedSymbols.each{
			def quotedSymbol = Pattern.quote(it)
			nodeCode = nodeCode.replaceAll('^' + quotedSymbol, '%s')
			nodeCode = nodeCode.replaceAll(quotedSymbol + '$', '%s')
			nodeCode = nodeCode.replaceAll(" " + quotedSymbol + " ", '%s')
		}
		
		nodeCode = nodeCode.replaceAll('(^| )[0-9]+( |$)', "(\\\\d+)")
		nodeCode = nodeCode.replaceAll(' (<|>)=? ', ' (<|>)=? ')
		nodeCode = nodeCode.replaceAll(' (==|!=) ', ' (==|!=) ')
		nodeCode = nodeCode.replaceAll('! ', '')
		nodeCode
	}
			
}

/**
 * For a given AST node, obtain all children recursively.
 **/

Object.metaClass.allASTNodes = { astNode ->
	def X = [astNode]
	X.addAll(astNode.children.collect{ allASTNodes(it) }.flatten())
	X
}
