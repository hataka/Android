// -*- mode: java -*-  Time-stamp: <2012-02-04 18:18:38 kahata>
/*================================================================
 * title: 
 * created: Time-stamp: <2012-02-04 18:18:38 kahata>
 * link: 
 * description: 画面の向きを設定する
 * 最終更新：moonlight_aska 2011年09月17日(土) 22:37:38履歴
 * 画面の向きは, 縦/横方向に固定あるいはセンサーによる自動切り換えに設定できる.
 * 設定する方法はいくつかある.
 * Activity#setRequestedOrientationメソッドで設定
 * Activity#setRequestedOrientationメソッドで, 画面の向きを設定する.
 * 値	説明
 * SCREEN_ORIENTATION_PORTRAIT	縦方向
 * SCREEN_ORIENTATION_LANDSCAPE	横方向
 * SCREEN_ORIENTATION_UNSPECIFIED	端末の設定により動作が異なる(デフォルト)
 * SCREEN_ORIENTATION_SENSOR	センサー状態に従う
 * SCREEN_ORIENTATION_UNSENSOR	センダー状態に従わない以外はunspecifiedと同じ
 *================================================================*/

package com.moonlight_aska.android.setorientation;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class SetOrientation extends Activity implements View.OnClickListener {
	private Button btn01 = null;
	private Button btn02 = null;
	private Button btn03 = null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn01 = (Button)findViewById(R.id.button1);
		btn02 = (Button)findViewById(R.id.button2);
		btn03 = (Button)findViewById(R.id.button3);
		btn01.setText("オリエンテーションをPortraitに変更");
		btn02.setText("オリエンテーションをLandscapeに変更");
		btn03.setText("オリエンテーションをSensorに変更");
		btn01.setOnClickListener(this);
		btn02.setOnClickListener(this);
		btn03.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btn01) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
		else if(v == btn02) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		} 
		else if(v == btn03) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		}
	}
}
