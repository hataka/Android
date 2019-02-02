// * -*- mode: java -*-  Time-stamp: <08/02/22(金) 14:00:03 hata>
/*================================================================
 * プログラム名: Sslib253.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib253.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦 <kazuhiko.hata@nifty.ne.jp>                
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.89  2.5.3 実係数連立１次方程式　ガウス・ジョルダン法（ＧＡＵＪＯＲ）
 *				分割、module化 OK 確認済み
 *               option base 0    ポインタによる引き数渡し
 *
 *   機能        係数が同じであるk組の実係数連立１次方程式
 *                       Ａ[m, m]・Ｘ[m,k] = Ｂ[m,k]
 *               の解をgaussjordan法で一度に求める。
 *               掃き出す際、軸(pivot)として列要素の絶対値最大を選択するため
 *               行列の入れ換えを行う
 *    書式  int gaujor(double *a, int l, int m, int n, double eps)
 *
 *   引き数  入出力
 *           a   :a[L][N]なる実配列名で実係数連立１次方程式の係数行列および
 *                定数行列である。演算後は定数行列部、すなわちa[i][j],
 *                i=0,1,2,...,M-1, j=M,M+1,M+2,...,N-1に解が得られる。
 *            入力
 *           l   :メインプログラムで宣言した配列Aの第１添字の値を、整定数か整
 *                　変数名で与える。　L≧M
 *           m,n :配列Aの内、演算対象となる列数を、整定数か整変数名で与える
 *                但し、N=M+K、Kは定数行列の列数である。N>M  80≧M≧2
 *           eps :収束判定値を実定数か実変数名で与える。EPS>0
 *            出力
 *           関数値   :エラーフラグである。
 *                       0   : エラーなし
 *                       1   : 掃き出しの途中、ピボット要素がepsより小さい
 *                      -1   : m<2, m>80, m≧n, eps≦0 のいずれかである
 *   スレーブサブルーチン    : なし
 *----------------------------------------------------------------------------
 */
 
package kahata.Sslib;
/// インポート
import java.lang.String;
//import java.math.*;

class Sslib253 {
	public  String output() {
		int nmax = 50;
		int l=  3;
		int m = 3;
		int n = 5;
		double eps = 1.0e-16;

		int i,j,g,ier=0;
		double a[][] = {{5.0, 1.0, 1.0, 10.0, 18.0},
					 {1.0,-7.0, 2.0, -7.0, -9.0},
					 {1.0, 1.0, 6.0, 21.0, 11.0}};

		//LsEquation p = new LsEquation();


		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("              ★ 科学技術計算サブルーチンライブラリー（Java）\n");
		rs +=  String.format("      2.5.3 実係数連立１次方程式　ガウス・ジョルダン法（ＧＡＵＪＯＲ）\n\n");
		rs +=  String.format("            given matrix:\n");
  
		for(i=0; i<l; i++){
			rs +=  String.format("                ");
			for(j=0; j<n; j++)
				rs +=  String.format("% 6.2f", a[i][j]);
			rs +=  String.format("\n");
		}
  
		ier = LsEquation.gaujor(a, l, m, n, eps);
  
		rs +=  String.format("\n        solution by gaujor:\n");

		for(i=1; i<=n-m;i++)
			rs +=  String.format("              [no. %d]     ",i);
		rs +=  String.format("\n");

		for(i=0; i<l; i++){
			for(j=m; j<n; j++)
				rs +=  String.format("        x%d =% 10.6E",i+1,a[i][j]);
			rs +=  String.format("\n");
		}
		rs +=  String.format("\n");
		return rs;
	}
}
/*
	static int gaujor(double[][] a, int l, int m, int n, double eps){
  		int i,ii,j,k,lc=0,lr=0,iw;
  		double wmax,w,pivot,api;
  		 int[] work = new int[80];

  		for(i=0; i<80; i++) work[i]= 0;

  		if(m<1 || m>79 || m>=n || eps<=0)
    		return(-1);
  		for(i=0; i<m; i++)
    		work[i] = i;
  		for(k=0; k<m; k++){
    		wmax = 0.0;
    		for(ii=k; ii<m; ii++){
      			for(i=k; i<m; i++){
					w = Math.abs(a[i][i]);
					if(w>=wmax){
	  					wmax = w;
	  					lc = i;
	  					lr = ii;
					}
      			}
    		}
    		pivot = a[lr][lc];
    		api = Math.abs(pivot);
    		if(api<=eps)
      			return(-1);
    		if(lc!=k){
      			iw = work[k];
      			work[k] = work[lc];
      			work[lc] = iw;
      			for(i=0; i<m; i++){
					w = a[i][k];
					a[i][k] = a[i][lc];
					a[i][lc] = w;
      			}
    		}
    		if(lr!=k){
      			for(j=k; j<n; j++){
					w = a[lr][j];
					a[lr][j] = a[k][j];
					a[k][j] = w;
      			}
    		}
    		for(i=k+1;i<n; i++)
      			a[k][i] = a[k][i] / pivot;
    		for(i=0; i<m; i++){
      			if(i!=k){
					w = a[i][k];
				for(j=k+1; j<n; j++)
	  				a[i][j] = a[i][j] - w * a[k][j];
      			}
    		}
  		}
  		for(i=0; i<m; i++){
    		do{
      			k = work[i];
      			if(k==i) break;
      				iw = work[k];
      				work[k] = work[i];
      				work[i] = iw;
      				for(j=m; j<n; j++){
						w = a[k][j];
					a[k][j] = a[i][j];
					a[i][j] = w;
      			}
    		} while(true);
  		}
  		return(0);
	}
}
*/
