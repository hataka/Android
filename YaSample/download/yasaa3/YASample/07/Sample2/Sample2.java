package ya.sample;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.hardware.*;

public class Sample2 extends Activity
{
    ImageView iv;
    SensorManager sm;
    Sensor s1, s2;
    SampleSensorEventListener sse;

    Bitmap bmp;
    float[] av = new float[3];
    float[] mv = new float[3];
    float[] R1 = new float[16];
    float[] R2 = new float[16];
    float[] I = new float[16];
    float[] v = new float[3];

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
        setContentView(ll);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.key);
        iv= new ImageView(this);
        iv.setImageBitmap(bmp);

        ll.addView(iv);

        sse = new SampleSensorEventListener();
    }
    protected void onResume()
    {
        super.onResume();
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        s1 = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        s2 = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sm.registerListener(sse, s1, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sse, s2, SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause()
    {
        super.onPause();
        sm.unregisterListener(sse, s1);
        sm.unregisterListener(sse, s2);
    }

    class SampleSensorEventListener implements SensorEventListener
    {
        public void onSensorChanged(SensorEvent e)
        {
            switch (e.sensor.getType())
            {
                case Sensor.TYPE_ACCELEROMETER:
                    av = e.values.clone();
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    mv = e.values.clone();
                    break;
            }
            if(mv != null && av != null)
            {
                SensorManager.getRotationMatrix(R1, I, av, mv);
                SensorManager.remapCoordinateSystem
                        (R1, SensorManager.AXIS_X, SensorManager.AXIS_Y, R2);
                SensorManager.getOrientation(R2, v);
                float d = (float) Math.toDegrees(v[0]);
                Matrix m = new Matrix();
                m.postRotate(-d);
                Bitmap tmp = Bitmap.createBitmap
                        (bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), m, true);
                iv.setImageBitmap(tmp);
            }
        }
        public void onAccuracyChanged(Sensor s, int accuracy) {}
    }
}
