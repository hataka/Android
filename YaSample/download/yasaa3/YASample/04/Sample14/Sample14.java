package ya.sample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample14 extends Activity
{
    TextView tv;
    Button bt;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        tv = new TextView(this);
        tv.setText("いらっしゃいませ。");
        bt = new Button(this);
        bt.setText("購入");

        ll.addView(tv);
        ll.addView(bt);

        bt.setOnClickListener(new SampleClickListener());
    }

    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            new AlertDialog.Builder(Sample14.this)
                    .setTitle("確認")
                    .setMessage("本当に購入しますか？")
                    .setPositiveButton("はい", new SampleDialogClickListener())
                    .setNegativeButton("いいえ", null).show();
        }
        class SampleDialogClickListener implements DialogInterface.OnClickListener
        {
            public void onClick(DialogInterface d, int w)
            {
                new AlertDialog.Builder(Sample14.this)
                        .setTitle("購入")
                        .setMessage("ありがとうございます。")
                        .setPositiveButton("OK", null).show();
            }
        }
    }
}
