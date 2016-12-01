!include("gremtest.groovy")

test("astNodes_on_leaf", {
	identifiers =
	g.V().has('type','Function').has('code','test_astnodes')
	.functionToAST()
	.astNodes()
	.has('type','Identifier')
	.collect()
	subnodes = __.inject(identifiers[0])
		.astNodes()
		.collect()

	assertEquals(subnodes,[identifiers[0]])
})

test("astNodes_on_root", {
	traversed_nodes =
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.collect() as Set

	functionId = traversed_nodes[0].value('functionId')

	all_function_ast_nodes =
		g.V().has('functionId',functionId)
		.has('type',P.not(P.within('CFGEntryNode','CFGExitNode','Symbol')))
		.collect() as Set

	assertEquals(traversed_nodes,all_function_ast_nodes)
})

test("ithChildren", {
	children_found =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','ArgumentList')
		.ithChildren('1')
		.map{ [ it.get().value(NODE_CHILDNUM), it.get().value('type'), it.get().value('code') ] }
		.collect()
	children_expected = [ ['1','Argument','"Hello %s!\\n"' ] ]
	assertEquals(children_found,children_expected)
})

test("siblings_single_node", {
	parent = 
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.next()
	children = __.inject(parent).out(AST_EDGE).collect()

	siblings_expected = (children - children[0]) as Set
	siblings_found =
		__.inject(children[0])
		.siblings()
		.collect() as Set

	assertEquals(siblings_found, siblings_expected)
})

test("siblings_of_siblings", {
	parent = 
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.next()
	children = __.inject(parent).out(AST_EDGE).collect()
	siblings_expected =
		(children - children[0]) + (children - children[1]) as Set
	siblings_found =
		__.inject(children[0],children[1])
		.siblings()
		.collect() as Set
	assertEquals(siblings_found, siblings_expected)
})

test("statements_from_leaf_ast_node", {
	leafnode =
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','Identifier')
		.collect()[-1]
	functionId = leafnode.value('functionId')
	cfgnode_expected = 
		g.V()
		.has('functionId',functionId)
		.has('isCFGNode','True')
		.has('type',P.not(P.within('CFGEntryNode','CFGExitNode')))
		.next()
	cfgnode_found =
		__.inject(leafnode)
		.statements()
		.next()

	assertEquals(cfgnode_found, cfgnode_expected)
})

test("statements_from_cfg_node", {
	cfgnode =
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','ExpressionStatement')
		.collect()[-1]
	cfgnode_found =
		__.inject(cfgnode)
		.statements()
		.next()

	assertEquals(cfgnode_found, cfgnode)
})

test("lval", {
	lvalnode =
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.lval()
		.values('code')
		.next()
	assertEquals(lvalnode, "x")
})

test("rval", {
	rvalnode =
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.rval()
		.values('code')
		.next()
	assertEquals(rvalnode, "8 * ++ a - b")
})

test("callToArguments", {
	args_found =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.callToArguments()
		.map{ [ it.get().value('childNum'), it.get().value('type'), it.get().value('code') ]}
		.collect() as Set
	args_expected = [ ['0', 'Argument', 'STDERR'],
		['1', 'Argument', '"Hello %s!\\n"'],
		['2', 'Argument', 'name']] as Set
	assertEquals(args_found, args_expected)
})

test("ithArguments", {
	args_found =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.ithArguments('1')
		.map{ [ it.get().value('childNum'), it.get().value('type'), it.get().value('code') ]}
		.collect() as Set
	args_expected = [ ['1', 'Argument', '"Hello %s!\\n"'] ] as Set
	assertEquals(args_found, args_expected)
})

test("argToCall", {
	callnode_expected =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.next()
	callnode_found = __.inject(callnode_expected)
		.ithArguments('1')
		.argToCall()
		.next()
	assertEquals(callnode_found, callnode_expected)
})

test("callToCallee", {
	callee =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.callToCallee()
		.map{ [ it.get().value('childNum'), it.get().value('type'), it.get().value('code') ]}
		.collect()
	assertEquals(callee, [['0','Callee','fprintf']])
})

test("calleeToCall", {
	callnode_expected =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.next()
	functionId = callnode_expected.value('functionId')
	callnode_found = 
		g.V().has('type','Callee').has('functionId',functionId)
		.calleeToCall()
		.next()
	assertEquals(callnode_found, callnode_expected)
})

test("callToAssigns", {

	assignmentnodes_expected = 
		g.V().has('type','Function').has('code','test_funccall_from_assignment')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.collect() as Set

	assignmentnodes_found =
		g.V().has('type','Function').has('code','test_funccall_from_assignment')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.callToAssigns()
		.collect() as Set

	assertEquals(assignmentnodes_found, assignmentnodes_expected)
})

test("callToAssignsNested", {

	assignmentnodes_expected = 
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.collect() as Set

	assignmentnodes_found =
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.callToAssigns()
		.collect() as Set

	assertEquals(assignmentnodes_found, assignmentnodes_expected)
})

test("matchParents", {

	nodes_expected = 
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','AdditiveExpression')
		.collect() as Set

	nodes_found =
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.matchParents( has('type','AdditiveExpression') )
		.collect() as Set

	assertEquals(nodes_found, nodes_expected)
})


test("matchParentsEnclosingStatement", {

	nodes_expected = 
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','ExpressionStatement')
		.collect() as Set

	nodes_found =
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','CallExpression')
		.matchParents( has('type','ExpressionStatement') )
		.collect() as Set

	assertEquals(nodes_found, nodes_expected)
})

test("matchParentsEnclosingStatementOnSelf", {

	node_expected = 
		g.V().has('type','Function').has('code','test_funccall_from_nested_assignment')
		.functionToAST()
		.astNodes()
		.has('type','ExpressionStatement')
		.next()

	nodes_found =
		__.inject(node_expected)
		.matchParents( has('type','ExpressionStatement') )
		.collect() as Set

	assertEquals(nodes_found, [node_expected] as Set)
})

test("arg", {
	arg_expected =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','ArgumentList')
		.ithChildren('2')
		.next()
	arg_found = 
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.arg('fprintf','2')
		.next()
	assertEquals(arg_found, arg_expected)
})

test("param", {
	param_expected =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','Parameter')
		.has('code','char * name')
		.next()
	param_found = 
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.param('.* name')
		.next()
	assertEquals(param_found, param_expected)
})

test("paramsToNames", {
	paramnames_expected =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','ParameterType')
		.siblings()
		.next()
	paramnames_found = 
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','Parameter')
		.paramsToNames()
		.next()
	assertEquals(paramnames_found, paramnames_expected)
})

test("paramsToTypes", {
	paramtypes_expected =
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','ParameterType')
		.next()
	paramtypes_found = 
		g.V().has('type','Function').has('code','test_funccall')
		.functionToAST()
		.astNodes()
		.has('type','Parameter')
		.paramsToTypes()
		.next()
	assertEquals(paramtypes_found, paramtypes_expected)
})

test("paramsToTypesDeclarationOnly", {
	paramtypes_expected =
		g.V().has('type','Function').has('code','declared_function')
		.functionToAST()
		.astNodes()
		.has('type','ParameterType')
		.collect()
	paramtypes_found = 
		g.V().has('type','Function').has('code','declared_function')
		.functionToAST()
		.astNodes()
		.has('type','Parameter')
		.paramsToTypes()
		.collect()
	assertEquals(paramtypes_found, paramtypes_expected)
})

test("paramsToNamesDeclarationOnly", {
	paramnames_expected =
		g.V().has('type','Function').has('code','declared_function')
		.functionToAST()
		.astNodes()
		.has('type','Parameter')
		.children()
		.not(has('type','ParameterType'))
		.collect()
	paramnames_found = 
		g.V().has('type','Function').has('code','declared_function')
		.functionToAST()
		.astNodes()
		.has('type','Parameter')
		.paramsToNames()
		.collect()
	assertEquals(paramnames_found, paramnames_expected)
})

test("unfold_bug_on_ast_nodes", {
	identifier_and_nodes = g.V()
	.has('type','Function').has('code','popa_ex_2_5')
	.functionToAST()
	.astNodes()
	.identity()
	.as('astnode')
	.emit{ it.get().value('type') == 'Identifier' }
	.repeat(out(AST_EDGE))
	.as('identifier')
	.select('astnode','identifier')
	.collect{ it['astnode'] }

	assertNotEquals(identifier_and_nodes[-1].getClass(), [].getClass())
})

test("statements_followed_by_astnodes", {
	leafnode =
		g.V().has('type','Function').has('code','test_astnodes')
		.functionToAST()
		.astNodes()
		.has('type','Identifier')
		.collect()[-1]
	cfgnode = __.inject(leafnode).statements().next()
	astnodes_expected = __.inject(cfgnode).astNodes().collect() as Set;

	astnodes_found = __.inject(leafnode).statements().astNodes().collect() as Set;
	assertEquals(astnodes_found, astnodes_expected);
})



run_tests()

