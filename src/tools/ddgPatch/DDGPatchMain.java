package tools.ddgPatch;

import java.util.List;

import output.neo4j.Neo4JDBInterface;
import tools.ddg.CFGForDDGCreation;
import tools.ddg.CFGForDDGFactory;

public class DDGPatchMain {

	static CFGForDDGFactory factory = new CFGForDDGFactory();
	
	public static void main(String[] args)
	{
		String source = "copy_from_user";
		String tainted_arg = "0";
			
		Neo4JDBInterface.setIndexDirectoryName(".joernIndex");
		Neo4JDBInterface.openDatabase();
		
		List<Long> sourceUsers = getFunctionsCallingFromIndex(source);
		for(Long funcId : sourceUsers){
			CFGForDDGCreation cfgForDDG = factory.create(funcId);
			patchCFGForDDG(cfgForDDG);
		}
				
		Neo4JDBInterface.closeDatabase();
	}

	private static List<Long> getFunctionsCallingFromIndex(String source)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private static void patchCFGForDDG(CFGForDDGCreation cfgForDDG)
	{
		// TODO Auto-generated method stub		
	}

}
