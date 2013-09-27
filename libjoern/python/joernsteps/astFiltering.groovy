
Gremlin.defineStep('subASTsOfType', [Vertex, Pipe], { t -> def types = t;		     
  _().copySplit(
    _().out('IS_AST_PARENT')
    .loop(1){it.object.out('IS_AST_PARENT').toList() != [] }{ it.object.type in types },
    _().filter{ it.type in types}
  ).fairMerge()
})

Gremlin.defineStep('astsOfTypeMatch', [Vertex, Pipe], { mPipe, Object [] t ->
  def matchPipe = mPipe;
  def types = t;
  return _().subASTsOfType().mPipe().toList() != []
})


Gremlin.defineStep('filterCodeByRegex', [Vertex,Pipe], { expr -> 
  _().filter{ it.code.matches(expr) }
})

Gremlin.defineStep('filterCodeByCompiledRegex', [Vertex,Pipe], { regex ->
 _().filter{ regex.matcher(it.code).matches() }
})

Gremlin.defineStep('codeContains', [Vertex,Pipe], { x ->
  _().filter{ it.code.matches(x) }
})

Object.metaClass.codeContains = { obj, x ->
  obj.code.contains(x)
}
