package tools.ddg;

import java.util.Stack;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import misc.MultiHashMap;

public class UseDefGraph {
	
	MultiHashMap useDefDict = new MultiHashMap();
	
	long currentBasicBlock;

	public class UseDefStackItem{
		public long nodeId;
		public boolean isDef;
	
		public UseDefStackItem(long aNodeId, boolean aIsDef)
		{
			nodeId = aNodeId; isDef = aIsDef;
		}
	
	};
	
	Stack<UseDefStackItem> useDefStack = new Stack<UseDefStackItem>();
	
	public void initialize(IndexHits<Long> basicBlocksInFunc)
	{		
		
		for(Long basicBlockId : basicBlocksInFunc){						
			
			Long astRoot = getASTForBasicBlock(basicBlockId);
			if(astRoot == -1){
				// perfectly normal, e.g., empty blocks.
				continue;
			}			
			
			currentBasicBlock = basicBlockId;
			traverseAST(astRoot);			
		}
	}
	
	public MultiHashMap getUseDefDict()
	{
		return useDefDict;
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
		if(type != null){
		
			if(type.equals("Identifier"))
				handleIdentifier(nodeId);
			else if(type.equals("MemberAccess"))
				handleIdentifier(nodeId);
			else if(type.equals("PtrMemberAccess"))
				handleIdentifier(nodeId);
		}
									
		traverseChildren(nodeId, type);		
	}

	private void handleIdentifier(Long nodeId)
	{		
		String code = getNodeCode(nodeId);
		boolean use = false;
		boolean def = false;		
		
		// create entries for all elements on the stack
		for(UseDefStackItem item : useDefStack){
			if(item.isDef)
				def = true;			
			else				
				use = true;
			
			useDefDict.add(code, item);
		}
		
		// and for the basic block.
		
		if(def) useDefDict.add(code, new UseDefStackItem(currentBasicBlock, true));
		if(use) useDefDict.add(code, new UseDefStackItem(currentBasicBlock, false));
		
	}

	private String getNodeCode(Long nodeId) {
		return (String) Neo4JBatchInserter.getNodeProperties(nodeId).get("code");
	}

	private void traverseChildren(Long nodeId, String nodeType)
	{
		Iterable<BatchRelationship> rels = getEdges(nodeId);
		
		for(BatchRelationship rel : rels){
			if(isIncomingEdge(nodeId, rel)) continue;
			if(!isASTEdge(rel)) continue;
			
			long childId = rel.getEndNode();
			
			// skip right children of MemberAccess and PtrMemberAccess 
			if(nodeType.equals("MemberAccess") || nodeType.equals("PtrMemberAccess"))
			{				
				String childNumber = getChildNumber(rel);
				String childType = getNodeType(childId);
			
				if(childType != null && childNumber.equals("1") &&
				   childType.equals("Identifier"))
					continue;				
			}
			
			updateUseDefStackEnter(nodeId, rel);						
			traverse(childId);
			updateUseDefStackLeave(nodeId, rel);
			
		}
		
	}

	private void updateUseDefStackEnter(Long nodeId, BatchRelationship rel)
	{
		// Hardcoded rules to implement the difference between DEF and USE
		String nodeType = getNodeType(nodeId);
		String childType = getNodeType(rel.getEndNode());
		String childNum = getChildNumber(rel);
					
		if(nodeType.equals("AssignmentExpr"))
		{
			if(childNum.equals("0") && childType.equals("Identifier"))
				useDefStack.push( new UseDefStackItem(nodeId, true));
			else
				useDefStack.push( new UseDefStackItem(nodeId, false));
		}else if(nodeType.equals("IdentifierDecl")){
			if(childNum.equals("1") && childType.equals("Identifier"))
				useDefStack.push( new UseDefStackItem(nodeId, true));
		}else if(nodeType.equals("Condition") || nodeType.equals("Argument"))
			useDefStack.push( new UseDefStackItem(nodeId, false));		
	}

	private void updateUseDefStackLeave(Long nodeId, BatchRelationship rel)
	{
		// Whatever we push onto the stack needs to be taken off as well
		String nodeType = getNodeType(nodeId);
		String childType = getNodeType(rel.getEndNode());
		String childNum = getChildNumber(rel);
		
		if(nodeType.equals("AssignmentExpr"))
			useDefStack.pop();		
		else if(nodeType.equals("IdentifierDecl")){
			if(childNum.equals("1") && childType.equals("Identifier"))
				useDefStack.pop();
		}else if(nodeType.equals("Condition") || nodeType.equals("Argument"))
			useDefStack.pop();
	}
	
	private boolean isASTEdge(BatchRelationship rel)
	{	
		// there's probably a more efficient way of doing this
		return rel.getType().name().equals(EdgeTypes.IS_AST_PARENT);
	}

	private boolean isIncomingEdge(Long nodeId, BatchRelationship rel)
	{
		return rel.getEndNode() == nodeId;
	}
	
	private boolean isBasicBlockEdge(BatchRelationship rel)
	{			
		return rel.getType().name().equals(EdgeTypes.IS_BASIC_BLOCK_OF);
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
