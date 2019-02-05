package ya.sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample12 extends Activity
{
    TextView tv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TableLayout tl = new TableLayout(this);
        setContentView(tl);

        tv = new TextView(this);
        tv.setText("いらっしゃいませ。");

        tl.addView(tv);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(Menu.NONE, 0, 0, "乗用車");
        menu.add(Menu.NONE, 1, 1, "タクシー");
        menu.add(Menu.NONE, 2, 2, "スーパーカー");
        menu.add(Menu.NONE, 3, 3, "オープンカー");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        String str = null;
        switch(mi.getItemId())
        {
            case 0:
                str = "乗用車";
                break;
            case 1:
                str = "タクシー";
                break;
            case 2:
                str = "スーパーカー";
                break;
            case 3:
                str = "オープンカー";
                break;
        }
        tv.setText(str + "ですね。");

        return true;
    }
}
