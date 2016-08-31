package outputModules.csv.exporters;

import cfg.CCFGFactory;
import udg.useDefAnalysis.CASTDefUseAnalyzer;

public class CCSVFunctionExporter extends CSVFunctionExporter {

	public CCSVFunctionExporter()
	{
		super();
		analyzer = new CASTDefUseAnalyzer();
		cfgFactory = new CCFGFactory();
	}

}
