
import CodeDatabase;

import com.tinkerpop.gremlin.groovy.*
import com.tinkerpop.blueprints.*
import com.tinkerpop.pipes.*;
import com.tinkerpop.pipes.util.*;
import com.tinkerpop.pipes.transform.*;

def printDotAST = { ast ->
  
  printf("digraph myGraph{");
  for(node in ast){
    (id, type, code, parentId) = node;
    
    code = code.replace('\\', '\\\\');
    code = code.replace('"', '\\"')
    
    printf('node%s [label="%s: %s"]\n',id, type, code);
    printf('"node%s":s->"node%s":n;\n', parentId, id);
  };
  printf("}\n");
  
}

codeDb = new CodeDatabase()
g = codeDb.getDbLink()

functions = g.idx('functionIndex')[[functionName:args[0]]].out('AST_ROOT')
ast = functions[0].AST().toList()[0]

printDotAST(ast)

g.shutdown();