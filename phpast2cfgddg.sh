#!/bin/bash

BASEDIR=$(dirname "$0")

java -cp "$BASEDIR/build/libs/joern-php.jar:$BASEDIR/jars/*" tools.php.ast2cfgddg.Main $@
