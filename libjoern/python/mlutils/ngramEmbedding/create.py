from mlutils.ngramEmbedding.Embedder import Embedder

from mlutils.ngramEmbedding.Filters.APIUsageFilter import APIUsageFilter
from mlutils.ngramEmbedding.Filters.SymbolFilter import SymbolFilter


def embedFunctions(projectRoot, filterName = 'DefaultFilter', ngramN = None, smallerNgramsToo = None, sink = None):
    
    if sink == None:
        return embedAllFunctions(projectRoot, filterName, ngramN, smallerNgramsToo)
    else:
        return embedFunctionsUsingSink(projectRoot, filterName, ngramN, smallerNgramsToo, sink)
    
def embedAllFunctions(projectRoot, filterName = 'DefaultFilter', ngramN = None, smallerNgramsToo = None):
    
    functionEmbedder = Embedder(projectRoot)
    if ngramN != None:
        functionEmbedder.configureNgramCalculator(ngramN, smallerNgramsToo)
    
    if filterName != 'DefaultFilter':
        """ if filterName == 'OnlyConditionsFilter':
            functionEmbedder.setFilter(OnlyConditionsFilter())
        elif filterName == 'DefaultPlusConditions':
            print 'DefaultPlusConditions'
            functionEmbedder.setFilter(DefaultPlusConditionsFilter())    
        elif filterName == 'IdentifiersInConditions':
            functionEmbedder.setFilter(IdentifiersInConditionsFilter())
        elif filterName == 'WaterOnly':
            functionEmbedder.setFilter(WaterOnlyFilter())
        elif filterName == 'ConditionalExpressions':
            functionEmbedder.setFilter(ConditionalExpressionsFilter())
        """
        if filterName == 'Symbols':
            functionEmbedder.setFilter(SymbolFilter())
        elif filterName == 'APISymbols':
            functionEmbedder.setFilter(APIUsageFilter())
        
    functionEmbedder.embedAllFunctions()
    
    name = '%s_%d.pickl' % (filterName, ngramN)
    return functionEmbedder.save(name)
    
    
def embedFunctionsUsingSink(projectRoot, filterName, ngramN, smallerNgramsToo, sinkOfInterest):
    from tools.SinkSnippetEmbedder.SinkSnippetEmbedder import SinkSnippetEmbedder
    from tools.SinkSnippetEmbedder.SinkUserProvider import SinkUserProvider
    
    name = '%s_%d.pickl' % (filterName, ngramN)
    embedder = SinkSnippetEmbedder(projectRoot, ngramN, smallerNgramsToo)
    sink = SinkUserProvider(projectRoot).getSinkByName(sinkOfInterest)
    
    embedder.embedSinkUsers(sink)
    return embedder.save(name, sinkOfInterest)
    
def usage():
    print '<projectRoot> <filterName> <ngramN> <smallerNgramsToo> [sink]'

if __name__ == '__main__':
    import sys
    
    if len(sys.argv) < 5:
        usage()
        sys.exit()
    
    projectRoot = sys.argv[1]
    filterName = sys.argv[2]
    ngramN = int(sys.argv[3])
    smallerNgramsToo = True
    if sys.argv[4] == '0':
        smallerNgramsToo = False
    
    if len(sys.argv) > 5:
        sink = sys.argv[5]
    else:
        sink = None
    
    if projectRoot[-1] != '/': projectRoot += '/'
   
    embedFunctions(projectRoot, filterName, ngramN, smallerNgramsToo, sink) 
    