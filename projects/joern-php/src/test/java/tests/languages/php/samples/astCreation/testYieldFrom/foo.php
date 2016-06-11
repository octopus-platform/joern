<?php

function foo() {
  yield from [4, 2];
  yield from new ArrayIterator(["hello", "world"]);
  yield from bar();
}
