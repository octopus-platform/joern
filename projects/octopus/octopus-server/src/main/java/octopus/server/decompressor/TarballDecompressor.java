package octopus.server.decompressor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class TarballDecompressor {

	public void decompress(String tarballFilename, String outputDirectory) throws FileNotFoundException, IOException
	{
		if(!outputDirectory.endsWith(File.separator))
			outputDirectory = outputDirectory + File.separator;

		TarArchiveInputStream tarIn = createTarInputStreamForFile(tarballFilename);

		TarArchiveEntry entry;
		while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null)
		{
			String outputFilename = outputDirectory + entry.getName();

			if(outputFilename.contains("pax_global_header"))
				continue;

			if (entry.isDirectory()) {
				createOutputSubDirectory(outputFilename);
				continue;
			}
			decompressFileToOutputDirectory(tarIn, outputFilename);
		}
		tarIn.close();
	}

	private TarArchiveInputStream createTarInputStreamForFile(String tarballFilename)
			throws FileNotFoundException, IOException
	{
		FileInputStream fin = new FileInputStream(tarballFilename);
		BufferedInputStream in = new BufferedInputStream(fin);
		GzipCompressorInputStream gzIn = new GzipCompressorInputStream(in);
		TarArchiveInputStream tarIn = new TarArchiveInputStream(gzIn);
		return tarIn;
	}

	private void createOutputSubDirectory(String outputFilename)
	{
		File f = new File(outputFilename);
	    f.mkdirs();
	}

	private void decompressFileToOutputDirectory(TarArchiveInputStream tarIn, String outputFilename) throws IOException
	{
		final int BUFFER_SIZE = 2048;
		byte data[] = new byte[BUFFER_SIZE];
		int bytesRead;

		FileOutputStream fos = new FileOutputStream(outputFilename);
		BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER_SIZE);
		while ((bytesRead = tarIn.read(data, 0, BUFFER_SIZE)) != -1)
		{
			dest.write(data, 0, bytesRead);
		}
		dest.close();

	}

}
