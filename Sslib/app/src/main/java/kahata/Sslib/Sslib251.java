// * -*- mode: java -*-  Time-stamp: <08/02/22(金) 14:36:23 hata>
/*================================================================
 * プログラム名: Sslib251.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib251.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 *================================================================*/
/*
 *-----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.83  2.5.1 実係数連立１次方程式　ガウス・ザイデル法（ＧＡＵＳＥＩ）
 *
 *   機能        実係数連立１次方程式
 *                       Ａ(m, m)・Ｘ(m) = Ｂ(m)
 *               の解をgauss-seidel法で求める。
 *               ただし、連立１次方程式の係数行列において、対角要素が非対角要素
 *               に比べて大きい場合に限りこのサブルーチンを用いることができる
 *-----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib251 {
	public  String output() {
		int nmax = 50,nmaxr = 50,nmaxc =50,ier=0;
		double eps = 0.0000000000000001;
		int l = 3;
		int m = 3;
		int n = 4;
		int nr = 30;

		int i,k;
		double a[][]={{5.0, 1.0, 1.0,10.0},{1.0,-7.0, 2.0,-7.0},{1.0, 1.0, 6.0,21.0}};
		double[] x = new double[50];

		for(i=0; i<50; i++) x[i]= 0.0;

		//LsEquation p = new LsEquation();

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("              ★ 科学技術計算サブルーチンライブラリー（Java）\n");
		rs +=  String.format("       2.5.1 実係数連立１次方程式　ガウス・ザイデル法（ＧＡＵＳＥＩ）\n\n");
		rs +=  String.format("                 given equation:\n");
		rs +=  String.format("                                5x + y + z = 10\n");
		rs +=  String.format("                                 x -7y +2z =  7\n");
		rs +=  String.format("                                 x + y +6z = 21\n");
   
		ier = LsEquation.gausei(a, l, m, n, nr, eps, x);
		rs +=  String.format("               solution by gausei:\n");
		rs +=  String.format("                             x = % 15.12E\n", x[0]);
		rs +=  String.format("                             y = % 15.12E\n", x[1]);
		rs +=  String.format("                             z = % 15.12E\n\n", x[2]);
		rs +=  String.format("               error code  ier = %3d\n\n", ier);
		return rs;
	}
}
/*
	static int gausei(double[][] a, int l, int m, int n, int nr, double eps, double[] x){
  		int i,j,inum;
  		double dif,sum,w,y,ay;
  
  		if(n<3 || nr<=0 ||eps<=0)
    		return(-1);
  		for(i=0; i<l; i++)
    		x[i] = 0.0;
  		inum = 1;
  		do{
    		dif = 0.0;
    		for(i= 0; i<l; i++){
      			sum = 0.0;
      			w = a[i][i];
      			for(j=0; j<m; j++){
					if(i!=j)
	  					sum = sum + a[i][j] * x[j];
      			}
      			y = (a[i][m] - sum) / w;
      			ay = Math.abs(y - x[i]);
      			if(ay>dif)
					dif = ay;
      			x[i] = y;
    		}
    		if(dif<=eps)
      			return(0);
    		if(inum>= nr)
      			return(1);
    		inum = inum + 1;
  		} while (true);
	}
}
*/
