// * -*- mode: java -*-  Time-stamp: <08/03/03(月) 14:41:47 hata>
/*================================================================
 * プログラム名: Sslib281.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib281.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run:  JavaConsoleApplication  Cint Version  OK! cint -03 で実行のこと
 * 説明: 
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.123 2.8.1 高速フーリエ変換（ＦＦＴ）
 *
 *   機能        n個の時系列データf(0),f(1)...,f(n-1)に対するフーリエ変換
 *                     n-1
 *               f(n)= Σ f(k)･w**nk   ; n=0,1,...n-1
 *                     k=0
 *               と、f(0),f(1)...,f(n-1)が与えられたときのフーリエ逆変換
 *                          n-1
 *               f(k)=(1/n)*Σ f(n)･w**(-nk)   ; k=0,1,...n-1
 *                          n=0
 *               の値を、cooley-tukeyのアルゴリズムによって求める。
 *               ただし、nは2のベキ乗に等しい場合である。
 *               また、wは、
 *                       w = exp(-2πi/n)
 *           
 *   呼出方法    call fft(ar(), ai(), n, flag, ier)
 *
 *   
 *   引き数
 *           入出力
 *             ar(),ai() :ar(n),ai(n)なる実配列名である。
 *                        フーリエ変換時には、時系列の実数部をar(1)～ar(n)に、
 *                        虚数部をai(1)～ar(n)に格納して渡す。
 *                        演算結果は実数部と虚数部も同じ配列に得られる。
 *                        逆フーリエ変換時には、周波数系列データの実数部、虚数
 *                        部を与えると、演算結果の実数部と虚数部が得られる。
 *           入力
 *               n       :データ数を整定数か整変数名で与える。
 *                          n=2**ν ( ν=1,2,3,4....)
 *               flag    :フーリエ変換の種類を示すフラグで整定数か整変数で与える
 *                         0 : フーリエ変換
 *                         1 : 逆フーリエ変換
 *           出力
 *               ier     :整変数名で、エラーフラグである
 *                         0 :エラーなし
 *                         1 :n≠2**ν (ν=1,2,3....)である
 *                       999 :n<2である
 *
 *   スレーブサブルーチン: なし
 *----------------------------------------------------------------------------
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
class Sslib281 extends Fft{
	public  String output() {
		int n = 8;
		int i,flag,f;
 		Ccomplex[] a = new Ccomplex[8];

		for (i=0;i<8;i++){
			a[i] = new Ccomplex(0.0, 0.0);
		}
		a[3].x = 1.0;
		a[3].y = 0.0;
		a[4].x = 1.0;
		a[4].y = 0.0;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
	 	rs +=  String.format("                     2.8.1 高速フーリエ変換（ＦＦＴ）\n\n");
		rs +=  String.format("           Matrix a:          ar                      ai\n");
		for(i=0; i<n; i++)
			rs +=  String.format("                           % 13.7E         % 13.7E\n",a[i].x,a[i].y);
		rs +=  String.format("\n");

  	/*   forward fft    */
		flag = 0;

		f = fft(a, n, flag);
		rs +=  String.format(" Forward FFT  Matrix a:       ar                      ai\n");
	 	for(i=0; i<n; i++)
			rs +=  String.format("                           % 13.7E         % 13.7E\n",a[i].x,a[i].y);
		rs +=  String.format("\n");

	/*   inverse fft    */
		flag = 1;
		f = fft(a, n, flag);
		rs +=  String.format(" Inverse FFT  Matrix a:       ar                      ai\n");
		for(i=0; i<n; i++)
			rs +=  String.format("                           % 13.7E         % 13.7E\n",a[i].x,a[i].y);
		rs +=  String.format("\n");
		rs +=  String.format("    IER Code No. = %4d\n\n",f);
		return rs;
	}
}
