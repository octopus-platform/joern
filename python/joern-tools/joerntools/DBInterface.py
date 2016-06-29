
from joern.all import JoernSteps
import os

JOERN_TOOLS_STEPDIR = os.path.join(os.path.dirname(__file__), 'steps')

class DBInterface:
    
    def connectToDatabase(self):
        self.j = JoernSteps()
        self.j.addStepsDir(JOERN_TOOLS_STEPDIR)
        self.j.connectToDatabase()
    
    def runGremlinQuery(self, query):
        return self.j.runGremlinQuery(query)
    
    def chunks(self, ids, chunkSize):
        return self.j.chunks(ids, chunkSize)
    
