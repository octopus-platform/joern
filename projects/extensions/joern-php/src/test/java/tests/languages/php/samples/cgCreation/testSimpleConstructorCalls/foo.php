<?php

class ClassOne {
  public function __construct() {
    new ClassOne();
    new ClassTwo("foo");
  }
}

class ClassTwo {
  public function ClassTwo($a) {
    new ClassOne();
    new ClassTwo("bar");
  }
}

new ClassOne();
new ClassTwo("bar");
