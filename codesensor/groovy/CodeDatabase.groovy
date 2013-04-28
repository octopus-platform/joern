import com.tinkerpop.gremlin.groovy.*
import com.tinkerpop.blueprints.*
import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph
import com.tinkerpop.blueprints.impls.neo4j.Neo4jIndex
import com.tinkerpop.pipes.Pipe;

import org.neo4j.kernel.EmbeddedReadOnlyGraphDatabase
  
public class CodeDatabase
{
  
  String PATH_TO_DATABASE = '/home/fabs/tmp/neo4j/';
  Graph g;
  Neo4jIndex typeIndex;
  
  public CodeDatabase(){
    Gremlin.load()
    g = new Neo4jGraph(PATH_TO_DATABASE); 
    // def db = new EmbeddedReadOnlyGraphDatabase(PATH_TO_DATABASE)
    // g = new Neo4jGraph(db)
    typeIndex = g.idx("typeIndex");
    
    defineCustomSteps();
  
    Object.metaClass.astNodes = astNodes;

  }
  
  def astNodes = { typeName ->
    typeIndex[[type:typeName]]
  };

  def outClosure = {
    _().transform{ tree(0, [it] ) }
  }
  
  def tree = { parentId, vertices ->
    
    def results = []; 
    vertices.each()
    {    
      results << [it.id, it.type, it.code, parentId];
      def children = it.out().toList();
    
      if (children) {
	def child_tree = tree(it.id, children);
	results.addAll(child_tree);
      }
    }
    results;
  }
  
  private defineCustomSteps()
  {
    
    
    Gremlin.defineStep('functionDef', [Vertex,Pipe],{
			 _().in('AST_CHILD').loop(1){it.object.type != "FunctionDef"} } );
    
    Gremlin.defineStep('function', [Vertex, Pipe], {_().functionDef().in()})

    Gremlin.defineStep('basicBlock', [Vertex,Pipe], { _().in().loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });

    Gremlin.defineStep('lval', [Vertex,Pipe], { _().outE('AST_CHILD').filter{ it.n.equals("0") }inV()});
    
    Gremlin.defineStep('pathsToExit', [Vertex,Pipe], { _().out('FLOW_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})
    
    Gremlin.defineStep('pathsFromEntry', [Vertex,Pipe], { _().in('FLOW_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    
    
    Gremlin.defineStep("AST", [Vertex,Pipe], outClosure);   
    
    Gremlin.defineStep("funcBasicBlocks", [Vertex,Pipe], { _().outE('BASIC_BLOCK').inV()})
  }

  def getDbLink() { g; }
  def getTypeIndex() { typeIndex; }

}

// g.v(1106181).as('x').outE('FLOW_TO').inV.loop('x'){ it.object.outE('FLOW_TO').toList() != [] }.path
