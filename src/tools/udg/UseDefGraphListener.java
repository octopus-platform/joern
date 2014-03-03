package tools.udg;

import tools.udg.useDefGraph.UseDefGraph;
import neo4j.batchInserter.ImportedNodeListener;
import neo4j.importers.UseDefGraphImporter;

public class UseDefGraphListener extends ImportedNodeListener {

	@Override
	public void visitNode(Long funcId)
	{
		createAndImportUseDefGraph(funcId);		
	}

	private void createAndImportUseDefGraph(Long funcId)
	{
		UseDefGraphCreator creator = new UseDefGraphCreator();
		UseDefGraphImporter useDefGraphImporter = new UseDefGraphImporter();
		
		UseDefGraph useDefGraph = creator.create(funcId);		
		useDefGraphImporter.setFunctionId(funcId);
		useDefGraphImporter.importGraph(useDefGraph);
	}

}
