The Octopus Server
==================

The Octopus Server is a generic server for collaborative code analysis
that can be extended to support analysis of particular programming
languages, hosting of domain specific languages, and the
implementation of code analysis algorithms via plugins and database
queries.

Both the source code analysis tool Joern and the binary analysis tool
Bjoern are implemented as extensions to Octopus.

Utility: octopus-project
------------------------

An octopus server can host multiple projects, e.g., a project for each
of the code bases under analysis. To manage projects, you can make use
of the tool `octopus-project`. The tool allows existing projects to be
listed, new projects to be created, deletion of projects, and
uploading of files to projects.

Example session:

.. code-block:: none

	$ octopus-project list
	$ octopus-project create myNewProject
	$ octopus-project list
	myNewProject
	$ echo "foo" > myFile.txt
	$ octopus-project upload myFile.txt
	$ octopus-project delete myNewProject

Utility: octopus-plugin
-----------------------

The `octopus-plugin` utility allows server-side plugins to be
invoked. This utility is only interesting during plugin development as
final plugins should include respective startup-scripts. For example,
it would be possible to invoke the `import` plugin of the Joern
extension for the project `testCode.tar.gz` via `octopus-plugin` as follows:

.. code-block:: none

	$ echo '{ "plugin": "importer.jar", "class":
	"joern.plugins.importer.JoernImporter","settings": { "projectName":
	"testCode.tar.gz", }} > foo.json
	$ octopus-plugin foo.json

This is handy during plugin development and for unit testing. However,
for the end user, please consider providing a utility script to
simplify usage. As an example, you can take a look at the
`joern-import` script for the joern import plugin.
