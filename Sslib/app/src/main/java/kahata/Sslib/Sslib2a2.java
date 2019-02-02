// * -*- mode: java -*-  Time-stamp: <08/03/06(木) 11:16:09 hata>
/*================================================================
 * プログラム名: Sslib2a2.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib2a2.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.137 2.10.2 ポアソン乱数（ＰＯＩＳＯＮ）
 *
 *   機能        rand()を用いて一様乱数を発生させ、これをもとに1個のポアソン
 *               乱数を発生させる。繰り返すことで一連のポアソン乱数を得る。
 *
 *   呼出方法    call poison(rav, irn, ier)
 *
 *   引き数
 *           入力
 *               rav :発生させるポアソン乱数の平均値を実定数か実変数名で与える
 *                    10≧rav≧0 (rav>10のときは正規乱数となるのでnormalを
 *                    使用する)
 *           出力
 *               irn :実変数名で、結果のポアソン乱数が得られる。
 *               ier     :整変数名で、エラーフラグである。
 *                           0   : エラーなし。
 *                          -1   : rav>10である。
 *
 *   スレーブサブルーチン: なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib2a2 extends MiscFunction{
	public  String output() {
		int[]  a= new int[12];
		int i,k,ier;
		double r,rav,ave,av,pro;
		double irn[] = {0.0};
		rav = 5.0;

		int n = 500;
		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（java）");
		rs +=  String.format("                    2.10.2 ポアソン乱数（ＰＯＩＳＯＮ）\n\n");
		rs +=  String.format("                   a poison random number :\n");
  		rs +=  String.format("                                n   =  %4d\n", n);
  		rs +=  String.format("                            lamda   =    % 8.5f\n\n", rav);
  
  		ave = 0.0;
  
  		for(i=1; i<=11; i++)
    		a[i] = 0;
  		r = irand()/32767.1;
  		for(i=1; i<=n; i++){
    		ier = poison(rav, irn);
    		ave = ave + irn[0];
    		k = (int)(irn[0] + 1);
    		if(k<=11 && k>=0)
      			a[k]++;
  		}
  		r = irand()/23767.1;
  		av = ave / n;
  		rs +=  String.format("                   observed number :\n");
  		rs +=  String.format("                              ave   =    % 8.5f\n\n", av);

  		for(i=1; i<=11; i++){
    		pro = a[i] * 100.0 / n;
    		rs +=  String.format("                     rn = %2d   -------% 6.2f %%   %4d\n",i-1,pro,a[i]);
  		}
  		rs +=  String.format("\n");
		return rs;
	}
}
