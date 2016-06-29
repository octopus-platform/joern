
import os

"""
Interface to a Sally data directory that provides
caching to reduce the necessary number of database
queries.
"""
class SallyDataStore:

    def __init__(self, directory):
        self.directory = directory
        
        if not os.path.isdir(self.directory):
            path = os.path.join(directory, 'data')
            os.makedirs(path)
        
        TOCFilename = os.path.join(directory, 'TOC')
        if not os.path.isfile(TOCFilename):
            open(TOCFilename, 'w').close()
        
        self._openTOC()
    
    def close(self):
        self.tocFile.close()
    
    def _openTOC(self):
        self.toc = dict()
        self.tocFile = open(os.path.join(self.directory, 'TOC'), 'r')
        number = 0
        for number, key in enumerate(self.tocFile):
            self.toc[int(key)] = number
        self._next_file_number = len(self.toc)
    
        self.tocFile.close()
        self.tocFile = open(os.path.join(self.directory, 'TOC'), 'a')
    
    """
    Retrieves the filename of the data point
    for the given function. If necessary, the file
    will be created first.
    """
    def createAndGetDataFileForFunction(self, func):    
        
        if not self._isFunctionCached(func):
            self._cacheFunction(func)
            
        number = self.getDataPointNumberForFunction(func)
            
        return os.path.join(self.directory,
                            'data',
                            str(number))

    def _isFunctionCached(self, func):
        return func.getKey() in self.toc
    
    def _cacheFunction(self, func):
        self._writeDataFile(func)
        self._writeToTOC(func)
    
    def _writeDataFile(self, func):
        
        filename = os.path.join(
                self.directory,
                'data',
                str(len(self.toc)))
        
        
        f = open(filename, 'w')    
        for feature in func.getFeatures():
            f.write(str(feature) + '\n')
        f.close()
    
    def _writeToTOC(self, func):
        self.toc[func.getKey()] = len(self.toc)
        self.tocFile.write(str(func.getKey()) + '\n')
    
    
    """
    Get the number of the data point assigned to it
    by the data store. Note, that this number will
    in general be different from the node id.
    """
    def getDataPointNumberForFunction(self, func):
        return self.toc[func.getKey()]
    
    """
    Transfer a data point from another store by
    creating a symlink and updating this data store's
    table of contents accordingly.
    """
    def transferDataPointFromStore(self, srcStore, func):
        filename = srcStore.createAndGetDataFileForFunction(func)
        number = srcStore.getDataPointNumberForFunction(func)
        self._linkToCachedDataPoint(filename, number, func)
    
    def _linkToCachedDataPoint(self, filename, number, func):
        
        source = filename
        target = os.path.join(self.directory, 'data', str(len(self.toc)))
        os.symlink(os.path.abspath(source),os.path.abspath(target))
    
        self._writeToTOC(func)

    
    
    