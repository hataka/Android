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

class MatrixCalc {

	public static int madd(double[][] a, double[][] b, double[][] c, int l, int m, int n){
    	int i,j;
    
    	if(m<1 || n<1)
      		return(-1);
   		for(i=0; i<m; i++){
   			for(j=0; j<n; j++)
				c[i][j] = a[i][j] + b[i][j];
   		}
    	return(0);
  	}

	static int msub(double[][] a, double[][] b, double[][] c, int l, int m, int n){
  		int i,j;
  
  		if(m<1 || n<1)
    		return(-1);
  		for(i=0; i<m; i++){
    		for(j=0; j<n; j++)
				c[i][j] = a[i][j] - b[i][j];
  		}
  	return(0);
	}

	public static int mmul1(double[][] a,double[][] b,double[][] c,int l,int m,int n,int k){
		int i,j,jj;
  		double x;
  
  		if(m<1 || n<1|| k<1)
    		return(-1);
  		for(i=0; i<m; i++){
    		for(j=0; j<k; j++){
      		x = 0.0;
      		for(jj=0; jj<n; jj++)
				x = x + a[i][jj] * b[jj][j];
      			c[i][j] = x;
    		}
  		}
  		return(0);
	}

	public static int mmul2(double[][] a,double[][] b,int l,int m){
  		int i,j,k;
    	double x;
  		double[] w = new double[60];
  
  		if(m<2 || m>60)
    		return(-1);
  		for(i=0; i<m; i++){
    		for(j=0; j<m; j++){
      		x = 0.0;
      		for(k=0; k<m; k++)
				x = x + a[j][k] * b[k][i];
      			w[j] = x;
    		}
    		for(k=0; k<m; k++)
      			b[k][i] = w[k];
  		}
  		return(0);
	}

	public static int mtra1(double[][] a, double[][] b, int l, int m, int n){
   		int i,j;
    	if(m<1 || n<1)
        	return(-1);
    	for(i=0; i<m; i++){
        	for(j=0; j<n; j++)
	  		b[j][i] = a[i][j];
    	}
    	return(0);
	}

	public static int mtra2(double[][] a, int l, int m){
  		int i,j;
  		double w;
    
  		if(m<2)
    		return(-1);
  		for(i=0; i<m-1; i++){
    		for(j =i; j<m; j++){
      			w = a[i][j];
      			a[i][j] = a[j][i];
      			a[j][i] = w;
    		}
  		}
  		return(0);
	}

	public static int minver(double[][] a, int l, int m, double eps, double[] det){
  		int i,j,k,lr=0,iw=0;
  		double api,pivot,w,wmax;
  		int[] work = new int[80];

  		if(m<2 || m > 80 || eps <= 0.0)
    		return(0);
  		det[0] = 1.0;
  		for(i=0; i<m; i++)
    		work[i] = i;
  		for(k=0; k<m; k++){
    		wmax = 0.0;
    		for(i=k; i<m; i++){
      			w = Math.abs(a[i][k]);
      			if(w>=wmax){
					wmax = w;
					lr = i;
      			}
        	}
    		pivot = a[lr][k];
    		api = Math.abs(pivot);
    		if(api<=eps)
      			return(1);
    		det[0] = det[0] * pivot;
    		if(lr!=k){
      			det[0] = -det[0];
      			iw = work[k];
      			work[k] = work[lr];
      			work[lr] = iw;
      			for(j=0; j<m; j++){
					w = a[k][j];
					a[k][j] = a[lr][j];
					a[lr][j] = w;
      			}
    		}
    		for(i=0; i<m; i++)
      			a[k][i] = a[k][i] / pivot;
    			for(i=0; i<m; i++){
      				if(i!=k){
						w = a[i][k];
						if(w!=0.0){
	  						for(j=0; j<m; j++){
	    						if(j!=k)
	      						a[i][j] = a[i][j] - w * a[k][j];
	  						}
	  					a[i][k] = -w / pivot;
					}
      			}
    		}
    		a[k][k] = 1.0 / pivot;
  		}
  		for(i=0; i<m; i++){
    		do{
      			k = work[i];
      			if(k==i) break;
      			iw = work[k];
      			work[k] = work[i];
      			work[i] = iw;
      			for(j=0; j<m; j++){
					w = a[j][i];
					a[j][i] = a[j][k];
					a[j][k] = w;
      			}
    		} while (true);
  		}
 		 return(0);
	}


	public static int jacobi(double[][] a, double[][] v,int l,int m,int[] nr,double eps){
  		int i,j,n,k=0,ll=0;
  		double a1,a2,a3,c0,si,t1,t2,t3,t4,ta,w,wmax;
  
  		if(m<2 || nr[0]<=0 || eps<=0){
    		nr[0] = 0;
    		return(-1);
  		}
  		n = 0;
  		for(i=0; i<m-1; i++){
    		for(j=i+1; j<m; j++){
      	 		if(a[i][j]!=a[j][i]){
					nr[0] = 0;
					return(-1);
      			}
    		}
  		}
  		for(i=0; i<m; i++){
    		for(j=0; j<m; j++)
	 			v[i][j] = 0.0;
	 		v[i][i] = 1.0;
  		}

		do {
    		wmax = 0.0;
    		for(i=0; i<m-1; i++){
      			for(j=i+1; j<m; j++){
	   				w = Math.abs(a[i][j]);
					if(w>wmax){
	  					wmax = w;
	  					k = i;
	  					ll = j;
					}
      			}
    		}
    		if(wmax<=eps){
      			nr[0] = n;
      			return(0);
    		}
    		if(n>=nr[0]){
      			nr[0] = n;
      			return(1);
    		}
    		n++;
       		a1 = a[k][k];
       		a2 = a[ll][ll];
       		a3 = a[k][ll];
    
    		t1 = Math.abs(a1 - a2);
    		t2 = t1 * t1;
    		t3 = 4.0 * a3 * a3;
    		ta = 2.0 * a3 / (t1 + Math.sqrt(t2 + t3));
    		if(a1<a2) ta = -ta;
    		t4 = ta * ta + 1.0;
    		c0 = Math.sqrt(1.0 / t4);
    		si = ta * c0;
    		for(i=0; i<m; i++){
	 			w = v[i][k];
	 			v[i][k] = w * c0 + v[i][ll] * si;
	 			v[i][ll] = -w * si + v[i][ll] * c0;
    		}
    		for(i=0; i<m; i++){
      			if(i!=k || i+1!=ll){
	   				w = a[i][k];
	   				a[i][k] = w * c0 + a[i][ll] * si;
	   				a[i][ll] = -w * si + a[i][ll] * c0;
	   				a[k][i] = a[i][k];
	   				a[ll][i] = a[i][ll];
      			}
    		}
       		a[k][k] = a1 * c0 * c0 + a3 * (c0 + c0) * si + a2 * si * si;
       		a[ll][ll] = a1 + a2 - a[k][k];
       		a[k][ll] = 0.0;
       		a[ll][k] = 0.0;
		  } while (true);
	}
}
