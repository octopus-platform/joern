<?php

switch ($i) {
  case "foo":
    break;
  case 1.42:
  case 2:
    break;
  default:
    buz();
}
