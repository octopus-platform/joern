# The Octopus Server


The Octopus Server is a generic server for collaborative code analysis
that can be extended to support analysis of particular programming
languages, hosting of domain specific languages, and the
implementation of code analysis algorithms via plugins and database
queries. In principle, it is not limited to the analysis of code,
however, it has been developed with this application in mind.

Both the source code analysis tool Joern and the binary analysis tool
Bjoern are implemented as extensions to Octopus.

## Installation

Octopus should run on recent Linux distributions. It currently only
depends on:

* Java 8 (tested with OpenJDK-8)
* Gradle 2.X

With these dependencies installed, you can build Octopus as follows:

```
git clone https://github.com/octopus-platform/octopus/
gradle build
```

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
./octopus-server.sh
```

The server can now be remoted controlled via a REST API on port 2480,
and an anonymous FTP Server on port 23231.

## Shell Utilities


While the extensions Joern and Bjoern come with their own set of shell
utilities for user interaction, the Octopus server itself also
provides shell utilities to carry out basic server operations. These
utilities are particularly valuable during the process of extension
development.

### Utility: octopus-csvimport `<projectName>`

This plugin will look for the files `nodes.csv` and `edges.csv` in the
projects root directory, and import the corresponding graph into the
project database.

Example code to import a graph:

```
octopus-project create myNewProject
octopus-project upload myNewProject nodes.csv
octopus-project upload myNewProject edges.csv
octopus-csvimport myNewProject
```

### Utility: octopus-project `<cmd>` [args]

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

### Utility: octopus-plugin `<json-file>`

The `octopus-plugin` utility allows server-side plugins to be
invoked. This utility is only interesting during plugin development as
final plugins should include respective startup-scripts. For example,
it would be possible to invoke the `import` plugin of the Joern
extension for the project `testCode.tar.gz` via `octopus-plugin` as follows:


```
echo '{ "plugin": "importer.jar", "class": "joern.plugins.importer.JoernImporter","settings": { "projectName": "testCode.tar.gz", }} > foo.json
octopus-plugin foo.json
```

This is handy during plugin development and for unit testing. However,
for the end user, please consider providing a utility script to
simplify usage. As an example, you can take a look at the
`joern-import` script for the joern import plugin.

## Node-file format for the CSV Importer

Nodes are described using a CSV-style file format, where the first
line describes the row format (CSV header), and the remaining lines
contain the actual nodes. The tabular character is used as a
deliminator. Double-quotes can be used to enclose values of fields
that contain newlines or tabs.

The CSV header has two mandatory fields: `command`, and
`_key`. All other fields are optional, however, fields named `type`
and `code` will receive special handling. 

In the following, we describe the different fields in greater detail.

### The _key field

The `_key` field contains an identifier for the node. The key can be
an arbitrary string. In general, this `_key` should be unique,
however, the importer will not bail if multiple nodes with the same
key are specified. 

The strategy to follow when a node with a specified key already exists
depends on the command.

### The command field

The `command` field specifies the action to perform for this node. The
following commands are currently supported:

| Name | Description                                                                                                                                                             |
|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ANR  | Add node, replacing any existing node with the same key.                                                                                                                |
| A    | Add node, creating an alternative key if a node with this key already exists. The alternative key is generated by adding an underscore followed by a number to the key. |


### The type field

In many graphs, each node has a some sort of type, where the number of
different types is typically small (< 1000). This field is not
mandatory, however, if it exists, the importer will create a composite
index for this field to allow for fast lookups by exact type
name. Please note that this index does not necessarily speed-up
wildcard searches.

### The code field

The `code` field, if present, will be treated as STRING content and
indexed using a LUCENE String index. In particular, this means that
fast lookups can be performed based on sub strings and regular
expression searches using the `text*`-functions in Gremlin
`has` clauses.

## Edge-file format for the CSV Importer

Edges between nodes are described in a CSV file, where nodes are
referred to by their keys. The first line of the CSV file (CSV header)
describes the row format.

The CSV header has three mandatory fields: `sourcekey`, `destkey`, and
`edgeType`.

The `sourcekey` and `destkey` fields specify the key of the edge's
source and destination node respectively, while `edgeType` specifies
the type of the edge as an arbitrary string.

The remaining fields are the names of edge properties.
