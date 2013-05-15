joern
====

joern is a tool for robust analysis of C/C++ code. It generates
abstract syntax trees (ASTs) and control flow graphs (CFGs) from
source code without the need for a working build environment. ASTs and
CFGs are stored in a Neo4J graph database. This allows code bases to
be searched using complex queries formulated in the graph traversal
languages Gremlin and Cypher.

Installation:
=============

Dependencies
----------

Make sure the following software is installed:

- A Java Virtual Machine such as OpenJDK's or Oracle's JVM.
- Neo4J 1.8.2 community edition: http://www.neo4j.org/download

Optional:
- py2neo - a Python library for neo4: http://py2neo.org
- Standalone Gremlin https://github.com/tinkerpop/gremlin/wiki/Downloads
- Standalone groovy (from your package manager)

Installing joern
----------

joern is written entirely in Java and made available as an executable
Java Archive (JAR) file for convenience. You can download the current
JAR from:

https://github.com/fabsx00/joern/blob/master/bin/joern.jar

Simply place this JAR file somewhere on your disk and installation is
done. If you are using bash, you can optionally create the following
alias in your .bashrc:

alias joern='java -jar $joern_path/joern.jar'

where $joern_path is the directory containing the JAR file.

Usage:
======

1. Importing Code
----------

To import source code into the database, point joern to the
directories containing the code by executing the following command:

	    $ java -jar $joern_path/joern.jar $CodeDirectory1
	    $ java -jar $joern_path/joern.jar $CodeDirectory2
	    ...
	    $ java -jar $joern_path/joern.jar $CodeDirectory_n

or, if you have created the alias in .bashrc as suggested, simply

    $ joern $CodeDirectory1
    ...

The neo4j database is then stored in the sub directory ".joernIndex"
of the current working directory. 

2. Accessing the Database using Python
----------

Once code has been imported into a Neo4j database, it can be accessed
using a number of different interfaces and programming languages. One
of the simplest possibilities is to create a standalone Neo4J server
instance and connect to this server using the Python library py2neo.

1. Specificy the location of the database created by joern in your
Neo4J server configuration file in
$Neo4jDir/conf/neo4j-server.properties:

		org.neo4j.server.database.location=/$path_to_joern_index/.joernIndex/

2. Start the database server by issuing the following command:

   	 $ $Neo4jDir/bin/neo4j console

3. Connect to the database to verify that the data has been loaded by
pointing your browser to: http://localhost:7474/

4. Run the following Python script to print all assignments:
   
	from py2neo import neo4j, gremlin
   	graph_db = neo4j.GraphDatabaseService("http://localhost:7474/db/data/")
   	for assign in gremlin.execute('g.idx("astNodeIndex")[[type:"AssignmentExpr"]].code', graph_db):
       	    print assign
