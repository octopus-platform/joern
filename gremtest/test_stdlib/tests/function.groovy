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

run_tests()
