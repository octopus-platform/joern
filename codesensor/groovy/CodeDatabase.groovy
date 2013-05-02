import com.tinkerpop.gremlin.groovy.*
import com.tinkerpop.blueprints.*
import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph
import com.tinkerpop.blueprints.impls.neo4j.Neo4jIndex
import com.tinkerpop.pipes.Pipe;

import org.neo4j.kernel.EmbeddedReadOnlyGraphDatabase
  
public class CodeDatabase
{
  
  String PATH_TO_DATABASE = '/home/fabs/.joernIndex/';
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

  def getAST = {
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
    
    // For a given AST-node, get the FunctionDef AST node
    // by expanding parents until the node is reached.
    
    Gremlin.defineStep('functionDef', [Vertex,Pipe],{
			 _().in('AST_CHILD').loop(1){it.object.type != "FunctionDef"} } );
    
    // For a given AST-node, get the function-node by first
    // obtaining the FunctionDef AST-node and then taking the parent
    
    Gremlin.defineStep('function', [Vertex, Pipe], {_().functionDef().in()})
    
    // For a given AST-node, get the basic-block this AST-node is part of

    Gremlin.defineStep('basicBlock', [Vertex,Pipe], { _().in().loop(1){ it.object.out('IS_BASIC_BLOCK_OF').toList() ==[]  }  });
    
    // For an assignment AST-node, get the lval-node

    Gremlin.defineStep('lval', [Vertex,Pipe], { _().outE('AST_CHILD').filter{ it.n.equals("0") }inV()});
    
    // For a given basic block, get all paths into the exit direction
    // up to and inlcuding a length of 10
    
    Gremlin.defineStep('pathsToExit', [Vertex,Pipe], { _().out('FLOW_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})
    
    // For a given basic block, get all paths into the entry direction
    // up to and inlcuding a length of 10
    
    Gremlin.defineStep('pathsFromEntry', [Vertex,Pipe], { _().in('FLOW_TO').loop(1){it.loops < 10 }{true}.simplePath.path()})    
    
    // Starting from an AST-node, extract the AST rooted
    // at that node

    Gremlin.defineStep("AST", [Vertex,Pipe], getAST);   
    
    // Get all basic blocks of a function

    Gremlin.defineStep("funcBasicBlocks", [Vertex,Pipe], { _().outE('BASIC_BLOCK').inV()})

    // Get all AST-nodes of a function

    Gremlin.defineStep("funcASTNodes", [Vertex,Pipe], { _().outE('AST_NODE').inV()})

  }

  def getDbLink() { g; }
  def getTypeIndex() { typeIndex; }

}

