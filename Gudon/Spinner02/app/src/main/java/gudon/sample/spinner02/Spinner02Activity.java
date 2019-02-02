package gudon.sample.spinner02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class Spinner02Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		final Spinner spinner = new Spinner(this);
		layout.addView(spinner);

		List<HashMap<String, Object>> myData = new ArrayList<HashMap<String, Object>>();
		Map<String, Object> map;

		map = new HashMap<String, Object>();
		map.put("title", "愚鈍人");
		map.put("subtitle", "愚鈍人サイトを表示");
		map.put("text1", "愚鈍人サイトを表示");
		map.put("intent", getIntent(Intent.ACTION_VIEW,
				"http://ichitcltk.hustle.ne.jp/gudon/"));
		myData.add((HashMap<String, Object>) map);

		map = new HashMap<String, Object>();
		map.put("title", "地図");
		map.put("subtitle", "行田市の地図を表示");
		map.put("intent", getIntent(Intent.ACTION_VIEW, "geo:36.2,139.5"));
		myData.add((HashMap<String, Object>) map);

		map = new HashMap<String, Object>();
		map.put("title", "DIAL");
		map.put("subtitle", "DIAL12345678を表示");
		map.put("intent", getIntent(Intent.ACTION_DIAL, "tel:12345678"));
		myData.add((HashMap<String, Object>) map);

		SimpleAdapter adapter = new SimpleAdapter(this, myData,
				R.layout.list_row, new String[] { "title", "subtitle" },
				new int[] { R.id.title, R.id.subtitle });
		spinner.setAdapter(adapter);

		Button button = new Button(this);
		button.setText("実行");
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Map<String, Object> item = (Map<String, Object>) spinner
						.getSelectedItem();
				startActivity((Intent) item.get("intent"));

			}
		});
		layout.addView(button);

	}

	private Intent getIntent(String action, String uriString) {
		return new Intent(action, Uri.parse(uriString));
	}
}
