!include("gremtest.groovy")

test("functionToLocationStr", {
	func =
		g.V().has('type','Function').has('code','function_location_1')
		.next()
	loc_found =
		__.inject(func)
		.functionToLocationStr()
		.next()
	prefix = loc_found.find("^.*testdata.tar.gz/src/")
	loc_expected = prefix + "testdata/test_function.c:" + func.value('location')

	assertEquals(loc_found,loc_expected)
})

test("functionToStatements", {
	func =
		g.V().has('type','Function').has('code','function_with_loop_1')
		.next()
	func_id = func.value("_key")
	cfg_nodes_expected = g.V().has('isCFGNode','True').has('functionId',func_id).collect() as Set

	cfg_nodes_found = __.inject(func).functionToStatements().collect() as Set
	assertEquals(cfg_nodes_found,cfg_nodes_expected)
})

test("functionToStatementsAfterLoopingTraversal", {
	func =
		g.V().has('type','Function').has('code','function_with_loop_1')
		.next()
	func_id = func.value("_key")
	cfg_nodes_expected = g.V().has('isCFGNode','True').has('functionId',func_id).collect() as Set

	cfg_nodes_found = __.inject(func)
		.out('IS_FUNCTION_OF_CFG')
		.in('IS_FUNCTION_OF_CFG')
		.functionToStatements()
		.collect() as Set

	assertEquals(cfg_nodes_found,cfg_nodes_expected)
})

test("functionToStatementsDuplicate", {
	func =
		g.V().has('type','Function').has('code','function_with_loop_1')
		.next()
	func_id = func.value("_key")
	cfg_nodes_expected = g.V().has('isCFGNode','True').has('functionId',func_id).collect() as Set

	cfg_nodes_found = __.inject(func, func)
		.functionToStatements().collect()

	assertEquals(cfg_nodes_found as Set,cfg_nodes_expected)
	assertEquals(cfg_nodes_found.size(),cfg_nodes_expected.size()*2)
})


run_tests()
