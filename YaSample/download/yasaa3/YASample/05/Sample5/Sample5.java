package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.widget.*;

public class Sample5 extends Activity
{
    ImageView[] iv = new ImageView[3];
    Bitmap bmp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER);
        setContentView(ll);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);

        for(int i=0; i<iv.length; i++)
        {
            iv[i] = new ImageView(this);
            iv[i].setImageBitmap(bmp);

            ll.addView(iv[i]);

            iv[i].setOnClickListener(new SampleClickListener());
        }
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            ImageView tmp = (ImageView) v;
            AnimationSet anim = new AnimationSet(true);
            anim.addAnimation
                    (new RotateAnimation(0, 360, tmp.getWidth()/2, tmp.getHeight()/2));
            anim.addAnimation
                    (new ScaleAnimation(1,2,1,2,tmp.getWidth()/2, tmp.getHeight()/2));
            anim.setDuration(1000);
            tmp.startAnimation(anim);
        }
    }
}
