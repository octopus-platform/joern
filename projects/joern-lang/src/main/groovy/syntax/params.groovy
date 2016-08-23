
paramsToNames = {
	_().children().filter{ it.type != 'ParameterType'}
}

paramsToTypes = {
	_().children().filter{ it.type == 'ParameterType'}
}
