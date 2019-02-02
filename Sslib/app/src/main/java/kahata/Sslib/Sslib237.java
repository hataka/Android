// * -*- mode: java -*-  Time-stamp: <08/02/18(月) 10:42:24 hata>
/*================================================================
 * プログラム名: sslib237.c
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib237.c,v 1.4 2008/02/18 10:42:52 Exp k.hata $
 * Programmed By: 畑和彦 <kazuhiko.hata@nifty.ne.jp>                
 * 説明: 
 *================================================================*/
/*
 *-------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.59  2.3.7 １次元半無限区間積分 ガウス・ラーゲル法
 *                （ＤＧＬＧ３、ＤＧＬＧ５、ＤＧＬＧ１０）
 *
 *   機能        ∫f(x)dx [a,b]をgausse-laguerre法により求める。
 *               ここでは3点、5点または10点により倍精度演算をおこなう
 *
 *-------------------------------------------------------------------------
 */

package kahata.Sslib;

import java.lang.String;
//import java.math.*;

class Sslib237 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		double s,exact;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("               ★ 科学技術計算サブルーチンライブラリー（java）\n");
		rs +=  String.format("               2.3.7 １次元半無限区間積分 ガウス・ラーゲル法\n");
		rs +=  String.format("                  （ＤＧＬＧ３、ＤＧＬＧ５、ＤＧＬＧ１０）\n\n");
		rs +=  String.format("               y  = ∫xexp(-x)dx  [0 ～∞]\n");

		exact = 1.0;

		s = DiffIntgl.dglg3();
		rs +=  String.format("               3-points      result    = % 19.16f\n", s);
		rs +=  String.format("                                    exact     = % 19.16f\n", exact);

		s = DiffIntgl.dglg5();
		rs +=  String.format("               5-points      result    = % 19.16f\n", s);
		rs +=  String.format("                                    exact     = % 19.16f\n", exact);

		s = DiffIntgl.dglg10();
		rs +=  String.format("              10-points      result    = % 19.16f\n", s);
		rs +=  String.format("                                    exact     = % 19.16f\n", exact);
		return rs;
	}
}
