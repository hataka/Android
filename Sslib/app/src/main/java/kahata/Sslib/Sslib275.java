// * -*- mode: java -*-  Time-stamp: <08/03/02(日) 16:19:54 hata>
/*================================================================
 * プログラム名: Sslib275.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib275.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.120 2.7.5 実対称行列の固有値と固有ベクトル　ヤコビ法（ＪＡＣＯＢＩ）
 *
 *              option base 0   ポインタによる引き数渡し
 *
 *   機能        実対称行列 a(m, m)の固有値・固有ベクトルをjacobi法により求める
 *   書式:
 *          int jacobi(double *a, double *v,int l,int m,int *nr,double eps)
 *     
 *   引き数
 *           入出力
 *               a()     :a(l, m)なる実配列名で、でa(i,j)を格納する。
 *                       :演算後は、対角要素a(i,j)に固有値が得られる。
 *               nr      :回転を行う最大数を、整変数名で与える。nr≧1
 *                        演算後は、回転が行われた回数が得られる。
 *           入力
 *               l       :メインプログラムで宣言した配列aの第１添字の値を
 *                        整定数か整変数名で与える。l≧m
 *               m　　   :配列aの内、演算の対象となる行列数を、整定数か整変数
 *                        名で与える。 m≧2
 *               eps     :収束判定値(標準値;1.0e-6)を、実定数か実変数名で与える。
 *                        eps>0
 *           出力
 *               v       :v(l, m)なる実配列名で、結果の固有ベクトルが得られる。
 *                        j番目の固有値に対する固有ベクトルはv(i, j),i=1,2...,m
 *                        である。
 *               戻り値  :エラーフラグである
 *                           0   :エラーなし
 *                           1   :nrの回転で収束しなかった。
 *                          -1   :配列a(i, j)が対称でない。
 *                                m<2, nr<1, eps≦0のいずれかである。
 *   スレーブサブルーチン: なし
 *----------------------------------------------------------------------------
 */
 
package kahata.Sslib;
// インポート
import java.lang.String;
import java.math.*;

class Sslib275 extends MatrixCalc {
	public  String output() {
		int l = 3;
		int m = 3;
		double eps = 0.000001;

		int i,j,ier;
		int nr[] = {20};
		double a[][]={{ 4.0, 1.0, 2.0},{ 1.0, 2.0,-1.0},{ 2.0,-1.0, 3.0}};
		double[][] v = new double[3][3];

		for(i =0;i <3;i++)
			for(j= 0;j<3; j++)
				v[i][j] = 0.0;

		// 文字列変数の宣言
		String rs;

  		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
  		rs +=  String.format("       2.7.5 実対称行列の固有値と固有ベクトル　ヤコビ法（ＪＡＣＯＢＩ）\n\n");
  		rs +=  String.format("    Matrix A\n");
  		for(i=0; i<m; i++){
    		rs +=  String.format("                  ");
    		for(j=0; j<m; j++)
      			rs +=  String.format("% 18.7E",a[i][j]);
    		rs +=  String.format("\n");
  		}

		ier = jacobi(a, v, l, m, nr, eps);

		rs +=  String.format("\n");
		rs +=  String.format("    IER Code No. = %4d\n", ier);
		rs +=  String.format("    The Number of Rotation = %2d\n\n", nr[0]);
		for(i=0; i<m; i++){
			rs +=  String.format("    Eigenvalue   %d% 18.7E\n", i+1, a[i][i]);
			rs +=  String.format("    Eigenvectors %d", i+1);
			for(j=0; j<m; j++)
				rs +=  String.format("% 18.7E", v[j][i]);
			rs +=  String.format("\n\n");
		}
		return rs;
	}
}
