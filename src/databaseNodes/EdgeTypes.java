package databaseNodes;

public class EdgeTypes
{

	/** Connects parent to child directories */
	public static final String IS_PARENT_DIR_OF = "IS_PARENT_DIR_OF";

	/** Connects file to the functions/classes/definitions it contains */
	public static final String IS_FILE_OF = "IS_FILE_OF";

	/** Edges connecting the function node to the AST pseudo node */
	public static final String IS_FUNCTION_OF_AST = "IS_FUNCTION_OF_AST";

	/** Edges connecting parent AST nodes with their children */
	public static final String IS_AST_PARENT = "IS_AST_PARENT";

	/** Edges connecting the function node to the CFG pseudo node */
	public static final String IS_FUNCTION_OF_CFG = "IS_FUNCTION_OF_CFG";

	/** Edges connecting basic blocks with basic blocks they transfer control to */
	public static final String FLOWS_TO = "FLOWS_TO";

	/** Connects classes to their members */
	public static final String IS_CLASS_OF = "IS_CLASS_OF";

	/**
	 * Links declaration statements to the declarations contained in them
	 */
	public static final String DECLARES = "DECLARES";

	public static final String IS_ARG = "IS_ARG";

	public static final String DEF = "DEF";

	public static final String USE = "USE";

	public static final String REACHES = "REACHES";

	public static final String POST_DOM = "POST_DOM";

	public static final String CONTROLS = "CONTROLS";

}
