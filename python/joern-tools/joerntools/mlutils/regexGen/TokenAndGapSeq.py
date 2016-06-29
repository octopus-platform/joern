from TokenExtractor import TokenExtractor
from GapStringExtractor import GapStringExtractor

import re

class TokenAndGap:
    def __init__(self, token, gapFillers):
        self.token = token
        self.gapFillers = gapFillers

class TokenAndGapSeq:
    
    def __init__(self, strings):
        
        self.tokenExtractor = TokenExtractor()
        self.gapStringExtractor = GapStringExtractor()
        
        tokens = self.tokenExtractor.extract(strings)
        gapStrings = self.gapStringExtractor.extract(strings, tokens)
        gapFillers = self.gapStringExtractor.convert(gapStrings)

        assert len(tokens) == len(gapFillers)

        self.seq = []
        nTokens = len(tokens)
        for i in range(nTokens):
            self.seq.append(TokenAndGap(tokens[i], gapFillers[i]))
        
    def toRegex(self):
        
        nStrings = self._getNGapFillers()
        nGaps = self.getNGaps()

        prefixes = self.seq[0].gapFillers
        curRegex = ''

        for j in range(1, nGaps):
            
            gapFillers = self.seq[j].gapFillers
            curRegex += self._join(prefixes) + re.escape(self.seq[j-1].token)
            prefixes = self._uniq([filler for filler in gapFillers])
        
        curRegex += self._join(prefixes)
            
        return curRegex

    def _join(self, prefixes):
        if len(prefixes) == 1:
            
            if prefixes[0] == '.*':
                return '.*'
            else:
                return re.escape(prefixes[0])
            
        nonEmptyStrings = [s for s in prefixes if s != '']
        uniqNonEmpty = self._uniq(nonEmptyStrings)

        regex =  '(' +  '|'.join([ '%s' % re.escape(p) for p in uniqNonEmpty]) + ')'
        if regex == '()':
            regex = ''

        if len(prefixes) != len(nonEmptyStrings) and len(nonEmptyStrings) != 0:
            regex += '?'

        return regex

    def setWildcard(self, i):
        self.seq[i].gapFillers =  ['.*']

    def getGapFillers(self, i):
        return self.seq[i].gapFillers
    
    def setGapFillers(self, i, fillers):
        self.seq[i].gapFillers = fillers

    def merge(self, i):
        
        left = self.seq[i]
        right = self.seq[i + 1]

        self.seq[i + 1].gapFillers = [left.gapFillers[j] + left.token + right.gapFillers[j]
                                      for j in range(len(left.gapFillers))]
        del self.seq[i]
        
    def mostVagueRegex(self):
        # TODO: optimize this

        from copy import deepcopy
        newObj = deepcopy(self)
        
        for i in range(0, newObj.getNGaps()):
            newObj.setWildcard(i)
        return newObj
        

    def _getNGapFillers(self):
        return len(self.seq[0].gapFillers)

    def getNGaps(self):
        return len(self.seq)
        
    def _uniq(self, seq):
        seen = set()
        seen_add = seen.add
        return [ x for x in seq if x not in seen and not seen_add(x)]
