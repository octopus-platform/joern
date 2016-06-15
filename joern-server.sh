#!/bin/sh

BASEDIR=$(dirname "$0")

while getopts :d: opt
do
	case $opt in
		d) JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=$OPTARG"
	esac
done

export JAVA_OPTS

$BASEDIR/projects/octopus/octopus-server/octopus-server.sh
