package outputModules.neo4j.importers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import databaseNodes.EdgeTypes;
import ddg.DataDependenceGraph.DDG;
import ddg.DataDependenceGraph.DefUseRelation;

public class DDGImporter
{
	GraphNodeStore nodeStore;

	public DDGImporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	public void addDDGToDatabase(DDG ddg)
	{

		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.REACHES);

		Map<String, Object> properties = new HashMap<String, Object>();

		Set<DefUseRelation> defUseEdges = ddg.getDefUseEdges();
		if (defUseEdges == null)
			return;

		for (DefUseRelation defUseRel : defUseEdges)
		{
			properties.put("var", defUseRel.symbol);

			long srcId = nodeStore.getIdForObject(defUseRel.src);
			long dstId = nodeStore.getIdForObject(defUseRel.dst);

			Neo4JBatchInserter.addRelationship(srcId, dstId, rel, properties);
		}
	}

}
