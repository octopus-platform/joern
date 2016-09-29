# Testing Gremlin queries

Gremtest is a shell script that lets you test Gremlin queries against an Octopus server.

## Usage

```
Usage:
	./gremtest [ -s | -t ] [ -n ] test(suite) ...

	-s | --suite : run specified testsuites. If no testsuites are
		specified, run all available testsuites. This is the
		default mode.
	-t | --test : run specified testcases.
	-n | --no-import : do not load the test data in the Octopus server.
		Saves execution time, but may let tests fail because the
		correct test data is not loaded. Be careful using it.
```


## Directory structure

Gremtest assumes the following directory layout for test suites:

```
├── test_stdlib
│   ├── testdata
│   │   ├── test_cfg.c
│   │   ├── test_function.c
│   │   └── test_syntax.c
│   └── tests
│       ├── cfg.groovy
│       ├── function.groovy
│       └── syntax.groovy
└── test_suite1
    ├── testdata
    │   ├── example1.c
    │   └── example2.c
    └── tests
        ├── suite1_test1.groovy
        ├── suite1_test2.groovy
        └── suite1_test3.groovy
```

Each test suite has its own test data (stored in the directory `testdata`) and
testcases (groovy scripts in the directory `tests`). This means that every test
suite will use a database named `testdata.tar.gz`. If you run gremtest, never
name one of your actual databases `testdata.tar.gz`, as it will be overwritten!


## Creating a test script

To create a test script, include gremtest:

```
!include("gremtest.groovy")
```

This is a Python escape, which means that you have the full power of Python 3
available. Multiple lines starting with `!` are seen as one block, so you can
even include multi-line Python code, such as function definitions.

The `include` command will include a script and process it as if it had been
part of the current script. This means that an included script can itself
include other scripts. Scripts are included relative to the current directory.

Then, define your tests, giving it a test name, a closure containing the test code, and an optional flag to enable or disable the test. For example:

``` groovy
test( "function name traversal", { ->
	fname = g.V()
		.has(NODE_TYPE,TYPE_FUNCTION)
		.has(NODE_CODE,'func1')
		.values('code')
		.next()
	assertEquals( fname, 'func1')
})
```

At the end, call `run_tests`:

``` groovy
run_tests()
```

## Test output

The script will return a list of test results, all formatted for terminal output. For example:

```
function name traversal            : PASS
test with error                    : ERROR
Division by zero
at Script7$_run_closure2(doCall:80)
at Script7(do_test:16)
at Script7$do_test$0(callCurrent:-1)
at Script7$do_test$0(callCurrent:-1)
at Script7(test:40)
at Script7(test:-1)
at Script7$test(callCurrent:-1)
at Script7(run:79)
at octopus.server.gremlinShell.OctopusGremlinShell(execute:122)
at octopus.server.gremlinShell.ShellRunnable(evaluteOnShell:145)
at octopus.server.gremlinShell.ShellRunnable(handleClient:136)
at octopus.server.gremlinShell.ShellRunnable(processClients:69)
at octopus.server.gremlinShell.ShellRunnable(run:44)

failing test                       : FAIL
assert found == expected
       |        |  |
       1        |  2
                false
1 pass, 1 fail, 1 error(s)
```

The texts `PASS`, `ERROR` and `FAIL` are color coded to immediately see the results at a glance.

