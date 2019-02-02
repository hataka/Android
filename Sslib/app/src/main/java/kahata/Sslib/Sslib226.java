//  -*- mode: java -*-  Time-stamp: <2012-02-02 8:58:44 kahata>
/*================================================================
 * プログラム名: sslib226.c
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib226.c,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * Programmed By: 畑和彦 <kazuhiko.hata@nifty.ne.jp>                
   To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.38 2.2.6 誤差関数（ＥＲＦ）
 *
 *   機能        誤差関数　erf(x)= (2/π)exp(-t*t)dt [0～π] :x≧0
 *               の値をhastingsの近似式で求める
 *
 *   書式        double erf(double x)
 *   引き数  入力
 *                   x      : erf(x)の引き数xを実定数か実変数名で与える
 *  戻り値   出力
 *                          : erf(x)の関数値を戻す
 *           エラー         : x<0の時、999 を戻す
 *
 *   スレーブ               : なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib226 {
	public  String output() {
		//MathFunction p = new MathFunction();
		int i;
		double x,fx;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		System.out. printf("                          2.2.6 誤差関数（ＥＲＦ）\n\n");
	  	rs +=  String.format("                           x              erf(x)\n");
		for(i=0; i<11; i++){
		    x =(double)i/2.0;
		    fx=MathFunction.erf(x);
		    rs +=  String.format("             %15.1f           % 12.6E\n", x, fx);
		}
		rs +=  String.format("\n");
		return rs;
	}
}
