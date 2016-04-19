package tests.languages.php;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;

import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import tools.php.ast2cfgddg.PHPCSVEdgeInterpreter;
import tools.php.ast2cfgddg.PHPCSVEdgeTypes;
import tools.php.ast2cfgddg.PHPCSVNodeInterpreter;
import tools.php.ast2cfgddg.PHPCSVNodeTypes;

public class PHPCSVBasedTest {

	// directory where the samples are stored
	private static final String sampleRootDir = "src" + File.separator +
												"tests" + File.separator +
												"languages" + File.separator +
												"php" + File.separator +
												"samples";
	private String sampleDir = sampleRootDir;
	
	// standard names for nodes and edges files
	private static final String nodesFile = "nodes.csv";
	private static final String edgesFile = "edges.csv";
	
	PHPCSVNodeInterpreter nodeInterpreter = new PHPCSVNodeInterpreter();
	PHPCSVEdgeInterpreter edgeInterpreter = new PHPCSVEdgeInterpreter();

	protected ASTUnderConstruction ast;
	KeyedCSVReader nodeReader;
	KeyedCSVReader edgeReader;

	@Before
	public void init() {
		ast = new ASTUnderConstruction();
		nodeReader = new KeyedCSVReader();
		edgeReader = new KeyedCSVReader();
	}

	protected void setSampleDir( String sampleDir) {
		this.sampleDir = sampleRootDir + File.separator + sampleDir;
	}
	
	protected String getSampleDir() {
		return this.sampleDir;
	}
	
	protected void handle(String nodeStr, String edgeStr)
			throws IOException, InvalidCSVFile {
		
		nodeReader.init(new StringReader(nodeStr));
		edgeReader.init(new StringReader(edgeStr));

		KeyedCSVRow keyedRow;
		while ((keyedRow = nodeReader.getNextRow()) != null)
			nodeInterpreter.handle(keyedRow, ast);
		while ((keyedRow = edgeReader.getNextRow()) != null)
			edgeInterpreter.handle(keyedRow, ast);
	}
	
	protected void handleCSVFiles(String testDir)
			throws IOException, InvalidCSVFile {
		
	    BufferedReader nodeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + nodesFile));
	    BufferedReader edgeFileReader = new BufferedReader(new FileReader(getSampleDir() + File.separator + testDir + File.separator + edgesFile));

		nodeReader.init(nodeFileReader);
		edgeReader.init(edgeFileReader);

		KeyedCSVRow keyedRow;
		while ((keyedRow = nodeReader.getNextRow()) != null) {
			// we are only interested in AST nodes here
			String type = keyedRow.getFieldForKey(PHPCSVNodeTypes.TYPE);
			if( !type.equals(PHPCSVNodeTypes.TYPE_DIRECTORY) && !type.equals(PHPCSVNodeTypes.TYPE_FILE)
					&& !type.equals(PHPCSVNodeTypes.TYPE_CFG_ENTRY) && !type.equals(PHPCSVNodeTypes.TYPE_CFG_EXIT))
				nodeInterpreter.handle(keyedRow, ast);
		}
		while ((keyedRow = edgeReader.getNextRow()) != null) {
			// we are only interested in AST edges here
			String type = keyedRow.getFieldForKey(PHPCSVEdgeTypes.TYPE);
			if( type.equals(PHPCSVEdgeTypes.TYPE_AST_PARENT_OF))
				edgeInterpreter.handle(keyedRow, ast);
		}
	}

}
