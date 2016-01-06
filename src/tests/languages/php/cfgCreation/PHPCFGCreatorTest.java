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
		ASTNode anAST = getASTForCSVLines(nodeLines, edgeLines);

		// This is a bit clumsy: to ensure that the structured flow visitor
		// is initialized correctly, we need to create a PHPCFGFactory
		// object despite the fact that we're only using the factory's static
		// methods.

		PHPCFGFactory phpcfgFactory = new PHPCFGFactory();
		return PHPCFGFactory.convert(anAST);
	}

}
