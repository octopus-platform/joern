<?php

interface A {
  abstract public function foo();
}

class B implements A {
  public function foo() {
    $this->foo();
  }
}

$b =  new B();
$b->foo();
