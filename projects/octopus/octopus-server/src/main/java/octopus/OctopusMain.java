package octopus;

import org.apache.ftpserver.FtpServerConfigurationException;
import org.apache.ftpserver.ftplet.FtpException;

import octopus.server.ftpserver.OctopusFTPServer;
import octopus.server.restServer.OctopusRestServer;

public class OctopusMain {

    static OctopusMain main;
    String octopusHome;

    OctopusFTPServer ftpServer;

    public static void main(String[] args) throws java.lang.Exception
    {
        main = new OctopusMain();
        main.startFTPServer();
        main.startRestServer();
    }

	public OctopusMain()
    {
		initializeOctopusHome();
		tryToLoadConfigFile();
    }

    private void tryToLoadConfigFile()
    {
    	String configFilename = octopusHome + "/conf/octopus.conf";
    	OctopusConfigFile configFile = new OctopusConfigFile(configFilename);
    	configFile.transferToEnvironment();
    }

	private void initializeOctopusHome()
	{
		octopusHome = System.getProperty("OCTOPUS_HOME");

        if (octopusHome == null)
        {
            throw new RuntimeException("System property OCTOPUS_HOME not defined.");
        }
	}

    private void startFTPServer()
    {
		ftpServer = new OctopusFTPServer();
		try {
			ftpServer.start(octopusHome);
		} catch (FtpException| FtpServerConfigurationException e) {
			System.out.println("Error starting Octopus");
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

    private void startRestServer()
    {
		OctopusRestServer.start();
	}

}
