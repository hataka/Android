// * -*- mode: java -*-  Time-stamp: <08/03/01(土) 14:23:17 hata>
/*================================================================
 * プログラム名: Sslib263.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib263.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.103 2.6.3 連立１階常微分方程式　ルンゲ・クッタ・ギル法（ＲＮＧＫＧＭ）
 *                   option base 0
 *   機能        連立１階常微分方程式の解を、runge-kutta-gill法で求める
 *
 *   呼出方法    call rngkgm(x, y(), n, h, multi, n, ier)
 *   引き数  入出力
 *               y　 :入力として各連立方程式yの初期値を、実配列名で与える
 *                    また出力としてy(multi)なる解ベクトルを得る
 *           入力
 *               x   :xの初期地を、実定数か実変数名で与える。
 *               h   :積分のきざみ幅を、実定数か実変数名で与える。h>0
 *               multi   :連立方程式の次数を、整定数か整変数名で与える。multi≦5
 *               n   :積分の繰り返し回数を、整定数か整変数名で与える。
 *           出力
 *               ier :整変数名で、エラーフラグである
 *                       0   :エラーなし
 *                       999 :h≦0,multi<5のいずれかである
 *   スレーブサブルーチン
 *               funct(x ,y ,dif, multi)
 *                   :連立微分方程式をdif(multi)に与えるサブルーチン
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib263 extends DifEquation {

	static class func_rngkgm implements Func2 {
		public int func(double x, double[] y, double[] dif) {
			dif[0] = y[1] + 1.0;
  			dif[1] = y[0];
  			return 0;
		}
	}

	public  String output() {

		int i,n,multi;
		double h,x0,y0,y1,x,exact1,exact2,ier;
		Func2 po = new func_rngkgm();

		h = 0.05;
		x0 = 0;
		n=20;
		multi=2;
  
		double[] y = new double[multi+10];
		double[] dif = new double[multi+10];

		y0 = y[0] = 0.0;
		y1 = y[1] = 1.0;
  
		exact1 = -Math.exp(-1) + Math.exp(1);
		exact2 = Math.exp(-1) + Math.exp(1) - 1;
		x = (double)h*n;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("       2.6.3 連立１階常微分方程式　ルンゲ・クッタ・ギル法（ＲＮＧＫＧＭ）\n\n");
		rs +=  String.format("       given equation:  (1) dy1/dx = y2 + 1  (2) dy2/dx = y1\n");
		rs +=  String.format("                            x0  =% 8.3f\n", x0);
		rs +=  String.format("                         y1(x0) =% 8.3f\n", y[0]);
		rs +=  String.format("                         y2(x0) =% 8.3f\n", y[1]);
		rs +=  String.format("                         width  =% 8.3f\n", h);
		rs +=  String.format("                             n  =% 4d\n", n);

		rs +=  String.format("       solution by rngkgm:\n");

		for (i=0;i<=n; i+=4){
			y[0]=y0;
			y[1]=y1;
			x = x0+(double)h*i;
			ier = rngkgm(po, x0, y, h, multi, i);
			rs +=  String.format("         x =%4.3f        y1     =% 10.6f        y2     =% 10.6f\n", x, y[0], y[1]);
		}
		rs +=  String.format("                         exact1 =% 10.6f        exact2 =% 10.6f\n", exact1, exact2);
		rs +=  String.format("                        [-exp(-1) + exp(1)]       [exp(-1) + exp(1) - 1]\n\n");
		return rs;
	}
}
