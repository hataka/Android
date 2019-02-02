//  -*- mode: java -*-  Time-stamp: <07/06/06 05:15:50 k.hata>

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib213 {
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
		rs +=  String.format("      2.1.3 複素数　対数、指数、ベキ乗 （ＣＣＬＯＧ、ＣＣＥＸＰ、ＣＣＰＷＲ）\n\n");

		z = ComplexCalc.cclog(a);
		rs +=  String.format("        log(%5.2f + %5.2f*i) = ( % 12.6E ) + ( % 12.6E )*i\n",
				  a.x,a.y,z.x,z.y);

		z = ComplexCalc.ccexp(a);
		rs +=  String.format("        exp(%5.2f + %5.2f*i) = ( % 12.6E ) + ( % 12.6E )*i\n",
				  a.x,a.y,z.x,z.y);

		z = ComplexCalc.ccpwr(a, b);
		rs +=  String.format("  (%5.2f+%5.2f*i)^(%5.2f+%5.2f*i) = ( % 12.6E ) + ( % 12.6E )*i\n\n",	
				  a.x,a.y,b.x,b.y,z.x,z.y);		return rs;
	}
}
