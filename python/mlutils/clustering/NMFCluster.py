
import numpy
import scipy.sparse

from mlutils.factorization.MatrixFactorizer import MatrixFactorizer

class NMFCluster:
    def __init__(self, configuration = None):
        
        if configuration:
            self.minimumNumMembers = configuration['minimumNumMembers']
            self.percentageInAcceptableClusters = configuration['inAcceptable']
            self.algorithm = configuration['algorithm']
        else:
            self.minimumNumMembers = 2
            self.percentageInAcceptableClusters = 0.8
            self.algorithm = 'NIMFA_NMF' 
    
    def pruneTermDocumentMatrix(self):
        thresh = 0 # essentially off.
        cscMatrix = self.matrix.tocsc()
        indices = [i for i in xrange(cscMatrix.shape[1]) if cscMatrix.getcol(i).indptr[1] >= thresh]
        newLabels = [self.termDocMatrix.index2Doc[i] for i in indices]
        return (newLabels, cscMatrix[:,indices])
    
    
    def cluster(self, termDocMatrix, initialNBases = 2):

        self.termDocMatrix = termDocMatrix
        self.matrix = termDocMatrix.matrix
        
        (prunedLabels, prunedMatrix) = self.pruneTermDocumentMatrix()
        
        self.matrix = prunedMatrix
        self.labels = prunedLabels
        
        if initialNBases > len(self.labels) + 1:
            initialNBases = (len(self.labels) + 1) / 2
        nBases = range(initialNBases,len(self.labels) + 1, 2)
        
        self._calculateDecomposition(prunedMatrix, nBases)
        self.clusterDict = self._calculateClusterDict(prunedLabels)
    
    def getW(self):
        return self.W
    
    def getH(self):
        return self.H
    
    def getError(self):
        WH = (self.W * self.H)
        return (self.matrix - WH)
    
    
    def getNumberOfClusters(self):
        return max(self.clusterIndices) + 1
        
    def getMatrixForCluster(self, clusterIndex):
        memberIndices = numpy.nonzero(numpy.array(self.clusterIndices) == clusterIndex)
        clusterMatrixLabels = [self.labels[i] for i in memberIndices[0]]
        return [clusterMatrixLabels, self.matrix[:, memberIndices[0]]]
    
    def getLowerDimensionalMatrixForCluster(self, clusterIndex):
        memberIndices = numpy.nonzero(numpy.array(self.clusterIndices) == clusterIndex)
        clusterMatrixLabels = [self.labels[i] for i in memberIndices[0]]
        return [clusterMatrixLabels, self.H[:, memberIndices[0]]]
    
    def getPrototype(self, clusterIndex):
        return self.W[clusterIndex,:]
    
    
    def _calculateDecomposition(self, matrix, nBases):
        self.W = None
        self.H = None
        
        for k in nBases:
            print k
            try:
                newFactorizer = MatrixFactorizer()
                (nextW,nextH) = newFactorizer.factorize(matrix, k, self.algorithm)
            except KeyboardInterrupt:
                import sys
                sys.exit()
            except:
                print 'Factorization failure for %d bases, incrementing' % (k)
                continue
            
            nextClusterIndices = self._determineClusters(nextH)
            score = self._calculateGoodnessMeasure(k, nextClusterIndices)
            
            if score < self.percentageInAcceptableClusters:
                break
                        
            self.W = nextW
            self.H = nextH
            self.clusterIndices = nextClusterIndices
            self.factorizer = newFactorizer

                        
        if self.W == None:
            self.W = nextW
            self.H = nextH
            self.clusterIndices = nextClusterIndices
            self.factorizer = newFactorizer
         
            
    def _determineClusters(self, H):
        if scipy.sparse.issparse(H):
            cscH = H.tocsc()
            return [self._getMaxIndex(cscH.getcol(i)) for i in xrange(cscH.shape[1])]
        else:
            return H.argmax(axis=0).tolist()[0]
    
    def _getMaxIndex(self, col):
        return (col.indices[col.data.argmax()] if col.nnz else 0)
        
    def _calculateGoodnessMeasure(self, k, clusterIndices):
        nMembers = numpy.bincount(clusterIndices)
        nClustersLargeEnough = len(numpy.nonzero(nMembers >= self.minimumNumMembers)[0])
        return float(nClustersLargeEnough)/k

    def _calculateClusterDict(self, labels):
        d = dict()
        for i in xrange(len(labels)):
            try:
                d[self.clusterIndices[i]].append(i)
            except:
                d[self.clusterIndices[i]] = [i]
        return d
    
    def calculateInnerClusterDistances(self):
        from sklearn.metrics.pairwise import pairwise_distances
        
        innerClusterDistances = []
        
        numberOfClusters = self.getNumberOfClusters()
        for clusterIndex in xrange(numberOfClusters):
            [unused, clusterMatrix]= self.getLowerDimensionalMatrixForCluster(clusterIndex)
            
            if clusterMatrix.shape[0] > 0 and clusterMatrix.shape[1] > 0:
                averageDistanceInCluster = numpy.mean(pairwise_distances(clusterMatrix.T, metric='cosine'))
            else:
                averageDistanceInCluster = 0
            nMembers = clusterMatrix.shape[1]
            if nMembers > 0:
                score = float(averageDistanceInCluster) / nMembers
            else:
                score = 0
            
            innerClusterDistances.append((score, averageDistanceInCluster,clusterIndex, nMembers))
        
        innerClusterDistances.sort()
        return innerClusterDistances
       
    
    def printClusterDict(self):
        for v in self.clusterDict.itervalues():
            print '============='
            for x in v: print self.labels[x]
    
    def getPrototypes(self, thresh):
        return self.factorizer.getBasisVectors(self.termDocMatrix, thresh)