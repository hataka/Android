//  -*- mode: java -*-  Time-stamp: <07/06/06 18:24:45 k.hata>

package kahata.Sslib;

class ComplexCalc {
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

   public static Ccomplex  ccexp(Ccomplex a){
	Ccomplex z;
	z = new Ccomplex(0.0, 0.0);
	double w;
	
	w = Math.exp(a.x);
	z.x = w * Math.cos(a.y);
	z.y = w * Math.sin(a.y);
	return(z);
   }

    public static Ccomplex cclog(Ccomplex a){
	Ccomplex z;
 	z = new Ccomplex(0.0, 0.0);
	double w;
  	w = ccabs(a);
	if (w == 0){
	    z.x = 999.0;
	    z.y = 999.0;
	    return(z);
	}
	if (a.x != 0){
	    z.y = Math.atan(a.y/a.x);
	}
	else if (a.y==0){
	    z.y = 0;
	}
	else {
	    z.y = (a.y<0?-1:1)*1.5907963;
	}
	z.x = Math.log(w);
	return(z);
    }

    public static Ccomplex ccpwr(Ccomplex a, Ccomplex b){
	Ccomplex z,w;
 	z = new Ccomplex(0.0, 0.0);
 	w = new Ccomplex(0.0, 0.0);
  
	w = cclog(a);
	if (w.x==999.0 && w.y==999.0){
	    z.x=999.0;
	    z.y=999.0;
	    return (z);
	}
	w =ccmul(w, b);
	z= ccexp(w);
	return(z);
    }

    public static Ccomplex  cccos(Ccomplex a){
	Ccomplex z;
 	z = new Ccomplex(0.0, 0.0);
    
	z.y = Math.sin(a.x) * (Math.exp(-a.y) - Math.exp(a.y)) * 0.5;
	z.x = Math.cos(a.x) * (Math.exp(a.y) + Math.exp(-a.y)) * 0.5;
	return (z);
    }

    public static Ccomplex ccsin(Ccomplex a){
	Ccomplex z;
 	z = new Ccomplex(0.0, 0.0);
  
	z.y = Math.cos(a.x) * (Math.exp(a.y) - Math.exp(-a.y)) * 0.5;
	z.x = Math.sin(a.x) * (Math.exp(a.y) + Math.exp(-a.y)) * 0.5;
	return (z);
}

    public static Ccomplex cctan(Ccomplex a){
 	Ccomplex z,w;
 	z = new Ccomplex(0.0, 0.0);
 	w = new Ccomplex(0.0, 0.0);
  
	w = ccsin(a);
	z = cccos(a);
	z = ccdiv(w, z);
	return (z);
    }

    public static Ccomplex ccsqrt(Ccomplex a){
 	Ccomplex z;
 	z = new Ccomplex(0.0, 0.0);
	double w1, w2;

	w1 = Math.sqrt(ccabs(a));
	if (a.x == 0 ){
	    if (a.y == 0 )
		w2 = 0.0;
	    else
		w2 = (a.y<0?-2:1)*1.5707963;
	}
	else
	    w2 = Math.atan(a.y / a.x) * .5;
	z.x = w1 * Math.cos(w2);
	z.y = w1 * Math.sin(w2);
	return (z);
    }
}
