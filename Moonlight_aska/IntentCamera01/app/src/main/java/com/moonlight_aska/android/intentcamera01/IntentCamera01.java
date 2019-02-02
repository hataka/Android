// -*- mode: java -*-  Time-stamp: <2012-02-06 8:45:35 kahata>
/*================================================================
 * title: 
 * file: IntentCamera01.java
 * created: Time-stamp: <2012-02-06 8:45:35 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%ab%a5%e1%a5%e9%a5%a2%a5%d7%a5%ea%a4%f2%b8%c6%a4%d3%bd%d0%a4%b9
 * description: カメラアプリを呼び出す
最終更新：moonlight_aska 2011年09月18日(日) 17:24:33履歴
インテント(Intent)を利用することで, カメラアプリを呼び出して写真を撮影し, 撮影した画像を取得することができる.
カメラアプリの起動
インテントのインスタンスを生成する.
Intent#setActionメソッドを使って, アクションに"android.media.action.IMAGE_CAPTURE"を設定する.
startActivityメソッドを使って, カメラアプリを起動する.
写真データを受け取るために, onActivityResultメソッドをオーバーライドする.
リクエストコードをチェックし, カメラアプリからのイベントか判断する.
Intent#getExtras()メソッドを使って, ビットマップデータを取得する.
おかしい→解決
 *================================================================*/

package com.moonlight_aska.android.intentcamera01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class IntentCamera01 extends Activity {
	private static final int REQUEST_IMAGE_CAPTURE = 0;
	private ImageView imgView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imgView = (ImageView)findViewById(R.id.imgview_id);
		// インテントのインスタンス生成
		Intent intent = new Intent();
		// インテントにアクションをセット
		intent.setAction("android.media.action.IMAGE_CAPTURE");
		// カメラアプリ起動
		startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "IntentCamera01.java");
		menu.add(Menu.NONE, 1, Menu.NONE, "AndroidManifest.xml");
		menu.add(Menu.NONE, 2, Menu.NONE, "res/layout/main.xml");
		menu.add(Menu.NONE, 3, Menu.NONE, "res/values/strings.xml");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String url = "http://www.google.co.jp/";
		String msg = "Google";
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
				url = "http://192.168.24.92/android/Moonlight_aska/IntentCamera01/src/com/moonlight_aska/android/intentcamera01/IntentCamera01.java";
				msg = "IntentCamera01.java";
				break;
			case 1:
				url= "http://192.168.24.92/android/Moonlight_aska/IntentCamera01/AndroidManifest.xml";
				msg = "AndroidManifest.xml";
				break;
			case 2:
				url= "http://192.168.24.92/android/Moonlight_aska/IntentCamera01/res/layout/main.xml";
				msg = "res/layout/main.xml";
				break;
			case 3:
				url= "http://192.168.24.92/android/Moonlight_aska/IntentCamera01/res/values/strings.xml";
				msg = "res/values/strings.xml";
				break;
			default:
				break;
		}
		// 指定したURLをWebviewに読み込む
		Uri uri = Uri.parse(url);
		Intent i = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(i);
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			try {
				// 画像データの取得
				Bitmap img = (Bitmap)data.getExtras().get("data");
				imgView.setImageBitmap(img);
			} catch (Exception e) {

			}
		}
	}
}
