package octopus.lib;

import octopus.server.components.projectmanager.OctopusProject;

public class OctopusProjectWrapper {

	private OctopusProject oProject;

	public void setWrappedProject(OctopusProject project)
	{
		oProject = project;
	}

	 public String getPathToProjectDir()
     {
             return oProject.getPathToProjectDir();
     }

     public String getDatabaseName()
     {
             return oProject.getDatabaseName();
     }

}
