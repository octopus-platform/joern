
EMBEDDING_FILENAME = '/embedding.libsvm'
FEATURE_FILENAME = '/feats.gz'
TOC_FILENAME = '/TOC'
D_FILENAME = '/D'
NNI_FILENAME = '/NNI'
NNV_FILENAME = '/NNV'

class Embedding:
    def __init__(self):
        self.x, self.y = None, None
        self.TOC = []
        self.rTOC = dict()
        self.featTable = dict()
        self.rFeatTable = dict()
        
        self.D = None
        self.NNI = None
        self.NNV = None

    def dExists(self):
        return (self.D != None)
    
    def nnExists(self):
        return (self.NNI != None)
        
