package octopus.server.commands.manageshells;

import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAbstract;
import octopus.server.components.gremlinShell.OctopusGremlinShell;
import octopus.server.components.gremlinShell.ShellRunnable;
import octopus.server.components.shellmanager.ShellManager;

import java.io.IOException;

public class ManageShellsHandler extends OServerCommandAbstract
{
	public ManageShellsHandler(final OServerCommandConfiguration iConfiguration)
	{
	}

	@Override
	public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse)
			throws Exception
	{

		String[] urlParts = checkSyntax(iRequest.url, 2, "Syntax error: manageshells/<cmd>/[projectName]");

		String command = urlParts[1];

		switch (command)
		{
			case "list":
				return executeList(iRequest, iResponse);
			case "create":
				return executeCreate(iRequest, iResponse);
			default:
				iResponse.send(OHttpUtils.STATUS_NOTFOUND_CODE, "Not found", null, "", null);
				return false;
		}
	}

	private boolean executeList(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{
		checkSyntax(iRequest.url, 2, "Syntax error: manageshells/list");
		StringBuilder sb = new StringBuilder();
		for (OctopusGremlinShell shell : ShellManager.getActiveShells())
		{
			sb.append(rowForShell(shell));
			sb.append('\n');

		}
		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, sb.toString(), null);
		return false;
	}

	private boolean executeCreate(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{
		String[] urlParts = checkSyntax(iRequest.url, 3, "Syntax error: manageshells/create/projectName");
		int port = ShellManager.createNewShell(urlParts[2]);
		OctopusGremlinShell shell = ShellManager.getShellForPort(port);
		startShellThread(shell);
		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, port + "\n", null);
		return false;
	}

	private void startShellThread(OctopusGremlinShell shell) throws IOException
	{
		ShellRunnable runnable = new ShellRunnable(shell);
		Thread thread = new Thread(runnable);
		thread.start();
	}

	private Object rowForShell(OctopusGremlinShell shell)
	{
		return String.format("%d\t%s", shell.getPort(), shell.getDbName());
	}

	@Override
	public String[] getNames()
	{
		return new String[]{"GET|manageshells/*"};
	}

}
