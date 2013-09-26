
Gremlin.defineStep('callToCallee', [Vertex, Pipe], {
 _().outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()
})

Gremlin.defineStep('callToArgumentN', [Vertex,Pipe], { n -> 
 _().out('IS_AST_PARENT').filter{it.type == 'ArgumentList'}
 .outE('IS_AST_PARENT').filter{ it.n == n }.inV()
})

Gremlin.defineStep('callToFunctions', [Vertex,Pipe], {
 _().callToCallee().transform{ getFunctionByName(it.code) }.scatter()
})

Gremlin.defineStep('argToCallee', [Vertex,Pipe], {
 _().in('IS_AST_PARENT').filter{ it.type == 'ArgumentList'}
 .in('IS_AST_PARENT').outE('IS_AST_PARENT').filter{ it.n == '0' }.inV()
})

