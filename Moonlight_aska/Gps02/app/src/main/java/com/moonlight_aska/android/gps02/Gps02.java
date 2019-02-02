package com.moonlight_aska.android.gps02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gps02 extends Activity implements View.OnClickListener{
	private Button btn;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
		btn.setText(R.string.sw_label); 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btn) {
			Uri uri = Uri.parse("custom:3");
			Intent intent = new Intent().setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider")
				.addCategory(Intent.CATEGORY_ALTERNATIVE)
				.setData(uri);
			sendBroadcast(intent);
		}
	}
}
