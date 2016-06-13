package octopus.server.commands.uploadfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import com.orientechnologies.orient.server.config.OServerCommandConfiguration;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAbstract;

import octopus.server.components.projectmanager.ProjectManager;


public class UploadHandler extends OServerCommandAbstract {

	public UploadHandler(final OServerCommandConfiguration iConfiguration)
	{
	}

	@Override
	public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception
	{
		String dstFilename = extractDstFilename(iRequest);

		byte[] decoded = Base64.getMimeDecoder().decode(iRequest.content);

		writeDataToFile(dstFilename, decoded);

		iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", null,
				"", null);
		return false;
	}

	private String extractDstFilename(OHttpRequest iRequest)
	{
		String[] urlParts = checkSyntax(
				iRequest.url,
				3,
				"Syntax error: uploadfile/<projectName>/<relativePath>");

		String projectName =  urlParts[1];
		String relativePath = urlParts[2];

		String pathToProject = ProjectManager.getPathToProject(projectName);
		String dstFilename = pathToProject + File.separator + relativePath;
		return dstFilename;
	}

	private void writeDataToFile(String dstFilename, byte[] data) throws FileNotFoundException, IOException
	{
		FileOutputStream file = new FileOutputStream(dstFilename);
		file.write(data);
		file.close();
	}

	@Override
	public String[] getNames()
	{
		return new String[] {"POST|uploadfile/*"};
	}

}
