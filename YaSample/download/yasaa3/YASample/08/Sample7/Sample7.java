package ya.sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class Sample7 extends Activity
{
    public static int SAMPLE_APP = 1;
    ListView lv;
    Button bt1, bt2;
    ArrayList<HashMap<String, String>> data;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        lv = new ListView(this);

        bt1 = new Button(this);
        bt2 = new Button(this);

        bt1.setText("新規");
        bt2.setText("削除");

        data = new ArrayList<HashMap<String, String>>();

        String[] str = {"Title", "Todo"};
        int[] ids = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter ad = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_single_choice, str,ids);
        lv.setAdapter(ad);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ll.addView(bt1);
        ll.addView(bt2);
        ll.addView(lv);

        lv.setOnItemClickListener(new SampleItemClickListener());
        bt1.setOnClickListener(new SampleClickListener());
        bt2.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            if(v == bt1)
            {
                Intent it = new Intent(getApplicationContext(), SampleInput.class);
                int pos = data.size();
                String title = "タイトル";
                String todo = "TODO";
                it.putExtra("Title", title);
                it.putExtra("Todo", todo);
                it.putExtra("Pos", pos);
                startActivityForResult(it, SAMPLE_APP);
            }
            else if(v == bt2)
            {
                int pos = lv.getCheckedItemPosition();
                if(pos >= 0)
                {
                    data.remove(pos);
                    SimpleAdapter ad = (SimpleAdapter) lv.getAdapter();
                    ad.notifyDataSetChanged();
                    lv.setItemChecked(-1, true);
                }
            }
        }
    }
    class SampleItemClickListener implements OnItemClickListener
    {
        public void onItemClick(AdapterView<?>v, View iv, int pos, long id)
        {
            Intent it = new Intent(getApplicationContext(), SampleInput.class);
            HashMap<String, String> hm = data.get(pos);
            String title = hm.get("Title");
            String todo = hm.get("Todo");
            it.putExtra("Title", title);
            it.putExtra("Todo", todo);
            it.putExtra("Pos", pos);
            startActivityForResult(it, SAMPLE_APP);
        }
    }
    public void onActivityResult(int reqcode, int result, Intent it)
    {
        if(reqcode == SAMPLE_APP && result == RESULT_OK)
        {
            String title = it.getStringExtra("Title");
            String todo = it.getStringExtra("Todo");
            int pos = it.getIntExtra("Pos", 0);
            HashMap<String, String> hm= new HashMap<String, String>();
            hm.put("Title", title);
            hm.put("Todo", todo);

            if(pos == data.size())
            {
                data.add(pos, hm);
            }
            else
            {
                data.set(pos, hm);
            }
            SimpleAdapter ad = (SimpleAdapter) lv.getAdapter();
            ad.notifyDataSetChanged();
        }
    }
}
