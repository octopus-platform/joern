from py2neo import neo4j, gremlin

def loadJoernSteps(graphDb):
    cmd = file('../gremlin/joernsteps.groovy').read()
    gremlin.execute(cmd, graphDb)
