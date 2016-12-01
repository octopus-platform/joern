package octopus.server.restServer.handlers;

import org.json.JSONObject;

import octopus.api.plugin.PluginExecutor;
import octopus.server.restServer.OctopusRestHandler;
import spark.Request;
import spark.Response;

public class ExecutePluginHandler implements OctopusRestHandler {

	private String pluginName;
	private String pluginClass;
	private JSONObject settings;

	@Override
	public Object handle(Request req, Response resp)
	{
		parseBody(req.body());
		return executePluginAndRespond();
	}

	private void parseBody(String content)
	{
		JSONObject data = new JSONObject(content);

		pluginName = data.getString("plugin");
		pluginClass = data.getString("class");
		settings = data.getJSONObject("settings");

		if(pluginName == null || pluginClass == null)
			throw new RuntimeException("Invalid request: pluginName or pluginClass not given");
	}

	private Object executePluginAndRespond() {
		Object result = new PluginExecutor().executePlugin(pluginName, pluginClass, settings);
		if (result == null) result = "";
		return result.toString();
	}

}
