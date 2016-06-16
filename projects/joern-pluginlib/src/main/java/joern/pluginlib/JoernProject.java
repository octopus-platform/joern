package joern.pluginlib;

import java.io.File;

import octopus.lib.OctopusProjectWrapper;

public class JoernProject extends OctopusProjectWrapper {

	public String getSourceCodeDirectory()
	{
		return getPathToProjectDir() + File.separator + "src";
	}

	public String getTarballName()
	{
		return getPathToProjectDir() + File.separator + "binary";
	}

}
