import CodeDatabase;

// Extract a func -> API-symbols map
// and a func -> symbols map and save

codeDb = new CodeDatabase()
g = codeDb.getDbLink()

def addToDictMap = { M, key, code ->
  if(M.get(key) == null){
    M.put(key, new HashMap<String, Integer>())
  }
  m = M.get(key);
  if(m.get(code) == null){
    m.put(code, 0) 
  }
  m.put(code,  m.get(code) + 1);

}

identifier2FuncMap = new HashMap<String, List<String>>();

func2API = new HashMap<String, HashMap<String, Integer>>();
def addToAPIMap = addToDictMap.curry(func2API)

functions = codeDb.astNodes("Function").sideEffect{
  name = it.functionName; loc = it.location; filename = it.filename;
}.back(1)

functions.funcASTNodes().filter{
  it.type in ['CallExpression', 'IdentifierDeclType', 'ParameterType']
}.sideEffect{  
  if(it.type != 'CallExpression'){
    code = it.code
  }else{
    code = it.out('AST_CHILD').filter{ it.type != 'ArgumentList'}.code.toList().get(0).toString()
  }
  
  key = filename + '/'+ name + ':' + loc
  addToAPIMap(key,code);
}.toList()

outputMap(func2API);

private void outputMap(m)
{
  for (entry in m){ 
    k = entry.getKey();
    
    println "/NEWFUNC " +  k
    val = entry.getValue();
    for(v in val)
    {
      println v.getKey() + "\t" + v.getValue();
    }
  }
}


g.shutdown()
