<?php

function foo() {
  yield 42;
  yield $somekey => bar();
  buz();
}

foo();
