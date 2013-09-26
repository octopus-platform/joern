from py2neo import neo4j, gremlin, cypher
import os

class JoernSteps:

    def __init__(self):
        self._initJoernSteps()
        
    def _initJoernSteps(self):
        self.graphDb = neo4j.GraphDatabaseService("http://localhost:7474/db/data/")
   
        joernStepsDir = os.path.dirname(__file__) + '/joernsteps/'
        self.initCommand = self._createInitCommand(joernStepsDir)
        
    def _createInitCommand(self, stepsDir):
        
        initCommand = ""
        for (root, dirs, files) in os.walk(stepsDir):
            files.sort()
            for f in files:
                filename = root + f
                initCommand += file(filename).read() + "\n"
        return initCommand
        
    def executeGremlinScript(self, filename):
        return self.executeGremlinCmd()

    def executeGremlinCmd(self, cmd):
        finalCmd = self.initCommand
        finalCmd += cmd
        return gremlin.execute(finalCmd, self.graphDb)
        
    def executeCypherQuery(self, query):
        return cypher.execute(self.graphDb, query)
    
