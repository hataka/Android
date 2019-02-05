package ya.sample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample2 extends Activity
{
    Button bt;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        bt = new Button(this);
        bt.setText("検索");

        ll.addView(bt);

        bt.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Intent it = new Intent();
            it.setAction(Intent.ACTION_SEARCH);
            it.putExtra(SearchManager.QUERY, "Android");
            startActivity(it);
        }
    }
}
