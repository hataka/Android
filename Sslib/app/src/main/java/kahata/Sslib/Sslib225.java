//  -*- mode: java -*-  Time-stamp: <2012-02-02 8:54:48 kahata>
/*================================================================
 * プログラム名: sslib225.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib225.java,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * Programmed By: 畑和彦
   To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *-----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.32 2.2.5 第２種変形ベッセル関数（ＢＥＳＫ０、ＢＥＳＫ１）
 *
 *   機能        第２種変形bessel関数において、Ｋ0(x),Ｋ1(x)の値をallenの近似
 *               式で求める
 *
 *   書式        Ｋ0(x)  : double besk0(double x)
 *               Ｋ1(x)  : double besk1(double x)
 *   引き数  入力
 *               x       : Ｋ0(x)、Ｋ1(x)の引数xを実定数か実変数名で与える
 *                          x>0
 *   戻り値  出力
 *                       : Ｋ0(x)、Ｋ1(x)の関数値が得られる
 *           エラー      : x<0の時、999 を戻す
 *
 *   スレーブ            : なし
 *-----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib225 {
	public  String output() {
		//MathFunction p = new MathFunction();
		double   x, bk0, bk1;
		int i;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                2.2.5 第２種変形ベッセル関数（ＢＥＳＫ０、ＢＥＳＫ１）\n\n");
		rs +=  String.format("                 x           besk0                  besk1\n");

		for (i=0; i<10; i++){
		    x = (double)i+1;
		    bk0 = MathFunction.besk0(x);
		    bk1 = MathFunction.besk1(x);
		    rs +=  String.format("              %5.2f       % 12.6E         % 12.6E\n", x, bk0, bk1);
		}
		rs +=  String.format("\n");
		return rs;
	}
}
