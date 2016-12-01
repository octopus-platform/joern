<?php

include 'foo.php';
include_once $userinput;
require getuserinput();
require_once "http://".$userinput."bar.php";
eval("{$evilinput}");
