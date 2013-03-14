package main.CommandLine;

import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

class DirectoryWalker extends SimpleFileVisitor<Path>
{
	private final PathMatcher matcher;
    public List<String> filenames = new LinkedList<String>();
	
    DirectoryWalker(String pattern)
    {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }

    @Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
    {
        
    	if(!fileMatches(file)){
    		return FileVisitResult.CONTINUE;
    	}
    	
     	filenames.add(file.toString() );
        return FileVisitResult.CONTINUE;
    }

	private boolean fileMatches(Path file)
	{
		Path name = file.getFileName();
        if(name == null)
        	return false;
        return matcher.matches(name);
	}
    

}