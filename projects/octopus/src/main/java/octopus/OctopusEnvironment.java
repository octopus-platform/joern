package octopus;

import java.nio.file.Path;
import java.nio.file.Paths;

public class OctopusEnvironment {

	private static final String OCTOPUS_HOME_STR;
	private static final String DATA_STR = "data";
	private static final String PROJECTS_STR = "projects";
	private static final String PLUGINS_STR = "plugins";
	private static final String LANGUAGES_STR = "languages";

	public static final Path PROJECTS_DIR;
	public static final Path PLUGINS_DIR;
	public static final Path LANGUAGES_DIR;

	static {

		OCTOPUS_HOME_STR = System.getProperty("OCTOPUS_HOME");

        if (OCTOPUS_HOME_STR == null)
        {
            throw new RuntimeException("System property OCTOPUS_HOME not defined.");
        }

        PROJECTS_DIR = Paths.get(OCTOPUS_HOME_STR, DATA_STR, PROJECTS_STR);
        PLUGINS_DIR = Paths.get(OCTOPUS_HOME_STR, PLUGINS_STR);
        LANGUAGES_DIR = Paths.get(OCTOPUS_HOME_STR, LANGUAGES_STR);

	}

}
