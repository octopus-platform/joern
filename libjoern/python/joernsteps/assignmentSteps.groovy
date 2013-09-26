
Gremlin.defineStep('assignmentToLval', [Vertex,Pipe], {
 _().outE('IS_AST_PARENT').filter{ it.n.equals("0") }.inV()
});

Gremlin.defineStep('assignmentToRval', [Vertex,Pipe], {
 _().outE('IS_AST_PARENT').filter{ it.n.equals("1") }.inV()
});
