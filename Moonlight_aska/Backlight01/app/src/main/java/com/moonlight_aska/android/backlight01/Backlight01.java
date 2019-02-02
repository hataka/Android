package com.moonlight_aska.android.backlight01;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Backlight01 extends Activity implements View.OnClickListener {
	Button btn;
	boolean flag = false;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btn) {
			if(flag == false) {
				// 常時ONに設定
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				btn.setText(R.string.off_label);
				flag = true;
			}
			else {
				// 自動消灯ONに設定
				getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				btn.setText(R.string.on_label);
				flag = false;
			}
		}
	}
}