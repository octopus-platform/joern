!include("gremtest.groovy")

test("toExitNode", {
	astnode =
		g.V().has('type','Function').has('code','popa_ex_2_5')
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.has('code','a = a + 1')
		.next()
	functionId = astnode.value('functionId')
	exitnode_expected =
		g.V().has('functionId',functionId)
		.has('type','CFGExitNode')
		.next()
	exitnode_found =
		__.inject(astnode)
		.toExitNode()
		.next()
	assertEquals(exitnode_found,exitnode_expected)
})

test("toExitNodeMultipleFunctionsPreserveOrder", {
	astnodes =
		g.V().has('type','Function').has('code',textRegex('popa_ex_2_.'))
		.functionToAST()
		.astNodes()
		.has('type','AssignmentExpression')
		.or( has('code','a = a + 1'), has('code','x = x - 1'))
		.collect()
	functionIds = astnodes.collect{ it.value('functionId') }
	exitnodes_expected =
		functionIds.collect{ fid ->
			g.V().has('type','CFGExitNode')
			.has('functionId',fid).next()
		}
	exitnodes_found =
		__.inject(*astnodes)
		.toExitNode()
		.collect()
	assertEquals(exitnodes_found,exitnodes_expected)
})


run_tests()
