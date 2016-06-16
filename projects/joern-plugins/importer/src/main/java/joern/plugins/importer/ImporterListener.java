package joern.plugins.importer;

import java.nio.file.Path;

import fileWalker.SourceFileListener;

public class ImporterListener extends SourceFileListener {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitFile(Path filename) {
		// TODO Auto-generated method stub
		System.out.println(filename);
	}

	@Override
	public void preVisitDirectory(Path dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postVisitDirectory(Path dir) {
		// TODO Auto-generated method stub

	}

}
