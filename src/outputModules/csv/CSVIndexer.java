package outputModules.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import tools.index.Indexer;

public class CSVIndexer extends Indexer
{
	PrintWriter nodeWriter;
	PrintWriter edgeWriter;

	@Override
	protected void initializeDatabase()
	{
		createOutputDirectory();
		openNodeFile();
		openEdgeFile();
	}

	private void openNodeFile()
	{
		String path = outputDir + File.separator + "nodes.csv";
		edgeWriter = createWriter(path);
	}

	private void openEdgeFile()
	{
		String path = outputDir + File.separator + "edges.csv";
		nodeWriter = createWriter(path);
	}

	private PrintWriter createWriter(String path)
	{
		try
		{
			return new PrintWriter(path);
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException("Cannot create file: " + path);
		}
	}

	private void createOutputDirectory()
	{
		File outputDirectory = new File(outputDir);
		if (outputDirectory.exists())
			throw new RuntimeException("Output directory already exists");

		try
		{
			outputDirectory.mkdirs();
		}
		catch (SecurityException ex)
		{
			throw new RuntimeException(
					"Cannot create output directory, permission denied.");
		}
	}

	@Override
	protected void shutdownDatabase()
	{
		closeEdgeFile();
		closeNodeFile();
	}

	private void closeNodeFile()
	{
		nodeWriter.close();
	}

	private void closeEdgeFile()
	{
		edgeWriter.close();
	}

	@Override
	protected void initializeDirectoryImporter()
	{
		dirTreeImporter = new CSVDirectoryTreeImporter();
	}

	@Override
	protected void initializeWalker()
	{
		astWalker = new CSVASTWalker();
	}

}
