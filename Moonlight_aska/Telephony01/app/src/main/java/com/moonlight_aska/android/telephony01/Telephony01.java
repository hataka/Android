package com.moonlight_aska.android.telephony01;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView; 

public class Telephony01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView text = (TextView)findViewById(R.id.textView1);
		TelephonyManager manager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		text.setText("識別番号:" + manager.getDeviceId());
	}
}