package neo4j.importers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import neo4j.EdgeTypes;
import neo4j.batchInserter.GraphNodeStore;
import neo4j.batchInserter.Neo4JBatchInserter;
import neo4j.nodes.EmptyCFGDatabaseNode;
import neo4j.nodes.FunctionDatabaseNode;
import neo4j.nodes.NodeKeys;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.RelationshipType;

import astnodes.ASTNode;
import cfg.CFG;
import cfg.CFGEdge;
import cfg.CFGNode;
import cfg.Edges;

public class CFGImporter {

    GraphNodeStore nodeStore;
    private FunctionDatabaseNode currentFunction;


    public CFGImporter(GraphNodeStore aNodeStore) {
	nodeStore = aNodeStore;
    }


    public void setCurrentFunction(FunctionDatabaseNode func) {
	currentFunction = func;
    }


    public void addCFGToDatabase(CFG cfg) {
	if (cfg == null)
	    return;

	createEmptyCFGNodes(cfg);
	addCFGEdges(cfg);
    }


    private void createEmptyCFGNodes(CFG cfg) {
	// This deserves some explanation:
	// Our CFG creation code currently inserts empty-blocks
	// in some places, e.g., nodes that join prior control-flows.
	// These nodes do not have to exist in theory but as long
	// as we have them in our CFG, we need to create corresponding
	// database nodes when importing the CFG. All other CFG nodes
	// are nodes of the AST and hence are already in the database.

	Vector<CFGNode> statemens = cfg.getStatements();
	Iterator<CFGNode> it = statemens.iterator();
	while (it.hasNext()) {
	    CFGNode statement = it.next();

	    ASTNode astNode = statement.getASTNode();
	    if (astNode != null) {
		// nothing to do for nodes that have already
		// been imported by the ASTImporter.
		continue;
	    }

	    EmptyCFGDatabaseNode emptyDatabaseNode = new EmptyCFGDatabaseNode();
	    emptyDatabaseNode.initialize(null);
	    Map<String, Object> properties = emptyDatabaseNode.createProperties();
	    properties.put(NodeKeys.FUNCTION_ID, nodeStore.getIdForObject(currentFunction));
	    nodeStore.addNeo4jNode(statement, properties);
	    nodeStore.indexNode(statement, properties);
	}
    }


    private void addCFGEdges(CFG cfg) {

	// Edges edges = cfg.getEdges();
	// Iterator<Entry<Object, List<Object>>> it =
	// edges.getEntrySetIterator();
	// while(it.hasNext())
	// {
	// Entry<Object, List<Object>> entry = it.next();
	// Object sourceBlock = (CFGNode) entry.getKey();
	//
	// // draw link from AST node if possible. Otherwise, this
	// // is an empty block.
	// ASTNode astNode = ((CFGNode) sourceBlock).getASTNode();
	// if(astNode != null)
	// sourceBlock = astNode;
	//
	// List<Object> dstBlockList = entry.getValue();
	// for(Object dstBlock: dstBlockList){
	//
	// ASTNode dstASTNode = ((CFGNode) dstBlock).getASTNode();
	// if(dstASTNode != null)
	// addFlowToLink(sourceBlock, dstASTNode);
	// else
	// addFlowToLink(sourceBlock, dstBlock);
	// }
	// }
	Iterator<CFGEdge> iterator = cfg.edgeIterator();
	CFGEdge edge;
	CFGNode src;
	CFGNode dst;
	while (iterator.hasNext()) {
	    edge = iterator.next();
	    src = edge.getSource();
	    dst = edge.getDestination();

	    Object srcBlock = (src.astNode != null) ? src.astNode : src;
	    Object dstBlock = (dst.astNode != null) ? dst.astNode : dst;
	    addFlowToLink(srcBlock, dstBlock, edge.getProperties());

	}
    }


    private void addFlowToLink(Object srcBlock, Object dstBlock, Map<String, Object> properties) {
	long srcId = nodeStore.getIdForObject(srcBlock);
	long dstId = nodeStore.getIdForObject(dstBlock);

	RelationshipType rel = DynamicRelationshipType.withName(EdgeTypes.FLOWS_TO);
	// Map<String, Object> properties = null;
	Neo4JBatchInserter.addRelationship(srcId, dstId, rel, properties);
    }

}
