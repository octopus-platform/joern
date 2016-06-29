from TermDocumentMatrix import TermDocumentMatrix


class FeatureArrayToMatrix():
    
    def __init__(self):
        self.termDocumentMatrix = TermDocumentMatrix()
    
    def convertFeatureArray(self, featureArray):
        
        self.nameDictMap = featureArray.vecs
        self.docNames = list(self.nameDictMap.d.keys())
        self.allSymbolsDict = featureArray.allSymbols
        return self.convert()
        
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

        return self.termDocumentMatrix

    def _getNthDocument(self, n):
        return self.nameDictMap.d[self.docNames[n]]
    
    def _getNumberOfTerms(self):
        return self.allSymbolsDict.getNumberOfEntries()
    
    def _getNumberOfDocuments(self):
        return self.nameDictMap.getNumberOfEntries()