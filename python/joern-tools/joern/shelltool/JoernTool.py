
from octopus.server.DBInterface import DBInterface
from octopus.shelltool.PipeTool import PipeTool


class JoernTool(PipeTool):
    
    def __init__(self, DESCRIPTION):
        PipeTool.__init__(self, DESCRIPTION)
    
    # @Override
    def streamStart(self):
        self.dbInterface = DBInterface()
        self.dbInterface.connectToDatabase()
    
    def _runGremlinQuery(self, query):
        return self.dbInterface.runGremlinQuery(query)
    
