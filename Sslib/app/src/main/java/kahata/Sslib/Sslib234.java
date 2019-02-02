//  -*- mode: java -*-  Time-stamp: <07/06/08 19:40:24 k.hata>
/*================================================================
 * プログラム名: sslib234.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib234.java,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦
 * To compile: simpuiが値を返すように変更した
 * To run:
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 *   ★ 科学技術計算サブルーチンライブラリー
 *    p.50  2.3.4 １次元有限区間積分 不等間隔シンプソン法（ＳＩＭＰＵＩ）
 *
 *   機能       標本点ｘの対するデータから積分値をsimpson法により求める
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib234 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		int i,n;
		double s;
		double[] x = new double[30];
		double[] y = new double[30];

		// 文字列変数の宣言
		String rs;

		rs =   String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("              2.3.4 １次元有限区間積分不等間隔Simpson法（ＳＩＭＰＵＩ）\n\n");
		rs +=  String.format("                          y  = ∫sin(x)dx  [0 ～π]\n");

		for(i=0; i<=20; i++){
			x[i] = Math.PI / 20.0 * ((double)i);
			if(i!=0 && i!=20)
				y[i] = Math.sin(x[i]);
		}
		n = 21;
		s = DiffIntgl.simpui(x ,y, n);
		rs +=  String.format("                         area  = % 14.7E\n\n", s);
		return rs;
	}
}
