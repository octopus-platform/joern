package tests.languages.php;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.junit.Before;

import ast.php.functionDef.FunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import tools.php.ast2cpg.PHPCSVEdgeInterpreter;
import tools.php.ast2cpg.PHPCSVNodeInterpreter;

public class PHPCSVFunctionExtractorBasedTest extends PHPCSVBasedTest
{
	protected CSVFunctionExtractor extractor;

	@Override
	@Before
	public void init()
	{
		super.init();

		this.extractor = new CSVFunctionExtractor();
		this.extractor.setInterpreters(new PHPCSVNodeInterpreter(), new PHPCSVEdgeInterpreter());
	}

	protected HashMap<String,FunctionDef> getAllFuncASTs( String testDir)
			throws IOException, InvalidCSVFile {

		HashMap<String,FunctionDef> functions = new LinkedHashMap<String,FunctionDef>();

	    BufferedReader nodeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + nodesFile));
	    BufferedReader edgeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + edgesFile));

		this.extractor.initialize(nodeFileReader, edgeFileReader);
		FunctionDef function;
		while( (function = (FunctionDef)extractor.getNextFunction()) != null) {

			functions.put( function.getName(), function);
		}

		return functions;
	}

	protected HashSet<FunctionDef> getAllFuncASTsUnkeyed( String testDir)
			throws IOException, InvalidCSVFile {

		HashSet<FunctionDef> functions = new LinkedHashSet<FunctionDef>();

	    BufferedReader nodeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + nodesFile));
	    BufferedReader edgeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + edgesFile));

		this.extractor.initialize(nodeFileReader, edgeFileReader);
		FunctionDef function;
		while( (function = (FunctionDef)extractor.getNextFunction()) != null) {

			functions.add( function);
		}

		return functions;
	}
}
