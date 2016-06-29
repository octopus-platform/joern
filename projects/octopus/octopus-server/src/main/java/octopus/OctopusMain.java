package octopus;

import com.orientechnologies.orient.core.exception.OSchemaException;
import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;
import orientdbimporter.CSVBatchImporter;

import java.io.File;

public class OctopusMain {

    static OctopusMain main;
    OServer server;

    public static void main(String[] args) throws java.lang.Exception
    {
        main = new OctopusMain();
        main.startOrientdb();
    }

    public void startOrientdb() throws java.lang.Exception
    {
        String octopusHome = System.getProperty("OCTOPUS_HOME");

        if (octopusHome == null)
        {
            throw new RuntimeException("System property OCTOPUS_HOME not defined.");
        }

        System.setProperty("ORIENTDB_HOME",octopusHome + "/orientdb");
        System.setProperty("orientdb.www.path",octopusHome +"/orientdb/www");
        System.setProperty("orientdb.config.file", octopusHome + "/conf/orientdb-server-config.xml");

        server = OServerMain.create();
        server.startup();
        server.activate();
    }

    public void stopOrientdb()
    {
        server.shutdown();
    }
}
