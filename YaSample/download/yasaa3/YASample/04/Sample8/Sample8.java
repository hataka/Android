package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class Sample8 extends Activity
{
    TextView tv;
    Spinner sp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);

        sp = new Spinner(this);
        String[] str = {"乗用車","トラック","オープンカー",
                "タクシー","スポーツカー","ミニカー",
                "自転車","三輪車","バイク",
                "飛行機","ヘリコプター","ロケット"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, str);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(ad);

        ll.addView(tv);
        ll.addView(sp);

        sp.setOnItemSelectedListener(new SampleItemSelectedListener());
    }
    class SampleItemSelectedListener implements OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?>v, View iv, int pos, long id)
        {
            TextView tmp = (TextView) iv;
            tv.setText(tmp.getText() + "ですね。");
        }
        public void onNothingSelected(AdapterView<?> arg0){}
    }
}
