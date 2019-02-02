package gudon.sample.listview02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView02 extends Activity {
	private String[] mStrings = { "aaa", "abc", "bbb", "ccc" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListView lv = new ListView(this);
		setContentView(lv);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_row, mStrings);
		lv.setAdapter(adapter);
	}
}
