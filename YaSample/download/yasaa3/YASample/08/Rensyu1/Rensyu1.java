package ya.sample;

import android.app.*;
import android.database.*;
import android.os.*;
import android.provider.*;
import android.content.*;
import android.widget.*;

public class Rensyu1 extends Activity
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

      getLoaderManager().initLoader(0, null, this);
   }

   public void onLoaderReset(Loader<Cursor> loader){}
   public Loader<Cursor> onCreateLoader(int id, Bundle args)
   {
      CursorLoader cl = new CursorLoader(this, ContactsContract.CommonDataKinds.Email.CONTENT_URI,
              null, null, null, null);
      return cl;
   }

   public void onLoadFinished(Loader<Cursor> loader, Cursor cr)
   {
      ArrayAdapter<String> ad = new ArrayAdapter<String>
              (this, android.R.layout.simple_list_item_1);
      while(cr.moveToNext())
      {
         int in = cr.getColumnIndex("DISPLAY_NAME");
         int id = cr.getColumnIndex("DATA1");
         String str1 = cr.getString(in);
         String str2 = cr.getString(id);
         ad.add(str1 + "\n" +str2);
      }
      cr.close();
      lv.setAdapter(ad);
   }
}
