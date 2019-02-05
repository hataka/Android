package ya.sample;

import java.io.*;
import android.app.*;
import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample5Setting extends Activity
{
    public static int SAMPLE_APP = 1;
    Button bt;
    ImageView iv;
    int id;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        iv = new ImageView(this);
        bt = new Button(this);

        bt.setText("選択");

        ll.addView(iv);
        ll.addView(bt);
        Intent it = getIntent();
        Bundle ex = it.getExtras();

        id = ex.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);

        bt.setOnClickListener(new SampleClickListener());
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
    public void onActivityResult(int reqcode, int result, Intent it)
    {
        if(reqcode == SAMPLE_APP && result == RESULT_OK)
        {
            try
            {
                Uri u = it.getData();
                InputStream is = getContentResolver().openInputStream(u);
                Bitmap bmp = BitmapFactory.decodeStream(is);

                Context cn = getBaseContext();
                RemoteViews rv = new RemoteViews(cn.getPackageName(),R.layout.widget);
                rv.setImageViewBitmap(R.id.SampleImageView, bmp);
                AppWidgetManager am = AppWidgetManager.getInstance(cn);
                am.updateAppWidget(id, rv);
                finish();
            }
            catch(Exception e){}
        }
    }
}
