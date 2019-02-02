package gudon.sample.sqlite02;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SQLite02Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PersonOpenHelper helper = new PersonOpenHelper(this);
		SQLiteDatabase db = helper.getReadableDatabase();

		//Cursor c = db.query("person_table", new String[] {"_id","name","age"}, null, null, null, null, null);
		Cursor c = db.rawQuery("select rowid as _id, name, age from person_table",null);
		startManagingCursor(c);

		ListAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, c,
                        new String[] { "name", "age" },
                        new int[] { android.R.id.text1, android.R.id.text2 });

		ListView lv = new ListView(this);
        lv.setAdapter(adapter);
		setContentView(lv);
    }
}
