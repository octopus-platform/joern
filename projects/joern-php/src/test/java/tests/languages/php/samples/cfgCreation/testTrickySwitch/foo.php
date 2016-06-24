<?php

foo();
switch ($i) {
  case "foo":
    break;
  case "bar":
    bar();
  case 1.42:
  case 2:
    buz();
    break;
  default:
    qux();
}
norf();
