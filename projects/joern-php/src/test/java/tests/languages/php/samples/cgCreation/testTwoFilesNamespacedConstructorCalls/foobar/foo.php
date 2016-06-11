<?php
namespace A;

include_once "bar.php";

class ClassOne {
  public function __construct() {}
}

new \B\ClassTwo();
