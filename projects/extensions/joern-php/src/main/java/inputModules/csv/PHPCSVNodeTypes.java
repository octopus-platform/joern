package inputModules.csv;

import java.util.Arrays;
import java.util.List;

import inputModules.csv.KeyedCSV.CSVKey;

public class PHPCSVNodeTypes
{
	/* node row keys */
	
	public static final CSVKey NODE_ID = new CSVKey("id","int");
	// node labels (either Filesystem, AST or Artificial)
	public static final CSVKey LABEL = new CSVKey("labels","label");
	// node properties shared by all nodes (cf. ast\Node specification
	// in {@link https://github.com/nikic/php-ast})
	public static final CSVKey TYPE = new CSVKey("type");
	public static final CSVKey FLAGS = new CSVKey("flags","string_array");
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
	public static final CSVKey CLASSNAME = new CSVKey("classname");
	public static final CSVKey NAMESPACE = new CSVKey("namespace");

	
	/* node labels */
	public static final String LABEL_FS = "Filesystem";
	public static final String LABEL_AST = "AST";
	public static final String LABEL_ART = "Artificial";
	
	
	/* node types */
	
	// directory/file types
	public static final String TYPE_FILE = "File";
	public static final String TYPE_DIRECTORY = "Directory";

	// null nodes (leafs)
	// used as dummy child for nodes with a fixed number of children
	// that do not need a certain child in a given context, to keep
	// the number of their children constant
	// (e.g., a function node that does not specify its return type in
	// its declaration; see TestPHPCSVASTBuilderMinimal for more examples.)
	public static final String TYPE_NULL = "NULL";
	
	// primary expressions (leafs)
	public static final String TYPE_INTEGER = "integer";
	public static final String TYPE_DOUBLE = "double";
	public static final String TYPE_STRING = "string";

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

	// CFG entry and exit nodes
	public static final String TYPE_CFG_ENTRY = "CFG_FUNC_ENTRY";
	public static final String TYPE_CFG_EXIT = "CFG_FUNC_EXIT";

	// nodes without children (leafs)
	// expressions
	public static final String TYPE_MAGIC_CONST = "AST_MAGIC_CONST";
	public static final String TYPE_TYPE = "AST_TYPE";

	// nodes with exactly 1 child
	// expressions
	public static final String TYPE_VAR = "AST_VAR";
	public static final String TYPE_CONST = "AST_CONST";
	public static final String TYPE_UNPACK = "AST_UNPACK";
	public static final String TYPE_UNARY_PLUS = "AST_UNARY_PLUS";
	public static final String TYPE_UNARY_MINUS = "AST_UNARY_MINUS";
	public static final String TYPE_CAST = "AST_CAST";
	public static final String TYPE_EMPTY = "AST_EMPTY";
	public static final String TYPE_ISSET = "AST_ISSET";
	public static final String TYPE_SILENCE = "AST_SILENCE";
	public static final String TYPE_SHELL_EXEC = "AST_SHELL_EXEC";
	public static final String TYPE_CLONE = "AST_CLONE";
	public static final String TYPE_EXIT = "AST_EXIT";
	public static final String TYPE_PRINT = "AST_PRINT";
	public static final String TYPE_INCLUDE_OR_EVAL = "AST_INCLUDE_OR_EVAL";
	public static final String TYPE_UNARY_OP = "AST_UNARY_OP";
	public static final String TYPE_PRE_INC = "AST_PRE_INC";
	public static final String TYPE_PRE_DEC = "AST_PRE_DEC";
	public static final String TYPE_POST_INC = "AST_POST_INC";
	public static final String TYPE_POST_DEC = "AST_POST_DEC";
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
	
	// flags for TYPE_ARRAY_ELEM and TYPE_CLOSURE_VAR (exclusive)
	public static final String FLAG_BY_REFERENCE = "BY_REFERENCE"; // custom, see phpjoern commit 95cdc6b6de1c4b973775a97b90e8bf41c90f629b

	// flags for TYPE_NAME nodes (exclusive)
	public static final String FLAG_NAME_FQ = "NAME_FQ";
	public static final String FLAG_NAME_NOT_FQ = "NAME_NOT_FQ";
	public static final String FLAG_NAME_RELATIVE = "NAME_RELATIVE";

	// flags for TYPE_TOPLEVEL nodes (exclusive)
	public static final String FLAG_TOPLEVEL_FILE = "TOPLEVEL_FILE"; // artificial
	public static final String FLAG_TOPLEVEL_CLASS = "TOPLEVEL_CLASS"; // artificial
	
	// flags for TYPE_METHOD, TYPE_PROP_DECL and TYPE_TRAIT_ALIAS nodes (combinable)
	public static final String FLAG_MODIFIER_PUBLIC = "MODIFIER_PUBLIC";
	public static final String FLAG_MODIFIER_PROTECTED = "MODIFIER_PROTECTED";
	public static final String FLAG_MODIFIER_PRIVATE = "MODIFIER_PRIVATE";
	public static final String FLAG_MODIFIER_STATIC = "MODIFIER_STATIC";
	public static final String FLAG_MODIFIER_ABSTRACT = "MODIFIER_ABSTRACT";
	public static final String FLAG_MODIFIER_FINAL = "MODIFIER_FINAL";
	
	// flags for TYPE_CLOSURE nodes (combinable)
	//public static final String FLAG_MODIFIER_STATIC = "MODIFIER_STATIC"; // already defined above

	// flags for TYPE_FUNC_DECL, TYPE_METHOD, TYPE_CLOSURE nodes (combinable)
	public static final String FLAG_RETURNS_REF = "RETURNS_REF";
	
	// flags for TYPE_CLASS nodes (exclusive)
	public static final String FLAG_CLASS_ABSTRACT = "CLASS_ABSTRACT";
	public static final String FLAG_CLASS_FINAL = "CLASS_FINAL";
	public static final String FLAG_CLASS_TRAIT = "CLASS_TRAIT";
	public static final String FLAG_CLASS_INTERFACE = "CLASS_INTERFACE";
	public static final String FLAG_CLASS_ANONYMOUS = "CLASS_ANONYMOUS";
	
	// flags for TYPE_PARAM nodes (exclusive)
	public static final String FLAG_PARAM_REF = "PARAM_REF";
	public static final String FLAG_PARAM_VARIADIC = "PARAM_VARIADIC";

	// flags for TYPE_TYPE nodes (exclusive)
	public static final String FLAG_TYPE_ARRAY = "TYPE_ARRAY";
	public static final String FLAG_TYPE_CALLABLE = "TYPE_CALLABLE";

	// flags for TYPE_CAST nodes (exclusive)
	public static final String FLAG_TYPE_NULL = "TYPE_NULL";
	public static final String FLAG_TYPE_BOOL = "TYPE_BOOL";
	public static final String FLAG_TYPE_LONG = "TYPE_LONG";
	public static final String FLAG_TYPE_DOUBLE = "TYPE_DOUBLE";
	public static final String FLAG_TYPE_STRING = "TYPE_STRING";
	//public static final String FLAG_TYPE_ARRAY = "TYPE_ARRAY"; // already defined above
	public static final String FLAG_TYPE_OBJECT = "TYPE_OBJECT";
	
	// flags for TYPE_UNARY_OP nodes (exclusive)
	public static final String FLAG_UNARY_BOOL_NOT = "UNARY_BOOL_NOT";
	public static final String FLAG_UNARY_BITWISE_NOT = "UNARY_BITWISE_NOT";
	public static final String FLAG_UNARY_MINUS = "UNARY_MINUS"; // since version 20 of php-ast
	public static final String FLAG_UNARY_PLUS = "UNARY_PLUS"; // since version 20 of php-ast
	public static final String FLAG_UNARY_SILENCE = "UNARY_SILENCE"; // since version 20 of php-ast
	
	// flags for TYPE_BINARY_OP and TYPE_ASSIGN_OP nodes in version >= 20 of php-ast (exclusive)
	public static final String FLAG_BINARY_BITWISE_OR = "BINARY_BITWISE_OR";
	public static final String FLAG_BINARY_BITWISE_AND = "BINARY_BITWISE_AND";
	public static final String FLAG_BINARY_BITWISE_XOR = "BINARY_BITWISE_XOR";
	public static final String FLAG_BINARY_CONCAT = "BINARY_CONCAT";
	public static final String FLAG_BINARY_ADD = "BINARY_ADD";
	public static final String FLAG_BINARY_SUB = "BINARY_SUB";
	public static final String FLAG_BINARY_MUL = "BINARY_MUL";
	public static final String FLAG_BINARY_DIV = "BINARY_DIV";
	public static final String FLAG_BINARY_MOD = "BINARY_MOD";
	public static final String FLAG_BINARY_POW = "BINARY_POW";
	public static final String FLAG_BINARY_SHIFT_LEFT = "BINARY_SHIFT_LEFT";
	public static final String FLAG_BINARY_SHIFT_RIGHT = "BINARY_SHIFT_RIGHT";

	// flags for TYPE_BINARY_OP (exclusive)
	public static final String FLAG_BINARY_BOOL_AND = "BINARY_BOOL_AND"; // since version 20 of php-ast
	public static final String FLAG_BINARY_BOOL_OR = "BINARY_BOOL_OR"; // since version 20 of php-ast
	public static final String FLAG_BINARY_BOOL_XOR = "BINARY_BOOL_XOR";
	public static final String FLAG_BINARY_IS_IDENTICAL = "BINARY_IS_IDENTICAL";
	public static final String FLAG_BINARY_IS_NOT_IDENTICAL = "BINARY_IS_NOT_IDENTICAL";
	public static final String FLAG_BINARY_IS_EQUAL = "BINARY_IS_EQUAL";
	public static final String FLAG_BINARY_IS_NOT_EQUAL = "BINARY_IS_NOT_EQUAL";
	public static final String FLAG_BINARY_IS_SMALLER = "BINARY_IS_SMALLER";
	public static final String FLAG_BINARY_IS_SMALLER_OR_EQUAL = "BINARY_IS_SMALLER_OR_EQUAL";
	public static final String FLAG_BINARY_IS_GREATER = "BINARY_IS_GREATER"; // since version 20 of php-ast
	public static final String FLAG_BINARY_IS_GREATER_OR_EQUAL = "BINARY_IS_GREATER_OR_EQUAL"; // since version 20 of php-ast
	public static final String FLAG_BINARY_SPACESHIP = "BINARY_SPACESHIP";
	
	// flags for TYPE_MAGIC_CONST nodes (exclusive)
	public static final String FLAG_MAGIC_LINE = "MAGIC_LINE";
	public static final String FLAG_MAGIC_FILE = "MAGIC_FILE";
	public static final String FLAG_MAGIC_DIR = "MAGIC_DIR";
	public static final String FLAG_MAGIC_NAMESPACE = "MAGIC_NAMESPACE";
	public static final String FLAG_MAGIC_FUNCTION = "MAGIC_FUNCTION";
	public static final String FLAG_MAGIC_METHOD = "MAGIC_METHOD";
	public static final String FLAG_MAGIC_CLASS = "MAGIC_CLASS";
	public static final String FLAG_MAGIC_TRAIT = "MAGIC_TRAIT";

	// flags for TYPE_USE, TYPE_GROUP_USE and TYPE_USE_ELEM nodes (exclusive)
	public static final String FLAG_USE_NORMAL = "USE_NORMAL";
	public static final String FLAG_USE_FUNCTION = "USE_FUNCTION";
	public static final String FLAG_USE_CONST = "USE_CONST";

	// flags for TYPE_INCLUDE_OR_EVAL nodes (exclusive)
	public static final String FLAG_EXEC_EVAL = "EXEC_EVAL";
	public static final String FLAG_EXEC_INCLUDE = "EXEC_INCLUDE";
	public static final String FLAG_EXEC_INCLUDE_ONCE = "EXEC_INCLUDE_ONCE";
	public static final String FLAG_EXEC_REQUIRE = "EXEC_REQUIRE";
	public static final String FLAG_EXEC_REQUIRE_ONCE = "EXEC_REQUIRE_ONCE";
}
