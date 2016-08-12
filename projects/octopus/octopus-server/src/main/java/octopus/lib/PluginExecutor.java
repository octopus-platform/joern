package octopus.lib;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

import octopus.server.components.pluginInterface.Plugin;
import octopus.server.components.pluginInterface.PluginLoader;

public class PluginExecutor {

	String pluginDir;

	public PluginExecutor()
	{
		pluginDir = System.getProperty("octopus.plugindir");
	}

	public Object executePlugin(String pluginName, String pluginClass)
	{
		return executePlugin(pluginName, pluginClass, null);
	}

	public Object executePlugin(String pluginName, String pluginClass, JSONObject settings)
	{
		Path path = Paths.get(pluginDir, pluginName);
		Plugin plugin = PluginLoader.load(path, pluginClass);

		if (plugin == null)
			throw new RuntimeException(
					"Error while loading plugin " + pluginName);

		try
		{
			if(settings != null)
				plugin.configure(settings);
			plugin.beforeExecution();
			plugin.execute();
			plugin.afterExecution();
			return plugin.result();
		} catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

}
