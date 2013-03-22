package main;


import java.util.concurrent.ConcurrentLinkedQueue;
import main.CommandLine.CommandLineInterface;


public class CodeSensor {
	
	
	private static CommandLineInterface cmd = new CommandLineInterface();
	private static ConcurrentLinkedQueue<FileToParse> queue = new ConcurrentLinkedQueue<FileToParse>();
	private static String[] userSpecifiedFiles;
	
    public static void main(String[] args)
	{
    	cmd.parseCommandLine(args);
    	userSpecifiedFiles = cmd.getUserSpecifiedFiles();  	    	
    	
    	createProducerThread();
    	createConsumerThreads();
	}

	private static void createProducerThread()
	{
		// new Thread(new FilenameProducer(queue, userSpecifiedFiles)).start();
		new FilenameProducer(queue, userSpecifiedFiles).run();
	}

	private static void createConsumerThreads()
	{
		for(int i = 0; i < 2; i++)
			new Thread(new FilenameConsumer(queue)).start();
		// new FilenameConsumer(queue).run();
	}
	    
}
