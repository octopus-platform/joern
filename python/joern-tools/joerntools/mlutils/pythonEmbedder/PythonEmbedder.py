import os

from FeatureArray import FeatureArray
from FeatureArrayToMatrix import FeatureArrayToMatrix

class Embedder:
    
    def embed(self, directory, tfidf = True):
        """
        For a given directory containing a TOC and a data/
        directory as, for example, created by joern-demux,
        create an embedding in libsvm format and save it
        as "embedding.libsvm" in the directory.
        """
        
        featureArray = self._createFeatureArray(directory)
        self.termDocMatrix = self._createTermDocumentMatrix(featureArray)
        if tfidf:
            self.termDocMatrix.tfidf()
        self._outputInLIBSVMFormat(directory)
        
    def _createFeatureArray(self, directory):
        
        featureArray = FeatureArray()
        
        dataDir = os.path.join(directory, 'data')
        filenames = os.listdir(dataDir)
        for f in filenames:
            label = f
            filename = os.path.join(dataDir, f)
            items = file(filename, 'r').readlines()
            featureArray.add(label, items)
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
        outFile = file(outFilename, 'w')

        for i in xrange(nCols):
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
    embeder = Embedder()
    embeder.embed(sys.argv[1])
    
