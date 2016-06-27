/**
   Retrieve nodes from index using a Lucene query.

   @param query The lucene query to run
*/
queryNodeIndex = { luceneQuery ->

	queryStr = 'SELECT * FROM V WHERE [childNum,code,filepath,functionId,key,location,name,nodeType] LUCENE "' + luceneQuery + '"';
	query = new com.orientechnologies.orient.core.sql.OCommandSQL(queryStr);
	g.getRawGraph().command(query).execute().toList()._().transform{ g.v(it.getIdentity()) }
}

/**
   Retrieve functions by name.
   
   @param name name of the function
*/

getFunctionsByName = { name ->
	getNodesWithTypeAndName(TYPE_FUNCTION, name)
}

getFunctionsByFilename = { name ->
	query = "$NODE_TYPE:$TYPE_FILE AND $NODE_FILEPATH:$name"
	queryNodeIndex(query)
	.out('IS_FILE_OF')
	.filter{ it.type == TYPE_FUNCTION }
}

getNodesWithTypeAndName = { type, name ->
	query = "$NODE_TYPE:$type AND $NODE_NAME:$name"
	queryNodeIndex(query)
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

getNodesWithTypeAndCode = { type, code ->
	query = "$NODE_TYPE:$type AND $NODE_CODE:$code"
	queryNodeIndex(query)
}
