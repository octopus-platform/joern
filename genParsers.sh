#!/bin/bash
antlr4='java -jar antlr4-4.0.1-SNAPSHOT-complete.jar'

$antlr4 src/antlr/Module.g4
$antlr4 src/antlr/Function.g4

