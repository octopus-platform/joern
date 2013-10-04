#!/bin/bash

ant tools
time java -jar ./bin/udg.jar
time java -jar ./bin/ddg.jar
