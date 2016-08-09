package octopus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class OctopusConfigFile {

	private Properties properties;

	public OctopusConfigFile(String filename)
	{
		tryToLoadConfigFile(filename);
	}

	private void tryToLoadConfigFile(String filename)
	{
		try {
			loadConfigFile(filename);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("octopus config file not found");
		} catch (IOException e) {
			throw new RuntimeException("error parsing octopus config file");
		}
	}

	private void loadConfigFile(String filename) throws FileNotFoundException, IOException
	{
		FileInputStream fileInput;
		fileInput = new FileInputStream(filename);
		properties = new Properties();
		properties.load(fileInput);

	}

	public void transferToEnvironment()
	{
		Enumeration<Object> keys = properties.keys();
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement();
			String value = properties.getProperty(key);
			System.setProperty(key, value);
		}
	}

}
