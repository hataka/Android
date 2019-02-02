package ya.Sample042;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.widget.*;

public class Sample042 extends Activity
{
   TextView[] tv = new TextView[3];
   Button bt;

   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      for(int i=0; i<tv.length; i++)
      {
         tv[i] = new TextView(this);
         tv[i].setText("This is a Car.");
      }
      
      tv[0].setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
      tv[1].setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
      tv[2].setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
      
      tv[0].setTextSize(16);
      tv[1].setTextSize(16);      
      tv[2].setTextSize(16);
      
      for(int i=0; i<tv.length; i++)
      {          
         ll.addView(tv[i]);
      }
   }
}
