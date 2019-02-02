package com.moonlight_aska.android.intent02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intent02 extends Activity {
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
				// インテントのインスタンス生成
				Intent intent = new Intent();
				// インテントにアクション及びURLをセット
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.google.com"));
				// ブラウザ起動
				startActivity(intent);
			}
		});
	}
}