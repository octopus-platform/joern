
import CodeDatabase


c = new CodeDatabase()
g = c.getDbLink()

mallocsInAssignments = astNodes("AssignmentExpr").filter{it.code.matches('.*malloc.*')}
l = mallocsInAssignments.outE('AST_CHILD').filter{ it.n.equals("0") }inV().code  //.inV().code.toList()

for(x in l)
{
  println x;
}



g.shutdown();
