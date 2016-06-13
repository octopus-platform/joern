#!/bin/sh

OPTS_FROM_ORIENTDB="-server -Xmx512m -Djna.nosys=true -XX:+HeapDumpOnOutOfMemoryError -Djava.awt.headless=true -Dfile.encoding=UTF8 -Drhino.opt.level=9 -Dprofiler.enabled=true"

OCTOPUS_HOME=`dirname $0`

exec java $JAVA_OPTS $OPTS_FROM_ORIENTDB -DOCTOPUS_HOME="$OCTOPUS_HOME" -cp "$OCTOPUS_HOME/jars/*" octopus.OctopusMain
