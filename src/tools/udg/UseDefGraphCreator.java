package tools.udg;

import java.util.Stack;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.unsafe.batchinsert.BatchRelationship;
import output.neo4j.QueryUtils;


public class UseDefGraphCreator
{
	
	long currentBasicBlock;
	UseDefGraph useDefGraph;
	
	Stack<UseOrDefRecord> useDefStack = new Stack<UseOrDefRecord>();	

	
	public UseDefGraph create(long functionId)
	{		
		useDefGraph = new UseDefGraph();
		
 		IndexHits<Long> basicBlocksInFunc = QueryUtils.getBasicBlocksFromIndex(functionId);
		
		for(Long basicBlockId : basicBlocksInFunc){						

			Long astRoot = QueryUtils.getASTForBasicBlock(basicBlockId);
			if(astRoot == -1){
				// perfectly normal, e.g., empty blocks.
				continue;
			}

			currentBasicBlock = basicBlockId;
			traverseAST(astRoot);			
		}
	
		return useDefGraph;
	}

	private void traverseAST(Long nodeId)
	{		
		String type = handleNodeBeforeExpansion(nodeId);
		traverseASTChildren(nodeId, type);		
	}

	private String handleNodeBeforeExpansion(Long nodeId)
	{
		String type = QueryUtils.getNodeType(nodeId);		
		if(type == null) return null;
				
		if(type.equals("Identifier"))
			handleIdentifier(nodeId);
		else if(type.equals("MemberAccess"))
			handleIdentifier(nodeId);
		else if(type.equals("PtrMemberAccess"))
			handleIdentifier(nodeId);

		return type;
	}

	private void handleIdentifier(Long nodeId)
	{		
		String code = QueryUtils.getNodeCode(nodeId);
		boolean use = false;
		boolean def = false;		

		// create entries for all elements on the stack
		for(UseOrDefRecord item : useDefStack){
			if(item.isDef){
				def = true;			
				useDefGraph.addDefinition(code, item.nodeId);
			} else {				
				use = true;
				useDefGraph.addUse(code, item.nodeId);
			}
							
		}

		// and for the basic block.

 		if(def) useDefGraph.addDefinition(code, currentBasicBlock);
		if(use) useDefGraph.addUse(code, currentBasicBlock);

	}

	private void traverseASTChildren(Long nodeId, String nodeType)
	{
		Iterable<BatchRelationship> rels = QueryUtils.getEdges(nodeId);

		for(BatchRelationship rel : rels){
			if(QueryUtils.isIncomingEdge(nodeId, rel)) continue;
			if(!QueryUtils.isASTEdge(rel)) continue;

			long childId = rel.getEndNode();

			// skip right children of MemberAccess and PtrMemberAccess 
			if(nodeType.equals("MemberAccess") || nodeType.equals("PtrMemberAccess"))
			{				
				String childNumber = QueryUtils.getChildNumber(rel);
				String childType = QueryUtils.getNodeType(childId);

				if(childType != null && childNumber.equals("1") &&
						childType.equals("Identifier"))
					continue;				
			}

			updateUseDefStackEnter(nodeId, rel);						
			traverseAST(childId);
			updateUseDefStackLeave(nodeId, rel);

		}

	}

	private void updateUseDefStackEnter(Long nodeId, BatchRelationship rel)
	{
		// Hardcoded rules to implement the difference between DEF and USE
		String nodeType = QueryUtils.getNodeType(nodeId);
		String childType = QueryUtils.getNodeType(rel.getEndNode());
		String childNum = QueryUtils.getChildNumber(rel);

		if(nodeType.equals("AssignmentExpr"))
		{
			if(childNum.equals("0"))
				useDefStack.push( new UseOrDefRecord(nodeId, true));
			else
				useDefStack.push( new UseOrDefRecord(nodeId, false));
		}else if(nodeType.equals("IdentifierDecl")){
			if(childNum.equals("1") && childType.equals("Identifier"))
				useDefStack.push( new UseOrDefRecord(nodeId, true));
		}else if(nodeType.equals("Condition"))
			useDefStack.push( new UseOrDefRecord(nodeId, false));		
		else if(nodeType.equals("Argument"))
			useDefStack.push( new UseOrDefRecord(nodeId, false));
		else if(nodeType.equals("ReturnStatement"))
			useDefStack.push( new UseOrDefRecord(nodeId, false));
			
	
	}

	private void updateUseDefStackLeave(Long nodeId, BatchRelationship rel)
	{
		// Whatever we push onto the stack needs to be taken off as well
		String nodeType = QueryUtils.getNodeType(nodeId);
		String childType = QueryUtils.getNodeType(rel.getEndNode());
		String childNum = QueryUtils.getChildNumber(rel);

		if(nodeType.equals("AssignmentExpr"))
			useDefStack.pop();		
		else if(nodeType.equals("IdentifierDecl")){
			if(childNum.equals("1") && childType.equals("Identifier"))
				useDefStack.pop();
		}else if(nodeType.equals("Condition") || nodeType.equals("Argument"))
			useDefStack.pop();
		else if(nodeType.equals("ReturnStatement"))
			useDefStack.pop();
	}
		
}
