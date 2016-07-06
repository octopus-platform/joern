from joern.shelltool.JoernTag import JoernTag

BATCH_SIZE = 1000

class JoernHide(JoernTag):
    
    def __init__(self, DESCRIPTION):
        JoernTag.__init__(self, DESCRIPTION)
    
    def processLine(self, line):
        
        hidden = '1'
        self._processLine(line, hidden)
    
    def _processLine(self, line, hidden):
        
        try:
            nodeId = int(line)
            newPairs = [[nodeId, hidden]]
        except ValueError:
            
            newNodeIds = self._getFileIdsForDir(line)
            newPairs = [[nodeId, hidden] for nodeId in newNodeIds]
        
        self.inputPairs.extend(newPairs)
        
        self.args.tag = 'hidden'
        while len(self.inputPairs) >= BATCH_SIZE:
            batch = self.inputPairs[:BATCH_SIZE]
            
            self.processBatch(batch)
            self.inputPairs = self.inputPairs[BATCH_SIZE:]

    
    def _getFileIdsForDir(self, line):
        query = """
        queryNodeIndex("type:File AND filepath:*%s*").id
        """ % (line)
        return self._runGremlinQuery(query)