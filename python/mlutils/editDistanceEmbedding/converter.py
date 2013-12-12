from sourceutils.pythonASTs.PythonASTTreeNode import PythonASTTreeNode
import pickle
import tree

def locationToPygramTree(location):
    if location[-1] != '/': location += '/'
    pickleFilename = location + 'func_ast.pickl'
    pythonASTRoot = pickle.load(file(pickleFilename))
    return _convertNode(pythonASTRoot)

def _convertNode(node):
    label = _labelFromRow(node.row)
    newNode = tree.Node(label)
    for child in node.children:
        newNode.addkid(_convertNode(child))
    return newNode
  
def _labelFromRow(row):
    
    if row[0] in ['if', 'for', 'while', 'do', 'switch', 'case', 'break', 'continue', 'return']:
        return str(row[0])
    
    if row[0] in ['call', 'decl', 'param', 'op']:
        return str(row[4])
    
    return '*'
    