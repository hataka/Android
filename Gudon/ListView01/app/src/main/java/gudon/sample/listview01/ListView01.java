package gudon.sample.listview01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView01 extends Activity {
	private String[] mStrings = { "aaa", "abc", "bbb", "ccc" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ListView lv = new ListView(this);
		setContentView(lv);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mStrings);
		lv.setAdapter(adapter);
		// lv.setSelection(1);
		// lv.setTextFilterEnabled(true);
	}
}
