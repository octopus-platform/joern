package outputModules.csv;

public class SinglePairCSVWriterImpl extends CSVWriterImpl {

	boolean outputFilesOpened = false;

	@Override
	public void changeOutputDir(String dirNameForFileNode)
	{
		if(outputFilesOpened)
			return;

		outputFilesOpened = true;
		System.out.println("reached");

		openNodeFile(dirNameForFileNode);
		openEdgeFile(dirNameForFileNode);
	}

}
