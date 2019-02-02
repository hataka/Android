package ya.Sample059;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample059 extends Activity implements Runnable
{
   SampleView sv;
   Handler hn;
   float x, y, dx, dy;

   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      
      getWindow().addFlags(
    		  WindowManager.LayoutParams.FLAG_FULLSCREEN);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      
      LinearLayout ll = new LinearLayout(this); 
      setContentView(ll);

      hn = new Handler();
      hn.postDelayed(this, 10);
      
      sv = new SampleView(this);
    		  
      ll.addView(sv);
   }
   public void run()
   {
      WindowManager wm =  (WindowManager)getSystemService(WINDOW_SERVICE);
      Display dp = wm.getDefaultDisplay(); 
	  
      if(x<0 || x>dp.getWidth()) dx = -dx;
      if(y<0 || y>dp.getHeight()) dy = -dy;
    	  
      x+=dx;
      y+=dy;
      
      sv.invalidate();
            
      hn.postDelayed(this, 10);
   }
   public void onDestroy()
   {
	  super.onDestroy();
      hn.removeCallbacks(this);
   }
   class SampleView extends View
   {
      public SampleView(Context cn)
      {
         super(cn);
         x = 0; y = 0;
         dx = 10; dy = 10; 
     }
      protected void onDraw(Canvas cs)
      {
         super.onDraw(cs);
     	 Paint p = new Paint();
    	 p.setColor(Color.WHITE);
         p.setStyle(Paint.Style.FILL);
         cs.drawCircle(x, y, 10, p); 
      }
   }
}