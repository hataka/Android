package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.widget.*;

public class Sample8 extends Activity
{
    static final int num = 100;
    ViewFlipper vf;
    SampleView[] sv = new SampleView[3];
    LinearLayout[] ll = new LinearLayout[3];
    float x;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout llp = new LinearLayout(this);
        setContentView(llp);

        vf = new ViewFlipper(this);

        for(int i=0; i<sv.length;i++)
        {
            ll[i] = new LinearLayout(this);
            sv[i] = new SampleView(this);
            ll[i].addView(sv[i]);
            vf.addView(ll[i]);
        }

        llp.addView(vf);
        setContentView(llp);

        llp.setOnTouchListener(new SampleTouchListener());
    }
    class SampleTouchListener implements OnTouchListener
    {
        public boolean onTouch(View v, MotionEvent e)
        {
            if(e.getAction() == MotionEvent.ACTION_DOWN)
            {
                x = e.getX();
            }
            else if(e.getAction() == MotionEvent.ACTION_UP)
            {
                if(x-20 > e.getX())
                {
                    TranslateAnimation inanim =
                            new TranslateAnimation(sv[0].getWidth(), 0, 0, 0);
                    inanim.setDuration(1000);
                    TranslateAnimation outanim =
                            new TranslateAnimation(0,-sv[0].getWidth(), 0, 0);
                    outanim.setDuration(1000);
                    vf.setInAnimation(inanim);
                    vf.setOutAnimation(outanim);
                    vf.showNext();
                }
                else if(x+20 < e.getX())
                {
                    TranslateAnimation inanim =
                            new TranslateAnimation(-sv[0].getWidth(), 0, 0, 0);
                    inanim.setDuration(1000);
                    TranslateAnimation outanim =
                            new TranslateAnimation(0,sv[0].getWidth(), 0, 0);
                    outanim.setDuration(1000);
                    vf.setInAnimation(inanim);
                    vf.setOutAnimation(outanim);
                    vf.showPrevious();
                }
            }
            return true;
        }
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

                p.setColor(Color.rgb(b.r, b.g, b.b));
                p.setStyle(Paint.Style.FILL);
                cs.drawCircle(b.x, b.y, 30, p);
            }
        }
    }
}
class Ball
{
    public int x,y,r,g,b;
}
