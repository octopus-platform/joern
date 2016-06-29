package octopus.server.components.shellmanager;

import octopus.server.components.gremlinShell.OctopusGremlinShell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class ShellManager
{
	private static final Logger logger = LoggerFactory
			.getLogger(ShellManager.class);

	private static final int MAX_SHELLS = 1024;
	private static final int FIRST_PORT = 6000;

	static OctopusGremlinShell[] shells;

	static
	{
		logger.info("Initializing ShellManager");
		shells = new OctopusGremlinShell[MAX_SHELLS];
	}

	public synchronized static int createNewShell(String dbName)
	{
		int port = getFirstFreePort();
		OctopusGremlinShell shell = new OctopusGremlinShell(dbName);
		shell.setPort(port);
		shells[port - FIRST_PORT] = shell;
		shell.initShell();

		return port;
	}

	private static int getFirstFreePort()
	{
		for (int i = 0; i < MAX_SHELLS; i++)
		{
			if (shells[i] == null)
				return i + FIRST_PORT;
		}

		throw new RuntimeException("No more free slots for your shell");
	}

	public static OctopusGremlinShell getShellForPort(int port)
	{
		int index = port - FIRST_PORT;
		if (index >= MAX_SHELLS || shells[index] == null)
			throw new RuntimeException(String.format(
					"Invalid shell for port: %d", port));

		return shells[index];
	}

	public static void destroyShell(int port)
	{
		int index = port - FIRST_PORT;

		if (index >= MAX_SHELLS || shells[index] == null)
			throw new RuntimeException(String.format(
					"Request to delete non-existent shell: %d", port));

		shells[index] = null;
	}

	public static List<OctopusGremlinShell> getActiveShells()
	{
		List<OctopusGremlinShell> retval = new LinkedList<OctopusGremlinShell>();
		for (int i = 0; i < MAX_SHELLS; i++)
		{
			if (shells[i] != null)
				retval.add(shells[i]);
		}
		return retval;
	}

}
