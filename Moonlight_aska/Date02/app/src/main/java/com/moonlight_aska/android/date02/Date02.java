// -*- mode: java -*-  Time-stamp: <2012-02-04 18:05:56 kahata>
/*================================================================
 * title: 
 * file: Date02.java
 * created: Time-stamp: <2012-02-04 18:05:56 kahata>
 * link: 
 * description: 現在の日時を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:41:22履歴
 * 現在の日時を取得する方法はいくつかある.
 * ここでは, 3種類の方法を紹介する.
 * Dateクラスの利用
 * java.util.Dateクラスを利用することで, 現在の日時を取得することができる.
 * また, java.text,SimpleDateFormatを利用することで, 取得した日時を表示用に整形することができる.
 * Date02.java
 * Dateクラスのインスタンスを生成する.
 * 引数に書式を指定して, SimpleDateFormatクラスのインスタンスを生成する.
 * SimpleDateFormat#formatメソッドで, 文字列に変換する.
 *================================================================*/

package com.moonlight_aska.android.date02;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Date02 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView dateText = (TextView)findViewById(R.id.editText1);
		// 現在の時刻を取得
		Date date = new Date();
		// 表示形式を設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'　kk'時'mm'分'ss'秒'");
		dateText.setText(sdf.format(date));
	}
}
