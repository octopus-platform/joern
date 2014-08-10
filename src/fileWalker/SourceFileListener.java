package fileWalker;

import java.nio.file.Path;

/**
 * Abstract base class for classes observing the SourceFileWalker.
 * */

public abstract class SourceFileListener
{
	abstract public void initialize();

	abstract public void shutdown();

	abstract public void visitFile(Path filename);

	abstract public void preVisitDirectory(Path dir);

	abstract public void postVisitDirectory(Path dir);

}
