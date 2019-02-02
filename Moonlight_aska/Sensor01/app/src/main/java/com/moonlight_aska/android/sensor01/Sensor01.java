/*
 * Sensor01 センサーの一覧を取得する ハードウェア
 */
package com.moonlight_aska.android.sensor01;

import java.util.List;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Sensor01 extends Activity {
	private SensorManager manager;
	private TextView nameLists;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		nameLists = (TextView)findViewById(R.id.textView1);
		manager = (SensorManager)getSystemService(SENSOR_SERVICE);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ALL);
		String str = "";
		for(Sensor s : sensors) {
			str += s.getName() + "\n";
		}
		nameLists.setText(str);
	}
}