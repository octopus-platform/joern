package output;

import java.util.Iterator;
import java.util.Stack;


import org.antlr.v4.runtime.ParserRuleContext;

import astnodes.ASTNode;
import astnodes.ASTNodeBuilder;
import astnodes.declarations.ClassDef;
import astnodes.declarations.IdentifierDecl;
import astnodes.functionDef.FunctionDef;
import astnodes.functionDef.Parameter;
import astnodes.statements.IdentifierDeclStatement;
import astwalking.ASTWalker;

public class CSVPrinter extends ASTWalker
{
    
    private final String SEPARATOR = "\t";
    
    @Override
    public void startOfUnit(ParserRuleContext ctx, String filename)
    {	
    	if(filename == null) return;
    	ASTNode item = new ASTNode();
    	item.setNodeTypeName("SOURCE_FILE");
    	item.setLocation(ctx);
    	item.setCodeStr(filename);	
    	defaultOut(item, 0);
    }
    
    @Override
    public void processItem(ASTNode item, Stack<ASTNodeBuilder> itemStack)
    {
    	
    	switch(item.getNodeTypeName()){
    	case "FUNCTION_DEF":
    		outputFunctionDef(item, itemStack);
    		break;
    	case "CLASS_DEF":
    		outputClassDef(item, itemStack);
    		break;
    	case "DECL":
    		outputDecl(item, itemStack);
    		break;
    	default:
    			defaultOut(item, itemStack.size());
    			break;
    	}
    }


	private void outputFunctionDef(ASTNode aItem, Stack<ASTNodeBuilder> itemStack)
    {
    	int level = itemStack.size();
		FunctionDef item = (FunctionDef) aItem;
    	defaultOut(item, level);
    	defaultOut(item.returnType, level + 1);
    	defaultOut(item.name, level + 1);
    	if(item.parameterList != null){
    		defaultOut(item.parameterList, level + 1);
    		Iterator<Parameter> i = item.parameterList.getParameters().iterator();
    		for(; i.hasNext();){
    			Parameter p = i.next();
    			defaultOut(p, level+2);
    			defaultOut(p.type, level+2);
    			defaultOut(p.name, level+2);
    		}
    	}
    }

    private void outputClassDef(ASTNode aItem, Stack<ASTNodeBuilder> itemStack)
    {
    	int level = itemStack.size();
    	ClassDef item = (ClassDef) aItem;
    	
    	if(item.name != null){
    		item.setCodeStr(item.name.getCodeStr());
    		defaultOut(item, level);
    		defaultOut(item.name, level + 1);
    	}else{
    		item.setCodeStr("[unnamed]");
    		defaultOut(item, level);
    	}
    }

    private void outputDecl(ASTNode aItem, Stack<ASTNodeBuilder> itemStack)
	{
    	IdentifierDeclStatement stmt = (IdentifierDeclStatement) aItem;
    	
    	Iterator<ASTNode> it = stmt.getIdentifierDeclList().iterator();
    	while(it.hasNext()){
    		IdentifierDecl item = (IdentifierDecl) it.next();
    		int level = itemStack.size();
        	
        	item.setCodeStr(item.name.getCodeStr());
        	if(item.type.completeType != "")
        		item.setCodeStr(item.type.completeType + " " + item.name.getCodeStr());
        	defaultOut(item, level);
    	}
	}
    
    private void defaultOut(ASTNode item, int level)
    {    	
    	if(item == null) return;
    	
    	String output = item.getNodeTypeName() + SEPARATOR;
    	output += item.getLocationString() + SEPARATOR + level;
    	String codeStr = item.getCodeStr();
    	if(codeStr != null)
    		output += SEPARATOR + escapeCodeStr(codeStr);
    	else
    		output += SEPARATOR + "";
    	System.out.println(output);
    }
      
    private String escapeCodeStr(String codeStr)
    {
    	String retval = codeStr;
    	retval = retval.replace("\n", "\\n");
    	retval = retval.replace("\t", "\\t");
    	return retval;
    }

	@Override
	public void endOfUnit(ParserRuleContext ctx, String filename)
	{
		
	}

	@Override
	public void begin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
    
}
