package tools.udg;

import output.neo4j.batchInserter.ImportedNodeListener;

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
