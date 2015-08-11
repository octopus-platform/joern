package outputModules.neo4j.exporters;

import java.util.Map;

import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import outputModules.common.DDGExporter;
import databaseNodes.EdgeTypes;
import ddg.DataDependenceGraph.DefUseRelation;

public class Neo4JDDGExporter extends DDGExporter
{
	GraphNodeStore nodeStore;

	public Neo4JDDGExporter(GraphNodeStore aNodeStore)
	{
		nodeStore = aNodeStore;
	}

	@Override
	protected void addDDGEdge(Map<String, Object> properties,
			DefUseRelation defUseRel)
	{
		long srcId = nodeStore.getIdForObject(defUseRel.src);
		long dstId = nodeStore.getIdForObject(defUseRel.dst);

		RelationshipType rel = DynamicRelationshipType
				.withName(EdgeTypes.REACHES);

		Neo4JBatchInserter.addRelationship(srcId, dstId, rel, properties);
	}

}
