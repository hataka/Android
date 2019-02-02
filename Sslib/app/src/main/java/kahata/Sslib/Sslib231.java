//  -*- mode: java -*-  Time-stamp: <2012-02-02 21:27:41 kahata>
/*================================================================
 * プログラム名: sslib231.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib231.java,v 1.4 2002/02/24 07:23:28 k.hata Exp $
 * Programmed By: 畑和彦
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *-------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *	p.50  2.3.1 数値微分 ラグランジェ法（ＬＡＧＤＩＦ）
 *-------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib231 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		int i,n;
		double[] x = new double[20];
		double[] y = new double[20];
		double xx,x0,exact;
		double pi = 3.14159265358;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
	  	rs +=  String.format("                    2.3.1 数値微分 ラグランジェ法（ＬＡＧＤＩＦ）\n\n");
	  	rs +=  String.format("                  y  =  sin(x)\n");
	  
		for(i=0; i<10; i++){
		    x[i] = 0.1 * pi * (double)(i+1);
		    y[i] = Math.sin(x[i]);
		}
		n = 6;
		xx = 0.5;
		exact = Math.cos(xx);
		x0 = DiffIntgl.lagdif(x, y, n, xx);

	  	rs +=  String.format("                  x  =% 7.3f        diference =  % 14.7E\n",xx,x0);
	  	rs +=  String.format("                                     exact     =  % 14.7E\n",exact);
		rs +=  String.format("\n");
		return rs;
	}
}
