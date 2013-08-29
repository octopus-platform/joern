package tools.ddg;


import org.neo4j.graphdb.index.IndexHits;
import output.neo4j.Neo4JBatchInserter;


public class DDGEdgeAdder {

	long functionId;
	UseDefGraph useDefGraph = new UseDefGraph();
	
	public void addEdgesToFunction(Long funcId)
	{
		functionId = funcId;
		createUseDefGraph();
	}

	private void createUseDefGraph()
	{
		IndexHits<Long> basicBlocks = getBasicBlocks();			
		useDefGraph.initialize(basicBlocks);		
	}

	private IndexHits<Long> getBasicBlocks()
	{
		String query = "type:\"BasicBlock\" AND functionId:\"" + functionId + "\"";
		return Neo4JBatchInserter.queryIndex(query);
	}
	
}
