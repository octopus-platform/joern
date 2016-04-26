<?php
namespace A;

include_once "bar.php";

class ClassOne {
  static function foo() {}
}

\B\ClassTwo::bar();
