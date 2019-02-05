package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample2 extends Activity
{
    ImageView iv;
    Bitmap bmp;
    Matrix m;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER);
        setContentView(ll);

        iv = new ImageView(this);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        iv.setImageBitmap(bmp);

        m = new Matrix();

        ll.addView(iv);

        iv.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            m.postRotate(90);
            Bitmap tmp = Bitmap.createBitmap
                    (bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), m, true);
            iv.setImageBitmap(tmp);
        }
    }
}
