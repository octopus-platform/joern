<?php

namespace A\B {

  class ClassFoo {
    static function foo() {}
  }

  class ClassBar {
    static function foo() {}
  }

  ClassFoo::foo(); // calls \A\B\ClassFoo::foo()
  \ClassFoo::foo(); // calls global ClassFoo::foo()
  \A\B\ClassFoo::foo(); // calls \A\B\ClassFoo::foo()
  \A\B\ClassBar::foo(); // calls \A\B\ClassBar::foo()
  ClassBuz::foo(); // not found
  \ClassBuz::foo(); // calls global ClassBuz::foo()
}

namespace {

  class ClassFoo {
    static function foo() {}
  }

  class ClassBuz {
    static function foo() {}
  }

  ClassFoo::foo(); // calls global ClassFoo::foo()
  \ClassFoo::foo(); // calls global ClassFoo::foo()
  \A\B\ClassFoo::foo(); // calls \A\B\ClassFoo::foo()
  \A\B\ClassBar::foo(); // calls \A\B\ClassBar::foo()
  ClassBuz::foo(); // calls global ClassBuz::foo()
  \ClassBuz::foo(); // calls global ClassBuz::foo()
}
