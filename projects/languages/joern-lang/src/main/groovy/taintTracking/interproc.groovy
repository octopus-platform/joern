import java.util.regex.Pattern;

/******************************************************
 * Steps for interprocedural analysis
 * Experimental and subject to change.
 ******************************************************/

/**
 * Identity for non-parameters.
 * For parameters, expand into caller arguments.
 **/

expandParameters = {

	_().transform{
	  if(it.type == 'Parameter'){
		def l = it.parameterToCallerArgs().toList();
		if(l != []) l else it._().toList()
	  }
	  else
	   it._().toList()
	}.scatter()

}

/**
 For a given parameter, get all nodes of arguments of callers.
*/

parameterToCallerArgs = {
   _().transform{
	   paramNum = it.childNum;
	   funcName = it.functions().name.toList()[0];

	   funcName = funcName.split(' ')[-1].trim()
	   funcName = funcName.replace('*', '')

	   getCallsTo(funcName).ithArguments(paramNum)
   }.scatter()
}


/**
 * Identity for nodes that do not contain arguments.
 * For arguments, descend into called function
 * parameters.
 **/

expandArguments = {
	_().transform{

	  def args = it.match{ it.type == "Argument"}.toList()

	  if(args != []){
			def l = args._().argToParameters().toList();
			if(l != []) l else it._().toList()
	  }else
	   it._().toList()
	}.scatter()
}

argToParameters = {
	_().transform{
		argNum = it.childNum;
		def callee = it.argToCall().callToCallee().code.toList()[0]
		callee = callee.replace('* ', '')
		// callee = callee.split("(::)|(\\.)")[-1].trim()
		callee = callee.split(' ')[-1].trim()

		getFunctionASTsByName(callee)
		.children().filter{ it.type == "ParameterList"}
		.children().filter{ it.childNum == argNum}.toList()
	}.scatter()
}


/**
 * For a given call-site, return statements in the callee
 * that taint arguments, i.e., assign to the function's parameters.
 * */

argTainters = {

	_().transform{

		def params = it.taintedArguments().expandArguments().toList();

		if(params == [])
			return []._()

		symbols = params._().transform{ x = it.code.split(' '); x[1 .. ( x.size()-1)].join(' ') }.toList()
		params[0]._().toExitNode().producers(symbols).toList()
	}.scatter()


}

/**
 * For a given call-site, return arguments that are tainted.
 * */

taintedArguments = {
	_().callToArguments()
	.filter{ it.defines().toList() != [] }
}


checks = { def args -> def regex = args[0];

	_().as('y').match{ it.type in ['EqualityExpression', 'RelationalExpression', 'PrimaryExpression', 'UnaryOp'] }
	.back('y').uses().filter{ it.code.matches('.*' + Pattern.quote(regex) + '.*') }

}

checksRaw = { def args -> def regex = args[0]

	_().as('y').match{ it.type in ['EqualityExpression', 'RelationalExpression', 'PrimaryExpression', 'UnaryOp'] }
	.back('y').uses().filter{ it.code.matches(regex) }


}

calls = { def args -> def regex = args[0];

	_().match{ it.type in ['Callee'] }
	.filter{ it.code.matches('.*' + Pattern.quote(regex) + '.*') }
}

codeMatches = { def args -> def regex = args[0]; def s = args[1]
	s = Pattern.quote(s)
	if(regex.contains("%s"))
		_().filter{it.code.matches(String.format(regex, s)) }
	else
		_().filter{it.code.matches(regex) }
}

NO_RESTRICTION = { a,s -> []}
ANY_SOURCE = { [1]._() }

source = { closure ->
  return { if(closure(it)) [10] else [] }
}

sourceMatches = { regex ->
  return {
		if(it.apiSyms().filter{ it.matches(regex) }.toList())
			return [10]
		if( it.code.matches(regex) )
			return [10]
		return []
  }
}
