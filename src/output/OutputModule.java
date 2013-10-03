package output;

import java.nio.file.Path;

/**
 * Derive output modules for the indexer from this class
 **/

public abstract class OutputModule
{
	abstract public void initialize(String indexDirectory);
	abstract public void shutdown();
	
	abstract public void visitFile(Path filename);
	abstract public void preVisitDirectory(Path dir);
	abstract public void postVisitDirectory(Path dir);
	
}
