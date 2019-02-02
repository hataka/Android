// * -*- mode: java -*-  Time-stamp: <08/02/27(水) 17:28:33 hata>
/*================================================================
 * プログラム名: Sslib261.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib261.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *--------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.99 2.6.1 １階常微分方程式　ルンゲ・クッタ・ギル法（ＲＮＧＫＧ）
 *
 *   機能        １階常微分方程式の解を、runge-kutta-gill法で求める
 *
 *--------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib261 extends DifEquation {

	static class func_rngkg implements Func {
		public double func(double x, double y) {
  			return(y + 1);
		}
	}

	public  String output() {
		int n = 100,ier;
  	double x0,y0,h,exact;
  	double[] y = new double[50];
		Func po = new func_rngkg();

  	x0 = 0.0;
  	y0 = 0.0;
  	h =  0.05;
  	n = 20;
  	exact = Math.exp(1.0) - 1.0;

		// 文字列変数の宣言
		String rs;
		
		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("        2.6.1 １階常微分方程式　ルンゲ・クッタ・ギル法（ＲＮＧＫＧ）\n\n");
		rs +=  String.format("                  given equation: dx/dy = y + 1\n");
		rs +=  String.format("                                 x  =% 8.3f\n", x0);
		rs +=  String.format("                             width  =% 8.3f\n", h);

		rs +=  String.format( "              solution by rngkg:\n");
  
		ier = rngkg(po, x0, y0, n, h, y);
		rs +=  String.format("                            result  =% 16.12f\n", y[n-1]);
		rs +=  String.format("                             exact  =% 16.12f\n", exact);

		rs +=  String.format("              error code:\n");
		rs +=  String.format("                               ier  = %3d\n\n", ier);
		return rs;
	}
}
