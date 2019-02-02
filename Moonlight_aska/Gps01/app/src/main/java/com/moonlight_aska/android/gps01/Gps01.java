package com.moonlight_aska.android.gps01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class Gps01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// 位置測位プロバイダー一覧を取得
		String providers = Settings.Secure.getString(
					getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		Log.v("GPS", "Location Providers = " + providers);
		if(providers.indexOf("gps", 0) < 0) {
			// 設定画面の呼出し
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(intent);
		} else {
			Toast.makeText(getApplicationContext(), "GPS : ON", Toast.LENGTH_LONG).show();
		}
	}
}