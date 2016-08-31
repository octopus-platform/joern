package octopus.server.gremlinShell.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.IteratorUtils;
import org.apache.tinkerpop.gremlin.driver.MessageSerializer;
import org.apache.tinkerpop.gremlin.driver.message.ResponseMessage;
import org.apache.tinkerpop.gremlin.driver.ser.GraphSONMessageSerializerV1d0;
import org.apache.tinkerpop.gremlin.driver.ser.SerializationException;
import org.apache.tinkerpop.gremlin.structure.Graph;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;

public class OctopusClientWriter extends BufferedWriter
{

	private boolean outputJSON = false;

	private MessageSerializer serializer = new GraphSONMessageSerializerV1d0();

	private Graph graph;

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
		if(outputJSON){
			writeMessage(convertToJSON(result));
			return;
		}

		String responseStr;

		if (result == null)
			responseStr = "";
		else if (result instanceof Iterable)
			responseStr = buildResponseForIterable(result);
		else if(result instanceof Iterator)
			responseStr = buildResponseForIterator(result);
		else{
			responseStr = result.toString();
		}

		writeMessage(responseStr);
	}

	private String buildResponseForIterator(Object o) throws IOException
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
		return sBuilder.toString();
	}

	private String buildResponseForIterable(Object o) throws IOException
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
		return sBuilder.toString();
	}

	private void writeMessage(String message) throws IOException
	{
		write(message);
		writeEndOfMessage();
		flush();
	}

	private String convertToJSON(Object result)
	{
		configureSerializer();

		if(result instanceof Iterator)
			result = IteratorUtils.toList((Iterator) result);

		UUID requestId = UUID.fromString("6457272A-4018-4538-B9AE-08DD5DDC0AA1");
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.build(requestId);
		ByteBufAllocator allocator = UnpooledByteBufAllocator.DEFAULT;
		try {
			final ByteBuf bb = serializer.serializeResponseAsBinary(responseMessageBuilder.result(result).create(), allocator);
			return bb.toString(StandardCharsets.UTF_8);
		} catch (SerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void configureSerializer()
	{
		Map<String, Object> config = new HashMap<String, Object>();
		config.put("useMapperFromGraph", "graph");
		Map<String, Graph> graphs = new HashMap<String, Graph>();
		graphs.put("graph", getGraph());
		serializer.configure(config, graphs);
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
