// * -*- mode: java -*-  Time-stamp: <08/02/27(水) 17:51:43 hata>
/*================================================================
 * プログラム名: Sslib262.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib262.c,v 1.3 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *--------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.101 2.6.2 １階常微分方程式　ハミング法（ＨＡＭＮＧ）
 *
 *   機能        １階常微分方程式の解を
 *               予測子－修正子法の一つであるhamming法で求める
 *
 *   呼出方法    call hamng(x0, y0, n, h, y(), ier)
 *   引き数  入力
 *               x0  :初期値を、実定数か実変数名で与える
 *               y0  :初期値を、実定数か実変数名で与える
 *               n   :積分の繰り返し回数を、整定数か整変数名で与える。n≦100
 *               h   :積分のきざみ幅を、実定数か実変数名で与える。h>0
 *           出力
 *               y   :y(n)なる実配列名で解を得る。
 *               ier :整変数名で、エラーフラグである
 *                       0   :エラーなし
 *                       999 :n>100,h≦0のいずれかである
 *   スレーブサブルーチン
 *               rngkg: 2.6.1のルンゲクッタ法サブルーチン
 *
 *   Cintのdllでは関数ポインタに問題あり。インタープリタで実行のこと
 *----------------------------------------------------------------------------
 */


package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib262 extends DifEquation {

	static class func_hamng implements Func {
		public double func(double x, double y) {
  			return(y + 1);
		}
	}

	public  String output() {
		int n,ier;
		double x0,y0,h,exact;
		double[] y = new double[100];
		Func po = new func_hamng();

  		x0 = 0.0;
  		y0 = 0.0;
  		h =  0.1;
  		n = 10;
  
  		exact = Math.exp(1.0) - 1.0;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("              2.6.2 １階常微分方程式　ハミング法（ＨＡＭＮＧ）\n\n");
		rs +=  String.format("                    given equation: dx/dy = y + 1\n");

		rs +=  String.format("                                   x  =% 7.4f\n",x0);
		rs +=  String.format("                               width  =% 7.4f\n",h);

		rs +=  String.format("                    solution by hamng:\n");
		ier = hamng(po, x0, y0, n, h, y);

		rs +=  String.format("                              result  = % 18.16f\n",y[n-1]);
		rs +=  String.format("                               exact  = % 18.16f\n",exact);
		rs +=  String.format("                    error code:\n");
		rs +=  String.format("                                 ier  = %3d\n\n", ier);
		return rs;
	}
}
