package ya.sample;

import java.text.*;
import java.util.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class Sample11 extends Activity
{
    TextView tv;
    ListView lv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        String[] str = new String[50];

        tv = new TextView(this);
        lv = new ListView(this);

        tv.setText("いらっしゃいませ。");

        SampleAdapter ad = new SampleAdapter
                (this, android.R.layout.simple_list_item_1, str);
        lv.setAdapter(ad);

        ll.addView(tv);
        ll.addView(lv);

        lv.setOnItemClickListener(new SampleItemClickListener());
    }
    class SampleItemClickListener implements OnItemClickListener
    {
        public void onItemClick(AdapterView<?>v, View iv, int pos, long id)
        {
            TextView tmp = (TextView) iv;
            tv.setText(tmp.getText() + "ですね。");
        }
    }
    class SampleAdapter extends ArrayAdapter<String>
    {
        public SampleAdapter(Context cn, int textViewResourceId,
                             String[] objects)
        {
            super(cn, textViewResourceId, objects);
        }
        public View getView(int pos, View convView, ViewGroup parent)
        {

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN);
            Calendar cl = Calendar.getInstance();
            cl.setTime(new Date());
            cl.add(Calendar.DATE, pos);

            TextView t = new TextView(getBaseContext());
            t.setText(df.format(cl.getTime()));
            t.setBackgroundColor(Color.GRAY);
            t.setTextColor(Color.WHITE);

            if(cl.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                t.setBackgroundColor(Color.WHITE);
                t.setTextColor(Color.RED);
            }

            convView = t;

            return convView;
        }
    }
}
