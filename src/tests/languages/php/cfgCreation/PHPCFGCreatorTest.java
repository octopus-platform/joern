package tests.languages.php.cfgCreation;

import java.io.IOException;

import ast.ASTNode;
import cfg.CFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import languages.php.cfg.PHPCFGFactory;
import tests.languages.php.PHPCSVBasedTest;

public class PHPCFGCreatorTest extends PHPCSVBasedTest {


	protected ASTNode getASTForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		handle(nodeLines, edgeLines);
		return ast.getNodeById((long) 3);
	}

	protected CFG getCFGForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		return PHPCFGFactory.convert(getASTForCSVLines(nodeLines, edgeLines));
	}

}
