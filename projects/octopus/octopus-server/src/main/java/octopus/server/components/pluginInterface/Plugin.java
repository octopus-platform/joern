package octopus.server.components.pluginInterface;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plugin
{
	private final Logger logger = LoggerFactory
			.getLogger(getClass());

	public Logger getLogger()
	{
		return this.logger;
	}

    public void configure(JSONObject settings) { }

    public void execute() throws Exception { }

    public void beforeExecution() throws Exception { }

    public void afterExecution() throws Exception { }
}