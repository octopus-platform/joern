joern-apiembedder
=================

SYNOPSIS
--------

joern-apiembedder [options]

joern-stream-apiembedder [options]

DESCRIPTION
------------

embedder.py creates an embedding of functions based on the API symbols
they employ as well as a corresponding distance matrix. These
embeddings are used by knn.py to identify similar functions but may
also serve as a basis for other tools that require a vectorial
representation of code.

-d --dirname <dirname>

Output directory of the embedding. By default, output will be written
to the directory 'embedding'.

**Note:** Please use ``joern-stream-apiembedder`` in new code,
``joern-apiembedder`` is only kept around because it is still being
used by legacy code.
