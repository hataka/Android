//  -*- mode: java -*-  Time-stamp: <07/06/06 18:28:58 k.hata>

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib215 {
	public  String output() {
		Ccomplex a,z; //b, Pointクラスのオブジェクトを参照するオブジェクト変数を宣言
		//ComplexCalc p = new ComplexCalc();
		a = new Ccomplex(2.0, 2.0);
		z = new Ccomplex(0.0, 0.0);
		double y  = 0.0;

		// 文字列変数の宣言
		String rs;

		rs =  String.format("\n%45s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                2.1.5 複素数 絶対値、平方根（ＣＣＡＢＳ、ＣＣＳＱＲＴ）\n\n");
	  
		y = ComplexCalc.ccabs(a);
		rs +=  String.format("           ccabs(%5.2f + %5.2f*i) = ( % 12.6E )\n", a.x, a.y, y);
		rs +=  String.format("           ccabs(%5.2f + %5.2f*i) = ( % 12.6E )\n", a.x, a.y, ComplexCalc.ccabs(a));

		z = ComplexCalc.ccsqrt(a);
		rs +=  String.format("          ccsqrt(%5.2f + %5.2f*i) = ( % 12.6E ) + ( % 12.6E )*i\n\n", a.x, a.y, z.x, z.y);
	 		return rs;
	}
}
