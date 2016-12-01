from joern.csvAST.CSVRowAccessors import CODE
import sys

class PythonASTTreeNode():
    def __init__(self, row):
        self.row = row
        self.children = []
        sys.setrecursionlimit(10000)

    def appendChild(self, child):
        self.children.append(child)

    def applyFunc(self, f):
        self.row = f(self.row)
        for child in self.children:
            child.applyFunc(f)
    
    def __str__(self):
        retStr = '@+'
        if self.row != None:
            try:
                rowStr = str(self.row[CODE])
            except IndexError:
                rowStr = ''
            rowStr = rowStr.replace('(', '\\(')
            rowStr = rowStr.replace(')', '\\)')
            retStr += rowStr
        
        for child in self.children:
            retStr += str(child)
        retStr += '+@'
        return retStr
