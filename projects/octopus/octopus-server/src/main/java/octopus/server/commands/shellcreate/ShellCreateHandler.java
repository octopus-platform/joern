package octopus.server.commands.shellcreate;

import com.orientechnologies.common.log.OLogManager;
import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAbstract;

import octopus.server.Constants;
import octopus.server.components.gremlinShell.ShellRunnable;

public class ShellCreateHandler extends OServerCommandAbstract
{

	private String dbName;

	public ShellCreateHandler(final OServerCommandConfiguration iConfiguration)
	{
	}

	@Override
	public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse)
			throws Exception
	{
		OLogManager.instance().warn(this, "shellcreate");

		dbName = getDbNameFromRequest(iRequest);

		startShellThread();

		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, String.format(
				"shell opened for %s. Try listshells next\n", dbName), null);
		return false;
	}

	private String getDbNameFromRequest(OHttpRequest iRequest)
	{
		String[] urlParts = checkSyntax(iRequest.url, 0,
				"Syntax error: shellcreate/[dbName]");

		if (urlParts.length >= 2 && !urlParts[1].equals(""))
			return urlParts[1];
		return Constants.DEFAULT_DB_NAME;
	}

	private void startShellThread()
	{
		ShellRunnable runnable = new ShellRunnable();
		runnable.setDbName(dbName);
		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Override
	public String[] getNames()
	{
		return new String[] { "GET|shellcreate/*" };
	}

}
