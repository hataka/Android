// * -*- mode: java -*-  Time-stamp: <2010-06-15 8:41:38 kahata>
/*================================================================
 * プログラム名: Sslib292.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib292.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run: JavaConsoleApplication
 * description: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.130 2.9.2 関数近似・ラグランジェ補間（ＬＡＧＲＡ）
 *
 *   機能        n個の点(xi,yi; i=1,2,...,n)が与えられていて、任意のxに対する
 *               点の関数値 y=f(x) をlagrange補間法で求める
 *       
 *   書式   int lagra(double x[], double y[], int n, double xi, double *yi);
 *
 *   引き数
 *           入力
 *             x[],y[]   :x(n),y(n)なる実配列名で、n個の点(x1,y1),(x2,y2),...
 *                        (xn,yn)を与える。
 *               n       :データ数を整定数か整変数名で与える。n≧2
 *               xi      :求めたい点のx座標を実定数か実変数名で与える
 *                         x(1)≦xi≦x(n)
 *           出力
 *               yi      :実変数名で、xiに対応した関数値が得られる
 *               戻り値  :整数で、エラーフラグである
 *                           0  :エラーなし
 *                          -1  :n<2か、xi<x(1)か、xi>x(n)のいずれかである
 *
 *   スレーブサブルーチン: なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib292 extends Aproximation{
	public  String output() {
		int n = 5;
		double xi,yi,z;

		double x[]={0.15,      0.20,      0.25,      0.30,      0.35},
						y[]={0.86070798,0.81873075,0.77880078,0.74081822,0.70468809};

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("                    2.9.2 ラグランジェ補間（ＬＡＧＲＡ）\n\n");

		xi = 0.27;
		yi = lagra(x, y, n, xi);
		z = Math.exp(-xi);

		rs +=  String.format("                  x          lagra                exp(-x)\n");
		rs +=  String.format("               %5.2f      % 10.7E      % 10.7E\n\n",xi,yi,z);
		return rs;
	}
}
