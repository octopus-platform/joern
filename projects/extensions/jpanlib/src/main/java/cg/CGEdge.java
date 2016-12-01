package cg;

import graphutils.Edge;

public class CGEdge extends Edge<CGNode> {

	private static final String DEFAULT_LABEL = "CALL";
	
	public CGEdge(CGNode source, CGNode destination) {
		super(source, destination);
	}
	
	@Override
	public String toString() {
		return getSource() + " ==[" + DEFAULT_LABEL + "]==> " + getDestination();
	}
}
