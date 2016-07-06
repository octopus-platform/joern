
from argparse import FileType
from octopus.shelltool.ChunkStartTool import ChunkStartTool
from octopus.mlutils.MLDataDir import MLDataDir
from octopus.mlutils.pythonEmbedder.PythonEmbedder import Embedder

DESCRIPTION = """ """

DEFAULT_DIRNAME = 'embedding'

class MLDataDirCreator(ChunkStartTool):
    def __init__(self):
        ChunkStartTool.__init__(self, DESCRIPTION)
        self.dataDir = MLDataDir()

        self.argParser.add_argument('-d', '--dirname', nargs='?',
                                    type = str, help="""The directory to write the embedding to.""",
                                    default = DEFAULT_DIRNAME)
    
        self.argParser.add_argument('-f', '--filename', nargs="?", type=
                                    FileType('r'), default=None,
                                    help = 'file to read ids of objects to embed from.')
    
    
    def _start(self):
        self.dataDir.create(self.args.dirname)

    # @Override    
    def _constructIdQuery(self):
        pass
    
    # @Override
    def _constructQueryForChunk(self, chunk):
        pass
        
    def _handleChunkResult(self, res, chunk):
        
        for (funcId, strings) in res:
            self.dataDir.addDataPoint(funcId, strings)
        
    def _stop(self):
        self.dataDir.finalize()
        self.embedder = Embedder()
        self.embedder.embed(self.args.dirname, tfidf=False)
        