package octopus.server.components.pluginInterface;

import java.nio.file.Path;

public class PluginLoader
{
	public static Plugin load(Path pathToJar, String pluginClass)
	{
		ClassLoader parentClassLoader = PluginClassLoader.class
				.getClassLoader();
		PluginClassLoader classLoader = new PluginClassLoader(
				parentClassLoader);
		classLoader.setJarFilename(pathToJar.toString());
		// It would be cleaner to put the name of the class implementing the
		// plugin somewhere in the jar.
		Class<?> myObjectClass = classLoader.loadClass(pluginClass);
		try
		{
			return (Plugin) myObjectClass.newInstance();
		} catch (Exception e)
		{
			return null;
		}
	}
}
