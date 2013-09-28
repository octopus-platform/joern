
Gremlin.defineStep('parameterToName', [Vertex, Pipe], {
 _().out('IS_AST_PARENT').filter{ it.type == 'Identifier' }
})
