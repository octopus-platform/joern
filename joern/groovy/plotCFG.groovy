import CodeDatabase;

import com.tinkerpop.gremlin.groovy.*
import com.tinkerpop.blueprints.*
import com.tinkerpop.pipes.*;
import com.tinkerpop.pipes.util.*;
import com.tinkerpop.pipes.transform.*;

import com.tinkerpop.blueprints.Direction;

def nodeIds = [];
def nodeCode = [];
def nodeType = []
def curNodeId;
def curCode;
def curNodeType;

codeDb = new CodeDatabase()
g = codeDb.getDbLink()

def storeBasicBlockInfo = 
{ it ->
  curNodeId = it.id; nodeIds << curNodeId;
  curCode = it.code; nodeCode << curCode;
  curNodeType = it.type; nodeType << curNodeType;
}

def normalizeCode = { code -> 
  if(code == null) code = "";
  code = code.replace('\\', '\\\\');
  code = code.replace('"', '\\"')
  code;
}

function = g.idx('functionIndex')[[functionName:args[0]]][0]

edges = function.funcBasicBlocks().sideEffect{
  storeBasicBlockInfo(it);
}.out('FLOW_TO').transform{ [curNodeId, it.id] }.toList()

printf("digraph myGraph{");
for (i = 0; i < nodeCode.size(); i++)
{
  code = normalizeCode(nodeCode[i])
  printf('node%s [label="%s: %s"]\n', nodeIds[i], nodeType[i], code)
}

for (edge in edges)
{
  (srcId, dstId) = edge
  printf('"node%s":s->"node%s":n;\n', srcId, dstId); 
}
printf("}\n");

g.shutdown();
