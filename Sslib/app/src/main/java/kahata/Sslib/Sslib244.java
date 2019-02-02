// * -*- mode: java -*-  Time-stamp: <08/02/19(火) 18:16:05 hata>
/*================================================================
 * プログラム名: Sslib244.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib244.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.77  2.4.4 超越代数方程式　レギュラ・ファルシ法（ＲＥＧＵＬＡ）
 *
 *   機能        高次代数方程式や超越代数方程式
 *                   f(x) = 0
 *               の実根をregula-falsi法で１根だけ求める。
 *
  *----------------------------------------------------------------------------
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
class Sslib244 {
	public  String output() {

		double x;
		double xs = 0,
		xe = 1,
		h = 0.1;
		double eps = 1e-16;

		//AlgEquation p = new AlgEquation();

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("               ★ 科学技術計算サブルーチンライブラリー（Ｃ）\n");
		rs +=  String.format( "         2.4.4 超越代数方程式　レギュラ・ファルシ法（ＲＥＧＵＬＡ）\n\n");
		rs +=  String.format( "                      exp(x) - 2.0 = 0\n");

		x = AlgEquation.regula(xs, xe, h, eps);
		if(x==1 || x==2.0 || x==-1) return "";
		rs +=  String.format("                          x =% 20.16E\n", x);
		rs +=  String.format("                      exact =% 20.16E\n\n", Math.log(2.0));
		return rs ;
	}
}
/*********************
	static double func(double x){
  		double f;
  		f = Math.exp(x) - 2.0;
  		return(f);
	}

	static double regula(double xs,double xe, double h, double eps){
  		int ic;
  		double x,x0,y0,x1,y1,x2,y2;
  
  		if(xs>=xe || h<=0 || eps<=0)
    		return(-1);
  		x0 = xs;
  		x1 = xe;
  		y1 = func(x1);
  		do{
    		y0 = func(x0);
    		if(y0*y1<=0.0) break;
    		x0 = x0 + h;
    		if((x0-xe)>0.0)
      		return(1);
  		} while (true);
  		for(ic=0; ic<1000; ic++){
    		x2 = x0 - y0 * (x1 - x0) / (y1 - y0);
    		y2 = func(x2);
    		if(y0*y2>=0){
      		x0 = x2;
      		y0 = y2;
    	}
    	else{
      		x1 = x2;
      		y1 = y2;
    	}
    	if(Math.abs(y2)<=eps){
      		x = x2;
      		return(x);
    	}
  	}
	return 0;
}
**************************/

