package tests.languages.php.udgCreation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import ast.ASTNode;
import ast.expressions.AssignmentExpression;
import ast.expressions.BinaryOperationExpression;
import ast.expressions.Variable;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVBasedTest;
import tests.languages.php.samples.CSVASTDefUseSamples;

public class PHPASTDefUseAnalyzerTest extends PHPCSVBasedTest {


	/**
	 * $foo = $bar + $buz;
	 */
	@Test
	public void testAssign() throws IOException, InvalidCSVFile
	{
		String nodeStr = CSVASTDefUseSamples.defUseAssignNodeStr;
		String edgeStr = CSVASTDefUseSamples.defUseAssignEdgeStr;

		handle(nodeStr, edgeStr);
		
		ASTNode node = ast.getNodeById((long)3);

		// TODO at this point, compute UDG for the given node, then check
		// names of defined and used variables similarly as below.

		assertThat( node, instanceOf(AssignmentExpression.class));
		
		Variable def = ((Variable)((AssignmentExpression)node).getLeft());
		assertEquals( "foo", def.getNameExpression().getEscapedCodeStr());
		
		BinaryOperationExpression opExpr = (BinaryOperationExpression)((AssignmentExpression)node).getRight();
		Variable use1 = (Variable)opExpr.getLeft();
		Variable use2 = (Variable)opExpr.getRight();
		assertEquals( "bar", use1.getNameExpression().getEscapedCodeStr());
		assertEquals( "buz", use2.getNameExpression().getEscapedCodeStr());
	}

}
