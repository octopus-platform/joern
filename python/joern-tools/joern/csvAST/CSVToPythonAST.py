from joern.csvAST.CSVProcessor import CSVProcessor
from joern.csvAST.CSVRowAccessors import getCSVRowLevel
from joern.csvAST.PythonASTTreeNode import PythonASTTreeNode

"""
A CSVProcessor which converts an AST in CSV format to an internal
python representation allowing transformations to be performed.
"""

class CSVToPythonAST(CSVProcessor):
    def __init__(self):
        CSVProcessor.__init__(self)
        
        self.rootNode = PythonASTTreeNode(None)
        self.parentStack = []
        self.previousNode = self.rootNode
        
        self.defaultHandler = self.handleNode
    
    def handleNode(self, row):
        newNode = PythonASTTreeNode(row)
        
        # code below fails if level ever
        # increases by more than one at once
        level = int(getCSVRowLevel(row))
        if level > len(self.parentStack) - 1:
            # moved down one level, push previous node
            self.parentStack.append(self.previousNode)
        elif level < len(self.parentStack) -1:
            while(level < len(self.parentStack) - 1):
                self.parentStack.pop()
        else:
            # stayed on a level, no need to adjust parentStack
            pass
                
        parentNode = self.parentStack[-1]
        parentNode.appendChild(newNode)
        
        self.previousNode = newNode
    
    def getResult(self):
        if self.rootNode.row == None:
            self.rootNode = self.rootNode.children[0]
        return self.rootNode
    
def pythonASTFromCSV(csvRows):
    converter = CSVToPythonAST()
    converter.processCSVRows(csvRows)
    return converter.getResult()
