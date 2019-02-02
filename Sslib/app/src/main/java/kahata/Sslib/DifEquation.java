//  -*- mode: java -*-  Time-stamp: <07/06/07 15:14:11 k.hata>
/*================================================================
 * プログラム名: AlgEquation.java
 * 作成日: Time-stamp: <08/02/15(金) 14:56:17 hata>
 * $Id: AlgEquation.java,v 1.1 2008/02/15 18:44:42 kahata Exp kahata $
 * Programmed By: 畑和彦
   To compile:
 * 説明: 代数方程式クラス　an algebraic equation
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
class DifEquation {

	public static interface Func {
		double func(double x, double y);
	}

	public static interface Func2 {
		int func(double x, double[] y, double[] dif);
	}

	public static interface Func3 {
		double func(double yd, double y, double x);
	}

	public static int rngkg(Func po, double x0, double y0, int n, double h, double[] y){
  		int i,l;
  		double ak,r,q,xx,yy;
  		double  cq[]={ 2.0, 1.0, 1.0, 2.0},
  				ckq[]={ 0.5, 0.29289322, 1.7071068, 0.1666666},
  				ck[]={ 0.5, 0.29289322, 1.7071068, 0.5},
  				ch[]={ 0.5, 0.0, 0.5, 0.0};
  
  		if(h<=0.0)
    		return(-1);
  		q = 0.0;
  		xx = x0;
  		yy = y0;
  		for(l=0; l<n; l++){
    		for(i=0; i<4; i++){
      			ak = h * po.func(xx, yy);
      			r = (ak - cq[i] * q) * ckq[i];
      			yy = yy + r;
      			q = q + 3.0 * r - ck[i] * ak;
      			xx = xx + h * ch[i];
      			if(i==3) y[l] = yy;
    		}
  		}
  		return 0;
	}

	public static int hamng(Func po, double x0, double y0, int n, double h, double[] y){
  		int i,ier;
  		double x=0.0,xp,yp,ym,yc,ypm,ycm,yim3,yi;
  		double[] f = new double[100];
  
  		ypm = 0.0;
  		ycm = 0.0;
  		yi  = 0.0;
  		yim3 = 0.0;

  		if(h<=0.0 || n>100)
    		return(-1);
  
  		ier = rngkg(po, x0, y0, n, h, y);
  		yim3 = yi;
  		f[0] = po.func(x0 + h, y[0]);
  		f[1] = po.func(x0 + 2.0 * h, y[1]);
  		for(i=2; i<n-1; i++){
    		x = x0 + (i+1) * h;
    		xp = x + h;
    		f[i] = po.func(x, y[i]);
    		if(i>2) yim3 = y[i-3];
    		yp = yim3 + h * (2.0 * (f[i] + f[i-2]) - f[i-1]) * 1.33333333;
    		ym = yp - (ypm - ycm) * 0.9256198;
    		yc =(9.0*y[i]-y[i-2]+3.0*h*(po.func(xp,ym)+2.0*f[i]-f[i-1]))*0.125;
    		y[i+1] = yc + (yp - yc) * 0.074380165;
    		ypm = yp;
    		ycm = yc;
  		}
  		x = x + h;
  		return(0);
	}


	static int rngkgm(Func2 po, double x, double[] y, double h, int multi, int n){
  		int i,l,m,s;
  		double ak,r;
  		double   cq[] = { 2.0, 1.0, 1.0, 2.0},
                 ckq[] = { 0.5, 0.29289322, 1.7071068, 0.16666666},
           	      ck[] = { 0.5, 0.29289322, 1.7071068, 0.5},
               	  ch[] = { 0.5, 0.0, 0.5, 0.0};

		double[] dif = new double[multi+10];
	    double[]   q = new double[multi+10];

  		if(h<=0.0)
    		return(-1);
  		for(i=0; i<multi; i++)
    		q[i] = 0.0;
  		for(l=0; l<n; l++){
    		for(i=0; i<4; i++){
      			s = po.func(x, y, dif);
      			for(m=0; m<multi; m++){
					ak = h * dif[m];
					r = (ak - cq[i] * q[m]) * ckq[i];
					y[m] = y[m] + r;
					q[m] = q[m] + 3.0 * r - ck[i] * ak;
      			}
      			x = x + ch[i];
    		}
  		}
	return 0;
	}

	public static int hdecdm(Func3 po0, Func3 po1, double xi, double a1, double a2, double h, int n, double[] r){
  		int i,j,p0,p1;
  		double x=0;
 		double y[] = {0.0};
		double yd[] = {0.0};
 		double[][]  u = new double[50][2];
		double  bld[]={ 0.0, 1.0},
                bl[]={ 1.0, 0.0};
  
  		if(n<1 || n>50 || h<0)
    		return(-1);
  		for(j=0; j<2; j++){
    		for(i=0; i<n; i++){
      			if(i==0){
					x = xi;
					yd[0] = bld[j];
					y[0] = bl[j];
      			}
      		p0 = rngktg1(po0, x, 1, h, yd, y);
      		p1 = rngktg1(po1, x, 2, h, yd, y);
      		u[i][j] = y[0];
      		if(i!=n-1)
				x = xi + h * (i+1);
    		}
  		}
  		if(u[n-1][1]!=0.0){
    		a2 = (a2 - a1 * u[n-1][0]) / u[n-1][1];
    		for(i=0; i<n; i++)
      			r[i] = a1 * u[i][0] + a2 * u[i][1];
    		return(0);
  		}
  		for(i=0; i<n; i++)
    		r[i] = a1 * u[i][0] + u[i][1];
  		if(a2==a1 * u[n-1][0])
    		return(0);
  		return(1);
	}

	public static int rngktg1(Func3 po, double x, int kind, double h, double[] yd, double[] y){
  		int i,j;
  		double h1,q,y1,ak,r;
  		double cq[]={ 2.0, 1.0, 1.0, 2.0},
  		ckq[]={ 0.5, 0.29289322, 1.7071068, 0.1666666},
  		ck[]={ 0.5, 0.29289322, 1.7071068, 0.5},
  		ch[]={ 0.5, 0.0, 0.5, 0.0};
  
  		h1 = h / 3.0;
  		q = 0.0;
  		y1 = yd[0];
  		if(kind==2)
    		y1 = y[0];
  			for(j=0; j<3; j++){
    			for(i=0; i<4; i++){
      				ak = h1 * po.func(yd[0], y[0], x);
      				r = (ak - cq[i] * q) * ckq[i];
      				y1 = y1 + r;
      				q = q + 3 * r - ck[i] * ak;
      				x = x + h1 * ch[i];
      				if(kind<2)
						yd[0] = y1;
      				else
						y[0] = y1;
    			}
  			}
  		return(0);
	}

}
