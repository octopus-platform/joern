package main.codeitems.expressions;

import java.util.LinkedList;
import java.util.List;

import tools.index.ParseTreeUtils;


import antlr.FineFunctionGrammarParser.Conditional_expressionContext;

public class AssignmentExpr extends ExpressionItem
{
	public List<Assignment> assignments = new LinkedList<Assignment>();

	public void addAssignment(Conditional_expressionContext lvalExpr,
			Conditional_expressionContext rvalExpr)
	{
		Assignment assignment = new Assignment();
		assignment.lval = ParseTreeUtils.childTokenString(lvalExpr);
		assignment.rval = ParseTreeUtils.childTokenString(rvalExpr);
		assignments.add(assignment);
	}
	
}
