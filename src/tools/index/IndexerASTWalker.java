package tools.index;

import astwalking.ASTWalker;

public abstract class IndexerASTWalker extends ASTWalker
{

	public abstract void setIndexerState(IndexerState aState);

}
