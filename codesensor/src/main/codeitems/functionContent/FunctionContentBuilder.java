package main.codeitems.functionContent;

import java.util.Iterator;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import antlr.FunctionGrammarParser.Block_starterContext;
import antlr.FunctionGrammarParser.Closing_curlyContext;
import antlr.FunctionGrammarParser.Else_statementContext;
import antlr.FunctionGrammarParser.If_statementContext;
import antlr.FunctionGrammarParser.Opening_curlyContext;
import antlr.FunctionGrammarParser.StatementContext;
import antlr.FunctionGrammarParser.StatementsContext;

import main.codeitems.CodeItemBuilder;

public class FunctionContentBuilder extends CodeItemBuilder
{
	Stack<StatementItem> itemStack = new Stack<StatementItem>();
	CompoundItem rootItem;
	
	@Override
	public void createNew(ParserRuleContext ctx)
	{
		item = new CompoundItem();
		rootItem = (CompoundItem) item;
		itemStack.push(rootItem);
	}

	public void exitStatements(StatementsContext ctx)
	{
		if(itemStack.size() != 1)
			throw new RuntimeException("Broken stack while parsing");
	
		consolidateIfElse(rootItem);
	}
	
	public void enterStatement(StatementContext ctx)
	{
		StatementItem statementItem = new StatementItem();
		statementItem.initializeFromContext(ctx);
		itemStack.push(statementItem);
	}
	
	public void enterBlockStarter(Block_starterContext ctx)
	{
		itemStack.pop();
		BlockStarterItem starterItem = new BlockStarterItem();
		itemStack.push(starterItem);
	}

	public void enterIf(If_statementContext ctx)
	{
		itemStack.pop();
		IfItem ifItem = new IfItem();
		itemStack.push(ifItem);
	}
	
	public void enterElse(Else_statementContext ctx)
	{
		itemStack.pop();
		ElseItem elseItem = new ElseItem();
		itemStack.push(elseItem);
	}

	public void enterOpeningCurly(Opening_curlyContext ctx)
	{
		itemStack.pop();
		CompoundItem compoundItem = new CompoundItem();
		itemStack.push(compoundItem);
	}
	
	public void enterClosingCurly(Closing_curlyContext ctx)
	{
		itemStack.pop();
		CloseBlockItem closeBlock = new CloseBlockItem();
		itemStack.push(closeBlock);
	}

	public void exitStatement(StatementContext ctx)
	{
		if(itemStack.size() == 0)
			throw new RuntimeException();
	
		StatementItem itemToRemove = itemStack.peek();
		
		if(itemToRemove instanceof CloseBlockItem){
			closeCompoundStatement();
			return;
		}
		
		// We keep Block-starters and compound items
		// on the stack. They are removed by following
		// statements.
		if(itemToRemove instanceof BlockStarterItem ||
		   itemToRemove instanceof CompoundItem)
			return;
		
		consolidate();	
	}

	private void closeCompoundStatement()
	{
		// remove 'CloseBlock'
		itemStack.pop();
		
		CompoundItem compoundItem = (CompoundItem) itemStack.pop();
		consolidateIfElse(compoundItem);
		consolidateBlockStarters(compoundItem);		
	}
	
	private void consolidateIfElse(CompoundItem compoundItem)
	{
		Iterator<StatementItem> it = compoundItem.statements.iterator();
		StatementItem prev = null;
		while(it.hasNext()){
			StatementItem cur = it.next();
			if(prev != null && cur instanceof ElseItem){
				if(prev instanceof IfItem){
					IfItem ifItem = (IfItem) prev;
					ifItem.elseItem = (ElseItem) cur;
					it.remove();
				}
			}
			prev = cur;
		}
	}

	private void consolidateBlockStarters(StatementItem topOfStack)
	{
		while(true){
			try{
				BlockStarterItem bItem = (BlockStarterItem) itemStack.peek();
				bItem = (BlockStarterItem) itemStack.pop();
				bItem.setStatement(topOfStack);
				topOfStack = bItem;
			}catch(ClassCastException ex){
				break;
			}
		}
		CompoundItem root = (CompoundItem) itemStack.peek();
		root.addStatement(topOfStack);
	}
	
	private void consolidate()
	{
		// We know at this point, that the item
		// on the top of the stack is not a
		// compound statement and not a blockstarter
		
		StatementItem stmt = (StatementItem) itemStack.pop();
		StatementItem topOfStack = null;
		
		if(itemStack.size() > 0)
			topOfStack = (StatementItem) itemStack.peek();
		
		if(topOfStack instanceof CompoundItem){
			CompoundItem compound = (CompoundItem)topOfStack;
			compound.addStatement(stmt);
		}else{
			consolidateBlockStarters(topOfStack);
		}
		
	}

}