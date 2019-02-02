// * -*- mode: java -*-  Time-stamp: <08/06/13(金) 02:58:48 hata>
/*================================================================
 * プログラム名: Sslib293.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib293.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.132 2.9.3 関数近似・スプライン補間（ＳＰＬＩＮＴ）
 *
 *   機能        標本点xi(i=1,2,..,n)に対するデータyi(i=1,2,...,n)から指定され
 *               た点x(x1≦x≦xn)における補間値を3次spline関数法によって求める
 *    
 *   呼出方法    splint(x(), y(), n, xx, yy, ier)
 *
 *   引き数
 *           入力
 *             x(),y()   :x(n),y(n)なる実配列名で、標本点とデータをそれぞれ与
 *                        える。
 *                        ただし、標本点はx(i)<x(i+1)(i=1,2,...,n-1)でなければ
 *                        ならない。
 *               n       :総データ数を、整定数か整変数名で与える。3≦n≦50
 *               xx      :求めようとする補間値に対するx(xl≦x≦xn)の値を
 *                        実定数か実変数名で与える
 *           出力
 *               yy      :実変数名で、指定されたxxの補間値が得られる。
 *               ier     :整変数名で、エラーフラグである
 *                           0   :エラーなし
 *                           999 :n<3,n>50,xi≧xi+1(i=1,2,..,n-1)のいずれか
 *                                である。
 *
 *   スレーブサブルーチン: subspl
 *----------------------------------------------------------------------------
 */
 
package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib293 extends Aproximation{
	public  String output() {

		int n = 10;
		int nmax = 20;
		double pai = 3.14159265358;

		int i;
		double exact,xx,yy;
		double[]  x = new double[20],y = new double [20];


		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                    2.9.3 スプライン補間（ＳＰＬＩＮＴ）\n\n");
		for(i=0; i<10; i++){
			x[i] = 0.1 * pai * i;
			y[i] = Math.sin(x[i]);
		}

		xx = 1.0;
		exact = Math.sin(xx);
		yy = splint(x, y, n, xx);

		rs +=  String.format("                 x = % 5.3f       Interp. =   % 10.8f\n",xx,yy);
		rs +=  String.format("                                  Exact   =   % 10.8f\n\n",exact);
		return rs;
	}
}
