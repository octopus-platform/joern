
Gremlin.defineStep("functionToFile", [Vertex,Pipe], { _().in('IS_FILE_OF') })

Gremlin.defineStep("functionToAST", [Vertex,Pipe], { _().out('IS_FUNCTION_OF_AST') })

Gremlin.defineStep("functionToASTRoot", [Vertex,Pipe], {
_().functionToAST().out('IS_AST_OF_AST_ROOT')
})

Gremlin.defineStep("functionToASTNodes", [Vertex,Pipe], {
 _().transform{ queryNodeIndex('functionId:' + it.id)}.scatter()
 .filter{ it.type != 'BasicBlock' && it.type != 'Symbol'}
})

Gremlin.defineStep("functionToAllASTNodesOfType", [Vertex, Pipe], { aType -> 
 _().functionToASTNodes().filter{ it.type == aType}
})

Gremlin.defineStep("functionToBasicBlocks", [Vertex,Pipe], {
 _().transform{ queryNodeIndex('type:BasicBlock AND functionId:' + it.id) }
 .scatter()
})


Gremlin.defineStep("functionToSymbols", [Vertex,Pipe], {
 _().transform{ queryNodeIndex('type:Symbol AND functionId:' + it.id) }
 .scatter()
})

Gremlin.defineStep("functionToParameters", [Vertex,Pipe], {
 _().transform{ queryNodeIndex('type:Parameter AND functionId:' + it.id) }
 .scatter()
})

Gremlin.defineStep("functionToParameterList", [Vertex,Pipe], {
 _().getFunctionASTRoot().outE('IS_AST_PARENT').filter{ it.n == '1'}.inV()
})

Gremlin.defineStep("functionToParameterN", [Vertex,Pipe], { n ->
 _().functionToParameterList().outE('IS_AST_PARENT').filter{ it.n == n}.inV()
})

Gremlin.defineStep("functionToParameterNType", [Vertex,Pipe], { n ->
 _().functionToParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()
})

Gremlin.defineStep("functionToParameterNName", [Vertex,Pipe], { n -> 
 _().functionToParameterN(n).outE('IS_AST_PARENT').filter{ it.n == '1'}.inV()
})

Gremlin.defineStep("functionToCalls", [Vertex,Pipe], {
 _().functionToAllNodesOfType('CallExpression')
})

Gremlin.defineStep("functionToCallsTo", [Vertex,Pipe], { x ->
  _().functionToCalls().filter{ it.code.startsWith(x + ' ')}
})

Gremlin.defineStep("functionToCallsToAnyOf", [Vertex,Pipe], { l ->
 _().functionToCalls().filter{
   for(x in l){ if(it.code.startsWith(x + ' ')) return true; };
   return false;
 }
})

Gremlin.defineStep('functionToCallsToRegex', [Vertex,Pipe], { callee ->
 _().functionToASTNodes().filter{ it.type == 'CallExpression' && it.code.matches(callee) }
})

Gremlin.defineStep("functionToConditions", [Vertex,Pipe], {
_().transform{
  ret = []
  ret = it.functionToAllNodesOfType('Condition').toList() 
  ret.addAll(it.functionToAllNodesOfType('ConditionalExpression')
             .outE('IS_AST_PARENT').filter{ it.n == "0"}.inV().toList())
  ret;
  }.scatter()
})

Gremlin.defineStep("functionToLocals", [Vertex,Pipe], {
 _().functionToASTNodes().filter{it.type == 'IdentifierDecl'}
})

Gremlin.defineStep("functionToLocalTypes", [Vertex,Pipe], { _().functionToLocals().localToType() } )
Gremlin.defineStep("functionToLocalNames", [Vertex,Pipe], { _().functionToLocals().localToName() } )

Gremlin.defineStep('functionToASTNodesOfType', [Vertex,Pipe], { t ->
 _().functionToASTNodes().filter{ it.type == t}
});

Gremlin.defineStep('functionToIdentifiers', [Vertex,Pipe], {
 _().functionToASTNodesOfType('Identifier')
})

Gremlin.defineStep("functionToLocationRow", [Vertex,Pipe], {
  _().functionToFile()
  .sideEffect{fname = it.filepath; }.back(2).transform{ [fname, it.location, it.signature] }
})

Gremlin.defineStep("functionToAllNodesOfType", [Vertex, Pipe], { aType ->
  
  _().transform{ queryNodeIndex('type:' + aType + ' AND functionId:' + it.id) }.scatter()
})

Gremlin.defineStep("filterByFunctionName", [Vertex, Pipe], { fExpr ->
  def filterExpression = fExpr;
  _().astNodeToFunction().filter{it.functionName.matches(fExpr)}.back(2)
})
