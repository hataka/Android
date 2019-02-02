// * -*- mode: java -*-  Time-stamp: <08/02/26(火) 16:19:36 hata>
/*================================================================
 * プログラム名: Sslib255.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib255.c,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * 説明: 
 * (重要!)JAVAはクラス多次元配列、数値多次元配列の四則演算に問題あり
 * 複素に次元配列を実数三次元配列にして、各要素(実数)ごとの計算が必要！
 * bug-fixに長時間要した。
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.95 2.5.5 複素係数連立１次方程式　ガウス・ジョルダン法（ＣＧＡＵＪ）
 *
 *   機能   係数が同じであるk組の複素係数連立１次方程式
 *                  Ａ[m, m]・Ｘ[m, k] = Ｃ[m, k]
 *          の解をgauss-jordan法で求める。掃き出す際、軸(pivot)として
 *          行列要素の絶対値最大を選択するため行列の入れ換えを行う
 *
 *   仕様
 *          #include <math.h>
 *          int cgauj(struct complex *a, int l, int m, int n, double eps)
 *
 *   引き数 入出力
 *           a   : a(l, n)なる複素数構造体配列名で複素係数連立１次方程式
 *                 の係数行列および定数行列の実数部と虚数部を与える
 *                 演算後は定数行列部、すなわちa[i][j]
 *                 i=0,1,2,..,m-1, j=m,m+2,..,n-1に実数部、虚数部の解を得る
 *           入力
 *           l   :メインプログラムで宣言した配列AR,AIの第１添字の値を、
 *                整定数か整変数名で与える。　l≧m
 *           m,n :配列AR,AIの内、演算対象となる列数を、整定数か整変数名で与える
 *                但し、n=m+k、Kは定数行列の列数である。n>m  60≧m≧2
 *           eps :収束判定値を実定数か実変数名で与える。EPS>0
 *
 *  戻り値  エラーフラグ
 *           0   : エラーなし
 *           1   : 掃き出しの途中、ピボット要素がEPSより小さい
 *          -1   : m<2, m>60, m≧n, eps≦0 のいずれかである
 *
 * スレーブ なし
 *---------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;
/*
class Ccomplex {
    double x=0,y=0;
    Ccomplex(double a,double b) {
	x = a;
	y = b;
    }
}
*/
class Sslib255 {
	public  String output() {
		int nmax = 50;
		int l = 3;
		int m = 3;
		int n = 4;
		double eps = 0.0000000000000001;

		double a[][][] = {{{2.0,-1.0},{1.0,2.0},{3.0,1.0},{10.0,2.0}},
				  {{1.0,1.0},{-2.0,-4.0},{5.0,3.0},{-3.0,-1.0}},
				  {{-4.0,-1.0},{5.0,1.0},{1.0,4.0},{2.0,4.0}}};
		int i,j,ier=0;

		//LsEquation p = new LsEquation();

		// 文字列変数の宣言
		String rs;
		
		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("       2.5.5 複素係数連立１次方程式　ガウス・ジョルダン法（ＣＧＡＵＪ）\n\n");
		rs +=  String.format("              given equation:\n");
		rs +=  String.format("                 ( 2 -  i)x1 +( 1 + 2i)x2 +( 3 +  i)x3 = 10 + 2i\n");
		rs +=  String.format("                 ( 1 +  i)x1 +(-2 - 4i)x2 +( 5 + 3i)x3 = -3 -  i\n");
		rs +=  String.format("                 (-4 -  i)x1 +( 5 +  i)x2 +( 1 + 4i)x3 =  2 + 4i\n");

		ier = LsEquation.cgauj( a, l, m, n, eps);

		rs +=  String.format("\n              solution by cgauj:\n");
		for(j=m; j<n; j++){
			for(i=0; i<m; i++)
			rs +=  String.format("                  x(%d) = (% 10.7E) + (% 10.7E)*i \n",i+1,a[i][j][0],a[i][j][1]);
		}
		rs +=  String.format("              error code      ier = %3d\n\n",ier);
		return rs;
	}
}
/*
	static int cgauj(double[][][]  a, int l, int m, int n, double eps){
  		int i,j,k,ii,lc=0,lr=0,iw;
  		int[]  work = new int[61];
  		double ww,wmax,pivot,wr,wi,w1,w2;
  		double[] w ={0.0,0.0};

		if(m<2 || m>60 || m>=n || eps<0.0)
    		return(-1);
  		for(i=0; i<m; i++)
    		work[i] = i;
  			for(k=0; k<m; k++){
    			wmax = 0.0;
    			for(ii=k; ii<m; ii++){
      				for(i=k; i<m; i++){
						ww = Math.pow(a[ii][i][0],2) + Math.pow(a[ii][i][1],2);
						if(ww>wmax){
	  						wmax = ww;
	  						lc = i;
	  						lr = ii;
						}
      				}
    			}

    			pivot = Math.pow(a[lr][lc][0],2) + Math.pow(a[lr][lc][1],2);
				if(pivot<=eps)
      				return(1);
    			if(k!=lc){
      				iw = work[k];
      				work[k] = work[lc];
      				work[lc] = iw;
      				for(i=0; i<m; i++){
						w[0] = a[i][k][0];
						w[1] = a[i][k][1];
						a[i][k][0] = a[i][lc][0];
						a[i][k][1] = a[i][lc][1];
						a[i][lc][0] = w[0];
						a[i][lc][1] = w[1];
      				}
    			}
    			if(k!=lr){
      				for(j=k; j<n; j++){
						w[0] = a[lr][j][0];
						w[1] = a[lr][j][1];
						a[lr][j][0] = a[k][j][0];
						a[lr][j][1] = a[k][j][1];
						a[k][j][0] = w[0];
						a[k][j][1] = w[1];
				    }
    			}
    			w[0] = a[k][k][0] / pivot;
    			w[1] = -a[k][k][1] / pivot;
    			for(i=k; i<n; i++){
      				ww = a[k][i][0] * w[0] - a[k][i][1] * w[1];
      				a[k][i][1] = a[k][i][0] * w[1] + a[k][i][1] * w[0];
      				a[k][i][0] = ww;
    			}
    			for(i=0; i<m; i++){
      				if(i!=k){
						w[0] = a[i][k][0];
						w[1] = a[i][k][1];
						for(j=k; j<n; j++){
	  						w1 = a[k][j][0] * w[0] - a[k][j][1] * w[1];
	  						w2 = a[k][j][0] * w[1] + a[k][j][1] * w[0];
	  						ww = a[i][j][0] - w1;
	  						a[i][j][1] = a[i][j][1] - w2;
	  						a[i][j][0] = ww;
						}
      				}
    			}
  			}
  			for(i=0; i<m-1; i++){
    			do{
      				k = work[i];
      				if(k==i) break;
      				iw = work[k];
      				work[k] = work[i];
      				work[i] = iw;
      				for(j=m; j<n; j++){
						w[0] = a[k][j][0];
						w[1] = a[k][j][1];
						a[k][j][0] = a[i][j][0];
						a[k][j][1] = a[i][j][1];
						a[i][j][0] = w[0];
						a[i][j][1] = w[1];
					}
    			} while (true);
  			}
  		return 0;
	}
}
*/
