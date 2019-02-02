//  -*- mode: java -*-  Time-stamp: <07/06/07 18:58:24 k.hata>
/*================================================================
 * プログラム名: DifIntgl.java
 * 作成日: Sun Feb 10 15:18:42 2002
 * $Id: sslib211.c,v 1.3 2002/02/22 23:24:01 k.hata Exp k.hata $
 * Programmed By: 畑和彦
   To compile:
     本来の組み込みstruct,functionとの衝突を避けるためcomplex
     ライブラリの先頭にCを付与する <Sat Feb 02 10:15:42 2002>
   To run:        cint -03 で実行のこと
 * 説明: 
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
class DiffIntgl {

    public static double[] spl_h = new double[50];
    public static double[] spl_sp = new double[50];

    public static double lagdif(double x[], double y[], int n, double  xx){
	int nm1,i,j,k;
	double sm0,sm1,sm2,xi,dif;
	
	if(n<3||xx<x[0]||xx>x[n-1])
	    return(-1);
	nm1 = n - 1;
	for(i=0; i<nm1; i++){
	    if((x[i+1] - x[i])<=0)
		return(-1);
	}
	dif = 0;
	for(i=0; i<n; i++){
	    sm0 = 0.0;
	    sm2 = 1;
	    xi = x[i];
	    for(j=0; j<n; j++){
		if((i - j)!= 0){
		    sm2 = sm2 * (xi - x[j]);
		    sm1 = 1.0;
		    for(k=0; k<n; k++){
			if( k != i && k != j)
			    sm1 = sm1 * (xx - x[k]);
		    }
		    sm0 = sm0 + sm1;
		}
	    }
	    dif = dif + y[i] * sm0 / sm2;
	}
	return(dif);
    }

    public static double spldif(double x[], double y[], int n, double xx){
	int i,nm1;
	double hi,hi2,dxp2,dxm2,dif;
	
	if(n<3 || n>50 || xx<x[0] || xx>x[n-1])
	    return(-1);
	nm1 = n - 1;
	for(i=0; i<nm1; i++){
	    if((x[i+1]-x[i])<=0)
		return(-1);
	}
	subspl(x, y, n, nm1);
	for(i=1; i<n; i++){
	    if(x[i-1]>xx && xx<=x[i]){
		i--;
		hi = spl_h[i];
		hi2 = hi * hi;
		dxp2 = (x[i] - xx) * (x[i] - xx);
		dxm2 = (xx - x[i-1]) * (xx - x[i-1]);
		dif = (spl_sp[i-1]*(hi2-3*dxp2)+spl_sp[i]*(3*dxm2-hi2)+6*(y[i]-y[i-1]))/hi/6;
		return(dif);
	    }
	}
	return(-1);
    }

    public static int subspl(double x[], double y[], int n, int nm1){
	int i,j;
	double hip1,hid,g;
	double[] d1 = new double[50];
	double[] d2 = new double[50];
	double[] d3 = new double[50];

	for(i=1; i<nm1; i++){
	    spl_h[i]= x[i] - x[i-1];
	    hip1 = x[i+1] - x[i];
	    spl_sp[i] = 6 * ((y[i+1] - y[i])/(spl_h[i]*hip1)-(y[i] - y[i-1])/(spl_h[i]*spl_h[i]));
	}
	spl_h[n-1] = x[n-1] - x[nm1-1];
	for(i=1; i<nm1; i++){
	    hid = spl_h[i+1]/spl_h[i];
	    d1[i] = 1;
	    d2[i] = 2 * (1 + hid);
	    d3[i] = hid;
	}
	d2[1] = d2[1] + 1;
	d2[nm1-1] = d2[nm1-1] + spl_h[n-1] / spl_h[nm1-1];
	d3[1] = d3[1] / d2[1];
	spl_sp[1] = spl_sp[1] / d2[1];
	for(i=2; i<nm1; i++){
	    g = d2[i] - d3[i-1] * d1[i];
	    d3[i] = d3[i] / g;
	    spl_sp[i] = (spl_sp[i] - spl_sp[i-1] * d1[i]) / g;
	}
	for(j=3; j<=nm1; j++){
	    spl_sp[n-j] = spl_sp[n-j] - spl_sp[n-j+1] * d3[n-j];
	}
	spl_sp[0] = spl_sp[1];
	spl_sp[n-1] = spl_sp[nm1-1];
	return(0);
    }

    public static double simpei (double y[], int n, double h){
	double s;
	int i;
  
	if(n<3 || n%2== 0)
	    return(-1);
	s = 0.0;
	for(i=1; i<n; i+=2)
	    s = s + y[i-1] + 4.0 * y[i] + y[i+1];
	s = h * s/ 3.0;
	return(s);
    }

    public static double simpui (double x[], double y[], int n){
	double s;
	int i;
	double x1,x2,x3,h,hpd,hmd,d;
  
	if(n<3 || n%2 == 0)
	    return(-1);
	for(i=0; i<(n-1); i++){
	    if(x[i+1] - x[i]<= 0)
		return(-1);
	}
	s = 0.0;
	for(i=1; i<(n-1); i+=2){
	    x1 = x[i-1];
	    x2 = x[i];
	    x3 = x[i+1];
	    h = 0.5 * (x3 - x1);
	    hpd = 1.0 / (x2 - x1);
	    hmd = 1 / (x3 - x2);
	    d = x2 - x1 - h;
	    s = s+((1.0 + 2.0*d*hpd)*y[i-1]+2.0*h*(hpd+hmd)*y[i]+(1.0-2.0*d*hmd)*y[i+1])*h/3.0;
	}
	return(s);
    }

    public static double splitg(double x[], double y[], int n){
	double s;
	int i,nm1;
	double hi,hi2;
  
	if(n<3 || n>50)
	    return(-1);
	nm1 = n - 1;
	for(i=0; i<nm1; i++){
	    if((x[i+1]-x[i])<=0)
		return(-1);
	}
	subspl(x, y, n, nm1);
	s = 0.0;
	for(i=1; i<n; i++){
	    hi = spl_h[i];
	    hi2 = hi * hi;
	    s = s + hi * (y[i] + y[i-1]-hi2*(spl_sp[i-1]+spl_sp[i]) * 8.333333333329999e-02) * 0.5;
	}
	return(s);
    }

    static double dgl2(double xi, double xe) {
  		double g = 0.5773502691896299;
  		double s;
  
  		if(xi>=xe)
    	return(-1);
  		s = (func_dgl(fv(xi, xe, g)) + func_dgl(fv(xi, xe, -g))) * (xe - xi) * 0.5;
  		return(s);
	}

	static double dgl20(double xi, double xe){
  		int i;
  		double gi,gim,s;
  		double g[]={0.0, 0.99312859918509, 0.96397192727791,
 	               0.9122344282513301,0.83911697182222, 0.74633190646015,
			       0.63605368072652, 0.51086700195083,0.37370608871542,
			       0.22778585114165, 0.07652652113349},
  				w[]={0.0, 0.01761400713914, 0.04060142980039,
	 				0.06267204833411, 8.327674157669999e-02,
	 				0.10193011981724, 0.11819453196151, 0.13168863844918,
                	0.14209610931838, 0.1491729864726,0.15275338713073};
  
  		if(xi>=xe)
    		return(-1);
  			s = 0.0;
  		for(i=1; i<=10; i++){
    		gi = g[i];
    		gim = -gi;
    		s = s + (func_dgl(fv(xi, xe, gi)) + func_dgl(fv(xi, xe, gim))) * w[i];
  		}
  		s = (xe - xi) * 0.5 * s;
  		return(s);
	}

	static double dgl3(double xi, double xe){
  		double s;
  		double gi=0.77459666924148,
  		g0=0.0,
  		w1=0.55555555555556,
  		w2=0.8888888888888899;
  
  		if(xi>=xe)
    		return(-1);
  		s = func_dgl(fv(xi, xe, g0)) * w2;
  		s = s + (func_dgl(fv(xi, xe, gi)) + func_dgl(fv(xi, xe, -gi))) * w1;
  		s = (xe - xi) * 0.5 * s;
  		return(s);
	}

	static double dgl38(double xi,double  xe){
  		int i;
  		double gi,gim,s;
  		double g[]={0.0,0.9980499305357, 0.9897394542664, 0.9748463285902,
		       0.9534663309335001, 0.9257413320486, 0.8918557390046,
		       0.8520350219324, 0.8065441676053, 0.7556859037544,
		       0.6997986803792, 0.6392544158297, 0.5744560210478,
		       0.5058347179279, 0.4338471694324, 0.3589724404794,
		       0.2817088097902, 0.2025704538921, 0.1220840253379,
		       0.04078514790458},
  			w[]={0.0, 0.005002880749632, 0.01161344471647,
	 			0.01815657770961, 0.02457973973823, 0.03083950054518,
	 			0.036894081594, 0.04270315850467, 0.04822806186076,
	 			0.05343201991033,0.058280399147,6.274093339212999e-02,
	 			6.678393797914e-02,0.0703825070669, 0.07351269258474,
	 			0.07615366354845, 0.07828784465821, 0.07990103324353,
	 			0.0809824937706, 0.08152502928039};

  		if(xi>=xe)
    		return(-1);
  		s = 0.0;
  		for(i=1; i<=19; i++){
    		gi = g[i];
    		gim = -gi;
    		s = s + (func_dgl(fv(xi, xe, gi)) + func_dgl(fv(xi, xe, gim))) * w[i];
  		}
  		s = (xe - xi) * 0.5 * s;
  		return(s);
	}

	static double func_dgl(double x){
  		return(Math.sin(x));
	}

	static double fv(double a, double b, double x){
  		double y;
  		y = ((b - a) * x + (b + a)) * 0.5;
  		return(y);
	}

	static double dglg10(){
  		int i;
  		double s;
  		double g[]={0.0, 29.92069701227389, 21.99658581198076,
                         16.2792578313781,11.84378583790007,8.330152746764497,
                         5.55249614006380, 3.4014336978549, 1.808342901740316,
                         0.7294545495031705, 0.1377934705404924},
  		w[]={0.0, 9.911827219609e-13, 1.839564823979631e-09,
	   				4.249313984962686e-07, 2.825923349599566e-05,
	   				7.530083885875388e-04, 9.501516975181101e-03,
	   				6.208745609867775e-02, 0.2180682876118094,
	   				0.4011199291552736, 0.3084411157650201};
  
  		s = 0.0;
  		for(i=1; i<=10; i++)
    		s = s + func_dglg(g[i]) * w[i];
  			return(s);
		}

	static double dglg3(){
  		int i;
  		double s;
  		double g[]={0.0,0.41577455678348,2.294280360279,6.2899450829375},
  			w[]={0.0,0.71109300992917,0.27851773356924,0.010389256501586};
  
  		s = 0.0;
  		for(i=1; i<=3; i++)
    		s = s + func_dglg(g[i]) * w[i];
  		return(s);
	}

	static double dglg5(){
  		int i;
  		double s;
  		double g[]={0.0, 12.64080084427578, 7.085810005858838,
                        3.596425771040722, 1.413403059106517,
                        0.2635603197181409},
  				w[]={0.0, 2.33699723857762e-05, 3.61175867992205e-03,
	  				7.594244968170601e-02, 0.398666811083176,
	  				0.5217556105828089};
  
  		s = 0.0;
  		for(i=1; i<=5; i++)
    	s = s + func_dglg(g[i]) * w[i];
  		return(s);
	}

	static double func_dglg(double x){
  		return(x);
	}


	static double dgh10(){
  		int i;
  		double s;
  		double g[]={0.0, 0.3429013272237046, 1.036610829789514,
                        1.756683649299882, 2.53273167423279,3.436159118837738},
  			w[]={0.0, 0.6108626337353258, 0.2401386110823147,
	  				3.387439445548106e-02, 1.343645746781233e-03,
	  				7.640432855232621e-06};
  
  		s = 0.0;
  		for(i=1; i<=5; i++)
    		s = s + func_dgh(g[i]) * w[i] + func_dgh(-g[i]) * w[i];
  		return(s);
	}

	static double dgh15(){
  		int i;
  		double s;
  		double g[]={0.0, 0.0, 0.5650695832555758, 1.136115585210921,
                        1.719992575186489,2.325732486173858, 2.967166927905603,
                        3.669950373404445, 4.499990707309392},
  				w[]={0.0, 0.5641003087264175, 0.4120286874988986,
	  					0.1584889157959357, 3.078003387254608e-02,
	  					2.778068842912276e-03, 1.00004441234999e-04,
	  					1.059115547711067e-06, 1.522475804253517e-09};

  		s = func_dgh(g[1]) * w[1];
  		for(i=2; i<= 8; i++)
    		s = s + func_dgh(g[i]) * w[i] + func_dgh(-g[i]) * w[i];
  		return(s);
	}

	static double func_dgh(double x){
  	return( x * x );
	}

	static double simpe22(double[][] y,int n1max,int n1,int n2,double h1,double h2){
  		int i,j;
  		double s;
  		double[]  w = new double[100];
  		if(n1<3 || n2<3 || n2>100 || (n1%2)==0 || (n2%2)==0)
    		return(-1);
  		s = 0;
  		for(j=0; j<n2; j++){
    		w[j] = 0.0;
    		for(i=1; i<n1-1; i+=2)
      			w[j] = w[j] + y[i-1][j]+4*y[i][j]+y[i+1][j];
  		}
  		for(j=1; j<n2-1; j+=2)
    		s = s + w[j-1] + 4 * w[j] + w[j+1];
  		s = 0.1111111111111111 * h1 * h2 *s;
  		return(s);
	}

}
