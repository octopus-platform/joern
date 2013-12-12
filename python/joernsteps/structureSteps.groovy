
// This first step is horrible as we use a regex to parse the
// struct part from the type and chop off the postfix

Gremlin.defineStep("structureToName", [Vertex,Pipe], {
  _().transform{ (it.code =~/struct ([^\s]+)/)[0][1] }
})

Gremlin.defineStep("structureToMemberDecls", [Vertex,Pipe], {
  _().out('IS_CLASS_OF').filter{it.type == 'DeclStmt'}.out()
})

Object.metaClass.isStruct = {
  it.code.startsWith('struct ') && !it.code.contains('*')
}

Object.metaClass.numTypesInStructure = {
  it.structureToMemberDecls().baseType.dedup().toList().size()
}
