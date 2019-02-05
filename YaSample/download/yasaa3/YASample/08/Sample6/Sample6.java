package ya.sample;

import java.io.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample6 extends Activity
{
    public static int SAMPLE_APP = 1;
    Button bt;

    ImageView iv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        bt = new Button(this);
        iv = new ImageView(this);

        bt.setText("選択");

        ll.addView(bt);
        ll.addView(iv);

        bt.setOnClickListener(new SampleClickListener());
    }
    public void onActivityResult(int reqcode, int result, Intent it)
    {
        if(reqcode == SAMPLE_APP && result == RESULT_OK)
        {
            Uri u = it.getData();
            try
            {
                InputStream is = getContentResolver().openInputStream(u);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                iv.setImageBitmap(bmp);
            }
            catch(Exception e){}
        }
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Intent it = new Intent();
            it.setType("image/*");
            it.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(it, SAMPLE_APP);
        }
    }
}