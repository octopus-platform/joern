package octopus.server.gremlinShell.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.apache.tinkerpop.gremlin.structure.io.graphson.GraphSONMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OctopusClientWriter extends BufferedWriter
{

	private boolean outputJSON = false;
	private ObjectMapper graphsonMapper = GraphSONMapper.build().embedTypes(false).create().createMapper();


	public OctopusClientWriter(Writer out)
	{
		super(out);
	}

	private void writeEndOfMessage() throws IOException
	{
		write("\0");
	}

	public void toggleJSONOutput()
	{
		outputJSON = !outputJSON;
	}

	public void writeResult(Object result) throws IOException
	{
		if (result == null)
			writeMessage("");
		else if (result instanceof Iterable)
			writeIterable(result);
		else if(result instanceof Iterator)
			writeIterator(result);
		else
			writeMessage(result.toString());
	}

	public void writeMessage(String message) throws IOException
	{
		if(outputJSON)
			message = graphsonMapper.writeValueAsString(message);

		write(message);
		writeEndOfMessage();
		flush();
	}

	private void writeIterator(Object o) throws IOException
	{
		Iterator<?> it = (Iterator<?>) o;
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
	}

	private void writeIterable(Object o) throws IOException
	{
		StringBuilder sBuilder = new StringBuilder();
		Iterable<?> iterable = (Iterable<?>) o;
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
	}

}
