//  -*- mode: java -*-  Time-stamp: <2012-02-02 9:13:51 kahata>
/*================================================================
 * プログラム名: sslib22a.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib22a.java,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * Programmed By: 畑和彦 <kazuhiko.hata@nifty.ne.jp>                
 * To compile: cからの変更点
 *             javaで参照渡し困難なため値を返すようにした。
 *             slave関数 termはMathFunctionクラス内関数に定義した
 * To run:
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.46  2.2.10 ベキ級数（ＢＥＫＩ）
 *
 *   機能        関数f(x)のベキ級数展開式f(x)=Σanｘ(n) [n=0,∞]の値を求める
 *   呼出方法    int beki(double a0, double x, double eps, double *fx)
 *   引き数  入力
 *               a0  :級数の第0項目a0の値を実定数か実変数名で与える。a0≠0
 *               x   :求めるべき点の値を実定数か実変数名で与える
 *               EPS :収束判定値
 *           出力
 *               fx  :倍精度実変数名で、積分値が得られる
 *               beki:
 *                       fx   :エラーなし
 *                       999 :xi≧xeである
 *   スレーブ        :term (被積分関数を定義する倍精度関数)
 *
 *    Cintのdllでは関数ポインタに問題あり。インタープリタで実行のこと
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib22a {
	public  String output() {
		//MathFunction p = new MathFunction();
		int i;
		double a0,d0,rad,fx,y,eps = 1E-18;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                          2.2.10 ベキ級数（ＢＥＫＩ）\n\n");
		rs +=  String.format("            d0       rad               beki              cos\n");
	  
		a0 = 1.0;
		for(i=1; i<=361; i+=30){
		    d0 = (double)i - 1;
		    rad = 0.0174532925 * d0;
		    fx = MathFunction.beki(a0, rad, eps);
		    y = Math.cos(rad);
		    rs +=  String.format("        % 6.1f    % 12.6E    % 12.6E    % 12.6E\n",
				      d0, rad, fx, y);
		}
		rs +=  String.format("\n");
		return rs;
	}
}
