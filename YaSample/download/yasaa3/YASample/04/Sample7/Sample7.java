package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class Sample7 extends Activity
{
    TextView tv;
    ListView lv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);
        tv.setText("いらっしゃいませ。");

        lv = new ListView(this);
        String[] str = {"乗用車","トラック","オープンカー",
                "タクシー","スポーツカー","ミニカー",
                "自転車","三輪車","バイク",
                "飛行機","ヘリコプター","ロケット"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>
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
}
