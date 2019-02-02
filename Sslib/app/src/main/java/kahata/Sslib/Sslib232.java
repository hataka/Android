//  -*- mode: java -*-  Time-stamp: <07/06/07 17:48:13 k.hata>
/*================================================================
 * プログラム名: sslib232.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib232.java,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * Programmed By: 畑和彦
 * To compile:Cからjavaへの変更点
 *    配列宣言
 *    subsplの配列参照返しを可能にするためDifIntglにインスタンス変数設定
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
 /*
 *-----------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.50  2.3.2 数値微分 ３次スプライン関数法（ＳＰＬＤＩＦ）
 *-----------------------------------------------------------------
 */
package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib232 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		int i,n;
		double xx,exact,dif;
		double[] x = new double[50];
		double[] y = new double[50];
		double pi = 3.14159265358;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                  2.3.2 数値微分 ３次スプライン関数法（ＳＰＬＤＩＦ）\n\n");
		rs +=  String.format("                  y  =  sin(x)\n");
	  
		for(i=0; i<50; i++){
		    x[i] = 0.02 * pi * (double)(i+1);
		    y[i] = Math.sin(x[i]);
		}
		n = 50;
		xx = 1.0;
		exact = Math.cos(xx);
		dif = DiffIntgl.spldif(x, y, n, xx);
		rs +=  String.format("                  x  =% 7.3f        diference =  % 14.7E\n",xx,dif);
		rs +=  String.format("                                     exact     =  % 14.7E\n",exact);
		rs +=  String.format("\n");
		return rs;	
	}
}
