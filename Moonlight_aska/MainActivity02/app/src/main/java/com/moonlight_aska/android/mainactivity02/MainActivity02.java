// -*- mode: java -*-  Time-stamp: <2012-02-08 4:47:56 kahata>
/*================================================================
 * title: 
 * file: MainActiviy.java
 * created: Time-stamp: <2012-02-08 4:47:56 kahata>
 * link: 
 * description: 

画面を遷移する
最終更新：moonlight_aska 2012年01月19日(木) 00:00:04履歴
画面の遷移は, 元画面(メイン画面)のアクティビティから次画面(サブ画面)のアクティビティを起動することで実現できる.
他の画面に切り替える

MainActiviy.java
インテントのインスタンスを生成する. ここでは, 元画面のアクティビティのインスタンスと次画面のアクティビティのクラスを明示的に指定する.
startActivityメソッドを使って, 次画面のアクティビティを起動する.
 *================================================================*/

package com.moonlight_aska.android.mainactivity02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MainActivity02 extends Activity {
	private EditText edit = null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		edit = (EditText)findViewById(R.id.edittext01_id);
		Button btn = (Button)findViewById(R.id.button01_id);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(MainActivity02.this, SubActivity02.class);
				//　インテントに値をセット
				intent.putExtra("keyword", edit.getText().toString());
				/// サブ画面の呼び出し
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "WebSite");
		//menu.add(Menu.NONE, 1, Menu.NONE, "SubActivity.java");
		//menu.add(Menu.NONE, 2, Menu.NONE, "res/layout/main.xml");
		//menu.add(Menu.NONE, 3, Menu.NONE, "res/layout/sub.xml");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
				//Uri uri = Uri.parse("http://android.roof-balcony.com/");
				try {
					//Uri uri = Uri.parse("");
					Uri uri = Uri.parse("http://wiki.livedoor.jp/moonlight_aska/d/%b2%e8%cc%cc%b4%d6%a4%c7%a5%c7%a1%bc%a5%bf%a4%f2%bc%f5%a4%b1%c5%cf%a4%b7%a4%b9%a4%eb");
					Intent intent = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(intent);
				}catch (Exception e) {
					Toast.makeText(this,
							e.toString(), Toast.LENGTH_LONG).show();
				}
				break;
		}
		return true;
	}
}
