
Gremlin.defineStep('subASTsOfType', [Vertex, Pipe], { t -> def types = t;		     
  // _().copySplit(
    _().out('IS_AST_PARENT')
    .loop(1){it.object.out('IS_AST_PARENT').toList() != [] }{ it.object.type in types }
    // _().filter{ it.type in types}
    // ).exhaustMerge()
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

Object.metaClass.containsSymbol = { it, symbol ->
  it.code.matches(".*" + "(?<![a-zA-Z0-9_])" + Pattern.quote(symbol) + '(?!([a-zA-Z0-9_]))' + ".*")  
}

// This is useful when checking if a patch DOES NOT exist.
// You can then use a .filter{!exists(pipe)} step.
// Not that it is not necessary for the positive case, i.e., when you
// want to know whether a path exists. In that case, the pipe can
// simply be appended to the existing pipe.

Object.metaClass.exists = { it ->  it.toList().size != 0 }

