// * -*- mode: java -*-  Time-stamp: <08/03/06(木) 11:42:05 hata>
/*================================================================
 * プログラム名: Sslib2a3.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib2a3.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*                                 
 *----------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.139 2.10.3 ２項係数（ＢＩＮＯ）
 *
 *   機能        ２項係数 mＣn = m!/n!*(m-n)! を求める
 *-----------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
import java.math.*;

class Sslib2a3 extends MiscFunction{
	public  String output() {
		int i,m,n,ier;
		int a[]={5,10,50}, b[]={3,5,30};
		double bc[] = {0.0};

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
  		rs +=  String.format("                        2.10.3 ２項係数（ＢＩＮＯ）\n\n");
  		rs +=  String.format("%50s\n","a binominal coefficient :");
  
  		for(i=0; i<3; i++){
    		m = a[i];
    		n = b[i];
    		ier = bino(m, n, bc);
    		rs +=  String.format("                 n = %3d    m = %3d    nＣm = % 10.7E\n", m, n, bc[0]);
  		}
  		rs +=  String.format("\n");
		return rs;
	}
}
