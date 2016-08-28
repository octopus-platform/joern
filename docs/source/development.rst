Development
===========

Accessing the GIT Repository
-----------------------------

We use the revision control system git to develop Joern. If you want
to participate in development or test the development version, you can
clone the git repository by issuing the following command:

.. code-block:: none

	git clone https://github.com/ocotopus-platform/joern.git

If you want to report issues or suggest new features, please do so via
https://github.com/octopus-platform/joern . For fixes, please fork the
repository and issue a pull request.

Build system and IDEs
------------------------------

Joern is a multi-module Gradle project where Java/Groovy sub-projects
are located in the directory 'projects', while python projects reside
in the directory 'python'.

To start hacking on Joern, make sure you can build it using the
supplied build script `build.sh`. For small modifications, it may be
sufficient to edit the source files using a simple text editor, and
subsequently invoking this script.

For larger changes, please consider using a JAVA IDE such as IntelliJ
or Eclipse. We use both of these IDEs for Joern-development on a
regular basis, so the import should hopefully be possible without
trouble using the corresponding Gradle plugin. IntelliJ typically
comes with a gradle plugin pre-installed, and Eclipse offers a plugin
in its "Marketplace".

