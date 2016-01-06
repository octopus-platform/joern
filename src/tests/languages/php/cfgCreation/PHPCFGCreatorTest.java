package tests.languages.php.cfgCreation;

import java.io.IOException;

import ast.ASTNode;
import cfg.CFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.cfg.PHPCFGFactory;
import tests.CFGCreatorTest;
import tests.inputModules.TestCSV2AST;

public class PHPCFGCreatorTest extends CFGCreatorTest {


	protected ASTNode getASTForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		return TestCSV2AST.createASTFromStrings(nodeLines, edgeLines);
	}

	protected CFG getCFGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		return PHPCFGFactory.convert(getASTForCSVLines(nodeLines, edgeLines));
	}

}
