package tools.argumentTainter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import neo4j.EdgeTypes;
import neo4j.readWriteDB.Neo4JDBInterface;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import traversals.readWriteDB.Traversals;
import udg.useDefAnalysis.ASTDefUseAnalyzer;
import udg.useDefGraph.ReadWriteDbASTProvider;
import udg.useDefGraph.UseOrDef;
import ddg.DefUseCFG.DefUseCFG;

public class DefUseCFGPatcher
{

	List<DefUseLink> newlyAddedLinks = new LinkedList<DefUseLink>();
	DefUseCFG defUseCFG;
	ASTDefUseAnalyzer astDefUseAnalyzer = new ASTDefUseAnalyzer();

	public class DefUseLink
	{
		public DefUseLink(String aSymbol, Long aStatementId, boolean aIsDef)
		{
			symbol = aSymbol;
			statement = aStatementId;
			isDef = aIsDef;
		}

		public String symbol;
		public long statement;
		public boolean isDef;
	}

	static final Map<String, Object> EMPTY_PROPERTIES = new HashMap<String, Object>();

	public void setSourceToPatch(String sourceToPatch, int argToPatch)
	{
		astDefUseAnalyzer.addTaintSource(sourceToPatch, argToPatch);
	}

	public Collection<DefUseLink> getDefUseLinksToAdd()
	{
		return newlyAddedLinks;
	}

	public void patchDefUseCFG(DefUseCFG defUseCFG,
			Collection<Node> statementsToPatch)
	{
		this.defUseCFG = defUseCFG;
		newlyAddedLinks.clear();

		for (Node statement : statementsToPatch)
		{

			long statementId = statement.getId();

			Node node = Traversals.getASTForStatement(statement);

			ReadWriteDbASTProvider astProvider = new ReadWriteDbASTProvider();
			astProvider.setNodeId(node.getId());

			Collection<UseOrDef> newDefs = astDefUseAnalyzer
					.analyzeAST(astProvider);

			Collection<Object> oldDefs = defUseCFG
					.getSymbolsDefinedBy(statementId);
			updateDefsToAdd(oldDefs, newDefs, statementId);

		}

	}

	private void updateDefsToAdd(Collection<Object> oldDefs,
			Collection<UseOrDef> newDefs, Long statementId)
	{
		for (UseOrDef newDef : newDefs)
		{
			if (oldDefs.contains(newDef.symbol))
				continue;
			if (!newDef.isDef)
				continue;
			DefUseLink e = new DefUseLink(newDef.symbol, statementId,
					newDef.isDef);
			// add to newlyAddedLinks
			newlyAddedLinks.add(e);
			defUseCFG.addSymbolDefined(statementId, newDef.symbol);

			// Add def-links from AST nodes to symbols
			long nodeId = ((ReadWriteDbASTProvider) newDef.astProvider)
					.getNodeId();
			if (statementId != nodeId)
			{
				DefUseLink e2 = new DefUseLink(newDef.symbol, nodeId,
						newDef.isDef);
				newlyAddedLinks.add(e2);
				defUseCFG.addSymbolDefined(nodeId, newDef.symbol);
			}

		}
	}

	public void writeChangesToDatabase()
	{

		if (defUseCFG == null)
		{
			System.out.println("defUseCFG is null");
			return;
		}

		Neo4JDBInterface.startTransaction();
		for (DefUseLink link : newlyAddedLinks)
		{

			Long fromId = link.statement;
			Long toId = (Long) defUseCFG.getIdForSymbol(link.symbol);

			if (toId == null)
			{
				System.err
						.println("Warning: Trying to create DEF-link to unknown symbol: "
								+ link.symbol);
				break;
			}

			RelationshipType relType = DynamicRelationshipType
					.withName(EdgeTypes.DEF);
			Neo4JDBInterface.addRelationship(fromId, toId, relType, null);
		}
		Neo4JDBInterface.finishTransaction();
	}

}
