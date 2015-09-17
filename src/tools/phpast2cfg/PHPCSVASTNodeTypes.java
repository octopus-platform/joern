package tools.phpast2cfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import tools.phpast2cfg.csv2ast.CSVASTNodeTypes;

public class PHPCSVASTNodeTypes implements CSVASTNodeTypes
{

	@Override
	public Set<String> functionDef()
	{
		return new HashSet<String>(
				Arrays.asList("AST_FUNC_DECL", "AST_METHOD"));
	}

}
