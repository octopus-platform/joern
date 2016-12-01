/**
   Elementary traversals for the function symbol graph
*/

/**
  Get all symbols used by an AST-node/statement.
*/

uses = {
	_().out(USES_EDGE)
}

usesFiltered = {
	
	_().transform{
		L = it.out(USES_EDGE).toList();
		L.sort{ a, b -> a.code.size() <=> b.code.size() }
		L = L.reverse()
	
		acc = []
		L.each{ node ->
		        // if(node.code.startsWith('*')) return;
			if(acc.findAll{ it.code.contains(node.code) }.size() != 0) return;
			acc << node; 
		}

		acc
	}.scatter()
	
}

defines = {
	_().out(DEFINES_EDGE)
}

/**
  Get all statements assigning a value to a symbol.
*/

setBy = {
	_().in(DEFINES_EDGE)
}

/**
 Get all definitions affecting an AST-node/statement.
*/

definitions = {
	_().uses().in(DEFINES_EDGE)
	.filter{it.type in [TYPE_IDENTIFIER_DECL_STMT, TYPE_PARAMETER] }
}
