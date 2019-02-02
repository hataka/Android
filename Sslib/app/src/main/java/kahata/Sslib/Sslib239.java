// * -*- mode: java -*-  Time-stamp: <08/02/18(月) 13:23:46 hata>
/*================================================================
 * プログラム名: Sslib239.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: Sslib239.java,v 1.4 2008/02/18 13:23:46 k.hata Exp k.hata $
　*　Tp Run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.68  2.3.9 ２次元有限区間積分 等間隔シンプソン法（ＳＩＭＰＥ２）
 *
 *   機能        ２次元的に等間隔な標本点に対するデータｙij（i=1～n,j=1～m）
 *               の２次元積分をsimpson法により求める
 *---------------------------------------------------------------------------
 */

package kahata.Sslib;

// インポート
import java.lang.String;
//import java.math.*;

class Sslib239 {
	public  String output() {
		//DiffIntgl p = new DiffIntgl();
		int j,i,n1max,n1,n2,n;
		double h1,h2,s;
		double[][] y = new double[50][50];

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("               ★ 科学技術計算サブルーチンライブラリー（Java）\n");
		rs +=  String.format("           2.3.9 ２次元有限区間積分 等間隔シンプソン法(ＳＩＭＰＥ２) \n\n");
  	rs +=  String.format("                   y  = ∬(x^2+y^2)dxdy  [-1.0～1.0],[-1.0～1.0]\n");

		n1max = 20;
		n  = 20;
		h1 = 0.2;
		h2 = 0.2;
		n1 = 11;
		n2 = 11;

		for(j=0; j<11; j++){
			for(i=0; i<11; i++)
				y[i][j]=(((double)(i+1)-6)*((double)(i+1)-6)+((double)(j+1)-6)*((double)(j+1)-6))*0.04;
		}

		s = DiffIntgl.simpe22( y, n1max, n1, n2, h1, h2);

		rs +=  String.format("                   volume  =  % 18.15E\n\n", s);
		return rs;
	}
}
