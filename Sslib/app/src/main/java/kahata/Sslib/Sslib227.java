//  -*- mode: java -*-  Time-stamp: <2012-02-02 9:02:45 kahata>
/*================================================================
 * プログラム名: sslib227.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib227.java,v 1.3 2002/02/22 23:24:01 kahata Exp $
 * Programmed By: 畑和彦
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *   p.38 2.2.7 ガンマ関数（ＧＡＭＭＡ）    *
 *                                  
 *   機能        Gamma関数　Γ(x)= ∫exp(-t)t^(x-1)dt [0～∞] :x>0
 *               の値をHastingsの近似式で求める
 *
 *   書式        double gamma(double x)
 *   引き数  入力
 *                   x      : gamma(x)の引き数xを実定数か実変数名で与える
 *  戻り値   出力
 *                          : gamma(x)の関数値を戻す
 *           エラー         : x≦0 かx≧34 の時、999 を戻す
 *
 *   スレーブ               : なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib227 {
	public  String output() {
		//MathFunction p = new MathFunction();
		int i;
		double x;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
	  	rs +=  String.format("                      2.2.7 ガンマ関数（ＧＡＭＭＡ）\n\n");
	  	rs +=  String.format("                       x              gamma(x)\n");
	  
		for (i = 5; i <= 50; i=i+5){
		    x = (double)i / 10.0;
		    rs +=  String.format("         %15.1f           % 15.13E\n", x, MathFunction.gamma(x));
		}
		rs +=  String.format("\n");
		return rs;
	}
}
