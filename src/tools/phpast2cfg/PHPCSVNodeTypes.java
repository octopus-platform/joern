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

	// nodes with exactly 1 child
	// expressions
	public static final String TYPE_VAR = "AST_VAR";
	public static final String TYPE_YIELD_FROM = "AST_YIELD_FROM";
	
	// statements
	public static final String TYPE_GLOBAL = "AST_GLOBAL";
	public static final String TYPE_UNSET = "AST_UNSET";
	public static final String TYPE_RETURN = "AST_RETURN";
	public static final String TYPE_LABEL = "AST_LABEL";
	public static final String TYPE_REF = "AST_REF";
	public static final String TYPE_HALT_COMPILER = "AST_HALT_COMPILER";
	public static final String TYPE_ECHO = "AST_ECHO";
	public static final String TYPE_THROW = "AST_THROW";
	public static final String TYPE_GOTO = "AST_GOTO";
	public static final String TYPE_BREAK = "AST_BREAK";
	public static final String TYPE_CONTINUE = "AST_CONTINUE";

	// nodes with exactly 2 children
	// expressions
	public static final String TYPE_DIM = "AST_DIM";
	public static final String TYPE_PROP = "AST_PROP";
	public static final String TYPE_STATIC_PROP = "AST_STATIC_PROP";
	public static final String TYPE_CALL = "AST_CALL";
	public static final String TYPE_CLASS_CONST = "AST_CLASS_CONST";
	public static final String TYPE_ASSIGN = "AST_ASSIGN";
	public static final String TYPE_ASSIGN_REF = "AST_ASSIGN_REF";
	public static final String TYPE_ASSIGN_OP = "AST_ASSIGN_OP";
	public static final String TYPE_BINARY_OP = "AST_BINARY_OP";
	public static final String TYPE_GREATER = "AST_GREATER";
	public static final String TYPE_GREATER_EQUAL = "AST_GREATER_EQUAL";
	public static final String TYPE_AND = "AST_AND";
	public static final String TYPE_OR = "AST_OR";
	public static final String TYPE_ARRAY_ELEM = "AST_ARRAY_ELEM";
	public static final String TYPE_NEW = "AST_NEW";
	public static final String TYPE_INSTANCEOF = "AST_INSTANCEOF";
	public static final String TYPE_YIELD = "AST_YIELD";
	public static final String TYPE_COALESCE = "AST_COALESCE";
	
	// statements
	public static final String TYPE_STATIC = "AST_STATIC";
	public static final String TYPE_WHILE = "AST_WHILE";
	public static final String TYPE_DO_WHILE = "AST_DO_WHILE";
	public static final String TYPE_IF_ELEM = "AST_IF_ELEM";
	public static final String TYPE_SWITCH = "AST_SWITCH";
	public static final String TYPE_SWITCH_CASE = "AST_SWITCH_CASE";
	public static final String TYPE_DECLARE = "AST_DECLARE";
	public static final String TYPE_PROP_ELEM = "AST_PROP_ELEM";
	public static final String TYPE_CONST_ELEM = "AST_CONST_ELEM";
	public static final String TYPE_USE_TRAIT = "AST_USE_TRAIT";
	public static final String TYPE_TRAIT_PRECEDENCE = "AST_TRAIT_PRECEDENCE";
	public static final String TYPE_METHOD_REFERENCE = "AST_METHOD_REFERENCE";
	public static final String TYPE_NAMESPACE = "AST_NAMESPACE";
	public static final String TYPE_USE_ELEM = "AST_USE_ELEM";
	public static final String TYPE_TRAIT_ALIAS = "AST_TRAIT_ALIAS";
	public static final String TYPE_GROUP_USE = "AST_GROUP_USE";

	// nodes with exactly 3 children
	// expressions
	public static final String TYPE_METHOD_CALL = "AST_METHOD_CALL";
	public static final String TYPE_STATIC_CALL = "AST_STATIC_CALL";
	public static final String TYPE_CONDITIONAL = "AST_CONDITIONAL";

	// statements
	public static final String TYPE_TRY = "AST_TRY";
	public static final String TYPE_CATCH = "AST_CATCH";
	public static final String TYPE_PARAM = "AST_PARAM";

	// nodes with exactly 4 children
	// statements
	public static final String TYPE_FOR = "AST_FOR";
	public static final String TYPE_FOREACH = "AST_FOREACH";

	// nodes with an arbitrary number of children
	public static final String TYPE_ARG_LIST = "AST_ARG_LIST";
	public static final String TYPE_LIST = "AST_LIST";
	public static final String TYPE_ARRAY = "AST_ARRAY";
	public static final String TYPE_ENCAPS_LIST = "AST_ENCAPS_LIST";
	public static final String TYPE_EXPR_LIST = "AST_EXPR_LIST";
	public static final String TYPE_STMT_LIST = "AST_STMT_LIST";
	public static final String TYPE_IF = "AST_IF";
	public static final String TYPE_SWITCH_LIST = "AST_SWITCH_LIST";
	public static final String TYPE_CATCH_LIST = "AST_CATCH_LIST";
	public static final String TYPE_PARAM_LIST = "AST_PARAM_LIST";
	public static final String TYPE_CLOSURE_USES = "AST_CLOSURE_USES";
	public static final String TYPE_PROP_DECL = "AST_PROP_DECL";
	public static final String TYPE_CONST_DECL = "AST_CONST_DECL";
	public static final String TYPE_CLASS_CONST_DECL = "AST_CLASS_CONST_DECL";
	public static final String TYPE_NAME_LIST = "AST_NAME_LIST";
	public static final String TYPE_TRAIT_ADAPTATIONS = "AST_TRAIT_ADAPTATIONS";
	public static final String TYPE_USE = "AST_USE";

	/* node flags */
	// flags for toplevel nodes
	public static final String FLAG_TOPLEVEL_FILE = "TOPLEVEL_FILE"; // artificial
	public static final String FLAG_TOPLEVEL_CLASS = "TOPLEVEL_CLASS"; // artificial
}
