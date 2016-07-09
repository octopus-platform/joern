
locations = {
	_()
	.statements().sideEffect{code = it.code }
	.functions().sideEffect{ name = it.name; }
	.functionToFiles().sideEffect{ filename = it.filepath; }
	.transform{ [code, name, filename] }
}

functions = {
	_().functionId.keysToNodes()
}

functionToFiles = {
	_().in(FILE_TO_FUNCTION_EDGE)
}

