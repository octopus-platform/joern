
class Condition{
	def cndId;
	def syms;
	def normalizedAST;
	def id;
	
	Condition(i,symbols, graphObj)
	{
		cndId = i; syms = symbols;
		id = cndId.toString() + syms.toString();
		normalizedAST = new ASTNode(i, syms, graphObj)
	}

	public boolean equals(java.lang.Object other)
	{
		if (other == null) return false
		if (this.is(other)) return true
		if (!(other instanceof Condition)) return false
		if (!other.canEqual(this)) return false
		if (cndId != other.cndId) return false
		if(syms != other.syms) return false
		return true
	}

	public boolean canEqual(java.lang.Object other)
	{
		return other instanceof Condition
	}
	
	public String getCode()
	{
		normalizedAST.getCode()
	}
	
}

/**
 * For a given invocation, generate checks per argument.
 * The result is a list with (narguments + 1) entries, one
 * for each argument and a trailing 'other'-group. Each
 * of these entries is a list of Conditions.
 * */

genConditionsPerArg = { taintGraph, invoc ->
	def graphlet = taintGraph[invoc[0]]
	def args = graphlet.args
	checksPerArg_(taintGraph, invoc, graphlet, args)
}


checksPerArg_ = { def taintGraph, invoc, curGraphlet, args ->

	def edges = curGraphlet.edges
	def extEdges = curGraphlet.extEdges
	def argToCnd = curGraphlet.argToCnd
	def conditions = curGraphlet.conditions
	
	def parentOthers = []

	def retval = args.collect{ def arg ->

		def vars = idListToNodes(edges[arg]).code.toList()
		def acc = argToCnd[arg].collect{ def c = new Condition(it, vars, g);
										 curGraphlet.cndIdToObject[it] = c; }

		edges[arg].each{ def var -> edges[var].each{ def stmt ->

				if(!extEdges.containsKey(stmt)){ return }

				def o = extEdges[stmt].findAll{ invoc.contains(it[1]) };
				if(o == []){return }

				def newGraphlet = taintGraph[o[0][1]]
				def newNode = o[0][0]

				def r = checksPerArg_(taintGraph, invoc, newGraphlet, [newNode])

				if(r.size() > 0){
					acc.addAll( flattenByOne(r.take(r.size() - 1)))
					parentOthers.addAll(r[r.size() -1])
				}
				// acc.unique{ a,b -> a.equals(b) }
				
			}
		}
		acc
	}

	// now add 'others'

	def others = parentOthers.collect() + conditions.collect{ def c = new Condition(it, [], g);
															  curGraphlet.cndIdToObject[it] = c; }
	args.eachWithIndex{ a, i -> others = others.minus(retval[i])}

	retval << others
	retval

}

/**
 From a node, determine all conditions that control its execution
*/

controllingConditions = { def args -> def order = 1; if(args.size() > 0) order = args[0];
  
  _().statements().as('x').in('CONTROLS').loop('x'){it.loops <= order}
	  {it.object.type == 'Condition'}
	  .dedup()
}
