// -*- mode: java -*-  Time-stamp: <2012-02-04 18:00:17 kahata>
/*================================================================
 * title: 
 * file: Orientation.java
 * created: Time-stamp: <2012-02-04 18:00:17 kahata>
 * link: 
 * description: 画面の向きを取得する
 * 最終更新：moonlight_aska 2011年09月17日(土) 23:15:51履歴
 * 現在の画面の向きを取得するには, コンフィギュレーション(Configuration)クラスを利用する.
 * 画面向きの取得
 * getResourcesメソッドで, Resourcesクラスのインスタンスを取得する.
 * Resources#getConfigurationメソッドで, Configurationクラスのインスタンスを取得する.
 * Configuration.orientationフィールドを調べる.
 *================================================================*/

package com.moonlight_aska.android.orientation;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class Orientation extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView text = (TextView)findViewById(R.id.textView1);
		Resources resources = getResources();
		Configuration config = resources.getConfiguration();
		String str;
		switch(config.orientation) {
		case Configuration.ORIENTATION_PORTRAIT:
			str = "縦方向";
			break;
		case Configuration.ORIENTATION_LANDSCAPE:
			str = "横方向";
			break;
		default :
			str = "デフォルト";
		}
		text.setText(str);
	}
}
