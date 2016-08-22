package octopus.server.gremlinShell.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.UUID;

import org.apache.tinkerpop.gremlin.driver.MessageSerializer;
import org.apache.tinkerpop.gremlin.driver.message.ResponseMessage;
import org.apache.tinkerpop.gremlin.driver.ser.GraphSONMessageSerializerGremlinV1d0;
import org.apache.tinkerpop.gremlin.driver.ser.SerializationException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;

public class OctopusClientWriter extends BufferedWriter
{

	private boolean outputJSON = false;

	private MessageSerializer serializer = new GraphSONMessageSerializerGremlinV1d0();

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

		if(outputJSON){
		    message = convertToJSON(message);
		}

		write(message);
		writeEndOfMessage();
		flush();
	}

	private String convertToJSON(String message)
	{
		UUID requestId = UUID.fromString("6457272A-4018-4538-B9AE-08DD5DDC0AA1");
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.build(requestId);
		ByteBufAllocator allocator = UnpooledByteBufAllocator.DEFAULT;
		try {
			final ByteBuf bb = serializer.serializeResponseAsBinary(responseMessageBuilder.result(message).create(), allocator);
			message =  bb.toString(StandardCharsets.UTF_8);
		} catch (SerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
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
