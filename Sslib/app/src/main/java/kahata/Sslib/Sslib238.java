// * -*- mode: java -*-  Time-stamp: <08/02/18(月) 12:41:43 hata>
/*================================================================
 * プログラム名: Sslib238.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: Sslib238.java,v 1.4 2008/02/18 12:41:43 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.66  2.3.8 １次元全無限区間積分 ガウス・エルミート法
 *                   （ＤＧＨ１０、ＤＧＨ１５）
 *
 *   機能        ∫f(x)exp(-x*x)dx [-∞,+∞]をgausse-hermite法により求める。
 *               ここでは10点と15点により倍精度演算をおこなう
 *
 *---------------------------------------------------------------------------
 */

package kahata.Sslib;

import java.lang.String;
//import java.math.*;

class Sslib238 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		double s,exact;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("               ★ 科学技術計算サブルーチンライブラリー（Java）\n");
		rs +=  String.format("              2.3.8 １次元全無限区間積分 ガウス・エルミート法\n");
		rs +=  String.format("                         （ＤＧＨ１０、ＤＧＨ１５）\n\n");
		rs +=  String.format("               y  = ∫x*x*exp(-x*x)dx  [-∞～+∞]\n");

		exact = 0.8862269254527581;       /* exact = sqr(PI) / 2 */

		s = DiffIntgl.dgh10();
		rs +=  String.format("              10-points      result    = % 19.16f\n", s);
		rs +=  String.format("                                     exact     = % 19.16f\n", exact);

		s = DiffIntgl.dgh15();
		rs +=  String.format("              15-points      result    = % 19.16f\n", s);
		rs +=  String.format("                                     exact     = % 19.16f\n\n", exact);
		return rs;
	}
}
