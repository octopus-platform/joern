<?php
namespace B;

include_once "foo.php";

class ClassTwo {
  public function bar() {}
}

$classone = new \A\ClassOne();
$classone->foo();
