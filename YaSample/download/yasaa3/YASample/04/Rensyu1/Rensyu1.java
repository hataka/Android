package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu1 extends Activity
{
    TextView tv;
    RadioButton rb1, rb2, rb3;
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
        rb3 = new RadioButton(this);

        rb1.setText("青");
        rb2.setText("赤");
        rb3.setText("黄");

        rg = new RadioGroup(this);

        rg.addView(rb1);
        rg.addView(rb2);
        rg.addView(rb3);

        rb1.setChecked(true);
        tv.setTextColor(Color.BLUE);

        ll.addView(tv);
        ll.addView(rg);

        rb1.setOnClickListener(new SampleClickListener());
        rb2.setOnClickListener(new SampleClickListener());
        rb3.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            int c = 0;
            if(v == rb1)
            {
                c = Color.BLUE;
            }
            else if(v == rb2)
            {
                c = Color.RED;
            }
            else if(v == rb3)
            {
                c = Color.YELLOW;
            }
            tv.setTextColor(c);
        }
    }
}

