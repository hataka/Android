//  -*- mode: java -*-  Time-stamp: <2012-02-02 8:48:03 kahata>
/*================================================================
 * プログラム名: sslib224.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib224.java,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * Programmed By: 畑和彦
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *-----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *	p.32 2.2.4 第１種変形ベッセル関数（ＢＥＳＩ０、ＢＥＳＩ１）
 *				  (完)
 *   機能		第１種変形bessel関数において、Ｉ0(x),Ｉ1(x)の値をallenの近似式
 *			   で求める
 *
 *   書式		Ｉ0(x)  : double besi0(double x)
 *			   Ｉ1(x)  : double besi1(double x)
 *   引き数  入力
 *			   x	   :Ｉ0(x)、Ｉ1(x)の引数xを実定数か実変数名で与える
 *						 x>0
 *   戻り値  出力
 *					   :Ｉ0(x)、Ｉ1(x)の関数値が得られる
 *		   エラー	  : x≦0 の時、999 を戻す
 *
 *   スレーブ			: なし
 *-----------------------------------------------------------------------------
 */
package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib224 {
	public  String output() {
		//MathFunction p = new MathFunction();
		double x, bi0, bi1;
		int i;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                  2.2.4 第１種変形ベッセル関数（ＢＥＳＩ０、ＢＥＳＩ１）\n\n");
		rs +=  String.format("                 x           besi0                  besi1\n");

		for (i=0; i<11; i++){
		    x = (double)i;
		    bi0 = MathFunction.besi0(x);
		    bi1 = MathFunction.besi1(x);
		    rs +=  String.format("              %5.2f       % 12.6E         % 12.6E\n", x, bi0, bi1);
		}
		rs +=  String.format("\n");
		return rs;
	}
}
