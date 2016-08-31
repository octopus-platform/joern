
"""
A shell tool that constructs a query from arguments and flags and
outputs results. This is different from a PipeTool as StartTool can
only occur at the beginning of a chain.
"""

from octopus.server.DBInterface import DBInterface
from octopus.shelltool.CmdLineTool import CmdLineTool

class StartTool(CmdLineTool):
    
    def __init__(self, DESCRIPTION):
        CmdLineTool.__init__(self, DESCRIPTION)

    # @Override
    def _constructQuery(self):
        """
        Create a query from arguments that will be passed to the
        database.
        """
        pass

    # @Override
    def _handleResult(self, res):
        """
        Process the result of the query.
        """
        pass

    def _runImpl(self):
        query = self._constructQuery()
        
        self.dbInterface = DBInterface()
        self.dbInterface.connectToDatabase()

        res = self.dbInterface.runGremlinQuery(query)
        self._handleResult(res)
        
