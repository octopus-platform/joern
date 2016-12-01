package octopus.api.shell;

import java.io.IOException;
import java.util.List;

import octopus.server.gremlinShell.OctopusGremlinShell;
import octopus.server.gremlinShell.ShellRunnable;
import octopus.server.shellmanager.OctopusShellManager;

public class ShellManager {

	public List<OctopusGremlinShell> getActiveShells()
	{
		return OctopusShellManager.getActiveShells();
	}

	public int createNewShellThread(String projectName, String shellName) throws IOException
	{
		int port = OctopusShellManager.createNewShell(projectName, shellName);
		OctopusGremlinShell shell = OctopusShellManager.getShellForPort(port);
		startShellThread(shell);
		return port;
	}

	private void startShellThread(OctopusGremlinShell shell) throws IOException
	{
		ShellRunnable runnable = new ShellRunnable(shell);
		Thread thread = new Thread(runnable);
		thread.start();
	}

}
