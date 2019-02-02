package ya.Sample074;

import com.google.android.maps.*;
import android.os.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class Sample074 extends MapActivity
{
   MapView mv;
   EditText[] et = new EditText[6];
   TextView[] tv = new TextView[6];
   Button bt;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      TableLayout tl = new TableLayout(this); 
      setContentView(tl);

      for(int i=0; i<et.length; i++)
      {
         et[i] = new EditText(this);
         tv[i] = new TextView(this);   
      }
      
      tv[0].setText("度");
      tv[1].setText("分");
      tv[2].setText("秒");
      tv[3].setText("度");
      tv[4].setText("分");
      tv[5].setText("秒");
      
      TableRow tr1 = new TableRow(this); 
      TableRow tr2 = new TableRow(this);

      tr1.addView(et[0]);
      tr1.addView(tv[0]);
      tr1.addView(et[1]);
      tr1.addView(tv[1]);
      tr1.addView(et[2]);
      tr1.addView(tv[2]);
     
      tr2.addView(et[3]);
      tr2.addView(tv[3]);
      tr2.addView(et[4]);
      tr2.addView(tv[4]);
      tr2.addView(et[5]);
      tr2.addView(tv[5]);      
      
      bt = new Button(this);
      
      bt.setText("検索");
      
      mv = new MapView(this, "0ZEldpaTWV2dKLtPZARBsGq-B2WQyggZc9A7HLQ");  //APIキーが必要
      mv.setEnabled(true);
      mv.setClickable(true);
      mv.setBuiltInZoomControls(true);
      MapController mc = mv.getController();
      mc.setZoom(3);

      tl.addView(tr1);
      tl.addView(tr2);
      tl.addView(bt);
      tl.addView(mv);
      
      bt.setOnClickListener(new SampleClickListener());
   }
   protected boolean isRouteDisplayed()
   {
	   return false;
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         try
         {   	  
            double[] d = new double[6];
         
    	    for(int i=0; i<et.length; i++) 
    	    {
    		   String str = et[i].getText().toString();
     		   d[i] = Double.parseDouble(str);
    	    }
    	 
            int lt = (int) ((d[0] + d[1] / 60 + d[2] /3600) * 1E6);
            int ln = (int) ((d[3] + d[4] / 60 + d[5] /3600) * 1E6);

            GeoPoint gp = new GeoPoint(lt, ln);
            mv.getController().animateTo(gp);
         }
         catch(NumberFormatException e)
         {
            Toast.makeText(getBaseContext(), "数値を入力してください。", Toast.LENGTH_LONG).show();	 
         }
      }
   }  
}

