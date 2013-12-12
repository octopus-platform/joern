import numpy
from sklearn.metrics.pairwise import pairwise_distances
import sys


class AnomalyCalculator:
    
    def analyzeDistanceMatrix(self, D, anomalyScore, k):

        if k == 0:
            print 'Warning: k = 0'
            return (0,0)
        
        self.D = D

        # NNI: nearest neighbour indices
        # NNV: nearest neighbour distance values
        self.NNV = self.D.copy()
        self.NNV.sort(axis=0)
        
        self.gammaScores = numpy.square(self.NNV[:k,:]).sum(axis=0) / k
        
        if anomalyScore == 'gamma':
            return self.gammaScores
        else:
            self._calculateZetaScores(self.gammaScores, k)
            return self.zetaScores
    
    def calculateNearestNeighbours(self, k, D):
        NNV = D.copy()
        NNV.sort(axis=0)
        NNV = NNV[:k,:]
        NNI = D.argsort(axis=0)
        NNI = NNI[:k,:]
        return (NNV, NNI)
    
    # k: number of neighbours to take into account
    def anomalyAnalysis(self, matrix, k = 200, metric = 'cosine'):
                
        matrix = matrix.T
        D = pairwise_distances(matrix, metric=metric)
        return self.analyzeDistanceMatrix(D, 'gamma', k)
        
    
    def dist2Prototype(self, prototype, matrix):
        # I = prototype > thresh
        D = numpy.array(numpy.abs(matrix.T - prototype))**2
        # D = numpy.multiply(D, I)
        D = D.sum(axis=1)
        return D
    
    def _calculateZetaScores(self, gammaScores, k):
        D = self.D
        self.NNI = D.argsort(axis=0)
                
        nDocs = D.shape[1]
        densityTerm = numpy.zeros((nDocs,))

        m = 0
        for colVec in self.NNI[:k,:].T:
            pairs = [(i,j) for i in colVec for j in colVec]
            s = 0.0
            for (i,j) in pairs:
                s += D[i,j]**2
            densityTerm[m] = s/(k**2)
            m += 1
        
        self.zetaScores = gammaScores - densityTerm
    
    """ For Debugging Purposes """
    
    def prettyPrint(self, name, labels):    
        print 'Results of anomaly detection'
        print 'Zeta | Gamma'
        # outputRows = [(self.zetaScores[i], self.gammaScores[i], labels[i]) for i in xrange(len(labels))]
        outputRows = [(self.gammaScores[i], labels[i]) for i in xrange(len(labels))]
        outputRows.sort(reverse = True)
        print name
        print '==================='
        for outputRow in outputRows:
            print '%f: %s' % outputRow
    