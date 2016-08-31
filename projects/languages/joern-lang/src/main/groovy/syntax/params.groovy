
paramsToNames = {
	delegate.children().filter{ it.type != 'ParameterType'}
}

paramsToTypes = {
	delegate.children().filter{ it.type == 'ParameterType'}
}
