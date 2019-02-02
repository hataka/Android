//  -*- mode: java -*-  Time-stamp: <2012-02-02 8:43:49 kahata>
 /*================================================================
 * プログラム名: sslib223.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib223.java,v 1.3 2002/02/22 23:24:01 k.hata Exp $
 * Programmed By: 畑和彦
 * To run: JavaConsoleApplication
 * To compile:
 * 説明: 
 *================================================================*/
/*
 *-----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.29 2.2.3 第２種ベッセル関数（ＢＥＳＹ０、ＢＥＳＹ１）
 *
 *   機能        第２種変形bessel関数において、Ｙ0(x),Ｙ1(x)の値をallenの近似
 *               式で求める
 *
 *   書式        Ｙ0(x)  :double  besy0(double x)
 *               Ｙ1(x)  :double  besy0(double x)
 *   引き数
 *          入力
 *               x       : Ｙ0(x)、Ｙ1(x)の引数xを実定数か実変数名で与える
 *                          x>0
 *   戻り値
 *          出力
 *                       : Ｙ0(x)、Ｙ1(x)の関数値が得られる
 *          エラー       : x≦0 の時、999を戻す。
 *   スレーブ            : なし
 *-----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import java.lang.String;
//import java.math.*;

class Sslib223 {
	public  String output() {
		//MathFunction p = new MathFunction();
		double x, by0, by1;
		int i;
		// sprintf

		// 文字列変数の宣言
		String rs="";

		
		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                  2.2.3 第２種ベッセル関数（ＢＥＳＹ０、ＢＥＳＹ１）\n\n");
		rs +=  String.format("                 x           besy0                  besy1\n");
	  
		for (i=0; i<10; i++){
		    x = (double)i+1;
		    by0 = MathFunction.besy0(x);
		    by1 = MathFunction.besy1(x);
		    rs +=  String.format("              %5.2f       % 12.6E         % 12.6E\n", x, by0, by1);
		}
	    rs +=  String.format("\n");
		return rs;
	}
}
