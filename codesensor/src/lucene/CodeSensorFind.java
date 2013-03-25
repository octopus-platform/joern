package lucene;

public class CodeSensorFind
{

	public static void main(String[] args)
	{
		String queryString = args[1];
		String directoryName = args[2];		
		Finder finder = new Finder(directoryName);
		finder.find(queryString);
	}
	
}
