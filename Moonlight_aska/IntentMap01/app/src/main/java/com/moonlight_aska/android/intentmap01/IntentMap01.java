// -*- mode: java -*-  Time-stamp: <2012-02-06 8:37:00 kahata>
/*================================================================
 * title: 
 * file: IntentMap01.java
 * created: Time-stamp: <2012-02-06 8:37:00 kahata>
 * link: 
 * description: 

地図を表示する
最終更新：moonlight_aska 2011年09月17日(土) 20:03:52履歴
  

インテント(Intent)を利用することで, 地図を表示することができる.



地図の表示
IntentMap01.java
インテントのインスタンスを生成する.
Intent#satActionメソッドを使って, アクションにACTION_VIEWを設定する.
Intent#setDataメソッドを使って, 位置情報を設定する.
geo:latitude,longitude
geo:latitude,longitude?z=zoom (zoom=1～23)
geo:0,0?q=住所
				：
startActivityメソッドを使って, Googleマップを起動する.
 *================================================================*/
package com.moonlight_aska.android.intentmap01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentMap01 extends Activity {
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
				// インテントにアクション及び位置情報をセット
				intent.setAction(Intent.ACTION_VIEW);
				//intent.setData(Uri.parse("geo:0,0?q=奈良県大和郡山市"));
				intent.setData(Uri.parse("geo:0,0?q=京都府久世郡久御山町栄"));
				// Googleマップ起動
				startActivity(intent);
			}
		});
	}
}
