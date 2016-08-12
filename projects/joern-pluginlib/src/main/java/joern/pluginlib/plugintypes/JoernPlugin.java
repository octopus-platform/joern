package joern.pluginlib.plugintypes;

import joern.pluginlib.JoernProject;
import octopus.api.database.Database;

public class JoernPlugin extends JoernProjectPlugin {

    private JoernProject project;
	private Database database;

	 @Override
     public void beforeExecution() throws Exception
     {
		 setProject((JoernProject) getProjectConnector().getWrapper());
		 connectToProjectDatabase();
     }

	 private void connectToProjectDatabase()
     {
		 database = getProject().getNewDatabaseInstance();
     }

	 protected JoernProject getProject()
     {
             return project;
     }

     protected void setProject(JoernProject project)
     {
             this.project = project;
     }

}
