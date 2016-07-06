from octopus.server.DBInterface import DBInterface

import os
from octopus.mlutils.pythonEmbedder.PythonEmbedder import Embedder

class APIEmbedder(object):
    
    def __init__(self):    
        self._initializeDBConnection()

    def _initializeDBConnection(self):
        self.dbInterface = DBInterface()
    
    def setOutputDirectory(self, directory):
        self.outputDirectory = directory

    def run(self):
        
        try: 
            # Will throw error if output directory already exists
            self._initializeOutputDirectory()
        except:
            return
        
        self._connectToDatabase()
        
        functions = self._getAPISymbolsFromDatabase()
        self._writeDataPoints(functions)
        self._finalizeOutputDirectory()
    
        self._embed()
                
    
    def _embed(self):
        # self.embedder = SallyBasedEmbedder()
        self.embedder = Embedder()
        self.embedder.embed(self.outputDirectory)
    
    def _connectToDatabase(self):
        self.dbInterface.connectToDatabase()
        
    def _writeDataPoints(self, functions):
        
        for (funcId, symbols) in functions:
            self.toc.write("%d\n" % (funcId))
            self._addDataPoint(symbols)
    
    def _addDataPoint(self, symbols):
        datapointFilename = os.path.join(self.dataDir, str(self.curDatapoint))
        f = file(datapointFilename, 'w')
        f.writelines([x + "\n" for x in symbols])
        f.close()
        self.curDatapoint += 1

    def _initializeOutputDirectory(self):
        directory = self.outputDirectory
        
        if os.path.exists(directory):
            raise
        
        self.dataDir = os.path.join(directory, 'data') 
        self.tocFilename = os.path.join(directory, 'TOC') 
        os.makedirs(self.dataDir)
        self.toc = file(self.tocFilename, 'w')
        
        self.curDatapoint = 0
        
    def _finalizeOutputDirectory(self):
        self.toc.close()

    def _getAPISymbolsFromDatabase(self):
    
        CHUNK_SIZE = 1024
    
        query = """queryNodeIndex('type:Function').id"""
        functionIds = self._runGremlinQuery(query)

        result = []

        for chunk in self.chunks(functionIds, CHUNK_SIZE):
            query = """
            _().transform{ %s }.scatter().transform{g.v(it)}
            .sideEffect{funcId = it.id}
            .transform{ [funcId, it.functionToAPISymbolNodes().code.toList()] }
            """ % (str(chunk))

            result.extend(self._runGremlinQuery(query))
        
        return result

    def chunks(self, l, n):
        for i in xrange(0, len(l), n):
            yield l[i:i+n]
    
    def _runGremlinQuery(self, query):
        return self.dbInterface.runGremlinQuery(query)
    
