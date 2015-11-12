package tools.phpast2cfg;

import java.util.Arrays;
import java.util.List;

import inputModules.csv.KeyedCSV.CSVKey;

public class PHPCSVNodeTypes
{
	/* node row keys */
	public static final CSVKey NODE_ID = new CSVKey("id","ID");
	// node properties shared by all nodes (cf. ast\Node specification
	// in {@link https://github.com/nikic/php-ast})
	public static final CSVKey TYPE = new CSVKey("type");
	public static final CSVKey FLAGS = new CSVKey("flags","string[]");
	public static final CSVKey LINENO = new CSVKey("lineno","int");
	// node properties for declaration nodes  (cf. ast\Node\Decl specification
	// in {@link https://github.com/nikic/php-ast}
	public static final CSVKey ENDLINENO = new CSVKey("endlineno","int");
	public static final CSVKey NAME = new CSVKey("name");
	public static final CSVKey DOCCOMMENT = new CSVKey("doccomment");
	// meta-properties
	public static final CSVKey CODE = new CSVKey("code");
	public static final CSVKey CHILDNUM = new CSVKey("childnum","int");
	public static final CSVKey FUNCID = new CSVKey("funcid","int");

	/* node types */
	// directory/file types
	public static final String TYPE_FILE = "File";
	public static final String TYPE_DIRECTORY = "Directory";

	// special nodes
	public static final String TYPE_NAME = "AST_NAME";
	public static final String TYPE_CLOSURE_VAR = "AST_CLOSURE_VAR";

	// declaration nodes
	public static final String TYPE_TOPLEVEL = "AST_TOPLEVEL"; // artificial
	public static final String TYPE_FUNC_DECL = "AST_FUNC_DECL";
	public static final String TYPE_METHOD = "AST_METHOD";
	public static final String TYPE_CLOSURE = "AST_CLOSURE";

	public static final List<String> funcTypes =
			Arrays.asList(TYPE_TOPLEVEL, TYPE_FUNC_DECL, TYPE_METHOD, TYPE_CLOSURE);

	public static final String TYPE_CLASS = "AST_CLASS";

	// nodes with exactly 2 children
	public static final String TYPE_WHILE = "AST_WHILE";
	public static final String TYPE_DO_WHILE = "AST_DO_WHILE";

	// nodes with exactly 3 children
	public static final String TYPE_PARAM = "AST_PARAM";

	// nodes with exactly 4 children
	public static final String TYPE_FOR = "AST_FOR";

	// nodes with an arbitrary number of children
	public static final String TYPE_STMT_LIST = "AST_STMT_LIST";
	public static final String TYPE_IF = "AST_IF";
	public static final String TYPE_PARAM_LIST = "AST_PARAM_LIST";
	public static final String TYPE_CLOSURE_USES = "AST_CLOSURE_USES";

	/* node flags */
	// flags for toplevel nodes
	public static final String FLAG_TOPLEVEL_FILE = "TOPLEVEL_FILE"; // artificial
	public static final String FLAG_TOPLEVEL_CLASS = "TOPLEVEL_CLASS"; // artificial
}
