// -*- mode: java -*-  Time-stamp: <2012-02-04 18:08:08 kahata>
/*================================================================
 * title: 
 * file: Date03.java
 * created: Time-stamp: <2012-02-04 18:08:08 kahata>
 * link: 
 * description: 現在の日時を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:41:22履歴
 * 現在の日時を取得する方法はいくつかある.
 * ここでは, 3種類の方法を紹介する.
 * Calendarクラスの利用
 * java.util.Calendarクラスを利用することで, 現在の日時を取得することができる.
 * Date03.java
 * Calendarクラスのインスタンスを生成する.
 * Calendar#getメソッドの引数に取得したい項目を設定して, 値を取得する.
 *================================================================*/

package com.moonlight_aska.android.date03;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Date03 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView dateText = (TextView)findViewById(R.id.editText1);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);	// 0 - 11
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String date = year + "年" + (month+1) + "月" + day + "日　"
						+ hour + "時" + minute + "分" + second + "秒";
		dateText.setText(date);
	}
}
