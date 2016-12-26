package tests.udg;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import tests.TestDBTestsBatchInserter;
import udg.CFGToUDGConverter;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;
import cfg.ASTToCFGConverter;
import cfg.CFG;

public class testUseDefGraphCreator extends TestDBTestsBatchInserter
{

	ASTToCFGConverter astToCFG;
	CFGToUDGConverter cfgToUDG;

	private static final Map<String, String> functionMap;
	static
	{
		Map<String, String> aMap = new HashMap<String, String>();
		
		aMap.put("condition_test",
				"int condition_test() { if(x && y) return 0; if(z) return 1; }");
		aMap.put("udg_test_def_tainted_call", "int f(){foo(x);}");
		aMap.put("plusEqualsUse", "int f(){ x += y; }");
		aMap.put(
				"ddg_test_struct",
				"int ddg_test_struct(){ struct my_struct foo; foo.bar = 10; copy_somehwere(foo); }");

		functionMap = aMap;
	}

	@Before
	public void init()
	{
		astToCFG = new ASTToCFGConverter();
		cfgToUDG = new CFGToUDGConverter();
	}

	@Test
	public void test_struct_field_assign_def()
	{
		UseDefGraph useDefGraph = createUDGForFunction("ddg_test_struct");
		assertOnlyDefForXFound(useDefGraph, "foo . bar");
	}

	@Test
	public void test_def_tainted_call()
	{
		String code = functionMap.get("udg_test_def_tainted_call");
		CFG cfg = getCFGForCode(code);
		CFGToUDGConverter myCFGToUDG = new CFGToUDGConverter();
		myCFGToUDG.addTaintSource("foo", 0);
		UseDefGraph useDefGraph = myCFGToUDG.convert(cfg);

		assertOnlyDefForXFound(useDefGraph, "* x");
		assertDefAndUseForXFound(useDefGraph, "x");
	}

	@Test
	public void test_plusEquals_asssignment()
	{
		UseDefGraph useDefGraph = createUDGForFunction("plusEqualsUse");
		assertDefAndUseForXFound(useDefGraph, "x");
		assertOnlyUseForXFound(useDefGraph, "y");
	}

	@Test
	public void test_condition()
	{
		UseDefGraph useDefGraph = createUDGForFunction("condition_test");
		assertOnlyUseForXFound(useDefGraph, "x");
		assertOnlyUseForXFound(useDefGraph, "y");
		assertOnlyUseForXFound(useDefGraph, "z");
	}


	private UseDefGraph createUDGForFunction(String functionName)
	{
		String code = functionMap.get(functionName);
		CFG cfg = getCFGForCode(code);
		return cfgToUDG.convert(cfg);
	}

	public CFG getCFGForCode(String input)
	{
		CFGCreator cfgCreator = new CFGCreator();
		return cfgCreator.getCFGForCode(input);
	}

	private void assertOnlyDefForXFound(UseDefGraph useDefGraph, String symbol)
	{
		List<UseOrDefRecord> usesAndDefs = useDefGraph
				.getUsesAndDefsForSymbol(symbol);
		assertTrue(usesAndDefs != null);
		assertTrue(usesAndDefs.size() > 0);

		// make sure only 'uses' of x exist
		for (UseOrDefRecord r : usesAndDefs)
		{
			assertTrue(r.isDef());
		}
	}

	private void assertOnlyUseForXFound(UseDefGraph useDefGraph, String symbol)
	{
		List<UseOrDefRecord> usesAndDefs = useDefGraph
				.getUsesAndDefsForSymbol(symbol);
		assertTrue(usesAndDefs != null);
		assertTrue(usesAndDefs.size() > 0);

		// make sure only 'uses' of x exist
		for (UseOrDefRecord r : usesAndDefs)
		{
			assertTrue(!r.isDef());
		}
	}

	private void assertDefAndUseForXFound(UseDefGraph useDefGraph, String symbol)
	{

		List<UseOrDefRecord> usesAndDefs = useDefGraph
				.getUsesAndDefsForSymbol(symbol);
		assertTrue(usesAndDefs != null);
		assertTrue(usesAndDefs.size() > 0);

		boolean isDefined = false, isUsed = false;

		// make sure only 'definitions' of x exist
		for (UseOrDefRecord r : usesAndDefs)
		{
			if (r.isDef())
				isDefined = true;
			if (!r.isDef())
				isUsed = true;
		}

		assertTrue(isDefined);
		assertTrue(isUsed);
	}

}
