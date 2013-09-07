########################################################
#
# Sample script - 'Similar API Usage Patterns'
# Fabian 'fabs' Yamaguchi <fabs@phenoelit.de>
#
# In this example, a similarity matrix suitable to identify functions
# employing similar API usage patterns is created. The example
# demonstrates how joern-steps can be easiely used to represent each
# function of a code base by the API symbols is employs, i.e., the
# the functions and types it references.
# With this information at hand, scikit-learn is used to
# create a sparse document by term matrix, apply the tf-idf weighting
# scheme and perform principal component analysis to extract common API
# usage patterns as proposed in the WOOT'11 paper on vulnerability
# extrapolation:
# http://user.informatik.uni-goettingen.de/%7Ekrieck/docs/2011-woot.pdf
########################################################

import sys, os
import cPickle as pickle
from collections import defaultdict, Counter

import numpy
from scipy.spatial.distance import squareform
import sparsesvd

from sklearn.feature_extraction import DictVectorizer
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn.preprocessing import Normalizer

sys.path.append(os.getcwd())
from libjoern import JoernSteps

def addRecordsToDict(records, d):
    
    for (func, apiSymbol) in records:
        funcKey = str(func)
        d[funcKey].append(apiSymbol)

def getTypeUsageRecords(j):
    
    cmd = """
    queryNodeIndex('type:IdentifierDeclType OR type:ParameterType')
    .transform{ [it.functionId, it.code] }
    """
    return j.executeGremlinCmd(cmd)

def getCallRecords(j):
    
    cmd = """
    queryNodeIndex('type:CallExpression').outE('IS_AST_PARENT').filter{ it.n == '0'}.inV()
    .transform{ [it.functionId, it.code] }
    """
    return j.executeGremlinCmd(cmd)

def getNameToId():
    nameToId = defaultdict(list)
    
    cmd = """
    queryNodeIndex('type:Function').transform{ [it.id, it.functionName] }
    """
    for (funcId, funcName) in j.executeGremlinCmd(cmd):
        d[funcName].append(funcId)
    return nameToId

if __name__ == '__main__':

    OUTPUTDIR = 'extrapolation'
    try:
        os.mkdir(OUTPUTDIR)
    except:
        pass

    j = JoernSteps()
    d = defaultdict(list)

    print 'Retrieving types used for all functions'
    records = getTypeUsageRecords(j)    
    
    print 'Adding types to dictionary'
    addRecordsToDict(records, d)

    print 'Adding callees to dictionary'
    records = getCallRecords(j)
    addRecordsToDict(records, d)

    print 'Getting nameToId mapping for convenience'

    nameToId = getNameToId()

    print 'Counting occurrences'
    for k in d.iterkeys():
        d[k] = dict(Counter(d[k]))
    
        for j in d[k].iterkeys():
            d[k][j] = 1.0
    
    funcIds = d.iterkeys()
    vectors = d.itervalues()

    print 'Creating document term matrix'

    vec = DictVectorizer()
    tfidf = TfidfTransformer()
    X = vec.fit_transform(vectors)
    X = tfidf.fit_transform(X)

    print 'Shape of document term matrix: ' + str(X.shape)
        
    k = 100
    print 'Performing SVD with k = %d' % (k)
    (U, S, V) = sparsesvd.sparsesvd(X.T.tocsc(), k)

    print 'Creating distance matrix'

    Xn = Normalizer().fit_transform(V.T)
    D = 1.0 + (-Xn.dot(Xn.T))
    numpy.fill_diagonal(D, 0.0)
    
    print 'Dumping all you need for extrapolation to: %s' % (OUTPUTDIR)
    
    pickle.dump(X, file('%s/X.pickl' % (OUTPUTDIR), 'w'), protocol=2)
    pickle.dump(U, file('%s/U.pickl' % (OUTPUTDIR), 'w'), protocol=2)
    pickle.dump(S, file('%s/S.pickl' % (OUTPUTDIR), 'w'), protocol=2)
    pickle.dump(V, file('%s/V.pickl' % (OUTPUTDIR), 'w'), protocol=2)
    pickle.dump(squareform(D), file('%s/D.pickl' % (OUTPUTDIR), 'w'), protocol=2)
    pickle.dump(list(funcIds), file('%s/funcIds.pickl' % (OUTPUTDIR), 'w'), protocol=2)
    pickle.dump(nameToId, file('%s/nameToId.pickl' % (OUTPUTDIR), 'w'), protocol = 2)
    
