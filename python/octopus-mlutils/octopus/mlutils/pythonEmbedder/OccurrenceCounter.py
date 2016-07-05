class OccurrenceCounter():
    def __init__(self):
        self.d = dict()
    
    def add(self, item):
        try:
            self.d[item] += 1
        except:
            self.d[item] = 1
    
    def getNumberOfEntries(self):
        return len(self.d.keys())
