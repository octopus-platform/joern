
joern-plot-proggraph
====================

SYNOPSIS
---------

``joern-plot-proggraph`` [ ``-h`` ] [ ``-f`` FILE ] [ ``-o`` OUT ] [ ``-ast`` ] [ ``-cfg`` ]
[ ``-dfg`` ] [ ``-ddg`` ] [ ``-cdg`` ] [``-dom`` ] [ ``-all`` ] [ ``-P`` ] [ ``-c`` PLOT_CONFIG ]
*project*

DESCRIPTION
-----------

``joern-plot-proggraph`` lets you plot various program graphs, but restricted to one plot per function.
Retrieves a graph representation of a function with the given id. The default output format is graphviz's 'dot'.


OPTIONS
-------

positional arguments:
~~~~~~~~~~~~~~~~~~~~

*project*, the name of the Joern project.

optional arguments
~~~~~~~~~~~~~~~~~~

-h, --help                        show this help message and exit
-f FILE, --file FILE              read input from the provided file
-o OUT, --out OUT                 write output to provided file
-ast, --show-ast                  Show AST in CFG nodes.
-cfg, --show-control-flow         Show control flow.
-dfg, --show-data-flow            Show data flow.
-ddg, --show-data-dependences     Show data dependences.
-cdg, --show-control-dependences  Show control dependences.
-dom, --show-dominance-edges      Show dominance edges.
-all, --show-all                  Show all edge types
-P, --id-property                 use functionId property value to identify function
-c PLOT_CONFIG, --plot-config PLOT_CONFIG  use plot configuration from file

PLOT CONFIGURATION
------------------

The default plot configuration can be found in the directory ``scripts/data/plotconfig.cfg``. The config consists of lines of the following format:


*element_type* ``.`` *rule_type* ``=`` *pattern* ``:`` [ ``+`` ] { [ ``&`` | ``-`` ] *property* [ ``,`` ... ] | *param* [ ``,`` ... ] }

element_type:
    graph element, can be ``node`` or ``edge``.

rule_type:
    ``display`` to tell which properties are shown in the graph, ``layout`` to determine graphviz layout options.

pattern:
    ``*`` :
        matches any element
    *prop* ``.`` *val* :
        matches if the property prop has value val. If value is * then any value of the field results in a match.

if the property or parameter list starts with a ``+``, the result will be added to the result of previous matching rules. If ``+`` is omitted, the current result will be replaced.

fields can start with ``&``, in which case the property label will be displayed.
fields can start with ``-``, in which case the propery will be removed from the current results.

Lines that start with optional whitespace followed by ``#`` are comments and not processed.

Example
~~~~~~~

::

  # comment lines are possible
  # for all nodes, show childNum, id, type and code properties, without property keys
  node.display=*:childNum,id,type,code
  # if we wanted property keys, use
  # node.display=*:&childNum,&id,&type,&code
  node.layout=*:shape=rectangle,style=filled,fillcolor=white
  node.layout=isCFGNode.True:+fillcolor=lightcyan
  # for CFGEntryNode and CFGExitNode, do not show childNum and type, but keep the rest
  node.display=type.CFGEntryNode:+-childNum,-type
  node.display=type.CFGExitNode:+-childNum,-type
  # keep the layout parameters from earlier matches (+), change fillcolor and add fontcolor
  node.layout=type.CFGEntryNode:+fillcolor=slategray,fontcolor=white
  node.layout=type.CFGExitNode:+fillcolor=black,fontcolor=white
  node.layout=type.Symbol:+shape=ellipse,fillcolor=wheat
  # this overrides the display options for Symbol nodes
  node.display=type.Symbol:code
  edge.display=*:label
  edge.display=label.IS_AST_PARENT:
  edge.layout=label.IS_AST_PARENT:color=gray
  # this clears all display properties for FLOWS_TO edges
  edge.display=label.FLOWS_TO:
  edge.layout=label.FLOWS_TO:color=black
  edge.layout=label.USE:color=lightpink,fontcolor=lightpink
  edge.layout=label.DEF:color=deeppink,fontcolor=deeppink
  edge.layout=label.DOM:color=navy,fontcolor=navy
  edge.layout=label.POST_DOM:color=deepskyblue,fontcolor=deepskyblue
  edge.layout=label.CONTROLS:color=seagreen,fontcolor=seagreen
  edge.display=label.REACHES:+var
  edge.layout=label.REACHES:color=darkolivegreen,fontcolor=darkolivegreen


