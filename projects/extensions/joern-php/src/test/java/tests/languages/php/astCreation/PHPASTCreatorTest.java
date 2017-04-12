package tests.languages.php.astCreation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ast.ASTNode;
import ast.expressions.ArgumentList;
import ast.expressions.ArrayIndexing;
import ast.expressions.AssignmentExpression;
import ast.expressions.AssignmentWithOpExpression;
import ast.expressions.BinaryOperationExpression;
import ast.expressions.CallExpressionBase;
import ast.expressions.CastExpression;
import ast.expressions.ClassConstantExpression;
import ast.expressions.ConditionalExpression;
import ast.expressions.Constant;
import ast.expressions.DoubleExpression;
import ast.expressions.Expression;
import ast.expressions.ExpressionList;
import ast.expressions.Identifier;
import ast.expressions.IdentifierList;
import ast.expressions.InstanceofExpression;
import ast.expressions.IntegerExpression;
import ast.expressions.NewExpression;
import ast.expressions.PostDecOperationExpression;
import ast.expressions.PostIncOperationExpression;
import ast.expressions.PreDecOperationExpression;
import ast.expressions.PreIncOperationExpression;
import ast.expressions.PropertyExpression;
import ast.expressions.StaticPropertyExpression;
import ast.expressions.StringExpression;
import ast.expressions.UnaryOperationExpression;
import ast.expressions.Variable;
import ast.functionDef.ParameterBase;
import ast.functionDef.ParameterList;
import ast.logical.statements.CompoundStatement;
import ast.logical.statements.Label;
import ast.php.declarations.ClassDef;
import ast.php.expressions.ClassExpression;
import ast.php.expressions.ClosureExpression;
import ast.php.expressions.MethodCallExpression;
import ast.php.expressions.ArrayElement;
import ast.php.expressions.ArrayExpression;
import ast.php.expressions.AssignmentByRefExpression;
import ast.php.expressions.CloneExpression;
import ast.php.expressions.CoalesceExpression;
import ast.php.expressions.EmptyExpression;
import ast.php.expressions.EncapsListExpression;
import ast.php.expressions.ExitExpression;
import ast.php.expressions.IncludeOrEvalExpression;
import ast.php.expressions.IssetExpression;
import ast.php.expressions.ListExpression;
import ast.php.expressions.MagicConstant;
import ast.php.expressions.PrintExpression;
import ast.php.expressions.ReferenceExpression;
import ast.php.expressions.ShellExecExpression;
import ast.php.expressions.TypeHint;
import ast.php.expressions.UnpackExpression;
import ast.php.expressions.YieldExpression;
import ast.php.expressions.YieldFromExpression;
import ast.php.expressions.StaticCallExpression;
import ast.php.functionDef.Closure;
import ast.php.functionDef.ClosureUses;
import ast.php.functionDef.ClosureVar;
import ast.php.functionDef.Method;
import ast.php.functionDef.FunctionDef;
import ast.php.functionDef.Parameter;
import ast.php.functionDef.TopLevelFunctionDef;
import ast.php.statements.ClassConstantDeclaration;
import ast.php.statements.ConstantDeclaration;
import ast.php.statements.ConstantElement;
import ast.php.statements.EchoStatement;
import ast.php.statements.GlobalStatement;
import ast.php.statements.GroupUseStatement;
import ast.php.statements.HaltCompilerStatement;
import ast.php.statements.UnsetStatement;
import ast.php.statements.PropertyDeclaration;
import ast.php.statements.PropertyElement;
import ast.php.statements.StaticVariableDeclaration;
import ast.php.statements.blockstarters.DeclareStatement;
import ast.php.statements.blockstarters.IfElement;
import ast.php.statements.blockstarters.IfStatement;
import ast.php.statements.blockstarters.SwitchCase;
import ast.php.statements.blockstarters.SwitchList;
import ast.php.statements.blockstarters.SwitchStatementPHP;
import ast.php.statements.blockstarters.TraitAdaptationElement;
import ast.php.statements.blockstarters.TraitAdaptations;
import ast.php.statements.blockstarters.TraitAlias;
import ast.php.statements.blockstarters.TraitPrecedence;
import ast.php.statements.blockstarters.UseTrait;
import ast.statements.ExpressionStatement;
import ast.statements.UseElement;
import ast.statements.UseStatement;
import ast.statements.blockstarters.CatchList;
import ast.statements.blockstarters.CatchStatement;
import ast.statements.blockstarters.DoStatement;
import ast.statements.blockstarters.ForEachStatement;
import ast.statements.blockstarters.ForStatement;
import ast.statements.blockstarters.MethodReference;
import ast.statements.blockstarters.NamespaceStatement;
import ast.statements.blockstarters.TryStatement;
import ast.statements.blockstarters.WhileStatement;
import ast.statements.jump.BreakStatement;
import ast.statements.jump.ContinueStatement;
import ast.statements.jump.GotoStatement;
import ast.statements.jump.ReturnStatement;
import ast.statements.jump.ThrowStatement;
import inputModules.csv.PHPCSVNodeTypes;
import inputModules.csv.KeyedCSV.exceptions.InvalidCSVFile;
import tests.languages.php.PHPCSVBasedTest;

public class PHPASTCreatorTest extends PHPCSVBasedTest
{
	// set sample directory
	@Before
	public void setSampleDir() {
		super.setSampleDir( "astCreation");
	}
	
	// primary expressions (leafs)

	/**
	 * "integer", "double" or "string" nodes are nodes holding primary expressions such
	 * as an integer, a floating point number or a string enclosed in single or double quotes.
	 *
	 * These nodes have no children. Their concrete value is specified as the 'code' property.
	 *
	 * This test checks a few primary expressions in the following PHP code:
	 *
	 * 42;
	 * 3.14;
	 * "Hello World!";
	 */
	@Test
	public void testPrimaryExpressionCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPrimaryExpression");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)8);

		assertThat( node, instanceOf(IntegerExpression.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( "42", ((IntegerExpression)node).getEscapedCodeStr());

		assertThat( node2, instanceOf(DoubleExpression.class));
		assertEquals( 0, node2.getChildCount());
		assertEquals( "3.14", ((DoubleExpression)node2).getEscapedCodeStr());

		assertThat( node3, instanceOf(StringExpression.class));
		assertEquals( 0, node3.getChildCount());
		assertEquals( "Hello World!", ((StringExpression)node3).getEscapedCodeStr());
	}


	/* special nodes */

	/**
	 * AST_NAME nodes are used to identify certain names in PHP code,
	 * such as for example the name of a class that a class declaration extends,
	 * the name of an interface that a class declaration implements,
	 * or the name of a type returned by a function.
	 * Other examples include names of called functions/methods, class
	 * names associated with 'new' or 'instanceof' operators, etc.
	 *
	 * Any AST_NAME node has exactly one child which is of type "string".
	 *
	 * This test checks the names 'bar' and 'buz' in the following PHP code:
	 *
	 * class foo extends bar implements buz {}
	 */
	@Test
	public void testNameCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClass");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(Identifier.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((Identifier)node).getNameChild());
		assertEquals( "bar", ((Identifier)node).getNameChild().getEscapedCodeStr());

		assertThat( node2, instanceOf(Identifier.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((Identifier)node2).getNameChild());
		assertEquals( "buz", ((Identifier)node2).getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_CLOSURE_VAR nodes are special nodes holding variables that
	 * occur within the 'use' language construct of closure declarations.
	 *
	 * Any AST_CLOSURE_VAR node has exactly one child which is of type "string".
	 *
	 * This test checks the names 'foo' and 'bar' in the following PHP code:
	 *
	 * function() use ($foo,$bar) {};
	 */
	@Test
	public void testClosureVarCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClosureVar");

		ASTNode node = ast.getNodeById((long)11);
		ASTNode node2 = ast.getNodeById((long)13);

		assertThat( node, instanceOf(ClosureVar.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((ClosureVar)node).getNameChild());
		assertEquals( "foo", ((ClosureVar)node).getNameChild().getEscapedCodeStr());

		assertThat( node2, instanceOf(ClosureVar.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((ClosureVar)node2).getNameChild());
		assertEquals( "bar", ((ClosureVar)node2).getNameChild().getEscapedCodeStr());
	}


	/* declaration nodes */

	/**
	 * AST_TOPLEVEL nodes are artificial function-declaring nodes for
	 * the top-level context of files and classes. We give such nodes the
	 * name "<path/to/file>" under file nodes, and "[classname]" under class nodes.
	 *
	 * Any AST_TOPLEVEL node has exactly one child which is of type AST_STMT_LIST.
	 *
	 * This test checks the name '<foo.php>' of the toplevel node of a file foo.php
	 * and the name '[bar]' of a class bar in the following PHP code:
	 *
	 * class bar {}
	 */
	@Test
	public void testTopLevelFuncCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testTopLevelFunc");

		ASTNode node = ast.getNodeById((long)2);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(TopLevelFunctionDef.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( "<./foo.php>", ((TopLevelFunctionDef)node).getName());
		assertEquals( ast.getNodeById((long)5), ((TopLevelFunctionDef)node).getContent());

		assertThat( node2, instanceOf(TopLevelFunctionDef.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( "[bar]", ((TopLevelFunctionDef)node2).getName());
		assertEquals( ast.getNodeById((long)12), ((TopLevelFunctionDef)node2).getContent());
	}

	/**
	 * AST_FUNC_DECL nodes are function-declaring nodes for top-level functions
	 * (as opposed to methods declared within a class scope.)
	 *
	 * Any AST_FUNC_DECL node has exactly four children:
	 * 1) AST_PARAM_LIST
	 * 2) NULL, for structural compatibility with AST_CLOSURE
	 * 3) AST_STMT_LIST
	 * 4) AST_NAME or NULL, indicating the return type
	 *
	 * This test checks a function's name and children in the following PHP code:
	 *
	 * function foo() : int {}
	 */
	@Test
	public void testFunctionDefCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testFunctionDef");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(FunctionDef.class));
		// repeat this three times... in the past, there was a bug that caused the
		// function name to change across several invocations of getName()
		assertEquals( "foo", ((FunctionDef)node).getName());
		assertEquals( "foo", ((FunctionDef)node).getName());
		assertEquals( "foo", ((FunctionDef)node).getName());
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((FunctionDef)node).getParameterList());
		assertEquals( ast.getNodeById((long)11), ((FunctionDef)node).getContent());
		assertEquals( ast.getNodeById((long)12), ((FunctionDef)node).getReturnType());
		assertEquals( ast.getNodeById((long)13), ((FunctionDef)node).getReturnType().getNameChild());
		assertEquals( "int", ((FunctionDef)node).getReturnType().getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_CLOSURE nodes are function-declaring nodes for closures (anonymous functions).
	 * We always give them the artificial name "{closure}".
	 *
	 * Any AST_CLOSURE node has exactly four children:
	 * 1) AST_PARAM_LIST
	 * 2) AST_CLOSURE_USES or NULL
	 * 3) AST_STMT_LIST
	 * 4) AST_NAME or NULL, indicating the return type
	 *
	 * This test checks a closure's pseudo-name and children in the following PHP code:
	 *
	 * $a = function() use ($foo) : int {};
	 *
	 * It also checks that a ClosureExpression holding the Closure is created.
	 */
	@Test
	public void testClosureCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClosure");

		ASTNode node = ast.getNodeById((long)9);

		assertThat( node, instanceOf(Closure.class));
		assertEquals( "{closure}", ((Closure)node).getName());
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((Closure)node).getParameterList());
		assertEquals( ast.getNodeById((long)13), ((Closure)node).getClosureUses());
		assertEquals( ast.getNodeById((long)16), ((Closure)node).getContent());
		assertEquals( ast.getNodeById((long)17), ((Closure)node).getReturnType());
		assertEquals( ast.getNodeById((long)18), ((Closure)node).getReturnType().getNameChild());
		assertEquals( "int", ((Closure)node).getReturnType().getNameChild().getEscapedCodeStr());

		// special test for the artificial ClosureExpression node:
		
		ASTNode node2 = ast.getNodeById((long)6);
		assertThat( node2, instanceOf(AssignmentExpression.class));
		
		ASTNode node3 = ((AssignmentExpression)node2).getRight();
		assertThat( node3, instanceOf(ClosureExpression.class));
		assertEquals( node, ((ClosureExpression)node3).getClosure());
		// the closure wrapper should have the same node id as the closure itself
		assertEquals( node.getNodeId(), node3.getNodeId());
	}

	/**
	 * AST_METHOD nodes are function-declaring nodes for class-level functions
	 * (as opposed to functions declared within a top-level scope.)
	 *
	 * Any AST_METHOD node has exactly four children:
	 * 1) AST_PARAM_LIST
	 * 2) NULL, for structural compatibility with AST_CLOSURE
	 * 3) AST_STMT_LIST or NULL (possible for abstract methods)
	 * 4) AST_NAME or NULL, indicating the return type
	 *
	 * This test checks a method's name and children in the following PHP code:
	 *
	 * class bar {
	 *   function foo() : int {}
	 * }
	 */
	@Test
	public void testMethodCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMethod");

		ASTNode node = ast.getNodeById((long)13);

		assertThat( node, instanceOf(Method.class));
		assertEquals( "foo", ((Method)node).getName());
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((Method)node).getParameterList());
		assertEquals( ast.getNodeById((long)18), ((Method)node).getContent());
		assertEquals( ast.getNodeById((long)19), ((Method)node).getReturnType());
		assertEquals( ast.getNodeById((long)20), ((Method)node).getReturnType().getNameChild());
		assertEquals( "int", ((Method)node).getReturnType().getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_CLASS nodes are used to declare classes.
	 *
	 * Any AST_CLASS node has exactly three children:
	 * 1) AST_NAME or NULL, indicating the parent class
	 * 2) AST_NAME_LIST or NULL, indicating the implemented interfaces
	 * 3) AST_TOPLEVEL, this class's top-level method
	 *
	 * This test checks a class's name and its children in the following PHP code:
	 *
	 * class foo extends bar implements buz {}
	 */
	@Test
	public void testClassCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClass");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ClassDef.class));
		assertEquals( "foo", ((ClassDef)node).getName());
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ClassDef)node).getExtends());
		assertEquals( ast.getNodeById((long)8), ((ClassDef)node).getExtends().getNameChild());
		assertEquals( "bar", ((ClassDef)node).getExtends().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((ClassDef)node).getImplements());
		assertEquals( ast.getNodeById((long)10), ((ClassDef)node).getImplements().getIdentifier(0));
		assertEquals( ast.getNodeById((long)11), ((ClassDef)node).getImplements().getIdentifier(0).getNameChild());
		assertEquals( "buz", ((ClassDef)node).getImplements().getIdentifier(0).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)12), ((ClassDef)node).getTopLevelFunc());
		assertEquals( "[foo]", ((ClassDef)node).getTopLevelFunc().getName());
		assertEquals( ast.getNodeById((long)15), ((ClassDef)node).getTopLevelFunc().getContent());
	}


	/* nodes without children (leafs) */

	/**
	 * AST_MAGIC_CONST nodes are nodes holding magic constant names.
	 *
	 * AST_MAGIC_CONST nodes have no children. They do however have a flag to distinguish
	 * which magic constant is used.
	 * The following flags exist:
	 * - FLAG_MAGIC_LINE
	 * - FLAG_MAGIC_FILE
	 * - FLAG_MAGIC_DIR
	 * - FLAG_MAGIC_NAMESPACE
	 * - FLAG_MAGIC_FUNCTION
	 * - FLAG_MAGIC_METHOD
	 * - FLAG_MAGIC_CLASS
	 * - FLAG_MAGIC_TRAIT
	 * See http://php.net/manual/en/language.constants.predefined.php
	 *
	 * This test checks a few magic constant expressions in the following PHP code:
	 *
	 * __LINE__;
	 * __FILE__;
	 * __DIR__;
	 * __NAMESPACE__;
	 * __FUNCTION__;
	 * __METHOD__;
	 * __CLASS__;
	 * __TRAIT__;
	 */
	@Test
	public void testMagicConstantCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMagicConstant");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)7);
		ASTNode node3 = ast.getNodeById((long)8);
		ASTNode node4 = ast.getNodeById((long)9);
		ASTNode node5 = ast.getNodeById((long)10);
		ASTNode node6 = ast.getNodeById((long)11);
		ASTNode node7 = ast.getNodeById((long)12);
		ASTNode node8 = ast.getNodeById((long)13);

		assertThat( node, instanceOf(MagicConstant.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_LINE, ((MagicConstant)node).getFlags());

		assertThat( node2, instanceOf(MagicConstant.class));
		assertEquals( 0, node2.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_FILE, ((MagicConstant)node2).getFlags());

		assertThat( node3, instanceOf(MagicConstant.class));
		assertEquals( 0, node3.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_DIR, ((MagicConstant)node3).getFlags());

		assertThat( node4, instanceOf(MagicConstant.class));
		assertEquals( 0, node4.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_NAMESPACE, ((MagicConstant)node4).getFlags());

		assertThat( node5, instanceOf(MagicConstant.class));
		assertEquals( 0, node5.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_FUNCTION, ((MagicConstant)node5).getFlags());

		assertThat( node6, instanceOf(MagicConstant.class));
		assertEquals( 0, node6.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_METHOD, ((MagicConstant)node6).getFlags());

		assertThat( node7, instanceOf(MagicConstant.class));
		assertEquals( 0, node7.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_CLASS, ((MagicConstant)node7).getFlags());

		assertThat( node8, instanceOf(MagicConstant.class));
		assertEquals( 0, node8.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_MAGIC_TRAIT, ((MagicConstant)node8).getFlags());
	}

	/**
	 * AST_TYPE nodes are nodes holding the PHP type hints 'array' and 'callable'.
	 *
	 * AST_TYPE nodes have no children. They do however have a flag to distinguish
	 * which type hint is used.
	 * The following flags exist:
	 * - TYPE_ARRAY
	 * - TYPE_CALLABLE
	 * TODO it is not yet completely clear to me why 'array' and 'callable' produce
	 * a special AST_TYPE node, while other types, such as 'int', 'bool', 'double' or 'string'
	 * produce a normal AST_NAME node. Should these built-in types not all consistently map
	 * to a AST_TYPE node? AST_NAME is mostly useful for "self-defined" types (i.e., class names)
	 *
	 * This test checks a few type hint expressions in the following PHP code:
	 *
	 * function foo( array $bar, callable $buz) : callable {}
	 */
	@Test
	public void testTypeHintCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testTypeHint");

		ASTNode node = ast.getNodeById((long)11);
		ASTNode node2 = ast.getNodeById((long)15);
		ASTNode node3 = ast.getNodeById((long)20);

		assertThat( node, instanceOf(TypeHint.class));
		assertEquals( 0, node.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_ARRAY, ((TypeHint)node).getFlags());

		assertThat( node2, instanceOf(TypeHint.class));
		assertEquals( 0, node2.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_CALLABLE, ((TypeHint)node2).getFlags());

		assertThat( node3, instanceOf(TypeHint.class));
		assertEquals( 0, node3.getChildCount());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_CALLABLE, ((TypeHint)node3).getFlags());
	}


	/* nodes with exactly 1 child */

	/**
	 * AST_VAR nodes are nodes holding variables names.
	 *
	 * Any AST_VAR node has exactly one child which is an expression, whose evaluation holds
	 * the variable's name (typically it is a string, but it may be another AST_VAR, for instance.)
	 *
	 * This test checks the names 'foo' and 'bar' in the following PHP code:
	 *
	 * $foo;
	 * $$bar;
	 */
	@Test
	public void testVariableCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testVariable");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)8);
		ASTNode node3 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(Variable.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((Variable)node).getNameExpression());
		assertEquals( "foo", ((Variable)node).getNameExpression().getEscapedCodeStr());

		assertThat( node2, instanceOf(Variable.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((Variable)node2).getNameExpression());

		assertThat( node3, instanceOf(Variable.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((Variable)node3).getNameExpression());
		assertEquals( "bar", ((Variable)node3).getNameExpression().getEscapedCodeStr());
	}

	/**
	 * AST_CONST nodes are nodes holding constant names.
	 *
	 * Any AST_CONST node has exactly one child which is of type Identifier, holding
	 * the constant's name (note that, as opposed to a Variable, a Constant may be
	 * namespaced.)
	 *
	 * This test checks a few constant expressions' children in the following PHP code:
	 *
	 * FOO;
	 * \BAR\BUZ;
	 */
	@Test
	public void testConstantCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testConstant");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(Constant.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((Constant)node).getIdentifier());
		assertEquals( "FOO", ((Constant)node).getIdentifier().getNameChild().getEscapedCodeStr());

		assertThat( node2, instanceOf(Constant.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((Constant)node2).getIdentifier());
		assertEquals( "BAR\\BUZ", ((Constant)node2).getIdentifier().getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_UNPACK nodes are used to represent "unpack" operations which unpack traversable
	 * objects or arrays into argument lists, also known as the "splat" operator (mostly useful
	 * in combination with variadic functions).
	 * See https://wiki.php.net/rfc/argument_unpacking
	 *
	 * Any AST_UNPACK node has exactly one child which is an expression whose evaluation yields
	 * a traversable object or array to be unpacked.
	 *
	 * This test checks a few unpack expressions' children in the following PHP code:
	 *
	 * foo( ...$traversable);
	 * foo( ...[4,2]);
	 */
	@Test
	public void testUnpackCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUnpack");

		ASTNode node = ast.getNodeById((long)10);
		ASTNode node2 = ast.getNodeById((long)17);

		assertThat( node, instanceOf(UnpackExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((UnpackExpression)node).getExpression());

		assertThat( node2, instanceOf(UnpackExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)18), ((UnpackExpression)node2).getExpression());
	}

	/**
	 * AST_CAST nodes are used to denote cast expressions.
	 *
	 * Any AST_CAST node has exactly exactly one child, representing the expression whose evaluation
	 * is going to be cast to a given type.
	 * Note that there is no distinguished child for the type that the expression is being cast to.
	 * Rather, the type of cast is determined by a flag. The following flags exist:
	 * - FLAG_TYPE_NULL
	 * - FLAG_TYPE_BOOL
	 * - FLAG_TYPE_LONG
	 * - FLAG_TYPE_DOUBLE
	 * - FLAG_TYPE_STRING
	 * - FLAG_TYPE_ARRAY
	 * - FLAG_TYPE_OBJECT
	 * Also see http://php.net/manual/en/language.types.type-juggling.php#language.types.typecasting
	 * for the different type casts that exist in PHP.
	 *
	 * This test checks a few cast expressions' children in the following PHP code:
	 *
	 * // NULL
	 * (unset)$n;
	 * // bool
	 * (bool)0;
	 * (boolean)1;
	 * // long
	 * (int)2;
	 * (integer)3;
	 * // double
	 * (float)3.14;
	 * (double)4.2;
	 * (real)6.6;
	 * // string
	 * (string)"hello";
	 * // array
	 * (array)$a;
	 * // object
	 * (object)$o;
	 */
	@Test
	public void testCastCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testCast");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);
		ASTNode node3 = ast.getNodeById((long)11);
		ASTNode node4 = ast.getNodeById((long)13);
		ASTNode node5 = ast.getNodeById((long)15);
		ASTNode node6 = ast.getNodeById((long)17);
		ASTNode node7 = ast.getNodeById((long)19);
		ASTNode node8 = ast.getNodeById((long)21);
		ASTNode node9 = ast.getNodeById((long)23);
		ASTNode node10 = ast.getNodeById((long)25);
		ASTNode node11 = ast.getNodeById((long)28);

		assertThat( node, instanceOf(CastExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((CastExpression)node).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_NULL, ((CastExpression)node).getFlags());

		assertThat( node2, instanceOf(CastExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((CastExpression)node2).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_BOOL, ((CastExpression)node2).getFlags());

		assertThat( node3, instanceOf(CastExpression.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((CastExpression)node3).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_BOOL, ((CastExpression)node3).getFlags());

		assertThat( node4, instanceOf(CastExpression.class));
		assertEquals( 1, node4.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((CastExpression)node4).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_LONG, ((CastExpression)node4).getFlags());

		assertThat( node5, instanceOf(CastExpression.class));
		assertEquals( 1, node5.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((CastExpression)node5).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_LONG, ((CastExpression)node5).getFlags());

		assertThat( node6, instanceOf(CastExpression.class));
		assertEquals( 1, node6.getChildCount());
		assertEquals( ast.getNodeById((long)18), ((CastExpression)node6).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_DOUBLE, ((CastExpression)node6).getFlags());

		assertThat( node7, instanceOf(CastExpression.class));
		assertEquals( 1, node7.getChildCount());
		assertEquals( ast.getNodeById((long)20), ((CastExpression)node7).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_DOUBLE, ((CastExpression)node7).getFlags());

		assertThat( node8, instanceOf(CastExpression.class));
		assertEquals( 1, node8.getChildCount());
		assertEquals( ast.getNodeById((long)22), ((CastExpression)node8).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_DOUBLE, ((CastExpression)node8).getFlags());

		assertThat( node9, instanceOf(CastExpression.class));
		assertEquals( 1, node9.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((CastExpression)node9).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_STRING, ((CastExpression)node9).getFlags());

		assertThat( node10, instanceOf(CastExpression.class));
		assertEquals( 1, node10.getChildCount());
		assertEquals( ast.getNodeById((long)26), ((CastExpression)node10).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_ARRAY, ((CastExpression)node10).getFlags());

		assertThat( node11, instanceOf(CastExpression.class));
		assertEquals( 1, node11.getChildCount());
		assertEquals( ast.getNodeById((long)29), ((CastExpression)node11).getCastExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_TYPE_OBJECT, ((CastExpression)node11).getFlags());
	}

	/**
	 * AST_EMPTY nodes are used to denote 'empty' operation expressions.
	 *
	 * Any AST_EMPTY node has exactly exactly one child, representing the expression for which
	 * the operation is to be performed.
	 *
	 * This test checks a few 'empty' operation expressions' children in the following PHP code:
	 *
	 * empty($foo);
	 * empty(bar());
	 */
	@Test
	public void testEmptyCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testEmpty");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(EmptyExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((EmptyExpression)node).getExpression());

		assertThat( node2, instanceOf(EmptyExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((EmptyExpression)node2).getExpression());
	}

	/**
	 * AST_ISSET nodes are used to denote 'isset' operation expressions.
	 *
	 * Any AST_ISSET node has exactly exactly one child, representing the variable for which
	 * the operation is to be performed.
	 *
	 * This test checks a few 'isset' operation expressions' children in the following PHP code:
	 *
	 * isset($foo);
	 * isset($bar->buz);
	 */
	@Test
	public void testIssetCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testIsset");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(IssetExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((IssetExpression)node).getVariableExpression());

		assertThat( node2, instanceOf(IssetExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((IssetExpression)node2).getVariableExpression());
	}

	/**
	 * AST_SHELL_EXEC nodes are used to denote shell command execution expressions.
	 *
	 * Any AST_SHELL_EXEC node has exactly exactly one child, representing the command that is
	 * going to be be executed by the shell. This is typically a string, but could be an AST_ENCAPS_LIST
	 * to include variables, for example.
	 * See http://php.net/manual/en/language.operators.execution.php
	 *
	 * This test checks a few shell command execution expressions' children in the following PHP code:
	 *
	 * $output = `cat /var/www/html/.htpasswd`;
	 * $output2 = `$attackerinput`;
	 */
	@Test
	public void testShellExecCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testShellExec");

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(ShellExecExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((ShellExecExpression)node).getShellCommand());

		assertThat( node2, instanceOf(ShellExecExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((ShellExecExpression)node2).getShellCommand());
	}

	/**
	 * AST_CLONE nodes are used to denote 'clone' expressions.
	 *
	 * Any AST_CLONE node has exactly exactly one child, representing the expression whose
	 * evaluation yields the object to be cloned.
	 *
	 * This test checks a few 'clone' expressions' children in the following PHP code:
	 *
	 * clone($foo);
	 * clone(bar());
	 */
	@Test
	public void testCloneCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClone");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(CloneExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((CloneExpression)node).getExpression());

		assertThat( node2, instanceOf(CloneExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((CloneExpression)node2).getExpression());
	}

	/**
	 * AST_EXIT nodes are used to denote 'exit' expressions.
	 *
	 * Any AST_EXIT node has exactly exactly one child, representing the expression whose
	 * evaluation yields either a string to be printed before exiting or an integer which
	 * will be used as an exit status. The child may also be a NULL node, if no exit status
	 * is passed as argument.
	 * See http://php.net/manual/en/function.exit.php
	 *
	 * This test checks a few 'exit' expressions' children in the following PHP code:
	 *
	 * exit($foo);
	 * exit(bar());
	 */
	@Test
	public void testExitCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testExit");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(ExitExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ExitExpression)node).getExpression());

		assertThat( node2, instanceOf(ExitExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((ExitExpression)node2).getExpression());
	}

	/**
	 * AST_PRINT nodes are used to denote 'print' expressions.
	 *
	 * Any AST_PRINT node has exactly exactly one child, representing the expression whose
	 * evaluation yields a string to be printed.
	 * See http://php.net/manual/en/function.print.php
	 *
	 * This test checks a few 'print' expressions' children in the following PHP code:
	 *
	 * print($foo);
	 * print(bar());
	 */
	@Test
	public void testPrintCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPrint");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);

		assertThat( node, instanceOf(PrintExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PrintExpression)node).getExpression());

		assertThat( node2, instanceOf(PrintExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((PrintExpression)node2).getExpression());
	}

	/**
	 * AST_INCLUDE_OR_EVAL nodes are used to denote include/require/eval expressions.
	 *
	 * Any AST_INCLUDE_OR_EVAL node has exactly exactly one child, representing the expression that is
	 * going to be be included as a file or executed by the PHP interpreter in the current program scope.
	 * This is typically a string, but could be an AST_ENCAPS_LIST
	 * to include variables, for example.
	 * See:
	 * - http://php.net/manual/en/function.include.php
	 * - http://php.net/manual/en/function.include-once.php
	 * - http://php.net/manual/en/function.require.php
	 * - http://php.net/manual/en/function.require-once.php
	 * - http://php.net/manual/en/function.eval.php
	 *
	 * This test checks a few include/require/eval expressions' children in the following PHP code:
	 *
	 * include 'foo.php';
	 * include_once $userinput;
	 * require getuserinput();
	 * require_once "http://".$userinput."bar.php";
	 * eval("{$evilinput}");
	 */
	@Test
	public void testIncludeOrEvalCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testIncludeOrEval");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)8);
		ASTNode node3 = ast.getNodeById((long)11);
		ASTNode node4 = ast.getNodeById((long)16);
		ASTNode node5 = ast.getNodeById((long)23);

		assertThat( node, instanceOf(IncludeOrEvalExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((IncludeOrEvalExpression)node).getIncludeOrEvalExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_EXEC_INCLUDE, ((IncludeOrEvalExpression)node).getFlags());

		assertThat( node2, instanceOf(IncludeOrEvalExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((IncludeOrEvalExpression)node2).getIncludeOrEvalExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_EXEC_INCLUDE_ONCE, ((IncludeOrEvalExpression)node2).getFlags());

		assertThat( node3, instanceOf(IncludeOrEvalExpression.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((IncludeOrEvalExpression)node3).getIncludeOrEvalExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_EXEC_REQUIRE, ((IncludeOrEvalExpression)node3).getFlags());

		assertThat( node4, instanceOf(IncludeOrEvalExpression.class));
		assertEquals( 1, node4.getChildCount());
		assertEquals( ast.getNodeById((long)17), ((IncludeOrEvalExpression)node4).getIncludeOrEvalExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_EXEC_REQUIRE_ONCE, ((IncludeOrEvalExpression)node4).getFlags());

		assertThat( node5, instanceOf(IncludeOrEvalExpression.class));
		assertEquals( 1, node5.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((IncludeOrEvalExpression)node5).getIncludeOrEvalExpression());
		assertEquals( PHPCSVNodeTypes.FLAG_EXEC_EVAL, ((IncludeOrEvalExpression)node5).getFlags());
	}

	/**
	 * AST_UNARY_OP nodes are used to denote unary operation expressions.
	 *
	 * Any AST_UNARY_OP node has exactly exactly one child, representing the expression for which
	 * the operation is to be performed.
	 *
	 * This test checks a few unary operation expressions' children in the following PHP code:
	 *
	 * // bit operators
	 * ~$foo;
	 * // arithmetic operators
	 * +$x;
	 * -$x;
	 * // boolean operators
	 * !$foo;
	 * // error control operators
	 * @foo();
	 */
	@Test
	public void testUnaryOperationCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUnaryOperation");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);
		ASTNode node3 = ast.getNodeById((long)12);
		ASTNode node4 = ast.getNodeById((long)15);
		ASTNode node5 = ast.getNodeById((long)18);

		assertThat( node, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((UnaryOperationExpression)node).getExpression());

		assertThat( node2, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((UnaryOperationExpression)node2).getExpression());
		
		assertThat( node3, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((UnaryOperationExpression)node3).getExpression());
		
		assertThat( node4, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node4.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((UnaryOperationExpression)node4).getExpression());
		
		assertThat( node5, instanceOf(UnaryOperationExpression.class));
		assertEquals( 1, node5.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((UnaryOperationExpression)node5).getExpression());
	}

	/**
	 * AST_PRE_INC nodes are used to denote pre-increment operation expressions.
	 *
	 * Any AST_PRE_INC node has exactly exactly one child, representing the variable that
	 * is to be incremented (e.g., could be AST_VAR, AST_PROP, AST_STATIC_PROP, AST_DIM, ...)
	 *
	 * This test checks a pre-increment operation expression's child in the following PHP code:
	 *
	 * ++$i;
	 */
	@Test
	public void testPreIncCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPreInc");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PreIncOperationExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PreIncOperationExpression)node).getVariableExpression());
	}

	/**
	 * AST_PRE_DEC nodes are used to denote pre-decrement operation expressions.
	 *
	 * Any AST_PRE_DEC node has exactly exactly one child, representing the variable that
	 * is to be decremented (e.g., could be AST_VAR, AST_PROP, AST_STATIC_PROP, AST_DIM, ...)
	 *
	 * This test checks a pre-decrement operation expression's child in the following PHP code:
	 *
	 * --$i;
	 */
	@Test
	public void testPreDecCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPreDec");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PreDecOperationExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PreDecOperationExpression)node).getVariableExpression());
	}

	/**
	 * AST_POST_INC nodes are used to denote post-increment operation expressions.
	 *
	 * Any AST_POST_INC node has exactly exactly one child, representing the variable that
	 * is to be incremented (e.g., could be AST_VAR, AST_PROP, AST_STATIC_PROP, AST_DIM, ...)
	 *
	 * This test checks a post-increment operation expression's child in the following PHP code:
	 *
	 * $i++;
	 */
	@Test
	public void testPostIncCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPostInc");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PostIncOperationExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PostIncOperationExpression)node).getVariableExpression());
	}

	/**
	 * AST_POST_DEC nodes are used to denote post-decrement operation expressions.
	 *
	 * Any AST_POST_DEC node has exactly exactly one child, representing the variable that
	 * is to be decremented (e.g., could be AST_VAR, AST_PROP, AST_STATIC_PROP, AST_DIM, ...)
	 *
	 * This test checks a post-decrement operation expression's child in the following PHP code:
	 *
	 * $i--;
	 */
	@Test
	public void testPostDecCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPostDec");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(PostDecOperationExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PostDecOperationExpression)node).getVariableExpression());
	}

	/**
	 * AST_YIELD_FROM nodes are used to denote 'yield from' expressions used in generators.
	 * See http://php.net/manual/en/language.generators.syntax.php
	 *
	 * Any AST_YIELD_FROM node has exactly one child, which is an expression that evaluates
	 * to another generator call, traversable object or array to be yielded from.
	 *
	 * This test checks a few yield from expressions' children in the following PHP code:
	 *
	 * function foo() {
	 *   yield from [4, 2];
	 *   yield from new ArrayIterator(["hello", "world"]);
	 *   yield from bar();
	 * }
	 */
	@Test
	public void testYieldFromCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testYieldFrom");

		ASTNode node = ast.getNodeById((long)12);
		ASTNode node2 = ast.getNodeById((long)20);
		ASTNode node3 = ast.getNodeById((long)32);

		assertThat( node, instanceOf(YieldFromExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((YieldFromExpression)node).getFromExpression());

		assertThat( node2, instanceOf(YieldFromExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)21), ((YieldFromExpression)node2).getFromExpression());

		assertThat( node3, instanceOf(YieldFromExpression.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)33), ((YieldFromExpression)node3).getFromExpression());
	}

	/**
	 * AST_GLOBAL nodes are used to denote 'global' statements used to make variables from
	 * the global scope available in a local function scope.
	 *
	 * Any AST_GLOBAL node has exactly one child, which is a variable that is being made
	 * available in a local scope.
	 *
	 * This test checks a few global statements' children in the following PHP code:
	 *
	 * function foo() {
	 *   global $bar, $buz;
	 * }
	 */
	@Test
	public void testGlobalCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testGlobal");

		ASTNode node = ast.getNodeById((long)12);
		ASTNode node2 = ast.getNodeById((long)15);

		assertThat( node, instanceOf(GlobalStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((GlobalStatement)node).getVariable());
		assertEquals( "bar", ((GlobalStatement)node).getVariable().getNameExpression().getEscapedCodeStr());

		assertThat( node2, instanceOf(GlobalStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((GlobalStatement)node2).getVariable());
		assertEquals( "buz", ((GlobalStatement)node2).getVariable().getNameExpression().getEscapedCodeStr());
	}

	/**
	 * AST_UNSET nodes are used to denote unset statements used to destroy variables.
	 *
	 * Any AST_UNSET node has exactly one child, which is a reference to variable that
	 * is to be destroyed (e.g., AST_VAR, AST_PROP, AST_DIM, ...)
	 *
	 * This test checks a few unset statement's children in the following PHP code:
	 *
	 * unset($foo,$bar->buz,$qux[42]);
	 */
	@Test
	public void testUnsetCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUnset");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);
		ASTNode node3 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(UnsetStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((UnsetStatement)node).getVariableExpression());

		assertThat( node2, instanceOf(UnsetStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((UnsetStatement)node2).getVariableExpression());

		assertThat( node3, instanceOf(UnsetStatement.class));
		assertEquals( 1, node3.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((UnsetStatement)node3).getVariableExpression());
	}

	/**
	 * AST_RETURN nodes are nodes representing a return statement.
	 *
	 * Any AST_RETURN node has exactly one child holding the expression to be
	 * returned or a null node if nothing is returned
	 * (e.g., could be NULL, AST_NEW, AST_CONST, AST_VAR, AST_CALL, etc.).
	 *
	 * This test checks a return statement's child in the following PHP code:
	 *
	 * function foo() : int {
	 *   return 42;
	 * }
	 */
	@Test
	public void testReturnCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testReturn");

		ASTNode node = ast.getNodeById((long)12);

		assertThat( node, instanceOf(ReturnStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((ReturnStatement)node).getReturnExpression());
		assertEquals( "42", ((ReturnStatement)node).getReturnExpression().getEscapedCodeStr());
	}

	/**
	 * AST_LABEL nodes are nodes representing a label statement.
	 *
	 * Any AST_LABEL node has exactly one child of type "string" holding the label's name.
	 *
	 * This test checks a label statement's child in the following PHP code:
	 *
	 * goto a;
	 * a:
	 */
	@Test
	public void testLabelCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testGoto");

		ASTNode node = ast.getNodeById((long)8);

		assertThat( node, instanceOf(Label.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((Label)node).getNameChild());
		assertEquals( "a", ((Label)node).getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_REF nodes are used to denote references to variables/properties.
	 * TODO As far as I currently understand, this is a node useful *only* in the
	 * context of a foreach statement; for AST_ARRAY_ELEM nodes that designate a reference,
	 * functions that return references, and function parameters taken as references,
	 * a simple flag is used; for assignments, there is a special kind of node AST_ASSIGN_REF.
	 * But look into this more closely.
	 *
	 * Any AST_REF node has exactly one child, which is a variable/property being referenced.
	 *
	 * This test checks a reference expression's children in the following PHP code:
	 * 
	 * foreach( $iterable as $somekey => &$someval) {}
	 * foreach( $iterable as $somekey => &$obj->someval) {}
	 */
	@Test
	public void testReferenceCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testReference");

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)18);

		assertThat( node, instanceOf(ReferenceExpression.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((ReferenceExpression)node).getVariableExpression());
		assertEquals( "someval", ((Variable)((ReferenceExpression)node).getVariableExpression()).getNameExpression().getEscapedCodeStr());
		
		assertThat( node2, instanceOf(ReferenceExpression.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((ReferenceExpression)node2).getVariableExpression());
		assertEquals( "obj", ((Variable)((PropertyExpression)((ReferenceExpression)node2).getVariableExpression()).getObjectExpression()).getNameExpression().getEscapedCodeStr());
		assertEquals( "someval", ((PropertyExpression)((ReferenceExpression)node2).getVariableExpression()).getPropertyExpression().getEscapedCodeStr());
	}

	/**
	 * AST_HALT_COMPILER nodes are used to denote halt compiler statements which halt
	 * the PHP compiler.
	 * See http://php.net/manual/en/function.halt-compiler.php
	 *
	 * Any AST_HALT_COMPILER node has exactly one child, which holds the offset (in bytes)
	 * in the file after which the compiler is to be halted; this offset is determined during parsing.
	 * TODO What does the offset look like if we throw an eval() on some user input, and
	 * the user input happens to be "__halt_compiler();"? ;-) Can be determined at runtime
	 * using the magic constant __COMPILER_HALT_OFFSET__, look into this.
	 *
	 * This test checks a halt compiler statement's children in the following PHP code:
	 *
	 * __halt_compiler();
	 */
	@Test
	public void testHaltCompilerCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testHaltCompiler");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(HaltCompilerStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((HaltCompilerStatement)node).getOffset());
		assertEquals( "25", ((HaltCompilerStatement)node).getOffset().getEscapedCodeStr());
	}

	/**
	 * AST_ECHO nodes are used to denote echo statements.
	 *
	 * Any AST_ECHO node has exactly one child, which holds the expression to be
	 * evaluated and whose result is to be output.
	 * Note that an echo statement can take an arbitrary number of arguments (but not 0),
	 * in which case an AST_ECHO node is generated for each argument.
	 * TODO What's really weird though, is that an echo statement may not only generate
	 * an arbitrary number of AST_ECHO nodes (which is fine), but also generates a common
	 * AST_STMT_LIST mother node for them. I'm not sure why this should be necessary.
	 * Either find out the reason, or file a bug report.
	 *
	 * This test checks a few echo statement's children in the following PHP code:
	 *
	 * echo "Hello World!", PHP_EOL;
	 */
	@Test
	public void testEchoCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testEcho");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)8);

		assertThat( node, instanceOf(EchoStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((EchoStatement)node).getEchoExpression());
		assertEquals( "Hello World!", ((EchoStatement)node).getEchoExpression().getEscapedCodeStr());

		assertThat( node2, instanceOf(EchoStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)9), ((EchoStatement)node2).getEchoExpression());
		assertEquals( "PHP_EOL", ((Constant)((EchoStatement)node2).getEchoExpression()).getIdentifier().getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_THROW nodes are nodes representing a throw statement.
	 *
	 * Any AST_THROW node has exactly one child holding the expression to
	 * be thrown (e.g., could be AST_NEW, AST_CONST, AST_VAR, AST_CALL, etc.)
	 *
	 * This test checks a throw statement's child in the following PHP code:
	 *
	 * throw new Exception("foo");
	 */
	@Test
	public void testThrowCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testThrow");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ThrowStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ThrowStatement)node).getThrowExpression());
	}

	/**
	 * AST_GOTO nodes are nodes representing a goto statement.
	 *
	 * Any AST_GOTO node has exactly one child of type "string" holding the target label's name.
	 *
	 * This test checks a goto statement's child in the following PHP code:
	 *
	 * goto a;
	 * a:
	 */
	@Test
	public void testGotoCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testGoto");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(GotoStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((GotoStatement)node).getTargetLabel());
		assertEquals( "a", ((GotoStatement)node).getTargetLabel().getEscapedCodeStr());
	}

	/**
	 * AST_BREAK nodes are nodes representing a break statement.
	 *
	 * Any AST_BREAK node has exactly one child which is of type "integer", holding
	 * the number of enclosing structures to be broken out of. It may also be a null
	 * child, in which case no depth was specified, which is equivalent to depth 1.
	 *
	 * This test checks a few break statements' children in the following PHP code:
	 *
	 * while (1) {
	 *   while (1) {
	 *     break 2;
	 *   }
	 *   break 1;
	 * }
	 */
	@Test
	public void testBreakCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testBreak");

		ASTNode node = ast.getNodeById((long)12);
		ASTNode node2 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(BreakStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((BreakStatement)node).getDepth());
		assertEquals( "2", ((BreakStatement)node).getDepth().getEscapedCodeStr());

		assertThat( node2, instanceOf(BreakStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((BreakStatement)node2).getDepth());
		assertEquals( "1", ((BreakStatement)node2).getDepth().getEscapedCodeStr());
	}

	/**
	 * AST_CONTINUE nodes are nodes representing a continue statement.
	 *
	 * Any AST_CONTINUE node has exactly one child which is of type "integer", holding
	 * the number of enclosing loops to be skipped to the end of. It may also be a null
	 * child, in which case no depth was specified, which is equivalent to depth 1.
	 *
	 * This test checks a few continue statements' children in the following PHP code:
	 *
	 * while (1) {
	 *   while (1) {
	 *     continue 2;
	 *   }
	 *   continue 1;
	 * }
	 */
	@Test
	public void testContinueCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testContinue");

		ASTNode node = ast.getNodeById((long)12);
		ASTNode node2 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(ContinueStatement.class));
		assertEquals( 1, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((ContinueStatement)node).getDepth());
		assertEquals( "2", ((ContinueStatement)node).getDepth().getEscapedCodeStr());

		assertThat( node2, instanceOf(ContinueStatement.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((ContinueStatement)node2).getDepth());
		assertEquals( "1", ((ContinueStatement)node2).getDepth().getEscapedCodeStr());
	}


	/* nodes with exactly 2 children */

	/**
	 * AST_DIM nodes are used to denote array indexing expressions.
	 *
	 * Any AST_DIM node has exactly two children:
	 * 1) an expression, whose evaluation returns the array to be accessed
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 2) an expression or NULL, representing the key by which to access the array
	 *    (e.g., could be "string", "integer", AST_VAR, AST_CONST, AST_CALL, etc...)
	 *
	 * This test checks a few array indexing expressions' children in the following PHP code:
	 *
	 * $foo[42];
	 * bar()['key'];
	 * $buz[qux()];
	 * SOMECONSTANT[];
	 */
	@Test
	public void testArrayIndexingCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testArrayIndexing");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)16);
		ASTNode node4 = ast.getNodeById((long)23);

		assertThat( node, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ArrayIndexing)node).getArrayExpression());
		assertEquals( ast.getNodeById((long)9), ((ArrayIndexing)node).getIndexExpression());

		assertThat( node2, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((ArrayIndexing)node2).getArrayExpression());
		assertEquals( ast.getNodeById((long)15), ((ArrayIndexing)node2).getIndexExpression());

		assertThat( node3, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)17), ((ArrayIndexing)node3).getArrayExpression());
		assertEquals( ast.getNodeById((long)19), ((ArrayIndexing)node3).getIndexExpression());

		assertThat( node4, instanceOf(ArrayIndexing.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((ArrayIndexing)node4).getArrayExpression());
		assertNull( ((ArrayIndexing)node4).getIndexExpression());
	}

	/**
	 * AST_PROP nodes are used to denote property access expressions.
	 *
	 * Any AST_PROP node has exactly two children:
	 * 1) an expression, whose evaluation returns the object to be accessed
	 *    (e.g., could be AST_VAR, AST_CALL, etc...)
	 * 2) an expression, whose evaluation holds the property name
	 *    (e.g., could be string, AST_VAR, etc...)
	 *
	 * This test checks a few property access expressions' children in the following PHP code:
	 *
	 * $foo->bar;
	 * buz()->$qux;
	 */
	@Test
	public void testPropertyCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testProperty");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(PropertyExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((PropertyExpression)node).getObjectExpression());
		assertEquals( ast.getNodeById((long)9), ((PropertyExpression)node).getPropertyExpression());

		assertThat( node2, instanceOf(PropertyExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((PropertyExpression)node2).getObjectExpression());
		assertEquals( ast.getNodeById((long)15), ((PropertyExpression)node2).getPropertyExpression());
	}

	/**
	 * AST_STATIC_PROP nodes are used to denote static property access expressions.
	 *
	 * Any AST_STATIC_PROP node has exactly two children:
	 * 1) an expression, whose evaluation returns the class to be accessed
	 *    (e.g., could be AST_NAME, AST_VAR, AST_CALL, etc...)
	 * 2) an expression, whose evaluation holds the property name
	 * 	  (e.g., could be string, AST_NAME, AST_VAR, etc...)
	 *
	 * This test checks a few static property access expressions' children in the following PHP code:
	 *
	 * Foo::$bar;
	 * $foo::$bar;
	 * buz()::$$qux;
	 */
	@Test
	public void testStaticPropertyCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testStaticProperty");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(StaticPropertyExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((StaticPropertyExpression)node).getClassExpression());
		assertEquals( ast.getNodeById((long)9), ((StaticPropertyExpression)node).getPropertyExpression());

		assertThat( node2, instanceOf(StaticPropertyExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((StaticPropertyExpression)node2).getClassExpression());
		assertEquals( ast.getNodeById((long)13), ((StaticPropertyExpression)node2).getPropertyExpression());

		assertThat( node3, instanceOf(StaticPropertyExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((StaticPropertyExpression)node3).getClassExpression());
		assertEquals( ast.getNodeById((long)19), ((StaticPropertyExpression)node3).getPropertyExpression());
	}

	/**
	 * AST_CALL nodes are used to denote call expressions.
	 *
	 * Any AST_CALL node has exactly 2 children:
	 * 1) an expression, representing the target
	 *    (e.g., could be AST_NAME, AST_VAR, AST_CALL, ...)
	 * 2) AST_ARG_LIST, representing the argument list
	 *
	 * This test checks a few call expressions' children in the following PHP code:
	 *
	 * foo($bar, "yabadabadoo");
	 * $buz(1);
	 */
	@Test
	public void testCallCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testCall");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)13);

		assertThat( node, instanceOf(CallExpressionBase.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((CallExpressionBase)node).getTargetFunc());
		assertEquals( "foo", ((Identifier)((CallExpressionBase)node).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((CallExpressionBase)node).getArgumentList());
		assertEquals( 2, ((CallExpressionBase)node).getArgumentList().size());

		assertThat( node2, instanceOf(CallExpressionBase.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((CallExpressionBase)node2).getTargetFunc());
		assertEquals( "buz", ((Variable)((CallExpressionBase)node2).getTargetFunc()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)16), ((CallExpressionBase)node2).getArgumentList());
		assertEquals( 1, ((CallExpressionBase)node2).getArgumentList().size());
	}

	/**
	 * AST_CLASS_CONST nodes are used to denote class constant access expressions.
	 *
	 * Any AST_CLASS_CONST node has exactly two children:
	 * 1) an expression, whose evaluation returns the class to be accessed
	 *    (e.g., could be AST_NAME, AST_VAR, AST_CALL, etc...)
	 * 2) a string, representing the constant name
	 *
	 * This test checks a few class constant expressions' children in the following PHP code:
	 *
	 * Foo::BAR;
	 * $foo::BAR;
	 * buz()::QUX;
	 */
	@Test
	public void testClassConstantCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClassConstant");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(ClassConstantExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ClassConstantExpression)node).getClassExpression());
		assertEquals( ast.getNodeById((long)9), ((ClassConstantExpression)node).getConstantName());

		assertThat( node2, instanceOf(ClassConstantExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((ClassConstantExpression)node2).getClassExpression());
		assertEquals( ast.getNodeById((long)13), ((ClassConstantExpression)node2).getConstantName());

		assertThat( node3, instanceOf(ClassConstantExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((ClassConstantExpression)node3).getClassExpression());
		assertEquals( ast.getNodeById((long)19), ((ClassConstantExpression)node3).getConstantName());
	}

	/**
	 * AST_ASSIGN nodes are used to denote assignment expressions.
	 *
	 * Any AST_ASSIGN node has exactly two children:
	 * 1) an expression, representing the variable being assigned to
	 *    (e.g., could be AST_VAR, AST_DIM, AST_PROP, AST_STATIC_PROP, AST_LIST, etc...)
	 * 2) an expression, representing the expression to be evaluated and assigned to a variable
	 *    (e.g., could be int, string, AST_CONST, AST_CALL, AST_ARRAY, etc...)
	 *
	 * This test checks a few assignment expressions' children in the following PHP code:
	 *
	 * $foo = 42;
	 * $bar[3] = "bonjour";
	 * $buz->qux = SOMECONST;
	 * Buz::$qux = somecall();
	 * list($a) = [3];
	 */
	@Test
	public void testAssignCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssign");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)16);
		ASTNode node4 = ast.getNodeById((long)24);
		ASTNode node5 = ast.getNodeById((long)33);

		assertThat( node, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((AssignmentExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)9), ((AssignmentExpression)node).getRight());

		assertThat( node2, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((AssignmentExpression)node2).getLeft());
		assertEquals( ast.getNodeById((long)15), ((AssignmentExpression)node2).getRight());

		assertThat( node3, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)17), ((AssignmentExpression)node3).getLeft());
		assertEquals( ast.getNodeById((long)21), ((AssignmentExpression)node3).getRight());

		assertThat( node4, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)25), ((AssignmentExpression)node4).getLeft());
		assertEquals( ast.getNodeById((long)29), ((AssignmentExpression)node4).getRight());

		assertThat( node5, instanceOf(AssignmentExpression.class));
		assertEquals( 2, node5.getChildCount());
		assertEquals( ast.getNodeById((long)34), ((AssignmentExpression)node5).getLeft());
		assertEquals( ast.getNodeById((long)37), ((AssignmentExpression)node5).getRight());
	}

	/**
	 * AST_ASSIGN_REF nodes are used to denote assignment by reference expressions.
	 * See
	 * http://php.net/manual/en/language.operators.assignment.php#language.operators.assignment.reference
	 *
	 * Any AST_ASSIGN_REF node has exactly two children:
	 * 1) an expression, representing the variable being assigned to
	 *    (e.g., could be AST_VAR, AST_DIM, AST_PROP, AST_STATIC_PROP, etc...)
	 * 2) an expression, representing the expression to be evaluated to a reference and assigned to a variable
	 *    (e.g., AST_VAR, AST_DIM, AST_CALL, AST_METHOD_CALL, AST_STATIC_CALL, etc...)
	 *
	 * This test checks a few assignment by reference expressions' children in the following PHP code:
	 *
	 * $foo =& $someref;
	 * $bar[3] =& $someref[4];
	 * $buz->qux =& $buz->somecall();
	 * Buz::$qux =& Buz::somestaticcall();
	 */
	@Test
	public void testAssignByRefCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignByRef");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)11);
		ASTNode node3 = ast.getNodeById((long)20);
		ASTNode node4 = ast.getNodeById((long)30);

		assertThat( node, instanceOf(AssignmentByRefExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((AssignmentByRefExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)9), ((AssignmentByRefExpression)node).getRight());

		assertThat( node2, instanceOf(AssignmentByRefExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((AssignmentByRefExpression)node2).getLeft());
		assertEquals( ast.getNodeById((long)16), ((AssignmentByRefExpression)node2).getRight());

		assertThat( node3, instanceOf(AssignmentByRefExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)21), ((AssignmentByRefExpression)node3).getLeft());
		assertEquals( ast.getNodeById((long)25), ((AssignmentByRefExpression)node3).getRight());

		assertThat( node4, instanceOf(AssignmentByRefExpression.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)31), ((AssignmentByRefExpression)node4).getLeft());
		assertEquals( ast.getNodeById((long)35), ((AssignmentByRefExpression)node4).getRight());
	}

	/**
	 * AST_ASSIGN_OP nodes are used to denote assignment expressions with operations.
	 *
	 * Any AST_ASSIGN_OP node has exactly two children:
	 * 1) an expression, representing the variable being assigned to
	 *    (e.g., could be AST_VAR, AST_DIM, AST_PROP, AST_STATIC_PROP, etc...)
	 * 2) an expression, representing the expression to be evaluated, combined with the
	 *    variable being assigned to using a given operator, and assigned to that variable
	 *    (e.g., could be int, string, AST_VAR, AST_CONST, AST_CALL, etc...)
	 *
	 * This test checks a few assignment with operation expressions' children in the following PHP code:
	 *
	 * $foo += 42;
	 * $bar .= "bonjour";
	 * $buz ^= $onetimepad;
	 */
	@Test
	public void testAssignWithOpCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testAssignWithOp");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(AssignmentWithOpExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((AssignmentWithOpExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)9), ((AssignmentWithOpExpression)node).getRight());

		assertThat( node2, instanceOf(AssignmentWithOpExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((AssignmentWithOpExpression)node2).getLeft());
		assertEquals( ast.getNodeById((long)13), ((AssignmentWithOpExpression)node2).getRight());

		assertThat( node3, instanceOf(AssignmentWithOpExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((AssignmentWithOpExpression)node3).getLeft());
		assertEquals( ast.getNodeById((long)17), ((AssignmentWithOpExpression)node3).getRight());
	}

	/**
	 * AST_BINARY_OP nodes are used to denote binary operation expressions.
	 *
	 * Any AST_BINARY_OP node has exactly two children:
	 * 1) an expression on the left-hand side
	 * 2) an expression on the right-hand side
	 *
	 * This test checks a plethora of binary operation expressions' children in the following PHP code:
	 *
	 * // bit operators
	 * $or1 | $or2;
	 * $and1 & $and2;
	 * $msg ^ $otp;
	 * $x << $y;
	 * $x >> $y;
	 * // string operators
	 * $str1 . $str2;
	 * // arithmetic operators
	 * $x + $y;
	 * $x - $y;
	 * $x * $y;
	 * $x / $y;
	 * $x % $y;
	 * $x ** $y;
	 * // boolean operators
	 * $x xor $y;
	 * $x && $y;
	 * $x || $y;
	 * // comparison operators
	 * $x === $y;
	 * $x !== $y;
	 * $x == $y;
	 * $x != $y;
	 * $x < $y;
	 * $x <= $y;
	 * $x <=> $y;
	 * $x > $y;
	 * $x >= $y;
	 */
	@Test
	public void testBinaryOperationCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testBinaryOperation");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)11);
		ASTNode node3 = ast.getNodeById((long)16);
		ASTNode node4 = ast.getNodeById((long)21);
		ASTNode node5 = ast.getNodeById((long)26);
		ASTNode node6 = ast.getNodeById((long)31);
		ASTNode node7 = ast.getNodeById((long)36);
		ASTNode node8 = ast.getNodeById((long)41);
		ASTNode node9 = ast.getNodeById((long)46);
		ASTNode node10 = ast.getNodeById((long)51);
		ASTNode node11 = ast.getNodeById((long)56);
		ASTNode node12 = ast.getNodeById((long)61);
		ASTNode node13 = ast.getNodeById((long)66);
		ASTNode node14 = ast.getNodeById((long)71);
		ASTNode node15 = ast.getNodeById((long)76);
		ASTNode node16 = ast.getNodeById((long)81);
		ASTNode node17 = ast.getNodeById((long)86);
		ASTNode node18 = ast.getNodeById((long)91);
		ASTNode node19 = ast.getNodeById((long)96);
		ASTNode node20 = ast.getNodeById((long)101);
		ASTNode node21 = ast.getNodeById((long)106);
		ASTNode node22 = ast.getNodeById((long)111);
		ASTNode node23 = ast.getNodeById((long)116);
		ASTNode node24 = ast.getNodeById((long)121);

		assertThat( node, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((BinaryOperationExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)9), ((BinaryOperationExpression)node).getRight());

		assertThat( node2, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((BinaryOperationExpression)node2).getLeft());
		assertEquals( ast.getNodeById((long)14), ((BinaryOperationExpression)node2).getRight());

		assertThat( node3, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)17), ((BinaryOperationExpression)node3).getLeft());
		assertEquals( ast.getNodeById((long)19), ((BinaryOperationExpression)node3).getRight());

		assertThat( node4, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)22), ((BinaryOperationExpression)node4).getLeft());
		assertEquals( ast.getNodeById((long)24), ((BinaryOperationExpression)node4).getRight());

		assertThat( node5, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node5.getChildCount());
		assertEquals( ast.getNodeById((long)27), ((BinaryOperationExpression)node5).getLeft());
		assertEquals( ast.getNodeById((long)29), ((BinaryOperationExpression)node5).getRight());

		assertThat( node6, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node6.getChildCount());
		assertEquals( ast.getNodeById((long)32), ((BinaryOperationExpression)node6).getLeft());
		assertEquals( ast.getNodeById((long)34), ((BinaryOperationExpression)node6).getRight());

		assertThat( node7, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node7.getChildCount());
		assertEquals( ast.getNodeById((long)37), ((BinaryOperationExpression)node7).getLeft());
		assertEquals( ast.getNodeById((long)39), ((BinaryOperationExpression)node7).getRight());

		assertThat( node8, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node8.getChildCount());
		assertEquals( ast.getNodeById((long)42), ((BinaryOperationExpression)node8).getLeft());
		assertEquals( ast.getNodeById((long)44), ((BinaryOperationExpression)node8).getRight());

		assertThat( node9, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node9.getChildCount());
		assertEquals( ast.getNodeById((long)47), ((BinaryOperationExpression)node9).getLeft());
		assertEquals( ast.getNodeById((long)49), ((BinaryOperationExpression)node9).getRight());

		assertThat( node10, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node10.getChildCount());
		assertEquals( ast.getNodeById((long)52), ((BinaryOperationExpression)node10).getLeft());
		assertEquals( ast.getNodeById((long)54), ((BinaryOperationExpression)node10).getRight());

		assertThat( node11, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node11.getChildCount());
		assertEquals( ast.getNodeById((long)57), ((BinaryOperationExpression)node11).getLeft());
		assertEquals( ast.getNodeById((long)59), ((BinaryOperationExpression)node11).getRight());

		assertThat( node12, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node12.getChildCount());
		assertEquals( ast.getNodeById((long)62), ((BinaryOperationExpression)node12).getLeft());
		assertEquals( ast.getNodeById((long)64), ((BinaryOperationExpression)node12).getRight());

		assertThat( node13, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node13.getChildCount());
		assertEquals( ast.getNodeById((long)67), ((BinaryOperationExpression)node13).getLeft());
		assertEquals( ast.getNodeById((long)69), ((BinaryOperationExpression)node13).getRight());

		assertThat( node14, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node14.getChildCount());
		assertEquals( ast.getNodeById((long)72), ((BinaryOperationExpression)node14).getLeft());
		assertEquals( ast.getNodeById((long)74), ((BinaryOperationExpression)node14).getRight());

		assertThat( node15, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node15.getChildCount());
		assertEquals( ast.getNodeById((long)77), ((BinaryOperationExpression)node15).getLeft());
		assertEquals( ast.getNodeById((long)79), ((BinaryOperationExpression)node15).getRight());

		assertThat( node16, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node16.getChildCount());
		assertEquals( ast.getNodeById((long)82), ((BinaryOperationExpression)node16).getLeft());
		assertEquals( ast.getNodeById((long)84), ((BinaryOperationExpression)node16).getRight());

		assertThat( node17, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node17.getChildCount());
		assertEquals( ast.getNodeById((long)87), ((BinaryOperationExpression)node17).getLeft());
		assertEquals( ast.getNodeById((long)89), ((BinaryOperationExpression)node17).getRight());

		assertThat( node18, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node18.getChildCount());
		assertEquals( ast.getNodeById((long)92), ((BinaryOperationExpression)node18).getLeft());
		assertEquals( ast.getNodeById((long)94), ((BinaryOperationExpression)node18).getRight());

		assertThat( node19, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node19.getChildCount());
		assertEquals( ast.getNodeById((long)97), ((BinaryOperationExpression)node19).getLeft());
		assertEquals( ast.getNodeById((long)99), ((BinaryOperationExpression)node19).getRight());

		assertThat( node20, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node20.getChildCount());
		assertEquals( ast.getNodeById((long)102), ((BinaryOperationExpression)node20).getLeft());
		assertEquals( ast.getNodeById((long)104), ((BinaryOperationExpression)node20).getRight());
		
		assertThat( node21, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node21.getChildCount());
		assertEquals( ast.getNodeById((long)107), ((BinaryOperationExpression)node21).getLeft());
		assertEquals( ast.getNodeById((long)109), ((BinaryOperationExpression)node21).getRight());
		
		assertThat( node22, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node22.getChildCount());
		assertEquals( ast.getNodeById((long)112), ((BinaryOperationExpression)node22).getLeft());
		assertEquals( ast.getNodeById((long)114), ((BinaryOperationExpression)node22).getRight());		
		
		assertThat( node23, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node23.getChildCount());
		assertEquals( ast.getNodeById((long)117), ((BinaryOperationExpression)node23).getLeft());
		assertEquals( ast.getNodeById((long)119), ((BinaryOperationExpression)node23).getRight());		

		assertThat( node24, instanceOf(BinaryOperationExpression.class));
		assertEquals( 2, node24.getChildCount());
		assertEquals( ast.getNodeById((long)122), ((BinaryOperationExpression)node24).getLeft());
		assertEquals( ast.getNodeById((long)124), ((BinaryOperationExpression)node24).getRight());
	}

	/**
	 * AST_ARRAY_ELEM nodes are used to denote the individual elements of an array expression.
	 * They are the children of an AST_ARRAY node; see description of AST_ARRAY.
	 *
	 * Any AST_ARRAY_ELEM node has exactly two children:
	 * 1) an expression, representing the array element's value
	 *    (e.g., could be "string", "integer", AST_VAR, AST_CONST, AST_CALL, etc...)
	 * 2) an expression or NULL, representing the array element's key
	 *    (e.g., could be "string", "integer", AST_VAR, AST_CONST, AST_CALL, etc...)
	 *
	 * This test checks a few array elements' children in the following PHP code:
	 *
	 * array("key1" => 42,
	 *       2 => "foo",
	 *       aconst => $bar,
	 *       buz());
	 */
	@Test
	public void testArrayElementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testArray");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)13);
		ASTNode node4 = ast.getNodeById((long)19);

		assertThat( node, instanceOf(ArrayElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((ArrayElement)node).getValue());
		assertEquals( ast.getNodeById((long)9), ((ArrayElement)node).getKey());

		assertThat( node2, instanceOf(ArrayElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((ArrayElement)node2).getValue());
		assertEquals( ast.getNodeById((long)12), ((ArrayElement)node2).getKey());

		assertThat( node3, instanceOf(ArrayElement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((ArrayElement)node3).getValue());
		assertEquals( ast.getNodeById((long)16), ((ArrayElement)node3).getKey());

		assertThat( node4, instanceOf(ArrayElement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)20), ((ArrayElement)node4).getValue());
		assertNull( ((ArrayElement)node4).getKey());
	}

	/**
	 * AST_NEW nodes are used to denote 'new' expressions used to create a new instance
	 * of a class.
	 *
	 * Any AST_NEW node has exactly 2 children:
	 * 1) an expression, whose evaluation holds the name of the class to be instantiated
	 *    (e.g., could be AST_NAME, AST_VAR, ...)
	 *    - or -
	 *    AST_CLASS, representing the instantiation of an anonymous class
	 * 2) AST_ARG_LIST, representing the argument list
	 *
	 * This test checks a few new expressions' children in the following PHP code:
	 *
	 * new Foo($bar);
	 * new $buz();
	 * new class() extends A implements B, C {};
	 * 
	 * It also checks that a ClassExpression holding an anonymous class definition is created.
	 */
	@Test
	public void testNewCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testNew");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)12);
		ASTNode node3 = ast.getNodeById((long)16);

		assertThat( node, instanceOf(NewExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((NewExpression)node).getTargetClass());
		assertEquals( "Foo", ((Identifier)((NewExpression)node).getTargetClass()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((NewExpression)node).getArgumentList());
		assertEquals( 1, ((NewExpression)node).getArgumentList().size());

		assertThat( node2, instanceOf(NewExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((NewExpression)node2).getTargetClass());
		assertEquals( "buz", ((Variable)((NewExpression)node2).getTargetClass()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)15), ((NewExpression)node2).getArgumentList());
		assertEquals( 0, ((NewExpression)node2).getArgumentList().size());

		assertThat( node3, instanceOf(NewExpression.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)29), ((NewExpression)node3).getArgumentList());
		assertEquals( 0, ((NewExpression)node3).getArgumentList().size());

		// special test for the artificial ClassExpression node:
		
		ASTNode node4 = ((NewExpression)node3).getTargetClass();
		assertThat( node4, instanceOf(ClassExpression.class));

		ASTNode node5 = ast.getNodeById((long)17);
		assertThat( node5, instanceOf(ClassDef.class));
		assertEquals( node5, ((ClassExpression)node4).getClassDef());
		// the class definition wrapper should have the same node id as the anonymous class definition itself
		assertEquals( node5.getNodeId(), node4.getNodeId());
	}

	/**
	 * AST_INSTANCEOF nodes are used to denote 'instanceof' expressions used to check whether
	 * a given expression evaluates to an instance of a given class.
	 *
	 * Any AST_INSTANCEOF node has exactly 2 children:
	 * 1) an expression, whose evaluation holds the object to be checked
	 *    (e.g., could be AST_VAR, AST_CALL, ...)
	 * 2) an expression, whose evaluation holds the name of the class that the object
	 *    may or may not be an instance of
	 *    (e.g., could be AST_NAME, AST_VAR, ...)
	 *
	 * This test checks a few instanceof expressions' children in the following PHP code:
	 *
	 * $foo instanceof Bar;
	 * buz() instanceof $qux;
	 */
	@Test
	public void testInstanceofCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testInstanceof");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)11);

		assertThat( node, instanceOf(InstanceofExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((InstanceofExpression)node).getInstanceExpression());
		assertEquals( "foo", ((Variable)((InstanceofExpression)node).getInstanceExpression()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((InstanceofExpression)node).getClassExpression());
		assertEquals( "Bar", ((Identifier)((InstanceofExpression)node).getClassExpression()).getNameChild().getEscapedCodeStr());

		assertThat( node2, instanceOf(InstanceofExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((InstanceofExpression)node2).getInstanceExpression());
		assertEquals( "buz", ((Identifier)((CallExpressionBase)((InstanceofExpression)node2).getInstanceExpression()).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)16), ((InstanceofExpression)node2).getClassExpression());
		assertEquals( "qux", ((Variable)((InstanceofExpression)node2).getClassExpression()).getNameExpression().getEscapedCodeStr());
	}

	/**
	 * AST_YIELD nodes are used to denote yield expressions used in generators.
	 * See http://php.net/manual/en/language.generators.syntax.php
	 *
	 * Any AST_YIELD node has exactly 2 children:
	 * 1) an expression or NULL, whose evaluation holds the value to be yielded
	 *    (if it is NULL, then the function interrupts execution, but returns nothing)
	 * 2) an expression or NULL, specifying an optional key to be yielded
	 *
	 * This test checks a few yield expressions' children in the following PHP code:
	 *
	 * function foo() {
	 *   yield 42;
	 *   yield $somekey => bar();
	 * }
	 */
	@Test
	public void testYieldCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testYield");

		ASTNode node = ast.getNodeById((long)12);
		ASTNode node2 = ast.getNodeById((long)15);

		assertThat( node, instanceOf(YieldExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((YieldExpression)node).getValue());
		assertEquals( "42", ((YieldExpression)node).getValue().getEscapedCodeStr());
		assertNull( ((YieldExpression)node).getKey());

		assertThat( node2, instanceOf(YieldExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((YieldExpression)node2).getValue());
		assertEquals( "bar", ((Identifier)((CallExpressionBase)((YieldExpression)node2).getValue()).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)20), ((YieldExpression)node2).getKey());
		assertEquals( "somekey", ((Variable)((YieldExpression)node2).getKey()).getNameExpression().getEscapedCodeStr());
	}

	/**
	 * AST_COALESCE nodes are used to represent coalesce expressions, i.e., expressions
	 * using the ?? operator.
	 *
	 * Any AST_COALESCE node has exactly two children:
	 * 1) various possible types (including plain nodes), representing
	 *    the expression on the left side
	 * 2) various possible types (including plain nodes), representing
	 *    the expression on the right side
	 *
	 * This test checks a coalesce expression's children in the following PHP code:
	 *
	 * "foo" ?? "bar";
	 */
	@Test
	public void testCoalesceCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testCoalesce");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(CoalesceExpression.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((CoalesceExpression)node).getLeft());
		assertEquals( ast.getNodeById((long)8), ((CoalesceExpression)node).getRight());
	}

	/**
	 * AST_STATIC nodes are used to denote static variable declarations.
	 * See http://php.net/manual/en/language.variables.scope.php#language.variables.scope.static
	 *
	 * Any AST_STATIC node has exactly two children:
	 * 1) AST_VAR, containing the static variable's name
	 * 2) various possible child types, representing the default value
	 *    (e.g., node type could be "NULL", "string", "integer", but also AST_CONST, etc.)
	 *
	 * This test checks a few static variable declarations' children in the following PHP code:
	 *
	 * function foo() {
	 *   static $bar, $buz = 42, $qux = norf();
	 * }
	 */
	@Test
	public void testStaticCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testStatic");

		ASTNode node = ast.getNodeById((long)12);
		ASTNode node2 = ast.getNodeById((long)16);
		ASTNode node3 = ast.getNodeById((long)20);

		assertThat( node, instanceOf(StaticVariableDeclaration.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((StaticVariableDeclaration)node).getNameChild());
		assertEquals( "bar", ((StaticVariableDeclaration)node).getNameChild().getNameExpression().getEscapedCodeStr());
		assertNull( ((StaticVariableDeclaration)node).getDefault());

		assertThat( node2, instanceOf(StaticVariableDeclaration.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)17), ((StaticVariableDeclaration)node2).getNameChild());
		assertEquals( "buz", ((StaticVariableDeclaration)node2).getNameChild().getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)19), ((StaticVariableDeclaration)node2).getDefault());
		assertEquals( "42", ((StaticVariableDeclaration)node2).getDefault().getEscapedCodeStr());

		assertThat( node3, instanceOf(StaticVariableDeclaration.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)21), ((StaticVariableDeclaration)node3).getNameChild());
		assertEquals( "qux", ((StaticVariableDeclaration)node3).getNameChild().getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)23), ((StaticVariableDeclaration)node3).getDefault());
		assertEquals( "norf", ((Identifier)((CallExpressionBase)((StaticVariableDeclaration)node3).getDefault()).getTargetFunc()).getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_WHILE nodes are used to declare while loops.
	 *
	 * Any AST_WHILE node has exactly two children:
	 * 1) various possible types, representing the expression in the loop's guard,
	 *    also known as "condition" or "predicate"
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 *
	 * This test checks a few while loops' children in the following PHP code:
	 *
	 * while($foo) {}
	 * while(true) {}
	 * while(somecall()) {}
	 * while($var === 1) {}
	 */
	@Test
	public void testWhileCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testWhile");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)15);
		ASTNode node4 = ast.getNodeById((long)21);

		assertThat( node, instanceOf(WhileStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((WhileStatement)node).getCondition());
		assertEquals( ast.getNodeById((long)9), ((WhileStatement)node).getStatement());

		assertThat( node2, instanceOf(WhileStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((WhileStatement)node2).getCondition());
		assertEquals( ast.getNodeById((long)14), ((WhileStatement)node2).getStatement());

		assertThat( node3, instanceOf(WhileStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((WhileStatement)node3).getCondition());
		assertEquals( ast.getNodeById((long)20), ((WhileStatement)node3).getStatement());

		assertThat( node4, instanceOf(WhileStatement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)22), ((WhileStatement)node4).getCondition());
		assertEquals( ast.getNodeById((long)26), ((WhileStatement)node4).getStatement());
	}

	/**
	 * AST_DO_WHILE nodes are used to declare do-while loops.
	 *
	 * Any AST_DO_WHILE node has exactly two children:
	 * 1) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 * 2) various possible types, representing the expression in the loop's guard,
	 *    also known as "condition" or "predicate"
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 *
	 * This test checks a few while loops' children in the following PHP code:
	 *
	 * do {} while($foo);
	 * do {} while(true);
	 * do {} while(somecall());
	 * do {} while($var === 1);
	 */
	@Test
	public void testDoCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testDo");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)10);
		ASTNode node3 = ast.getNodeById((long)15);
		ASTNode node4 = ast.getNodeById((long)21);

		assertThat( node, instanceOf(DoStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((DoStatement)node).getStatement());
		assertEquals( ast.getNodeById((long)8), ((DoStatement)node).getCondition());

		assertThat( node2, instanceOf(DoStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((DoStatement)node2).getStatement());
		assertEquals( ast.getNodeById((long)12), ((DoStatement)node2).getCondition());

		assertThat( node3, instanceOf(DoStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((DoStatement)node3).getStatement());
		assertEquals( ast.getNodeById((long)17), ((DoStatement)node3).getCondition());

		assertThat( node4, instanceOf(DoStatement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)22), ((DoStatement)node4).getStatement());
		assertEquals( ast.getNodeById((long)23), ((DoStatement)node4).getCondition());
	}

	/**
	 * AST_IF_ELEM nodes are used to denote the individual elements of an if-statement.
	 * Similarly as while or do-while loops, they are composed of a condition and
	 * a statement; see description of AST_IF for the bigger picture.
	 *
	 * Any AST_IF_ELEM node has exactly two children:
	 * 1) various possible types or NULL, representing the expression in the element's guard,
	 *    also known as "condition" or "predicate"; NULL is used when there is no such
	 *    expression, i.e., in "pure" unconditional else-branches.
	 *    (e.g., could be NULL, AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 *
	 * This test checks a few if-elements' children in the following PHP code:
	 *
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */
	@Test
	public void testIfElementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testIf");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)11);
		ASTNode node3 = ast.getNodeById((long)15);
		ASTNode node4 = ast.getNodeById((long)19);

		assertThat( node, instanceOf(IfElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((IfElement)node).getCondition());
		assertEquals( ast.getNodeById((long)10), ((IfElement)node).getStatement());

		assertThat( node2, instanceOf(IfElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)12), ((IfElement)node2).getCondition());
		assertEquals( ast.getNodeById((long)14), ((IfElement)node2).getStatement());

		assertThat( node3, instanceOf(IfElement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((IfElement)node3).getCondition());
		assertEquals( ast.getNodeById((long)18), ((IfElement)node3).getStatement());

		assertThat( node4, instanceOf(IfElement.class));
		assertEquals( 2, node4.getChildCount());
		assertNull( ((IfElement)node4).getCondition());
		assertEquals( ast.getNodeById((long)21), ((IfElement)node4).getStatement());
	}

	/**
	 * AST_SWITCH nodes are used to denote switch-statements.
	 * They are composed of an expression that evaluates to a value (matched against the different
	 * switch-element's values) and a switch list composed of switch-elements.
	 *
	 * Any AST_SWITCH node has exactly two children:
	 * 1) various possible types, representing the expression in the switch statement's guard,
	 *    (e.g., could be AST_VAR, AST_CONST, AST_CALL, AST_BINARY_OP, etc...)
	 * 2) AST_SWITCH_LIST, a list of switch-elements in the switch statement's body
	 *
	 * This test checks a switch-statement's children in the following PHP code:
	 *
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitchCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testSwitch");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(SwitchStatementPHP.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((SwitchStatementPHP)node).getExpression());
		assertEquals( "i", ((Variable)((SwitchStatementPHP)node).getExpression()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((SwitchStatementPHP)node).getSwitchList());
		assertEquals( 4, ((SwitchStatementPHP)node).getSwitchList().size());
	}

	/**
	 * AST_SWITCH_CASE nodes are used to denote the individual switch-elements of a switch list.
	 * Similarly as if-elements, they are composed of a value (matched against a condition) and
	 * a statement list; see description of AST_SWITCH_LIST and AST_SWITCH for the bigger picture.
	 *
	 * Any AST_SWITCH_CASE node has exactly two children:
	 * 1) an Expression or NULL, representing the value in the switch element's guard,
	 *    NULL is used when there is no such value, i.e., in "default" switch-elements.
	 *    (e.g., could be integer, double, string, AST_CONST, AST_CLASS_CONST, ...)
	 * 2) AST_STMT_LIST, representing the code in the switch element's body
	 *
	 * This test checks a few switch-elements' children in the following PHP code:
	 *
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitchCaseCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testSwitch");

		ASTNode node = ast.getNodeById((long)10);
		ASTNode node2 = ast.getNodeById((long)15);
		ASTNode node3 = ast.getNodeById((long)18);
		ASTNode node4 = ast.getNodeById((long)23);

		assertThat( node, instanceOf(SwitchCase.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((SwitchCase)node).getValue());
		assertEquals( "string", ((SwitchCase)node).getValue().getProperty("type"));
		assertEquals( "foo", ((SwitchCase)node).getValue().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)12), ((SwitchCase)node).getStatement());

		assertThat( node2, instanceOf(SwitchCase.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((SwitchCase)node2).getValue());
		assertEquals( "double", ((SwitchCase)node2).getValue().getProperty("type"));
		assertEquals( "1.42", ((SwitchCase)node2).getValue().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)17), ((SwitchCase)node2).getStatement());

		assertThat( node3, instanceOf(SwitchCase.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((SwitchCase)node3).getValue());
		assertEquals( "integer", ((SwitchCase)node3).getValue().getProperty("type"));
		assertEquals( "2", ((SwitchCase)node3).getValue().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)20), ((SwitchCase)node3).getStatement());

		assertThat( node4, instanceOf(SwitchCase.class));
		assertEquals( 2, node4.getChildCount());
		assertNull( ((SwitchCase)node4).getValue());
		assertEquals( ast.getNodeById((long)25), ((SwitchCase)node4).getStatement());
	}

	/**
	 * AST_DECLARE nodes are used to denote declare statements.
	 * See http://php.net/manual/en/control-structures.declare.php
	 *
	 * Any AST_DECLARE node has exactly two children:
	 * 1) AST_CONST_DECL, holding the set directive(s)
	 * 2) statement types or NULL, holding the code to be executed under the given directives
	 *    (If a standalone semicolon is used, then this child is NULL and the directives affect
	 *    all code following the declare statement.)
	 *
	 * This test checks a few declare statement's children in the following PHP code:
	 *
	 * declare(ticks=1) {}
	 * declare(foo='bar');
	 * declare(buz=$qux) norf();
	 */
	@Test
	public void testDeclareCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testDeclare");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)12);
		ASTNode node3 = ast.getNodeById((long)18);

		assertThat( node, instanceOf(DeclareStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((DeclareStatement)node).getDeclares());
		assertEquals( ast.getNodeById((long)11), ((DeclareStatement)node).getStatement());

		assertThat( node2, instanceOf(DeclareStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)13), ((DeclareStatement)node2).getDeclares());
		assertNull( ((DeclareStatement)node2).getStatement());
		
		assertThat( node3, instanceOf(DeclareStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)19), ((DeclareStatement)node3).getDeclares());
		
		// special test for the artificial ExpressionStatement node:

		ASTNode node4 = ((DeclareStatement)node3).getStatement();
		assertThat( node4, instanceOf(ExpressionStatement.class));

		ASTNode node5 = ast.getNodeById((long)24);
		assertThat( node5, instanceOf(CallExpressionBase.class));
		assertEquals( node5, ((ExpressionStatement)node4).getExpression());
		// the expression statement wrapper should have the same node id as the expression itself
		assertEquals( node5.getNodeId(), node4.getNodeId());
	}

	/**
	 * AST_PROP_ELEM nodes are used to denote the individual elements of a property declaration
	 * statement in the top-level scope of a class.
	 * They are the children of an AST_PROP_DECL node; see description of AST_PROP_DECL.
	 *
	 * Any AST_PROP_ELEM node has exactly two children:
	 * 1) string, indicating the property's name
	 * 2) various possible child types, representing the default value
	 *    (e.g., node type could be "NULL", "string", "integer", but also AST_CONST, etc.)
	 *
	 * This test checks a few property elements' children in the following PHP code:
	 *
	 * class Foo {
	 *   public $foo, $bar = 3, $buz = "bonjour", $qux = SOMECONSTANT;
	 * }
	 */
	@Test
	public void testPropertyElementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPropertyDeclaration");

		ASTNode node = ast.getNodeById((long)14);
		ASTNode node2 = ast.getNodeById((long)17);
		ASTNode node3 = ast.getNodeById((long)20);
		ASTNode node4 = ast.getNodeById((long)23);

		assertThat( node, instanceOf(PropertyElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((PropertyElement)node).getNameChild());
		assertEquals( "foo", ((PropertyElement)node).getNameChild().getEscapedCodeStr());
		assertNull( ((PropertyElement)node).getDefault());

		assertThat( node2, instanceOf(PropertyElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)18), ((PropertyElement)node2).getNameChild());
		assertEquals( "bar", ((PropertyElement)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)19), ((PropertyElement)node2).getDefault());
		assertEquals( "3", ((PropertyElement)node2).getDefault().getEscapedCodeStr());

		assertThat( node3, instanceOf(PropertyElement.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)21), ((PropertyElement)node3).getNameChild());
		assertEquals( "buz", ((PropertyElement)node3).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)22), ((PropertyElement)node3).getDefault());
		assertEquals( "bonjour", ((PropertyElement)node3).getDefault().getEscapedCodeStr());

		assertThat( node4, instanceOf(PropertyElement.class));
		assertEquals( 2, node4.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((PropertyElement)node4).getNameChild());
		assertEquals( "qux", ((PropertyElement)node4).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)25), ((PropertyElement)node4).getDefault());
		assertEquals( "SOMECONSTANT", ((Constant)((PropertyElement)node4).getDefault()).getIdentifier().getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_CONST_ELEM nodes are used to denote the individual elements of a constant declaration
	 * statement, either on top level or within the scope of a class.
	 * They are the children of AST_CONST_DECL and AST_CLASS_CONST_DECL nodes;
	 * see descriptions of these.
	 *
	 * Any AST_CONST_ELEM node has exactly two children:
	 * 1) string, indicating the constant's name
	 * 2) various possible child types, representing the value
	 *    (e.g., node type could be "string", "integer", but also AST_CONST, etc.)
	 *
	 * This test checks a few constant elements' children in the following PHP code:
	 *
	 * const QUESTION = "any", ANSWER = 42;
	 */
	@Test
	public void testConstantElementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testConstantDeclaration");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(ConstantElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((ConstantElement)node).getNameChild());
		assertEquals( "QUESTION", ((ConstantElement)node).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((ConstantElement)node).getValue());
		assertEquals( "any", ((ConstantElement)node).getValue().getEscapedCodeStr());

		assertThat( node2, instanceOf(ConstantElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((ConstantElement)node2).getNameChild());
		assertEquals( "ANSWER", ((ConstantElement)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)12), ((ConstantElement)node2).getValue());
		assertEquals( "42", ((ConstantElement)node2).getValue().getEscapedCodeStr());
	}

	/**
	 * AST_USE_TRAIT nodes are used to denote trait use statements. They can optionally
	 * contain trait adaptations.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 *
	 * Any AST_USE_TRAIT node has exactly two children:
	 * 1) AST_NAME_LIST, holding a list of traits to be used
	 * 2) AST_TRAIT_ADAPTATIONS or NULL, representing the optional trait adaptations
	 *    for the used traits
	 *
	 * This test checks a use trait statement's children in the following PHP code:
	 *
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testUseTraitCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUseTrait");

		ASTNode node = ast.getNodeById((long)13);

		assertThat( node, instanceOf(UseTrait.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((UseTrait)node).getTraits());
		assertEquals( "Foo", ((UseTrait)node).getTraits().getIdentifier(0).getNameChild().getEscapedCodeStr());
		assertEquals( "Bar", ((UseTrait)node).getTraits().getIdentifier(1).getNameChild().getEscapedCodeStr());
		assertEquals( "Buz", ((UseTrait)node).getTraits().getIdentifier(2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)21), ((UseTrait)node).getTraitAdaptations());
	}

	/**
	 * AST_TRAIT_PRECEDENCE nodes are used to denote trait precedence statements within a
	 * trait use statement. Such statements are used to resolve conflicts when using
	 * several traits that declare the same method name and indicate which of these
	 * methods is to be used.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 *
	 * Any AST_TRAIT_PRECEDENCE node has exactly two children:
	 * 1) AST_METHOD_REFERENCE, representing the trait method to be used
	 * 2) AST_NAME_LIST, holding a list of trait names that declare the same
	 *    method name but whose method is not to be used
	 *
	 * This test checks a trait precedence statement's children in the following PHP code:
	 *
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testTraitPrecedenceCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUseTrait");

		ASTNode node = ast.getNodeById((long)33);

		assertThat( node, instanceOf(TraitPrecedence.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)34), ((TraitPrecedence)node).getMethod());
		assertEquals( ast.getNodeById((long)38), ((TraitPrecedence)node).getInsteadOf());
		assertEquals( "Bar", ((TraitPrecedence)node).getInsteadOf().getIdentifier(0).getNameChild().getEscapedCodeStr());
		assertEquals( "Buz", ((TraitPrecedence)node).getInsteadOf().getIdentifier(1).getNameChild().getEscapedCodeStr());
	}

	/**
	 * AST_METHOD_REFERENCE nodes are used to denote references to methods.
	 * They are composed of a reference to the class that declares the referenced method,
	 * and the method name. They appear as children of trait adaptation elements;
	 * see AST_TRAIT_ALIAS and AST_TRAIT_PRECEDENCE.
	 * (TODO check if they can appear in other contexts)
	 *
	 * Any AST_METHOD_REFERENCE node has exactly two children:
	 * 1) AST_NAME or NULL, representing the class that the referenced method is declared in
	 *    (or null if no class name is given)
	 * 2) string, indicating the method's name
	 *
	 * This test checks a few method references' children in the following PHP code:
	 *
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testMethodReferenceCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUseTrait");

		ASTNode node = ast.getNodeById((long)23);
		ASTNode node2 = ast.getNodeById((long)28);
		ASTNode node3 = ast.getNodeById((long)34);

		assertThat( node, instanceOf(MethodReference.class));
		assertEquals( 2, node.getChildCount());
		assertNull( ((MethodReference)node).getClassIdentifier());
		assertEquals( ast.getNodeById((long)25), ((MethodReference)node).getMethodName());
		assertEquals( "qux", ((MethodReference)node).getMethodName().getEscapedCodeStr());

		assertThat( node2, instanceOf(MethodReference.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)29), ((MethodReference)node2).getClassIdentifier());
		assertEquals( "Bar", ((MethodReference)node2).getClassIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)31), ((MethodReference)node2).getMethodName());
		assertEquals( "norf", ((MethodReference)node2).getMethodName().getEscapedCodeStr());

		assertThat( node3, instanceOf(MethodReference.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( ast.getNodeById((long)35), ((MethodReference)node3).getClassIdentifier());
		assertEquals( "Foo", ((MethodReference)node3).getClassIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)37), ((MethodReference)node3).getMethodName());
		assertEquals( "nicknack", ((MethodReference)node3).getMethodName().getEscapedCodeStr());
	}

	/**
	 * AST_NAMESPACE nodes are used to denote namespace statements. They are composed
	 * of a name and a compound statement. Either of these, but not both, may be null
	 * (a namespace  without a compound statement declares a namespace for the code
	 * following until the next namespace statement; a namespace without a name opens
	 * a "non-namespaced" scope)
	 * See  http://php.net/manual/en/language.namespaces.definitionmultiple.php
	 *
	 * Any AST_NAMESPACE node has exactly two children:
	 * 1) string or NULL, representing the namespace name
	 * 2) AST_STMT_LIST or NULL, holding the namespaced code
	 *
	 * This test checks a few use namespace statements' children in the following PHP code:
	 *
	 * namespace Foo {}
	 * namespace Bar;
	 * namespace {}
	 */
	@Test
	public void testNamespaceCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testNamespace");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)9);
		ASTNode node3 = ast.getNodeById((long)12);

		assertThat( node, instanceOf(NamespaceStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((NamespaceStatement)node).getName());
		assertEquals( "Foo", ((NamespaceStatement)node).getName().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)8), ((NamespaceStatement)node).getContent());

		assertThat( node2, instanceOf(NamespaceStatement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((NamespaceStatement)node2).getName());
		assertEquals( "Bar", ((NamespaceStatement)node2).getName().getEscapedCodeStr());
		assertNull( ((NamespaceStatement)node2).getContent());

		assertThat( node3, instanceOf(NamespaceStatement.class));
		assertEquals( 2, node3.getChildCount());
		assertNull( ((NamespaceStatement)node3).getName());
		assertEquals( ast.getNodeById((long)14), ((NamespaceStatement)node3).getContent());
	}

	/**
	 * AST_USE_ELEM nodes are used to denote individual use statement elements within a
	 * use statement. They are the children of AST_USE nodes.
	 *
	 * Any AST_USE_ELEM node has exactly two children:
	 * 1) string, representing the imported namespace
	 * 2) string or NULL, indicating the optional alias for the namespace
	 *
	 * This test checks a few use statement elements' children in the following PHP code:
	 *
	 * use Foo\Bar as Buz, Qux as Norf;
	 */
	@Test
	public void testUseElementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUse");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)10);

		assertThat( node, instanceOf(UseElement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)8), ((UseElement)node).getNamespace());
		assertEquals( "Foo\\Bar", ((UseElement)node).getNamespace().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((UseElement)node).getAlias());
		assertEquals( "Buz", ((UseElement)node).getAlias().getEscapedCodeStr());

		assertThat( node2, instanceOf(UseElement.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((UseElement)node2).getNamespace());
		assertEquals( "Qux", ((UseElement)node2).getNamespace().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)12), ((UseElement)node2).getAlias());
		assertEquals( "Norf", ((UseElement)node2).getAlias().getEscapedCodeStr());
	}

	/**
	 * AST_TRAIT_ALIAS nodes are used to denote trait alias statements within a
	 * trait use statement. Such statements are used to declare aliases for
	 * trait methods, or to change the visibility of trait methods.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 *
	 * Any AST_TRAIT_ALIAS node has exactly two children:
	 * 1) AST_METHOD_REFERENCE, representing the trait method being referenced
	 * 2) string or NULL, indicating: if it's a string, the alias name; or if it's NULL,
	 *    we are only changing a trait method's visibility without declaring an alias
	 *
	 * This test checks a few trait alias statements' children in the following PHP code:
	 *
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testTraitAliasCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUseTrait");

		ASTNode node = ast.getNodeById((long)22);
		ASTNode node2 = ast.getNodeById((long)27);

		assertThat( node, instanceOf(TraitAlias.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)23), ((TraitAlias)node).getMethod());
		assertEquals( ast.getNodeById((long)26), ((TraitAlias)node).getAlias());
		assertEquals( "_qux", ((TraitAlias)node).getAlias().getEscapedCodeStr());

		assertThat( node2, instanceOf(TraitAlias.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( ast.getNodeById((long)28), ((TraitAlias)node2).getMethod());
		assertNull( ((TraitAlias)node2).getAlias());
	}

	/**
	 * AST_GROUP_USE nodes are used to denote group use statements.
	 * This is a new feature in PHP 7, see
	 * http://php.net/manual/en/language.namespaces.importing.php#language.namespaces.importing.group
	 *
	 * Any AST_GROUP_USE node has exactly two children:
	 * 1) string, representing the prefix of the namespaces to be used
	 * 2) AST_USE, holding the used namespaces
	 *
	 * This test checks a group use statement's children in the following PHP code:
	 *
	 * use Foo\{Bar as B, Buz, Qux as Q};
	 */
	@Test
	public void testGroupUseCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testGroupUse");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(GroupUseStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((GroupUseStatement)node).getPrefix());
		assertEquals( "Foo", ((GroupUseStatement)node).getPrefix().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)8), ((GroupUseStatement)node).getUses());
	}


	/* nodes with exactly 3 children */

	/**
	 * AST_METHOD_CALL nodes are used to denote method call expressions.
	 *
	 * Any AST_METHOD_CALL node has exactly 3 children:
	 * 1) an expression node, representing the expression whose evaluation yields the
	 *    object that the target method belongs to
	 *    (e.g., could be AST_VAR, AST_CALL, AST_PROP, ...)
	 * 2) an expression node, representing the expression whose evaluation yields the
	 *    target method's name
	 *    (e.g., could be AST_VAR, "string", AST_BINARY_OP, ...)
	 * 3) AST_ARG_LIST, representing the argument list
	 *
	 * This test checks a few method call expressions' children in the following PHP code:
	 *
	 * $buz->foo($bar, "yabadabadoo");
	 * buz()->$foo($bar, "yabadabadoo");
	 */
	@Test
	public void testMethodCallCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testMethodCall");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)14);

		assertThat( node, instanceOf(MethodCallExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((MethodCallExpression)node).getTargetObject());
		assertEquals( "buz", ((Variable)((MethodCallExpression)node).getTargetObject()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((MethodCallExpression)node).getTargetFunc());
		assertEquals( "foo", ((MethodCallExpression)node).getTargetFunc().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)10), ((MethodCallExpression)node).getArgumentList());
		assertEquals( 2, ((MethodCallExpression)node).getArgumentList().size());

		assertThat( node2, instanceOf(MethodCallExpression.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)15), ((MethodCallExpression)node2).getTargetObject());
		assertEquals( "buz", ((Identifier)((CallExpressionBase)((MethodCallExpression)node2).getTargetObject()).getTargetFunc()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)19), ((MethodCallExpression)node2).getTargetFunc());
		assertEquals( "foo", ((Variable)((MethodCallExpression)node2).getTargetFunc()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)21), ((MethodCallExpression)node2).getArgumentList());
		assertEquals( 2, ((MethodCallExpression)node2).getArgumentList().size());
	}

	/**
	 * AST_STATIC_CALL nodes are used to denote static call expressions.
	 *
	 * Any AST_STATIC_CALL node has exactly 3 children:
	 * 1) an expression, whose evaluation holds the class name that the static target method belongs to
	 *    (e.g., could be AST_NAME, AST_VAR, etc...)
	 * 2) an expression, whose evaluation holds the static method's name within the class
	 *    (e.g., could be string, AST_DIM, etc...)
	 * 3) AST_ARG_LIST, representing the argument list
	 *
	 * This test checks a few static call expressions' children in the following PHP code:
	 *
	 * Foo::bar($buz);
	 * $qux::{norf[42]}();
	 */
	@Test
	public void testStaticCallCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testStaticCall");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)13);

		assertThat( node, instanceOf(StaticCallExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((StaticCallExpression)node).getTargetClass());
		assertEquals( "Foo", ((Identifier)((StaticCallExpression)node).getTargetClass()).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)9), ((StaticCallExpression)node).getTargetFunc());
		assertEquals( "bar", ((StaticCallExpression)node).getTargetFunc().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)10), ((StaticCallExpression)node).getArgumentList());

		assertThat( node2, instanceOf(StaticCallExpression.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((StaticCallExpression)node2).getTargetClass());
		assertEquals( "qux", ((StringExpression)((Variable)((StaticCallExpression)node2).getTargetClass()).getNameExpression()).getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)16), ((StaticCallExpression)node2).getTargetFunc());
		assertEquals( "norf", ((Variable)((ArrayIndexing)((StaticCallExpression)node2).getTargetFunc()).getArrayExpression()).getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)20), ((StaticCallExpression)node2).getArgumentList());
	}

	/**
	 * AST_CONDITIONAL nodes are used to represent conditional expressions using the ?: operator,
	 * also known as the ternary conditional operator.
	 *
	 * Any AST_CONDITIONAL node has exactly three children:
	 * 1) an expression representing the conditional
	 * 2) an expression representing the true branch, or NULL
	 * 3) an expression representing the false branch
	 *
	 * This test checks a conditional expression's children in the following PHP code:
	 *
	 * true ? "foo" : "bar";
	 */
	@Test
	public void testConditionalCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testConditional");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ConditionalExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ConditionalExpression)node).getCondition());
		assertEquals( ast.getNodeById((long)10), ((ConditionalExpression)node).getTrueExpression());
		assertEquals( ast.getNodeById((long)11), ((ConditionalExpression)node).getFalseExpression());
	}

	/**
	 * AST_TRY nodes are used for try statements.
	 *
	 * Any AST_TRY node has exactly three children:
	 * 1) AST_STMT_LIST, representing the code to be "tried"
	 * 2) AST_CATCH_LIST, representing the list of catch statements, i.e.,
	 *    the list of caught exceptions.
	 * 3) AST_STMT_LIST or NULL, representing a finally statement, if it exists.
	 *
	 * This test checks a few catch statements' children in the following PHP code:
	 *
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testTryCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testTry");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(TryStatement.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((TryStatement)node).getContent());
		assertEquals( ast.getNodeById((long)8), ((TryStatement)node).getCatchList());
		assertEquals( ast.getNodeById((long)21), ((TryStatement)node).getFinallyContent());
	}

	/**
	 * AST_CATCH nodes are used for catch statements.
	 *
	 * Any AST_CATCH node has exactly three children:
	 * 1) AST_NAME, representing the exception's name
	 * 2) string, indicating the variable name holding the exception
	 * 3) AST_STMT_LIST, representing the catch statement's content
	 *
	 * This test checks a few catch statements' children in the following PHP code:
	 *
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testCatchCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testTry");

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)15);

		assertThat( node, instanceOf(CatchStatement.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)10), ((CatchStatement)node).getExceptionIdentifier());
		assertEquals( ast.getNodeById((long)11), ((CatchStatement)node).getExceptionIdentifier().getNameChild());
		assertEquals( "FooException", ((CatchStatement)node).getExceptionIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)12), ((CatchStatement)node).getVariable());
		assertEquals( ast.getNodeById((long)13), ((CatchStatement)node).getVariable().getNameExpression());
		assertEquals( "f", ((CatchStatement)node).getVariable().getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)14), ((CatchStatement)node).getContent());

		assertThat( node2, instanceOf(CatchStatement.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((CatchStatement)node2).getExceptionIdentifier());
		assertEquals( ast.getNodeById((long)17), ((CatchStatement)node2).getExceptionIdentifier().getNameChild());
		assertEquals( "BarException", ((CatchStatement)node2).getExceptionIdentifier().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)18), ((CatchStatement)node2).getVariable());
		assertEquals( ast.getNodeById((long)19), ((CatchStatement)node2).getVariable().getNameExpression());
		assertEquals( "b", ((CatchStatement)node2).getVariable().getNameExpression().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)20), ((CatchStatement)node2).getContent());
	}

	/**
	 * AST_PARAM nodes are used for function parameters.
	 *
	 * Any AST_PARAM node has exactly three children:
	 * 1) AST_NAME or NULL, representing the parameter's type
	 * 2) string, indicating the parameter's name
	 * 3) various possible child types, representing the default value
	 *    (e.g., node type could be "NULL", "string", "integer", but also AST_CONST, etc.)
	 *
	 * This test checks a parameter's children in the following PHP code:
	 *
	 * function foo(int $bar = 3, string $buz = "yabadabadoo") {}
	 */
	@Test
	public void testParameterCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testParameterList");

		ASTNode node = ast.getNodeById((long)10);
		ASTNode node2 = ast.getNodeById((long)15);

		assertThat( node, instanceOf(Parameter.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( ast.getNodeById((long)11), ((Parameter)node).getType());
		assertEquals( ast.getNodeById((long)12), ((Parameter)node).getType().getNameChild());
		assertEquals( "int", ((Parameter)node).getType().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)13), ((Parameter)node).getNameChild());
		assertEquals( "bar", ((Parameter)node).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)14), ((Parameter)node).getDefault());
		assertEquals( "3", ((Parameter)node).getDefault().getEscapedCodeStr());

		assertThat( node2, instanceOf(Parameter.class));
		assertEquals( 3, node2.getChildCount());
		assertEquals( ast.getNodeById((long)16), ((Parameter)node2).getType());
		assertEquals( ast.getNodeById((long)17), ((Parameter)node2).getType().getNameChild());
		assertEquals( "string", ((Parameter)node2).getType().getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)18), ((Parameter)node2).getNameChild());
		assertEquals( "buz", ((Parameter)node2).getNameChild().getEscapedCodeStr());
		assertEquals( ast.getNodeById((long)19), ((Parameter)node2).getDefault());
		assertEquals( "yabadabadoo", ((Parameter)node2).getDefault().getEscapedCodeStr());
	}


	/* nodes with exactly 4 children */

	/**
	 * AST_FOR nodes are used to declare for-loops.
	 *
	 * Any AST_FOR node has exactly four children:
	 * 1) AST_EXPR_LIST or NULL, representing the list of expressions
	 *    used to initialize the loop
	 * 2) AST_EXPR_LIST or NULL, representing the list of expressions
	 *    in the loop's guard, used to check whether to continue iterating
	 * 3) AST_EXPR_LIST or NULL, representing the list of expressions
	 *    used to increment or otherwise modify variables in each step
	 * 4) statement node or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 *
	 * This test checks a for loop's children in the following PHP code:
	 *
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */
	@Test
	public void testForCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testFor");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ForStatement.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ForStatement)node).getForInitExpression());
		assertEquals( ast.getNodeById((long)16), ((ForStatement)node).getCondition());
		assertEquals( ast.getNodeById((long)21), ((ForStatement)node).getForLoopExpression());
		assertEquals( ast.getNodeById((long)28), ((ForStatement)node).getStatement());
	}

	/**
	 * AST_FOREACH nodes are used to declare foreach-loops.
	 *
	 * Any AST_FOREACH node has exactly four children:
	 * 1) an expression, representing the array or object to be iterated over
	 *    (e.g., could be AST_VAR, AST_CALL, AST_CONST, etc...)
	 * 2) an expression, representing the value of the current element
	 *    (typically AST_VAR or AST_REF, but could also be AST_PROP etc...) 
	 * 3) an expression or NULL, representing the value of the current element
	 *    (typically AST_VAR or NULL, but could also be AST_PROP etc...) 
	 * 4) statement types or NULL, representing the code in the loop's body
	 *    (e.g., could be AST_STMT_LIST, AST_CALL, etc...)
	 *
	 * This test checks a foreach loop's children in the following PHP code:
	 *
	 * foreach ($somearray as $foo) {}
	 * foreach (somecall() as $bar => $buz) {}
	 * foreach ($someobj->qux as $someobj->norf => $someobj->nicknack) {}
	 */
	@Test
	public void testForEachCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testForEach");

		ASTNode node = ast.getNodeById((long)6);
		ASTNode node2 = ast.getNodeById((long)13);
		ASTNode node3 = ast.getNodeById((long)23);

		assertThat( node, instanceOf(ForEachStatement.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( ast.getNodeById((long)7), ((ForEachStatement)node).getIteratedObject());
		assertEquals( ast.getNodeById((long)9), ((ForEachStatement)node).getValueExpression());
		assertNull( ((ForEachStatement)node).getKeyExpression());
		assertEquals( ast.getNodeById((long)12), ((ForEachStatement)node).getStatement());

		assertThat( node2, instanceOf(ForEachStatement.class));
		assertEquals( 4, node2.getChildCount());
		assertEquals( ast.getNodeById((long)14), ((ForEachStatement)node2).getIteratedObject());
		assertEquals( ast.getNodeById((long)18), ((ForEachStatement)node2).getValueExpression());
		assertEquals( ast.getNodeById((long)20), ((ForEachStatement)node2).getKeyExpression());
		assertEquals( ast.getNodeById((long)22), ((ForEachStatement)node2).getStatement());
		
		assertThat( node3, instanceOf(ForEachStatement.class));
		assertEquals( 4, node3.getChildCount());
		assertEquals( ast.getNodeById((long)24), ((ForEachStatement)node3).getIteratedObject());
		assertEquals( ast.getNodeById((long)28), ((ForEachStatement)node3).getValueExpression());
		assertEquals( ast.getNodeById((long)32), ((ForEachStatement)node3).getKeyExpression());
		assertEquals( ast.getNodeById((long)36), ((ForEachStatement)node3).getStatement());
	}


	/* nodes with an arbitrary number of children */

	/**
	 * AST_ARG_LIST nodes are used to denote a list of arguments in a function call.
	 *
	 * Any AST_ARG_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one argument in the list.
	 *
	 * This test checks a few argument lists' children in the following PHP code:
	 *
	 * foo($bar, "yabadabadoo");
	 * $buz(1);
	 */
	@Test
	public void testArgumentListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testCall");

		ASTNode node = ast.getNodeById((long)9);
		ASTNode node2 = ast.getNodeById((long)16);

		assertThat( node, instanceOf(ArgumentList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ArgumentList)node).size());
		assertEquals( ast.getNodeById((long)10), ((ArgumentList)node).getArgument(0));
		assertEquals( ast.getNodeById((long)12), ((ArgumentList)node).getArgument(1));
		for( ASTNode argument : (ArgumentList)node)
			assertTrue( ast.containsValue(argument));

		assertThat( node2, instanceOf(ArgumentList.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( 1, ((ArgumentList)node2).size());
		assertEquals( ast.getNodeById((long)17), ((ArgumentList)node2).getArgument(0));
		for( ASTNode argument : (ArgumentList)node)
			assertTrue( ast.containsValue(argument));
	}

	/**
	 * AST_LIST nodes are used to denote PHP list expressions.
	 *
	 * Any AST_LIST node has between 1 and an arbitrarily large number of children.
	 * (Note: an empty list will generate an implicit NULL node child,
	 * see TestPHPCSVASTBuilderMinimal.testMinimalListCreation()).
	 * Each child corresponds to one element in the list.
	 *
	 * This test checks a few PHP list expressions' children in the following PHP code:
	 *
	 * list($a, , list($c, $d)) = array("foo", "bar", array("buz", "qux"));
	 */
	@Test
	public void testListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testList");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)11);

		assertThat( node, instanceOf(ListExpression.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( 3, ((ListExpression)node).size());
		assertEquals( ast.getNodeById((long)8), ((ListExpression)node).getElement(0));
		assertNull( ((ListExpression)node).getElement(1));
		assertEquals( ast.getNodeById((long)11), ((ListExpression)node).getElement(2));
		for( Expression element : (ListExpression)node)
			assertTrue( null == element || ast.containsValue(element));

		assertThat( node2, instanceOf(ListExpression.class));
		assertEquals( 2, node2.getChildCount());
		assertEquals( 2, ((ListExpression)node2).size());
		assertEquals( ast.getNodeById((long)12), ((ListExpression)node2).getElement(0));
		assertEquals( ast.getNodeById((long)14), ((ListExpression)node2).getElement(1));
		for( Expression element : (ListExpression)node2)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_ARRAY nodes are used to denote array declaration expressions.
	 *
	 * Any AST_ARRAY node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the array.
	 *
	 * This test checks an array expression's children in the following PHP code:
	 *
	 * array("key1" => 42,
	 *       2 => "foo",
	 *       aconst => $bar,
	 *       buz());
	 */
	@Test
	public void testArrayCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testArray");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ArrayExpression.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((ArrayExpression)node).size());
		assertEquals( ast.getNodeById((long)7), ((ArrayExpression)node).getArrayElement(0));
		assertEquals( ast.getNodeById((long)10), ((ArrayExpression)node).getArrayElement(1));
		assertEquals( ast.getNodeById((long)13), ((ArrayExpression)node).getArrayElement(2));
		assertEquals( ast.getNodeById((long)19), ((ArrayExpression)node).getArrayElement(3));
		for( ArrayElement element : (ArrayExpression)node)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_ENCAPS_LIST nodes are used for holding strings with variables,
	 * i.e., non-constant strings wherein variable expansion occurs.
	 * See http://php.net/manual/en/language.types.string.php#language.types.string.parsing
	 *
	 * Any AST_ENCAPS_LIST node has between 1 and an arbitrarily large number
	 * of children. Each child is either (a) a "string" node; or (b) an AST_VAR node;
	 * or (c) an AST_DIM node; or (d) an AST_PROP node.
	 *
	 * This test checks an encapsulated list's children in the following PHP code:
	 *
	 * "Hello {$foo}, {$bar['somekey']} and {$buz->qux}!";
	 */
	@Test
	public void testEncapsulatedList() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testEncapsulatedList");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(EncapsListExpression.class));
		assertEquals( 7, node.getChildCount());
		assertEquals( 7, ((EncapsListExpression)node).size());
		assertEquals( ast.getNodeById((long)7), ((EncapsListExpression)node).getElement(0));
		assertEquals( ast.getNodeById((long)8), ((EncapsListExpression)node).getElement(1));
		assertEquals( ast.getNodeById((long)10), ((EncapsListExpression)node).getElement(2));
		assertEquals( ast.getNodeById((long)11), ((EncapsListExpression)node).getElement(3));
		assertEquals( ast.getNodeById((long)15), ((EncapsListExpression)node).getElement(4));
		assertEquals( ast.getNodeById((long)16), ((EncapsListExpression)node).getElement(5));
		assertEquals( ast.getNodeById((long)20), ((EncapsListExpression)node).getElement(6));
		for( Expression element : (EncapsListExpression)node)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_EXPR_LIST nodes are used for holding a list of expressions, e.g.,
	 * a list of initializations in a for-loop.
	 *
	 * Any AST_EXPR_LIST node has between 1 and an arbitrarily large number
	 * of children. Each child corresponds to one expression in the list.
	 * TODO I am not sure at the moment whether there are situations where
	 * an AST_EXPR_LIST with 0 children can be generated; I do not think so,
	 * but look into it more closely.
	 *
	 * This test checks an expression list's children in the following PHP code:
	 *
	 * for ($i = 0, $j = 1; $i < 3; $i++, $j++) {}
	 */
	@Test
	public void testExpressionList() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testFor");

		ASTNode node = ast.getNodeById((long)7);
		ASTNode node2 = ast.getNodeById((long)16);
		ASTNode node3 = ast.getNodeById((long)21);

		assertThat( node, instanceOf(ExpressionList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ExpressionList)node).size());
		assertEquals( ast.getNodeById((long)8), ((ExpressionList)node).getExpression(0));
		assertEquals( ast.getNodeById((long)12), ((ExpressionList)node).getExpression(1));
		for( Expression expression : (ExpressionList)node)
			assertTrue( ast.containsValue(expression));

		assertThat( node2, instanceOf(ExpressionList.class));
		assertEquals( 1, node2.getChildCount());
		assertEquals( 1, ((ExpressionList)node2).size());
		assertEquals( ast.getNodeById((long)17), ((ExpressionList)node2).getExpression(0));
		for( Expression expression : (ExpressionList)node2)
			assertTrue( ast.containsValue(expression));

		assertThat( node3, instanceOf(ExpressionList.class));
		assertEquals( 2, node3.getChildCount());
		assertEquals( 2, ((ExpressionList)node3).size());
		assertEquals( ast.getNodeById((long)22), ((ExpressionList)node3).getExpression(0));
		assertEquals( ast.getNodeById((long)25), ((ExpressionList)node3).getExpression(1));
		for( Expression expression : (ExpressionList)node3)
			assertTrue( ast.containsValue(expression));
	}

	/**
	 * AST_STMT_LIST nodes are used to declare lists (or "blocks") of statements.
	 *
	 * Any AST_STMT_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one statement in the list.
	 *
	 * This test checks statements lists' children in the following PHP code:
	 *
	 * function foo() {}
	 * foo();
	 */
	@Test
	public void testCompoundStatementCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testCompoundStatement");

		ASTNode node = ast.getNodeById((long)5);
		ASTNode node2 = ast.getNodeById((long)11);

		assertThat( node, instanceOf(CompoundStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((CompoundStatement)node).size());
		assertEquals( ast.getNodeById((long)6), ((CompoundStatement)node).getStatement(0));
		assertEquals( ast.getNodeById((long)13), ((CompoundStatement)node).getStatement(1));
		for( ASTNode stmt : (CompoundStatement)node)
			assertTrue( ast.containsValue(stmt));

		assertThat( node2, instanceOf(CompoundStatement.class));
		assertEquals( 0, node2.getChildCount());
		assertEquals( 0, ((CompoundStatement)node2).size());
		for( ASTNode stmt : (CompoundStatement)node2)
			assertTrue( ast.containsValue(stmt));
	}

	/**
	 * AST_IF nodes are used to denote if-statements.
	 *
	 * Any AST_IF node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one if-element. Such if-elements are composed of an
	 * expression and a statement (see description of AST_IF_ELEM). The PHP interpreter
	 * simply goes through the list of if-elements in order and evaluates the if-elements'
	 * expressions until the first such expression evaluates to true. Then, the
	 * corresponding statement is executed. This allows to represent if-statements with
	 * multiple 'elseif' constructs in a flat hierarchy, instead of an arbitrarily deep
	 * nesting that would be obtained when using 'else if' instead.
	 *
	 * This test checks an if-statement's children in the following PHP code:
	 *
	 * if($foo) {}
	 * elseif($bar) {}
	 * elseif($buz) {}
	 * else {}
	 */
	@Test
	public void testIfCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testIf");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(IfStatement.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((IfStatement)node).size());
		assertEquals( ast.getNodeById((long)7), ((IfStatement)node).getIfElement(0));
		assertEquals( ast.getNodeById((long)11), ((IfStatement)node).getIfElement(1));
		assertEquals( ast.getNodeById((long)15), ((IfStatement)node).getIfElement(2));
		assertEquals( ast.getNodeById((long)19), ((IfStatement)node).getIfElement(3));
	}

	/**
	 * AST_SWITCH_LIST nodes are used to denote a list of switch-elements.
	 *
	 * Any AST_SWITCH_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one switch-case. Such switch-cases are composed of a
	 * value and a statement list (see description of AST_SWITCH_CASE). AST_SWITCH_LIST nodes
	 * are always a child of AST_SWITCH nodes, and always have exactly one sister which
	 * represents an expression whose evaluated form is matched against the values of the
	 * AST_SWITCH_CASE children (see description of AST_SWITCH).
	 *
	 * This test checks a switch list's children in the following PHP code:
	 *
	 * switch ($i) {
	 *   case "foo":
	 *     break;
	 *   case 1.42:
	 *   case 2:
	 *     break;
	 *   default:
	 *     buz();
	 * }
	 */
	@Test
	public void testSwitchListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testSwitch");

		ASTNode node = ast.getNodeById((long)9);

		assertThat( node, instanceOf(SwitchList.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((SwitchList)node).size());

		assertEquals( ast.getNodeById((long)10), ((SwitchList)node).getSwitchCase(0));
		assertEquals( ast.getNodeById((long)15), ((SwitchList)node).getSwitchCase(1));
		assertEquals( ast.getNodeById((long)18), ((SwitchList)node).getSwitchCase(2));
		assertEquals( ast.getNodeById((long)23), ((SwitchList)node).getSwitchCase(3));
		for( SwitchCase switchcase : (SwitchList)node)
			assertTrue( ast.containsValue(switchcase));
	}

	/**
	 * AST_CATCH_LIST nodes are used to denote a list of catch statements.
	 *
	 * Any AST_CATCH_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one catch statement in the list.
	 *
	 * This test checks a catch list's children in the following PHP code:
	 *
	 * try {}
	 * catch(FooException $f) {}
	 * catch(BarException $b) {}
	 * finally {}
	 */
	@Test
	public void testCatchListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testTry");

		ASTNode node = ast.getNodeById((long)8);

		assertThat( node, instanceOf(CatchList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((CatchList)node).size());

		assertEquals( ast.getNodeById((long)9), ((CatchList)node).getCatchStatement(0));
		assertEquals( ast.getNodeById((long)15), ((CatchList)node).getCatchStatement(1));
		for( CatchStatement catchstatement : (CatchList)node)
			assertTrue( ast.containsValue(catchstatement));
	}

	/**
	 * AST_PARAM_LIST nodes are used to denote a list of function parameters.
	 *
	 * Any AST_PARAM_LIST node has between 0 and an arbitrarily large number of children.
	 * Each child corresponds to one parameter in the list.
	 *
	 * This test checks a parameter list's children in the following PHP code:
	 *
	 * function foo(int $bar = 3, string $buz = "yabadabadoo") {}
	 */
	@Test
	public void testParameterListCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testParameterList");

		ASTNode node = ast.getNodeById((long)9);

		assertThat( node, instanceOf(ParameterList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ParameterList)node).size());
		assertEquals( ast.getNodeById((long)10), ((ParameterList)node).getParameter(0));
		assertEquals( ast.getNodeById((long)15), ((ParameterList)node).getParameter(1));
		for( ParameterBase parameter : (ParameterList)node)
			assertTrue( ast.containsValue(parameter));
	}

	/**
	 * AST_CLOSURE_USES nodes are used for holding a list of variables that
	 * occur within the 'use' language construct of closure declarations.
	 *
	 * Any AST_CLOSURE_USES node has between 1 and an arbitrarily large number
	 * of children. Each child corresponds to one closure variable in the list.
	 * (It cannot have 0 children as the 'use' construct can only be used in
	 * conjunction with at least 1 variable name.)
	 *
	 * This test checks a closure 'uses' list's children in the following PHP code:
	 *
	 * function() use ($foo,$bar) {};
	 */
	@Test
	public void testClosureUsesCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClosureVar");

		ASTNode node = ast.getNodeById((long)10);

		assertThat( node, instanceOf(ClosureUses.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ClosureUses)node).size());
		assertEquals( ast.getNodeById((long)11), ((ClosureUses)node).getClosureVar(0));
		assertEquals( ast.getNodeById((long)13), ((ClosureUses)node).getClosureVar(1));
		for( ClosureVar closurevar : (ClosureUses)node)
			assertTrue( ast.containsValue(closurevar));
	}

	/**
	 * AST_PROP_DECL nodes are used to denote property declaration statements
	 * in the top-level scope of a class.
	 *
	 * Any AST_PROP_DECL node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the property declaration statement.
	 *
	 * This test checks a property declaration statement's children in the following PHP code:
	 *
	 * class Foo {
	 *   public $foo, $bar = 3, $buz = "bonjour", $qux = SOMECONSTANT;
	 * }
	 */
	@Test
	public void testPropertyDeclarationCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testPropertyDeclaration");

		ASTNode node = ast.getNodeById((long)13);

		assertThat( node, instanceOf(PropertyDeclaration.class));
		assertEquals( 4, node.getChildCount());
		assertEquals( 4, ((PropertyDeclaration)node).size());
		assertEquals( ast.getNodeById((long)14), ((PropertyDeclaration)node).getPropertyElement(0));
		assertEquals( ast.getNodeById((long)17), ((PropertyDeclaration)node).getPropertyElement(1));
		assertEquals( ast.getNodeById((long)20), ((PropertyDeclaration)node).getPropertyElement(2));
		assertEquals( ast.getNodeById((long)23), ((PropertyDeclaration)node).getPropertyElement(3));
		for( PropertyElement element : (PropertyDeclaration)node)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_CONST_DECL nodes are used to denote constant declaration statements
	 * in top-level code.
	 *
	 * Any AST_CONST_DECL node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the constant declaration statement.
	 *
	 * This test checks a constant declaration statement's children in the following PHP code:
	 *
	 * const QUESTION = "any", ANSWER = 42;
	 */
	@Test
	public void testConstantDeclarationCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testConstantDeclaration");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(ConstantDeclaration.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ConstantDeclaration)node).size());
		assertEquals( ast.getNodeById((long)7), ((ConstantDeclaration)node).getConstantElement(0));
		assertEquals( ast.getNodeById((long)10), ((ConstantDeclaration)node).getConstantElement(1));
		for( ConstantElement element : (ConstantDeclaration)node)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_CLASS_CONST_DECL nodes are used to denote class constant declaration statements
	 * in the top-level scope of a class.
	 *
	 * Any AST_CLASS_CONST_DECL node has between 1 and an arbitrarily large number of children.
	 * Each child corresponds to one element in the class constant declaration statement.
	 *
	 * This test checks a class constant declaration statement's children in the following PHP code:
	 *
	 * class Foo {
	 *   const QUESTION = "any", ANSWER = 42;
	 * }
	 */
	@Test
	public void testClassConstantDeclarationCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testClassConstantDeclaration");

		ASTNode node = ast.getNodeById((long)13);

		assertThat( node, instanceOf(ClassConstantDeclaration.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((ClassConstantDeclaration)node).size());
		assertEquals( ast.getNodeById((long)14), ((ClassConstantDeclaration)node).getConstantElement(0));
		assertEquals( ast.getNodeById((long)17), ((ClassConstantDeclaration)node).getConstantElement(1));
		for( ConstantElement element : (ClassConstantDeclaration)node)
			assertTrue( ast.containsValue(element));
	}

	/**
	 * AST_NAME_LIST nodes are used for holding a list of identifiers, e.g.,
	 * a list of names referring to interfaces that a class extends.
	 *
	 * Any AST_NAME_LIST node has between 1 and an arbitrarily large number
	 * of children. Each child corresponds to one identifier in the list.
	 * TODO I am not sure at the moment whether there are situations where
	 * an AST_NAME_LIST with 0 children can be generated; I do not think so,
	 * but look into it more closely.
	 *
	 * This test checks an identifier list's children in the following PHP code:
	 *
	 * class foo extends bar implements buz, qux {}
	 */
	@Test
	public void testIdentifierList() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testIdentifierList");

		ASTNode node = ast.getNodeById((long)9);

		assertThat( node, instanceOf(IdentifierList.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((IdentifierList)node).size());
		assertEquals( ast.getNodeById((long)10), ((IdentifierList)node).getIdentifier(0));
		assertEquals( ast.getNodeById((long)12), ((IdentifierList)node).getIdentifier(1));
		for( Identifier identifier : (IdentifierList)node)
			assertTrue( ast.containsValue(identifier));
	}

	/**
	 * AST_TRAIT_ADAPTATIONS nodes are used for holding a list of trait adaptations, i.e.,
	 * a list of AST_TRAIT_ALIAS and AST_TRAIT_PRECEDENCE nodes.
	 * See http://php.net/manual/en/language.oop5.traits.php
	 *
	 * Any AST_TRAIT_ADAPTATIONS node has between 1 and an arbitrarily large number
	 * of trait adaptations. Each child corresponds to one trait adaptation in the list.
	 *
	 * This test checks a trait adaptations statement's children in the following PHP code:
	 *
	 * class SomeClass {
	 *   use Foo, Bar, Buz {
	 *     qux as protected _qux;
	 *     Bar::norf as private;
	 *     Foo::nicknack insteadof Bar, Buz;
	 *   }
	 * }
	 */
	@Test
	public void testTraitAdaptations() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUseTrait");

		ASTNode node = ast.getNodeById((long)21);

		assertThat( node, instanceOf(TraitAdaptations.class));
		assertEquals( 3, node.getChildCount());
		assertEquals( 3, ((TraitAdaptations)node).size());
		assertEquals( ast.getNodeById((long)22), ((TraitAdaptations)node).getTraitAdaptationElement(0));
		assertEquals( ast.getNodeById((long)27), ((TraitAdaptations)node).getTraitAdaptationElement(1));
		assertEquals( ast.getNodeById((long)33), ((TraitAdaptations)node).getTraitAdaptationElement(2));
		for( TraitAdaptationElement traitAdaptation : (TraitAdaptations)node)
			assertTrue( ast.containsValue(traitAdaptation));
	}

	/**
	 * AST_USE nodes are used to denote use statements.
	 *
	 * Any AST_USE node has between 1 and an arbitrarily large number
	 * of use statement elements. Each child corresponds to one use element in the list.
	 *
	 * This test checks a use statement's children in the following PHP code:
	 *
	 * use Foo\Bar as Buz, Qux as Norf;
	 */
	@Test
	public void testUseCreation() throws IOException, InvalidCSVFile
	{
		handleCSVFiles( "testUse");

		ASTNode node = ast.getNodeById((long)6);

		assertThat( node, instanceOf(UseStatement.class));
		assertEquals( 2, node.getChildCount());
		assertEquals( 2, ((UseStatement)node).size());
		assertEquals( ast.getNodeById((long)7), ((UseStatement)node).getUseElement(0));
		assertEquals( ast.getNodeById((long)10), ((UseStatement)node).getUseElement(1));
		for( UseElement useElement : (UseStatement)node)
			assertTrue( ast.containsValue(useElement));
	}
}
