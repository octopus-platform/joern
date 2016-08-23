
/**
   Retrieve functions by name.

   @param name name of the function
*/

getFunctionsByName = { name ->
	getNodesWithTypeAndName(TYPE_FUNCTION, name)
}

getFunctionsByFilename = { name ->

     g.V.has(NODE_TYPE, TYPE_FILE)
	 .filter{ it.filepath == name }
	 .out('IS_FILE_OF')
	 .filter{ it.type == TYPE_FUNCTION }
}

getNodesWithTypeAndName = { type, name ->
	g.V.has(NODE_TYPE, type).filter{ it.name == name}
}

getFunctionsByFileAndName = { filename, name  ->
	getFunctionsByFilename(filename)
	.filter{ it.name == name }
}

getFilesByName = { filename ->
	query = "$NODE_TYPE:$TYPE_FILE AND $NODE_FILEPATH:$filename"
	queryNodeIndex(query)
}

/**
   Retrieve calls by name.

   @param callee Name of called function

*/

getCallsTo = { callee ->

  getNodesWithTypeAndCode(TYPE_CALLEE, callee)
  .parents()

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

getNodesWithTypeAndCode = { def type, def code ->
	query = "$NODE_TYPE:$type AND $NODE_CODE:$code"
	queryNodeIndex(query)
}
