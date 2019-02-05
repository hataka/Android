package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample5 extends Activity
{
    TextView tv;
    RadioButton rb1, rb2;
    RadioGroup rg;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);
        tv.setText("いらっしゃいませ。");

        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);

        rb1.setText("車");
        rb2.setText("トラック");

        rg = new RadioGroup(this);

        rg.addView(rb1);
        rg.addView(rb2);

        rb1.setChecked(true);

        ll.addView(tv);
        ll.addView(rg);

        rb1.setOnClickListener(new SampleClickListener());
        rb2.setOnClickListener(new SampleClickListener());
    }

    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            RadioButton tmp = (RadioButton) v;
            tv.setText(tmp.getText() + "を選びました。");
        }
    }
}
