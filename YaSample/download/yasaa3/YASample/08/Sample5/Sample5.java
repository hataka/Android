package ya.sample;

import android.app.*;
import android.database.*;
import android.os.*;
import android.provider.*;
import android.content.*;
import android.widget.*;

public class Sample5 extends Activity
        implements LoaderManager.LoaderCallbacks<Cursor>
{
    ListView lv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        lv = new ListView(this);
        ll.addView(lv);

        LoaderManager lm = getLoaderManager();
        lm.initLoader(0, null, this);
    }

    public void onLoaderReset(Loader<Cursor> loader){}
    public Loader<Cursor> onCreateLoader(int id, Bundle args)
    {
        CursorLoader cl = new CursorLoader(this, ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        return cl;
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cr)
    {
        ArrayAdapter<String> ad = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1);
        while(cr.moveToNext())
        {
            int i = cr.getColumnIndex("DISPLAY_NAME");
            String str = cr.getString(i);
            ad.add(str);
        }
        cr.close();
        lv.setAdapter(ad);
    }
}
