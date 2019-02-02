// * -*- mode: java -*-  Time-stamp: <08/03/01(土) 15:16:24 hata>
/*================================================================
 * プログラム名: Sslib264.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib264.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.105 2.6.4 二階同次常微分方程式　定数決定法（ＨＤＥＣＤＭ）
 *
 *   機能        二階同次常微分方程式の境界値問題を定数決定法により解を求める
 *
 *   呼出方法    call hdecdm(xi, a1, a2, func0, func1, h, n, r, ier)
 *   引き数
 *           入力
 *               xi      :xの境界値の始点を、実定数か実変数名で与える
 *               a1,a2   :xの境界値の始点と終点に対応するyの値を、実定数か
 *                        実変数名で与える。出力として解ベクトルy(multi)を得る
 *               func0   :同次常微分方程式を定義する関数サブルーチン名を与える
 *               func1   :二階常微分方程式を解くとき定義する関数サブルーチン
 *                        を与える
 *               h       :積分のきざみ幅を、実定数か実変数名で与える; h>0
 *               n       :積分の繰り返し回数を、整定数か整変数名で与える。
 *                               1≦n≦50
 *           出力
 *               r       :r(n)なる実配列名で、解を得る
 *               ier     :整変数名で、エラーフラグである
 *                           0   :エラーなし
 *                           1   :解が存在しない
 *                           999 :h≦0, n<1, n>50のいずれかである
 *   スレーブサブルーチン
 *       rngktg(x ,func, kind, h, yd, y, ier)
 *               本サブルーチンはrunge-kutta-gill法(2.6.1)と同じ機能であるが、
 *               kind=1のときx点におけるyの１階微分値がydに、またkind=2のとき
 *               y値がyに得られる。
 *       func0 : ユーザーで用意する関数サブルーチン         
 *       func1 : ユーザーで用意する関数サブルーチン
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib264 extends DifEquation {

	static class func0_hdecdm implements Func3 {
		public double func(double yd, double y, double x) {
  			return(3 * yd - y);
		}
	}

	static class func1_hdecdm implements Func3 {
		public double func(double yd, double y, double x) {
  			return(yd);
		}
	}

	public  String output() {
		int i,n;
		double a1,a2,h,x=0,er,ier;
		double[] r = new double[50];
		Func3 po0 = new func0_hdecdm();
		Func3 po1 = new func1_hdecdm();

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("            2.6.4 ２階同時常微分方程式　定数決定法（ＨＤＥＣＤＭ）\n\n");
		rs +=  String.format("                 x                 solution            exact\n");
   
		a1 = 0;
		a2 = 1;
		n = 15;
		h = (a2 - a1) / n;
  
		ier = hdecdm(po0, po1, a1, a1, a2, h, n, r);
		for(i=0; i<n; i++){
			x = a1 + h * (i+1);
			er = exact(x);
			rs +=  String.format("             % 10.6f          % 10.6f          % 10.6f\n",x,r[i],er);
		}
		rs +=  String.format("\n");
		return rs;
	}

	static double exact(double x){
  		double a = 2.61803399,
         	b = 0.38196601,
         	f;

  		f = (Math.exp(a * x) - Math.exp(b * x)) / (Math.exp(a) - Math.exp(b));
		return(f);
	}
}

