package tools.ddgPatch;

import java.util.LinkedList;
import java.util.List;

import org.neo4j.graphdb.Node;

import output.neo4j.Neo4JDBInterface;
import tools.ddg.CFGForDDGCreation;
import tools.ddg.CFGForDDGFactory;

public class DDGPatchMain {

	static CFGForDDGFactory factory = new ReadWriteDbFactory();
	
	public static void main(String[] args)
	{
		String source = "copy_from_user";
		String tainted_arg = "0";
			
		Neo4JDBInterface.setIndexDirectoryName(".joernIndex");
		Neo4JDBInterface.openDatabase();
		
		List<Node> sourceUsers = getFunctionsCallingFromIndex(source);
		for(Node funcNode : sourceUsers){
			// CFGForDDGCreation cfgForDDG = factory.create(funcNode.getId());
			// patchCFGForDDG(cfgForDDG);
			System.out.println(funcNode.getId());
		}
				
		Neo4JDBInterface.closeDatabase();
	}

	private static List<Node> getFunctionsCallingFromIndex(String source)
	{
		List<Node> retval = new LinkedList<Node>();
		String query = "type:CallExpression AND code:" + source + "*";
				
		for(Node n : Neo4JDBInterface.queryIndex(query))
			retval.add(n);
		return retval;
	}

	private static void patchCFGForDDG(CFGForDDGCreation cfgForDDG)
	{
		// TODO Auto-generated method stub		
	}

}
