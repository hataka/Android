package ya.sample;

import java.util.*;

import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

public class Rensyu2 extends AppWidgetProvider
{
    public void onUpdate(Context cn, AppWidgetManager am, int[] ids)
    {
        RemoteViews rv = new RemoteViews(cn.getPackageName(), R.layout.widget);

        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        int h = cl.get(Calendar.HOUR_OF_DAY);

        String str = "あいさつ";

        if(6 <= h && h <= 10)
        {
            str = "おはよう";
        }
        else if(11 <= h && h <= 15)
        {
            str = "こんにちは";
        }
        else if(16 <= h && h <= 20)
        {
            str = "また明日";
        }
        else if(21 <= h && h <= 23)
        {
            str = "おやすみ";
        }
        else if(0 <= h && h <= 5)
        {
            str = "ZZZ...";
        }

        rv.setTextViewText(R.id.SampleTextView, str);
        rv.setTextColor(R.id.SampleTextView, Color.BLACK);
        am.updateAppWidget(ids, rv);

    }
}
