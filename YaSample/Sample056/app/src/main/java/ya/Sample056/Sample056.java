package ya.Sample056;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample056 extends Activity
{
   SampleView sv;

   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      setContentView(ll);

      sv = new SampleView(this);
    		  
      ll.addView(sv);
   }
   class SampleView extends View
   {
      float x, y;

      public SampleView(Context cn)
      {
         super(cn);
         x = -10; y = -10;
      }
      public boolean onTouchEvent(MotionEvent e)
      {
         x = e.getX();
         y = e.getY();
         
         this.invalidate();
  	  
         return true;
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

