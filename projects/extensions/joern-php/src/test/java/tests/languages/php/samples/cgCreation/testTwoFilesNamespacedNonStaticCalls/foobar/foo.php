<?php
namespace A;

include_once "bar.php";

class ClassOne {
  public function foo() {}
}

$classtwo = new \B\ClassTwo();
$classtwo->bar();
