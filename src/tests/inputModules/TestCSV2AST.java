package tests.inputModules;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.CSV2AST;

public class TestCSV2AST
{

	@Test
	public void testMethodCreation() throws InvalidCSVFile, IOException
	{
		CSV2AST csv2AST = new CSV2AST();
		StringReader nodeReader = new StringReader(
				"nodeId:ID,type,name\n1,AST_METHOD,foo");
		csv2AST.convert(nodeReader, null);
	}

}
