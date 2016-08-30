package octopus.server.gremlinShell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tinkerpop.gremlin.groovy.AbstractImportCustomizerProvider;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

public class OctopusCompilerConfiguration extends CompilerConfiguration
{

	public OctopusCompilerConfiguration()
	{
		this.setScriptBaseClass(OctopusScriptBase.class.getName());
		this.addCompilationCustomizers(new OctopusImportCustomizer());
	}

}

class OctopusImportCustomizerProvider extends AbstractImportCustomizerProvider
{

    public Set<String> getCombinedStaticImports()
    {
        final Set<String> combined = new HashSet<>();
        combined.addAll(getStaticImports());
        combined.addAll(extraStaticImports);

        return Collections.unmodifiableSet(combined);
    }

    public Set<String> getCombinedImports()
    {
        final Set<String> combined = new HashSet<>();
        combined.addAll(getImports());
        combined.addAll(extraImports);

        return Collections.unmodifiableSet(combined);
    }
}

class OctopusImportCustomizer extends ImportCustomizer
{

	private static final List<String> imports = new ArrayList<String>();
	static
	{
		OctopusImportCustomizerProvider provider = new OctopusImportCustomizerProvider();

		imports.addAll(provider.getAllImports());
		imports.add("static com.thinkaurelius.titan.core.attribute.Text.*");
		imports.add("static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.*");
		imports.add("static org.apache.tinkerpop.gremlin.process.traversal.step.TraversalOptionParent.*");
		imports.add("groovy.grape.Grape");
	}

	public OctopusImportCustomizer()
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