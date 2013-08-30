package tools.ddg;

import tools.ImportedNodeListener;

public class DDGListener extends ImportedNodeListener {
	
	@Override
	public void visitNode(Long funcId)
	{
		DDGCreator ddgCreator = new DDGCreator();
		DDGImporter ddgImporter = new DDGImporter();
		
		DDG ddg = ddgCreator.create(funcId);		
		if(ddg == null) return;
		ddgImporter.importDDG(ddg);
	}

}
