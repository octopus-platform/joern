#!/bin/sh


MAXHEAP="-Xmx${OCTOPUS_SERVER_MAXHEAP:-3g}"
OPTS_FROM_ORIENTDB="-Djna.nosys=true -XX:+HeapDumpOnOutOfMemoryError -XX:MaxDirectMemorySize=512g -Djava.awt.headless=true -Dfile.encoding=UTF8 -Drhino.opt.level=9"
OCTOPUS_HOME=`dirname $0`

exec java $JAVA_OPTS $MAXHEAP $OPTS_FROM_ORIENTDB -DOCTOPUS_HOME="$OCTOPUS_HOME" -cp "$OCTOPUS_HOME/extensions:$OCTOPUS_HOME/lib/*:build/libs/octopus.jar" octopus.OctopusMain
