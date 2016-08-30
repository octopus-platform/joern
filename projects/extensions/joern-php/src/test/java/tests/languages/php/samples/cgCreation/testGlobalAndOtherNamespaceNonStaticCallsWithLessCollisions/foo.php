<?php

namespace A\B {

  class ClassFoo {
    public function foo() { echo "ab foo", PHP_EOL; }
  }

  class ClassBar {
    public function bar() { echo "ab bar", PHP_EOL; }
  }

  (new ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
  (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
  (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
  (new \A\B\ClassBar())->bar(); // calls \A\B\ClassBar()->bar()
  (new ClassBuz())->buz(); // not found
  (new \ClassBuz())->buz(); // calls global ClassBuz()->buz()
}

namespace {

  class ClassFoo {
    public function foo() { echo "global foo", PHP_EOL; }
  }

  class ClassBuz {
    public function buz() { echo "global buz", PHP_EOL; }
  }

  (new ClassFoo())->foo(); // calls global ClassFoo()->foo()
  (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
  (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
  (new \A\B\ClassBar())->bar(); // calls \A\B\ClassBar()->bar()
  (new ClassBuz())->buz(); // calls global ClassBuz()->buz()
  (new \ClassBuz())->buz(); // calls global ClassBuz()->buz()
}
