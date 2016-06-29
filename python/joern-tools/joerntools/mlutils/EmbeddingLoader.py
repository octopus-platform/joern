#!/usr/bin/env python2

from sklearn.datasets import load_svmlight_file
from gzip import GzipFile
from Embedding import *

import os

LEN_BIN = len(' bin=')

class EmbeddingLoader:
    
    def __init__(self):
        self.emb = Embedding()
        
    def load(self, dirname, svd_k = 0):
        """
        Load the embedding and optionally perform SVD
        on load. If svd_k is set to 0, no SVD is performed.
        """
        
        self.dirname = dirname
        
        try:
            self.emb.x, self.emb.y = load_svmlight_file(dirname + EMBEDDING_FILENAME)
        except (ValueError, IOError):
            return None
        
        if svd_k != 0:
            try:
                import sparsesvd
                import scipy.sparse
                
                X = self.emb.x.T
                X = scipy.sparse.csc_matrix(X)
                Ut, S, Vt = sparsesvd.sparsesvd(X, svd_k)
                self.emb.x = scipy.sparse.csr_matrix(Vt.T)

            except ImportError:
                print 'Warning: Cannot perform SVD without sparsesvd module'

        self._loadFeatureTable()
        self._loadTOC()
        return self.emb
    
    def _loadFeatureTable(self):
        
        filename = self.dirname + FEATURE_FILENAME
        if not os.path.exists(filename):
            return

        f  = GzipFile(filename)
        
        # discard first line
        f.readline()

        while True:
            line = f.readline().rstrip()
            if line == '': break
            
            (feat, n) = self._parseHashTableLine(line)
            
            self.emb.featTable[feat] = n
            self.emb.rFeatTable[n] = feat
            
        f.close()
    
    def _parseHashTableLine(self, line):
        n, feat = line[LEN_BIN+1:].split(':',1)
        n = int(n , 16)
        feat = feat.lstrip().rstrip()
        return (feat, n)

    def _loadTOC(self):
        filename = self.dirname + TOC_FILENAME
        f = file(filename)
        TOCLines = [x.rstrip() for x in f.readlines()]
        self.emb.TOCLines = TOCLines
        f.close()
        
        for i in range(len(self.emb.y)):
            label = self.emb.y[i]
            name = TOCLines[int(label)]
            self.emb.rTOC[name] = i
            self.emb.TOC.append(name)
    

if __name__ == '__main__':
    import sys
    s = EmbeddingLoader()
    s.load(sys.argv[1])
    
