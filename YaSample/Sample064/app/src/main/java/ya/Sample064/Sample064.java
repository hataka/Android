package ya.Sample064;

import java.io.*;
import java.util.*;
import android.app.*;
import android.content.pm.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.hardware.*;
import android.hardware.Camera.*;
import android.media.*;

public class Sample064 extends Activity
{
   Button[] bt = new Button[2];
   SurfaceView sv;
   SurfaceHolder sh;
   MediaRecorder mr;
   File dir, f;
   Camera cm;
   
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
	      
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

      File dir = new File(Environment.getExternalStorageDirectory(),"YASample");
      if(dir.exists() == false)
      {
          dir.mkdir(); 
      }	  
      f = new File(dir, "Sample.3gp");
      
      sv = new SurfaceView(this);
      sh = sv.getHolder();
      sh.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
      
      for(int i=0; i<bt.length; i++)
      {
         bt[i] = new Button(this);
      }
      
      bt[0].setText("録画");
      bt[1].setText("停止");
      
      bt[0].setEnabled(true);
      bt[1].setEnabled(false);	        	 
       
      mr = new MediaRecorder();
      mr.setPreviewDisplay(sh.getSurface());
      
      for(int i=0; i<bt.length; i++)
      {
         ll.addView(bt[i]);
         bt[i].setOnClickListener(new SampleClickListener());
      }
      ll.addView(sv);
   }
   public void onDestroy()
   {
	   super.onDestroy();
	   mr.release();   
   } 
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         if(v == bt[0])
         {
            bt[0].setEnabled(false);
            bt[1].setEnabled(true);	
     	    try
            {
     	       mr.setVideoSource(MediaRecorder.VideoSource.CAMERA);
     	       mr.setAudioSource(MediaRecorder.AudioSource.MIC);
     	       mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
     	       mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
     			      
     	       String path = f.getAbsolutePath();
     	       mr.setOutputFile(path);
     			            
     	       mr.setVideoFrameRate(30);
     	       cm = Camera.open();
     	       Camera.Parameters pr = cm.getParameters();
     	       List<Size> ss = pr.getSupportedPictureSizes();
     	       Size s = ss.get(0);
               cm.release();
               mr.setVideoSize(s.width, s.height);
     	       mr.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
     	       mr.prepare();
               mr.start();
            }
            catch (Exception e){}            
         }
         else if(v == bt[1])
         {
             try
             {
                bt[0].setEnabled(true);
                bt[1].setEnabled(false);	        	 
                mr.stop();
             }  
             catch (Exception e){}
         }
      }
   } 
}