<?php

function funcone() {
  funcone();
  functwo("foo");
}

function functwo($a) {
  funcone();
  functwo("bar");
}

funcone();
functwo();
