package outputModules.csv;

public class MultiPairCSVWriterImpl extends CSVWriterImpl
{

	@Override
	public void changeOutputDir(String dirNameForFileNode)
	{
		closeEdgeFile();
		closeNodeFile();
		openNodeFile(dirNameForFileNode);
		openEdgeFile(dirNameForFileNode);
	}

	@Override
	public void shutdown()
	{
		closeEdgeFile();
		closeNodeFile();
	}
}
