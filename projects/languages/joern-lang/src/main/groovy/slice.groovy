forwardSlice = { def args -> 
	     def symbols = args[0];
	     def ORDER = 5; if(args.size() > 1) ORDER = args[1];
	     def edgeTypes = ['REACHES', 'CONTROLS']; if(args.size() > 2) edgeTypes = args[2];
	     
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
}

backwardSlice = { def args -> 
	     def symbols = args[0];
	     def ORDER = 5; if(args.size() > 1) ORDER = args[1];
	     def edgeTypes = ['REACHES', 'CONTROLS']; if(args.size() > 2) edgeTypes = args[2];
	      
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
}

/**
   Starting from an argument node, slice backwards, but for data flow,
   consider only the symbols actually used in the argument.
*/

sliceBackFromArgument = { def args -> 
	     def symbols = args[0];
	     def ORDER = 5; if(args.size() > 1) ORDER = args[1];
	     def edgeTypes = ['REACHES', 'CONTROLS']; if(args.size() > 2) edgeTypes = args[2];
	      
	_().transform{
		symbols = it.uses().code.toList();
		it.statements().backwardSlice(symbols, ORDER, edgeTypes)
	}.scatter()
}

/**
   Starting from an argument node, slice forward, but for data flow,
   consider only the symbols actually used in the argument.
*/

sliceForwardFromArgument = { def args -> 
	     def symbols = args[0];
	     def ORDER = 5; if(args.size() > 1) ORDER = args[1];
	     def edgeTypes = ['REACHES', 'CONTROLS']; if(args.size() > 2) edgeTypes = args[2];

	_().transform{
		symbols = it.uses().code.toList();
		it.statements().forwardSlice(symbols, ORDER, edgeTypes)
	}.scatter()
}

/**
   Slice forward from assignment, but for data flow, consider only the
   symbols defined on the left-hand side of the assignment.
*/

sliceForwardFromAssign = { def args -> 
	     def symbols = args[0];
	     def ORDER = 5; if(args.size() > 1) ORDER = args[1];
	     def edgeTypes = ['REACHES', 'CONTROLS']; if(args.size() > 2) edgeTypes = args[2];
	_()
	.transform
	{
      		callee = it.code;
      		symbols = it.lval().code.toList()
		it.statements().forwardSlice(symbols, ORDER, edgeTypes)
	}.scatter()
}


///

functionToAPISymbolNodes = {
        _() // Function node
        .functionToASTNodes()
        .filter{it.type == 'IdentifierDeclType' || it.type == 'ParameterType' || it.type == 'Callee' || it.type == 'Sizeof'}
}


edgesInX = { def X, labels = [] -> 
	 X._().transform{ g.v(it) }
	.outE().filter{ labels == [] || labels.contains(it.label) }
	.filter{
		def p = it._().inV().id.toList()[0]
		X.contains(p.toString())
	}.id
}
