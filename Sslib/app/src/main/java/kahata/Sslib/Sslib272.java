// * -*- mode: java -*-  Time-stamp: <08/03/02(日) 13:41:59 hata>
/*================================================================
 * プログラム名: Sslib272.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib272.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *-------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.111 2.7.2 行列の乗算（ＭＭＵＬ１，ＭＭＵＬ２）
 *
 *   機能        乗算１  :c(i,l)=Σa(i,j)*b(j,l) i=1,2,...,m l=1,2,...,k
 *               乗算２  :b(i,l)=Σa(i,j)*b(i,l) i=1,2,...,m l=1,2,...,l
 *
 *-------------------------------------------------------------------------
 */

package kahata.Sslib;
/// インポート
import java.lang.String;
//import java.math.*;

class Sslib272 extends MatrixCalc {
	public  String output() {

		int l = 3;
		int m = 3;
		int n = 2;
		int k = 3;

		int i,j,ier;
		double a[][]={{ 2.0,-1.0,-7.0},{3.0, 4.0,-6.0},{5.0, 8.0,-9.0}},
           b[][]={{-6.0, 2.0,-3.0},{-9.0, 5.0,-1.0},{4.0, 1.0, 2.0}},
           c[][]={{-0.0, 0.0,-0.0},{-0.0, 0.0,0.0},{0.0, 0.0, 0.0}};

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("                  2.7.2 行列の乗算（ＭＭＵＬ１，ＭＭＵＬ２）\n\n");
		rs +=  String.format("     matrix a\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<n; j++)
				rs +=  String.format("% 12.2f",a[i][j]);
				rs +=  String.format("\n");
		}
		rs +=  String.format("     matrix b\n");
		for(i=0; i<n; i++){
			rs +=  String.format("                      ");
			for(j=0; j<k; j++)
				rs +=  String.format("% 12.2f",b[i][j]);
			rs +=  String.format("\n");
		}

		ier = mmul1(a, b, c, l, m, n, k);

		rs +=  String.format("     matrix c (mmul1: c=a*b)\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<k; j++)
				rs +=  String.format("% 12.2f",c[i][j]);
				rs +=  String.format("\n");
			}
		rs +=  String.format("\n");
		rs +=  String.format("                  [matrix a]                     [matrix b]\n");
		for(i=0; i<m; i++){
			rs +=  String.format("            ");
			for(j=0; j<m; j++)
				rs +=  String.format("% 8.2f",a[i][j]);
			rs +=  String.format("    ");
			for(j=0; j<m; j++)
					rs +=  String.format("% 8.2f",b[i][j]);
			rs +=  String.format("\n");
		}

		ier= mmul2(a, b, l, m);
		rs +=  String.format("\n     matrix b (mmul2: b=a*b)\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                      ");
			for(j=0; j<m; j++)
			rs +=  String.format("% 12.2f",b[i][j]);
			rs +=  String.format("\n");
		}
		rs +=  String.format("\n");
		return rs;
	}
}
