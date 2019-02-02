// * -*- mode: java -*-  Time-stamp: <08/03/02(日) 13:26:55 hata>
/*================================================================
 * プログラム名: Sslib271.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib271.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *-------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.108 2.7.1 行列の加減算（ＭＡＤＤ，ＭＳＵＢ）
 *
 *   機能        加算    :c(i,j)=a(i,j)+b(i,j) i=1,2,...,m j=1,2,...,n
 *               減算    :c(i,j)=a(i,j)-b(i,j) i=1,2,...,m j=1,2,...,n
 *
 *-------------------------------------------------------------------------
 */
 
package kahata.Sslib;
/// インポート
import java.lang.String;
import java.math.*;

class Sslib271 extends MatrixCalc {
	public  String output() {
		int l = 2;
		int m = 2;
		int n = 3;

		int i,j,ier;
		double a[][]={{6.0, 8.0, 5.0},{1.0, 7.0, 3.0}},
                b[][]={{1.0, 3.0, 5.0},{2.0, 6.0, 4.0}},
                c[][] ={{0.0, 0.0, 0.0},{0.0, 0.0, 0.0}};

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("                  2.7.1 行列の加減算（ＭＡＤＤ，ＭＳＵＢ）\n\n");
		rs +=  String.format("         matrix a\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<n; j++){
				rs +=  String.format("% 12.4f",a[i][j]);
			}
			rs +=  String.format("\n");
		}
		rs +=  String.format("         matrix b\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<n; j++){
				rs +=  String.format("% 12.4f", b[i][j]);
			}
			rs +=  String.format("\n");
		}

		ier = madd(a, b, c, l, m, n);

		rs +=  String.format("         matrix (a+b)\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<n; j++)
				rs +=  String.format("% 12.4f", c[i][j]);
				rs +=  String.format("\n");
			}

			ier = msub(a, b, c, l, m, n);

			rs +=  String.format("         matrix (a-b)\n");
			for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<n; j++)
				rs +=  String.format("% 12.4f", c[i][j]);
				rs +=  String.format("\n");
			}
			rs +=  String.format("\n");
		return rs;
	}
}

