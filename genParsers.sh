#!/bin/bash
antlr4='java -jar bin/antlr4-4.0.1-SNAPSHOT-complete.jar'

$antlr4 src/antlr/CodeSensor.g4
$antlr4 src/antlr/FineFunctionGrammar.g4

