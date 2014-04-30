package cdg;

public class CDG {

    private DominatorTree<Object> dominatorTree;


    private CDG() {
    }


    public DominatorTree<Object> getDominatorTree() {
	return this.dominatorTree;
    }


    public static CDG newInstance(DominatorTree<Object> dominatorTree) {
	CDG cdg = new CDG();
	cdg.dominatorTree = dominatorTree;
	return cdg;
    }
}
