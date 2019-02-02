
<?php
/*===========================================================================
 * ƒvƒƒOƒ‰ƒ€–¼: sslib213.php
 * ì¬“ú: Sun Feb 10 15:18:42 2002
 * $Id: sslib213.php,v 1.1 2008/03/26 13:42:58 kazuhiko Exp $
 * Programmed By: ”¨˜a•F
 * To compile:
 * To run: {@link http://localhost/php1/sslib/sslib213_good.php
 * To folder: {@link http://localhost/php1/sslib_class/sslib_class.lnk}
 * à–¾: 
 *=============================================================================
 * š ‰ÈŠw‹ZpŒvZƒTƒuƒ‹[ƒ`ƒ“ƒ‰ƒCƒuƒ‰ƒŠ[  
 * p.18 2.1.3 •¡‘f”@‘Î”Aw”AƒxƒLæi‚b‚k‚n‚fA‚b‚d‚w‚oA‚b‚o‚v‚qj
 * create    Sun Feb 10 15:18:42 2002
 *=============================================================================*/
 
//-----------------------
	//header('Content-Type: text/html;charset=Shift_JIS');
 	print("<pre><font size=5>");  
  $a = array( 2.0, 2.0);
  $b = array( 1.0, 1.0);
  $z = array( 0.0, 0.0);

    printf ("\n%60s\n","š ‰ÈŠw‹ZpŒvZƒTƒuƒ‹[ƒ`ƒ“ƒ‰ƒCƒuƒ‰ƒŠ[iPHPj");
    printf("       2.1.3 •¡‘f”@‘Î”Aw”AƒxƒLæ i‚b‚k‚n‚fA‚b‚d‚w‚oA‚b‚o‚v‚qj\n\n");
//   $p = new sslib();
  $z = clog($a);
  $format = '        log(%5.2f + %5.2f*i) = ( %12.6e ) + ( %12.6e )*i'."\n";
  printf($format, $a[0],$a[1],$z[0],$z[1]);

  $z = cexp($a);
  $format = '        exp(%5.2f + %5.2f*i) = ( %12.6e ) + ( %12.6e )*i'."\n";
  printf($format, $a[0],$a[1],$z[0],$z[1]);

  $z = cpwr($a, $b);
  $format = '  (%5.2f+%5.2f*i)^(%5.2f+%5.2f*i) = ( %12.6e ) + ( %12.6e )*i'."\n";
  printf($format, $a[0],$a[1],$b[0],$b[1],$z[0],$z[1]);

  print("</font></pre>");  

/**
 * cmul  •¡‘f”‚ÌÏ‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ [re,im]‚Å•Ô‚·
 *
 * {@source }
 * @access public
 * @param array [re,im]
 * @param array [re,im]
 * @return array •¡‘f”‚ÌÏ‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @uses Sslib212()
 */
  function cmul($a, $b){
    $z = array();

  $z[1] = $a[0]*$b[1] + $b[0]*$a[1];
  $z[0] = $a[0]*$b[0] - $a[1]*$b[1];
  return $z;
  }

/**
 * cdiv  •¡‘f”‚Ì¤‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ $z[re,im]‚Å•Ô‚·
 * {@source }
 * @access public
 * @param array [re,im]
 * @param array [re,im]
 * @return array •¡‘f”‚Ì¤‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @uses Sslib212()
 */
  function cdiv($a, $b){
    $z =array();
  
    if (cabs($b) == 0.0){
      $z[0] = 999.0;
      $z[1] = 999.0;
      return $z;
    }
    $z[1] = ($b[0]*$a[1]-$a[0]*$b[1])/($b[0]*$b[0]+$b[1]*$b[1]);
    $z[0] = ($a[0]*$b[0]+$a[1]*$b[1])/($b[0]*$b[0]+$b[1]*$b[1]);
    return $z;
  }

/**
 * cadd  •¡‘f”‚Ì˜a‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ [re,im]‚Å•Ô‚·
 * {@source }
 * @access public
 * @param array [re,im]
 * @param array [re,im]
 * @return array •¡‘f”‚Ì˜a‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @see csub()
 */
  function cadd($a, $b){
    $z = array();

    $z[0] = $a[0] + $b[0];
    $z[1] = $a[1] + $b[1];
    return $z;
  }

/**
 * csub  •¡‘f”‚Ì·‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ [re,im]‚Å•Ô‚·
 * {@source }
 * @access public
 * @param array [re,im]
 * @param array [re,im]
 * @return array •¡‘f”‚Ì·‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @see sslib211::sslib211()
 */
  function csub($a, $b){
    $z[0] = $a[0] - $b[0];
    $z[1] = $a[1] - $b[1];
    return $z;
  }

/**
 * cabs  •¡‘f”‚Ìâ‘Î’l‚ğ•Ô‚·
 * {@source }
 * @access public
 * @param array
 * @return double •¡‘f”‚Ìâ‘Î’l‚ğdouble‚Å•Ô‚·
 * @uses Sslib215()
 */
  function cabs($a){
    return sqrt($a[0]*$a[0]+$a[1]*$a[1]);
  }

/**
 * cexp  •¡‘f”‚Ìw”‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ $z[re,im]‚Å•Ô‚·
 * {@source }
 * @access public
 * @param array [re,im]
 * @return array •¡‘f”‚Ì¤‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @uses Sslib213()
 */
function cexp($a) {
  $z = array();
  $w = 0;
  
  $w = exp($a[0]);
  $z[0] = $w * cos($a[1]);
  $z[1] = $w * sin($a[1]);
  return $z;
}

/**
 * cexp  •¡‘f”‚Ì‘Î”‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ $z[re,im]‚Å•Ô‚·
 * {@source }
 * @access public
 * @param array [re,im]
 * @return array •¡‘f”‚Ì‘Î”‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @uses Sslib213()
 */
function clog( $a ) {
  $z = array();
  $w = 0;
  
  $w = cabs($a);
  if ($w == 0){
    $z[0] = 999.0;
    $z[0] = 999.0;
    return $z;
  }
  if ($a[0] != 0){
    $z[1] = atan($a[1]/$a[0]);
  }
  else if ($a[1]==0){
    $z[1] = 0;
  }
  else {
    $z[1] = ($a[1]<0?-1:1)*1.5907963;
  }
  $z[0] = log($w);
  return $z;
}

/**
 * cexp  •¡‘f”‚ÌƒxƒLæ‚ğ‹‚ßŒ‹‰Ê‚ğ”z—ñ $z[re,im]‚Å•Ô‚·
 * {@source }
 * @access public
 * @param array [re,im]
 * @param array [re,im]
 * @return array •¡‘f”‚ÌƒxƒLæ‚ğ”z—ñ[re,im]‚Å•Ô‚·
 * @uses Sslib213()
 */
function cpwr($a, $b) {
  $z =array();
  $w = 0;
  
  $w = clog($a);
  if ($w[0] == 999.0 && $w[0]==999.0){
    $z[0] = 999.0;
    $z[1] = 999.0;
    return  $z;
  }
  $w = cmul($w, $b);
  $z = cexp($w);
  return $z;
}


//‚o‚g‚o‚ÌI‚í‚è
?>
