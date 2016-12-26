#!/bin/bash

ant
ant tools

rm -rf .testDB
java -jar bin/joern.jar testCode -outdir .testDB

# Taint sources 

java -jar bin/argumentTainter.jar -dbdir .testDB taint_source 1
java -jar bin/argumentTainter.jar -dbdir .testDB second_taint_source 0
java -jar bin/argumentTainter.jar -dbdir .testDB interproc_callee 0
