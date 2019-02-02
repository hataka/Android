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
class Aproximation {
	public static int lstsq(double[] x, double[] y, int n, int mp1, double[] c){
  		int i,j,k,l,m,mp2,m2;
  		double w1,w2,w3,pivot,aik;
  		double[][]  a = new double[12][13];
		double[] w = new double[23];
  
  		if(mp1>n || mp1<2 || mp1>11)
    		return(-1);
  		m = mp1 - 1;
  		mp2 = mp1 + 1;
  		m2 = 2 * m;
  		for(i=0; i<m2; i++){
    		w1 = 0.0;
    		for(j=0; j<n; j++){
      			w2 = x[j];
      			w1 = w1 + Math.pow(w2, i+1);
    		}
    		w[i] = w1;
  		}
  		for(i=0; i<mp1; i++){
    		for(j=0; j<mp1; j++){
      			l = i + j;
      			if (l == 0) a[i][j] = w[0];
      			else a[i][j] = w[l-1];

    		}
  		}
  		a[0][0] = n;
  		w1 = 0.0;
  		for(i=0; i<n; i++)
    		w1 = w1 + y[i];
  		a[0][mp2-1] = w1;
  		for(i=0; i<m; i++){
    	w1 = 0.0;
    	for(j=0; j<n; j++){
      		w2 = y[j];
      		w3 = x[j];
      		w1 = w1 + w2 * Math.pow(w3, i+1);
    	}
    	a[i+1][mp2-1] = w1;
  	}
  	for(k=0; k<mp1; k++){
    	pivot = a[k][k];
    	for(j=k; j<mp2; j++)
      		a[k][j] = a[k][j] / pivot;
    		for(i=0; i<mp1; i++){
      			if(i!=k){
				aik = a[i][k];
				for(j=k; j<mp2; j++)
	  				a[i][j] = a[i][j] - aik * a[k][j];
      			}
    		}
  		}
  		for(i=0; i<mp1; i++)
    		c[i] = a[i][mp2-1];
  	return(0);
	}


	public static double lagra(double[] x, double[] y, int n, double xi){
  		int i,j;
  		double w1,w2,w3,yi;
  
  		if(n<2 || xi<x[0] || xi>x[n-1])
    		return(-1);
  		yi = 0.0;
  		for(i=0; i<n; i++){
    		w1 = 1.0;
    		w2 = x[i];
    		for(j=0; j<n; j++){
      		w3 = x[j];
      		if(i!=j)
				w1 = w1 * ((xi - w3) / (w2 - w3));
    		}
    		yi = yi + w1 * y[i];
    	}
  		return(yi);
	}

	public static double splint(double[] x, double[] y, int n, double xx){
  		int i,nm1,ier;
  		double sm,si,hi,hi2,dxp,dxm,yy;
  		double[] h = new double[50], sp = new double[50];
  
  		if(n<3 || n>50)
    		return(-1);
  		nm1 = n - 1;
  		for(i=0; i<nm1; i++){
    		if((x[i+1]-x[i])<=0)
      		return(-1);
  		}
  		ier = subspl(x, y, n, nm1, h, sp);
  		for(i=1; i<n; i++){
    		if(x[i-1]>xx && xx<=x[i]){
      			i = i - 1;
      			sm = sp[i-1];
      			si = sp[i];
      			hi = h[i];
      			hi2 = hi * hi;
      			dxp = x[i] - xx;
      			dxm = xx - x[i-1];
      			yy = ((sm * Math.pow(dxp,3) + si * Math.pow(dxm,3)) + (6.0 * y[i-1] - hi2 * sm) * dxp + (6.0 * y[i] - hi2 * si) * dxm) / hi / 6.0;
      			return(yy);
    		}
  		}
    	return(-1);
	}

	public static int subspl(double[] x, double[] y, int n, int nm1, double[] h, double[] sp){
  		int i,j,m;
  		double hip1,hid,g;
  		double[] d1 = new double[51], d2 = new double[51], d3 = new double[51];
  		for(i=2; i<=nm1; i++){
    		h[i]= x[i] - x[i-1];
    		hip1 = x[i+1] - x[i];
    		sp[i] = 6 * ((y[i+1] - y[i])/(h[i]*hip1)-(y[i] - y[i-1])/(h[i]*h[i]));
  		}
  		h[n] = x[n] - x[nm1];
  		for(i=2; i<=nm1; i++){
    		hid = h[i+1]/h[i];
    		d1[i] = 1;
    		d2[i] = 2 * (1 + hid);
    		d3[i] = hid;
  		}
  		d2[2] = d2[2] + 1;
  		d2[nm1] = d2[nm1] + h[n] / h[nm1];
  		d3[2] = d3[2] / d2[2];
  		sp[2] = sp[2] / d2[2];
  		for(i=3; i<=nm1; i++){
    		g = d2[i] - d3[i-1] * d1[i];
    		d3[i] = d3[i] / g;
    		sp[i] = (sp[i] - sp[i-1] * d1[i]) / g;
  		}
  		for(j=3; j<=nm1; j++){
    		m = n + 1 - j;
    		sp[m] = sp[m] - sp[m+1] * d3[m];
  		}
  		sp[1] = sp[2];
  		sp[n] = sp[nm1];
  		return(0);
	}
}
