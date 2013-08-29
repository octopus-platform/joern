package tools.ddg;

import java.util.Stack;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import misc.MultiHashMap;

public class UseDefGraph {
	
	MultiHashMap UseDict = new MultiHashMap();
	MultiHashMap DefDict = new MultiHashMap();			
	long currentBasicBlock;

	private class DefUseStackItem{
		long nodeId;
		boolean isDef;
	
		public DefUseStackItem(long aNodeId, boolean aIsDef)
		{
			nodeId = aNodeId; isDef = aIsDef;
		}
	
	};
	
	Stack<DefUseStackItem> defUseStack = new Stack<DefUseStackItem>();
	
	
	public void initialize(IndexHits<Long> basicBlocksInFunc)
	{		
		
		for(Long basicBlockId : basicBlocksInFunc){				
						
			Long astRoot = getASTForBasicBlock(basicBlockId);
			if(astRoot == -1){
				System.err.println("Warning: Basic Block without AST");
				continue;
			}			
			
			currentBasicBlock = basicBlockId;
			traverseAST(astRoot);			
		}
	}

	private Long getASTForBasicBlock(Long basicBlockId)
	{
		Iterable<BatchRelationship> rels = getEdges(basicBlockId);
		for(BatchRelationship rel : rels){
			if(isBasicBlockEdge(rel))
				return rel.getEndNode();
		}
		return new Long(-1);
	}

	private void traverseAST(Long astRoot)
	{		
		traverse(astRoot);
	}

	private void traverse(Long nodeId)
	{		
		String type = getNodeType(nodeId);		
		if(type != null && type.equals("Identifier"))
			handleIdentifier(nodeId);
		
		traverseChildren(nodeId);		
	}

	

	private void handleIdentifier(Long nodeId)
	{		
		
		// If immediate parent is a Decl-Node
		// and we are its second child (variable name), this is a DEF			
		
		// Otherwise, this is a use-node.
		
	}

	private void traverseChildren(Long nodeId)
	{
		Iterable<BatchRelationship> rels = getEdges(nodeId);
		for(BatchRelationship rel : rels){
			if(isIncomingEdge(nodeId, rel)) continue;
			if(!isASTEdge(rel)) continue;
		
			updateDefUseStackEnter(nodeId, rel);						
			traverse(rel.getEndNode());
			updateDefUseStackLeave(nodeId, rel);
			
		}
		
	}

	private void updateDefUseStackEnter(Long nodeId, BatchRelationship rel)
	{
		// Hardcoded rules to implement the difference between DEF and USE
		String nodeType = getNodeType(nodeId);
		String childType = getNodeType(rel.getEndNode());
		String childNum = getChildNumber(rel);
	
		System.out.println("REACHED");
		
		if(nodeType.equals("AssignmentExpr"))
		{
			if(childNum.equals("0") && childType.equals("Identifier"))
				defUseStack.push( new DefUseStackItem(nodeId, true));
			else
				defUseStack.push( new DefUseStackItem(nodeId, false));
		}else if(nodeType.equals("IdentifierDecl")){
			if(childNum.equals("1") && childType.equals("Identifier"))
				defUseStack.push( new DefUseStackItem(nodeId, true));
		}else if(nodeType.equals("Condition") || nodeType.equals("Argument"))
			defUseStack.push( new DefUseStackItem(nodeId, false));		
	}

	private void updateDefUseStackLeave(Long nodeId, BatchRelationship rel)
	{
		// Whatever we push onto the stack needs to be taken off as well
		String nodeType = getNodeType(nodeId);
		String childType = getNodeType(rel.getEndNode());
		String childNum = getChildNumber(rel);
		
		if(nodeType.equals("AssignmentExpr"))
			defUseStack.pop();		
		else if(nodeType.equals("IdentifierDecl")){
			if(childNum.equals("1") && childType.equals("Identifier"))
				defUseStack.pop();
		}else if(nodeType.equals("Condition") || nodeType.equals("Argument"))
			defUseStack.pop();
	}
	
	private boolean isASTEdge(BatchRelationship rel)
	{
		return rel.getType().equals(EdgeTypes.IS_AST_PARENT);
	}

	private boolean isIncomingEdge(Long nodeId, BatchRelationship rel)
	{
		return rel.getEndNode() == nodeId;
	}
	
	private boolean isBasicBlockEdge(BatchRelationship rel)
	{
		return rel.getType().equals(EdgeTypes.IS_BASIC_BLOCK_OF);
	}

	private Iterable<BatchRelationship> getEdges(Long nodeId)
	{
		return Neo4JBatchInserter.getRelationships(nodeId);
	}

	private String getNodeType(Long nodeId)
	{
		return (String) Neo4JBatchInserter.getNodeProperties(nodeId).get("type");
	}

	private String getChildNumber(BatchRelationship rel)
	{
		return (String) Neo4JBatchInserter.getRelationshipProperties(rel.getId()).get("n");
	}
	
}
