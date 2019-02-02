package gudon.sample.spinner01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner01Activity extends Activity {
	private String[] mStrings = { "aaa", "abc", "bbb", "ccc" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		Spinner spinner = new Spinner(this);
		layout.addView(spinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mStrings);
		spinner.setAdapter(adapter);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setPrompt("以下のリストより選択して下さい。");
		spinner.setSelection(1);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent,
					View view, int position, long id) {
				Spinner spinner = (Spinner) parent;
				String item = (String) spinner.getSelectedItem();
				Toast.makeText(Spinner01Activity.this,
						String.format("%sが選択されました。", item),
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Toast.makeText(Spinner01Activity.this,
						"onNothingSelected", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
