
from tools.SinkSnippetEmbedder.SinkUserProvider import SinkUserProvider
from mlutils.termDocMatrix.NameDictMapToMatrix import NameDictMapToMatrix

from sourceutils.misc.NameToDictMap import NameToDictMap
from sourceutils.misc.OccurrenceCounter import OccurrenceCounter

import pickle

class SinkMatrixCreator:
    def __init__(self, projectRoot):
        self.projectRoot = projectRoot
        self.programDir = '/'.join(self.projectRoot.split('/')[:-3]) + '/'
        self.sinkUserProvider = SinkUserProvider(self.projectRoot + '../../')

    def createMatrixForSink(self, sinkName):
        (unused, callsToSink) = self.sinkUserProvider.getSinkByName(sinkName)
        functionNames = self.uniq([ '%s%s' % (self.programDir, c[1]) for c in callsToSink])
        
        return self.createMatrixForFunctionNames(functionNames)
    
    """
    This operation looses TF-IDF. I don't think that's the way to go.
    """
    
    def createMatrixForFunctionNames(self, functionNames):
        self._loadFunc2SubtreesMap()
        
        self.nameToDictMap = NameToDictMap()
        self.allSymbolsDict = OccurrenceCounter()
        nameDictMapToMatrix = NameDictMapToMatrix()
        
        functions = [(doc ,self.func2SubtreesMap.d[doc]) for doc in functionNames]
        
        for (doc, func) in functions:
            
            for (ngram, nOccurrences) in func.iteritems():
                for unused in xrange(nOccurrences):
                    self.nameToDictMap.add(ngram, doc)
                    self.allSymbolsDict.add(ngram)
        
        nameDictMapToMatrix.convertFromDicts(self.nameToDictMap, self.allSymbolsDict)
        newTermDocMatrix = nameDictMapToMatrix.termDocumentMatrix
        return newTermDocMatrix
        
    
    def _loadFunc2SubtreesMap(self):
        filename = self.projectRoot + 'func2SubtreesMap.pickl'
        self.func2SubtreesMap = pickle.load(file(filename))
    
    def uniq(self, seq, idfun=None): 
        # order preserving
        if idfun is None:
            def idfun(x): return x
        seen = {}
        result = []
        for item in seq:
            marker = idfun(item)
            if marker in seen: continue
            seen[marker] = 1
            result.append(item)
        return result
