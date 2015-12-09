package ast;

/*
 * This is a dummy "placeholder" node.
 * It is mainly used as dummy child for nodes with a fixed number of children
 * that do not need a certain child in a given context, to keep
 * the number of their children constant
 * (e.g., a function node that does not specify its return type in
 * its declaration; see TestPHPCSVASTBuilderMinimal for more examples.)
 */
public class NullNode extends ASTNode
{
}
