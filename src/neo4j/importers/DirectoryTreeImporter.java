package neo4j.importers;

import java.nio.file.Path;

import tools.index.IndexerState;

public abstract class DirectoryTreeImporter
{
	public abstract void setState(IndexerState state);

	public abstract void enterDir(Path dir);

	public abstract void exitDir(Path dir);

	public abstract void enterFile(Path pathToFile);

}
