package tools.index;

import java.nio.file.Path;

public abstract class DirectoryListener
{
	abstract public void visitFile(Path filename);
	abstract public void preVisitDirectory(Path dir);
	
}
