package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu2 extends Activity
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

        bt.setOnTouchListener(new SampleTouchListener());
    }

    class SampleTouchListener implements OnTouchListener
    {
        public boolean onTouch(View v, MotionEvent e)
        {
            if(e.getAction() == MotionEvent.ACTION_DOWN)
            {
                bt.setText("こんにちは");
            }
            else if(e.getAction() == MotionEvent.ACTION_UP)
            {
                bt.setText("さようなら");
            }
            return true;
        }
    }
}
