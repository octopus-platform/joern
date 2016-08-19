Joern Shell
===========

The joern shell (`josh` for short) provides an interactive interface to
access code already imported into the platform. With josh, you can easily
interact with the graph database using the graph traversal language *Gremlin*.
It features a history and basic code completion, which makes is extremely useful when
developing custom steps or verifying the database content by issuing some
queries.

To access a database, josh requests a database connection from the
octopus server. The server initializes the database connection and
replies with a port number (the shellport). In return, josh can accesses
the database via that port.

Basic Usage
-----------

Josh can list, create, and access database connections provided by the
octopus server. These commands can be executed by :code:`josh list`,
:code:`josh create`, and :code:`josh connect`, respectively.
All three commands will be explained in the following. You an use
:code:`josh --help` to get an overview of all options.

List database connections
~~~~~~~~~~~~~~~~~~~~~~~~~

By issuing :code:`josh list` you get an overview of all open database connections, e.g:

.. code:: bash

    $ josh list
    6000 libpng-1.6.2.tar.gz noname free

meaning that there is a single active database connection for the
database 'libpng-1.6.2.tar.gz' accessible via port 6000. Moreover,
the connection is not in use, e.g. it is free and we can
use :code:`josh connect` to use it.

Create database connections
~~~~~~~~~~~~~~~~~~~~~~~~~~~

By issuing :code:`josh create <database name>` you can create a new database connection, e.g.:

.. code:: bash

    $ josh list
    $ josh create libpng-1.6.2.tar.gz
    $ josh list
    6000 libpng-1.6.2.tar.gz libpng-1.6.2.tar.gz free

Access database connections
~~~~~~~~~~~~~~~~~~~~~~~~~~~

By issuing :code:`josh connect` you can access a free database connection, e.g.:

.. code:: bash

    $ josh create libpng-1.6.2.tar.gz
    $ josh connect
    Connecting to database 'libpng-1.6.2.tar.gz' on port 6000.
       _           _
      (_) ___  ___| |__
      | |/ _ \/ __| '_ \
      | | (_) \__ \ | | |
     _/ |\___/|___/_| |_|
    |__/      joern shell

    josh>

However, this only works if there is a single active database
connection. If there are multiple active database connections at the
octopus server you have to use :code:`bjosh connect -q <shellport>` and
to access the database connection with the shellport :code:`shellport`.
Another option is to use :code:`bjosh connect --dbname <dbname>` to
access the database connection for the database :code:`dbname` (if it
is unique). If no database connection for the database :code:`dbname`
exits a new one is created automatically.

Using the shell
---------------

If you are connected to a database you can execute arbitrary gremlin
commands, or issue a lookup query. For example, to find all functions
with a return value of type :code:`int` you can use the following
query:

.. code:: bash

    $ josh create libpng-1.6.2.tar.gz
    $ josh connect
    Connecting to database 'libpng-1.6.2.tar.gz' on port 6000.
       _           _
      (_) ___  ___| |__
      | |/ _ \/ __| '_ \
      | | (_) \__ \ | | |
     _/ |\___/|___/_| |_|
    |__/      joern shell
	   _
    josh> queryNodeIndex("type:Function").out("IS_FUNCTION_OF_AST").out("IS_AST_PARENT").has("type", "ReturnType").has("code", "int")
    v[#9:1186]
    v[#9:2414]
    v[#9:2714]
    ...

Developing custom steps
~~~~~~~~~~~~~~~~~~~~~~~

When developing new steps, it is recommended to use a small codebase or,
even better, a handcrafted set of function where it is easy to verify
the correctness. Usually, you need to play around a bit. Once your step
works as intended, you can place it in a file as a named closure.

Let's continue with the previous example. Travering from a function to
its return type is a recurring problem. Therefore, we should take the
time and write a custom step:

.. code:: bash

    josh> functionToReturnType = {_().out("IS_FUNCTION_OF_AST").out("IS_AST_PARENT").has("type", "ReturnType")}
    Script60$_run_closure1@220be57b
    josh> queryNodeIndex("type:Function").functionToReturnType().has("code", "int").next(3)
    v[#9:1186]
    v[#9:2414]
    v[#9:2714]

It works! Now you can place the step into a file:

.. code::

    functionToReturnType = {
	_().out("IS_FUNCTION_OF_AST")
	   .out("IS_AST_PARENT")
	   .has("type", "ReturnType")
    }

Loading steps
~~~~~~~~~~~~~

Of course, you can save your steps into a file and load it every time you
use a fresh database connection. You can do so by typing
:code:`!reload(<stepsdir>)` in `josh`, where :code:`stepsdir` contains
your step file(s).
