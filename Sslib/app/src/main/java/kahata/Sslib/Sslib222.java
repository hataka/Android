//  -*- mode: java -*-  Time-stamp: <2012-02-02 8:39:14 kahata>
/*================================================================
 * プログラム名: sslib222.java
 * 作成日: 07/06/06 19:16:43
 * $Id: sslib222.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦
   To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *------------------------------------------------------------------*
 * ★ 科学技術計算サブルーチンライブラリー                          *
 *    p.24 2.2.2 第１種ベッセル関数（ＢＥＳＪ０、ＢＥＳＪ１）       *
 *------------------------------------------------------------------*
 */
package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib222 {
	public  String output() {
		//MathFunction p = new MathFunction();
		double x, bj0, bj1;//y
		int i;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                  2.2.2 第１種ベッセル関数（ＢＥＳＪ０、ＢＥＳＪ１）\n\n");
		rs +=  String.format("                 x           besj0                  besj1\n");

		for (i = 0; i < 11; i++) {
		    x = (double) i;
		    bj0 = MathFunction.besj0(x);
		    bj1 = MathFunction.besj1(x);
		    rs +=  String.format("              %5.2f       % 12.6E         % 12.6E\n", x, bj0, bj1);
		}
		rs +=  String.format("\n\n");
		return rs;
	}
}
