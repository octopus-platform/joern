<?php

try {
  foo();
  bar();
}
catch(FooException $f) {
  buz();
}
catch(BarException $b) {
  qux();
}
finally {
  norf();
}
