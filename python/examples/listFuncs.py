from py2neo import neo4j, gremlin

import sys, os
sys.path.append(os.getcwd())
from libjoern import JoernSteps

j = JoernSteps()

# Get functions by name from index
# or, get all functions if no name is specified.

if len(sys.argv) == 2:
    cmd = "queryNodeIndex('functionName:%s')" % (sys.argv[1])
else:
    cmd = "queryNodeIndex('type:Function')"

cmd += """
.sideEffect{ name = it.functionName; }
.in('IS_FILE_OF').sideEffect{fname = it.filepath }
.transform{ [name, fname] }.toList()
"""

y = j.executeGremlinCmd(cmd)

for x in y: print x
