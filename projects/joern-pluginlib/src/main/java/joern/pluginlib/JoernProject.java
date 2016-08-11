package joern.pluginlib;

import java.io.File;

import octopus.lib.projects.OctopusProjectWrapper;

public class JoernProject extends OctopusProjectWrapper {

	public String getSourceCodeDirectory()
	{
		return getPathToProjectDir() + File.separator + "src";
	}

	public String getTarballName()
	{
		return getPathToProjectDir() + File.separator + "binary";
	}

	public String getParserOutputDirectory()
	{
		return getPathToProjectDir() + File.separator + "parseroutput";
	}

}
