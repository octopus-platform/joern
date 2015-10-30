package tools.phpast2cfg;

import java.util.Arrays;
import java.util.List;

public class PHPCSVNodeTypes
{
	/* node row keys */
	public static final String NODE_ID = "id";
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String FUNCID = "funcid";

	/* node types */
	// directory/file types
	public static final String TYPE_FILE = "File";
	public static final String TYPE_DIRECTORY = "Directory";
	
	// function declaration nodes
	public static final String TYPE_TOPLEVEL = "AST_TOPLEVEL"; // artificial
	public static final String TYPE_FUNC_DECL = "AST_FUNC_DECL";
	public static final String TYPE_METHOD = "AST_METHOD";
	public static final String TYPE_CLOSURE = "AST_CLOSURE";
	
	public static final List<String> funcTypes =
			Arrays.asList(TYPE_TOPLEVEL, TYPE_FUNC_DECL, TYPE_METHOD, TYPE_CLOSURE);
	
	// nodes with an arbitrary number of children
	public static final String TYPE_STMT_LIST = "AST_STMT_LIST";
	public static final String TYPE_IF = "AST_IF";
	
	// nodes with exactly 2 children
	public static final String TYPE_WHILE = "AST_WHILE";
	public static final String TYPE_DO_WHILE = "AST_DO_WHILE";
	
	// nodes with exactly 4 children
	public static final String TYPE_FOR = "AST_FOR";



}
