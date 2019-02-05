package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.widget.*;

public class Rensyu1 extends Activity
{
    ImageView iv;
    Bitmap bmp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER);
        setContentView(ll);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);

        iv = new ImageView(this);
        iv.setImageBitmap(bmp);

        ll.addView(iv);

        iv.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            ImageView tmp = (ImageView) v;
            TranslateAnimation anim = new TranslateAnimation(400, 0, 0, 0);
            anim.setInterpolator(getBaseContext(),
                    android.R.anim.accelerate_decelerate_interpolator);
            anim.setDuration(1000);
            tmp.startAnimation(anim);
        }
    }
}
