package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample8 extends Activity
{
    Button bt1, bt2;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        bt1 = new Button(this);
        bt2 = new Button(this);

        bt1.setText("開始");
        bt2.setText("停止");

        ll.addView(bt1);
        ll.addView(bt2);

        bt1.setOnClickListener(new SampleClickListener());
        bt2.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Context ct = getApplicationContext();
            Intent it = new Intent(ct, SampleService.class);
            PendingIntent pi = PendingIntent.getService(ct, 0, it, 0);
            AlarmManager am = (AlarmManager)ct.getSystemService(Context.ALARM_SERVICE);
            if(v == bt1)
            {
                long time = Calendar.getInstance().getTimeInMillis();
                am.setRepeating(AlarmManager.RTC_WAKEUP, time, 10*1000, pi);
            }
            else if(v == bt2)
            {
                am.cancel(pi);
                stopService(it);
            }
        }
    }
}
