package octopus.api.decompressor;

import java.io.FileNotFoundException;
import java.io.IOException;

import octopus.server.decompressor.TarballDecompressor;

public class Decompressor
{

	public void decompressTarball(String tarballFilename,
			String outputDirectory)
					throws FileNotFoundException, IOException
	{
		(new TarballDecompressor()).decompress(tarballFilename, outputDirectory);;
	}

}
