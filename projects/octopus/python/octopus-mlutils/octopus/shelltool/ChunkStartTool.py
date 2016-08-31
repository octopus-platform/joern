"""
A shell tool that constructs queries from arguments and flags, then
outputs results. In contrast to StartTool, this tool performs chunking
to increase performance.
"""

from octopus.server.DBInterface import DBInterface
from octopus.shelltool.CmdLineTool import CmdLineTool

CHUNK_SIZE = 20560

class ChunkStartTool(CmdLineTool):

    def __init__(self, DESCRIPTION):
        CmdLineTool.__init__(self, DESCRIPTION)
        self.argParser.add_argument('project')

    # @Override
    def _constructIdQuery(self):
        pass

    # @Override
    def _constructQueryForChunk(self, chunk):
        pass

    # @Override
    def handleChunkResult(self, res, chunk):
        pass

    # @Override
    def _start(self):
        pass

    def _stop(self):
        pass

    def _runImpl(self):

        self.dbInterface = DBInterface()
        self.dbInterface.connectToDatabase(self.args.project)

        self._start()

        query = self._constructIdQuery()
        ids = self.dbInterface.runGremlinQuery(query)

        for chunk in self.dbInterface.chunks(ids, CHUNK_SIZE):
            query = self._constructQueryForChunk(chunk)
            res = self.dbInterface.runGremlinQuery(query)
            self._handleChunkResult(res, chunk)

        self._stop()
