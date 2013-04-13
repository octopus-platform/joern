package output.cfg;

public class Edge {

	BasicBlock srcBlock;
	BasicBlock dstBlock;
	
	public Edge(BasicBlock src, BasicBlock dst)
	{
		srcBlock = src;
		dstBlock = dst;
	}

}
