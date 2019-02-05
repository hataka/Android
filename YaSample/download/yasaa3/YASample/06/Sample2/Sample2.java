package ya.sample;

import java.io.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.media.*;
import android.media.MediaPlayer.*;

public class Sample2 extends Activity
{
    Button[] bt = new Button[3] ;
    MediaPlayer mp;
    MediaRecorder mr;
    File f;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        for(int i=0; i<bt.length; i++)
        {
            bt[i] = new Button(this);
        }

        bt[0].setText("開始");
        bt[1].setText("停止");
        bt[2].setText("再生");

        bt[0].setEnabled(true);
        bt[1].setEnabled(false);
        bt[2].setEnabled(true);

        File dir = getFilesDir();
        f = new File(dir, "Sample.3gp");

        for(int i=0; i<bt.length; i++)
        {
            ll.addView(bt[i]);
            bt[i].setOnClickListener(new SampleClickListener());
        }
    }
    public void onResume()
    {
        super.onResume();

        mp = new MediaPlayer();
        mr = new MediaRecorder();

        mp.setOnCompletionListener(new SampleCompletionListener());
    }
    public void onPause()
    {
        super.onPause();

        mp.release();
        mr.release();
    }
    class SampleCompletionListener implements OnCompletionListener
    {
        public void onCompletion(MediaPlayer mp)
        {
            bt[0].setEnabled(true);
            bt[1].setEnabled(false);
            bt[2].setEnabled(true);
        }
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            if(v == bt[0])
            {
                bt[0].setEnabled(false);
                bt[1].setEnabled(true);
                bt[2].setEnabled(false);
                try
                {
                    mp.reset();
                    mr.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                    String path = f.getAbsolutePath();
                    mr.setOutputFile(path);
                    mr.prepare();
                    mr.start();
                }
                catch(Exception e){}
            }
            else if(v == bt[1])
            {
                bt[0].setEnabled(true);
                bt[1].setEnabled(false);
                bt[2].setEnabled(true);
                try {
                    mr.reset();

                }catch(Exception e){}
            }
            else if(v == bt[2])
            {
                bt[0].setEnabled(false);
                bt[1].setEnabled(false);
                bt[2].setEnabled(false);
                try
                {
                    String path = f.getAbsolutePath();
                    mp.setDataSource(path);
                    mp.prepare();
                }
                catch(Exception e){}
                mp.start();
             }
        }
    }
}
