<?php

class ClassOne {
  public function foo() {
    $this->foo();
    $classtwo = new ClassTwo();
    $classtwo->foo("foo");
  }
}

class ClassTwo {
  public function foo($a) {
    $classone = new ClassOne();
    $classone->foo();
    $this->foo("bar");
  }
}

$classone = new ClassOne();
$classtwo = new ClassTwo();
$classone->foo();
$classtwo->foo("foo");
