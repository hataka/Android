package gudon.sample.sqlite01;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SQLite01Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		PersonOpenHelper helper = new PersonOpenHelper(this);
		SQLiteDatabase db = helper.getReadableDatabase();

		Cursor c = db.query("person_table", new String[] { "name", "age" },
				null, null, null, null, null);
		boolean isEof = c.moveToFirst();
		while (isEof) {
			TextView tv = new TextView(this);
			tv.setText(String.format("%s : %d才", c.getString(0), c.getInt(1)));
			isEof = c.moveToNext();
			layout.addView(tv);
		}
		c.close();

		db.close();
	}
}
