<?php

function counttothree() {
  foreach( [1,2,3] as $index => $value)
    yield $index => $value;
}
