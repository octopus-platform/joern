
import CodeDatabase;

import com.tinkerpop.gremlin.groovy.*
import com.tinkerpop.blueprints.*
import com.tinkerpop.pipes.*;
import com.tinkerpop.pipes.util.*;
import com.tinkerpop.pipes.transform.*;

codeDb = new CodeDatabase()
g = codeDb.getDbLink()

ast = g.astNodes("FunctionDef")[0].AST().toList()[0];

printf("digraph myGraph{");
for(node in ast){
  (id, type, code, parentId) = node;
  
  code = code.replace('\\', '\\\\');
  code = code.replace('"', '\\"')
  
  printf('node%s [label="%s: %s"]\n',id, type, code);
  printf('"node%s":s->"node%s":n;\n', parentId, id);
};
printf("}\n");

g.shutdown();