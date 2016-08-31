package joern.api;

import java.io.File;

import octopus.api.projects.OctopusProjectWrapper;

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
