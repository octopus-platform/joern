
import cPickle as pickle
from sklearn.metrics.pairwise import pairwise_distances
import numpy
from scipy.spatial.distance import squareform
from scipy.spatial.distance import pdist


DFilename = 'D_%s.pickl'

class DataMatrixToDistMatrix():
    
    def __init__(self, projectRoot):
        self.projectDir = projectRoot
        self.D = None
        self.NNI = None
        self.NNV = None
        
    def convert(self, dataMatrix, metric = 'euclidean'):
        dataMatrix = dataMatrix.T
        # print type(dataMatrix)
        # print dataMatrix.shape
        
        if metric == 'euclidean':        
            self.D = pairwise_distances(dataMatrix, metric=metric)
        elif metric == 'cosine':
            self.sklearnCosineDistance(dataMatrix)
            # self.pyDistancesPdist(dataMatrix, metric) 
            # self.D = pdist(dataMatrix, 'cosine')
        else:
            raise
        self.D[numpy.nonzero(self.D < 0)] = 0
        
    
    def sklearnCosineDistance(self, X):
        
        from sklearn.preprocessing import Normalizer
        Xn = Normalizer().fit_transform(X.tocsc())
        # self.D = squareform(1.0 + (-Xn * Xn.T).todense(), checks=False)
        D = 1.0 + (-Xn * Xn.T).todense()
        numpy.fill_diagonal(D, 0.0)
        self.D = D
        # self.D = squareform(D)
        
    def pyDistancesPdist(self, dataMatrix, metric):
        import distmetrics
        dm = distmetrics.DistanceMetric(metric)
        self.D = dm.pdist(dataMatrix.tocsc())
        self.D[numpy.nonzero(self.D < 0)] = 0
    
    def calculateNearestNeighbours(self):
        # this isn't efficient, because we sort twice
        self.NNI = self.D.argsort(axis=0)
        self.NNV = self.D.copy()
        self.NNV.sort(axis=0)
    
    def save(self, metric):
        print self.D.shape
        # save as in hdf5
        
        if self.D != None:
            import h5py
            filename = self.projectDir + DFilename % (metric)
            f = h5py.File(filename, 'w')
            f.create_dataset('distanceM', data=self.D)
            f.close()
            # pickle.dump(squareform(self.D), file(filename, 'w'), protocol=2)
        
        