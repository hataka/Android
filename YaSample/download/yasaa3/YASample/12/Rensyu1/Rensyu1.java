package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu1 extends Activity
{

   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_rensyu1);
      
      Button bt = (Button) findViewById(R.id.SampleButton);
 
      bt.setOnClickListener(new SampleClickListener());
   }
   
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
    	 TextView tv = (TextView) findViewById(R.id.SampleTextView);  
         tv.setText("ありがとうございます。");
      }
   }  
}
