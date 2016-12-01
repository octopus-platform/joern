<?php
namespace B;

include_once "foo.php";

class ClassTwo {
  static function bar() {}
}

\A\ClassOne::foo();
