
/**
 This is how you _would_ directly query the index, but don't ever do that.
*/

// queryNodeIndex = { query ->
//   __.inject(*graph.indexQuery('byTypeAndValue', query).vertices()*.getElement())
// }

/**
   Retrieve functions by name.

   @param name name of the function
*/

getFunctionsByName = { name ->
	getNodesWithTypeAndCode(TYPE_FUNCTION, name)
}

getFunctionsByFilename = { name ->

     g.V().has(NODE_TYPE, TYPE_FILE)
     	.has(NODE_CODE, name)
	.out(FILE_TO_FUNCTION_EDGE)
	.has(NODE_TYPE, TYPE_FUNCTION)
}

getNodesWithTypeAndCode = { type, code ->

	g.V().has(NODE_TYPE, type)
	   .has(NODE_CODE, code)
}

getFunctionsByFileAndName = { filename, name  ->
	getFunctionsByFilename(filename)
	.has(NODE_CODE, name)
}

getFilesByName = { filename ->	
	g.V().has(NODE_TYPE, TYPE_FILE).has(NODE_CODE, filename)
}

/**
   Retrieve calls by name.

   @param callee Name of called function

*/

getCallsTo = { callee ->

  getNodesWithTypeAndCode(TYPE_CALLEE, callee)
  .calleeToCall()

}

getCallsToRegex = { regex ->
 g.V().has(NODE_TYPE, TYPE_CALLEE).has(NODE_CODE, textRegex(regex))
 .calleeToCall()
}

/**
   Retrieve arguments to functions. Corresponds to the traversal
   'ARG' from the paper.

   @param name Name of called function
   @param i Argument index

*/

getArguments = { name, i ->
	getCallsTo(name).ithArguments(i)
}

