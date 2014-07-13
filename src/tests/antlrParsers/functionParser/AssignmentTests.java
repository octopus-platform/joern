package tests.antlrParsers.functionParser;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import parsing.ANTLRFunctionParserDriver;

public class AssignmentTests
{

	@Test
	public void testAssignmentExpr()
	{
		String input = "x = y + 1;";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("assign_expr"));
	}

	@Test
	public void testComplexAssignment()
	{
		String input = "k += ((c = text[k]) >= sBMHCharSetSize) ? patlen : skip[c];";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("assign_expr"));
	}

	@Test
	public void testPrivateInName()
	{
		String input = "struct acpi_battery *battery = m->private;";
		ANTLRFunctionParserDriver functionParser = new ANTLRFunctionParserDriver();
		ParseTree tree = functionParser.parseString(input);
		String output = tree.toStringTree(functionParser.getAntlrParser());
		System.out.println(output);
		assertTrue(output.contains("simple_decl"));
	}

}
