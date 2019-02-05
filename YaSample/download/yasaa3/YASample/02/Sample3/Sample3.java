package ya.sample;

import android.app.*;
import android.os.*;
import android.widget.*;

public class Sample3 extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        TextView tv1 = new TextView(this);
        tv1.setText("ようこそアンドロイドへ!");
        TextView tv2 = new TextView(this);
        tv2.setText("アンドロイドをはじめましょう!");

        ll.addView(tv1);
        ll.addView(tv2);
    }
}
