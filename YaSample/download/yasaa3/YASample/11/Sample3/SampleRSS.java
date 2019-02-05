package ya.sample;

import java.io.*;
import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class SampleRSS extends Activity
{
    public static int SAMPLE_APP = 1;

    ListView lv;
    Intent it;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);

        it = getIntent();

        lv = new ListView(this);

        ArrayList<String> list = new ArrayList<String>();

        try
        {
            FileInputStream fis = openFileInput("SampleRSS.txt");
            BufferedReader br = new  BufferedReader(new InputStreamReader(fis));
            String str;
            while((str = br.readLine()) != null)
            {
                list.add(str);
            }
        }
        catch(Exception e){}

        ArrayAdapter<String> ad = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(ad);

        ll.addView(lv);

        lv.setOnItemClickListener(new SampleItemClickListener());
    }
    class SampleItemClickListener implements OnItemClickListener
    {
        public void onItemClick(AdapterView<?>v, View iv, int pos, long id)
        {
            TextView tmp = (TextView) iv;
            String str  = (String) tmp.getText();

            it.putExtra("URL", str);
            setResult(RESULT_OK, it);
            finish();
        }
    }
}
