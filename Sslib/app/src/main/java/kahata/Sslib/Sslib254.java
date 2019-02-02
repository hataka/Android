// * -*- mode: java -*-  Time-stamp: <08/02/22(金) 15:44:00 hata>
/*================================================================
 * プログラム名: Sslib254.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib254.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.92 2.5.4 実係数連立１次方程式　ＬＵ分解法（ＬＵＤＣＭＰ）
 *
 *				 option base 0   配列表記
 *
 *   機能        n元の連立１次方程式
 *                       Ａ[n, n]・Ｘ[n] = Ｂ[n]
 *               の解をlu分解法で求める。
 *
 *   呼出方法    call ludcmp(a(), b(), n, eps, x, ier)
 *   引き数  入力
 *           a   :a(n, n+1)なる実配列名で実係数連立１次方程式の係数を与える
 *           b   :b(n)なる実配列名で、常数ベクトルを与える
 *           n   :連立方程式の元数を、整定数か整変数名で与える
 *                n≦50
 *           eps :係数行列の特異性を調べるパラメーターを、実定数か実変数名で
 *                与える eps>0
 *            出力
 *           x   :x(n)なる実配列名で。解ベクトルを得る
 *           ier :整変数名で、エラーフラグである。
 *                       0   : エラーなし
 *                       1   : （係数行列の対角要素の絶対値）≦epsである
 *                       999 : n>50, eps≦0 のいずれかである
 *   スレーブサブルーチン    : なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
import java.lang.String;
//import java.math.*;

class Sslib254 {
	public  String output() {
		int nmax = 50;
		int l= 5;
		int m = 5;
		int n = 6;
		double eps = 0.000001;

		int i,j,ier;
		double[][] lu = new double[50][50];
		double[]   x  = new double[50];

		//LsEquation p = new LsEquation();

		for(i=0; i<l; i++){
			for(j=0; j<l; j++){
				lu[i][j] = i+1 +(j+1) * 10;
				if(i==j) lu[i][j] = 5 * lu[i][j];
				x[i] = 0.0;
			}
		}
  
		lu[0][n-1]=199;lu[1][n-1]=248;lu[2][n-1]=297;lu[3][n-1]=346;
		lu[4][n-1]=395;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("              ★ 科学技術計算サブルーチンライブラリー（Java）\n");
		rs +=  String.format("          2.5.4 実係数連立１次方程式　ＬＵ分解法（ＬＵＤＣＭＰ）\n\n");
		rs +=  String.format("          given equation:\n");
		rs +=  String.format("             ");
		for(j=0; j<n; j++)
			rs +=  String.format("     J=%d",j+1);
		rs +=  String.format("\n");
		for(i=0; i<l; i++){
			rs +=  String.format("          i=%d", i+1);
			for(j=0; j<=l; j++)
				rs +=  String.format("% 8.1f", lu[i][j]);
			rs +=  String.format("\n");
		}

		ier = LsEquation.ludcmp(lu, l, m, n, eps, x);

		rs +=  String.format("          solution by ludcmp:\n");
		for(i=0; i<l; i++)
			rs +=  String.format("                            x(%d) =% 12.7E\n", i+1, x[i]);  
		rs +=  String.format("\n          Error Code     IER = %3d\n\n", ier);
		return rs;
	}
}
/*
	static int ludcmp(double[][] a,int l,int m,int n,double eps,double[] x){
		int i,j,k,jm,im;
  		double w;
  		double[] y = new double[50];
  
  		if(l>=50 || eps<=0)
    		return(-1);
  		for(i=0; i<l-1; i++){
    		if(Math.abs(a[i][i])<=eps)
      			return(1);
    		for(j=i+1; j<l; j++){
      			w = a[j][i];
     			if(i!=0){
					for(k=0; k<i; k++)
	  					w = w - a[j][k] * a[k][i];
      			}
      			a[j][i] = w / a[i][i];
    		}
    		for(j=i+1; j<l; j++){
      			w = a[i+1][j];
      			for(jm=0; jm<i+1; jm++)
					w = w - a[i+1][jm] * a[jm][j];
      				a[i+1][j] = w;
    			}
  			}
  			y[0] = a[0][l];
  			for(i=1; i<l; i++){
    			w = a[i][l];
    			for(j=0; j<i; j++)
      				w = w - a[i][j] * y[j];
    			y[i] = w;
  			}
  			x[l-1] = y[l-1] / a[l-1][l-1];
  			for(im=2; im<=l; im++){
    			i = l - im;
    			w = y[i];
    			for(j=i+1; j<l; j++)
      				w = w - a[i][j] * x[j];
    			x[i] = w / a[i][i];
  			}
  		return(0);
		}
	}
*/
