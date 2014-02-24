package traversals.batchInserter;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;

public class AST
{

	public static boolean isASTEdge(BatchRelationship rel)
	{	
		return Elementary.isEdgeOfType(rel, EdgeTypes.IS_AST_PARENT);
	}
	
	public static String getCalleeFromCall(Long nodeId)
	{
		Iterable<BatchRelationship> rels = Elementary.getEdges(nodeId);
		for(BatchRelationship rel : rels){
			if(Elementary.isIncomingEdge(nodeId, rel)) continue;
			if(!isASTEdge(rel)) continue;
			
			if(Elementary.getChildNumber(rel).equals("0"))
				return Elementary.getNodeCode(rel.getEndNode());
		}
		return "";
	}

	
}
