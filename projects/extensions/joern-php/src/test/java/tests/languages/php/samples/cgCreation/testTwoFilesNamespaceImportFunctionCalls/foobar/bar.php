<?php
namespace D\E\F;
use A\B\C as G, D\E\F as H;

include_once "foo.php";

function bar() {}

\A\B\C\foo(); // absolute reference - works
G\foo(); // translated to A\B\C\foo(); - works
H\bar(); // translated to A\B\C\foo(); - works
\G\foo(); // absolute reference, not translated - not found

namespace Y; // cancels all uses in effect

G\foo(); // not found
use A\B\C as G;
G\foo(); // translated to D\E\F\bar(); - works
