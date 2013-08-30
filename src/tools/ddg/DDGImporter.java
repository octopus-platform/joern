package tools.ddg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import output.neo4j.EdgeTypes;
import output.neo4j.Neo4JBatchInserter;
import tools.ddg.DDG.DefUseRelation;

public class DDGImporter
{

	public void importDDG(DDG ddg)
	{
		RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.REACHES);	
		
		Map<String, Object> properties = new HashMap<String, Object>();
		
		List<DefUseRelation> defUseEdges = ddg.getDefUseEdges();
		if(defUseEdges == null)
			return;
		
		for(DefUseRelation defUseRel : defUseEdges){			
			properties.put("var", defUseRel.symbol);
			Neo4JBatchInserter.addRelationship(defUseRel.src, defUseRel.dst, rel, properties);		
		}
	}
	
}
