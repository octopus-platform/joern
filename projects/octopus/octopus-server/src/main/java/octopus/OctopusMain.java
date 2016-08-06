package octopus;

import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;

import octopus.server.components.ftpserver.OctopusFTPServer;

public class OctopusMain {

    static OctopusMain main;
    String octopusHome;
    OServer server;
    OctopusFTPServer ftpServer;

    public static void main(String[] args) throws java.lang.Exception
    {
        main = new OctopusMain();
        main.startOrientdb();
        main.startFTPServer();
    }

    public OctopusMain()
    {
	initializeOctopusHome();
    }

    private void initializeOctopusHome()
	{
		octopusHome = System.getProperty("OCTOPUS_HOME");

        if (octopusHome == null)
        {
            throw new RuntimeException("System property OCTOPUS_HOME not defined.");
        }
	}

	public void startOrientdb() throws java.lang.Exception
    {
        System.setProperty("ORIENTDB_HOME",octopusHome + "/orientdb");
        System.setProperty("orientdb.www.path",octopusHome +"/orientdb/www");
        System.setProperty("orientdb.config.file", octopusHome + "/conf/orientdb-server-config.xml");

        server = OServerMain.create();
        server.startup();
        server.activate();
    }

    private void startFTPServer()
    {
		ftpServer = new OctopusFTPServer();
		ftpServer.start(octopusHome);
    }

    public void stopOrientdb()
    {
        server.shutdown();
    }
}
