package tools.phpast2cfg;

import java.util.Arrays;
import java.util.List;

public class PHPCSVNodeTypes
{

	public static final String NODE_ID = "id";
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String FUNCID = "funcid";

	public static final List<String> funcTypes =
			Arrays.asList("AST_TOPLEVEL", "AST_FUNC_DECL", "AST_METHOD", "AST_CLOSURE");
}
