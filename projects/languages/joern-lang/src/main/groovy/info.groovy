
locations = {
	_()
	.statements().sideEffect{code = it.code }
	.functions().sideEffect{ name = it.name; }
	.functionToFiles().sideEffect{ filename = it.filepath; }
	.transform{ [code, name, filename] }
}

functions = {

	delegate.functionId.map{ g.V.has('_key', it).toList()[0] }
}


functionToFiles = {
	_().in(FILE_TO_FUNCTION_EDGE)
}

