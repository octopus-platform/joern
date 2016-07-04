package octopus.server.commands.executeplugin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

import com.orientechnologies.common.log.OLogManager;
import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.config.OServerEntryConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http
		.OHttpRequestException;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command
		.OServerCommandAbstract;

import octopus.server.components.pluginInterface.Plugin;
import octopus.server.components.pluginInterface.PluginLoader;

public class ExecutePluginCommand extends OServerCommandAbstract
{
	String pluginName;
	String pluginDir;
	String pluginClass;
	JSONObject settings;

	public ExecutePluginCommand(
			final OServerCommandConfiguration iConfiguration)
	{
		readConfiguration(iConfiguration);
	}

	private void readConfiguration(OServerCommandConfiguration iConfiguration)
	{
		for (OServerEntryConfiguration param : iConfiguration.parameters)
		{
			switch (param.name)
			{
				case "dir":
					pluginDir = System.getProperty("OCTOPUS_HOME") + "/" + param.value;
					break;
			}
		}
	}

	@Override
	public boolean execute(OHttpRequest iRequest,
						   OHttpResponse iResponse) throws Exception
	{
		OLogManager.instance().warn(this, "startplugin");

		parseContent(iRequest.content);

		Object result = executePlugin();
		if (result == null)
		{
			result = "";
		}
		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, result, null);
		return false;
	}

	private void parseContent(String content)
	{
		if (content == null)
			throw new RuntimeException("Error: no content");

		JSONObject data = new JSONObject(content);
		pluginName = data.getString("plugin");
		pluginClass = data.getString("class");
		settings = data.getJSONObject("settings");
	}

	private Object executePlugin()
	{
		Path path = Paths.get(pluginDir, pluginName);
		Plugin plugin = PluginLoader.load(path, pluginClass);

		if (plugin == null)
		{
			throw new OHttpRequestException(
					"Error while loading plugin " + pluginName);
		}
		try
		{
			plugin.configure(settings);
			plugin.beforeExecution();
			plugin.execute();
			plugin.afterExecution();
			return plugin.result();
		} catch (Exception e)
		{
			throw new OHttpRequestException(e.getMessage());
		}
	}

	@Override
	public String[] getNames()
	{
		return new String[]{"POST|executeplugin/"};
	}
}
