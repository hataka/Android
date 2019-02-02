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
class LsEquation {

	public static int gausei(double[][] a, int l, int m, int n, int nr, double eps, double[] x){
  		int i,j,inum;
  		double dif,sum,w,y,ay;
  
  		if(n<3 || nr<=0 ||eps<=0)
    		return(-1);
  		for(i=0; i<l; i++)
    		x[i] = 0.0;
  		inum = 1;
  		do{
    		dif = 0.0;
    		for(i= 0; i<l; i++){
      			sum = 0.0;
      			w = a[i][i];
      			for(j=0; j<m; j++){
					if(i!=j)
	  					sum = sum + a[i][j] * x[j];
      			}
      			y = (a[i][m] - sum) / w;
      			ay = Math.abs(y - x[i]);
      			if(ay>dif)
					dif = ay;
      			x[i] = y;
    		}
    		if(dif<=eps)
      			return(0);
    		if(inum>= nr)
      			return(1);
    		inum = inum + 1;
  		} while (true);
	}

	public static int gauss(double[][] a,int l,int m,int n,double eps){
  		int i,j,k,lr=0,iw;
  		double w,wmax,pivot,api,x;
  		int[] work = new int[80];
  
		if(m<2 || m>80 || m>=n || eps<=0)
			return(-1);
		for(i=0; i<m; i++)
			work[i] = i+1;
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
    		if(lr!=k){
      			iw = work[k];
      			work[k] = work[lr];
      			work[lr] = iw;
      			for(j=0; j<n; j++){
					w = a[k][j];
					a[k][j] = a[lr][j];
					a[lr][j] = w;
      			}
    		}
    		for(i=k; i<n; i++)
      			a[k][i] = a[k][i] / pivot;
    			if(k>m-2) {
//       goto gss;
// gss:;
      				for(k=m; k<n; k++){
        				for(i=0; i<m-1; i++){
          					x = 0.0;
          					for(j=m-i-1; j<m; j++){
	    						x = x + a[m-i-2][2*m-i-j-2] * a[2*m-i-j-2][k];
          					}
        					a[m-i-2][k] = a[m-i-2][k] - x;
       					}
     				}
       				return 0;
    			}
    
    			for(i=k+1; i<m; i++){
      				w = a[i][k];
      				if(w!=0){
						for(j=k+1; j<n; j++)
	  						a[i][j] = a[i][j] - w * a[k][j];
      				}
    			}
  			}
  
// gss:;
  			for(k=m; k<n; k++){
    			for(i=0; i<m-1; i++){
      				x = 0.0;
      				for(j=m-i-1; j<m; j++){
						x = x + a[m-i-2][2*m-i-j-2] * a[2*m-i-j-2][k];
      			}
      			a[m-i-2][k] = a[m-i-2][k] - x;
    		}
  		}
		return 0;
	}

	public static int gaujor(double[][] a, int l, int m, int n, double eps){
  		int i,ii,j,k,lc=0,lr=0,iw;
  		double wmax,w,pivot,api;
  		 int[] work = new int[80];

  		for(i=0; i<80; i++) work[i]= 0;

  		if(m<1 || m>79 || m>=n || eps<=0)
    		return(-1);
  		for(i=0; i<m; i++)
    		work[i] = i;
  		for(k=0; k<m; k++){
    		wmax = 0.0;
    		for(ii=k; ii<m; ii++){
      			for(i=k; i<m; i++){
					w = Math.abs(a[i][i]);
					if(w>=wmax){
	  					wmax = w;
	  					lc = i;
	  					lr = ii;
					}
      			}
    		}
    		pivot = a[lr][lc];
    		api = Math.abs(pivot);
    		if(api<=eps)
      			return(-1);
    		if(lc!=k){
      			iw = work[k];
      			work[k] = work[lc];
      			work[lc] = iw;
      			for(i=0; i<m; i++){
					w = a[i][k];
					a[i][k] = a[i][lc];
					a[i][lc] = w;
      			}
    		}
    		if(lr!=k){
      			for(j=k; j<n; j++){
					w = a[lr][j];
					a[lr][j] = a[k][j];
					a[k][j] = w;
      			}
    		}
    		for(i=k+1;i<n; i++)
      			a[k][i] = a[k][i] / pivot;
    		for(i=0; i<m; i++){
      			if(i!=k){
					w = a[i][k];
				for(j=k+1; j<n; j++)
	  				a[i][j] = a[i][j] - w * a[k][j];
      			}
    		}
  		}
  		for(i=0; i<m; i++){
    		do{
      			k = work[i];
      			if(k==i) break;
      				iw = work[k];
      				work[k] = work[i];
      				work[i] = iw;
      				for(j=m; j<n; j++){
						w = a[k][j];
					a[k][j] = a[i][j];
					a[i][j] = w;
      			}
    		} while(true);
  		}
  		return(0);
	}

	public static int ludcmp(double[][] a,int l,int m,int n,double eps,double[] x){
		int i,j,k,jm,im;
  		double w;
  		double[] y = new double[50];
  
  		if(l>=50 || eps<=0)
    		return(-1);
  		for(i=0; i<l-1; i++){
    		if(Math.abs(a[i][i])<=eps)
      			return(1);
    		for(j=i+1; j<l; j++){
      			w = a[j][i];
     			if(i!=0){
					for(k=0; k<i; k++)
	  					w = w - a[j][k] * a[k][i];
      			}
      			a[j][i] = w / a[i][i];
    		}
    		for(j=i+1; j<l; j++){
      			w = a[i+1][j];
      			for(jm=0; jm<i+1; jm++)
					w = w - a[i+1][jm] * a[jm][j];
      				a[i+1][j] = w;
    			}
  			}
  			y[0] = a[0][l];
  			for(i=1; i<l; i++){
    			w = a[i][l];
    			for(j=0; j<i; j++)
      				w = w - a[i][j] * y[j];
    			y[i] = w;
  			}
  			x[l-1] = y[l-1] / a[l-1][l-1];
  			for(im=2; im<=l; im++){
    			i = l - im;
    			w = y[i];
    			for(j=i+1; j<l; j++)
      				w = w - a[i][j] * x[j];
    			x[i] = w / a[i][i];
  			}
  		return(0);
		}

	public static int cgauj(double[][][]  a, int l, int m, int n, double eps){
  		int i,j,k,ii,lc=0,lr=0,iw;
  		int[]  work = new int[61];
  		double ww,wmax,pivot,w1,w2;
  		double[] w ={0.0,0.0};

		if(m<2 || m>60 || m>=n || eps<0.0)
    		return(-1);
  		for(i=0; i<m; i++)
    		work[i] = i;
  			for(k=0; k<m; k++){
    			wmax = 0.0;
    			for(ii=k; ii<m; ii++){
      				for(i=k; i<m; i++){
						ww = Math.pow(a[ii][i][0],2) + Math.pow(a[ii][i][1],2);
						if(ww>wmax){
	  						wmax = ww;
	  						lc = i;
	  						lr = ii;
						}
      				}
    			}

    			pivot = Math.pow(a[lr][lc][0],2) + Math.pow(a[lr][lc][1],2);
				if(pivot<=eps)
      				return(1);
    			if(k!=lc){
      				iw = work[k];
      				work[k] = work[lc];
      				work[lc] = iw;
      				for(i=0; i<m; i++){
						w[0] = a[i][k][0];
						w[1] = a[i][k][1];
						a[i][k][0] = a[i][lc][0];
						a[i][k][1] = a[i][lc][1];
						a[i][lc][0] = w[0];
						a[i][lc][1] = w[1];
      				}
    			}
    			if(k!=lr){
      				for(j=k; j<n; j++){
						w[0] = a[lr][j][0];
						w[1] = a[lr][j][1];
						a[lr][j][0] = a[k][j][0];
						a[lr][j][1] = a[k][j][1];
						a[k][j][0] = w[0];
						a[k][j][1] = w[1];
				    }
    			}
    			w[0] = a[k][k][0] / pivot;
    			w[1] = -a[k][k][1] / pivot;
    			for(i=k; i<n; i++){
      				ww = a[k][i][0] * w[0] - a[k][i][1] * w[1];
      				a[k][i][1] = a[k][i][0] * w[1] + a[k][i][1] * w[0];
      				a[k][i][0] = ww;
    			}
    			for(i=0; i<m; i++){
      				if(i!=k){
						w[0] = a[i][k][0];
						w[1] = a[i][k][1];
						for(j=k; j<n; j++){
	  						w1 = a[k][j][0] * w[0] - a[k][j][1] * w[1];
	  						w2 = a[k][j][0] * w[1] + a[k][j][1] * w[0];
	  						ww = a[i][j][0] - w1;
	  						a[i][j][1] = a[i][j][1] - w2;
	  						a[i][j][0] = ww;
						}
      				}
    			}
  			}
  			for(i=0; i<m-1; i++){
    			do{
      				k = work[i];
      				if(k==i) break;
      				iw = work[k];
      				work[k] = work[i];
      				work[i] = iw;
      				for(j=m; j<n; j++){
						w[0] = a[k][j][0];
						w[1] = a[k][j][1];
						a[k][j][0] = a[i][j][0];
						a[k][j][1] = a[i][j][1];
						a[i][j][0] = w[0];
						a[i][j][1] = w[1];
					}
    			} while (true);
  			}
  		return 0;
	}
}
