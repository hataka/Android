package gudon.sample.layout03;

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
		LayoutParams lp1 = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		layout.addView(button1, lp1);

		Button button2 = new Button(this);
		button2.setText("数値で指定");
		LayoutParams lp2 = new LayoutParams(200, 100);
		layout.addView(button2, lp2);

		Button button3 = new Button(this);
		button3.setText("fill_parent");
		LayoutParams lp3 = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		layout.addView(button3, lp3);
	}
}



