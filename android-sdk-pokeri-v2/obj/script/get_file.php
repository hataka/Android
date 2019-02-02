<?php // -*- mode: php -*-  Time-stamp: <2017-01-03 11:51:58 kahata>
/*================================================================
 * title: 
 * file: get_file.php
 * path: F:\codingground\java\isemba\get_file.php
 * url:  F:/codingground/java/isemba/get_file.php
 * created: Time-stamp: <2016-09-13 8:43:57 kahata>
 * revised: Time-stamp: <2017-01-03 11:51:58 kahata>
 * revision: $Id$
 * Programmed By: 畑　和彦
 * To compile:
 * To run: 
 * link: 
 * description: 
 *================================================================*/
	error_reporting(E_ALL);
	require_once('F:/php1/CommonLib/Lib.class.php');
	//if ($_SERVER['HTTP_HOST'] == 'kahata.travel.coocan.jp') {
	//	require_once('/homepage/php1/lib/file_util_nogeshi.inc.php');
	//} else {
	//	require_once('F:/php1/lib/file.inc.php');
	//}
/*
	define('GET_SITE',      false);
	define('GET_SOURCE',    false);
	define('CLEAR_ALL',     false);
	define('BUILD_FILES',   false);
	define('PROJECT_FILES', false);
	define('EXEC_BUILD',    false);
	define('EXEC_CLEAN',    false);
*/
	define('GET_SITE',      0b0000000000000001);
	define('GET_SOURCE',    0b0000000000000010);
	define('CLEAR_ALL',     0b0000000000000100);
	define('BUILD_FILES',   0b0000000000001000);
	define('PROJECT_FILES', 0b0000000000010000);
	define('EXEC_BUILD',    0b0000000000100000);
	define('EXEC_CLEAN',    0b0000000001000000);

	global $option,$br,$nemu_content;
	//var $sitelist = array();
	//var $codelist = array();
	$recordset = array();
	$option = 'overwrite';
	$br = isset($_SERVER["HTTP_USER_AGENT"]) ? "<br />\n" : "\n";


	//====== メイン処理 ======
	//$target =  (BUILD_FILES|GET_SOURCE);
	$target =  (BUILD_FILES);
	//echo $target;
	array_push($recordset,isemba_get_record());
	//print_r($recordset);
	//if(GET_SOURCE & $target) save_srcfiles($recordset);
	if(BUILD_FILES & $target) copy_templateFiles('template/build', $recordset);
	//if(PROJECT_FILES & $target) copy_templateFiles('template/ProjectTemplate', $recordset);

	//$mxmlfiles= Lib::glob_recursive('F:\\GitHub\\apache\\flex-utilities\\TourDeFlex\\TourDeFlex3\\src','*.mxml');
	//print_r($mxmlfiles);
	//echo count($mxmlfiles);

	//====== public functions ======
	
	function isemba_get_record(){
		global $br;
		$record = array();
		$site ="http://antlers.cis.ibaraki.ac.jp/PROGRAM/JAVA/java.shtml";
		$template_dir = __DIR__."\\template";
		$pattern ="'<a href=\"(.+?)\">'s";
		$record['index_name'] = "java_isemba";
		$record['index_site'] = $site;
		$record['pattern'] = $pattern;
		$index = file_get_contents($site);
		$count = preg_match_all($pattern,$index,$matches);
		//echo $count; //742
		$record['count'] = $count;
		
		//$offset = 0; $length = 742; //全レコード
		$offset = 0; $length = 591; //SERVLET より以前
		//$offset = 0; $length = 58;  // KISO
		//$offset = 58; $length = 143-58;  // CLASS
		
		//foreach($matches[1] as $match)echo $match."\n";
		for($i = $offset;$i<$offset+$length; $i++){ //SERVLET より以前
			$filebody = Lib::filebody($matches[1][$i]);
			$output = "";
			$pattern ="'<pre>(.+?)</pre>'s";
			$sitelist = dirname($site).'/'.$matches[1][$i];
			$content = file_get_contents($sitelist);
			$count2 = preg_match_all($pattern,$content,$matches2);
			if($count2 > 0) $output .= $matches2[1][0];
			if($count2 > 1){
				for($j=1;$j<$count2;$j++) $output .= "\n/** \n".trim($matches2[1][$j])."\n */ \n"; // */
			}
			//$content = strip_tags($content);
			$output = str_replace('^Z',"",$output);
			$record['record'][$i-$offset]['site'] = dirname($site).'/'.$matches[1][$i];
			$record['record'][$i-$offset]['path'] = str_replace(dirname($site),"",dirname($matches[1][$i])).'/'.$filebody.'/'.$filebody.'.java';
			$record['record'][$i-$offset]['content'] = $output;
		}
		return $record;
	}

	function save_srcfiles($recordset,$basedir= "./"){
		global $br;
		//$basedir = "test/";
		for($i=0;$i<count($recordset);$i++){
			for($j=0;$j<count($recordset[$i]['record']);$j++){
				$dist = $basedir.$recordset[$i]['record'][$j]['path'];
				$content = $recordset[$i]['record'][$j]['content'];
				if (!is_dir(dirname($dist))) mkdir(dirname($dist),0700,true);
				if($content !=""){
					$res = file_put_contents($dist,$content);
					echo 'save to '.$dist.$br;
				}
			}
		}
	}
	// TODO: c_heading
	function copy_templateFiles($template_dir,$recordset,$basedir="",$option = "overwrite"){
		global $br,$target;
		//$basedir = "test/";
		for($i=0;$i<count($recordset);$i++){
			for($j=0;$j<count($recordset[$i]['record']);$j++){
				$distpath = $recordset[$i]['record'][$j]['path'];
				//echo $distpath.$br;
				Lib::copy_templateFiles($template_dir, $basedir.dirname($distpath), Lib::filebody($distpath),$option);
			}
		}
	}
	
	//$javafiles= Lib::glob_recursive('F:\\java\\isemba','*.java');
/*
	//for($i=0;$i<1;$i++){
	for($i=0;$i<count($javafiles);$i++){
		$dist = __DIR__."/".str_replace('F:/java/isemba/','',$javafiles[$i]);
		$dist = str_replace("\\","/",$dist);
		$contents = file_get_contents($javafiles[$i]); 
		if(GET_SOURCE){
			if (!is_dir(dirname($dist))) mkdir(dirname($dist),0700,true);
			$res = file_put_contents($dist,$contents);
			//copy($java,$dir.'/'.basename($java)); 
			echo ('copy '.$javafiles[$i].' to '.$dist.$br);
		}
		if (CLEAR_ALL){
			Lib::rrmdir(dirname(dirname($dist)));
			echo ('delete '.dirname($dist).$br);
		}
		if (BUILD_FILES){
			//copy_templateFiles('template/build', dirname($dist), filebody($javafiles[$i]));
			Lib::copy_templateFiles('template/build', dirname($dist), Lib::filebody($javafiles[$i]),"overwrite");
		}
		if (PROJECT_FILES){
			//copy_templateFiles('template/ProjectTemplate', $dir, Lib::filebody($java));
			Lib::copy_templateFiles('template/ProjectTemplate', dirname($dist), Lib::filebody($javafiles[$i]),"overwrite");
		}
		if(EXEC_BUILD) {
			//$cmdline = "cmd.exe /c ". $dir ."\\build.bat";
			//echo $cmdline.$br;
			//echo shell_exec($cmdline);
		}
		if(EXEC_CLEAN) {
			$cmdline = "cmd.exe /c ". $dir ."\\build.bat clearall";
			echo $cmdline.$br;
			echo shell_exec($cmdline);
		}
		//echo $br;
	*/
	
	//}

