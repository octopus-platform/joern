

Gremlin.defineStep('getASTNodes', [Vertex,Pipe], { _().transform{ nodesOfTree([it]) }.scatter() } );

public nodesOfTree(ArrayList vertices)
{
  def results = []; 
  vertices.each()
  { 
    results << it;
    def children = it.out('IS_AST_PARENT').toList();
    if(children){
      def childNodes = nodesOfTree(children);
      results.addAll(childNodes);
    }
  }
  results;
}
