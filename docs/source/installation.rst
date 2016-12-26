Installation
=============

Joern currently consists of the following components:

- `joern(-core) <https://github.com/fabsx00/joern/>`_ parses source
  code using a robust parser, creates code property graphs and
  finally, imports these graphs into a Neo4j graph database. 

- `python-joern <https://github.com/fabsx00/python-joern/>`_ is a
  (minimal) python interface to the Joern database. It offers a
  variety of utility traversals (so called *steps*) for common
  operations on the code property graph (think of these are stored
  procedures).

- `joern-tools <https://github.com/fabsx00/joern-tools/>`_ is a
  collection of command line tools employing python-joern to allow
  simple analysis tasks to be performed directly on the shell. 

Both python-joern and joern-tools are optional, however, installing
python-joern is highly recommended for easy access to the
database. While it is possible to access Neo4J from many other
languages, you will need to write some extra code to do so and
therefore, it is currently not recommended.

System Requirements and Dependencies
-------------------------------------

Joern is a Java Application and should work on systems offering a Java
virtual machine, e.g., Microsoft Windows, Mac OS X or GNU/Linux. We
have tested Joern on Arch Linux as well as Mac OS X Lion. If you plan
to work with large code bases such as the Linux Kernel, you should
have at least 30GB of free disk space to store the database and 8GB of
RAM to experience acceptable performance. In addition, the following
software should be installed:


- **A Java Virtual Machine 1.7.** Joern is written in Java 7 and does
  not build with Java 6. It has been tested with OpenJDK-7 but should
  also work fine with Oracle's JVM.
  
- **Neo4J 2.1.5 Community Edition.**  The graph database `Neo4J
  <http://www.neo4j.org/download/>`_ provides access to 
  the imported code.

- **Gremlin for Neo4J 2.X.** The `Gremlin plugion for Neo4J 2.X
  <https://github.com/neo4j-contrib/gremlin-plugin>`_ allows
  traversals written in the programming language Gremlin to be run on
  the Neo4J database.
	  
**Build Dependencies.** A tarball containing all necessary
build-dependencies is available for download `here
<http://mlsec.org/joern/lib/lib.tar.gz>`_ . This contains files from
the following projects.


* `The ANTLRv4 Parser Generator <http://www.antlr.org/>`_ 
* `Apache Commons CLI Command Line Parser 1.2
  <http://commons.apache.org/proper/commons-cli/>`_
* `Neo4J 2.1.5 Community Edition
  <http://www.neo4j.org/download/other_versions>`_

* `The Apache Ant build tool <http://ant.apache.org/>`_ (tested with
  version 1.9.2).

The following sections offer a step-by-step guide to the installation
of Joern, including all of its dependencies.

Building joern
--------------

Begin by downloading the latest stable version of joern at
http://mlsec.org/joern/download.shtml. This will create the directory
``joern`` in your current working directory.

.. code-block:: none

	wget https://github.com/fabsx00/joern/archive/0.3.1.tar.gz
	tar xfzv 0.3.1.tar.gz

Change to the directory ``joern-0.3.1/``. Next, download build dependencies
at http://mlsec.org/joern/lib/lib.tar.gz and extract the tarball.

.. code-block:: none

	cd joern-0.3.1
	wget http://mlsec.org/joern/lib/lib.tar.gz
	tar xfzv lib.tar.gz

The JAR-files necessary to build joern should now be located in
``joern-0.3.1/lib/``.

**Note**: If you want to build the development version, you need
to download the build dependencies from
http://mlsec.org/joern/lib/lib-dev.tar.gz .

Build the project using ``ant`` by issuing the following command.

.. code-block:: none

	ant

Create symlinks (optional). The executable JAR file will be located in
``joern-0.3.1/bin/joern.jar``. Simply place this JAR file somewhere on your
disk and you are done. If you are using bash, you can optionally
create the following alias in your ``.bashrc``:

.. code-block:: none

	# ~/.bashrc
	alias joern='java -jar $JOERN/bin/joern.jar'


where ``$JOERN`` is the directory you installed joern into.


Build additional tools (optional). Tools such as the
\code{argumentTainter} can be built by issuing the following command.

.. code-block:: none
	
	ant tools

Upon successfully building the code, you can start importing C/C++
code you would like to analyze. To interact with the database using
python and the shell, it is also highly recommended to install
``python-joern`` and ``joern-tools`` as outlined in the following
sections.

Installing python-joern
------------------------

``python-joern`` is a thin python access layer for joern and a set of
utility traversals. It depends on the following python modules:

- py2neo 2.0 (http://py2neo.org/)

To install ``python-joern``, first make sure python setuptools are
correctly installed. On Debian/Ubuntu, issuing the following command
on the shell should be sufficient.

.. code-block:: none
	
	sudo apt-get install python-setuptools python-dev	


``python-joern`` and all its dependencies can then be installed as
follows:

.. code-block:: none

	wget https://github.com/fabsx00/python-joern/archive/0.3.1.tar.gz
	tar xfzv 0.3.1.tar.gz
	cd python-joern-0.3.1
	sudo python2 setup.py install


Installing joern-tools
-----------------------

``joern-tools`` is a set of shell utilities for code analysis based on
joern. It is at a very early stage of development and has not been
labeled for release. However, it can be installed from github.

``joern-tools`` depends on ``python-joern`` for database communication
and graphviz/pygraphviz for graph visualization. To install it, make
sure graphviz is installed. On Debian/Ubuntu, the following command
will install graphviz:

.. code-block:: none

	sudo apt-get install graphviz libgraphviz-dev


Just like ``python-joern``, ``joern-tools`` is installed using
python-setuptools as follows:

.. code-block:: none
	
	git clone https://github.com/fabsx00/joern-tools
	cd joern-tools
	sudo python2 setup.py install

After installation, type ``joern-lookup`` to verify correct
installation.
