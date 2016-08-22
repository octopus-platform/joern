package octopus.server.gremlinShell.io;

import java.io.IOException;
import java.io.Reader;

public class OctopusClientReader extends Reader
{
	private Reader in;

	public OctopusClientReader(Reader in)
	{
		this.in = in;
	}

	@Override
	public void close() throws IOException
	{
		in.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		return in.read(cbuf, off, len);
	}

	public String readMessage() throws IOException
	{
		StringBuilder builder = new StringBuilder();
		int c;
		while ((c = in.read()) != -1)
		{
			// Messages end with "...\0" (NUL byte)
			if (c == '\0')
			{
				String message = builder.toString();
				return message;
			} else
			{
				builder.append((char) c);
			}
		}
		return null;
	}

}
