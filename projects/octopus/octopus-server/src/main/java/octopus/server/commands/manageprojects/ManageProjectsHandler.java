package octopus.server.commands.manageprojects;

import java.io.IOException;

import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.config.OServerEntryConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAbstract;

import octopus.server.components.projectmanager.ProjectManager;

public class ManageProjectsHandler extends OServerCommandAbstract
{

	String projectsDir;

	public ManageProjectsHandler(final OServerCommandConfiguration iConfiguration)
	{
		readConfiguration(iConfiguration);
		try {
			ProjectManager.setProjectDir(projectsDir);
		} catch (IOException e) {
			throw new RuntimeException("Error opening project dir");
		}
	}

	private void readConfiguration(OServerCommandConfiguration iConfiguration)
	{
		for (OServerEntryConfiguration param : iConfiguration.parameters)
		{
			switch (param.name)
			{
				case "dir":
					projectsDir = System.getProperty("OCTOPUS_HOME") + "/" + param.value;
					break;
			}
		}

	}

	@Override
	public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{

		String[] urlParts = checkSyntax(
				iRequest.url,
				3,
				"Syntax error: manageprojects/<cmd>/<projectName>");

		String command = urlParts[1];
		String projectName = urlParts[2];

		if(command.equals("create"))
			ProjectManager.create(projectName);
		else if(command.equals("delete"))
			ProjectManager.delete(projectName);

		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null,
				"", null);

		return false;
	}

	@Override
	public String[] getNames()
	{
		return new String[] { "GET|manageprojects/*" };
	}

}
