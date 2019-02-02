//  -*- mode: java -*-  Time-stamp: <07/06/08 09:22:29 k.hata>
/*================================================================
 * プログラム名: sslib235.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib235.java,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *-----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.57  2.3.5 １次元有限区間積分 ３次スプライン関数法（ＳＰＬＩＴＧ）
 *
 *   機能        標本点xiの対するデータyiから積分値を３次spline関数法により求める
 *-----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib235 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		int n,i;
		double exact,s;
		double[] x = new double[20];
		double[] y = new double[20];
		double pi = 3.14159265358;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("              2.3.5 １次元有限区間積分 ３次スプライン関数法（ＳＰＬＩＴＧ）\n\n");
		rs +=  String.format("                          y  = ∫sin(x)dx  [0 ～π]\n");

		n = 11;
		for(i=0; i<n; i++){
			x[i] = pi * ((double)i) / ((double)n - 1);
			if(i!=0 || i!=n-1)
				x[i] = x[i] + 0.02 * Math.pow(-1,((double)i+1));
			y[i] = Math.sin(x[i]);
		}
		exact = 2.0;
		s = DiffIntgl.splitg(x, y, n);
		rs +=  String.format("                         exact  = % 12.7f     result  = % 12.7f\n\n", exact, s);
		return rs;
	}
}
