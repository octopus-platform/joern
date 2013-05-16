from py2neo import neo4j, gremlin

class JoernSteps:

    def __init__(self):
        self._initJoernSteps()
    
    def _initJoernSteps(self):
        self.graphDb = neo4j.GraphDatabaseService("http://localhost:7474/db/data/")
        cmd = file('../gremlin/joernsteps.groovy').read()
        gremlin.execute(cmd, self.graphDb)

    def executeGremlinScript(self, filename):
        cmd = file(filename).read()
        return self.executeGremlinCmd()

    def executeGremlinCmd(self, cmd):
        return gremlin.execute(cmd, self.graphDb)
    