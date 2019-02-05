package ya.sample;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample9 extends Activity implements Runnable
{
    SampleView sv;
    Handler hn;
    float x, y, dx, dy;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);

        hn = new Handler();
        hn.postDelayed(this, 10);

        sv = new SampleView(this);

        ll.addView(sv);
    }
    public void run()
    {
        WindowManager wm =  (WindowManager)getSystemService(WINDOW_SERVICE);
        Display dp = wm.getDefaultDisplay();
        Point p = new Point();
        dp.getSize(p);

        if(x<0 || x>p.x) dx = -dx;
        if(y<0 || y>p.y) dy = -dy;

        x+=dx;
        y+=dy;

        sv.invalidate();

        hn.postDelayed(this, 10);
    }
    public void onDestroy()
    {
        super.onDestroy();
        hn.removeCallbacks(this);
    }
    class SampleView extends View
    {
        Paint p;
        public SampleView(Context cn)
        {
            super(cn);
            x = 0; y = 0;
            dx = 10; dy = 10;
            p = new Paint();
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
