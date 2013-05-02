import cPickle as pickle
import numpy

class FunctionContext:
    def __init__(self, symbol):
        self.symbol = symbol
        self.neighbours = []
        
        self.gammaA = None
        self.gammaC = 0.0
        self.mue = None
        self.originVector = None
        self.deviationVec = None
        self.index2Term = None
        self.origin = None
        
    def setOrigin(self, o):
        self.origin = o
    
    def setImportance(self, i):
        self.importance = i
        
    def addNeighbour(self,n):
        self.neighbours.append(n)
        
    def printContext(self):
        print '========================================='
        print 'Context for (%s,%f)' % (self.symbol, self.importance)
        self.printNeighbourhood()
        if self.mue != None:
            print '-- Model --'
            print 'Gamma API Space: %f, %f' % (self.gammaA, self.gammaA / len(self.neighbours))
            print 'Gamma Expression Space: %f' % (self.gammaC)
            self.printModel()
            self.printDeviation()
    
    def printNeighbourhood(self):
        print "Number of Neighbours: %d" % (len(self.neighbours))
        print '========================================='
        print 'Distance\tOccurrences\tLocation'
        for neighbour in self.neighbours:
            distance = neighbour.distance
            location = neighbour.location
            nOccurrences = neighbour.nOccurrences
            print '%f\t%f\t%s' % (distance, nOccurrences, location)
        
    
    def printModel(self):
        print '--- Model (Top 10) ---'
        if self.mue == None:
            print 'None'
            return
        model = []
        for i in xrange(self.mue.shape[1]):
            model.append((self.mue[0,i], self.index2Term[i]))
        model.sort(reverse=True)
        model = model[:31]
        for m in model: print m
        
        
    def printDeviation(self):
        print '--- Deviation (Top 10) ---'
        if self.deviationVec == None:
            print 'None'
            return
        dev = []
        for i in xrange(self.deviationVec.shape[1]):
            dev.append((self.deviationVec[0,i], self.index2Term[i]))
        dev.sort()
        dev = dev[:31]
        for d in dev: print d
    
    
class FunctionNeighbour:
    def __init__(self, location):
        self.location = location
    
    def setDistance(self, d):
        self.distance = d
    
    def setNSymbolOccurrences(self, o):
        self.nOccurrences = o
    
    def setExpressions(self, e):
        self.expressions = e

    
class FunctionContextProvider:
    def __init__(self, projectRoot):
        embedDir = projectRoot + 'embeddings/'
        self.apiUsageDir = embedDir + 'APISymbols_1.pickl/'
        self.symbolsDir = embedDir + 'Symbols_1.pickl/'
        self._loadRequiredData()

    def configure(self, kmin, kmax, tau, symbolsOfInterest):
        
        # 1, 11, 0.9
        self.k = int(kmin) # (including the function itself)
        self.maxk = int(kmax)
        self.tau = float(tau)
        self.symbolsOfInterest = symbolsOfInterest

    
    def _loadRequiredData(self):
        
        func2SubtreesFilename = self.apiUsageDir + 'func2SubtreesMap.pickl'
        self.APIfunc2SubtreesMap = pickle.load(file(func2SubtreesFilename))
        self.APItermDocMatrix = pickle.load(file(self.apiUsageDir + 'termDocMatrix.pickl'))
        self.APItermDocMatrix.matrix = self.APItermDocMatrix.matrix.tocsr()
        self.D = self._loadDistanceMatrix('cosine')
        
        func2SubtreesFilename = self.symbolsDir + 'func2SubtreesMap.pickl'
        self.Symbolfunc2SubtreesMap = pickle.load(file(func2SubtreesFilename))
        self.SymboltermDocMatrix = pickle.load(file(self.symbolsDir + 'termDocMatrix.pickl'))
        self.SymboltermDocMatrix.matrix = self.SymboltermDocMatrix.matrix.tocsr()
        
        
        
    def _loadDistanceMatrix(self, metric):
        from scipy.spatial.distance import squareform
        filename = self.apiUsageDir + 'D_%s.pickl' % (metric)
        D = squareform(pickle.load(file(filename)), checks=False)
        # import h5py
        # D = h5py.File(filename, 'r')['distanceM']
        return D

    def getContextsForFunction(self, functionLocation):
        if functionLocation[-1] == '/':
            functionLocation = functionLocation[:-1]
        
        symbolsContainedInFunc = self.getSymbolsForFunction(functionLocation)

        if not self.symbolsOfInterest:
            print 'REACHED'
            symbols = symbolsContainedInFunc
        else:
            symbols = set(self.symbolsOfInterest) & set(symbolsContainedInFunc)
        
        retDict = {}
        for symbol in symbols:
            if self.isSymbolNotOfInterest(symbol):
                continue
            print 'Keeping: %s' % (symbol)
            context = self.getGlobalContext(functionLocation, symbol)
            if len(context.neighbours) != 0:
                retDict[symbol] = context
        return retDict

    def getSymbolsForFunction(self, location):
        try:
            symbols = self.Symbolfunc2SubtreesMap.d[location]
            return symbols
        except:
            print 'WARNING: No symbols found for: %s' % (location)
            return []
    
    def getFunctionLocationsUsingSymbol(self, functionName, symbol):
        functionIndex = self.SymboltermDocMatrix.doc2Index[functionName]
        symbolIndex = self.SymboltermDocMatrix.term2Index[symbol]
        matrix = self.SymboltermDocMatrix.matrix
        
        row = matrix[symbolIndex, :]
        functionIndices = row.indices
        
        importance = matrix[symbolIndex, functionIndex]
        
        return (importance, [self.SymboltermDocMatrix.index2Doc[i] for i in functionIndices])

    def getGlobalContext(self, functionName, symbol):
        return self.getContext(functionName, symbol)

    def getContext(self, functionName, symbol):
        
        (importanceOfSymbol, locations) = self.getFunctionLocationsUsingSymbol(functionName, symbol)        
        functionIndices = [self.APItermDocMatrix.doc2Index[l] for l in locations]
        
        functionIndex = self.APItermDocMatrix.doc2Index[functionName]
        distances = self.D[numpy.array(functionIndex),functionIndices]
        
        # determine nearest neighbours from functions using symbol

        if self.maxk > len(distances):
            nAtMax = len(distances)
        else:
            nAtMax = self.maxk
        
        nn = [functionIndices[x] for x in distances.argsort()[:nAtMax]]
        locations = [self.APItermDocMatrix.index2Doc[i] for i in nn]
        distances.sort()
        distances = distances[:nAtMax]    
        
        nOccurrences = [self.getNumberOfOccurrences(l, symbol) for l in locations]
        
        functionContext = FunctionContext(symbol)
        functionContext.setImportance(importanceOfSymbol)
                
        kiter = 1
        for (l, d, o) in zip(locations, distances, nOccurrences):        
            newNeighbour = FunctionNeighbour(l)
            newNeighbour.setDistance(d)
            newNeighbour.setNSymbolOccurrences(o)
            
            if kiter >= self.k and d > self.tau:
                # print 'FOO: %f' % d
                break
            
            if l == functionName:
                functionContext.setOrigin(newNeighbour)
            else:
                functionContext.addNeighbour(newNeighbour) 
            kiter += 1
        
        if functionContext.origin == None:
            print 'Warning: Origin not set: '
            o = FunctionNeighbour(functionName)
            o.setDistance(0.0)
            o.setNSymbolOccurrences(self.getNumberOfOccurrences(functionName, symbol))
            functionContext.setOrigin(o)
            

        return functionContext
    
    def printContextsForFunction(self, contexts):
        
        print '--- Contexts for function --- '
        
        l = [(context.importance, context) for (unused, context) in contexts.iteritems()]
        l.sort(reverse=True)

        print 'Total Number of symbols to check: %d' % len(l)
        
        for (unused, context) in l:
            context.printContext()
           
    def getNumberOfOccurrences(self, location, symbol):
        try:
            return self.Symbolfunc2SubtreesMap.d[location][symbol]
        except KeyError:
            return 0

    def isSymbolNotOfInterest(self, symbol):
        cleanerSymbol = symbol[2:-2]
                
        # Discard types
        if cleanerSymbol.startswith('type:'):
            return True

        # Discard locals for the evaluation:
        if cleanerSymbol.startswith('local:'):
            return True

        # filter string literals
        if cleanerSymbol.startswith('"') or symbol.startswith("'"):
            return True
        
        # filter numeric literals
        if cleanerSymbol[0].isdigit():
            return True
        if cleanerSymbol.startswith('0x'):
            return True
        
        if cleanerSymbol[0] == '(' and cleanerSymbol[-1] == ')':
            return True
        
        if cleanerSymbol == 'NULL':
            return True
        
        if cleanerSymbol in ['>', '<', '<=', '>=', '==', '!=']:
            return True
        
        if cleanerSymbol.startswith('!'):
            return True
        
        if cleanerSymbol.startswith('--') or cleanerSymbol.endswith('--'):
            return True

        if cleanerSymbol.startswith('++') or cleanerSymbol.endswith('++'):
            return True

        return False
    