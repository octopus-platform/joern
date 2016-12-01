Parsing and Importing Code
==========================

Importing code
--------------

Once joern has been installed, you can start the server and begin to
import code into the database by executing `joern-import`. In one
terminal, execute the joern server:

.. code-block:: none

	cd $JOERN
	./joern-server

where `$JOERN` is the joern root directory. In a second terminal,
import the code as follows

.. code-block:: none

	`cd $JOERN`
	`tar -cvf testCode.tar.gz testCode`
	`joern-import testCode.tar.gz`

This will upload the tarball to the server, unpack it, parse the code
and create a new project and corresponding graph database. The project
name corresponds to the name of the tarball.

Parsing code without importing
------------------------------

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
