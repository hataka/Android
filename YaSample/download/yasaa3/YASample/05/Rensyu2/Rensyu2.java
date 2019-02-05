package ya.sample;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Rensyu2 extends Activity
{
    SampleView sv;
    Bitmap bmp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);

        sv = new SampleView(this);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);

        ll.addView(sv);
    }
    class SampleView extends View
    {
        float x, y;
        Paint p;

        public SampleView(Context cn)
        {
            super(cn);
            x = -200; y = -200;
            p = new Paint();
        }
        public boolean onTouchEvent(MotionEvent e)
        {
            x = e.getX();
            y = e.getY();

            this.invalidate();

            return true;
        }
        protected void onDraw(Canvas cs)
        {
            super.onDraw(cs);

            cs.drawBitmap(bmp, x, y, p);
        }
    }
}
