// * -*- mode: java -*-  Time-stamp: <08/02/18(月) 16:36:31 hata>
/*================================================================
 * プログラム名: Sslib241.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib241.c,v 1.4 2002/02/24 07:23:28 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *----------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.70  2.4.1 ３次代数方程式　カルダノ法（ＣＡＲＤＡ）
 *
 *   機能        ３次代数方程式
 *                   a1*x^3+a2*x^2+a3*x+a4=0 ;a1≠0
 *               のすべての根をcardano法により求める
 *----------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

/*
class Ccomplex {
    double x,y;
    Ccomplex(double a,double b) {
	x = a;
	y = b;
    }
}
*/

class Sslib241 {
	public  String output() {
		int i;
		double a[]={0.1, -0.5, 0.8, 1.4};
		Ccomplex[] x = new Ccomplex[3];
		x[0] = new Ccomplex(0, 0);
		x[1] = new Ccomplex(0, 0);
		x[2] = new Ccomplex(0, 0);

		//AlgEquation p = new AlgEquation();
		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n");
		rs +=  String.format("              ★ 科学技術計算サブルーチンライブラリー（Ｃ）\n");
		rs +=  String.format("               2.4.1 ３次代数方程式　カルダノ法（ＣＡＲＤＡ）\n\n");
		rs +=  String.format("           (% 6.2f )x^3 +(% 6.2f )x^2 +(% 6.2f )x +(% 6.2f ) = 0\n\n",  a[0], a[1], a[2], a[3]);

		AlgEquation.carda(a, x);
		for(i=0; i<3; i++)
			rs +=  String.format("           x = (% 18.12E ) + (% 18.12E )*i\n", x[i].x, x[i].y);
		rs +=  String.format("\n");
		return rs;
	}
}

/***
	static int carda(double[] a, Ccomplex[] x){
  		int i;
  		double b1,b2,b3,p,q,d,w,u3,v3,alfa,beta;
  		double theta = 1.57079632679,
  		pai = 3.1415926535897932;
  		if(a[0] == 0)
    		return(-1);
  		b1 = a[1] / a[0] / 3.0;
  		b2 = a[2] / a[0];
  		b3 = a[3] / a[0];
  		p = b2 / 3.0 - b1 * b1;
  		q = -(b1 * (2.0 * b1 * b1 - b2) + b3);
  		d = q * q + 4.0 * p * p * p;
  		w = Math.sqrt(Math.abs(d));
  		if(d<0){
    		if(q != 0.0)
      			theta = Math.atan(w / q);
    		w = 2.0 * Math.sqrt(-p);
    		x[0].x = w * Math.cos(theta / 3) - b1;
    		x[1].x = -(w * Math.cos((pai - theta) / 3.0)) - b1;
    		x[2].x = -(w * Math.cos((pai + theta) / 3.0)) - b1;
    		for(i=0; i<3; i++)
      		x[i].y = 0.0;
    		return(0);
  		}
  		u3 = 0.5 * (q + w);
  		v3 = 0.5 * (q - w);
  		alfa = cbrt(u3);
  		beta = cbrt(v3);
  		x[0].x = alfa + beta - b1;
  		x[0].y = 0.0;
  		w = -0.5 * (alfa + beta) - b1;
  		x[1].x = w;
  		x[2].x = w;
  		w = 0.8660253999999999 * (alfa - beta);
  		x[1].y = w;
  		x[2].y = -w;
  		return(0);
	}

	static double cbrt(double x){
  		double w1,y;
  
  		if (x == 0)
    		return(0.0);
  		w1 = (x<0?-1:1)*Math.pow(Math.abs(x),0.3333333333);
  		y = 0.5 * (w1 + 3 * x / (2 * w1 * w1 + x / w1));
  		return(y);
	}
********/

