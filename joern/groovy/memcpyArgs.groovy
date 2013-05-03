
import java.util.regex.Pattern

import CodeDatabase
c = new CodeDatabase()
g = c.getDbLink()

// all calls to memcpy

memcpyCalls = astNodes("CallExpression").filter{it.code.matches('.*memcpy.*')}.as("x")

r = memcpyCalls.function().sideEffect
{
  filename = it.filename;
  signature = it.signature
}.back('x')

r = r.out().filter{it.type == "ArgumentList"}.outE().filter
{
  it.n == "2"
}.inV().sideEffect{ arg = it.code}.back('x')

paths = r.basicBlock().pathsFromEntry().transform
{
  ret = []
  it.each()
  {
    // if(it.code.matches('.*' + Pattern.quote(arg) + '.*') )
    ret << [it.type, it.code]  
  }
  [ret, arg, filename, signature];
}.toList()

for (path in paths)
{
  typeCodeList = path[0]
  arg = path[1]
  filename = path[2]
  signature = path[3]

  println filename + " " + signature + " " + typeCodeList
}

g.shutdown()
