// * -*- mode: java -*-  Time-stamp: <08/02/18(月) 17:31:20 hata>
/*================================================================
 * プログラム名: Sslib243.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib243.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.72  2.4.2 高次代数方程式　ニュートン法（ＮＥＷＴＯＮ）
 *
 *   機能        高次代数方程式
 *                   a1*x^n+a2*x^(n=1)+.....+an*x+a(n+1)=0 ;a1≠0
 *                   の１つの実根をnewton-raphson法により求める
 *------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;
/*
class Ccomplex {
    double x=0,y=0;
    Ccomplex(double a,double b) {
	x = a;
	y = b;
    }
}
*/

class Sslib242 {
	public  String output() {
		int i;
		int np1=4;
		double x;
		double a[]={ 0.1, -0.5, 0.8, 1.4};
		double eps=0.0000000000000001;

		//AlgEquation p = new AlgEquation();

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("              ★ 科学技術計算サブルーチンライブラリー（Ｃ）\n");
		rs +=  String.format("            2.4.2 高次代数方程式　ニュートン法（ＮＥＷＴＯＮ）\n\n");
		rs +=  String.format("          ");
		for(i=0; i<np1; i++)
			rs +=  String.format(" +(% 4.2f)x^%d", a[i], (np1-i-1));
		rs +=  String.format("  = 0\n");

		x = AlgEquation.newton(a, np1, eps);
		rs +=  String.format("                       x  = % 18.12E\n\n", x);
		return rs;
	}
}

/*******************
	static double newton(double[] a, int np1, double eps){
  		int i,n,m,nm1;
  		double a1,d,dx,p,q,r,w,x;

  //  int i,n,m,nm1;
  //  double a1,d,dx,p,q,r,w,x;
  
  n = np1 - 1;
  x = a[0];
  a1 = Math.abs(x);
  if(a[0]==0.0 || np1<3 || eps<= 0)
    return(-1);
  for(i=1; i<n; i++){
    w = a[i];
    x = x + w;
    if(a1<Math.abs(w))
      a1 = Math.abs(w);
  }
  x = -x / np1;
  for(i=0; i<50; i++){
    p = a[0];
    for(i=1; i<np1; i++)
      p = p * x + a[i];
    m = n;
    q = m * a[0];
    for(i=1; i<n; i++){
      m = m - 1;
      q = q * x + m * a[i];
    }
    if(q!=0){
      dx = -p / q;
      //      goto nwm;
    } else {
      m = n;
      nm1 = n - 1;
      r = m * nm1 * a[i];
      for(i=1; i<nm1; i++){
	m = m - 1;
	r = r * x + m * (m - 1) * a[i];
      }
      d = p * (p - 2 * r);
      if(d<=0){
	dx = -q / p;
	//	goto nwm;
      } else {
	w = Math.sqrt(d);
	if(q!=0){
	  dx = 2 * p / (-q + w);
	}
	else{
	  dx = 2 * p / (-q - w);
	}
      }
    }
    // nwm:;
    x = x + dx;
    if(Math.abs(dx)/a1<=eps)
      return(x);
  }
  return(1);

	}
************************/
