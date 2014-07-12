Code Analysis with joern-tools/python-joern
===========================================

..
   Short introduction/motivation

This tutorial shows how the command line utilities ``joern-tools`` and
the python interface ``python-joern`` can be used for code analysis on
the shell. These tools have been created in light of the observation
that programmatic code analysis (think: "idapython") can be extremely
powerful, particularly when  dealing with large amounts of
code. Consider them a useful addition to your GUI-based code browsing
tools and not so much as a replacement. That being said, you may find
yourself doing more and more of your code browsing on the shell with
these tools.

Importing the code
-------------------

As an example, we will analyze the VLC media player, a medium sized
code base containing code for both Windows and Linux/BSD. I assume
that you have successfully installed joern into the directory
``$JOERN`` and Neo4J into ``$NEO4J`` as described in
:doc:`../installation`. To begin, you can download and import the code
as follows:
   
.. code-block:: none

	cd $JOERN
	mkdir tutorial; cd tutorial
	wget http://download.videolan.org/pub/videolan/vlc/2.1.4/vlc-2.1.4.tar.xz
	tar xfJ vlc-2.1.4.tar.xz
	cd ..
	./joern tutorial/vlc-2.1.4/

Next, please start the database server in a second terminal:

.. code-block:: none

	$NEO4J/bin/neo4j console

We will now take a brief look at how the code base has been stored in
the database and then move on to joern-tools.

Database Contents
-----------------

Before we start using ``joern-tools``, let's take a quick look at the
way the code base has been stored in the database. To this end, we
make use of the web-based API (REST API) offered by Neo4J, allowing us
to see the database as the tools do. Once your database server has
been launched, point your browser to

.. code-block:: none

    http://localhost:7474/db/data/node/0
    
This is the *reference node*, which is the root node of the graph
database. Starting from this node, the entire database contents can be
accessed using your browser. In particular, you can get an overview of
all existing edge types as well as the properties attached to nodes
and edges. Of course, in practice, you will not want to use your
browser to query the database. Instead, you can use ``python-joern``
to access the REST API using Python as we will do in the following.

The Directory Hierarchy
""""""""""""""""""""""""
**Inspecting node properties.** Let's begin by writing a small
python-script, which outputs all nodes directly connected to the root
node:

.. code-block:: python

	#!/usr/bin/env python2
	# tutorial/hierarchy.py

	from joern.all import JoernSteps

	j = JoernSteps()
	j.connectToDatabase()

	# Syntax:
	# g: a reference to the neo4j graph
	# g.v(id): retrieve node by id.
	# g.v(id).out(): all nodes immediately
	# connected to the node by an
	# outgoing edge.

	query = """ g.v(0).out() """
	for x in j.runGremlinQuery(query):
		print x

Running this script yields the following result:

.. code-block:: none

	chmod u+x ./tutorial/hierarchy.py
	python2 ./tutorial/hierarchy.py

	(1 {"type":"Directory","filepath":"tutorial/vlc-2.1.4"})

If this works, you have successfully injected a Gremlin script into
the Neo4J database using the REST API with
``python-joern``. Congratulations, btw. As you can see from the
output, the reference node has a single child node. This node has two
*attributes*: "type" and "filepath". In the joern database, each node
has a "type" attribute, in this case "Directory". Directory nodes in
particular have a second attribute, "filepath", which stores the
complete path to the directory represented by this node.

For short queries like these, creating scripts is a bit clumsy. You
can use the shell utility ``joern-lookup`` instead. For example:

.. code-block:: none
	
	echo 'g.v(0).out()' | joern-lookup -g

	(1 {"type":"Directory","filepath":"tutorial/vlc-2.1.4"})

gives the same result as ``hierarchy.py``.

**Inspecting Edge Types.** Let's see where we can get by expanding
outgoing edges:

.. code-block:: none

	# Syntax
	# .outE(): outgoing Edges

	echo 'g.v(0).out().outE()' | joern-lookup -g | sort | uniq -c
	
	14 IS_PARENT_DIR_OF

This shows: the Directory node itself merely stores a filepath,
however, it is connected to the rest of the directory hierarchy by
edges of type 'IS_PARENT_DIR_OF', and thus its position in the
directory hierarchy is encoded in the graph structure.

**Filtering.** Starting from a directory node, we can recursively
enumerate all files it contains and filter them by name. For example,
the following query returns all files in the directory 'demux':

.. code-block:: none
	
	# Syntax
	# .filter(closure): allows you to filter incoming objects using the
	# supplied closure, e.g., the anonymous function { it.type ==
	# 'File'}. 'it' is the incoming pipe, which means you can treat it
	# just like you would treat the return-value of out().
	# loop(1){true}{true}: perform the preceeding traversal
	# exhaustively and emit each node visited

	echo 'g.v(0).out("IS_PARENT_DIR_OF").loop(1){true}{true}.
 	      filter{ it.filepath.contains("/demux/") }' | joern-lookup -g

File nodes are linked to all definitions they contain, i.e., type,
variable and function definitions and this is where things start to
become interesting.

