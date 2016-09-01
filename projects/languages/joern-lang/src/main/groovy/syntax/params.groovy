
GraphTraversal.metaClass.paramsToNames = {
	delegate.children().filter{ it.type != 'ParameterType'}
}

GraphTraversal.metaClass.paramsToTypes = {
	delegate.children().filter{ it.type == 'ParameterType'}
}
