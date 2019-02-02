//  -*- mode: java -*-  Time-stamp: <2012-02-02 9:06:16 kahata>
/*================================================================
 * プログラム名: sslib228.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib228.java,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * Programmed By: 畑和彦
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.42  2.2.8 ルジャンドルの多項式（ＬＥＧＥＮＤ）
 *
 *   機能        Legendreの多項式の値を、漸化式により求める
 *
 *   書式        double legend(double x, int n)
 *   引き数  入力
 *                   x      : Ｐn(x)の引き数xを実定数か実変数名で与える
 *                   n      : Ｐn(x)のnを整定数か整変数名で与える。n≧0
 *   戻り値   出力
 *                          : Ｐn(x)の関数値を戻す
 *           エラー         : n<0の時、999 を戻す
 *
 *   スレーブ               : なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib228 {
	public  String output() {
		//MathFunction p = new MathFunction();
		int i;
		double x,p2x,p10x;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
    	rs +=  String.format("                     2.2.8 ルジャンドルの多項式（ＬＥＧＥＮＤ）\n\n");
    	rs +=  String.format("              x          p2(x)                     p10(x)\n");

    	for(i=1; i<=11; i++){
    		x =((double)i - 1.0) / 10.0;
    		p2x = MathFunction.legend(x, 2);
    		p10x =MathFunction.legend(x, 10);
    		rs +=  String.format("           % 5.2f      % 15.8E          % 15.8E\n", x, p2x, p10x);
    	}
    	rs +=  String.format("\n");
    	return rs;
	}
}
