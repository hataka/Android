//  -*- mode: java -*-  Time-stamp: <07/06/06 18:56:56 k.hata>
/*================================================================
 * プログラム名: sslib221.c
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib221.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦 <kazuhiko.hata@nifty.ne.jp>                
   To compile:
 * To run: JavaConsoleApplication
   warning!      Note: posix.dll is not found. 
                 Do 'sh setup' in $CINTSYSDIR/lib/posix directory 
                 if you use UNIX.
 * 説明: 
 *================================================================*/
/*
 *------------------------------------------------------------------*
 * ★ 科学技術計算サブルーチンライブラリー                          *
 *    p.24 2.2.1 立方根（ＣＢＲＴ）                                 *
 *------------------------------------------------------------------*
 */
package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib221 {
	public  String output() {
	//MathFunction p = new MathFunction();
		int i;
		double x = 0.0, y  = 0.0;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                         2.2.1 立方根（ＣＢＲＴ）\n\n");
		rs +=  String.format("                       x               cbrt(x)\n");

		for (i = 1; i <= 10; i++) {
		    x = (double)i;
		    y = MathFunction.cbrt(x);
		    rs +=  String.format("                    %5.2f           % 12.6E\n", x, y);
		}
		rs +=  String.format("\n");
		rs +=  String.format("\n");
		return rs;
	}
}
