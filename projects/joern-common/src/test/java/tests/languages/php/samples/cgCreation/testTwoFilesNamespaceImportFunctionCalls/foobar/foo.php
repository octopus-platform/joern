<?php
namespace A\B\C;
use \D\E\F;

include_once "bar.php";

function foo() {}

\D\E\F\bar(); // absolute reference - works
F\bar(); // translated to D\E\F\bar(); - works
\F\bar(); // absolute reference, not translated - not found

namespace X; // cancels all uses in effect

F\bar(); // not found
use \D\E\F;
F\bar(); // translated to D\E\F\bar(); - works
