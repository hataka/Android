package com.moonlight_aska.android.wifimanager01;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WifiManager01 extends Activity implements View.OnClickListener {
	Button btn;
	WifiManager wifi;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
		wifi = (WifiManager)getSystemService(WIFI_SERVICE);
		if(wifi.isWifiEnabled()) {
			btn.setText(R.string.on_label);
		}
		else {
			btn.setText(R.string.off_label);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btn) {
			if(wifi.isWifiEnabled()) {
				// WifiをOnからOffに
				wifi.setWifiEnabled(false);
				btn.setText(R.string.off_label);
			}
			else {
				// WifiをOffからOnに
				wifi.setWifiEnabled(true);
				btn.setText(R.string.on_label);
			}
		}
	}
}