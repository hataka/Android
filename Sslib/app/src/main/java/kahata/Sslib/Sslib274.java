// * -*- mode: java -*-  Time-stamp: <08/03/02(日) 15:28:17 hata>
/*================================================================
 * プログラム名: Sslib228.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib274.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.117 2.7.4 逆行列と行列式（ＭＩＮＶＥＲ）
 *
 *   機能        正方行列 [ａmm] の逆行列と行列式の値をgauss-jordan法により
 *               求める。掃き出す際、軸(pivot)としての列要素の絶対値最大を
 *               選択するための行入れ替えを行う。
 *
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
import java.math.*;

class Sslib274 extends MatrixCalc {
	public  String output() {
		int l = 3;
		int m = 3;
		double eps = 0.000001;

		int i,j,ier;
		double det[] = {0.0};
		double a[][]={{3.0,-6.0, 7.0},{9.0, 0.0,-5.0},{5.0,-8.0, 6.0}},
           b[][]={{0.0,0.0, 0.0},{0.0, 0.0,0.0},{0.0,0.0, 0.0}};

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("                   2.7.4 逆行列と行列式（ＭＩＮＶＥＲ）\n\n");
		rs +=  String.format("    matrix a\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                  ");
			for(j=0; j<m; j++)
				rs +=  String.format("% 12.5f", a[i][j]);
			rs +=  String.format("\n");
		}
		for(i=0; i<m; i++){
			for(j=0; j<m; j++)
				b[i][j] = a[i][j];
		}

		ier = minver(a, l, m, eps, det);

		rs +=  String.format("\n");
		rs +=  String.format("    value of det.= % 10.4f\n\n", det[0]);

		rs +=  String.format("    inversion of matrix a\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                  ");
			for(j=0; j<m; j++)
				rs +=  String.format("% 12.5f", a[i][j]);
			rs +=  String.format("\n");
		}

		ier = mmul2(a, b, l, m);

		rs +=  String.format("\n");
		rs +=  String.format("    solution  of mmul2\n");
		for(i=0; i<m; i++){
			rs +=  String.format("                  ");
			for(j=0; j<m; j++)
				rs +=  String.format("% 12.5f", b[i][j]);
			rs +=  String.format("\n");
		}
		rs +=  String.format("\n");
		return rs;
	}
}
