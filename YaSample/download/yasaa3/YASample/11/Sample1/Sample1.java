package ya.sample;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample1 extends Activity
{
    Button bt;
    TextView[] tv = new TextView[3];
    EditText[] et = new EditText[3];

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TableLayout tl = new TableLayout(this);
        setContentView(tl);

        Button bt = new Button(this);

        for(int i=0; i<tv.length; i++)
        {
            tv[i] = new TextView(this);
        }

        for(int i=0; i<et.length; i++)
        {
            et[i] = new EditText(this);
            et[i].setWidth(300);
        }

        tv[0].setText("宛先");
        tv[1].setText("タイトル");
        tv[2].setText("本文");
        et[2].setLines(5);

        bt.setText("送信");

        TableRow[] tr = new TableRow[3];

        for(int i=0; i<tr.length; i++)
        {
            tr[i] = new TableRow(this);
            tr[i].addView(tv[i]);
            tr[i].addView(et[i]);
            tl.addView(tr[i]);
        }

        tl.addView(bt);
        bt.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Intent it = new Intent();
            it.setAction(Intent.ACTION_SENDTO);
            it.setData(Uri.parse( "mailto:" + et[0].getText().toString()));
            it.putExtra(Intent.EXTRA_SUBJECT, et[1].getText().toString());
            it.putExtra(Intent.EXTRA_TEXT, et[2].getText());
            startActivity(it);
        }
    }
}
