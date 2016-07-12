Parsing
=======

In addition to offering a tool to automatically parse and import code
into a graph database (`joern-import`), joern provides a tool to parse
code and store its intermediate graph representation in a text
file. The fuzzy parser can thus be used without the graph database
backend, e.g., to provide input for other standalone code analysis
tools.

To parse source code in the directory $codeDir, simply invoke
`joern-parse` as follows.

.. code-block:: none

	./joern-parse $codeDir


This will create a directory named `parsed`, which contains two files
for each source file: a node file (`nodes.csv`) and an edge file
(`edges.csv`).
