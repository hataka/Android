//  -*- mode: java -*-  Time-stamp: <07/06/06 05:14:47 k.hata>
/*================================================================
 * プログラム名: sslib211.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib211.c,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * http://192.168.24.92/android/Sslib/Sslib211/src/kahata/Sslib211/Sslib211.java
 * Programmed By: 畑和彦
   To Ron: JavaConsoleApplication
   To compile:
     本来の組み込みstruct,functionとの衝突を避けるためcomplex
     ライブラリの先頭にCを付与する <Sat Feb 02 10:15:42 2002>
   To run:        cint -03 で実行のこと
 * 説明: 
 *================================================================*/
/* 
 * ----------------------------------------------------------------
 *      ★ 科学技術計算サブルーチンライブラリー  
 *
 *      ２．１．１ 複素数の加減算   ( ccadd, ccsub )
 *          
 *      仕様:
 *          #include <math.h>
 *          struct ccomplex cadd(struct ccomplex a, struct ccomplex b)
 *          struct ccomplex csub(struct ccomplex a, struct ccomplex b)
 *
 *      引数    入力    複素数構造体、
 *              a{x,y}:a.x + a.y･i の実数部と虚数部を定数か変数名で与える。
 *              b{x,y}:b.x + b.y･i の実数部と虚数部を定数か変数名で与える。
 *
 *      戻り値  出力　　計算結果の複素数構造体、
 *                      z{x,y}:z.x + z.y･i の実数部と虚数部を戻す。
 *
 *      エラーフラグ    なし
 *      スレーブ        なし
 *  To compile:
 *    本来の組み込みstruct,functionとの衝突を避けるためcomplex
 *    ライブラリの先頭にCを付与する <Sat Feb 02 10:15:42 2002>
 *-------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
// インポート
import java.lang.String;
//import java.math.*;
/*
class Ccomplex {
    double x=0,y=0;
    Ccomplex(double a,double b) {
	x = a;
	y = b;
    }
}
*/

class Sslib211 {
	public String rs;
	//public static void main(String args[]) {
	public  String output() {
	
	Ccomplex a,b,z; // Pointクラスのオブジェクトを参照するオブジェクト変数を宣言
	// 文字列変数の宣言。
	//String rs;
 
	//ComplexCalc p = new ComplexCalc();

    	
	a = new Ccomplex(2.0, 2.0);
	b = new Ccomplex(1.0, 1.0);
	z = new Ccomplex(0.0, 0.0);

	rs = "\n";	
	rs += "               ★ 科学技術計算サブルーチンライブラリー（java）\n";
	rs += "               2.1.1 複素数　加減算 （ＣＣＡＤＤ、ＣＣＳＵＢ）\n\n";
  
	z = ComplexCalc.ccadd(a, b);
	rs +=  String.format("  (%5.2f+%5.2f*i)+(%5.2f+%5.2f*i) = (% 10.6E )+(% 10.6E )*i\n",
			  a.x,a.y,b.x,b.y,z.x,z.y);
	
	z = ComplexCalc.ccsub(a, b);
	rs +=  String.format("  (%5.2f+%5.2f*i)-(%5.2f+%5.2f*i) = (% 10.6E )+(% 10.6E )*i\n\n",
			  a.x,a.y,b.x,b.y,z.x,z.y);
    return rs;
	}
 }

