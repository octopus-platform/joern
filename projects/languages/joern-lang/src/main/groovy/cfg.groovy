
/**
   For an AST node, traverse to the exit-node
   of the function
*/
addStep("toExitNode", {
  delegate.flatMap{
    functionId = it.get().value('functionId')
    g.V().has('type','CFGExitNode').has('functionId',functionId)
  }
})

/**
   Search the CFG breadth-first so that we can keep track of all nodes we've visited in
    the entire search rather than just along the current path (massive optimization for
    high branching-factor CFGs, e.g. state machines).
*/
_reachableCfgNodes = { def args ->

  def curNodes = args[0]; def visited = args[1];
  nextNodes = curNodes._().out('FLOWS_TO').toSet() - visited
  if (nextNodes.isEmpty()) { return visited }

  visited.addAll(nextNodes)
  return _reachableCfgNodes(nextNodes.toList(), visited)
}

reachableCfgNodes = {
  _().transform { _reachableCfgNodes(it.statements().toList(), new HashSet())}.scatter()
}

isInLoop = { it ->
  it._().reachableCfgNodes().toSet().contains(it.statements().toList()[0])
}
