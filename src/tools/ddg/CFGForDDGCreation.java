package tools.ddg;

import java.util.LinkedList;

import misc.MultiHashMap;

public class CFGForDDGCreation {

	LinkedList<Long> basicBlocks = new LinkedList<Long>();
	MultiHashMap symbolsUsed = new MultiHashMap();
	MultiHashMap symbolsDefined = new MultiHashMap();
	MultiHashMap parentBlocks = new MultiHashMap();
	MultiHashMap childBlocks = new MultiHashMap();
}
