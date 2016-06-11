<?php

$foo =& $someref;
$bar[3] =& $someref[4];
$buz->qux =& $buz->somecall();
Buz::$qux =& Buz::somestaticcall();
