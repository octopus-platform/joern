Code Analysis with joern-tools (Work in progress)
=================================================

..
   Short introduction/motivation

This tutorial shows how the command line utilities ``joern-tools`` can
be used for code analysis on the shell. These tools have been created
to enable fast programmatic code analysis, in particular to hunt for
bugs and vulnerabilities. Consider them a possible addition to your
GUI-based code browsing tools and not so much as a replacement. That
being said, you may find yourself doing more and more of your code
browsing on the shell with these tools.

This tutorial offers both short and concise commands that *get a job
done* as well as more lengthly queries that illustrate the inner
workings of the code analysis platform ``joern``. The later have been
provided to enable you to quickly extend ``joern-tools`` to suit your
specific needs.

**Note:** If you end up writing tools that may be useful to others,
please don't hesitate to send a pull-request to get them included in
``joern-tools``.

Importing the Code
-------------------

As an example, we will analyze the VLC media player, a medium sized
code base containing code for both Windows and Linux/BSD. It is
assumed that you have successfully installed joern into the directory
``$JOERN`` as described in :doc:`../installation`. To begin, you can
download and import the code as follows:

.. code-block:: none

	cd $JOERN
	mkdir tutorial; cd tutorial
	wget http://download.videolan.org/pub/videolan/vlc/2.1.4/vlc-2.1.4.tar.xz
	tar xfJ vlc-2.1.4.tar.xz
	tar zcf vlc-2.1.4.tar.gz vlc-2.1.4/
	cd ..

Next, start the joern-server:

.. code-block:: none

	./joern-server

Open a new terminal and import the code:

.. code-block:: none

	cd $JOERN
	joern-import tutorial/vlc-2.1.4.tar.gz


Exploring Database Contents
---------------------------


Inspecting node and edge properties
""""""""""""""""""""""""""""""""""""

Fast lookups using the Node Index
"""""""""""""""""""""""""""""""""

Before we discuss function definitions, let's quickly take a look at
the node index, which you will probably need to make use of in all but
the most basic queries. Instead of walking the graph database from its
root node, you can lookup nodes by their properties. Under the hood,
this index is implemented as an Apache Lucene Index and thus you can
make use of the full Lucene query language to retrieve nodes. Let's
see some examples.

.. code-block:: none

	echo 'g.V().has("type", "File").hasRegex("code", ".*demux.*").code' | joern-lookup vlc-2.1.4.tar.gz

Advantage:

.. code-block:: none

	echo 'g.V().has("type", "File").hasRegex("code", ".*demux.*").out().has("type", "Function").code' | joern-lookup vlc-2.1.4.tar.gz

Plotting Database Content
-------------------------

To enable users to familarize themselves with the database contents
quickly, ``joern-tools`` offers utilities to retrieve graphs from the
database and visualize them using *graphviz*.

**Retrieve functions by name**

.. code-block:: none

	echo 'getFunctionsByName("GetAoutBuffer").id' | joern-lookup vlc-2.1.4.tar.gz | joern-location

	/home/fabs/targets/vlc-2.1.4/modules/codec/mpeg_audio.c:526:0:19045:19685
	/home/fabs/targets/vlc-2.1.4/modules/codec/dts.c:400:0:13847:14459
	/home/fabs/targets/vlc-2.1.4/modules/codec/a52.c:381:0:12882:13297

Usage of the shorthand getFunctionsByName. Reference to python-joern.

.. code-block:: none

	echo 'getFunctionsByName("GetAoutBuffer").id' | joern-lookup -g | tail -n 1 | joern-plot-ast > foo.dot

**Plot abstract syntax tree**

Take the first one, use joern-plot-ast to generate .dot-file of AST.

.. code-block:: none

	dot -Tsvg foo.dot -o ast.svg; eog ast.svg


.. image:: ../_static/ast.svg

**Plot control flow graph**

.. code-block:: none

	 echo 'getFunctionsByName("GetAoutBuffer").id' | joern-lookup -g | tail -n 1 | joern-plot-proggraph -cfg > cfg.dot;
	dot -Tsvg cfg.dot -o cfg.svg; eog cfg.svg

.. image:: ../_static/cfg.svg

**Show data flow edges**

.. code-block:: none

	 echo 'getFunctionsByName("GetAoutBuffer").id' | joern-lookup -g | tail -n 1 | joern-plot-proggraph -ddg -cfg > ddgAndCfg.dot;
	dot -Tsvg ddgAndCfg.dot -o ddgAndCfg.svg; eog ddgAndCfg.svg

.. image:: ../_static/ddgAndCfg.svg

**Mark nodes of a program slice**

.. code-block:: none

	echo 'getFunctionsByName("GetAoutBuffer").id' | joern-lookup -g | tail -n 1 | joern-plot-proggraph -ddg -cfg | joern-plot-slice 1856423 'p_buf' > slice.dot;
	dot -Tsvg slice.dot -o slice.svg;

.. image:: ../_static/slice.svg

Note: You may need to exchange the id: 1856423.



Selecting Functions by Name
---------------------------

Lookup functions by name

.. code-block:: none

	echo 'type:Function AND name:main' | joern-lookup

Use Wildcards:

.. code-block:: none

	echo 'type:Function AND name:*write*' | joern-lookup

Output all fields:

.. code-block:: none

	echo 'type:Function AND name:*write*' | joern-lookup -c

Output specific fields:

.. code-block:: none

	echo 'type:Function AND name:*write*' | joern-lookup -a name


Shorthand to list all functions:

.. code-block:: none

	joern-list-funcs

Shorthand to list all functions matching pattern:

.. code-block:: none

	joern-list-funcs -p '*write*

List signatures

echo "getFunctionASTsByName('*write*').code" | joern-lookup -g


Lookup by Function Content
--------------------------

**Lookup functions by parameters:**

.. code-block:: none

	echo "queryNodeIndex('type:Parameter AND code:*len*').functions().id" | joern-lookup -g

Shorthand:

.. code-block:: none

	echo "getFunctionsByParameter('*len*').id" | joern-lookup -g

From function-ids to locations: joern-location

.. code-block:: none

	echo "getFunctionsByParameter('*len*').id" | joern-lookup -g | joern-location

Dumping code to text-files:

.. code-block:: none

	echo "getFunctionsByParameter('*len*').id" | joern-lookup -g | joern-location | joern-code > dump.c

Zapping through locations in an editor:

.. code-block:: none

	echo "getFunctionsByParameter('*len*').id" | joern-lookup -g | joern-location | tail -n 2 | joern-editor

Need to be in the directory where code was imported or import using full paths.

**Lookup functions by callees:**

.. code-block:: none

	echo "getCallsTo('memcpy').functions().id" | joern-lookup -g

You can also use wildcards here. Of course, joern-location, joern-code
and joern-editor can be used on function ids again to view the code.

List calls expressions:

.. code-block:: none

	echo "getCallsTo('memcpy').code" | joern-lookup -g


List arguments:

.. code-block:: none

	echo "getCallsTo('memcpy').ithArguments('2').code" | joern-lookup -g

Analyzing Function Syntax
-------------------------

- Plot of AST
- locate sub-trees and traverse to statements


Analyzing Statement Interaction
-------------------------------

- some very basic traversals in the data flow graph
