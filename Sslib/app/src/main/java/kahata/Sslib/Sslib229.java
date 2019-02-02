//  -*- mode: java -*-  Time-stamp: <2012-02-02 9:10:09 kahata>
/*================================================================
 * プログラム名: sslib229.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib229.java,v 1.3 2002/02/22 23:24:01 k.hata Exp $
 * Programmed By: 畑和彦
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.44  2.2.9 第１種、第２種完全楕円積分（ＣＥＬＩ１、ＣＥＬＩ２）
 *
 *   機能        第１種、第２種完全楕円積分の値を、算術幾何平均法で求める
 *
 *   書式        第１種 : double celi1(double pk)
 *               第２種 : double celi2(double pk)
 *
 *   引き数  入力
 *                   pk     : Ｋ(k),Ｅ(k)の引き数xを実定数か実変数名で与える
 *
 *   戻り値   出力
 *                          : Ｋ(k),Ｅ(k)の関数値を戻す
 *           エラー         : ｜pk｜>1の時、999 を戻す
 *
 *   スレーブ               : なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib229 {
	public  String output() {
		//MathFunction p = new MathFunction();
		int i;
		double px,pk,fk,fe;

		// 文字列変数の宣言
		String rs="";

		rs +=  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("               2.2.9 第１種、第２種完全楕円積分（ＣＥＬＩ１、ＣＥＬＩ２）\n\n");
		rs +=  String.format("         k*k       k                  k(k)               e(k)\n");
		for(i=0; i<=100; i+=10){
		    px = (double)i / 100.0;
		    pk = Math.sqrt(px);
		    fk = MathFunction.celi1(pk);
		    fe = MathFunction.celi2(pk);
		    rs +=  String.format("        %4.2f    % 12.7E    % 12.7E    % 12.7E\n", px, pk, fk, fe);
		}
		rs +=  String.format("\n");
		return rs;
	}
}
