package ya.sample;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.animation.*;
import android.widget.*;

public class Sample4 extends Activity
{
    TextView tv;
    ImageView iv;
    SampleBroadcastReceiver sb;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);
        iv = new ImageView(this);

        Bitmap bmp = BitmapFactory.decodeResource
                (getResources(), R.drawable.light);
        iv.setImageBitmap(bmp);

        ll.addView(tv);
        ll.addView(iv);

        sb = new SampleBroadcastReceiver();
    }
    protected void onResume()
    {
        super.onResume();
        IntentFilter itf = new IntentFilter();
        itf.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(sb, itf);
    }
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(sb);
    }

    class SampleBroadcastReceiver extends BroadcastReceiver
    {
        public void onReceive(Context cn, Intent it)
        {
            String str = it.getAction();
            if(str.equals(Intent.ACTION_BATTERY_CHANGED))
            {
                float level = it.getIntExtra("level", 0);
                float scale = it.getIntExtra("scale", 1);
                float b = level / scale;
                tv.setText("バッテリ" + b *100 + "%");
                AlphaAnimation anim = new AlphaAnimation(0, b);
                anim.setDuration((long)(1000 / b));
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                iv.startAnimation(anim);
            }
        }
    }
}
