package gudon.sample.layout06;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import android.view.View;
import android.widget.Toast;

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
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String msg = String.format("[%d , %d]\n", v.getWidth(),v.getHeight());
				Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
				//System.out.printf("[%d , %d]\n", v.getWidth(),v.getHeight());
			}
		});

		Button button2 = new Button(this);
		button2.setText("数値で指定");
		button2.setLayoutParams(new LayoutParams(200, 100));
		layout.addView(button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String msg = String.format("[%d , %d]\n", v.getWidth(),v.getHeight());
				Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
				//System.out.printf("[%d , %d]\n", v.getWidth(),v.getHeight());
			}
		});

		Button button3 = new Button(this);
		button3.setText("fill_parent");
		button3.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
			LayoutParams.FILL_PARENT));
		layout.addView(button3);
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String msg = String.format("[%d , %d]\n", v.getWidth(),v.getHeight());
				Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
				//System.out.printf("[%d , %d]\n", v.getWidth(),v.getHeight());
			}
		});

	}
}
