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

	`joern-import` <tarball>

This will upload the tarball to the server, unpack it, parse the code
and create a new project and corresponding graph database. The project
name corresponds to the name of the tarball.

Verifying the import
--------------------

You can verify whether the import has succeeded by pointing your
browser to

.. code-block:: none

	http://127.0.0.1:2480/

A database for the imported tarball should be selectable from the
drop-down menu. The default credentials are "root"/"admin".

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
