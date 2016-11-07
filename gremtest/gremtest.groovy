import groovy.transform.Field;
import org.codehaus.groovy.runtime.StackTraceUtils;

@Field def gremtest_results = []
@Field def gremtest_result_count = [ 'pass':0, 'fail':0, 'error':0 ]

//
// The test runner function. Used internally.
//
def do_test( name, testclosure ) {
	red = '\u001b[31;1m'
	green = '\u001b[32;1m'
	yellow = '\u001b[33;1m'
	reset = '\u001b[0m'
	try {
		testclosure()
		gremtest_result_count['pass']++
		sprintf "%-35s: ${green}PASS${reset}", name
	} catch (AssertionError e) {
		gremtest_result_count['fail']++
		sprintf "%-35s: ${red}FAIL${reset}\n%s", [name,e.getMessage()]
	} catch (Exception e) {
		gremtest_result_count['error']++
		sw = new StringWriter()
		pw = new PrintWriter(sw)
		StackTraceUtils.printSanitizedStackTrace(e,pw)
		sprintf "%-35s: ${yellow}ERROR${reset}\n%s\n%s", [name, e.getMessage(), sw.toString() ]
	}
}

//
// test(name, testclosure, enable=true)
//
// Executes a test (if enable is true) and collects the results. Tests are
// defined as a closure. The optional parameter enable can be used to disable
// a test.
//
def test( name, testclosure, enable=true ) {
	if (enable) {
		r = do_test(name,testclosure)
		gremtest_results << r
	}
}

//
// summarize the collected results and return it to the caller. Use this as
// the last command in your test script.
//
def run_tests () {
	gremtest_results << sprintf ("%d pass, %d fail, %d error(s)", gremtest_result_count['pass'], gremtest_result_count['fail'], gremtest_result_count['error'])
	gremtest_results
}

//
// Assertions
//

// check a condition which is defined as a closure.
def assertCond(condition,found,expected) {
	assert condition(found,expected)
}

def assertEquals(found,expected) {
	assert found == expected
}

def assertNotEquals(found,expected) {
	assert found != expected
}


