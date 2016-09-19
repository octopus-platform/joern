Installation
=============

System Requirements and Dependencies
-------------------------------------

Joern is a Java Application and should work on systems offering a Java
virtual machine, e.g., Microsoft Windows, Mac OS X or GNU/Linux. We
have tested Joern on Debian Jessie, where OpenJDK-8 and Gradle 2 have
been installed from jessie backports. If you plan to work with large
code bases such as the Linux Kernel, you should have at least 30GB of
free disk space to store the database and 8GB of RAM to experience
acceptable performance. In addition, the following software should be
installed:


- **A Java Virtual Machine 1.8.** Joern is written in Java 8 and does
  not build with Java 6 or 7. It has been tested with OpenJDK-8 but
  should also work fine with Oracle's JVM.

- **Python 3.** Joern implements a client/server architecture where
  client scripts are written in Python 3. Please note that these
  scripts are **not compatible with Python2**.

- **Python3-setuptools and python3-dev.** Client scripts are installed
  using setuptools. Moreover, some of the python libraries client
  tools depend on are written in C and require header files from
  python3-dev to be present.

- **Graphviz-dev.** Plotting tools require Graphviz and its
  development files to be installed.
  
- **Gradle 2.x.** Joern uses the gradle build tool, and some features
  specific to Gradle 2.0 and above.

If you are on a Debian-based system, try the following to download the
necessary dependencies:

.. code-block:: none

	sudo apt-get install openjdk-8-jdk gradle python3 python3-setuptools python3-dev graphviz graphviz-dev
		

Please note, however, that Debian stable (¨Jessie¨) currently does not
include openjdk8 nor gradle 2 by default, so for Joern to work on
Debian stable, please make use of Debian backports.
	
The following sections offer a step-by-step guide to the installation
of Joern, including all of its dependencies.

Building joern

--------------

**Please make sure Gradle 2.x is installed.** Then clone the repository
and invoke the build script as follows. The build script will
automatically download and install dependencies.

.. code-block:: none

	git clone https://github.com/octopus-platform/joern
	cd joern
	./build.sh

Testing the server
-------------------

In the joern root directory, invoke the script

.. code-block:: none

	./joern-server.sh

to start the server.

Testing client scripts
----------------------

Client scripts are installed into the user script directory, which is
typically `~/.local/bin`. Please make sure this directory is in your
path, e.g., by adding the line

.. code-block:: none

	export PATH="$PATH:~/.local/bin"

to your `~/.bashrc`, and restarting the shell. You can execute the
script

.. code-block:: none

	joern-import

without parameters to verify that scripts are installed correctly.
