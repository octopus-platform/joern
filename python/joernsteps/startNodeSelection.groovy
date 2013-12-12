
//////////////////////////////////////////////////////////////////////
// Start Node Selection (Coarse Node Selection)
// The following are utility functions for Gremlin/Groovy scripts,
// which you can use to select start-nodes for your analysis. For
// example, you might want to start with all function definitions, all
// calls to a specific function or all instances of variables of a
// certain type.
//////////////////////////////////////////////////////////////////////

/**
   Query the node index.
   @param query Lucene query
*/

Object.metaClass.queryNodeIndex = { query ->
  index = g.getRawGraph().index().forNodes("nodeIndex")
  new Neo4jVertexSequence(index.query(query), g)._()
}

/**
   Retrieve all nodes of a specified type from the node index.
   @param typeName type
*/

Object.metaClass.getNodesByType = { typeName ->
  g.idx("nodeIndex")[[type:typeName]]
}

////////////////////////////////
///// Functions ///////
///////////////////////////////

/**
   Retrieve function by name.
   @param aName name
*/

Object.metaClass.getFunctionByName = { aName ->
  g.idx('nodeIndex')[[functionName:aName]]
}

/**
   Retrieve function by name matching regular
   expression.
   @param aNameRegex regular expression function names must match.
*/

Object.metaClass.getFunctionByNameRegex = { aNameRegex ->
  getNodesByType("Function").filter{ it.functionName.matches(aNameRegex) }
}

//////////////////////////////////
////// Parameters //////
/////////////////////////////////

Object.metaClass.getParametersOfType = { typeName ->
  query = 'type:"ParameterType" AND code:"' + typeName + '"'
  queryNodeIndex(query).in('IS_AST_PARENT')
}

Object.metaClass.getParameterByRegex = { aNameRegex ->
  getNodesByType("Parameter").filter{ it.code.matches(aNameRegex) }
}

Object.metaClass.getParameterByNameRegex = { aNameRegex ->
  getNodesByType("Parameter").out('IS_AST_PARENT').filter{ it.type == 'Identifier' && it.code.matches(aNameRegex) }
}

/////////////////////////////
//////// Calls //////////
////////////////////////////

/**
   Retrieve all calls by callee.  This is more efficient than
   'getCallsToRegex' but less powerful, allowing only exact matches of
   callee names. If we had 'Callee'-nodes, this would be a lot more efficient.

  @param callee identifier of the callee
*/

Object.metaClass.getCallsTo = { callee ->
  query = 'type:"CallExpression" AND code:' + callee + '*'
  queryNodeIndex(query).filter
  {
    it.code.startsWith(callee + ' ')
  }
}

/**
   Retrieve all calls by regular expression To match a regex, we can
   only use the index to extract all CallExpressions. We then need to
   iterate over all call expressions to see where the regex matches.

   @param callee regular expression callees must match.
   
 */
 
Object.metaClass.getCallsToRegex = { callee ->
  getNodesByType("CallExpression").filterCodeByCompiledRegex(Pattern.compile(callee))
}

//////////////////////////
//// Arguments to calls
//////////////////////////

/**
   Retrieve n'th arguments to calls by callee.
   
   @param callee callee
   @param n the parameter number (a String)
*/

Object.metaClass.getArgumentNTo = { callee, n ->
  getCallsTo(callee).callToArgumentN(n)
}


/**
   Retrieve declaration by name.
   @param aName name
*/

Object.metaClass.getTypeDeclsByName = { aName ->
  g.idx('nodeIndex')[[name:aName]]
}

Object.metaClass.getAssignmentsByRegex = { aRegex ->
  getNodesByType('AssignmentExpr').filterCodeByCompiledRegex(Pattern.compile(aRegex))
}
