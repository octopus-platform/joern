
class NgramCalculator:
    
    def __init__(self):
        self.N = 3
        self.smallerNgramsToo = True
    
    def setSmallerNgramsToo(self, boolVal):
        self.smallerNgramsToo = boolVal
    
    def setNgramN(self, n):
        self.N = n
    
    def ngramsForFile(self, filename):
        
        f = file(filename)
        l = [row[:-1] for row in f.readlines()]
        f.close()
        
        return self.ngramsForRows(l)
    
    def ngramsForRows(self,iRows):
        ngrams = []

        if iRows == []:
            return []
        
        s = '\n'.join(iRows)
        units = s.split('\n\n')

        for unit in units:
            
            rows = unit.split('\n')
            if len(rows) >= 1 and rows[-1] == '':
                rows = rows[-1]
            
            
            if self.smallerNgramsToo == True:
                for i in xrange(self.N):
                    ngrams.extend([r for r in self.genNgrams(rows,i+1) if not len(r) == 0])
            else:
                ngrams.extend([r for r in self.genNgrams(rows,self.N) if not len(r) == 0])
        
        return ngrams
    
    def genNgrams(self, l, n):
        return [l[i:i+n] for i in xrange(len(l) - n + 1)]