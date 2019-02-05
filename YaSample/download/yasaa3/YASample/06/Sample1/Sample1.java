package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.media.*;
import android.media.MediaPlayer.*;

public class Sample1 extends Activity
{
    Button[] bt = new Button[3] ;
    MediaPlayer mp;

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

        bt[0].setText("再生");
        bt[1].setText("一時停止");
        bt[2].setText("停止");

        bt[0].setEnabled(true);
        bt[1].setEnabled(false);
        bt[2].setEnabled(false);

        for(int i=0; i<bt.length; i++)
        {
            ll.addView(bt[i]);
            bt[i].setOnClickListener(new SampleClickListener());
        }
    }
    public void onResume()
    {
        super.onResume();
        mp = MediaPlayer.create(this, R.raw.ring);
        mp.setOnCompletionListener(new SampleCompletionListener());
    }
    public void onPause()
    {
        super.onPause();
        mp.release();
    }
    class SampleCompletionListener implements OnCompletionListener
    {
        public void onCompletion(MediaPlayer mp)
        {
            bt[0].setEnabled(true);
            bt[1].setEnabled(false);
            bt[2].setEnabled(false);
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
                bt[2].setEnabled(true);
                try
                {
                    mp.prepare();
                }
                catch(Exception e){}
                mp.start();
            }
            else if(v == bt[1])
            {
                if(mp.isPlaying())
                {
                    bt[0].setEnabled(false);
                    bt[1].setEnabled(true);
                    bt[2].setEnabled(true);
                    mp.pause();
                }
                else
                {
                    bt[0].setEnabled(false);
                    bt[1].setEnabled(true);
                    bt[2].setEnabled(true);
                    mp.start();
                }
            }
            else if(v == bt[2])
            {
                bt[0].setEnabled(true);
                bt[1].setEnabled(false);
                bt[2].setEnabled(false);
                mp.pause();
                mp.seekTo(0);
            }
        }
    }
}
