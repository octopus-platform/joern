Performance Tuning
===================


Optimizing Code Importing
--------------------------

Joern uses the Neo4J Batch Inserter for code importing (see Chapter 35
of the `Neo4J documentation
<http://docs.neo4j.org/chunked/stable/batchinsert.html>`_). Therefore,
the performance you will experience mainly depends on the amount of
heap memory you can make available for the importer and
how you assign it to the different caches used by the Neo4J Batch
Inserter. You can find a detailed discussion of this topic at
https://github.com/jexp/batch-import .

By default, Joern will use a configuration based on the maximum size
of the Java heap. For sizes below 4GB, the following configuration is
used:

.. code-block:: none

		cache_type = none
		use_memory_mapped_buffers = true
		neostore.nodestore.db.mapped_memory = 200M
		neostore.relationshipstore.db.mapped_memory = 2G
		neostore.propertystore.db.mapped_memory = 200M
		neostore.propertystore.db.strings.mapped_memory = 200M
		neostore.propertystore.db.index.keys.mapped_memory = 5M
		neostore.propertystore.db.index.mapped_memory = 5M

The following configuration is used for heap-sizes larger than 4GB:

.. code-block:: none

		cache_type = none
		use_memory_mapped_buffers = true
		neostore.nodestore.db.mapped_memory = 1G
		neostore.relationshipstore.db.mapped_memory = 3G
		neostore.propertystore.db.mapped_memory = 1G
		neostore.propertystore.db.strings.mapped_memory = 500M
		neostore.propertystore.db.index.keys.mapped_memory = 5M
		neostore.propertystore.db.index.mapped_memory = 5M


The Neo4J Batch Inserter configuration is currently not
exported. If you are running Joern on a machine where these values
are too low, you can adjust the values in
``src/neo4j/batchinserter/ConfigurationGenerator.java``.

For the ``argumentTainter``, the same default configurations are
used. The corresponding values reside in
``src/neo4j/readWriteDb/ConfigurationGenerator.java``.

Optimizing Traversal Speed
---------------------------

To experience acceptable performance, it is crucial to configure your
Neo4J server correctly. To achieve this, it is highly recommended to
review Chapter 22 of the Neo4J documentation on `Configuration and
Performance
<http://docs.neo4j.org/chunked/stable/configuration.html>`_. In
particular, the following settings are important to obtain good
performance.


**Size of the Java heap**. Make sure the maximum size of the java heap
is high enough to benefit from the amount of memory in your
machine. One possibility to ensure this, is to add the ``-Xmx$SIZEg``
flag to the variable ``JAVA_OPTS`` in ``$Neo4JDir/bin/neo4j`` where
``$Neo4JDir`` is the directory of the Neo4J installation. You can also
configure the maximum heap size globally by appending the ``-Xmxx``
flag to the environment variable ``_JAVA\_OPTIONS``.

**Maximum number of open file descriptors.** If, when starting the
Neo4J server, you see the message

.. code-block:: none

	WARNING: Max 1024 open files allowed, minimum of 40 000 recommended.

you need to raise the maximum number of open file
descriptors for the user running Neo4J (see the `Neo4J Linux
Performance Guide
<http://docs.neo4j.org/chunked/stable/linux-performance-guide.html>`_).

**Memory Mapped I/O Settings.** Performance of graph database
traversals increases significantly when large parts of the graph
database can be kept in RAM and do not have to be loaded from disk
(see
http://docs.neo4j.org/chunked/stable/configuration-io-examples.html
). For example, for a machine with 8GB RAM the following
``neo4j.properties`` configuration has been tested to work well:

.. code-block:: none

	# conf/neo4j.conf
	use_memory_mapped_buffers=true
	cache_type=soft
	neostore.nodestore.db.mapped_memory=500M
	neostore.relationshipstore.db.mapped_memory=4G
	neostore.propertystore.db.mapped_memory=1G
	neostore.propertystore.db.strings.mapped_memory=1300M
	neostore.propertystore.db.arrays.mapped_memory=130M
	neostore.propertystore.db.index.keys.mapped_memory=200M
	neostore.propertystore.db.index.mapped_memory=200M
	keep_logical_logs=true

Automatically Killing Runaway Queries
-------------------------------------

Inefficient graph traversals can consume unbounded amounts of
resources.  Currently, Neo4j does not support killing active queries,
instead it offers an execution guard that will kill queries running
beyond a specified amount of time. It's recommended you enable it by
adding the following to ``neo4j.properties``:

.. code-block:: none

  execution_guard_enabled=true

And then specify the timeout (in millseconds) in
``neo4j-server.properties`` as below:

.. code-block:: none

  org.neo4j.server.webserver.limit.executiontime=60000
