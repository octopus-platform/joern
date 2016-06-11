<?php

$x = source();
if( $x < MAX) {
  $y = 2*$x;
  sink($y);
}
