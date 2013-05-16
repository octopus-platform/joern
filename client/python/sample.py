from py2neo import neo4j, gremlin
import joernsteps

graphDb = neo4j.GraphDatabaseService("http://localhost:7474/db/data/")
joernsteps.loadJoernSteps(graphDb)

cmd = "JoernIndex.astNodesByType(g, '%query%AssignmentExpr').toList()"

for x in gremlin.execute(cmd, graphDb):
    print x

