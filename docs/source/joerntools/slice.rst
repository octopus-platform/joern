joern-slice
============

SYNOPSIS
---------

joern-slice [options]

DESCRIPTION
-----------

Creates program slices for all nodes passed to the program via
standard input or a supplied file. Input is expected to be a list of
node ids separated by newlines. Both forward and backward slices can
be calculated. For each node, the tool generates a line of output of
the following format:

.. code-block:: none

	label TAB NodeId_1 ... NodeId_m TAB EdgeId_1 .... EdgeId_n

where label is the id of the reference node, NodeId_1 ... NodeId_m is
the list of nodes of the slice and EdgeId_1 .... EdgeId_n is the list
of edges.

Forward Slices
""""""""""""""
The exact behavior depends on the node type:

- **Statements and Conditions:** For statement and condition nodes
  (i.e., nodes where ``isCFGNode``is `True``), the slice is calculated
  for all symbols defined by the statement.

- **Arguments:** The slice is calculated for all symbols defined by the
argument.

- **Callee:** The slice is calculated for all symbols occurring on the
left hand side of the assignment (*return values*).

Backward Slices
"""""""""""""""
The exact behavior depends on the node type:

- **Statements, Conditions and Callees:** For statement and condition nodes
  (i.e., nodes where ``isCFGNode``is `True``), the slice is calculated
  for all symbols used by the statement.

- **Arguments.** The slice is calculated for all symbols used inside the
argument.

