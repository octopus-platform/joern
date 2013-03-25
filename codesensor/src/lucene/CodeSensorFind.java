package lucene;

public class CodeSensorFind
{

	public static void main(String[] args)
	{
		String queryString = "localType:int";
		String directoryName = "/home/fabs/tmp/lucene/";		
		Finder finder = new Finder(directoryName);
		finder.find(queryString);
	}
	
}
