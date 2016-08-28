Accessing Code via Python
=========================

Once code has been imported into the platform it can be accessed via
the joern shell `josh`, a Java plugin API, and a python scripting
API. In this section, we explain how the Python scripting API can be
accessed.

**General Note:** It is highly recommended to test your installation on a
small code base first. The same is true for early attempts of creating
search queries, as erroneous queries will often run for a very long
time on large code bases, making a trial-and-error approach
unfeasible.

Basic Usage
-----------

Joern currently provides a single python class,`DBInterface`, that
allows to connect to the database server and run queries. The
following is a simple sample script that employs this interface to
select a project, connect to the server and run a Gremlin query.

::

   #!/usr/bin/env python3

   from octopus.server.DBInterface import DBInterface

   projectName = 'testCode.tar.gz'
   query = "g.V.has('type', 'Function').code"

   db = DBInterface()
   db.connectToDatabase(projectName)

   result = db.runGremlinQuery(query)
   for x in result: print(x)


Chunking Traversals
--------------------

*Note*: It is not clear whether this optimization is still necessary
now that the code has been ported to Tinkerpop3.

Running the same traversal on a large set of start nodes often leads
to unacceptable performance as all nodes and edges touched by the
traversal are kept in server memory before returning results. For
example, the query::
	g.V.has('type', 'FunctionDef').astNodes().id

which retrieves all astNodes that are part of functions, can already
completely exhaust memory.

If traversals are independent, the query can be chunked to gain high
performance. The following example code shows how this works::

	#!/usr/bin/env python3

	from octopus.server.DBInterface import DBInterface

	projectName = 'testCode.tar.gz'
	query = "g.V.has('type', 'FunctionDef').id"

	db = DBInterface()
	db.connectToDatabase(projectName)

	ids = db.runGremlinQuery(query)

	CHUNK_SIZE = 256
	for chunk in db.chunks(ids, CHUNK_SIZE):
	     query = """ idListToNodes(%s).astNodes().id """ % (chunk)
	     for r in db.runGremlinQuery(query):
		  print(r)

This will execute the query in batches of 256 start nodes each.
