package tests.languages.php;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;

import inputModules.csv.PHPCSVEdgeTypes;
import inputModules.csv.PHPCSVNodeTypes;
import inputModules.csv.KeyedCSV.KeyedCSVReader;
import inputModules.csv.KeyedCSV.KeyedCSVRow;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csv2ast.ASTUnderConstruction;
import tools.php.ast2cpg.PHPCSVEdgeInterpreter;
import tools.php.ast2cpg.PHPCSVNodeInterpreter;

public class PHPCSVBasedTest {

	// directory where the samples are stored
	private static final String sampleRootDir = "src" + File.separator +
												"test" + File.separator +
												"java" + File.separator +
												"tests" + File.separator +
												"languages" + File.separator +
												"php" + File.separator +
												"samples";
	private String sampleDir = sampleRootDir;

	// standard names for nodes and edges files
	protected static final String nodesFile = "nodes.csv";
	protected static final String edgesFile = "edges.csv";

	private PHPCSVNodeInterpreter nodeInterpreter = new PHPCSVNodeInterpreter();
	private PHPCSVEdgeInterpreter edgeInterpreter = new PHPCSVEdgeInterpreter();

	protected ASTUnderConstruction ast;
	private KeyedCSVReader nodeReader;
	private KeyedCSVReader edgeReader;

	@Before
	public void init() {
		this.ast = new ASTUnderConstruction();
		this.nodeReader = new KeyedCSVReader();
		this.edgeReader = new KeyedCSVReader();
	}

	protected void setSampleDir( String sampleDir) {
		this.sampleDir = sampleRootDir + File.separator + sampleDir;
	}

	protected String getSampleDir() {
		return this.sampleDir;
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

	/**
	 * Takes two CSV strings, hands them directly to the node and edge interpreters and builds an AST.
	 * We now prefer to read CSV strings directly from files.
	 *
	 * @see handleCSVFiles(String)
	 */
	@Deprecated
	protected void handleCSVLines(String nodeStr, String edgeStr)
			throws IOException, InvalidCSVFile {

		this.nodeReader.init(new StringReader(nodeStr));
		this.edgeReader.init(new StringReader(edgeStr));

		KeyedCSVRow keyedRow;
		while ((keyedRow = nodeReader.getNextRow()) != null)
			nodeInterpreter.handle(keyedRow, ast);
		while ((keyedRow = edgeReader.getNextRow()) != null)
			edgeInterpreter.handle(keyedRow, ast);
	}
}
