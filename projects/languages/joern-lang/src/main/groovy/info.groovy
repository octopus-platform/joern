
GraphTraversal.metaClass.locations = {
	delegate
	.statements().sideEffect{code = it.code }
	.functions().sideEffect{ name = it.name; }
	.functionToFiles().sideEffect{ filename = it.code; }
	.map{ [code, name, filename] }
}

GraphTraversal.metaClass.functions = {

	delegate.values('functionId').map{ g.V().has('_key', it).toList()[0] }
}


GraphTraversal.metaClass.functionToFiles = {
	delegate.in(FILE_TO_FUNCTION_EDGE)
}

