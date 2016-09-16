
addStep("paramsToNames", {
	delegate.children().not(has('type','ParameterType'))
})

addStep("paramsToTypes", {
	delegate.children().has('type','ParameterType')
})
