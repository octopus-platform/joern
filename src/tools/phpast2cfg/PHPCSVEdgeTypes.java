package tools.phpast2cfg;

import inputModules.csv.KeyedCSV.CSVKey;

public class PHPCSVEdgeTypes
{
	/* edge row keys */
	public static final CSVKey START_ID = new CSVKey("", "START_ID");
	public static final CSVKey END_ID = new CSVKey("", "END_ID");
	public static final CSVKey TYPE = new CSVKey("", "TYPE");

	/* edge types */
	public static final String TYPE_FILE_OF = "FILE_OF";
	public static final String TYPE_DIRECTORY_OF = "DIRECTORY_OF";
	public static final String TYPE_AST_PARENT_OF = "PARENT_OF";

}
