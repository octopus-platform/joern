
import re
from TokenAndGapSeq import TokenAndGapSeq

class StringSetToRegex:

    def convert(self, M, X):
        """
        Given a set of strings X, and a subset M, create a
        regular expression that captures all of the strings
        in M but none of the strings in X\M.
        """

        self.X = X
        self.M = M
        
        tokenAndGaps = TokenAndGapSeq(M)
        regex = self._refineRegex(tokenAndGaps)
        return regex
    
    def _refineRegex(self, tokenAndGaps):
        
        # Run the most vague regex first to determine the
        # maximum set of points this regex may cover.
        
        mostVague = tokenAndGaps.mostVagueRegex()
        mostVagueRegex = mostVague.toRegex()

        maxSet = self._getMatchingStrings(self.X, mostVagueRegex)
        if len(maxSet) - len(self.M) == 0:
            return mostVagueRegex

        # Next, fill gaps with "($a_1 | $a_2 | ... $a_n)" where $a_i is the
        # substring contained in this gap in the i'th string. Run this regex
        # on the strings in maxSet. If the number of matches is equal to the
        # size of C, continue. Else, merge first and second token and try
        # again until this holds.
        
        regex = tokenAndGaps.toRegex()
        curFPRate = self._nFalsePositives(regex, maxSet)
        
        while curFPRate != 0 and tokenAndGaps.getNGaps() != 1:
            tokenAndGaps.merge(0)
                
            regex = tokenAndGaps.toRegex()
            curFPRate = self._nFalsePositives(regex, maxSet)
            
            if curFPRate == 0:
                break

        nGaps = tokenAndGaps.getNGaps()
        
        if nGaps == 1:
            # No common tokens found
            # except for the END token
            # TODO: check this
            return tokenAndGaps.toRegex()

        for i in xrange(nGaps):
            
            fillersBackup = tokenAndGaps.getGapFillers(i)
            tokenAndGaps.setWildcard(i)
            
            newRegex = tokenAndGaps.toRegex()
            fpRate = self._nFalsePositives(newRegex, maxSet)
            
            if fpRate == 0:
                regex = newRegex
                continue
            
            tokenAndGaps.setGapFillers(i, fillersBackup)
            
            
        assert self._nFalsePositives(regex, maxSet) == 0
        return regex
            
    def _nFalsePositives(self, regex, maxSet):
        matches = self._getMatchingStrings(maxSet, regex)
        return len(matches) - len(self.M)

    def _getMatchingStrings(self, M, regex):
        prog = re.compile('^' + regex + '$')
        return [x.rstrip() for x in M if prog.match(x) != None]


