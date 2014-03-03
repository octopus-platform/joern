package tools.argumentTainter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import neo4j.EdgeTypes;
import neo4j.readWriteDB.Neo4JDBInterface;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import tools.ddg.DDG;
import tools.ddg.DDGCreator;
import tools.ddg.DDGDifference;
import tools.ddg.DefUseRelation;
import tools.ddg.DefUseCFGFactories.DefUseCFG;
import traversals.readWriteDB.Traversals;

public class DDGPatcher
{

	DDGDifference diff;
	
	public void patchDDG(DefUseCFG defUseCFG, Long funcId)
	{
		Node node = Neo4JDBInterface.getNodeById(funcId);
		
		DDG oldDDG = Traversals.getDDGForFunction(node);
		DDGCreator ddgCreator = new DDGCreator();
		DDG newDDG = ddgCreator.createForDefUseCFG(defUseCFG);
		
		diff = oldDDG.difference(newDDG);
	}

	
	public void writeChangesToDatabase()
	{
		Neo4JDBInterface.startTransaction();
		removeOldEdges(diff);
		addNewEdges(diff);
		Neo4JDBInterface.finishTransaction();
	}
	
	private void addNewEdges(DDGDifference diff)
	{
		List<DefUseRelation> relsToAdd = diff.getRelsToAdd();
		for(DefUseRelation rel : relsToAdd){
			
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("var", rel.symbol);
			RelationshipType relType = DynamicRelationshipType.withName(EdgeTypes.REACHES);
			
			Neo4JDBInterface.addRelationship(rel.src, rel.dst, relType, properties);	
		}
	}

	private void removeOldEdges(DDGDifference diff)
	{
		List<DefUseRelation> relsToRemove = diff.getRelsToRemove();
	
		for(DefUseRelation rel : relsToRemove){
			Node srcStatement = Neo4JDBInterface.getNodeById(rel.src);
			
			Iterable<Relationship> rels = srcStatement.getRelationships(Direction.OUTGOING);
			
			for(Relationship reachRel : rels){
				if(!reachRel.getType().toString().equals(EdgeTypes.REACHES))
					continue;
				
				if(reachRel.getEndNode().getId() != rel.dst)
					continue;
				
				Object var = reachRel.getProperty("var");
				if(var == null || !var.toString().equals(rel.symbol))
					continue;
				
				Neo4JDBInterface.removeEdge(reachRel.getId());
				break;
			}
		}
	}
	
}
