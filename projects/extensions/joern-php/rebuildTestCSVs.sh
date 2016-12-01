#!/bin/bash

# path to phpjoern installation
PHPJOERN=/your/path/to/phpjoern

parsePHP() {
  echo "$1"
  cd "$1"
  # start parsing---let's hear error messages only:
  $PHPJOERN/php2ast -f jexp -n nodes.csv -r edges.csv . >/dev/null
}

export PHPJOERN
export -f parsePHP

find src/test/java/tests/languages/php/samples/ -name "*.csv" -delete
find src/test/java/tests/languages/php/samples/ -mindepth 2 -maxdepth 2 -type d \
    -exec bash -c 'parsePHP "{}"' \;
