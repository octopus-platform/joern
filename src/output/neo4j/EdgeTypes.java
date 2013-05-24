package output.neo4j;

public class EdgeTypes
{
	
	/** Edges connecting parent AST nodes with their children */
	public static final String IS_AST_PARENT = "IS_AST_PARENT";
	
	/** Edges connecting basic blocks with basic blocks they transfer control to*/
	public static final String FLOWS_TO = "FLOW_TO";
	
	/** Edges connecting a basic block to its corresponding AST node */
	public static final String IS_BASIC_BLOCK_OF = "IS_BASIC_BLOCK_OF";
	
	/** Edges connecting functions with all of their AST nodes*/
	public static final String IS_FUNCTION_OF_AST_NODE = "IS_FUNCTION_OF_AST_NODE";
	
	/** Edges connecting functions with all of their basic blocks*/
	public static final String IS_FUNCTION_OF_BASIC_BLOCK = "IS_FUNCTION_OF_BASIC_BLOCK";
	
	/** Edges connecting functions with the root AST node */
	public static final String IS_FUNCTION_OF_AST_ROOT = "AST_ROOT";
	
	/** Connects parent to child directories */
	public static final String IS_PARENT_DIR_OF = "IS_PARENT_DIR_OF";

	/** Connects file to the functions/classes/definitions it contains */
	public static final String IS_FILE_OF = "IS_FILE_OF";
}
