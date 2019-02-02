package ya.Sample037;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample037 extends Activity
{
   TextView tv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("いらっしゃいませ。");

      ll.addView(tv);
   }
   public boolean onKeyDown(int keycode, KeyEvent e)
   {
      String str;
      switch(keycode)
      {
         case KeyEvent.KEYCODE_DPAD_UP:
            str = "上"; break;
         case KeyEvent.KEYCODE_DPAD_DOWN:
            str = "下"; break;        	  
         case KeyEvent.KEYCODE_DPAD_LEFT:
            str = "左"; break;      
         case KeyEvent.KEYCODE_DPAD_RIGHT:
            str = "右"; break;      
         case KeyEvent.KEYCODE_DPAD_CENTER:
            str = "中央"; break;
         default:
            str = "他のキー";
      }
      tv.setText(str + "ですね。");
      
      return true;
   }
}
