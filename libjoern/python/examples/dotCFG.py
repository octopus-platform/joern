################################################
# Create a graphviz .dot graph description
# file for the control flow graph of a function
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

cmd = "getFunctionByName('%s').funcBasicBlocks().transform{ [it.id, it.code, it.out('FLOWS_TO').id] } " % (functionName)

y = j.executeGremlinCmd(cmd)

print 'digraph myGraph{'

for (bbId, bbString, links) in y:
    print 'node%s [label="%s"]' % (bbId, normalizeCode(bbString))

for (bbId, bbString, links) in y:
    for l in links:
        print '"node%s":s->"node%s":n;' % (bbId, l) 

print '}'
