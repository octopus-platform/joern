
from joern.csvAST.PythonASTProcessor import PythonASTProcessor

class ASTPrinter(PythonASTProcessor):
    
    def __init__(self):
        self.output = []

    def nodeHandler(self, node):
        self.output.append(str(node))
        return True

    def getOutput(self):
        return self.output
