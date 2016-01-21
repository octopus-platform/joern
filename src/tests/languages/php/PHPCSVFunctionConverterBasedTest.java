package tests.languages.php;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;

import ast.ASTNode;
import ast.functionDef.FunctionDef;
import cfg.CFG;
import ddg.CFGAndUDGToDefUseCFG;
import ddg.DDGCreator;
import ddg.DataDependenceGraph.DDG;
import ddg.DefUseCFG.DefUseCFG;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import inputModules.csv.csvFuncExtractor.CSVFunctionExtractor;
import languages.php.cfg.PHPCFGFactory;
import tests.languages.php.PHPCSVBasedTest;
import udg.CFGToUDGConverter;
import udg.useDefGraph.UseDefGraph;

public class PHPCSVFunctionConverterBasedTest extends PHPCSVBasedTest {

	CSVFunctionExtractor extractor;

	@Before
	public void init()
	{
		super.init();
		
		// Additionally, initialize a function extractor
		this.extractor = new CSVFunctionExtractor();
		this.extractor.setLanguage("PHP");		
	}

	/* Note: for testing, use either:
	 * - getASTForCSVLines(String,String) which generates an AST for custom CSV strings
	 *   and defines the global ASTUnderConstruction ast; or
	 * - getASTOfNextFunction() which returns an AST for the next function
	 *   yielded by the function extractor; the function initFunctionExtractor(String,String)
	 *   must be called *once* prior to using this function, causing the function extractor
	 *   to read the CSV files and generate ASTs for each function separately.
	 */
	
	/**
	 * Creates and returns an AST for two given CSV strings (nodes and edges),
	 * and returns the AST node with the lowest id.
	 */
	protected ASTNode getASTForCSVLines(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		handle(nodeLines, edgeLines);

		return ast.getNodeWithLowestId();
	}
	
	/**
	 * Initializes the function extractor for two given CSV strings (nodes and edges).
	 */
	protected void initFunctionExtractor(String nodeLines, String edgeLines)
			throws IOException, InvalidCSVFile
	{
		StringReader nodeReader = new StringReader(nodeLines);
		StringReader edgeReader = new StringReader(edgeLines);
		
		this.extractor.initialize(nodeReader, edgeReader);
	}
	
	/**
	 * Obtains and returns a function AST from the function extractor.
	 * 
	 * Note: initFunctionExtractor(String,String) must be called
	 * prior to calling this function!
	 */
	protected FunctionDef getASTOfNextFunction()
			throws IOException, InvalidCSVFile
	{
		FunctionDef rootnode = extractor.getNextFunction();
		return rootnode;
	}
	
	
	/* ******************** */
	/* Conversion functions */
	/* ******************** */
	
	/**
	 * Creates and returns a CFG for a given AST.
	 */
	protected CFG getCFGForAST(ASTNode rootnode)
			throws IOException, InvalidCSVFile
	{
		// This is a bit clumsy: to ensure that the structured flow visitor
		// is initialized correctly, we need to create a PHPCFGFactory
		// object despite the fact that we're only using the factory's static
		// methods.

		PHPCFGFactory phpcfgFactory = new PHPCFGFactory();
		return PHPCFGFactory.convert(rootnode);
	}
	
	/**
	 * Creates and returns a UDG for a given CFG.
	 */
	protected UseDefGraph getUDGForCFG(CFG cfg)
			throws IOException, InvalidCSVFile
	{
		CFGToUDGConverter cfgToUDG = new CFGToUDGConverter();
		cfgToUDG.setLanguage("PHP");
		
		return cfgToUDG.convert(cfg);
	}
	
	/**
	 * Creates and returns a DDG for a given CFG and UDG.
	 */
	protected DDG getDDGForCFGAndUDG(CFG cfg, UseDefGraph udg) {
		
		CFGAndUDGToDefUseCFG udgAndCfgToDefUseCFG = new CFGAndUDGToDefUseCFG();
		DefUseCFG defUseCFG = udgAndCfgToDefUseCFG.convert(cfg, udg);

		DDGCreator ddgCreator = new DDGCreator();
		
		return ddgCreator.createForDefUseCFG(defUseCFG);
	}
}
