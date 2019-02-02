// -*- mode: java -*-  Time-stamp: <2012-02-04 18:03:04 kahata>
/*================================================================
 * title: 
 * file: Date01.java
 * created: Time-stamp: <2012-02-04 18:03:04 kahata>
 * link: 
 * description: 現在の日時を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:41:22履歴
 * 現在の日時を取得する方法はいくつかある.
 * ここでは, 3種類の方法を紹介する.
 * Timeクラスの利用
 * android.text.format.Timeクラスを利用することで, 現在の日時を取得することができる.
 * Date01.java
 * Timeクラスのインスタンスを生成する.
 * Timer#setToNowメソッドで, 現在の日時を取得する.
 *================================================================*/

package com.moonlight_aska.android.date01;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.TextView;

public class Date01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView dateText = (TextView)findViewById(R.id.editText1);
		Time time = new Time("Asia/Tokyo");
		time.setToNow();
		String date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" 
						+ time.hour + "時" + time.minute + "分" + time.second + "秒";
		dateText.setText(date);
	}
}
