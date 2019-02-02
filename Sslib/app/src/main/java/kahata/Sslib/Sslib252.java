// * -*- mode: java -*-  Time-stamp: <08/02/22(金) 15:14:33 hata>
/*================================================================
 * プログラム名: Sslib252.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib252.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.86  2.5.2 実係数連立１次方程式　ガウス消去法（ＧＡＵＳＳ）
 *               option base 0    ポインタ表記
 *   機能        係数が同じであるk組の実係数連立１次方程式
 *                       Ａ[m, m]・Ｘ[m,k] = Ｂ[m,k]
 *               の解をgauss消去法で一度に求める。
 *               掃き出す際、軸(pivot)として列要素の絶対値最大を選択するため
 *               行列の入れ換えを行う
 *
 *   呼出方法    int gauss(double a[L][N],int l,int m,int n,double eps)
 *   引き数  入出力
 *           a   :a([L][N]なる実配列名で実係数連立１次方程式の係数行列および
 *                定数行列である。演算後は定数行列部、すなわちa([i][j],
 *                i=0,2,...,m-1, j=m,m+1,m+2,...,n-1に解が得られる。
 *            入力
 *           l   :メインプログラムで宣言した配列aの第１添字の値を、整定数か整
 *                　変数名で与える。　l≧m
 *           m,n :配列aの内、演算対象となる列数を、整定数か整変数名で与える
 *                但し、n=m+k、kは定数行列の列数である。n>m  80≧m≧2
 *           eps :収束判定値を実定数か実変数名で与える。eps>0
 *            出力
 *           ier :整変数名で、エラーフラグである。
 *                       0   : エラーなし
 *                       1   : 掃き出しの途中、ピボット要素がepsより小さい
 *                       999 : m<2, m>80, m≧n, eps≦0 のいずれかである
 *   スレーブサブルーチン    : なし
 *-----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib252 {
	public  String output() {
		int l = 3;
		int m = 3;
		int n = 5;
		int nmax = 50;
		double eps = 1.0e-6;
  
		double a[][]={{ 5.0, 1.0, 1.0, 10.0, 18.0},
				 { 1.0,-7.0, 2.0, -7.0, -9.0},
				 { 1.0, 1.0, 6.0, 21.0, 11.0}};
		int i,j,g,ier=0;

		//LsEquation p = new LsEquation();


		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("              ★ 科学技術計算サブルーチンライブラリー（Java）\n");
		rs +=  String.format("          2.5.2 実係数連立１次方程式　ガウス消去法（ＧＡＵＳＳ）\n\n");
		rs +=  String.format("              given equation:\n");
		rs +=  String.format("          [No. 1]                       [No. 2]\n");
		rs +=  String.format("             5x1 + x2 + x3 = 10               5x1 + x2 + x3 = 18\n");
		rs +=  String.format("              x1 -7x2 +2x3 = -7                x1 -7x2 +2x3 = -9\n");
		rs +=  String.format("              x1 + x2 +6x3 = 21                x1 + x2 +6x3 = 11\n");

		ier = LsEquation.gauss(a, l, m, n, eps);

		rs +=  String.format("              solution by gauss:\n");
		rs +=  String.format("          [no. 1]                       [no. 2]\n");
		for(i=0; i<l; i++){
			for(j=m; j<n; j++)
				rs +=  String.format("              x%d =% 10.7E",i+1,a[i][j]);
			rs +=  String.format("\n");
		}
		rs +=  String.format("              Error Code        IER = %3d\n\n", ier);
		return rs;
	}
}
/*
	static int gauss(double[][] a,int l,int m,int n,double eps){
  		int i,j,k,lr=0,iw,g;
  		double w,wmax,pivot,api,x;
  		int[] work = new int[80];
  
		if(m<2 || m>80 || m>=n || eps<=0)
			return(-1);
		for(i=0; i<m; i++)
			work[i] = i+1;
		for(k=0; k<m; k++){
			wmax = 0.0;
			for(i=k; i<m; i++){
				w = Math.abs(a[i][k]);
      			if(w>=wmax){
					wmax = w;
					lr = i;
      			}
    		}
    		pivot = a[lr][k];
    		api = Math.abs(pivot);
    		if(api<=eps)
      			return(1);
    		if(lr!=k){
      			iw = work[k];
      			work[k] = work[lr];
      			work[lr] = iw;
      			for(j=0; j<n; j++){
					w = a[k][j];
					a[k][j] = a[lr][j];
					a[lr][j] = w;
      			}
    		}
    		for(i=k; i<n; i++)
      			a[k][i] = a[k][i] / pivot;
    			if(k>m-2) {
//       goto gss;
// gss:;
      				for(k=m; k<n; k++){
        				for(i=0; i<m-1; i++){
          					x = 0.0;
          					for(j=m-i-1; j<m; j++){
	    						x = x + a[m-i-2][2*m-i-j-2] * a[2*m-i-j-2][k];
          					}
        					a[m-i-2][k] = a[m-i-2][k] - x;
       					}
     				}
       				return 0;
    			}
    
    			for(i=k+1; i<m; i++){
      				w = a[i][k];
      				if(w!=0){
						for(j=k+1; j<n; j++)
	  						a[i][j] = a[i][j] - w * a[k][j];
      				}
    			}
  			}
  
// gss:;
  			for(k=m; k<n; k++){
    			for(i=0; i<m-1; i++){
      				x = 0.0;
      				for(j=m-i-1; j<m; j++){
						x = x + a[m-i-2][2*m-i-j-2] * a[2*m-i-j-2][k];
      			}
      			a[m-i-2][k] = a[m-i-2][k] - x;
    		}
  		}
		return 0;
	}
}
*/
