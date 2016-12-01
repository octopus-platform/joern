<?php

class SomeClass {
  use Foo, Bar, Buz {
    qux as protected _qux;
    Bar::norf as private;
    Foo::nicknack insteadof Bar, Buz;
  }
}
