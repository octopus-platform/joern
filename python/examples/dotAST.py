################################################
# Create a graphviz .dot graph description
# file for the abstract syntax tree of a function
# Useful for debugging.
################################################

from py2neo import neo4j, gremlin

import sys, os
sys.path.append(os.getcwd())
from libjoern import JoernSteps

def normalizeCode(code):
    code = code.replace('\\', '\\\\')
    code = code.replace('"', '\\"')
    return code

j = JoernSteps()
functionName = sys.argv[1]

cmd = " getFunctionByName('%s').functionToASTNodes().transform{ [it.id, it.type, it.code, it.out('IS_AST_PARENT').id] } " % (functionName)

y = j.executeGremlinCmd(cmd)

print 'digraph myGraph{'

for (bbId, bbType, bbString, links) in y:
    print 'node%s [label="%s"]' % (bbId, normalizeCode(bbType) + ': ' + normalizeCode(bbString))

for (bbId, bbType, bbString, links) in y:
    for l in links:
        print '"node%s":s->"node%s":n;' % (bbId, l) 

print '}'
