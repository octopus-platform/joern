from octopus.server.DBInterface import DBInterface
from octopus.shelltool.PipeTool import PipeTool


class JoernTool(PipeTool):

    def __init__(self, DESCRIPTION):
        PipeTool.__init__(self, DESCRIPTION)
        self.dbName = None
        self.argParser.add_argument('project')

    # @Override
    def streamStart(self):
        self.dbInterface = DBInterface()
        self.dbInterface.disable_json()
        self.dbInterface.connectToDatabase(self.args.project)

    def _runGremlinQuery(self, query):
        return self.dbInterface.runGremlinQuery(query)
