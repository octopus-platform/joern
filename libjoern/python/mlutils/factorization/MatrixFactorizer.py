import scipy
import sparsesvd
import nimfa
import pymf
import pickle

class MatrixFactorizer():
    
    def __init__(self):
        self._registerAlgorithms()

    def factorize(self, X, nBases=None, algo = 'SVD'):
        self.algorithm = algo
        """
        Returns the factorization of the sparse matrix X into
        the matrices (W,H). Watchout, W and H are dense
        scipy matrices.
        If number of bases is not specified, it will try to
        determine this parameter automatically.
        """
        if nBases == None:
            return self.factorizeWithoutK(X, algo)
        
        
        return self.algorithms[algo](X, nBases)
    
    def save(self, projectRoot):
        WFilename = projectRoot + 'W_%s_%d.pickl' % (self.algorithm, self.W.shape[1])
        HFilename = projectRoot + 'H_%s_%d.pickl' % (self.algorithm, self.W.shape[1])
        
        pickle.dump(self.W, file(WFilename, 'w'))
        pickle.dump(self.H, file(HFilename, 'w'))
        
    
    def factorizeWithoutK(self, X, algo):
        nBases = xrange(100, X.shape[1], 10)
  
        W = None
        H = None
    
        for k in nBases:
            print k
            try:
                (nextW,nextH) = self.factorize(X, k, algo)
            except KeyboardInterrupt:
                import sys
                sys.exit()
            except:
                import traceback
                print traceback.print_exc()
                print 'Factorization failure for %d bases, incrementing' % (k)
                continue
                
    
    def _registerAlgorithms(self):
        self.algorithms = {}
        self.algorithms['SVD'] = self._SPARSESVD
        self.algorithms['PYMF_PCA'] = self._PYMF_PCA
        self.algorithms['NIMFA_NMF'] = self._NIMFA_NMF
          
    def _SPARSESVD(self, X, nBases):
        k = int(nBases[0])
        (U, S, V) = sparsesvd.sparsesvd(X.tocsc(), k)
        self.W = scipy.matrix(U.T*S)
        self.H = scipy.matrix(V)
        return (self.W, self.H)
    
    def _NIMFA_NMF(self, X, nBases):
        
        
        model = nimfa.mf(X, seed = 'nndsvd', rank = nBases,
                         method = "nmf", initialize_only = True)

        fit = nimfa.mf_run(model)
        W = fit.basis()
        H = fit.coef()
                
        self.W = W.todense()
        self.H = H.todense()
        return (self.W, self.H)
      
    def _PYMF_PCA(self, X, nBases):
        X = X.todense()
        
        self.mdl = pymf.PCA(X, num_bases=nBases)
        self.mdl.factorize()
        self.W = self.mdl.W
        self.H = self.mdl.H
        return (self.mdl.W, self.mdl.H)    
    
    """ For Debugging Purposes """
        
    def getBasisVectors(self, termDocMatrix, thresh=0.8):
        
        basisVectors = []
        
        for w in self.W.T:
            vList = []
            termIndex = 0
            for wi in w.T:
                if wi > thresh:
                    vList.append((wi[0,0], termDocMatrix.index2Term[termIndex]))
                termIndex += 1
            vList.sort(reverse = True)
            basisVectors.append(vList)
        return basisVectors
        
        