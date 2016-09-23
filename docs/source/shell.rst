Octopus Shell
=============

The octopus shell (`octopus-shell`) provides an interactive interface to access
code already imported into the platform. With `octopus-shell` you can easily
interact with the graph database using the graph traversal language *Gremlin*.
The shell has support for maintaining a history and features basic completion of
Gremlin's default steps as well as the steps defined in the joern specific
language.

To access a database with octopus-shell, you first need to requests a database
connection from the octopus server. The server initializes the database
connection and replies with a port number (the shellport) where you can access
the database. In return, you can use the shell to query the database.

Basic Usage
-----------

The octopus shell can list database connections, create new database
connections, and connect to a database. The respective commands are

- :code:`octopus-shell list` (list database connections)
- :code:`octopus-shell create` (create database connection)
- :code:`octopus-shell connect` (connect to database)

All three commands will be explained in the following. You an use
:code:`octopus-shell --help` to get an overview of all options.

List database connections
~~~~~~~~~~~~~~~~~~~~~~~~~

By issuing :code:`octopus-shell list` you get an overview of all available
database connections, e.g:

.. code:: bash

    $ octopus-shell list
    6000 libpng-1.6.2.tar.gz None free

meaning that there is a single active database connection for the project
'libpng-1.6.2.tar.gz' accessible via port 6000. Moreover, the connection is not
in use, e.g. it is free and we can use :code:`octopus-shell connect` to use it.

Request a database connections
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

If no database connection is available, or the available database connections
are not connected to the project you want to work with, you need to create a
new connection. You can do so by issuing
:code:`octopus-shell create <database name>`. For example:

.. code:: bash

    $ octopus-shell list
    $ octopus-shell create libpng-1.6.2.tar.gz
    $ octopus-shell list
    6000 libpng-1.6.2.tar.gz libpng-1.6.2.tar.gz free

Access database connections
~~~~~~~~~~~~~~~~~~~~~~~~~~~

If :code:`octopus-shell list` contains a free connection to the database of the
project you want to work with, you can use :code:`octopus-shell connect` to
access the project's database, e.g.:

.. code:: bash

    $ octopus-shell list
    6000 libpng-1.6.2.tar.gz None free
    $ octopus-shell connect -q 6000
    Connecting to database 'libpng-1.6.2.tar.gz' on port 6000.
       ___       _
      / _ \  ___| |_ ___  _ __  _   _ ___
     | | | |/ __| __/ _ \| '_ \| | | / __|
     | |_| | (__| || (_) | |_) | |_| \__ \
      \___/ \___|\__\___/| .__/ \__,_|___/
                         |_| Octopus shell

    >

Using the shell
---------------

If you are connected to a database you can execute arbitrary gremlin
commands, or issue a lookup query. For example, to find all functions
with a return value of type :code:`int` you can use the following
query:

.. code:: bash

       ___       _
      / _ \  ___| |_ ___  _ __  _   _ ___
     | | | |/ __| __/ _ \| '_ \| | | / __|
     | |_| | (__| || (_) | |_) | |_| \__ \
      \___/ \___|\__\___/| .__/ \__,_|___/
                         |_| Octopus shell

    > g.V().has("type", "Function").out("IS_FUNCTION_OF_AST").out("IS_AST_PARENT").has("type", "ReturnType").has("code", "int")
    v[4632720]
    v[2457632]
    v[3604656]
    ...
    >

Developing custom steps
~~~~~~~~~~~~~~~~~~~~~~~

When developing new steps, it is recommended to use a small codebase or,
even better, a handcrafted set of function where it is easy to verify
the correctness. Usually, you need to play around a bit. Once your step
works as intended, you can place it in a file and reload it everytime you need
it.

Let's continue with the previous example. Travering from a function to its
return type is a recurring problem. Therefore, we should take the time and
write a step for this:

.. code:: bash

    > addStep("functionToReturnType", { delegate.out("IS_FUNCTION_OF_AST").out("IS_AST_PARENT").has("type", "ReturnType") })
    > g.V().has("type", "Function").functionToReturnType().has("code", "int").next(3)
    v[4632720]
    v[2457632]
    v[3604656]
    >

Another scenario is to filter functions by its return type. Again, we should
write a step.

.. code:: bash

    > addStep("hasReturnType", { types -> delegate.as("function").functionToReturnType().has("code", P.within(types)).select("function") })
    > g.V().has("type", "Function").hasReturnType("int").count()
    61
    > g.V().has("type", "Function").hasReturnType("size_t").count()
    1
    > g.V().has("type", "Function").hasReturnType("int", "size_t").count()
    62
    > g.V().has("type", "Function").hasReturnType("size_t").values("code")
    png_safecat
    > g.V().has("type", "Function").hasReturnType("size_t").values("type")
    Function

This time, we defined a step with arguments: the step :code:`hasReturnType`
takes a list of type names and returns only functions that match these return
types. Notice that, the step :code:`hasReturnType` uses the step
:code:`functionToReturnType` defined earlier.

Loading steps
~~~~~~~~~~~~~

Of course, you can save your steps into a file and load it every time you
use a fresh database connection. You can do so by typing
:code:`!reload(<stepsdir>)` in `octopus-shell`, where `stepsdir` contains
your step file(s).
