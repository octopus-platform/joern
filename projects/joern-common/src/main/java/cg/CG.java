package cg;

import graphutils.IncidenceListGraph;

/**
 * Call Graph. Consider this to be the target format of CGFactories.
 * Please place language specific attributes of the CG into a sub-class.
 */
public class CG extends IncidenceListGraph<CGNode, CGEdge> {

	public int numberOfCallees() {
		
		return getVertices().stream().filter(v -> v.isCallee()).toArray().length;
	}
	
	public int numberOfCallers() {
		
		return getVertices().stream().filter(v -> !v.isCallee()).toArray().length;
	}
	

}
