//  -*- mode: java -*-  Time-stamp: <07/06/06 05:15:17 k.hata>

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;


class Sslib212 {
	public  String output() {
	//public static void main(String args[]) {
		Ccomplex a,b,z; // Pointクラスのオブジェクトを参照するオブジェクト変数を宣言
		//ComplexCalc p = new ComplexCalc();
		a = new Ccomplex(2.0, 2.0);
		b = new Ccomplex(1.0, 1.0);
		z = new Ccomplex(0.0, 0.0);
		// 文字列変数の宣言。
		String rs;

		rs =  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                  2.1.2 複素数　乗除算 （ＣＣＭＵＬ、ＣＣＤＩＶ）\n\n");
	  
		z = ComplexCalc.ccmul(a, b);
		rs +=  String.format("  (%5.2f+%5.2f*i)*(%5.2f+%5.2f*i) = ( % 10.6E ) + ( % 10.6E )*i\n",
				  a.x,a.y,b.x,b.y,z.x,z.y);
		 z = ComplexCalc.ccdiv(a, b);

		rs +=  String.format("  (%5.2f+%5.2f*i)/(%5.2f+%5.2f*i) = ( % 10.6E ) + ( % 10.6E )*i\n\n",
				  a.x,a.y,b.x,b.y,z.x,z.y);		return rs;
	}
}

