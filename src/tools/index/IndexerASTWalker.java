package tools.index;

import astwalking.ASTWalker;

public abstract class IndexerASTWalker extends ASTWalker
{

	IndexerState state;

	public void setIndexerState(IndexerState aState)
	{
		state = aState;
	}
	
}
