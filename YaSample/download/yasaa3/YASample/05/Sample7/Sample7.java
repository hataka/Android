package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample7 extends Activity
{
    static final int num = 100;
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
        ArrayList<Ball> bl;
        Paint p;

        public SampleView(Context cn)
        {
            super(cn);

            bl = new ArrayList<Ball>();
            Random rn = new Random();
            p = new Paint();

            for (int i=0; i<num; i++)
            {
                Ball b = new Ball();

                b.x = rn.nextInt(1440);
                b.y = rn.nextInt(2560);
                b.r = rn.nextInt(256);
                b.g = rn.nextInt(256);
                b.b = rn.nextInt(256);
                bl.add(b);
            }
        }
        protected void onDraw(Canvas cs)
        {
            super.onDraw(cs);

            for(int i=0; i<num; i++)
            {
                Ball b = bl.get(i);

                p.setColor(Color.rgb(b.r,b.g,b.b));
                p.setStyle(Paint.Style.FILL);
                cs.drawCircle(b.x,b.y,30,p);
            }
        }
    }
}
class Ball
{
    public int x,y,r,g,b;
}
