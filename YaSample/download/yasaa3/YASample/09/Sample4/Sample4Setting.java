package ya.sample;

import java.util.*;
import android.app.*;
import android.appwidget.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample4Setting extends Activity
{
    Button bt;
    EditText et;
    static HashMap<Integer, String> mp = new HashMap<Integer, String>();
    int id;
    String str;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        Intent it = getIntent();
        Bundle ex = it.getExtras();
        id = ex.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);

        bt = new Button(this);
        bt.setText("設定");

        et = new EditText(this);

        if(!mp.containsKey(id))
        {
            str = "MEMO";
        }
        else
        {
            str = (String) mp.get(id);
        }

        et.setText(str);

        ll.addView(et);
        ll.addView(bt);

        bt.setOnClickListener(new SampleClickListener());
    }
    class SampleClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Context cn = getBaseContext();
            RemoteViews rv = new RemoteViews(cn.getPackageName(),R.layout.widget);

            String str = et.getText().toString();
            mp.put(id, str);

            rv.setTextViewText(R.id.SampleTextView, str);

            AppWidgetManager am = AppWidgetManager.getInstance(cn);
            am.updateAppWidget(id, rv);
            finish();
        }
    }
}
