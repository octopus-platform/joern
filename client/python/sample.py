from py2neo import neo4j, gremlin
from joernsteps import JoernSteps

j = JoernSteps()

cmd = "JoernIndex.astNodesByType(g, 'AssignmentExpr').toList()"

for x in j.executeGremlinCmd(cmd):
    print x

