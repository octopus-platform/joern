from py2neo import neo4j, gremlin

import sys, os
sys.path.append(os.getcwd())
from libjoern import JoernSteps

j = JoernSteps()

cmd = "JoernIndex.astNodesByType(g, 'AssignmentExpr').toList()"

for x in j.executeGremlinCmd(cmd):
    print x

