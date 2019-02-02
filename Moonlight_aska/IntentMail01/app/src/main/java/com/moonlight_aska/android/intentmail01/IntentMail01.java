// -*- mode: java -*-  Time-stamp: <2012-02-06 7:37:56 kahata>
/*================================================================
 * title: 
 * file: IntentMail01.java
 * created: Time-stamp: <2012-02-06 7:37:56 kahata>
 * link: 
 * description: メールを呼び出す
 * 最終更新：moonlight_aska 2011年09月24日(土) 10:12:07履歴
 * インテント(Intent)を利用することで, メール作成画面を呼び出して表示することができる.
 * メールの呼出
 * IntentMail01.java
 * インテントのインスタンスを生成する.
 * Intent#setActionメソッドを使って, アクションにACTION_SENDTOを設定する.
 *Intent#setDataメソッドを使って, 宛先のメールアドレスを設定する. (必須)
 *		注) 複数人に同時に送信する場合, "mailto:xxx@gmail.com, yyy@yahoo.co.jp"といった風に記述する.
 * Intent#putExtraメソッドを使って, メールの各項目のデータを設定する. (オプション)
 * EXTRA_CC : CCするメールアドレス
 * EXTRA_BCC : BCCするメールアドレス
 * EXTRA_SUBJECT : 件名
 * EXTRA_TEXT : 本文
 *		注1) CC, BCCについては, Yahoo!メールヘルプ参照.
 * 		注2) EXTRA_STREAMを使ったファイル添付はできない. ファイル添付する場合はメールに画像を添付するを参照.
 * startActivityメソッドを使って, メールを起動する.
 *================================================================*/
package com.moonlight_aska.android.intentmail01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentMail01 extends Activity {
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
				intent.setAction(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("mailto:xxx@gmail.com"));
				intent.putExtra(Intent.EXTRA_SUBJECT, "TEST");
				intent.putExtra(Intent.EXTRA_TEXT, "これはテストメールです.");
				// メール起動
				startActivity(intent);
			}
		});
	}
}
