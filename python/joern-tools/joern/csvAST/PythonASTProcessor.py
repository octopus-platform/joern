
class PythonASTProcessor():
    def __init__(self):
        
        self.currentFile = None
        
    def processTree(self, node):
        
        traverseChildren = self.nodeHandler(node)
        if traverseChildren:
            self.processChildren(node)

    def processChildren(self, node = None):
        if node == None:
            node = self.tree
        
        for child in node.children:
            self.processTree(child)
    
    def nodeHandler(self, node):
        pass
