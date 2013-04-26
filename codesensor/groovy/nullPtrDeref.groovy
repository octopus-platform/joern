PATH_TO_DATABASE = '/home/fabs/tmp/neo4j/';
g = new Neo4jGraph(PATH_TO_DATABASE);
index = g.idx("typeIndex");

def astNodes_(index,typeName) { return index[[type:typeName]]; };
astNodes = astNodes_.curry(index);
Gremlin.defineStep('functionDef', [Vertex,Pipe], { _().in('AST_CHILD').loop(1){it.object.type != "FunctionDef"} } );


astNodes("CallExpression").filter{it.code.matches('^malloc.*')}.functionDef();

g.shutdown();
