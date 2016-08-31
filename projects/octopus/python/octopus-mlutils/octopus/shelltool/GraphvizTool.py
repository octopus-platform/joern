
from octopus.shelltool.PipeTool import PipeTool
from pygraphviz import AGraph

class GraphvizTool(PipeTool):
    
    def __init__(self, description):
        PipeTool.__init__(self, description)
        self.lines = []

    # @Override
    def processLine(self, line):
        ENDMARKER = '//###'
        
        if line == ENDMARKER:
            self.processLines()
            self.lines = []
        else:
            self.lines.append(line)
            
    def processLines(self):
        if len(self.lines) == 0:
            return
        
        self.identifier = self.lines[0][2:]

        s = '\n'.join(self.lines)
        A = AGraph()
        G = A.from_string(s)
        self.processGraph(G)
        

    def processGraph(self, G):
        print(G)

    # @Override
    def streamEnd(self):
        if self.lines != []:
            self.processLines()

    def _outputGraph(self, G, identifier):
        ENDMARKER = '//###'
        self.output('//' + identifier + '\n')
        self.output(str(G) + '\n')
        self.output(ENDMARKER + '\n')

if __name__ == '__main__':
    tool = GraphvizTool('foo')
    tool.run()

