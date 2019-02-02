//  -*- mode: java -*-  Time-stamp: <2012-02-02 9:31:26 kahata>
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


class MathFunction {
    public static double cbrt(double x){
	double w1, y;
	if (x == 0)
	    return (0.0);
	w1 = (x < 0 ? -1 : 1) * Math.pow(Math.abs(x), 0.3333333333);
	y = .5 * (w1 + 3 * x / (2 * w1 * w1 + x / w1));
	return (y);
    }

    public static double besj0(double x){
	int i, j;
	double bj0, w, wx, wx4, wp, wq;
	double a[] = {0, 1.00, -3.9999998721, 3.9999973021, -1.7777560599,
			     0.4443584263, -0.0709253492, 0.0076771853},
	              c[] = {0, 0.3989422793, -0.001753062, 0.00017343,
			     -0.00004877613, 0.0000173565},
		      k[] = {0, -.0124669441, 0.0004564324, -0.0000869791,
			     0.0000342468, -0.0000142078};
       if (x < 0)
	   return (999.0);
       wx = x;
       if (x <= 4) {
	   w = -.0005014415;
	   wx4 = (wx / 4.0) * (wx / 4.0);
	   for (i = 1; i <= 7; i++) {
	       j = 8 - i;
	       w = w * wx4 + a[j];
	   }
	   bj0 = w;
	   return (bj0);
       }
       wx4 = (4.0 / wx) * (4.0 / wx);
       wp = -.0000037043;
       wq = .0000032312;
       for (i = 1; i <= 5; i++) {
	   j = 6 - i;
	   wp = wp * wx4 + c[j];
	   wq = wq * wx4 + k[j];
       }
       w = wx - 0.7853981633974483;
       wp = wp * Math.cos(w);
       wq = wq * Math.sin(w);
       w = 2 / Math.sqrt(wx);
       bj0 = w * (wp - 4 * wq / wx);
       return (bj0);
    }

    public static double besj1(double x){
	int i, j;
	double bj1, w, wx, wx4, wp, wq;
	double a[] = {0.0, 1.9999999998, -3.999999971, 2.6666660544,
			     -0.8888839649, 0.1777582922, -0.0236616773,
			     0.0022069155},
	              c[] = {0.0, 0.3989422819, 0.0029218256, -0.000223203,
			     0.0000580759, -0.000020092},
		      k[] = {0.0, 0.0374008364, -0.00063904, 0.0001064741,
			     -0.0000398708, 0.00001622};
	if (x < 0)
	    return (999);
	wx = x;
	if (x <= 4.0) {
	    w = -0.0001289769;
	    wx4 = (wx / 4.0) * (wx / 4.0);
	    for (i = 1; i <= 7; i++) {
		j = 8 - i;
		w = w * wx4 + a[j];
	    }
	    bj1 = w * wx / 4.0;
	    return (bj1);
	}
	wx4 = (4.0 / wx) * (4.0 / wx);
	wp = 0.000004214;
	wq = -0.0000036594;
	for (i = 1; i <= 5; i++) {
	    j = 6 - i;
	    wp = wp * wx4 + c[j];
	    wq = wq * wx4 + k[j];
	}
	w = wx - 2.356194490192345;
	wp = wp * Math.cos(w);
	wq = wq * Math.sin(w);
	w = 2.0 / Math.sqrt(wx);
	bj1 = w * (wp - 4.0 * wq / wx);
	return (bj1);
}

    public static double besy0(double x){
	int i,j;
	double w,wx,by0,bj0,wx3,wf,wp;
	double a[]={0.0, 0.36746691, 0.60559366, -0.74350384,
		    0.25300117, -0.04261214, 0.00427916},
	       b[]={0.0, 1.0, -2.2499997, 1.2656208, -0.3163866,
		    0.0444479, -0.0039444},
	       c[]={0.0, 0.79788456, -0.00000077, -0.0055274,
		    -0.00009512, 0.00137237,  -7.2805e-04},
	       k[]={0.0,  0.78539816, 0.04166397, 0.00003954,
		    -0.00262573, 0.00054125, 0.00029333};
  
        if(x<=0)
	    return(999);
	wx = x;
	if(x<= 3.0){
	    w = -0.00024846;
	    bj0 = 0.00021;
	    wx3 = (wx/3.0)*(wx/3.0);
	    for(i=1; i<=6; i++){
		j = 7 - i;
		w = w * wx3 + a[j];
		bj0 = bj0 * wx3 + b[j];
	    }
	    by0 = w + 0.636619772367581*Math.log(wx/2.0)*bj0;
	    return(by0);
	}
	wx3 = 3.0 / wx;
	wf = 0.00014476;
	wp = -0.00013558;
	for(i=1; i<=6; i++){
	j = 7 - i;
	wf = wf * wx3 + c[j];
	wp = wp * wx3 + k[j];
	}
	w = wx - wp;
	by0 = wf * Math.sin(w) / Math.sqrt(wx);
	return(by0);
    }

    public static double besy1(double x){
	int i,j;
	double w,wx,wx3,by1,bj1,wf,wp;
	double a[]={0.0, -0.6366198, 0.2212091, 2.1682709, -1.3164827,
		    0.3123951, -0.0400976},
	       b[]={0.0, 0.5, -0.56249985, 0.21093573, -0.03954289,
		    0.00443319, -0.00031761},
	       c[]={0.0, 0.79788456, 0.00000156, 0.01659667, 0.00017105,
		    -0.00249511, 0.00113653},
	       k[]={0.0, 0.78539816, -0.12499612, -0.0000565, 0.00637879,
		    -0.00074348, -0.00079824};
  
       if(x<= 0.0)
	   return(999);
       wx = x;
       if(x <= 3.0){
	   wx3 = (wx / 3.0) * (wx / 3.0);
	   w = 0.0027873;
	   bj1 = 0.00001109;
	   for(i = 1; i<= 6; i++){
	       j = 7 - i;
	       w = w * wx3 + a[j];
	       bj1 = bj1 * wx3 + b[j];
	   }
	   w = w / wx;
	   bj1 = bj1 * wx;
	   by1 = w + 0.636619772367581 * Math.log(wx / 2.0) * bj1;
	   return(by1);
       }
       wx3 = 3.0 / wx;
       wf = -0.00020033;
       wp = 0.00029166;
       for(i = 1; i<= 6; i++){
	   j = 7 - i;
	   wf = wf * wx3 + c[j];
	   wp = wp * wx3 + k[j];
       }
       w = wx - wp;
       by1 = -wf * Math.cos(w) / Math.sqrt(wx);
       return(by1);
    }

    public static double besi0(double x){
	int i,j;
	double bi0,w,wx,wx375;
	double a[]={0.0, 1.0, 3.5156229, 3.0899424, 1.2067492,
		    0.2659732, 0.0360768},
	       b[]={0.0, 0.39894228, 0.013285917, 0.002253187,
		    -0.001575649, 0.009162808, -0.020577063,
		    0.026355372, -0.016476329};
  
        if(x<0.0)
	    return(999);
	wx = x;
	if(x > 3.75){
	    wx375 = 3.75 / wx;
	    w = 0.003923767;
	    for(i=1; i<=8; i++){
		j = 9 - i;
		w = w * wx375 + b[j];
	    }
	    bi0 = w / Math.sqrt(wx) * Math.exp(wx);
	    return(bi0);
	}
	wx375 = (wx / 3.75)*(wx / 3.75);
	w = .0045813;
	for(i=1; i<=6; i++){
	    j = 7 - i;
	    w = w * wx375 + a[j];
	}
	bi0 = w;
	return(bi0);
    }

    public static double besi1(double x){
	int i,j;
	double bi1,w,wx,wx375;
	double a[]={0.0, 0.5, 0.87890594, 0.51498869,
		    0.15084934, 0.02658733, 0.0030153},
	       b[]={0.0,0.39894228, -0.039880242, -0.003620183, 0.001638014,
		    -0.01031555, 0.022829673, -0.028953121, 0.017876535};
  
        if(x<0)
	    return(999);
	wx = x;
	if(x>3.75){
	    wx375 = 3.75 / wx;
	    w = -0.004200587;
	    for(i=1; i<= 8; i++){
		j = 9 - i;
		w = w * wx375 + b[j];
	    }
	    bi1 = w / Math.sqrt(wx) * Math.exp(wx);
	    return(bi1);
	}
  
	wx375 = (wx / 3.75)*(wx / 3.75);
	w = 0.00032411;
	for(i=1; i<=6; i++){
	    j = 7 - i;
	    w = w * wx375 + a[j];
	}
	bi1 = w * wx;
	return(bi1);
    }

    public static double besk0(double x){
	int i,j;
	double bk0,w,wx,wx2,wx375,bi0;
	double a[]={0.0, -0.57721566, 0.4227842, 0.23069756, 0.0348859,
		    0.00262698, 0.0001075},
               b[]={0.0, 1.0, 3.5156229, 3.0899424, 1.2067492, 0.2659732,
		    0.0360768},
               c[]= {0.0, 1.25331414, -0.0783222358, 0.02189568,
		     -0.01062446, 0.00587872, -0.0025154};

        if(x<=0.0)
	    return(999);
	wx = x;
	if(x>2){
	    wx2 = 2 / wx;
	    w = 0.00053208;
	    for(i=1; i<=6; i++){
		j = 7 - i;
		w = w * wx2 + c[j];
	    }
	    bk0 = w / Math.sqrt(wx) / Math.exp(wx);
	    return(bk0);
	}
	wx2 = (wx / 2)*(wx / 2);
	wx375 = (wx / 3.75)*(wx / 3.75);
	w = 0.0000074;
	bi0 = 0.004581;
	for(i=1; i<=6; i++){
	    j = 7 - i;
	    w = w * wx2 + a[j];
	    bi0 = bi0 * wx375 + b[j];
	}
	bk0 = w - Math.log(wx / 2) * bi0;
	return(bk0);
}

    public static double besk1(double x){
    int i,j;
    double bk1,w,wx,wx2,wx375,bi1;
    double a[]={0.0, 1.0, 0.15443144, -0.67278579, -0.18156897,
		-0.01919402, -0.00110404},
           b[]={0.0, 0.5, 0.87890594, 0.51498869, 0.15084934,
		0.02658733, 0.00301532},
           c[]={0.0, 1.25331414, 0.23498619, -0.0365562, 0.01504268,
		-0.00780353, 0.00325614};
    if(x<=0)
	return(999);
    wx = x;
    if(x>2){
	wx2 = 2 / wx;
	w = -0.00068245;
	for(i=1; i<=6; i++){
	    j = 7 - i;
	    w = w * wx2 + c[j];
	}
	bk1 = w / Math.sqrt(wx) / Math.exp(wx);
	return(bk1);
    }
    wx2 = (wx / 2)*(wx / 2);
    wx375 = (wx / 3.75)*(wx / 3.75);
    w = -0.00004686;
    bi1 = 0.00032411;
    for(i=1; i<=6; i++){
	j = 7 - i;
	w = w * wx2 + a[j];
	bi1 = bi1 * wx375 + b[j];
    }
    bk1 = w / wx + Math.log(wx / 2) * bi1 * wx;
    return(bk1);
    }

    public static double erf(double x){
	int i,j;
	double w,wx,fx;
	double a[]={0.0, 1.0, 7.05230784e-02, 0.0422820123, 0.0092705272,
		    0.0001520143, 0.00027655672};
   
	if(x<0.0)
	    return(999);
	if(x==0.0)
	    return(0);
	if(x>=10.0)
	    return(1.0);
	wx = x;
	w = 0.0000430638;
	for(i=1; i<=6; i++){
	    j = 7 - i;
	    w = w * wx + a[j];
	}
	fx = 1 - 1 / (Math.exp(16*Math.log(w)));
	return(fx);
    }

    public static double gamma(double x){
	double a[] = {1.0e0, -0.577191652e0, 0.9882055890999999e0,
		      -0.897056937e0, 0.918206857e0, -0.7567040779999999e0,
		      0.482199394e0, -0.193527818e0};
	double w, wx, w1, gx;
	int i, j;
  
	if (x <= 0.0 || x >= 34.0){
	    return(999);
	}
	wx = x;
	w1 = 1.0e0;
	if (x > 1.0){
	    do {
		wx = wx - 1.0e0;
		w1 = w1 * wx;
	    } while (wx > 1.0);
	}
	w = .035868343e0;
	for (i = 1; i<= 8; i++){
	    j = 8 - i;
	    w = w * wx + a[j];
	}
	gx = w1 * w / wx;
	return(gx);
    }

    public static double legend(double x, int n){
	double pnx,w,wx,wn,p0,p1,p2;
  
	if(n<0)
	    return(999);
	if(n==0){
	    pnx = 1;
	    return(pnx);
	}
	if(n==1){
	    pnx = x;
	    return(pnx);
	}
	wx = x;
	wn = n;
	p0 = 1;
	p1 = wx;
	do{
	    wn = wn - 1;
	    w = wn / (wn + 1);
	    p2 = wx * p1 + w * (wx * p1 - p0);
	    p0 = p1;
	    p1 = p2;
	} while (wn >= 2);
	pnx = p2;
	return(pnx);
    }

    public static double celi1(double pk){
	//int i;
	double fk,a0,b0,a1,b1; //c0
  
	if (Math.abs(pk)>1)
	    return(999);
	a0 = 1.0;
	b0 = Math.sqrt(1 - pk * pk);
	do{
	    a1 = (a0 + b0) / 2;
	    b1 = Math.sqrt(a0 * b0);
	    if(Math.abs(a1 - b1)<= 0.000001)
		break;
	    a0 = a1;
	    b0 = b1;
	} while (true);
	fk = 1.5707963 / a1;
	return(fk);
    }

    public static double celi2(double pk){
	int i;
	double fe,a0,b0,c0,a1,b1,c1,cn;
	
	if(Math.abs(pk)>1)
	    return(999);
	a0 = 1.0;
	c0 = pk * pk;
	b0 = Math.sqrt(1.0 - c0);
	cn = 0;
	i = 0;
	do{
	    a1 = (a0 + b0) / 2;
	    b1 = Math.sqrt(a0 * b0);
	    c1 = (a0 - b0) / 2;
	    cn = cn + Math.pow(2.0,(double)i) * c1 * c1;
	    i++;
	    if(Math.abs(a1 - b1)<=0.000001)
		break;
	    a0 = a1;
	    b0 = b1;
	} while (true);
	fe = 1.5707963 / a1 * (1 - (c0 / 2 + cn));
	return(fe);
    }

    public static double beki(double a0, double x, double eps){
	int n;
	double w1,w2,an, fx;

	if(a0==0||eps<=0)
	    return(-1);
	fx = a0;
	w1 = a0;
	for(n=1; n<=50; n++){
	    an = (double)n;
	    w2 = term(x, an) * w1;
	    fx = fx + w2;
	    if(Math.abs(w2) <= eps||Math.abs(w2 / fx) <= eps)
		return(fx);
	    w1 = w2;
	}
	return(fx);
    }

    public static double term (double x, double an){
	return( -x * x / ((2 * an - 1) * 2 * an));
    }
}
