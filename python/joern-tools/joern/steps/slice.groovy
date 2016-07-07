Gremlin.defineStep('forwardSlice', [Vertex, Pipe], { symbols,
		     ORDER = 5, edgeTypes = ['REACHES', 'CONTROLS'] ->
  	_()
	.copySplit(
	  	_(),
	  	_().sideEffect{first = true;}.as('x')
		.transform{
			  it.outE(*edgeTypes)
			  .filter{it.label == 'CONTROLS' || !first || it.var in symbols}
			  .inV().gather{it}.scatter()
			  .sideEffect{first = false}
		}.scatter()
		.loop('x'){it.loops <= ORDER}{true}
	).fairMerge()
	.dedup()
});

Gremlin.defineStep('backwardSlice', [Vertex, Pipe], { symbols,
		     ORDER = 5, edgeTypes = ['REACHES', 'CONTROLS'] ->
	_()
	.copySplit(
		_(),
		_()
		.sideEffect{first = true;}.as('x')
		.transform{
			it.inE(*edgeTypes)
			.filter{it.label == 'CONTROLS' || !first || it.var in symbols}
			.outV().gather{it}.scatter()
			.sideEffect{first = false}
		}.scatter()
		.loop('x'){it.loops <= ORDER}{true}
	).fairMerge()
	.dedup()
});

/**
   Starting from an argument node, slice backwards, but for data flow,
   consider only the symbols actually used in the argument.
*/

Gremlin.defineStep('sliceBackFromArgument', [Vertex, Pipe], { ORDER = 5, edgeTypes = ['REACHES', 'CONTROLS'] ->
	_().transform{
		symbols = it.uses().code.toList();
		it.statements().backwardSlice(symbols, ORDER, edgeTypes)
	}.scatter()
})

/**
   Starting from an argument node, slice forward, but for data flow,
   consider only the symbols actually used in the argument.
*/

Gremlin.defineStep('sliceForwardFromArgument', [Vertex, Pipe], { ORDER = 5, edgeTypes = ['REACHES', 'CONTROLS'] ->
	_().transform{
		symbols = it.uses().code.toList();
		it.statements().forwardSlice(symbols, ORDER, edgeTypes)
	}.scatter()
})

/**
   Slice forward from assignment, but for data flow, consider only the
   symbols defined on the left-hand side of the assignment.
*/

Gremlin.defineStep('sliceForwardFromAssign', [Vertex, Pipe], { ORDER = 5, edgeTypes = ['REACHES', 'CONTROLS'] ->
	_()
	.transform
	{
      		callee = it.code;
      		symbols = it.lval().code.toList()
		it.statements().forwardSlice(symbols, ORDER, edgeTypes)
	}.scatter()
})
