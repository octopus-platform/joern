from libjoern.pythonast.TreeToTokenStream import TreeToTokenStream
from libjoern.pythonast.SubtreeProcessors import getSubtreeValueFromNode

class SymbolFilter(TreeToTokenStream):
    def __init__(self):
        TreeToTokenStream.__init__(self)
        
        self.handlers['CALLEE'] = self.newCallHandler
        self.handlers['PARAMETER_DECL'] = self.newParamHandler
        self.handlers['VAR_DECL'] = self.newDeclHandler
        self.handlers['FIELD'] = self.nonFuncCallHandler
        self.handlers['UNARY_EXPR'] = self.nonFuncCallHandler
        
    def reset(self):
        self.localNames = {}
        self.paramNames = {}
        
    def nonFuncCallHandler(self, node):
        rowContent = node.row[4]
        
        if rowContent in self.localNames:
            self.s.write('type: %s\n' % (self.localNames[rowContent]))
            # self.s.write('local: %s\n' % (rowContent))
            self.s.write('local: %s %s\n' % (self.localNames[rowContent], rowContent))
            
            return True
        
        if rowContent in self.paramNames:
            self.s.write('type: %s\n' % (self.paramNames[rowContent]))
            self.s.write('param: %s %s\n' % (self.paramNames[rowContent], rowContent))
            return True
        
        self.s.write('%s\n' % (rowContent))
        return True
        
    def newCallHandler(self, node):
        self.s.write('call: %s\n' % (node.row[4]))
        return True
    
    def newDeclHandler(self, node):
        typeName = getSubtreeValueFromNode(node, 'TYPE')
        identifier = getSubtreeValueFromNode(node, 'NAME')
        self.localNames[identifier] = typeName
        # self.s.write('type: %s\n' % (typeName))
        # self.s.write('local: %s\n' % (identifier))
        
        # add typename to local
        self.s.write('type: %s\n' % (typeName))
        self.s.write('local: %s %s\n' % (typeName, identifier))
        
        return True
     
    def newParamHandler(self, node):
        
        typeName = getSubtreeValueFromNode(node, 'TYPE')
        identifier = getSubtreeValueFromNode(node, 'NAME')
        
        self.paramNames[identifier] = typeName
        self.s.write('type: %s\n' % (typeName))
        if identifier: self.s.write('param: %s %s\n' % (typeName, identifier))
        return False
    