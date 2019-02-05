package ya.sample;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample1 extends Activity
{
    Button bt;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        bt = new Button(this);
        bt.setText("電話");

        ll.addView(bt);

        bt.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Intent it = new Intent();
            it.setAction(Intent.ACTION_VIEW);
            it.setData(Uri.parse("tel:12345678"));
            startActivity(it);
        }
    }
}

