package main;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;

public class CommonParser {

	protected static boolean isRecognitionException(RuntimeException ex)
	{
		return ex.getClass() == RuntimeException.class &&
				ex.getCause() instanceof RecognitionException;
	}

	protected static void setLLStarMode(Parser parser)
	{
		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
		parser.setErrorHandler(new DefaultErrorStrategy());
		parser.getInterpreter().setPredictionMode(PredictionMode.LL);
	}

	protected static void setSLLMode(Parser parser)
	{
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
	    parser.removeErrorListeners();
	    parser.setErrorHandler(new BailErrorStrategy());
	}

	public CommonParser() {
		super();
	}

}