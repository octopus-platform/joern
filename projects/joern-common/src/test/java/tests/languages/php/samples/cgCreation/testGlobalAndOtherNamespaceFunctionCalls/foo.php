<?php

namespace A\B {

  function foo() {}
  function bar() {}

  foo(); // calls \A\B\foo()
  \foo(); // calls global foo()
  \A\B\foo(); // calls \A\B\foo()
  \A\B\bar(); // calls \A\B\bar()
  buz(); // calls global buz()
}

namespace {

  function foo() {}
  function buz() {}

  foo(); // calls global foo()
  \foo(); // calls global foo()
  \A\B\foo(); // calls \A\B\foo()
  \A\B\bar(); // calls \A\B\bar()
  buz(); // calls global buz()
}
