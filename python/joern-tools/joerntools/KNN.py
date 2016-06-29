
from joerntools.mlutils.EmbeddingLoader import EmbeddingLoader
from sklearn.metrics.pairwise import pairwise_distances


class KNN():
    def __init__(self):
        self.loader = EmbeddingLoader()
    
        self.svdK = 0
    
    def setEmbeddingDir(self, dirname):
        self.dirname = dirname
    
    def setLimitArray(self, limit):
        self.limit = limit
    
    def setK(self, k):
        self.k = k

    def setSVDk(self, k):
        self.svdK = k
    
    def setNoCache(self, no_cache):
        self.no_cache = no_cache
    
    def initialize(self):
        
        self.emb = self._loadEmbedding(self.dirname)

        # Normalize vectors for cosine similarity calculation
        from sklearn.preprocessing import Normalizer
        self.emb.x = Normalizer().fit_transform(self.emb.x)


    def _loadEmbedding(self, dirname):
        return self.loader.load(dirname, svd_k=self.svdK)
        
    
    def getNeighborsFor(self, funcId):
        """
        Retrieve k nearest neighbors of funcId, possibly
        limited to data points in self.limit
        """
        
        # This is VERY inefficient: We calculate entire
        # distance matrices although all we need is the
        # distance from one data point to all others
        
        if self.limit:
            validNeighborIds = [funcId] + [x for x in self.limit if x != funcId]
            validNeighbors = [self.emb.rTOC[str(x)] for x in validNeighborIds]
            
            X = self.emb.x[validNeighbors, :]            
            D = 1.0 - (X * self.emb.x[0, :].T).todense()
            NNI = list(D[:,0].argsort(axis=0))[:self.k]
                        
            return [validNeighborIds[x] for x in NNI]
        else:
            dataPointIndex = self.emb.rTOC[funcId]    
            X = self.emb.x
            D = 1.0 - (X * self.emb.x[dataPointIndex, :].T).todense()
            NNI = list(D[:,0].argsort(axis=0))[:self.k]
            return [self.emb.TOC[x] for x in NNI]

    def calculateDistances(self):
        
        self.emb.D = self._calculateDistanceMatrix()
        self._calculateNearestNeighbors()
        
    def _calculateNearestNeighbors(self):
        self.emb.NNI = self.emb.D.argsort(axis=0)
        
    def _calculateDistanceMatrix(self):
        return pairwise_distances(self.emb.x, metric='cosine')
