from py2neo import neo4j, gremlin

import sys, os
sys.path.append(os.getcwd())
from libjoern import JoernSteps

j = JoernSteps()

# Get functions by name from index

cmd = "g.idx('astNodeIndex')[[functionName:'%%query%%' + '%s']]" % (sys.argv[1])
cmd += ".sideEffect{ name = it.functionName; }.in('IS_FILE_OF').sideEffect{fname = it.filepath }";
cmd += '.transform{ [name, fname] }.toList()'


y = j.executeGremlinCmd(cmd)

for x in y: print x