<?php
	error_reporting(E_ALL);
	require_once('F:/php1/CommonLib/Lib.class.php');

	$fdps= Lib::glob_recursive('F:\\GitHub\\android-sdk-pokeri-v2','*.fdp');
	//echo count($fdps);

	for($i=0;$i<count($fdps);$i++){
		echo $fdps[$i]."\n";
	}
