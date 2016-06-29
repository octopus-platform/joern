
class GapStringExtractor:
    
    def extract(self, M, tokens):
        """
        Returns a list of gap-string where each element
        of the list contains the gap-strings for one of
        the strings in m
        """

        gapStrings = []
        for m in M:
            tokenIndices = self._getTokenIndices(m, tokens)
            assert len(tokens) == len(tokenIndices)
            
            gapStringsForM = [self._getNthGap(m, tokenIndices, tokens, n)
                              for n in xrange(len(tokens))]
            gapStrings.append(gapStringsForM)
            

        return gapStrings
    
    def convert(self, oldGapStrings):
        """
        Convert a list of gap-strings as created by `extract` to
        a list of gap-strings where each element corresponds to
        one of the gaps.
        """
        if len(oldGapStrings) == 0:
            return []

        gapStrings = []
        nGaps = len(oldGapStrings[0])
        for i in range(nGaps):
            gapStrings.append([])
        
        for datapoint in oldGapStrings:
            for i in range(len(datapoint)):
                gapStrings[i].append(datapoint[i])
        
        return gapStrings


    def _getTokenIndices(self, aStr, tokens):
        
        lastIndex = 0
        indices = []
        
        for token in tokens:
            if token == '$':
                indices.append(len(aStr))
            else:
                pos = aStr.find(token, lastIndex)
                lastIndex = pos + len(token)
                indices.append(pos)

        return indices
        
    
    def _getNthGap(self, aStr, tokenIndices, tokens, n):
        """
        Extract the sub-string between the n-1'th and the n'th token.
        
        If n is 0, extract the sub-string from the start of the
        string up to the first token.
        
        """
        if n == 0:
            return aStr[:tokenIndices[0]]
        
        endLastTokenIdx = tokenIndices[n-1] + len(tokens[n-1])
        startThisTokenIdx = tokenIndices[n]
        return aStr[endLastTokenIdx:startThisTokenIdx]


    
