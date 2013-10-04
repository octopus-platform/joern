#!/bin/bash

ant
ant tools

rm -rf .testDB
java -jar bin/joern.jar testCode -outdir .testDB
java -jar bin/udg.jar -dbdir .testDB
java -jar bin/ddg.jar -dbdir .testDB

# Taint sources 

java -jar bin/argumentTainter.jar -dbdir .testDB taint_source 1
java -jar bin/argumentTainter.jar -dbdir .testDB second_taint_source 0

