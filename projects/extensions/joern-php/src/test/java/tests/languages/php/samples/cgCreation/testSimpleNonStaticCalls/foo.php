<?php

class ClassOne {
  public function funcone() {
    $this->funcone();
    $classtwo = new ClassTwo();
    $classtwo->functwo("foo");
  }
}

class ClassTwo {
  public function functwo($a) {
    $classone = new ClassOne();
    $classone->funcone();
    $this->functwo("bar");
  }
}

$classone = new ClassOne();
$classtwo = new ClassTwo();
$classone->funcone();
$classtwo->functwo("foo");
