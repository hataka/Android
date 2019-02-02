// -*- mode: java -*-  Time-stamp: <2012-02-03 15:59:20 kahata>
/*================================================================
 * title: 
 * file: AlertDialog01.java
 * created: Time-stamp: <2012-02-03 15:59:20 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%a2%a5%e9%a1%bc%a5%c8%a5%c0%a5%a4%a5%a2%a5%ed%a5%b0%a4%f2%c9%bd%bc%a8%a4%b9%a4%eb
 * description: アラートダイアログを表示する
 * 最終更新：moonlight_aska 2011年10月16日(日) 22:46:40履歴
 * アラートダイアログは, 主に警告メッセージや確認メッセージを表示するために使用するダイアログである.
 * 最大3つまでのボタンを配置したアラートダイアログ
 * AlertDialog.Builderを生成する.
 * setTitleメソッドでタイトルを設定する.
 * setMessageメソッドで本文を設定する.
 * setPositiveButton/setNeutralButton/setNegativeButtonメソッドでボタンに表示する文字列と,
 * 押した時のリスナーを設定する.
 * createメソッドでアラートダイアログを生成する.
 * showメソッドでアラートダイアログを表示する.
 *================================================================*/

package com.moonlight_aska.android.alertdialog01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AlertDialog01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(AlertDialog01.this)
				.setTitle("アラートダイアログ")
				.setMessage("どれかボタンを押してください.")
				// 肯定的な意味を持つボタンを設定
				.setPositiveButton("Positive", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						// Positive Buttonが押された時の処理を記述{
						Log.v("Alert", "Positive Button");
					}
				})
				// 中立的な意味を持つボタンを設定
				.setNeutralButton("Neutral", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						// Neutral Buttonが押された時の処理を記述
						Log.v("Alert", "Nuetral Button");
					}
				})
				// 否定的な意味を持つボタンを設定
				.setNegativeButton("Negative", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						// Negative Buttonが押された時の処理を記述
						Log.v("Alert", "Negative Button");
					}
				})
				.create()
				.show();
			}
		});
	} 
}