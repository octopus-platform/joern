
import java.util.regex.Pattern

import CodeDatabase
c = new CodeDatabase()
g = c.getDbLink()

def lvals = []

mallocAssigns  = astNodes("AssignmentExpr").filter{it.code.matches('.*[^_]malloc.*')}.as('assign')
r = mallocAssigns.function().sideEffect { storeFunctionInfo() }.back('assign')
r = r.lval().sideEffect { storeLval() }.back('assign')

paths = r.basicBlock().pathsToExit().transform{
  ret = []
  it.each() { if(it.code.matches('.*' + Pattern.quote(lval) + ".*")) ret << [it.type, it.code]    }
  [ret, lval, filename, signature];
}.toList()

for (path in paths)
{
  typeCodeList = path[0]
  lval = path[1]
  filename = path[2]
  signature = path[3]
  
  if(typeCodeList.size() > 0 && typeCodeList[0][0] == 'ConditionBB')
    continue;

  typeCodeList.remove(0);

  for (elem in typeCodeList){   
    type = elem[0]
    if(type != "ConditionBB"){
      println filename + " " + signature + " " + lval
      break;
    }
    break;
  }
  
}

def storeFunctionInfo =
{
  filename = it.filename;
  signature = it.signature
}

def storeLval =
{
  lval = it.code;
}

g.shutdown();
