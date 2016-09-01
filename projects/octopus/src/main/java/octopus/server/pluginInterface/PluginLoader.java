package octopus.server.pluginInterface;

import java.nio.file.Path;

import octopus.api.plugin.Plugin;

public class PluginLoader
{
	public static Plugin load(Path pathToJar, String pluginClass)
	{
		ClassLoader parentClassLoader = PluginClassLoader.class
				.getClassLoader();
		PluginClassLoader classLoader = new PluginClassLoader(
				parentClassLoader);
		classLoader.setJarFilename(pathToJar.toString());

		return createPluginInstance(classLoader, pluginClass);
	}

	public static Plugin load(String pluginClass)
	{
		ClassLoader parentClassLoader = PluginClassLoader.class
				.getClassLoader();
		return createPluginInstance(parentClassLoader, pluginClass);
	}

	private static Plugin createPluginInstance(ClassLoader classLoader, String pluginClass)
	{
		try
		{
			Class<?> myObjectClass = classLoader.loadClass(pluginClass);
			return (Plugin) myObjectClass.newInstance();
		} catch (Exception e)
		{
				return null;
		}
	}

}
