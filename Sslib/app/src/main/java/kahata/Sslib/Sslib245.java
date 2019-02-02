// * -*- mode: java -*-  Time-stamp: <08/02/19(火) 20:47:14 hata>
/*================================================================
 * プログラム名: Ssslib245.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: Sslib245.c,v 1.3 2008/02/19 20:47:14 k.hata Exp k.hata $
 * To compile:javac Sslib245.java
 * To run: JavaConsoleApplication
 * To run: java Sslib245
 * 説明: クラス Cccomplex の = による代入に問題あり
 *       a = b × => a.x = b.x; a.y = b.y; ○ (要素ごとに代入すること)
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.79  2.4.5 複素係数高次代数方程式　ニュートン法（ＣＮＷＴＮ）
 *
 *   機能        複素係数高次代数方程式
 *                (a1+b1･i)x^n+..........+(a[n+1]+b[n+1]･i) = 0, |a1+b1･i|≠0
 *               をnewton-raphson法で全ての根を求める。
 *   呼出方法    cnwtn(ar(), ai(), npi, eps, ier)
 *   引き数  入出力
 *               ar,ai   :ar(np1),ai(np1)なる実配列名で方程式の係数の実数部と
 *                        虚数部を与える
 *                        ar(1)=a1,ai(1)=b1,...,ar(np1)=a[n+1],ai(np1)=b[n+1]
 *                        ただし、ar(1)とai(1)は共に0であってはならない
 *           入力
 *               np1     :(方程式の次数)+1を整定数か整変数名で与える np1≧3
 *               eps     :収束判定値を実定数か実変数名で与える。eps>0
 *           出力
 *               ier     :整変数名で、エラーフラグである。
 *                       1～997: 収束せず、演算を途中で打ち切った
 *                               ier値はそれまでに求まった根の個数
 *                               根はar(i),ai(i)(i=np1-ier+1～np1)に得られる
 *                       998:    収束せず根は１個も求まらなかった
 *                       999:    ar(1),ai(1)が同時に0か、np1<3か、eps≦0
 *                               のいずれかである
 *   スレーブサブルーチン    :　 cdiv,cmul (2.1.2のサブルーチン)
 *                               cadd,csub (2.1.1のサブルーチン)
 *                               csabs      (2.1.5の関数サブルーチン)
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;
/*
class Ccomplex {
	double x=0,y=0;
	Ccomplex(double a,double b) {
		x = a;
		y = b;
	}
}
*/
class Sslib245 {
	public  String output() {
		int i,j,ier;
		int np1 = 4;
		double eps = 1e-16;
		Ccomplex x = new Ccomplex(0.0, 4.0),w = new Ccomplex(0.0, 4.0);

		Ccomplex[] a = new Ccomplex[4];
		Ccomplex[] b = new Ccomplex[4];
		Ccomplex[] c = new Ccomplex[4];
		Ccomplex[] e = new Ccomplex[4];

		a[0] = new Ccomplex(4.0, 4.0);
		a[1] = new Ccomplex(3.0, 3.0);
		a[2] = new Ccomplex(2.0, 2.0);
		a[3] = new Ccomplex(1.0, 1.0);

		for( i= 0; i<4; i++){
			b[i] = new Ccomplex(0.0, 0.0);
			c[i] = new Ccomplex(0.0, 0.0);
			e[i] = new Ccomplex(0.0, 0.0);
		}

		//AlgEquation p = new AlgEquation();

		// 文字列変数の宣言
		String rs;

		rs  =  String.format("\n%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("           2.4.5 複素係数高次代数方程式　ニュートン法（ＣＮＷＴＮ）\n\n");
		rs +=  String.format("               (4+4*i)*x^3 +(3+3*i)*x^2 +(2+2*i)*x +(1+1*i) = 0\n");
		for(i=0; i<np1; i++){
			c[i].x = a[i].x;
			c[i].y = a[i].y;
		}

		ier = AlgEquation.cnwtn(a, np1, eps);
		for(i=0; i<np1-1; i++){
			x.x = a[i].x;
			x.y = a[i].y;
			w.x = c[0].x;
			w.y = c[0].y;
			for(j=1; j<np1; j++){
				w = AlgEquation.ccmul(w, x);
				w = AlgEquation.ccadd(w, c[j]);
			}
			e[i].x = w.x;
			e[i].y = w.y;
		}

		rs  +=  String.format( "             solution\n");
		for(i=0; i<np1-1; i++)
			rs +=  String.format("%18s(%d) =  (% 14.6E) + (% 14.6E)*i\n","x",i+1,a[i].x,a[i].y);
		rs +=  String.format("\n");
		rs +=  String.format("             error\n");
		for(i=0; i<np1-1; i++)
			rs +=  String.format("%18s(%d) =  (% 14.6E) + (% 14.6E)*i\n","e",i+1,e[i].x,e[i].y);
		rs +=  String.format("\n");
		rs +=  String.format("             ier = %3d\n\n", ier);
		return rs;
	}
}
/********************
    static Ccomplex ccadd(Ccomplex a, Ccomplex b){
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		z.x = a.x + b.x;
		z.y = a.y + b.y;
		return(z);
    }

   	static Ccomplex ccsub(Ccomplex a, Ccomplex b){
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		z.x = a.x - b.x;
		z.y = a.y - b.y;
		return(z);
    }

    static Ccomplex ccmul(Ccomplex a, Ccomplex b) {
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		z.y = a.x*b.y + b.x*a.y;
		z.x = a.x*b.x - a.y*b.y;
		return(z);
    }

    static Ccomplex ccdiv(Ccomplex a, Ccomplex b){
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		if (ccabs(b) == 0.0){
	    	z.x = 999.0;
	    	z.y = 999.0;
	    	return(z);
		}
		z.y = (b.x*a.y-a.x*b.y)/(b.x*b.x+b.y*b.y);
		z.x = (a.x*b.x+a.y*b.y)/(b.x*b.x+b.y*b.y);;
		return(z);
   }

    static double ccabs(Ccomplex a){
		return Math.sqrt(a.x*a.x+a.y*a.y);
    }

	static int cnwtn(Ccomplex[] a, int np1, double eps){
  		int i,ii,ic,n,ier=0;
  		double am,amax;
  		Ccomplex p,q,w,x;
        p = new Ccomplex(0.0,0.0);
		q = new Ccomplex(0.0,0.0);
		w = new Ccomplex(0.0,0.0);
		x = new Ccomplex(0.0,0.0);


		if((a[0].x==0.0 && a[0].y==0.0) || np1<3 || eps<=0){
    		ier = 999;
    		return(ier);
  		}
  		ii = np1;
  		n = np1 - 1;

  		w.x = a[0].x;
  		w.y = a[0].y;


  		for(i=0; i<np1; i++)
    		a[i] = ccdiv(a[i], w);

//ctn2:;
		do {
  			amax = ccabs(a[0]);
  			for(i=1; i<ii; i++){
    			w.x = ccabs(a[i]);
    			if(amax<w.x)
      				amax = w.x;
  			}
  			x.x =  0.0;
  			x.y = -1.0;
  			for(ic=0; ic<50; ic++){

    			p.x = a[0].x;
    			p.y = a[0].y;


    			for(i=1; i<ii; i++){
      				w = ccmul(p, x);
      				p = ccadd(w , a[i]);
    			}
    			am = (double)n;
    			q.x = am * a[0].x;
    			q.y = am * a[0].y;
    			for(i=1; i<n; i++){
      				am = am - 1.0;
      				w = ccmul(q, x);
      				q.x = w.x + am * a[i].x;
      				q.y = w.y + am * a[i].y;
    			}
    			w = ccdiv(p, q);
    			x = ccsub(x, w);
    			if((ccabs(w)/amax)<=eps) break;
  			}
//  if(ii==np1){
//    ier=998;
//    return(ier);
//  }

  			a[ii-1].x= x.x;
  			a[ii-1].y= x.y;

  			ii = ii - 1;
  			n = n - 1;
  			ier = ier+1;
  			w.x = 0.0;
  			w.y = 0.0;
  			for(i=0; i<ii; i++){
    			w = ccmul(w, x);
    			w = ccadd(w, a[i]);
    			a[i].x = w.x;
    			a[i].y = w.y;
			}
		} while (ii>2);

//  if(ii>2) goto ctn2;


	  	w= ccdiv(a[1], a[0]);
  		a[ii-1].x = -w.x;
  		a[ii-1].y = -w.y;
  	
		for(i=1; i<np1; i++){

    		a[i-1].x = a[i].x;
    		a[i-1].y = a[i].y;
		}
  		ier = 0;
  		return(ier);
	}
****************/
