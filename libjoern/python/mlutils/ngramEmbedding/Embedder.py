from mlutils.ngramEmbedding.ngramCalculator import NgramCalculator

from libjoern.FileIterators import FunctionPythonASTIterator
from libjoern.containers.FeatureArray import FeatureArray

from sourceutils.misc.GzipPickler import GzipPickler
import cPickle as pickle
import os, os.path

class Embedder:
    
    def __init__(self, projectRoot):
        self.projectRoot = projectRoot
        
        self.csvFilter = None        
        self.ngramCalculator = NgramCalculator()
        
        self.featureArray = FeatureArray()
    
    def setFilter(self, csvFilter):
        self.csvFilter = csvFilter
    
    def configureNgramCalculator(self, ngramN, smallerNgramsToo):
        self.ngramCalculator.setNgramN(ngramN)
        self.ngramCalculator.setSmallerNgramsToo(smallerNgramsToo)
        
    def embedAllFunctions(self):
        if self._embeddingExists():
            print 'Global Embedding already exists, skipping.'
            return
        
        codeTreeWalker = FunctionPythonASTIterator(self.projectRoot)
                
        for picklFilename in codeTreeWalker:
            funcDir = '/'.join(picklFilename.split('/')[:-1])
            
            rootNode = GzipPickler().load(picklFilename)
            
            self.filterAndAddAST(funcDir, rootNode)
            
    def _embeddingExists(self):
        filename = self.projectRoot + 'func2SubtreesMap.pickl'
        return os.path.exists(filename)
    
    def filterAndAddAST(self, label, node):
        
        self.csvFilter.reset()
        lines = self.csvFilter.apply(node)
        ngrams = self.ngramCalculator.ngramsForRows(lines)
        label = str(label)
        
        self.featureArray.add(label, ngrams)
        
    
    def getMaps(self):
        # this should be removed
        return (self.featureArray.vecs, self.featureArray.allSymbols)
       
    def save(self, name):
        embeddingsDir = self.projectRoot + 'embeddings'
        thisEmbeddingDir = embeddingsDir + '/'+ name
        
        if not os.path.exists(embeddingsDir):
            os.mkdir(embeddingsDir)
        
        if not os.path.exists(thisEmbeddingDir):
            os.mkdir(thisEmbeddingDir)
            
        
        pickle.dump(self.featureArray.vecs, file( thisEmbeddingDir + '/func2SubtreesMap.pickl', 'w'))
        pickle.dump(self.featureArray.allSymbols, file( thisEmbeddingDir + '/allSubtreesDict.pickl', 'w'))
        return thisEmbeddingDir