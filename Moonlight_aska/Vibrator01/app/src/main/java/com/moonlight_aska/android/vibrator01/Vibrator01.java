package com.moonlight_aska.android.vibrator01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class Vibrator01 extends Activity implements View.OnClickListener{
	private Button btn01, btn02, btn03;
	private Vibrator vib;
	private long pattern[] = {1000, 200, 700, 200, 400, 200 };
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn01 = (Button)findViewById(R.id.button1);
		btn01.setOnClickListener(this);
		btn02 = (Button)findViewById(R.id.button2);
		btn02.setOnClickListener(this);
		btn03 = (Button)findViewById(R.id.button3);
		btn03.setOnClickListener(this);
		// Vibratorクラスのインスタンス取得
		vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub;
		if(v == btn01) {
			vib.vibrate(5000);	// 指定時間ONする
		}
		else if(v == btn02) {
			vib.vibrate(pattern, 0);	// パターンを繰り返す
		}
		else if(v == btn03) {
			vib.cancel();	// 止める
		}
	}
}