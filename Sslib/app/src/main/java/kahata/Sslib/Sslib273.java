// * -*- mode: java -*-  Time-stamp: <08/03/02(日) 15:14:49 hata>
/*================================================================
 * プログラム名: Sslib273.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib273.c,v 1.3.1.2 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦 <kazuhiko.hata@nifty.ne.jp>                
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.114 2.7.3 行列の転置（ＭＴＲＡ１，ＭＴＲＡ２）
 *
 *   機能        転置１  :b(j,i)=a(i,j) i=1,2,...,m j=1,2,...,n
 *               転置２  :a(j,i)=a(i,j) i=1,2,...,m j=1,2,...,m
 *
 *----------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib273 extends MatrixCalc {
	public  String output() {
		int l = 3;
		int m = 3;
		int n = 2;

		int i,j,ier;
		double a[][]={{1.0, 4.0, 7.0},{2.0, 5.0, 8.0},{3.0, 6.0, 9.0}},
           b[][]={{0.0, 0.0, 0.0},{0.0, 0.0, 0.0},{0.0, 0.0, 0.0}};

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("                2.7.3 行列の転置（ＭＴＲＡ１，ＭＴＲＡ２）\n\n");
		rs +=  String.format("     matrix a\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<n; j++)
				rs +=  String.format("% 13.4f",a[i][j]);
			rs +=  String.format("\n");
		}

		ier = mtra1(a, b, l, m, n);

		rs +=  String.format("     matrix b (=a')\n");
		for(i=0; i<n; i++){
			rs +=  String.format("                      ");
			for(j=0; j<m; j++)
				rs +=  String.format("% 13.4f", b[i][j]);
				rs +=  String.format("\n");
			}
			rs +=  String.format("     matrix a\n");
			for(i=0; i<m; i++){
				rs +=  String.format("                      ");
				for(j=0; j<m; j++)
					rs +=  String.format("% 13.4f", a[i][j]);
				rs +=  String.format("\n");
			}

		ier = mtra2(a, l, m);

		rs +=  String.format("\n");
		rs +=  String.format("     matrix a (=a')\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<m; j++)
				rs +=  String.format("% 13.4f", a[i][j]);
			rs +=  String.format("\n");
		}
		rs +=  String.format("\n");
		return rs;
	}
}
