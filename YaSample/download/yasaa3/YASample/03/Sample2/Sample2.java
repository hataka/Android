package ya.sample;

import android.app.*;
import android.os.*;
import android.widget.*;

public class Sample2 extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        Button[] bt = new Button[10];

        for(int i=0; i<bt.length; i++)
        {
            bt[i] = new Button(this);
            bt[i].setText(Integer.toString(i));
            ll.addView(bt[i]);
        }
    }
}
