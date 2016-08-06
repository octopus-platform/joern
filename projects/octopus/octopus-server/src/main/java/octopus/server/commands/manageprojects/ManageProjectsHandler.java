package octopus.server.commands.manageprojects;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.config.OServerEntryConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAbstract;

import octopus.server.components.projectmanager.ProjectManager;

public class ManageProjectsHandler extends OServerCommandAbstract
{

	Path projectsDir;

	public ManageProjectsHandler(final OServerCommandConfiguration iConfiguration)
	{
		readConfiguration(iConfiguration);
		try
		{
			ProjectManager.setProjectDir(projectsDir);
		} catch (IOException e)
		{
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
					projectsDir = Paths.get(System.getProperty("OCTOPUS_HOME"), param.value);
					break;
			}
		}

	}

	@Override
	public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{

		String[] urlParts = checkSyntax(iRequest.url, 2, "Syntax error: manageprojects/<cmd>/[projectName]");

		String command = urlParts[1];

		if (command.equals("create"))
		{
			return executeCreate(iRequest, iResponse);
		} else if (command.equals("delete"))
		{
			return executeDelete(iRequest, iResponse);
		} else if (command.equals("list"))
		{
			return executeList(iRequest, iResponse);
		} else
		{
			iResponse.send(OHttpUtils.STATUS_NOTFOUND_CODE, "Not found", null, "", null);
			return false;
		}

	}

	private boolean executeCreate(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{
		String[] urlParts = checkSyntax(iRequest.url, 3, "Syntax error: manageprojects/create/projectName");
		String projectName = urlParts[2];
		if (ProjectManager.doesProjectExist(projectName))
		{
			iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, "Project already exists.", null);
		} else
		{
			ProjectManager.create(projectName);
			iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, "Project created.", null);
		}
		return false;
	}

	private boolean executeDelete(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{
		String[] urlParts = checkSyntax(iRequest.url, 3, "Syntax error: manageprojects/delete/projectName");
		String projectName = urlParts[2];
		if (ProjectManager.doesProjectExist(projectName))
		{
			ProjectManager.delete(projectName);
			iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, "Project deleted.", null);
		} else
		{
			iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, "Project does not exist.", null);
		}
		return false;
	}

	private boolean executeList(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{
		checkSyntax(iRequest.url, 2, "Syntax error: manageprojects/list");
		StringBuilder sb = new StringBuilder();
		for (String name : ProjectManager.listProjects())
		{
			sb.append(name);
			sb.append('\n');
		}
		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null, sb.toString(), null);
		return false;
	}

	@Override
	public String[] getNames()
	{
		return new String[]{"GET|manageprojects/*", "POST|manageprojects/uploadfile/*"};
	}

}
