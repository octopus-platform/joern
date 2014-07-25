Database Overview
==================

In this section, we give an overview of the database layout created by
Joern, i.e., the nodes, properties and edges that make up the code
property graph. The code property graph created by Joern matches that
of the code property graph as described in the paper and merely
introduces some additional nodes and edges that have turned out to be
convenient in practice.

Code Property Graphs
--------------------

For each function of the code base, the database stores a code
property graph consisting of the following nodes.

**Function nodes (type: Function).** A node for each function
(i.e. procedure) is created. The function-node itself only holds the
function name and signature, however, it can be used to obtain the
respective Abstract Syntax Tree and Control Flow Graph of the
function.

**Abstract Syntax Tree Nodes (type:various).** Abstract syntax trees
represent the syntactical structure of the code. They are the
representation of choice when language constructs such as function
calls, assignments or cast-expressions need to be located. Moreover,
this hierarchical representation exposes how language constructs are
composed to form larger constructs. For example, a statement may
consist of an assignment expression, which itself consists of a left-
and right value where the right value may contain a multiplicative
expression (see `Wikepedia: Abstract Syntax Tree
<http://en.wikipedia.org/wiki/Abstract_syntax_tree>`_ for more
information). Abstract syntax tree nodes are connected to their child
nodes with ``IS_AST_PARENT_OF`` edges. Moreover, the corresponding
function node is connected to the AST root node by a
``IS_FUNCTION_OF_AST`` edge.

**Statement Nodes (type:various).** This is a sub-set of the Abstract
Syntax Tree Nodes. Statement nodes are marked using the property
``isCFGNode`` with value ``true``. Statement nodes are connected to
other statement nodes via ``FLOWS_TO`` and ``REACHES`` edges to
indicate control and data flow respectively.

**Symbol nodes (type:Symbol).** Data flow analysis is always
performed with respect to a variable. Since our fuzzy parser needs
to work even if declarations contained in header-files are missing,
we will often encounter the situation where a *symbol* is used,
which has not previously been declared. We approach this problem by
creating *symbol* nodes for each identifier we encounter regardless
of whether a declaration for this symbol is known or not. We also
introduce symbols for postfix expressions such as ``a->b`` to allow us
to track the use of fields of structures. Symbol nodes are connected
to all statement nodes using the symbol by ``USE``-edges and to all
statement nodes assigning to the symbol (i.e., *defining* the symbol})
by ``DEF``-edges.

Code property graphs of individual functions are linked in various
ways to allow transition from one function to another as discussed in
the next section.

Global Code Structure
----------------------

In addition, to the nodes created for functions, the source file
hierarchy, as well as global type and variable declarations are
represented as follows.

**File and Directory Nodes (type:File/Directory).** The
directory hierarchy is exposed by creating a node for each file and
directory and connecting these nodes using ``IS_PARENT_DIR_OF`` and
``IS_FILE_OF`` edges. This *source tree* allows code to
be located by its location in the filesystem directory hierarchy,
for example, this allows you to limit your analysis to functions
contained in a specified sub-directory.

**Struct/Class declaration nodes (type: Class).** A
Class-node is created for each structure/class identified and
connected to file-nodes by ``IS_FILE_OF`` edges. The members
of the class, i.e., attribute and method declarations are
connected to class-nodes by ``IS_CLASS_OF`` edges.

**Variable declaration nodes (type: DeclStmt).** Finally, declarations
of global variables are saved in declaration statement nodes and
connected to the source file they are contained in using
``IS_FILE_OF`` edges.

The Node Index
---------------

In addition to the graphs stored in the Neo4J database, Joern makes an
Apache Lucene Index available that allows nodes to be quickly
retrieved based on their properties. This is particularly useful to
select start nodes for graph database traversals. For examples of node
index usage, refer to :doc:`querying`.
