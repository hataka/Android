package ya.sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.widget.*;

public class Sample1 extends Activity
{
    TextView[] tv = new TextView[3];

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        for(int i=0; i<tv.length; i++)
        {
            tv[i] = new TextView(this);
            tv[i].setText("車はいかがですか？");
        }

        tv[0].setTextColor(Color.BLACK);
        tv[1].setTextColor(Color.BLUE);
        tv[2].setTextColor(Color.RED);

        tv[0].setBackgroundColor(Color.WHITE);
        tv[1].setBackgroundColor(Color.LTGRAY);
        tv[2].setBackgroundColor(Color.WHITE);

        tv[0].setTextSize(14);
        tv[1].setTextSize(16);
        tv[2].setTextSize(18);

        for(int i=0; i<tv.length; i++)
        {
            ll.addView(tv[i]);
        }
    }
}
