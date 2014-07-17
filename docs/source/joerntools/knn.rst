
joern-knn
=========

SYNOPSIS
---------

joern-knn [options]

DESCRIPTION
-----------

knn.py is a tool to identify similar functions/program slices. It does
not deal with the extraction of functions from code nor their
characterization (see embedder.py), however, given a representation of
each function/program-slice by a set of strings, it allows similar
functions to be identified.

OPTIONS
-------

-l --limit <file>

Limit possible neighbours to those specified in the  provided
file. The file is expected to contain ids of possible neighbors
separated by newlines.

-d --dirname <dirname>

The name of the directory containing the embedding, as for example,
created by apiEmbed.py. In summary, the directory must contain the
following files.

/TOC

A line containing labels for each data point where the i'th line
contains the label for the i'th data point.

/data/$i

The i'th data point where $i is an ordinal. Lines of the file
correspond to elementary features. For example, if the function is
represented by API symbols and it contains the symbol 'int' twice, the
corresponding file will be contain the lines:

int
int

Write-access to this directory is required as knn.py will cache
distance matrices in this directory.
