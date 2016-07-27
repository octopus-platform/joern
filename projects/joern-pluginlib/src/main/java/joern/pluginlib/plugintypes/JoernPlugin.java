package joern.pluginlib.plugintypes;

import joern.pluginlib.JoernProject;
import octopus.lib.connectors.OrientDBConnector;

public class JoernPlugin extends JoernProjectPlugin {

    private JoernProject project;
	private OrientDBConnector orientConnector = new OrientDBConnector();

	 @Override
     public void beforeExecution() throws Exception
     {
		 setProject((JoernProject) getProjectConnector().getWrapper());
		 connectToProjectDatabase();
     }

	 private void connectToProjectDatabase()
     {
		 String databaseName = getProject().getDatabaseName();
		 getOrientConnector().connect(databaseName);
     }

	 protected JoernProject getProject()
     {
             return project;
     }

     protected void setProject(JoernProject project)
     {
             this.project = project;
     }

     protected OrientDBConnector getOrientConnector()
     {
             return orientConnector;
     }

     protected void setOrientConnector(OrientDBConnector orientConnector)
     {
             this.orientConnector = orientConnector;
     }


}
