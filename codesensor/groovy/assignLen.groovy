import java.util.regex.Pattern
import CodeDatabase
c = new CodeDatabase()
g = c.getDbLink()

l = astNodes("AssignmentExpr").sideEffect
{
  code = it.code;
}.as('x').lval().filter
{
  it.code.matches('.*len.*')
}.back('x').function().filter
{
  it.functionName.matches('.*parse.*')
}.sideEffect{
  println it.filename + ' ' + it.functionName + ': ' + code
}.toList()

g.shutdown()