package tools.udg;


import org.neo4j.graphdb.index.IndexHits;
import output.neo4j.Neo4JBatchInserter;


public class UseDefGraphEdgeAdder {

	long functionId;
	UseDefGraph useDefGraph = new UseDefGraph();
	UseDefGraphImporter useDefGraphImporter = new UseDefGraphImporter();
	
	public void addEdgesToFunction(Long funcId)
	{
		functionId = funcId;
		createUseDefGraph();
	}

	private void createUseDefGraph()
	{
		IndexHits<Long> basicBlocks = getBasicBlocks();			
		useDefGraph.initialize(basicBlocks);		
		
		useDefGraphImporter.setFunctionId(functionId);
		useDefGraphImporter.importGraph(useDefGraph);
	}

	private IndexHits<Long> getBasicBlocks()
	{
		String query = "type:\"BasicBlock\" AND functionId:\"" + functionId + "\"";
		return Neo4JBatchInserter.queryIndex(query);
	}
	
}
