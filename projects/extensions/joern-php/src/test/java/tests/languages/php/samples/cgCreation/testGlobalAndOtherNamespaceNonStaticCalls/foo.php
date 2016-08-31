<?php

namespace A\B {

  class ClassFoo {
    public function foo() {}
  }

  class ClassBar {
    public function foo() {}
  }

  (new ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
  (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
  (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
  (new \A\B\ClassBar())->foo(); // calls \A\B\ClassBar()->foo()
  (new ClassBuz())->foo(); // not found
  (new \ClassBuz())->foo(); // calls global ClassBuz()->foo()
}

namespace {

  class ClassFoo {
    public function foo() {}
  }

  class ClassBuz {
    public function foo() {}
  }

  (new ClassFoo())->foo(); // calls global ClassFoo()->foo()
  (new \ClassFoo())->foo(); // calls global ClassFoo()->foo()
  (new \A\B\ClassFoo())->foo(); // calls \A\B\ClassFoo()->foo()
  (new \A\B\ClassBar())->foo(); // calls \A\B\ClassBar()->foo()
  (new ClassBuz())->foo(); // calls global ClassBuz()->foo()
  (new \ClassBuz())->foo(); // calls global ClassBuz()->foo()
}
