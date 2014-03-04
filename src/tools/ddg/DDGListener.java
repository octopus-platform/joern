package tools.ddg;

import tools.ddg.DataDependenceGraph.DDG;
import neo4j.batchInserter.ImportedNodeListener;
import neo4j.importers.DDGImporter;

public class DDGListener extends ImportedNodeListener {
	
	@Override
	public void visitNode(Long funcId)
	{
		DDGCreator ddgCreator = new DDGCreator();
		DDGImporter ddgImporter = new DDGImporter();
		
		DDG ddg = ddgCreator.createForFunctionById(funcId);		
		if(ddg == null) return;
		ddgImporter.importDDG(ddg);
	}

}
