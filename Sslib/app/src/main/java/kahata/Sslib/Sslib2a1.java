// * -*- mode: java -*-  Time-stamp: <08/03/06(木) 10:20:07 hata>
/*================================================================
 * プログラム名: Sslib2a1.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib2a1.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * To compile:
 * To run: JavaConsoleApplication
 * 説明: 
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.134 2.10.1 正規乱数（ＮＯＲＭＡＬ）
 *
 *   機能        rand()を用いて一様乱数を発生させ、これをもとにbox-muler法に
 *               よって2個の正規乱数を発生させる。繰り返すことで一連の正規乱数
 *               乱数が得られる。
 *
 *   呼出方法    call normal(av, st, rn)
 *
 *   引き数
 *           入力
 *                av   :発生させる正規乱数の平均値を実定数か実変数名で与える
 *                st   :発生させる正規乱数の標準偏差を実定数か実変数名で与える
 *           出力
 *                rnx,rny :実変数名で、結果の正規乱数が得られる。
 *
 *   スレーブサブルーチン: なし
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

class Sslib2a1 extends MiscFunction{
	public  String output() {

		int n = 500;
		int[]  b = new int[11];
		int i;

		for (i =0; i<11;i++ ) b[i] =0;

		double av,st,sum,var,ave,pro;
		double[]  x= new double[500],y= new double[500];
		double rnx[] = {0.0}, rny[] = {0.0};

		av = 5.0;
		st = 2.0;

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
  		rs +=  String.format("                     2.10.1 正規乱数（ＮＯＲＭＡＬ）\n\n");
  		rs +=  String.format("                   a normal random nunber :\n");
  		rs +=  String.format("                                n   =  %4d\n", n);
  		rs +=  String.format("                              ave   =    % 8.5f\n",av);
  		rs +=  String.format("                               st   =    % 8.5f\n\n",st);
  
  		sum = 0.0;
  		var = 0.0;
  		for(i=0; i<11; i++)
    		b[i] = 0;
  		for(i=0; i<n; i++){
    		normal(av, st, rnx, rny);
    		x[i] = rnx[0];
    		y[i] = rny[0];
    		sum += rnx[0];
    		sum += rny[0];
    		if(rnx[0] >= 0) b[(int)rnx[0]]++;
    		if(rny[0] >= 0) b[(int)rny[0]]++;
  		}
  		ave = sum /(2 * n);
  		for(i=0; i<n; i++){
    		var += (x[i] - ave)*(x[i] - ave);
    		var += (y[i] - ave)*(y[i] - ave);
  		}
  		st = Math.sqrt(var /(2 * n));
  		rs +=  String.format("                   observed number :\n");
  		rs +=  String.format("                              ave   =    % 8.5f\n", ave);
  		rs +=  String.format("                               st   =    % 8.5f\n\n", st);

  		for(i=0; i<11; i++){
    		pro = b[i] * 100 /(2*n);
    		rs +=  String.format("                     %2d > rn >= %2d   ------- %5.2f %%  %4d\n", i+1, i, pro, b[i]);
  		}
  		rs +=  String.format("\n");
		return rs;
	}
}
