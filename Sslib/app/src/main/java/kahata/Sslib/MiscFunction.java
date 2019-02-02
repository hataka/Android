//  -*- mode: java -*-  Time-stamp: <07/06/07 15:14:11 k.hata>
/*================================================================
 * プログラム名: MathFunction.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: MathFunction.java,v 1.1 2007/06/06 18:44:42 k.hata Exp k.hata $
 * Programmed By: 畑和彦
   To compile:
   To run:        cint -03 で実行のこと
 * 説明: 数学関数クラス
 *================================================================*/

package kahata.Sslib;
// インポート
//import java.lang.String;
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
class MiscFunction {

	public static void normal(double av, double st, double[] rnx, double[] rny){
  		double r1,r2;
  
  		r1 = irand()/32767.1;
  		r2 = irand()/32767.1;
  		rnx[0] = st * Math.sqrt(-2 * Math.log(r1)) * Math.cos(2 * 3.141592653 * r2) + av;
  		rny[0] = st * Math.sqrt(-2 * Math.log(r1)) * Math.sin(2 * 3.141592653 * r2) + av;
  
	}

	static int rndnum=13;
	public static int irand() {
		rndnum=(rndnum*109 +1021) % 32768;
		return rndnum;
	}

	static int poison(double rav, double[] irn){
  		double c,x,rn;
  
  		if(rav>=10)
    		return(-1);
  		c = Math.exp(-rav);
  		x = 1.0;
  		irn[0] = -1;
  		do{
    		if(x<=c)
      			return(0);
    		rn = irand()/32767.1;
    		x = x * rn;
    		irn[0] += 1;
  		} while(true);
	}


	static int bino(int m, int n, double[] bc){
  		double w1,w2;
		double[] a = new double[3];
  		int i,j,l;
		int[] k = new int[3];
  
  		if(m<=n || n<0)
    		return(-1);
  		k[0] = m;
  		k[1] = n;
  		k[2] = m - n;
  		for(i=0; i<3; i++){
    		w1 = 0.0;
    		l = k[i];
    		for(j=2; j<=l; j++){
      			w2 = l + 2.0 - j;
      			w1 = w1 + Math.log(w2);
    		}
    		a[i] = w1;
  		}
  		w2 = a[0] - a[1] - a[2];
  		bc[0] = Math.exp(w2);
	return 0;
  	}
}
