package octopus.server.components.gremlinShell;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

public class OctopusCompilerConfiguration extends CompilerConfiguration
{

	public OctopusCompilerConfiguration()
	{
		this.setScriptBaseClass(OctopusScriptBase.class.getName());
		this.addCompilationCustomizers(new BjoernImportCustomizer());
	}

}

class BjoernImportCustomizer extends ImportCustomizer
{

	private static final List<String> imports = new ArrayList<String>();

	static
	{
		// TODO
		// imports.addAll(Imports.getImports());
		// imports.add("com.tinkerpop.gremlin.Tokens.T");
		// imports.add("com.tinkerpop.gremlin.groovy.*");
		imports.add("groovy.grape.Grape");
	}

	public BjoernImportCustomizer()
	{
		for (String s : imports)
		{
			String importString = new String(s);
			byte mask = 0b00;
			if (importString.endsWith(".*"))
			{
				importString = importString.substring(0,
						importString.lastIndexOf(".*"));
				mask |= 0b01;
			}
			if (importString.startsWith("static"))
			{
				importString = importString.substring(7);
				mask |= 0b10;
			}
			switch (mask)
			{
			case 0b00:
				addImports(importString);
				break;
			case 0b01:
				addStarImports(importString);
				break;
			case 0b10:
				break;
			case 0b11:
				addStaticStars(importString);
				break;
			}
		}
	}

}