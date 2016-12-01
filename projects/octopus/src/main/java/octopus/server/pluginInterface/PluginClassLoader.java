package octopus.server.pluginInterface;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginClassLoader extends ClassLoader {

	private String jarFilename;
	private Hashtable<String,Class<?>> classCache = new Hashtable<String,Class<?>>();

	public PluginClassLoader(ClassLoader parent)
	{
		super(parent);
	}

	@Override
	public Class<?> loadClass(String className)
	{
		Class<?> classFromCache = getClassFromCache(className);
		if(classFromCache != null)
			return classFromCache;

		return tryToLoadClassFromJar(className);
	}

	private Class<?> tryToLoadClassFromJar(String className)
	{
		try {
			return loadClassFromJar(className);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Class<?> loadClassFromJar(String className) throws IOException
	{

		Class<?> retval = loadClassDirectly(className);

		if(retval == null)
			return loadClassViaParent(className);

		return retval;
	}

	private Class<?> loadClassDirectly(String className)
	{

		JarFile jar = null;
		try {
			jar = new JarFile(getJarFilename());
			JarEntry entry = jar.getJarEntry(className.replace('.', '/') + ".class");

			if(entry == null)
			{
				jar.close();
				return null;
			}

			InputStream is = jar.getInputStream(entry);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			int nextValue = is.read();
			while (-1 != nextValue) {
				byteStream.write(nextValue);
				nextValue = is.read();
			}

			byte classByte [] = byteStream.toByteArray();
			Class<?> result = defineClass(className, classByte, 0, classByte.length, null);
			classCache.put(className, result);
			tryToCloseJar(jar);
			return result;

		} catch (IOException e) {
			tryToCloseJar(jar);
		}

		return null;
	}

	private void tryToCloseJar(JarFile jar)
	{
		if(jar == null)
			return;

		try {
			jar.close();
		} catch (IOException e) {
		}
	}

	private Class<?> loadClassViaParent(String className)
	{
		try {
			return super.loadClass(className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	private Class<?> getClassFromCache(String className)
	{
		return classCache.get(className);
	}

	public String getJarFilename()
	{
		return jarFilename;
	}

	public void setJarFilename(String jarFilename)
	{
		this.jarFilename = jarFilename;
	}


}
