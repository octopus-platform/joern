package octopus.server.components.gremlinShell;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import octopus.server.components.gremlinShell.io.BjoernClientReader;
import octopus.server.components.gremlinShell.io.BjoernClientWriter;
import octopus.server.components.shellmanager.ShellManager;

public class ShellRunnable implements Runnable
{
	private static final Logger logger = LoggerFactory
			.getLogger(ShellRunnable.class);

	private String dbName;
	private ServerSocket serverSocket;
	private OctopusGremlinShell bjoernGremlinShell;
	private Socket clientSocket;
	private BjoernClientWriter clientWriter;
	private BjoernClientReader clientReader;

	private boolean listening = true;

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	@Override
	public void run()
	{
		createGremlinShell();

		try
		{
			createLocalListeningSocket();
			processClients();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void createGremlinShell()
	{
		int port = ShellManager.createNewShell(dbName);
		bjoernGremlinShell = ShellManager.getShellForPort(port);
	}

	private void createLocalListeningSocket() throws IOException
	{
		InetAddress bindAddr = InetAddress.getLoopbackAddress();
		serverSocket = new ServerSocket(bjoernGremlinShell.getPort(), 10,
				bindAddr);
	}

	private void processClients() throws IOException
	{
		while (listening)
		{
			try
			{
				acceptNewClient();
				handleClient();
			}
			catch (IOException e)
			{
				logger.warn("IOException when handling client: {}",
						e.getMessage());
				continue;
			}

		}
		ShellManager.destroyShell(bjoernGremlinShell.getPort());
		serverSocket.close();
	}

	private void acceptNewClient() throws IOException
	{
		clientSocket = serverSocket.accept();
		initClientWriter();
		initClientReader();
	}

	private void initClientReader() throws IOException
	{
		InputStream in = clientSocket.getInputStream();
		clientReader = new BjoernClientReader(new InputStreamReader(in));
	}

	private void initClientWriter() throws IOException
	{
		OutputStream out = clientSocket.getOutputStream();
		clientWriter = new BjoernClientWriter(new OutputStreamWriter(out));
	}

	private void handleClient() throws IOException
	{

		String message;
		while ((message = clientReader.readMessage()) != null)
		{
			if (message.equals("quit"))
			{
				listening = false;
				clientWriter.writeMessage("bye");
				break;
			}
			else
			{
				Object evalResult;
				try
				{
					evalResult = bjoernGremlinShell.execute(message);
					clientWriter.writeResult(evalResult);
				}
				catch (Exception ex)
				{
					clientWriter.writeMessage(ex.getMessage());
				}
			}

		}
		clientSocket.close();
	}
}
