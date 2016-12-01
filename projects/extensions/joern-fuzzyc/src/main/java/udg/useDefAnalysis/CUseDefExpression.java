package udg.useDefAnalysis;

public class CUseDefExpression {
    /**
     * Eliminate redundant "& * " and "* & " patterns that can occur in
     * dynamically generated UseDef references.
     */
    public static String simplify(String expr)
    {
        return expr.replace("& * ", "").replace("* & ", "");
    }
}
