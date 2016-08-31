# The Octopus Server


The Octopus Server is a generic server for collaborative code analysis
that can be extended to support analysis of particular programming
languages, hosting of domain specific languages, and the
implementation of code analysis algorithms via plugins and database
queries. In principle, it is not limited to the analysis of code,
however, it has been developed with this application in mind.

Both the source code analysis tool Joern and the binary analysis tool
Bjoern are implemented as extensions to Octopus.

## Configuration & Startup


By default, Octopus server will use up to 3GB for the Java Heap. The
more heap memory you can spare, the better performance will be. You
can tell Octopus how much heap to use by setting the environment
variable `OCTOPUS_SERVER_MAXHEAP`, e.g.,


```
export OCTOPUS_SERVER_MAXHEAP=16G
```

will allow a heap of up to 16GB.

To start a bare-bones octopus-server without any extensions loaded,
you, invoke the startup script:


```
$ ./octopus-server.sh
```

The server can now be remoted controlled via a REST API on port 2480,
and an anonymous FTP Server on port 23231.

## Utilities


While the extensions Joern and Bjoern come with their own set of shell
utilities for user interaction, the Octopus server itself also
provides shell utilities to carry out basic server operations. These
utilities are particularly valuable during the process of extension
development.


### Utility: octopus-project

An octopus server can host multiple projects, e.g., a project for each
of the code bases under analysis. To manage projects, you can make use
of the tool `octopus-project`. The tool allows existing projects to be
listed, new projects to be created, deletion of projects, and
uploading of files to projects.

Example session:


```
$ octopus-project list
$ octopus-project create myNewProject
$ octopus-project list
myNewProject
$ echo "foo" > myFile.txt
$ octopus-project upload myNewProject myFile.txt
$ octopus-project delete myNewProject
$ octopus-project list
```

### Utility: octopus-plugin


The `octopus-plugin` utility allows server-side plugins to be
invoked. This utility is only interesting during plugin development as
final plugins should include respective startup-scripts. For example,
it would be possible to invoke the `import` plugin of the Joern
extension for the project `testCode.tar.gz` via `octopus-plugin` as follows:


```
$ echo '{ "plugin": "importer.jar", "class": "joern.plugins.importer.JoernImporter","settings": { "projectName": "testCode.tar.gz", }} > foo.json
$ octopus-plugin foo.json
```

This is handy during plugin development and for unit testing. However,
for the end user, please consider providing a utility script to
simplify usage. As an example, you can take a look at the
`joern-import` script for the joern import plugin.
