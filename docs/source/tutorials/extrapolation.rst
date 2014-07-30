Finding Similar Functions with joern-tools
==========================================

**Embed functions in vector space.**

- Represents functions by the API symbols used
- Applies TF-IDF weighting
- Dumps data in libsvm format

.. code-block:: none

	joern-stream-apiembedder


To allow this to scale to large code bases:

- database requests are chunked to not keep all results in memory at any point in time
- data is streamed onto disk

**Determine nearest neighbors.**

Get a list of available functions first:

.. code-block:: none

	joern-list-funcs


Get id of function by name:

.. code-block:: none

	joern-list-funcs -p VLCEyeTVPluginInitialize | awk -F "\t" '{print $2}'


where ``VLCEyeTVPluginInitialize`` is the name of the function in this example.

**Lookup nearest neighbors.**

.. code-block:: none

	joern-list-funcs -p VLCEyeTVPluginInitialize | awk -F "\t" '{print $2}' | joern-knn

**Show location name or location.**

.. code-block:: none

	joern-list-funcs -p VLCEyeTVPluginInitialize | awk -F "\t" '{print $2}' | joern-knn

	joern-list-funcs -p VLCEyeTVPluginInitialize | awk -F "\t" '{print $2}' | joern-knn | joern-location


**Dump code or open in editor.**

.. code-block:: none


	joern-list-funcs -p VLCEyeTVPluginInitialize | awk -F "\t" '{print $2}' | joern-knn | joern-location | joern-code

	joern-list-funcs -p VLCEyeTVPluginInitialize | awk -F "\t" '{print $2}' | joern-knn | joern-location | joern-editor

