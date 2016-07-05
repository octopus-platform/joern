from embedding.SallyDataStore import SallyDataStore


class SallyDataDirectoryCreator:
    
    def __init__(self, outputDir, cacheDir = None):
        
        if cacheDir != None:
            self.directory = cacheDir
            self.cache = SallyDataStore(self.directory)
        else:
            self.cache = None
        
        self.outputdir = outputDir
        self.dstStore = SallyDataStore(self.outputdir)
 
    """
    Create a sally data directory for the given functions
    and write it to outputdir. This data directory can then
    be embedded using a SallyBasedEmbedder.
    """
    def create(self, functions):
        for func in functions:
            # self.logger.info('Processing %s (%s/%s).', func, i, len(functions))
            if self.cache:
                self.dstStore.transferDataPointFromStore(self.cache, func)
            else:
                self.dstStore.createAndGetDataFileForFunction(func)
        
        if self.cache:
            self.cache.close()
            self.dstStore.close()
