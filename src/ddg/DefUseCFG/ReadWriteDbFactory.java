package ddg.DefUseCFG;

import java.util.List;

import misc.Pair;
import neo4j.EdgeTypes;
import neo4j.readWriteDB.Neo4JDBInterface;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

import traversals.readWriteDB.Traversals;

public class ReadWriteDbFactory extends DefUseCFGFactory
{

	DefUseCFG cfg;

	@Override
	public DefUseCFG create(Long funcId)
	{
		cfg = new DefUseCFG();

		getStatementsOfFunction(funcId);
		getUsesAndDefs();
		getParentBlocks();
		getChildBlocks();

		return cfg;
	}

	private void getStatementsOfFunction(Long funcId)
	{
		String query = "isCFGNode:True AND functionId:" + funcId;
		IndexHits<Node> hits = Neo4JDBInterface.queryIndex(query);
		for (Node node : hits)
			cfg.addStatement(node.getId());
	}

	private void getUsesAndDefs()
	{
		for (Object obj : cfg.getStatements())
		{
			Long statementId = (Long) obj;

			List<Pair<Long, String>> used = Traversals
					.getSymbolsUsedByStatement(statementId);
			for (Pair<Long, String> symbolIdAndCode : used)
			{
				Long symbolId = symbolIdAndCode.getL();
				String symbolCode = symbolIdAndCode.getR();
				cfg.addSymbolUsed(statementId, symbolCode);
				cfg.setSetSymbolId(symbolCode, symbolId);
			}

			List<Pair<Long, String>> defined = Traversals
					.getSymbolsDefinedByStatement(statementId);
			for (Pair<Long, String> symbolIdAndCode : defined)
			{
				Long symbolId = symbolIdAndCode.getL();
				String symbolCode = symbolIdAndCode.getR();
				cfg.addSymbolDefined(statementId, symbolCode);
				cfg.setSetSymbolId(symbolCode, symbolId);
			}
		}
	}

	private void getParentBlocks()
	{
		for (Object obj : cfg.getStatements())
		{
			Long statementId = (Long) obj;

			Node statement = Neo4JDBInterface.getNodeById(statementId);
			Iterable<Relationship> rels = statement
					.getRelationships(Direction.INCOMING);
			for (Relationship rel : rels)
			{
				if (!rel.getType().toString().equals(EdgeTypes.FLOWS_TO))
					continue;
				long parentId = rel.getStartNode().getId();
				cfg.addParentBlock(statementId, parentId);
			}
		}
	}

	private void getChildBlocks()
	{
		for (Object obj : cfg.getStatements())
		{
			Long statementId = (Long) obj;

			Node statement = Neo4JDBInterface.getNodeById(statementId);
			Iterable<Relationship> rels = statement
					.getRelationships(Direction.OUTGOING);
			for (Relationship rel : rels)
			{
				if (!rel.getType().toString().equals(EdgeTypes.FLOWS_TO))
					continue;

				long childId = rel.getEndNode().getId();
				cfg.addChildBlock(statementId, childId);
			}
		}
	}

}
