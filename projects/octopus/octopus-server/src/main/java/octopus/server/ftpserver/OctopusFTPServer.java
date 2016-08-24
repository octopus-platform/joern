package octopus.server.ftpserver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.ftpserver.ConnectionConfigFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctopusFTPServer {

	private static final Logger logger = LoggerFactory
			.getLogger(OctopusFTPServer.class);

	private static final String FTP_SERVER_HOST = "localhost";
	private static final int FTP_SERVER_PORT = 23231;

	FtpServer server;
	FtpServerFactory serverFactory = new FtpServerFactory();
	ListenerFactory factory = new ListenerFactory();
	ConnectionConfigFactory connectionConfigFactory = new ConnectionConfigFactory();

	public void start(String octopusHome) throws FtpException
	{
		factory.setPort(FTP_SERVER_PORT);
		factory.setServerAddress(FTP_SERVER_HOST);

		configureAnonymousLogin(octopusHome);

		serverFactory.addListener("default", factory.createListener());

		server = serverFactory.createServer();
		server.start();
	}

	private void configureAnonymousLogin(String octopusHome) throws FtpException
	{
		connectionConfigFactory.setAnonymousLoginEnabled(true);
		serverFactory.setConnectionConfig(connectionConfigFactory.createConnectionConfig());

		BaseUser user = configureAnonymousUser();

		Path path = Paths.get(octopusHome, "projects");
		String homeDirectory = path.toString();
		user.setHomeDirectory(homeDirectory);
		serverFactory.getUserManager().save(user);
	}

	private BaseUser configureAnonymousUser()
	{
		BaseUser user = new BaseUser();
		user.setName("anonymous");
		List<Authority> auths = new ArrayList<Authority>();
		Authority auth = new WritePermission();
		auths.add(auth);
		user.setAuthorities(auths);
		return user;
	}

}
