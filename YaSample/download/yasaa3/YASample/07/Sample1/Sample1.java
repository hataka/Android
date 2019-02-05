package ya.sample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.hardware.*;

public class Sample1 extends Activity
{
    ImageView iv;
    SensorManager sm;
    Sensor s;
    SampleSensorEventListener sse;
    float val;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
        setContentView(ll);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.light);
        iv = new ImageView(this);
        iv.setImageBitmap(bmp);
        iv.setImageAlpha(100);

        ll.addView(iv);

        sse = new SampleSensorEventListener();
    }
    protected void onResume()
    {
        super.onResume();
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(sse,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause()
    {
        super.onPause();
        sm.unregisterListener(sse);
    }
    class SampleSensorEventListener implements SensorEventListener
    {
        public void onSensorChanged(SensorEvent e)
        {
            if(e.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            {
                float tmp = e.values[0]+e.values[1]+e.values[2];

                if((tmp-val) > 2)
                {
                    iv.setImageAlpha(255);
                }
                else
                {
                    iv.setImageAlpha(100);
                }
                val = tmp;
            }
        }
        public void onAccuracyChanged(Sensor s, int accuracy) {}
    }
}
