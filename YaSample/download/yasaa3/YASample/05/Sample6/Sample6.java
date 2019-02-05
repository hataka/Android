package ya.sample;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample6 extends Activity
{
    SampleView sv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);

        sv = new SampleView(this);

        ll.addView(sv);
    }
    class SampleView extends View
    {
        float x, y;
        Paint p;

        public SampleView(Context cn)
        {
            super(cn);
            x = -50; y = -50;
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

            p.setColor(Color.GRAY);
            p.setStyle(Paint.Style.FILL);
            cs.drawCircle(x, y, 50, p);
        }
    }
}
