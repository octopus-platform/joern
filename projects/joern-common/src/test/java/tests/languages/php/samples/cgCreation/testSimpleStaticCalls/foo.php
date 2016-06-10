<?php

class ClassOne {
  static function funcone() {
    ClassOne::funcone();
    ClassTwo::functwo("foo");
  }
}

class ClassTwo {
  static function functwo($a) {
    ClassOne::funcone();
    ClassTwo::functwo("bar");
  }
}

ClassOne::funcone();
ClassTwo::functwo();
