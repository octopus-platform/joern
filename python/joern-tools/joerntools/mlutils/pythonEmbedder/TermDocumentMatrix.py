
from scipy.sparse import lil_matrix, dia_matrix
import math

# A sparse matrix (lil_matrix) packaged with
# maps between terms/docs and indices.

class TermDocumentMatrix():
    def __init__(self):
        self.matrix = None
        self.term2Index = dict()
        self.index2Term = dict()
        self.doc2Index = dict()
        self.index2Doc = dict()
        self.nterms = 0
    
    def setDimensions(self, h, w):
        if (h,w) != (0,0):
            self.matrix = lil_matrix((h, w))

    def setDocuments(self, docs):
        self.index2Doc = docs
        for i in xrange(len(self.index2Doc)):
            self.doc2Index[self.index2Doc[i]] = i
    
    def addTerm(self, term):
        self.term2Index[term] = self.nterms
        self.index2Term[self.nterms] = term
        self.nterms += 1

    def incCoefficient(self, i, j, n):
        if self.matrix == None: return
        self.matrix[self.term2Index[i],j] += n

    def isTermKnown(self, term):
        return term in self.term2Index
   
    def tfidf(self):
        
        m = self.matrix
        
        if m == None:
            return

        # TF
        # d = [1.0/x if x != 0 else 0.0 for x in m.sum(0).tolist()[0]]
        # dia = dia_matrix((d, [0]), shape=(len(d), len(d)))
        # m = m * dia
        
        # IDF
        epsilon = 10**(-50) # We want to make sure no item is completely removed
        numberOfDocuments = m.shape[1]
        idf = [math.log(float(numberOfDocuments) / len(r)) + epsilon for r in self.matrix.rows]
        dia = dia_matrix((idf, [0]), shape=(len(idf), len(idf)))
        m = (m.T * dia).T
        self.matrix = lil_matrix(m)
        
        
    
