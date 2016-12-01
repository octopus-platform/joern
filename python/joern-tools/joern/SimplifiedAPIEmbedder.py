import os
from octopus.server.DBInterface import DBInterface

from octopus.mlutils.pythonEmbedder.FeatureArray import FeatureArray
from octopus.mlutils.pythonEmbedder.FeatureArrayToMatrix import FeatureArrayToMatrix


"""
Contributed by @yangke:

For a given output directory, generate a TOC File,
create an APISymbol embedding in libsvm format and save it
as "embedding.libsvm" in the output directory. where the TOC File
records a list of the functionIds in a coresponding order 
with the file:"embedding.libsvm". 
Unlike the other disk writing embedder, this embedder does not
generate the APISymbol features. So it may provide a better
performance for programs which are only focusing on the similarity
between functions.
"""

class APIEmbedder(object):
          
    def __init__(self):    
        self._initializeDBConnection()

    def _initializeDBConnection(self):
        self.dbInterface = DBInterface()
    
    def setOutputDirectory(self, directory):
        self.outputDirectory = directory
    
    def run(self,tfidf=True):
        try: 
            # Will throw error if output directory already exists
            self._initializeOutputDirectory()
        except:
            return
        self._connectToDatabase()
        functions = self._getAPISymbolsFromDatabase()
        featureArray = self._createFeatureArray(functions)
        self._finalizeOutputDirectory() 
        self.termDocMatrix = self._createTermDocumentMatrix(featureArray)
        if tfidf:
            self.termDocMatrix.tfidf()
        self._outputInLIBSVMFormat(self.outputDirectory)
    
    def _connectToDatabase(self):
        self.dbInterface.connectToDatabase()

    def _initializeOutputDirectory(self):
        directory = self.outputDirectory
        if os.path.exists(directory):
            raise
        os.makedirs(directory)
        self.tocFilename = os.path.join(directory, 'TOC')
        self.toc = open(self.tocFilename, 'w')
        
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
        for i in range(0, len(l), n):
            yield l[i:i+n]
    
    def _runGremlinQuery(self, query):
        return self.dbInterface.runGremlinQuery(query)
   
    def _createFeatureArray(self, functions):
        
        featureArray = FeatureArray()
        for index,(funcId, symbols) in enumerate(functions):
            for i in range(len(symbols)):
               symbols[i]= symbols[i]+'\n'
            featureArray.add(index, symbols)#label,items
            self.toc.write("%d\n" % (funcId))
        self.toc.flush()
        return featureArray
    
    def _createTermDocumentMatrix(self, featureArray):
        converter = FeatureArrayToMatrix()
        return converter.convertFeatureArray(featureArray)
    
    def _outputInLIBSVMFormat(self, directory):
        
        from scipy.sparse import csc_matrix
        
        if self.termDocMatrix.matrix == None: return

        m =  csc_matrix(self.termDocMatrix.matrix)
        nCols = m.shape[1]
        
        outFilename = os.path.join(directory, 'embedding.libsvm')
        outFile = open(outFilename, 'w')

        for i in range(nCols):
            label = self.termDocMatrix.index2Doc[i] 
            
            col = m.getcol(i)
            entries = [(i,col[i,0]) for i in col.indices]
            entries.sort()
            features = " ".join(['%d:%f' % e for e in entries])
            row = '%s %s #%s\n' % (label, features, label) 
            outFile.write(row)
        
        outFile.close()
        
if __name__ == '__main__':
    import sys
    embeder = APIEmbedder()
    embedder.setOutputDirectory(sys.argv[1])
    embeder.run()
