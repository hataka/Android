package com.moonlight_aska.android.camera01;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.TextView;

public class Camera01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// カメラオープン
		Camera camera = Camera.open();
		// パラメータ取得
		Camera.Parameters params = camera.getParameters();
		String strParams = params.flatten();
		String[] tokens = strParams.split(";");
		strParams = null;
		for(String p : tokens) {
			strParams += p + "\n";
		}
		// パラメータ表示
		TextView text = (TextView)findViewById(R.id.textView1);
		text.setText(strParams);
		// カメラリリース
		camera.release();
	}
}