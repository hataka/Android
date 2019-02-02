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
class AlgEquation {

	public static int carda(double[] a, Ccomplex[] x){
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

	public static double cbrt(double x){
  		double w1,y;
  
  		if (x == 0)
    		return(0.0);
  		w1 = (x<0?-1:1)*Math.pow(Math.abs(x),0.3333333333);
  		y = 0.5 * (w1 + 3 * x / (2 * w1 * w1 + x / w1));
  		return(y);
	}


	public static double newton(double[] a, int np1, double eps){
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

	public static int bairs(double[] a, int np1, double eps, Ccomplex[] x){
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

	public static double func(double x){
  		double f;
  		f = Math.exp(x) - 2.0;
  		return(f);
	}

	public static double regula(double xs,double xe, double h, double eps){
  		int ic;
  		double x,x0,y0,x1,y1,x2,y2;
  
  		if(xs>=xe || h<=0 || eps<=0)
    		return(-1);
  		x0 = xs;
  		x1 = xe;
  		y1 = func(x1);
  		do{
    		y0 = func(x0);
    		if(y0*y1<=0.0) break;
    		x0 = x0 + h;
    		if((x0-xe)>0.0)
      		return(1);
  		} while (true);
  		for(ic=0; ic<1000; ic++){
    		x2 = x0 - y0 * (x1 - x0) / (y1 - y0);
    		y2 = func(x2);
    		if(y0*y2>=0){
      			x0 = x2;
      			y0 = y2;
    		}
    		else{
      			x1 = x2;
      			y1 = y2;
    		}
    		if(Math.abs(y2)<=eps){
      			x = x2;
      			return(x);
    		}
  		}
		return 0;
	}


    public static Ccomplex ccadd(Ccomplex a, Ccomplex b){
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		z.x = a.x + b.x;
		z.y = a.y + b.y;
		return(z);
    }

   	public static Ccomplex ccsub(Ccomplex a, Ccomplex b){
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		z.x = a.x - b.x;
		z.y = a.y - b.y;
		return(z);
    }

    public static Ccomplex ccmul(Ccomplex a, Ccomplex b) {
		Ccomplex z;
		z = new Ccomplex(0.0, 0.0);
		z.y = a.x*b.y + b.x*a.y;
		z.x = a.x*b.x - a.y*b.y;
		return(z);
    }

    public static Ccomplex ccdiv(Ccomplex a, Ccomplex b){
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

    public static double ccabs(Ccomplex a){
		return Math.sqrt(a.x*a.x+a.y*a.y);
    }

	public static int cnwtn(Ccomplex[] a, int np1, double eps){
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

}
