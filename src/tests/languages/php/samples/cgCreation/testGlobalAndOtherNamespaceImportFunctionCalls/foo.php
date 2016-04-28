<?php

namespace A\B {

  function foo() {}

  C\bar(); // calls \A\B\C\bar()
}

namespace A\B\C {

  use A\B as D;

  function bar() {}

  D\foo(); // calls \A\B\foo()
  D\C\bar(); // calls \A\B\C\bar()
}

namespace {

  use A\B;
  use A\B\C as E;

  B\foo(); // calls \A\B\foo()
  \B\foo(); // absolute reference, not translated - not found
  B\C\bar(); // calls \A\B\C\bar()
  E\bar(); // calls \A\B\C\bar()
  \D\bar(); // absolute reference, not translated - not found
}
