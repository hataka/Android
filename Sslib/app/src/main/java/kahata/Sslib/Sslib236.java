// -*- mode: java -*-  Time-stamp: <08/02/18(月) 07:16:40 hata>
/*================================================================
 * プログラム名: sslib236.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib236.c,v 1.3 Time-stamp: 2008/02/18 07:17:05 Exp k.hata $
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------;
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.59  2.3.6 １次元有限区間積分 ガウス・ルジャンドル法
 *               （ＤＧＬ２、ＤＧＬ３、ＤＧＬ２０、ＤＧＬ３８）
 *
 *   機能    ∫f(x)dx [a,b]をGauss-Legendre法により求める。
 *           ここでは2点、3点、20点または38点により倍精度演算をおこなう
 *   書式
 *           double dgl2(double (* func)(double x), double xi, double xe)
 *           double dgl3(double (* func)(double x), double xi, double xe)
 *           double dgl20(double (* func)(double x), double xi, double xe)
 *           double dgl38(double (* func)(double x), double xi, double xe)
 *
 *   引き数  入力
 *           xi  :積分区間の下限値を倍精度実定数か倍精度実変数名で与える
 *           xe  :積分区間の上限値を倍精度実定数か倍精度実変数名で与える
 *   戻り値
 *           出力
 *               :積分値を戻す
 *
 *   エラー      :xi≧xeの時、999を戻す
 *
 *   スレーブ    :double func(double x)
 *                被積分関数を定義する倍精度サブルーチン)
 *
 *    Cintのdllでは関数ポインタに問題あり。インタープリタで実行のこと
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;

import java.lang.String;
//import java.math.*;

class Sslib236 {
	public  String output() {

		//DiffIntgl p = new DiffIntgl();
		double xi,xe,s,exact;
		double pi = 3.14159265358;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("              2.3.6 １次元有限区間積分 ガウス・ルジャンドル法\n");
		rs +=  String.format("               （ＤＧＬ２、ＤＧＬ３、ＤＧＬ２０、ＤＧＬ３８）\n\n");
		rs +=  String.format("                         y  = ∫sin(x)dx  [0 ～π/2]\n");

  		xi = 0.0;
  		xe = pi / 2.0;
  		exact = 1.0;

  		s = DiffIntgl.dgl2(xi, xe);
		rs +=  String.format("               2-points      result    = % 19.16f\n", s);
  		rs +=  String.format("                             exact     = % 19.16f\n", exact);

  		s = DiffIntgl.dgl3(xi, xe);
  		rs +=  String.format("               3-points      result    = % 19.16f\n", s);
  		rs +=  String.format("                             exact     = % 19.16f\n", exact);

  		s = DiffIntgl.dgl20(xi, xe);
  		rs +=  String.format("              20-points      result    = % 19.16f\n", s);
  		rs +=  String.format("                             exact     = % 19.16f\n", exact);

  		s = DiffIntgl.dgl38(xi, xe);
  		rs +=  String.format("              38-points      result    = % 19.16f\n", s);
  		rs +=  String.format("                             exact     = % 19.16f\n\n", exact);

 		return rs;
	}
}

