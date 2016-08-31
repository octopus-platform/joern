<?php

const MAX = 10;

function foo() {
  $x = source();
  if( $x < MAX) {
    $y = 2*$x;
    sink($y);
  }
}

function source() {
  global $argv;
  return $argv[1];
}

function sink($arg) {
  echo $arg, PHP_EOL;
}

foo();
