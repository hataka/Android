// -*- mode: java -*-  Time-stamp: <2012-02-06 8:21:11 kahata>
/*================================================================
 * title: 
 * file: IntentMail02.java
 * created: Time-stamp: <2012-02-06 8:21:11 kahata>
 * link: 
 * description: メールに画像を添付する
 * 最終更新：moonlight_aska 2011年09月17日(土) 16:59:48履歴
 * インテント(Intent)を利用することで, ファイルを添付してメール作成画面を表示することができる.
 * ファイル添付
 * IntentMail02.java
 * インテントのインスタンスを生成する.
 * Intent#setActionメソッドを使って, アクションにACTION_SENDを設定する.
 * Intent#putExtraメソッドを使って, メールの各項目のデータを設定する.(オプション)
 * EXTRA_EMAIL : 宛先のメールアドレス
 * EXTRA_CC : CCするメールアドレス
 * EXTRA_BCC : BCCするメールアドレス
 * EXTRA_SUBJECT : 件名
 * EXTRA_TEXT : 本文
 * EXTRA_STREAM : 添付ファイル
 * 		注) CC, BCCについては, Yahoo!メールヘルプ参照.
 * startActivityメソッドを使って, メールを起動する.
 *================================================================*/

package com.moonlight_aska.android.intentMail02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentMail02Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent();
				// インテントにアクション及び送信情報をセット
				intent.setAction(Intent.ACTION_SEND);
				String[] mailto = {"xxx@gmail.com"};
				intent.putExtra(Intent.EXTRA_EMAIL, mailto);
				intent.putExtra(Intent.EXTRA_SUBJECT, "TEST");
				// 画像を添付
				intent.setType("image/jpeg");
				//intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/DCIM/101SHARP/DSC_0001.JPG"));
				intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///Removable/MicroSD/Pictures/博幹/博幹201005宇治/DSCF0730.jpg"));
				// メール起動
				startActivity(intent);
			}
		});
	}
}
