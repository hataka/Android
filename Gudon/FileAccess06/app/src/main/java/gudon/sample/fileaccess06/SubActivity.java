package gudon.sample.fileaccess06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

       //DoSuCommand su = new DoSuCommand();
       //su.init();

		String filePath = getIntent().getExtras().getString("filePath");

		TextView tvPath = new TextView(this);
		tvPath.setText(filePath);
		layout.addView(tvPath);

		ScrollView scrollView = new ScrollView(this);
		layout.addView(scrollView);

		TextView tv = new TextView(this);
		scrollView.addView(tv);

		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(fileReader);
			String line;
			StringBuilder lines = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				lines.append(line).append('\n');
			}
			reader.close();

			tv.setText(lines);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(),
					"ファイルの読込みに失敗しました。\n" + e.getMessage(), Toast.LENGTH_LONG)
					.show();
		}

	}
}
