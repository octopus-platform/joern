
from octopus.server.python_shell_interface import PythonShellInterface

import os

class DBInterface:
    
    def connectToDatabase(self, databaseName = 'octopusDB'):
        self.j = PythonShellInterface()
        self.j.setDatabaseName(databaseName)
        self.j.connectToDatabase()
    
    def runGremlinQuery(self, query):
        return self.j.runGremlinQuery(query)
    
    def chunks(self, ids, chunkSize):
        return self.j.chunks(ids, chunkSize)
    
