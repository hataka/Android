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

// インポート
//import java.lang.String;
//import java.math.*;

package kahata.Sslib;
/*
class Ccomplex {
    double x,y;
    Ccomplex(double a,double b) {
	x = a;
	y = b;
    }
}
*/
class Fft {
	public static int fft(Ccomplex[] a, int n, int flag){
  		int i,j,j1,j2,it,iter,k,xp,xp2;
  		double aa,s,w;
  		Ccomplex ww=new Ccomplex(0.0,0.0),d1=new Ccomplex(0.0,0.0),
		d2=new Ccomplex(0.0,0.0),t=new Ccomplex(0.0,0.0);
    
  		if(n<2)
    		return(-1);
  			iter = 0;
  			i = n;
  			while (true){
    			i = i / 2;
    			if(i==0)
      				break;
    			iter++;
  			}
  			if(n!=(int)Math.pow(2,iter))
    			return(1);
  			s = -1.0;
  			if(flag==1)
    			s = 1.0;
  			xp2 = n;
  			for(it=1; it<=iter; it++){
    			xp = xp2;
    			xp2 = xp / 2;
    			w = 3.14159265358 / xp2;
    			for(k=1; k<=xp2; k++){
      				aa = (k - 1) * w;
      				ww.x = Math.cos(aa);
      				ww.y = s * Math.sin(aa);
      				i = k - xp;
      				for(j=xp; j<=n; j+=xp){
						j1 = j + i;
						j2 = j1 + xp2;

						d1.x = a[j1-1].x;
						d1.y = a[j1-1].y;
	
						d2.x = a[j2-1].x;
						d2.y = a[j2-1].y;


						t  = ccsub(d1,d2);
						a[j1-1].x = ccadd(d1,d2).x;
						a[j1-1].y = ccadd(d1,d2).y;
						a[j2-1].x = ccmul(t,ww).x;
						a[j2-1].y = ccmul(t,ww).y;
      				}
    			}
  			}
  			j1 = n / 2;
  			j2 = n - 1;
  			j = 1;
  			for(i=1; i<=j2; i++){
    			if((i-j)<0){
      				t.x = a[j-1].x;
      				t.y = a[j-1].y;
				    a[j-1].x = a[i-1].x;
      				a[j-1].y = a[i-1].y;
      				a[i-1].x = t.x;
      				a[i-1].y = t.y;
    		}
    		k = j1;
    		do{
      			if((k-j)>=0) break;
      			j = j - k;
      			k = k / 2;
    		} while (true);
    		j = j + k;
  		}
  		if(flag==0) 
    	return(0);
  		w = n;
  		for(i=1; i<=n; i++){
    		a[i-1].x = a[i-1].x / w;
    		a[i-1].y = a[i-1].y / w;
  		}
  		return(0);
	}

	public static Ccomplex ccadd(Ccomplex a, Ccomplex b){
  		Ccomplex z = new Ccomplex(0.0,0.0);
  
  		z.x = a.x + b.x;
  		z.y = a.y + b.y;
  		return(z);
	}

	public static Ccomplex ccsub(Ccomplex a, Ccomplex b){
  		Ccomplex z = new Ccomplex(0.0,0.0);
  
  		z.x = a.x - b.x;
  		z.y = a.y - b.y;
  		return(z);
	}

	public static Ccomplex ccdiv(Ccomplex a, Ccomplex b){
  		Ccomplex z = new Ccomplex(0.0,0.0);
  
  		if (ccabs(b) == 0.0){
    		z.x = 999.0;
    		z.y = 999.0;
    		return(z);
  		}
  		z.y = (b.x*a.y-a.x*b.y)/(b.x*b.x+b.y*b.y);
  		z.x = (a.x*b.x+a.y*b.y)/(b.x*b.x+b.y*b.y);;
  		return(z);
	}

	public static Ccomplex ccmul(Ccomplex a, Ccomplex b){
  		Ccomplex z = new Ccomplex(0.0,0.0);
  
  		z.y = a.x*b.y + b.x*a.y;
  		z.x = a.x*b.x - a.y*b.y;
  		return(z);
	}

	public static double ccabs(Ccomplex a){
  		return Math.sqrt(a.x*a.x+a.y*a.y);
	}
}
