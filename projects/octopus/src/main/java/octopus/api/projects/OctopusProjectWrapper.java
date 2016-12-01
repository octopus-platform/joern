package octopus.api.projects;

import octopus.api.database.Database;

public class OctopusProjectWrapper {

	private OctopusProject oProject;

	public void setWrappedProject(OctopusProject project)
	{
		oProject = project;
	}

	public OctopusProject unwrap()
	{
		return oProject;
	}

	 public String getPathToProjectDir()
     {
             return oProject.getPathToProjectDir();
     }

     public Database getNewDatabaseInstance()
     {
    	 return oProject.getNewDatabaseInstance();
     }

     public String getName()
     {
    	 return oProject.getName();
 	}

}
