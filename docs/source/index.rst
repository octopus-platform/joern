.. joern documentation master file, created by
   sphinx-quickstart2 on Thu Jul 10 10:58:55 2014.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to joern's documentation!
=================================

Joern is a platform for robust analysis of C/C++ code developed by
`Fabian Yamaguchi <http://codeexploration.blogspot.de>`_ at the
`Computer Security Group <http://goesec.de>`_ of the University of
Goettingen. It generates *code property graphs*, a novel graph
representation that exposes the code's syntax, control-flow, data-flow
and type information in a joint data structure. Code property graphs
are stored in a Neo4J graph database. This allows code to be mined
using search queries formulated in the graph traversal language
Gremlin.

- **Fuzzy Parsing.** Joern employs a fuzzy parser, allowing code to be
  imported even if a working build environment cannot be supplied.
    
- **Code Property Graphs.** Joern creates code property graphs from
  the fuzzy parser output and makes and stores them in a Neo4J graph
  database. For background information on code property graphs, we
  strongly encourage you to read `our paper on the topic
  <http://user.informatik.uni-goettingen.de/~fyamagu/pdfs/2014-oakland.pdf>`_.

- **Extensible Query Language.** Based on the graph traversal language
  Gremlin, Joern offers an extensible query language based on
  user-defined Gremlin steps that encode common traversals in the code
  property graph. These can be combined to create search queries easily.

This is joern's official documentation. It covers its installation and
configuration, discusses how code can be imported and retrieved from
the database and gives an overview of the database contents.

Contents:

.. toctree::
	:maxdepth: 2
	
	installation		
	import
	access
	performance
	databaseOverview
	querying
	joerntools
	development
	tutorials
..
   Indices and tables
   ==================

   * :ref:`genindex`
   * :ref:`modindex`
   * :ref:`search`

