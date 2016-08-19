package octopus.server.gremlinShell.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public class BjoernClientWriter extends BufferedWriter
{

	public BjoernClientWriter(Writer out)
	{
		super(out);
	}

	private void writeEndOfMessage() throws IOException
	{
		write("\0");
	}

	public void writeMessage(String message) throws IOException
	{
		write(message);
		writeEndOfMessage();
		flush();
	}

	public void writeResult(Object result) throws IOException
	{
		if (result == null)
		{
			writeMessage("");
		} else if (result instanceof Iterable)
		{
			StringBuilder sBuilder = new StringBuilder();
			Iterable<?> iterable = (Iterable<?>) result;
			for (Object obj : iterable)
			{
				if (obj != null)
				{
					sBuilder.append(obj.toString());
					sBuilder.append("\n");
				}
			}
			if (sBuilder.length() > 0)
			{
				sBuilder.deleteCharAt(sBuilder.length() - 1);
			}
			writeMessage(sBuilder.toString());
		} else if(result instanceof Iterator)
		{
			Iterator<?> it = (Iterator<?>) result;
			StringBuilder sBuilder = new StringBuilder();

			while(it.hasNext()){
				Object obj = it.next();
				if (obj != null)
				{
					sBuilder.append(obj.toString());
					sBuilder.append("\n");
				}
			}
			if (sBuilder.length() > 0)
			{
				sBuilder.deleteCharAt(sBuilder.length() - 1);
			}
			writeMessage(sBuilder.toString());
		} else
		{
			writeMessage(result.toString());
		}
	}

}
