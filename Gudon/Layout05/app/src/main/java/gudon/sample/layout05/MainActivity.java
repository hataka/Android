package gudon.sample.layout05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams lp0 = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		setContentView(layout, lp0);

		Button button1 = new Button(this);
		button1.setText("wrap_content");
		button1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
			LayoutParams.WRAP_CONTENT));
		layout.addView(button1);

		Button button2 = new Button(this);
		button2.setText("数値で指定");
		button2.setLayoutParams(new LayoutParams(200, 100));
		layout.addView(button2);

		Button button3 = new Button(this);
		button3.setText("fill_parent");
		button3.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
			LayoutParams.FILL_PARENT));
		layout.addView(button3);
	}
}
