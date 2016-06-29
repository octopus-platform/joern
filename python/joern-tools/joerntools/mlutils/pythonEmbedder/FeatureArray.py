
from NameToDictMap import NameToDictMap
from OccurrenceCounter import OccurrenceCounter

class FeatureArray(object):
    def __init__(self):
        self.vecs = NameToDictMap()
        self.allSymbols = OccurrenceCounter()
    
    def add(self, label, items):
        
        if len(items) == 0:
            self.vecs.add(None, label)
            return
        
        for item in items:
            itemStr = str(item)
            self.vecs.add(itemStr, label)
            self.allSymbols.add(itemStr)
            
    def __iter__(self):
        for x in self.vecs.iteritems():
            yield x
    
    def getNumberOfTerms(self):
        return self.allSymbols.getNumberOfEntries()
    
    def getNumberOfDocuments(self):
        self.vecs.getNumberOfEntries()
    