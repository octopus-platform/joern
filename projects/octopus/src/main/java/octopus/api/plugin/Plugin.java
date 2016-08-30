package octopus.api.plugin;

import org.json.JSONObject;

public interface Plugin
{
	void configure(JSONObject settings);

	void execute() throws Exception;

	default void beforeExecution() throws Exception {}

	default void afterExecution() throws Exception {}

	default Object result()
	{
		return null;
	}
}