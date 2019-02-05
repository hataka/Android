package ya.sample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import android.graphics.*;
import android.hardware.*;

public class Rensyu1 extends Activity
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

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        iv = new ImageView(this);
        iv.setImageBitmap(bmp);

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

                if((tmp-val) > 5)
                {
                    RotateAnimation anim = new RotateAnimation(0, 360, iv.getWidth()/2, iv.getHeight()/2);
                    anim.setDuration(500);
                    iv.startAnimation(anim);
                }
                val = tmp;
            }
        }
        public void onAccuracyChanged(Sensor s, int accuracy){}
    }
}
