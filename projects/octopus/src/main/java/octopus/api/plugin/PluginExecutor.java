package octopus.api.plugin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

import octopus.OctopusEnvironment;
import octopus.server.pluginInterface.PluginLoader;

public class PluginExecutor {

	public Object executePlugin(String pluginName, String pluginClass)
	{
		return executePlugin(pluginName, pluginClass, null);
	}

	public Object executePlugin(String pluginName, String pluginClass, JSONObject settings)
	{
		String pluginDir = OctopusEnvironment.PLUGINS_DIR.toString();
		Path path = Paths.get(pluginDir, pluginName).toAbsolutePath();
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
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

}
