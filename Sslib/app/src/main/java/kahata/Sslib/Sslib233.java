//  -*- mode: java -*-  Time-stamp: <07/06/08 09:03:20 k.hata>
/*================================================================
 * プログラム名: sslib233.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib233.java,v 1.4 2002/02/24 07:23:28 k.hata Exp $
 * Programmed By: 畑和彦 
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *-----------------------------------------------------------------------------
 *   ★ 科学技術計算サブルーチンライブラリー
 *    p.50  2.3.3 １次元有限区間積分 等間隔シンプソン法（ＳＩＭＰＥＩ）
 *
 *   機能        等間隔な標本点に対するデータの積分値をsimpson法により求める
 *-----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib233 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		int i,n;
		double h,s=0;
		double[] y = new double[100];
		double pi = 3.14159265358;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("              2.3.3 １次元有限区間積分 等間隔シンプソン法（ＳＩＭＰＥＩ）\n\n");
		rs +=  String.format("                  y  = ∫sin(x)dx  [0 ～π]\n");
		for(i=0; i<=20; i++)
			y[i] = Math.sin(pi / 20.0 * i);
		n = 21;
		h = pi / 20.0;
		s = DiffIntgl.simpei(y, n, h);
		rs +=  String.format("                  width = % 7.6f     area = % 14.7E\n\n",h,s);
		return rs;
	}
}
