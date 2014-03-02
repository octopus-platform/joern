package output.neo4j.batchInserter;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationGenerator {

	/**
	 * Creates a BatchInserter configuration based on
	 * the amount of memory available to the JVM.
	 * @return 
	 * */
	
	public static Map<String, String> generateConfiguration()
	{
		Runtime runtime = Runtime.getRuntime();
    	long maxMemory = runtime.maxMemory() / (1024*1024);
	
    	// TODO: return configuration based on amount of RAM.
    	// Need to run some performance tests to get this right.
    	
    	return get6GBImportConfiguration();
	}
	
	private static Map<String, String> get6GBImportConfiguration()
	{
		Map<String, String> config = new HashMap<String, String>();
		config.put("cache_type", "none");
		config.put("use_memory_mapped_buffers", "true");
		config.put("neostore.nodestore.db.mapped_memory", "200M");
		config.put("neostore.relationshipstore.db.mapped_memory", "3G");
		config.put("neostore.propertystore.db.mapped_memory", "500M");
		config.put("neostore.propertystore.db.strings.mapped_memory", "500M");
		config.put("neostore.propertystore.db.index.keys.mapped_memory", "5M");
		config.put("neostore.propertystore.db.index.mapped_memory", "5M");
		return config;
	}
	
}
