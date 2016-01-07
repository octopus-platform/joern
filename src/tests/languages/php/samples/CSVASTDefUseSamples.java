package tests.languages.php.samples;

/**
 * Simlarly as CSVASTSamples, this class contains some PHP AST samples in CSV format,
 * optimized for testing def/use analysis.
 */
public class CSVASTDefUseSamples extends CSVASTSamples {

	/* 
	 * $foo = $bar + $buz;
	 */
	
	public static final String defUseAssignNodeStr = nodeHeader
			+ "3,AST_ASSIGN,,3,,0,1,,,\n"
			+ "4,AST_VAR,,3,,0,1,,,\n"
			+ "5,string,,3,\"foo\",0,1,,,\n"
			+ "6,AST_BINARY_OP,BINARY_ADD,3,,1,1,,,\n"
			+ "7,AST_VAR,,3,,0,1,,,\n"
			+ "8,string,,3,\"bar\",0,1,,,\n"
			+ "9,AST_VAR,,3,,1,1,,,\n"
			+ "10,string,,3,\"buz\",0,1,,,\n";
	
	public static final String defUseAssignEdgeStr = edgeHeader
			+ "4,5,PARENT_OF\n"
			+ "3,4,PARENT_OF\n"
			+ "7,8,PARENT_OF\n"
			+ "6,7,PARENT_OF\n"
			+ "9,10,PARENT_OF\n"
			+ "6,9,PARENT_OF\n"
			+ "3,6,PARENT_OF\n";


}
