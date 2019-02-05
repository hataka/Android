package ya.sample;

import java.io.*;
import java.util.*;
import android.app.*;
import android.os.*;
import android.widget.*;
public class Rensyu2 extends Activity
{
    ListView lv;
    ArrayList<HashMap<String, String>> data;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        setContentView(ll);

        ListView lv = new ListView(this);

        File fl = new File("data/data/" + getPackageName());
        data = new ArrayList<HashMap<String, String>>();

        File[] list = fl.listFiles();

        for(int i=0; i<list.length; i++)
        {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("name", list[i].getName());
            hm.put("info", list[i].length() + "bytes");
            data.add(hm);
        }

        String[] str = {"name", "info"};
        int[] ids = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter ad = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2, str, ids);
        lv.setAdapter(ad);
        ll.addView(lv);

    }
}
