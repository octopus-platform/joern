package tests.udg;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.neo4j.graphdb.index.IndexHits;

import tests.TestDBTestsBatchInserter;

import traversals.batchInserter.Function;
import udg.useDefGraph.UseDefGraph;
import udg.useDefGraph.UseOrDefRecord;

public class testUseDefGraphCreator extends TestDBTestsBatchInserter {

	
	@Test
	public void testSimpleDecl()
	{
		UseDefGraph useDefGraph = createUDGForFunction("udg_test_simple_decl");		
		assertOnlyDefForXFound(useDefGraph, "x");
	}

	@Test
	public void testDeclWithAssignment()
	{
		UseDefGraph useDefGraph = createUDGForFunction("udg_test_decl_with_assign");		
		assertOnlyDefForXFound(useDefGraph, "x");
	}
	
	@Test
	public void testParamDecl()
	{
		UseDefGraph useDefGraph = createUDGForFunction("udg_test_param_decl");		
		assertOnlyDefForXFound(useDefGraph, "x");
	}
	
	@Test
	public void test_use_untainted_call()
	{
		UseDefGraph useDefGraph = createUDGForFunction("udg_test_use_untainted_call");
		assertOnlyUseForXFound(useDefGraph, "x");
	}
	
	@Test
	public void test_struct_field_use()
	{
		UseDefGraph useDefGraph = createUDGForFunction("udg_test_struct_field_use");
		assertOnlyUseForXFound(useDefGraph, "x . y");
		assertOnlyUseForXFound(useDefGraph, "x");
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
		IndexHits<Long> hits = Function.getFunctionsByName("udg_test_def_tainted_call");
		long functionId = hits.next();
		
		UseDefGraphCreator creator = new UseDefGraphCreator();
		creator.addTaintSource("foo", 0);
		
		UseDefGraph useDefGraph = creator.create(functionId);
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
	
	@Test
	public void test_buf_def()
	{
		UseDefGraph useDefGraph = createUDGForFunction("test_buf_def");
		// this, we want to improve. It should be DEF(*x) and USE(x),
		// right now, it's just DEF(x).
		assertOnlyDefForXFound(useDefGraph, "buf"); 
		assertOnlyUseForXFound(useDefGraph, "i");
	}
	
	
	private UseDefGraph createUDGForFunction(String functionName)
	{
		IndexHits<Long> hits = Function.getFunctionsByName(functionName);
		long functionId = hits.next();
		
		UseDefGraphCreator creator = new UseDefGraphCreator();
		return creator.create(functionId);
	}
	
	
	
	private void assertOnlyDefForXFound(UseDefGraph useDefGraph, String symbol)
	{
		List<Object> usesAndDefs = useDefGraph.getUsesAndDefsForSymbol(symbol);
		assertTrue(usesAndDefs != null);
		assertTrue(usesAndDefs.size() > 0);
		
		// make sure only 'uses' of x exist
		for( Object u : usesAndDefs){
			UseOrDefRecord r = (UseOrDefRecord) u;
			assertTrue(r.isDef);
		}
	}

	private void assertOnlyUseForXFound(UseDefGraph useDefGraph, String symbol)
	{
		List<Object> usesAndDefs = useDefGraph.getUsesAndDefsForSymbol(symbol);
		assertTrue(usesAndDefs != null);
		assertTrue(usesAndDefs.size() > 0);
		
		// make sure only 'uses' of x exist
		for( Object u : usesAndDefs){
			UseOrDefRecord r = (UseOrDefRecord) u;
			assertTrue(!r.isDef);
		}
	}
	
	private void assertDefAndUseForXFound(UseDefGraph useDefGraph, String symbol) {
		
		List<Object> usesAndDefs = useDefGraph.getUsesAndDefsForSymbol(symbol);
		assertTrue(usesAndDefs != null);
		assertTrue(usesAndDefs.size() > 0);
		
		boolean isDefined = false, isUsed = false;
		
		// make sure only 'definitions' of x exist
		for( Object u : usesAndDefs){
			UseOrDefRecord r = (UseOrDefRecord) u;
			if(r.isDef) isDefined = true;
			
			if(!r.isDef) isUsed = true;
		}
	
		assertTrue(isDefined);
		assertTrue(isUsed);
	}

}
