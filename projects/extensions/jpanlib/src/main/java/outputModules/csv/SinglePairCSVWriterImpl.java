package outputModules.csv;

public class SinglePairCSVWriterImpl extends CSVWriterImpl {

	boolean outputFilesOpened = false;

	@Override
	public void changeOutputDir(String dirNameForFileNode)
	{
		if(outputFilesOpened)
			return;

		outputFilesOpened = true;

		openNodeFile(dirNameForFileNode);
		openEdgeFile(dirNameForFileNode);
	}

	@Override
	public void shutdown()
	{
		if(!outputFilesOpened)
			return;

		closeNodeFile();
		closeEdgeFile();
	}

}
