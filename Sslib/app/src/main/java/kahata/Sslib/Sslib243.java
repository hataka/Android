// * -*- mode: Java -*-  Time-stamp: <08/02/19(火) 17:24:51 hata>
/*================================================================
 * プログラム名: sslib243.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib243.c,v 1.4 2008/02/19 17:24:51 k.hata Exp k.hata $
 * 説明: 
 *================================================================*/
/*
 *---------------------------------------------------------------------------
 * ★ 科学技術計算サブルーチンライブラリー
 *    p.74  2.4.3 高次代数方程式　ベアストウ法（ＢＡＩＲＳ）
 *
 *   機能        高次代数方程式
 *                   a1*x^n+a2*x^(n=1)+.....+an*x+a(n+1)=0 ;a1≠0
 *               を奇数次の時はnewton-raphson法で１実根を求め、
 *         残る根をbairstawで求める方法で、偶数次の時はbairstaw法で全ての根を求める
 *   呼出方法    call bairs(a() ,np1 ,eps, xr(), xi(), ier)
 *   引き数  入力
 *               a       :a(np1)なる実配列名で、方程式の係数を与える。
 *                        与え方は、
 *                        a(1)=a1,a(2)=a2, ....,af(np1)=a(n+1)でa(1)≠0とする。
 *               np1     :(方程式の次数)+1を整定数か整変数名で与える。np1≧3
 *               eps     :収束判定値を実定数か実変数名で与える。eps>0
 *           出力
 *               xr,xi   :xr(npi-1),xi(npi-1)なる実配列名で、根の実数部と
 *                        虚数部が得られる。
 *               ier     :整変数名で、エラーフラグである。
 *                       0   :  エラーなし
 *                       1,2 :収束しなくて、解が求められなかった
 *                           1はnewton-raphson法で、2はbairstaw法でのエラー
 *                       999 :a(1)=0か、np1<3か、eps≦0である
 *   スレーブサブルーチン:ＮＥＷＴＯＮ(2.4.2のサブルーチン)
 *
 *----------------------------------------------------------------------------
 */

package kahata.Sslib;
// インポート
import java.lang.String;
//import java.math.*;

//#define NP 5
//#define NP1 (NP+1)
//#define EPS  0.000000000000001
/*
class Ccomplex {
    double x=0,y=0;
    Ccomplex(double a,double b) {
	x = a;
	y = b;
    }
}
*/
class Sslib243 {
	public  String output() {
  
		int i,q;
		int np1=6;
		double  a[]={ 1.0,-10.0, 55.0,-140.0, 174.0, -100.0};
		double eps=0.0000000000000001;
		Ccomplex[] x = new Ccomplex[6];

		//AlgEquation p = new AlgEquation();

		// 文字列変数の宣言
		String rs;
		for(i=0; i< 6; i++)
			x[i] = new Ccomplex(0, 0);

		rs  =  String.format("\n");
		rs +=  String.format("%40s\n","★ 科学技術計算サブルーチンライブラリー（Java）");
		rs +=  String.format("              2.4.3 高次代数方程式　ベアストウ法（ＢＡＩＲＳ）\n\n");
		rs +=  String.format("           x^5 - 10*x^4 + 55*x^3 - 140*x^2 + 174*x -100 = 0\n");

//  		x =(struct ccomplex *)calloc((NP1-1),sizeof(struct ccomplex));
		q = AlgEquation.bairs(a, np1, eps, x);
		if(q!=0) return "";

		for(i=0; i<(np1-1); i++)
			rs +=  String.format("           x = (% 18.16f) + (% 18.16f)*i\n",x[i].x,x[i].y);

		rs +=  String.format("\n");
		rs +=  String.format("            ier = %3d\n\n", q);
		return rs;
	}
}
/***********************
	static int bairs(double[] a, int np1, double eps, Ccomplex[] x){
  		int i,ic,j,n,nn,k,nm;
  		double amax,w,p,q,bnm1,bnm2,cnm1,cnm2,cnm3,bk,ck,d,y;

		cnm3 =0.0; bk=0.0; 

  		if(a[0]==0 || np1<3 || eps<=0)
    		return(-1);
  		n = np1 - 1;
  		nm = np1;
  		if((n%2)!=0){
    		y = newton(a, np1, eps);
    		if(y==1.0 || y==-1.0) return(-1);
    		x[n-1].x = y;
    		x[n-1].y = 0.0;
    		w = 0.0;
    		for(i=0; i<n; i++){
      			w = w * y + a[i];
      			a[i] = w;
    		}
    		nm = n;
    		n--;
  		}
  		amax = Math.abs(a[0]);
  		for(i=1; i<nm; i++)
    		if(amax<Math.abs(a[i])) amax = Math.abs(a[i]);
  			i = n-1;
  			do {
    			p = 1.0;
    			q = 1.0;
    			for(ic=0; ic<50; ic++){
      				bnm1 = 0.0;
      				bnm2 = 0.0;
      				cnm1 = 0.0;
      				cnm2 = 0.0;
      				nn = i+2;
      				for(k=0; k<nn; k++){
						bk = a[k] - (p * bnm1 + q * bnm2);
						ck = bk - (p * cnm1 + q * cnm2);
						if(k==(nn-4)) cnm3 = ck;
							if(k!=nn-1){
	  							bnm2 = bnm1;
	  							bnm1 = bk;
	  							cnm2 = cnm1;
	  							cnm1 = ck;
							}
      					}
      					cnm1 = -(p * cnm2 + q * cnm3);
      					d = cnm2 * cnm2 - cnm1 * cnm3;
      					if(d==0.0){
							p = p + 1.0;
							q = q + 1.0;
      					}
      					else{
						p = p + (bnm1 * cnm2 - bk * cnm3) / d;
						q = q + (bk * cnm2 - bnm1 * cnm1) / d;
      				}
      				if((Math.abs(bnm1)+Math.abs(bk+p*bnm1))/amax<=eps) break;
    			}
    //      if(((abs(bnm1)+abs(bk+p*bnm1))/amax<=eps)) return(2);
      //  bs:
    		bnm1 = 0.0;
    		bnm2 = 0.0;
    		j = i;
    		for(k=0; k<j; k++){
      			bk = a[k] - (p * bnm1 + q * bnm2);
      			a[k] = bk;
      			bnm2 = bnm1;
      			bnm1 = bk;
    		}
    		a[i] = p;
    		a[i+1] = q;
    		i = i - 2;
    		if(i<3){
      			a[1] = a[1] / a[0];
      			a[2] = a[2] / a[0];
      			for(i=1; i<n; i+=2){
					d = a[i] * a[i] - 4.0 * a[i+1];
					w = Math.sqrt(Math.abs(d));
				if(d>=0){
	  				x[i-1].x = -0.5 * (a[i] - w);
	  				x[i-1].y = 0.0;
	  				x[i].x = -0.5 * (a[i] + w);
	  				x[i].y = 0.0;
				}
				else{
	  				x[i-1].x = -0.5 * a[i];
	  				x[i-1].y = 0.5 * w;
	  				x[i].x = x[i-1].x;
	  				x[i].y = -x[i-1].y;
				}
      		}
      		return(0);
    		}
  		} while(true);
	}

	static double newton(double[] a, int np1, double eps){
  		int i,n,m,nm1;
  		double a1,d,dx,p,q,r,w,x;

  //  int i,n,m,nm1;
  //  double a1,d,dx,p,q,r,w,x;
  
  n = np1 - 1;
  x = a[0];
  a1 = Math.abs(x);
  if(a[0]==0.0 || np1<3 || eps<= 0)
    return(-1);
  for(i=1; i<n; i++){
    w = a[i];
    x = x + w;
    if(a1<Math.abs(w))
      a1 = Math.abs(w);
  }
  x = -x / np1;
  for(i=0; i<50; i++){
    p = a[0];
    for(i=1; i<np1; i++)
      p = p * x + a[i];
    m = n;
    q = m * a[0];
    for(i=1; i<n; i++){
      m = m - 1;
      q = q * x + m * a[i];
    }
    if(q!=0){
      dx = -p / q;
      //      goto nwm;
    } else {
      m = n;
      nm1 = n - 1;
      r = m * nm1 * a[i];
      for(i=1; i<nm1; i++){
	m = m - 1;
	r = r * x + m * (m - 1) * a[i];
      }
      d = p * (p - 2 * r);
      if(d<=0){
	dx = -q / p;
	//	goto nwm;
      } else {
	w = Math.sqrt(d);
	if(q!=0){
	  dx = 2 * p / (-q + w);
	}
	else{
	  dx = 2 * p / (-q - w);
	}
      }
    }
    // nwm:;
    x = x + dx;
    if(Math.abs(dx)/a1<=eps)
      return(x);
  }
  return(1);

	}
*****************/
