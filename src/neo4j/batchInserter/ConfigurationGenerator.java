package neo4j.batchInserter;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationGenerator
{

	/**
	 * Creates a BatchInserter configuration based on the amount of memory
	 * available to the JVM.
	 * 
	 * @return
	 * */

	public static Map<String, String> generateConfiguration()
	{
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / (1024 * 1024);

		if (maxMemory < 2000)
		{
			System.err
					.println("Warning: your JVM has a maximum heap size of less than"
							+ " 2 Gig. You may need to import large code bases in batches.");
			System.err
					.println("If you have additional memory, you may want to allow your JVM to access it"
							+ " by using the -Xmx flag.");

		}

		if (maxMemory < 4000)
			return get4GBImportConfiguration();
		else
			return get6GBImportConfiguration();
	}

	private static Map<String, String> get6GBImportConfiguration()
	{
		Map<String, String> config = new HashMap<String, String>();
		config.put("cache_type", "none");
		config.put("use_memory_mapped_buffers", "true");
		config.put("neostore.nodestore.db.mapped_memory", "1G");
		config.put("neostore.relationshipstore.db.mapped_memory", "3G");
		config.put("neostore.propertystore.db.mapped_memory", "1G");
		config.put("neostore.propertystore.db.strings.mapped_memory", "500M");
		config.put("neostore.propertystore.db.index.keys.mapped_memory", "5M");
		config.put("neostore.propertystore.db.index.mapped_memory", "5M");
		return config;
	}

	private static Map<String, String> get4GBImportConfiguration()
	{
		Map<String, String> config = new HashMap<String, String>();
		config.put("cache_type", "none");
		config.put("use_memory_mapped_buffers", "true");
		config.put("neostore.nodestore.db.mapped_memory", "200M");
		config.put("neostore.relationshipstore.db.mapped_memory", "2G");
		config.put("neostore.propertystore.db.mapped_memory", "200M");
		config.put("neostore.propertystore.db.strings.mapped_memory", "200M");
		config.put("neostore.propertystore.db.index.keys.mapped_memory", "5M");
		config.put("neostore.propertystore.db.index.mapped_memory", "5M");
		return config;
	}

}
