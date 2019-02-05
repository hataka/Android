package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Rensyu3 extends Activity
{
    static final int num = 50;
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
        ArrayList<Point> bl;
        Paint p;

        public SampleView(Context cn)
        {
            super(cn);

            bl = new ArrayList<Point>();
            Random rn = new Random();
            p = new Paint();

            for (int i=0; i<num; i++)
            {
                Point b = new Point();

                b.x = rn.nextInt(1440);
                b.y = rn.nextInt(2560);
                bl.add(b);
            }
        }
        protected void onDraw(Canvas cs)
        {
            super.onDraw(cs);

            for(int i=0; i<num; i++)
            {
                Point b = bl.get(i);

                cs.drawBitmap(bmp, b.x, b.y, p);
            }
        }
    }
}



