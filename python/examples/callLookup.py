import sys, os
sys.path.append(os.getcwd())
from joern.all import JoernSteps

j = JoernSteps()
j.connectToDatabase()

# (1) Lookup all calls to memcpy

cmd = 'getCallsTo("memcpy").code'

# (2) Lookup all calls to memcpy* using a lucene query

luceneQuery = 'type:"Identifier" AND code:memcpy*'
cmd = 'queryNodeIndex(\'%s\').code' % (luceneQuery)

# (3) Lookup all calls to functions matching regex
# Slow, but more powerful

cmd = 'getCallsToRegex("memcpy.*").code'

# (4) Lookup the functions performing the call

cmd = 'getCallsTo("memcpy").astNodeToFunction().signature'

# (5) Get a [filename,location,signature] table of functions
# calling memcpy

cmd = 'getCallsTo("memcpy").astNodeToFunction().functionToLocationRow()'

y = j.runGremlinQuery(cmd)
for x in y: print x
