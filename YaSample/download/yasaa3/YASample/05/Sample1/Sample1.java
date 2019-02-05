package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample1 extends Activity
{
    ImageView[] iv = new ImageView[3];

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER);
        setContentView(ll);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);

        for(int i=0; i<iv.length; i++)
        {
            iv[i]= new ImageView(this);
            iv[i].setImageBitmap(bmp);
            ll.addView(iv[i]);
        }
    }
}
