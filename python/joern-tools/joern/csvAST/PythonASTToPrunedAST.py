from joern.csvAST.PythonASTTreeNode import PythonASTTreeNode
from joern.csvAST.PythonASTProcessor import PythonASTProcessor
from joern.csvAST.CSVRowAccessors import ROW_TYPE

PRUNED = 'pruned'
prunedRow = [PRUNED, '(*)', '(*)', '(*)', '']

class PythonASTToPrunedAST(PythonASTProcessor):
    def __init__(self):
        PythonASTProcessor.__init__(self)
        self.nodeTypesOfInterest = []
        self.keepNodesOfInterest = False

    def nodeHandler(self, node):
        self.prunedTree = self._pruneTree(node)
        return False

    def _pruneTree(self, node):
        return self._prune(node)
    
    def _prune(self, node):
        if self._mustPruneNode(node):
            r = prunedRow
        else:
            r = node.row
        
        newRootNode = PythonASTTreeNode(r)
        self.addPrunedChildren(node, newRootNode)
        return newRootNode
    
    def addPrunedChildren(self, node, root):
        for child in node.children:
            self._attachPruned(child, root)

    def _attachPruned(self, node, root):

        if self._mustPruneNode(node):
            self._pruneNode(node, root)
        else:
            newNode = PythonASTTreeNode(node.row)
            self.addPrunedChildren(node, newNode)
            root.appendChild(newNode)

    def _mustPruneNode(self, node):
        nodeType = node.row[ROW_TYPE]
        if (len(self.nodeTypesOfInterest) == 0): return False
        if self.keepNodesOfInterest and (nodeType in self.nodeTypesOfInterest): return False
        if (not self.keepNodesOfInterest) and (not(nodeType in self.nodeTypesOfInterest)): return False
        return True
    
    def _pruneNode(self, node, root):
        # If a leaf is to be pruned, discard it altogether
        if len(node.children) == 0: return
        newNode = PythonASTTreeNode(prunedRow)
        self.addPrunedChildren(node, newNode)
        if len(newNode.children) == 0: return
        root.appendChild(newNode)

    def getPrunedTree(self):
        return self.prunedTree
