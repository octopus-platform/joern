#!/bin/sh
#
# Usage:
#
#    import_testcode.sh /path/to/testcodedir
#

codedir_parent=`dirname "$1"`
project_name=`basename "$1"`

tar -zcvf "$project_name".tar.gz -C "$codedir_parent" "$project_name" && \
octopus-project delete "$project_name".tar.gz && \
joern-import "$project_name".tar.gz && \
rm "$project_name".tar.gz

