#!/bin/sh


MAXHEAP="-Xmx${OCTOPUS_SERVER_MAXHEAP:-512m}"
MAXDISKCACHE="-Dstorage.diskCache.bufferSize=${OCTOPUS_SERVER_MAXDISKCACHE:-8192}"
OPTS_FROM_ORIENTDB="-server -Djna.nosys=true -XX:+HeapDumpOnOutOfMemoryError -Djava.awt.headless=true -Dfile.encoding=UTF8 -Drhino.opt.level=9 -Dprofiler.enabled=true"

OCTOPUS_HOME=`dirname $0`

exec java $JAVA_OPTS $MAXHEAP $MAXDISKCACHE $OPTS_FROM_ORIENTDB -DOCTOPUS_HOME="$OCTOPUS_HOME" -cp "$OCTOPUS_HOME/jars/*" octopus.OctopusMain
