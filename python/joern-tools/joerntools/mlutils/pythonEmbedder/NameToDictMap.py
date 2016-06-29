import cPickle as pickle

class NameToDictMap():
    def __init__(self):
        self.d = dict()
    
    def add(self, itemToAdd, name, amount=1):
        if not name in self.d:
            self.d[name] = dict()
        
        if not itemToAdd:
            return
        
        if not itemToAdd in self.d[name]:
            self.d[name][itemToAdd] = amount
        else:
            self.d[name][itemToAdd] += amount
    
    def setItem(self, item, name, val):
        if not name in self.d:
            self.d[name] = dict()
        self.d[name][item] = val
    
    def getNumberOfEntries(self):
        return len(self.d.keys())
    
    def save(self, filename):
        pickle.dump(self, open(filename, 'wb'), protocol=2)
