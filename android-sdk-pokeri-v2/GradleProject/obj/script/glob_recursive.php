<?php
	error_reporting(E_ALL);
	require_once('F:/php1/CommonLib/Lib.class.php');

	$fdps= Lib::glob_recursive('F:\\java\\gradle','build.gradle');
	//echo count($fdps);

	for($i=0;$i<count($fdps);$i++){
		echo $fdps[$i]."\n";
	}
