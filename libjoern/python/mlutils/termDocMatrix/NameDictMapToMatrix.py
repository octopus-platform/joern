
from mlutils.termDocMatrix.TermDocumentMatrix import TermDocumentMatrix
import cPickle as pickle

class NameDictMapToMatrix():
    
    def __init__(self):
        self.termDocumentMatrix = TermDocumentMatrix()
    
    def _openNameDictMap(self, filename):
        self.nameDictMap = pickle.load(open(filename, 'rb'))
        self.docNames = list(self.nameDictMap.d.keys())
    
    def _openAllSymbolsDict(self, filename):
        self.allSymbolsDict = pickle.load(open(filename, 'rb'))
    
    def convertFromFiles(self, nameDictMapFilename, allSymbolsFilename):
        self._openNameDictMap(nameDictMapFilename)
        self._openAllSymbolsDict(allSymbolsFilename)
        self.convert()
    
    def convertFromDicts(self, nameDictMap, allSymbolsDict):
        self.nameDictMap = nameDictMap
        self.docNames = list(self.nameDictMap.d.keys())
        self.allSymbolsDict = allSymbolsDict
        self.convert()
        
    def convert(self):
        numberOfTerms = self._getNumberOfTerms()
        numberOfDocuments = self._getNumberOfDocuments()
                
        self.termDocumentMatrix.setDimensions(numberOfTerms, numberOfDocuments)
        self.termDocumentMatrix.setDocuments(self.docNames)
        
        for n in range(numberOfDocuments):
            doc = self._getNthDocument(n)
            for term in doc.keys():
                if not self.termDocumentMatrix.isTermKnown(term):
                    self.termDocumentMatrix.addTerm(term)
                self.termDocumentMatrix.incCoefficient(term, n, doc[term])
    
    def discardRows(self, toDiscard):
         
        nTerms = self._getNumberOfTerms() - len(toDiscard)
        nDocs = self._getNumberOfDocuments()
        
        newMatrix = TermDocumentMatrix()
        newMatrix.setDimensions(nTerms, nDocs)
        newMatrix.setDocuments(self.docNames)
        
        for n in range(nDocs):
            doc = self._getNthDocument(n)
            for term in doc.keys():
                if self.termDocumentMatrix.term2Index[term] in toDiscard: continue
                
                if not newMatrix.isTermKnown(term):
                    newMatrix.addTerm(term)
                print (term, n)
                newMatrix.incCoefficient(term, n, doc[term])
    
        self.termDocumentMatrix = newMatrix
                    
    def save(self, projectRoot):
        pickle.dump(self.termDocumentMatrix, open(projectRoot + 'termDocMatrix.pickl', 'wb'), protocol=2)
    
    def getDimensions(self):
        return self.termDocumentMatrix.matrix.shape
    
    def _getNthDocument(self, n):
        return self.nameDictMap.d[self.docNames[n]]
    
    def _getNumberOfTerms(self):
        return self.allSymbolsDict.getNumberOfEntries()
    
    def _getNumberOfDocuments(self):
        return self.nameDictMap.getNumberOfEntries()

