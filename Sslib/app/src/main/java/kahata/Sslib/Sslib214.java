//  -*- mode: java -*-  Time-stamp: <07/06/06 18:14:56 k.hata>

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib214 {
	public  String output() {
	//public static void main(String args[]) {
		Ccomplex a,z; //// Pointクラスのオブジェクトを参照するオブジェクト変数を宣言
		//ComplexCalc p = new ComplexCalc();
		a = new Ccomplex(2.0, 2.0);
		z = new Ccomplex(0.0, 0.0);
  
		// 文字列変数の宣言。
		String rs;

		rs =  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                 2.1.4 三角関数（ＣＣＳＩＮ、ＣＣＣＯＳ、ＣＣＴＡＮ）\n\n");

		z = ComplexCalc.ccsin(a);
		rs +=  String.format("    sin( %5.2f + %5.2f * i ) = ( % 12.6E ) + ( % 12.6E )*i\n", 
				  a.x, a.y, z.x, z.y);
	  
		z = ComplexCalc.cccos(a);
		rs +=  String.format("    cos( %5.2f + %5.2f * i ) = ( % 12.6E ) + ( % 12.6E )*i\n", 
				  a.x, a.y, z.x, z.y);

		z = ComplexCalc.cctan(a);
		rs +=  String.format("    tan( %5.2f + %5.2f * i ) = ( % 12.6E ) + ( % 12.6E )*i\n\n", 
				  a.x, a.y, z.x, z.y);
		return rs;
	}
}
