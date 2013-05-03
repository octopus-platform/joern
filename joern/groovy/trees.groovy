// Gremlin user-defined defined tree steps
// inTree() and outTree()
// by James Thornton, http://jamesthornton.com
 
// see https://groups.google.com/d/topic/gremlin-users/iCPUifiU_wk/discussion
 
// closure can't have the same name as the defined step
tree = { vertices ->
 
def results = []
 
vertices.each() {
results << [it.id, it.type, it.code]
if (label == null) {
children = it."$direction"().toList()
} else {
children = it."$direction"(label).toList()
}
if (children) {
child_tree = tree(children)
results << child_tree
}
}
results
}
 
 
inClosure = {final Object... params ->
try { label = params[0] }
catch(e){ label = null }
results = []
direction = "in"
_().transform{ tree(it) }
}
 
outClosure = {final Object... params ->
try { label = params[0] }
catch(e){ label = null }
results = []
direction = "out"
_().transform{ tree(it) }
}
 
Gremlin.defineStep("inTree", [Vertex,Pipe], inClosure)
Gremlin.defineStep("outTree", [Vertex,Pipe], outClosure)
