package gudon.sample.OtherActivity3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		Intent intent = getIntent();
		int iValue = intent.getIntExtra("int Value", -1);
		CharSequence strValue = intent.getCharSequenceExtra("String Value");
		Person person = (Person) intent.getSerializableExtra("Person Object");

		TextView tv = new TextView(this);
		//tv.setText(String.format("iValue=%d\nstrValue=%s\nperson=%s", iValue,
		//		strValue.toString(), person.toString()));
		layout.addView(tv);

		Button button = new Button(this);
		button.setText("戻る");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		layout.addView(button);
	}

}
