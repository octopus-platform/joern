from joern.shelltool.JoernTool import JoernTool

class TraversalTool(JoernTool):

    def __init__(self, DESCRIPTION):
        JoernTool.__init__(self, DESCRIPTION)

    # @Override
    def processLine(self, line):
        query = self.queryFromLine(line)

        y = self._runGremlinQuery(query)
        self.outputResult(y)

    # @Override
    def queryFromLine(self, line):
        return line

    def outputResult(self, result):

        if type(result) == type([]):
            for r in result:
                self.output(str(r) + '\n')
        else:
            self.output(str(result) + '\n')
