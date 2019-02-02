// -*- mode: java -*-  Time-stamp: <2012-02-08 4:53:08 kahata>
/*================================================================
 * title: 
 * file: SubActivity.java
 * fileurl: http://localhost/android/Moonlight_aska/MainActivity/src/com/moonlight_aska/android/mainactivity/SubActivity.java
 * created: Time-stamp: <2012-02-08 4:53:08 kahata>
 * link: 
 * description: 


元の画面に戻る
SubActivity.java
元の画面に戻るタイミングで, finishメソッドを呼ぶ.
 *================================================================*/

package com.moonlight_aska.android.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);

		Button btn = (Button)findViewById(R.id.button02_id);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 次画面のアクティビティ終了
				finish();
			}
		});
	}
}