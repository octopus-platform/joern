
/**
   Traversals Composition
*/

/**
   OR-composition for lookups: returns a pipe emitting nodes from both
   pipes. Please note that if both traversals return the same object,
   the object will be emitted twice. You can use 'dedup' to filter
   duplicates.
   
   @param: lookup1 First lookup to perform, a function returning a pipe.
   @param: lookup1 Second lookup to perform, a function returning a pipe.
   
*/

OR = { lookup1, lookup2 ->
	
	[1]._().copySplit( _().transform{ lookup1 }.scatter(),
	       _().transform{ lookup2 }.scatter()
	).fairMerge()
}	

/**
   Pipe which filters nodes from functions also matching the traversal
   supplied in the closure `cl`

   @param cl The closure containing the traversal
   
*/

not = { def args -> def cl = args[0]; def c = []; if(args.size > 1) c = args[1];
	
        X = []; Y = []
	_().aggregate(X) // Watchout! aggregation!
	._emitForFunctions(cl, c)
	.functionId.gather{ Y = it; }
	.transform{ X }.scatter().filter{ !(it.functionId in Y) }
}


/**
	Executes the closure `cl` which is expected to return a
	pipe of nodes. Returns a pipe containing all of these nodes
	which match the boolean predicate `c`.

	@param cl The closure to execute
	@param c  The predicate to evaluate on nodes returned by cl.
*/

_emitForFunctions = { def args -> def cl = args[0]; def c = args[1];

	if(c == [])
		c = {it.functionId in ids}
	
	// aggregation is performed before the
	// call because otherwise, we do the
	// lookup for each element.
	// We should consider offering an
	// alternative step that does not aggregate.

	_().functionId.gather()
	.transform{
		ids = it;
		cl().filter(c)
	}.scatter()
}

pairs = { def args -> def x = args[0]; def y = args[1];
  
	odd = true;

	_().copySplit(x, y).fairMerge()
	.transform{
		if(odd){
			pair = it
			odd = false;
			return 'none' ;
		}else{
			pair = [pair, it]
			odd = true;
			return pair;
		}			
	}.filter{ it != 'none' }

}
