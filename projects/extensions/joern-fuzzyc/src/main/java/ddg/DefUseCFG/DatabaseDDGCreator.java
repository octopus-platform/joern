package ddg.DefUseCFG;

import ddg.DDGCreator;
import ddg.DataDependenceGraph.DDG;
import ddg.DefUseCFG.DefUseCFG;
import ddg.DefUseCFG.DefUseCFGFactory;

public class DatabaseDDGCreator extends DDGCreator {
	DefUseCFGFactory cfgFactory = new BatchInserterFactory();

	public void setFactory(DefUseCFGFactory aFactory)
	{
		cfgFactory = aFactory;
	}

	public DDG createForFunctionById(Long funcId)
	{
		DefUseCFG cfg = cfgFactory.create(funcId);
		return createForDefUseCFG(cfg);
	}


}
