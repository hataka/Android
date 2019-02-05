package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample3 extends Activity
{
    ImageView iv;
    RadioButton rb1, rb2, rb3;
    RadioGroup rg;
    Bitmap bmp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);
        rb3 = new RadioButton(this);

        rb1.setText("通常");
        rb2.setText("拡大");
        rb3.setText("縮小");

        RadioGroup rg = new RadioGroup(this);

        rg.addView(rb1);
        rg.addView(rb2);
        rg.addView(rb3);

        rb1.setChecked(true);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        iv = new ImageView(this);
        iv.setImageBitmap(bmp);

        ll.addView(rg);
        ll.addView(iv);

        rb1.setOnClickListener(new SampleClickListener());
        rb2.setOnClickListener(new SampleClickListener());
        rb3.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Matrix m = new Matrix();
            if(v == rb1)
            {
                m.postScale(1, 1);
            }
            else if(v == rb2)
            {
                m.postScale(2, 2);
            }
            else if(v == rb3)
            {
                m.postScale(0.5F, 0.5F);
            }
            Bitmap bmp2 = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), m, true);
            iv.setImageBitmap(bmp2);
        }
    }
}
