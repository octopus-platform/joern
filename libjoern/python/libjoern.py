from py2neo import neo4j, gremlin, cypher
import os

class JoernSteps:

    def __init__(self):
        self._initJoernSteps()
        
    def _initJoernSteps(self):
        self.graphDb = neo4j.GraphDatabaseService("http://localhost:7474/db/data/")
    
        filename = os.path.join(os.path.dirname(__file__), 'joernsteps.groovy')
        cmd = file(filename).read()
        self.initCommand = cmd + "\n"

    def executeGremlinScript(self, filename):
        return self.executeGremlinCmd()

    def executeGremlinCmd(self, cmd):
        finalCmd = self.initCommand
        finalCmd += cmd
        return gremlin.execute(finalCmd, self.graphDb)
        
    def executeCypherQuery(self, query):
        return cypher.execute(self.graphDb, query)
    