import scipy.cluster.hierarchy as hcluster
import scipy.spatial.distance as distance
import numpy

class LinkageClustering:
    def __init__(self, labels, X):
        self.X = X
        self.labels = labels
    
    def cluster(self, distanceMatrix, method = 'average', metric = 'cosine'):
        Y = distance.squareform(distanceMatrix, checks=False)
        Z = hcluster.linkage(Y, method = method, metric = metric)
        self.clusterIndices = hcluster.fcluster(Z, 0.4, criterion='distance')
        print 'Number of clusters: %d' % (numpy.max(self.clusterIndices) + 1)
        self.clusterDict = self._calculateClusterDict()
    
    def getNumberOfClusters(self):
        return max(self.clusterIndices)
        
    def getLowerDimensionalMatrixForCluster(self, clusterIndex):
        clusterIndex += 1
        memberIndices = numpy.nonzero(numpy.array(self.clusterIndices) == clusterIndex)
        clusterMatrixLabels = [self.labels[i] for i in memberIndices[0]]
        return [clusterMatrixLabels, self.X[:, memberIndices[0]]]
       
    def _calculateClusterDict(self):
        d = dict()
        for i in xrange(len(self.labels)):
            try:
                d[self.clusterIndices[i]].append(i)
            except:
                d[self.clusterIndices[i]] = [i]
        return d