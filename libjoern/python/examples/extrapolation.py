########################################################
# Sample script - 'Similar API Usage Patterns'
# Fabian 'fabs' Yamaguchi <fabs@phenoelit.de>
#
# This short script demonstrates how the graph database
# created by joern can be queried to calculate all
# information required for vulnerability extrapolation
# as outlined in the WOOT'11 paper on the topic.
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
    
    records = j.executeCypherQuery('START n=node:astNodeIndex(type="Function") ' + 
                                   'MATCH (n)-[:IS_FUNCTION_OF_AST]->(p)-[:IS_AST_OF_AST_NODE]->(m) WHERE ' +
                                   'm.type IN ["IdentifierDeclType", "ParameterType"] ' +
                                   'RETURN ID(n), m.code ORDER BY ID(n)')[0]

    return records

def getCallRecords(j):
    
    records = j.executeCypherQuery('START n=node:astNodeIndex(type="Function") ' + 
                                   'MATCH (n)-[:IS_FUNCTION_OF_AST]->(p)-[:IS_AST_OF_AST_NODE]->(m)-[r:IS_AST_PARENT]->(callee) WHERE ' +
                                   'm.type = "CallExpression" AND r.n = "0"' +
                                   'RETURN ID(n), callee.code ORDER BY ID(n)')[0]
    return records


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
    