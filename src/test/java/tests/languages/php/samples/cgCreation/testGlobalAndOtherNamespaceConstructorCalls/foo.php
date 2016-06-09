<?php

namespace A\B {

  class ClassFoo {
    public function __construct() {}
  }

  class ClassBar {
    public function __construct() {}
  }

  new ClassFoo(); // calls \A\B\ClassFoo::__construct()
  new \ClassFoo(); // calls global ClassFoo::__construct()
  new \A\B\ClassFoo(); // calls \A\B\ClassFoo::__construct()
  new \A\B\ClassBar(); // calls \A\B\ClassBar::__construct()
  new ClassBuz(); // not found
  new \ClassBuz(); // calls global ClassBuz::__construct()
}

namespace {

  class ClassFoo {
    public function __construct() {}
  }

  class ClassBuz {
    public function __construct() {}
  }

  new ClassFoo(); // calls global ClassFoo::__construct()
  new \ClassFoo(); // calls global ClassFoo::__construct()
  new \A\B\ClassFoo(); // calls \A\B\ClassFoo::__construct()
  new \A\B\ClassBar(); // calls \A\B\ClassBar::__construct()
  new ClassBuz(); // calls global ClassBuz::__construct()
  new \ClassBuz(); // calls global ClassBuz::__construct()
}
