package tests.languages.php.cfgCreation;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import ast.ASTNode;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.samples.CSVASTSamples;

public class IfBlockTests extends PHPCFGCreatorTest {

	@Test
	public void testIfAndElseIf() throws IOException, InvalidCSVFile
	{
		ASTNode ast = getASTForCSVLines(CSVASTSamples.ifStatementNodeStr, CSVASTSamples.ifStatementEdgeStr);
		assertNotNull(ast);

		System.out.println(ast.getChildCount());
	}

}
