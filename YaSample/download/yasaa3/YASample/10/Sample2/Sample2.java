package ya.sample;

import java.io.*;
import android.app.*;
import android.os.*;
import android.widget.*;

public class Sample2 extends Activity
{
    ListView lv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        setContentView(ll);

        ListView lv = new ListView(this);

        File fl = new File("data/data/" + getPackageName());

        String[] str = fl.list();

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        lv.setAdapter(ad);

        ll.addView(lv);

    }
}
