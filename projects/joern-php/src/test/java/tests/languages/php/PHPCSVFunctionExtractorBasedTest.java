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

import ast.php.functionDef.PHPFunctionDef;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import tools.php.ast2cfgddg.PHPCSVEdgeInterpreter;
import tools.php.ast2cfgddg.PHPCSVNodeInterpreter;

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

	protected HashMap<String,PHPFunctionDef> getAllFuncASTs( String testDir)
			throws IOException, InvalidCSVFile {

		HashMap<String,PHPFunctionDef> functions = new LinkedHashMap<String,PHPFunctionDef>();

	    BufferedReader nodeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + nodesFile));
	    BufferedReader edgeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + edgesFile));

		this.extractor.initialize(nodeFileReader, edgeFileReader);
		PHPFunctionDef function;
		while( (function = (PHPFunctionDef)extractor.getNextFunction()) != null) {

			functions.put( function.getName(), function);
		}

		return functions;
	}

	protected HashSet<PHPFunctionDef> getAllFuncASTsUnkeyed( String testDir)
			throws IOException, InvalidCSVFile {

		HashSet<PHPFunctionDef> functions = new LinkedHashSet<PHPFunctionDef>();

	    BufferedReader nodeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + nodesFile));
	    BufferedReader edgeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + edgesFile));

		this.extractor.initialize(nodeFileReader, edgeFileReader);
		PHPFunctionDef function;
		while( (function = (PHPFunctionDef)extractor.getNextFunction()) != null) {

			functions.add( function);
		}

		return functions;
	}
}
