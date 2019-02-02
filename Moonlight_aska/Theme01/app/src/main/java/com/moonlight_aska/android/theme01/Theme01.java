// -*- mode: java -*-  Time-stamp: <2012-02-17 13:34:24 kahata>
/*================================================================
 * title: 
 * file: Theme01.java
 * path: F:\android\Moonlight_aska\Theme01\src\com\moonlight_aska\android\theme01\Theme01.java
 * url:  http://192.168.24.92/android/Moonlight_aska/Theme01/src/com/moonlight_aska/android/theme01/Theme01.java
 * created: Time-stamp: <2012-02-17 13:34:24 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%a2%a5%af%a5%c6%a5%a3%a5%d3%a5%c6%a5%a3%a4%cb%c7%d8%b7%ca%b2%e8%c1%fc%a4%f2%c0%df%c4%ea%a4%b9%a4%eb
 * description: アクティビティに背景画像を設定する
 * 元のままでは不具合あり 以下に従って変更
 * http://www.appli-info.jp/archives/202
 *================================================================*/

package com.moonlight_aska.android.theme01;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Theme01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "Theme01.java");
		menu.add(Menu.NONE, 1, Menu.NONE, "AndroidManifest.xml");
		menu.add(Menu.NONE, 2, Menu.NONE, "res/layout/main.xml");
		menu.add(Menu.NONE, 3, Menu.NONE, "res/values/strings.xml");
		menu.add(Menu.NONE, 4, Menu.NONE, "Web Site");
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
				url = "http://192.168.24.92/android/Moonlight_aska/Theme01/src/com/moonlight_aska/android/theme01/Theme01.java";
				msg = "Graphic16C1.java";
				break;
			case 1:
				url= "http://192.168.24.92/android/Moonlight_aska/Theme01/AndroidManifest.xml";
				msg = "AndroidManifest.xml";
				break;
			case 2:
				url= "http://192.168.24.92/android/Moonlight_aska/Theme01/res/layout/main.xml";
				msg = "res/layout/main.xml";
				break;
			case 3:
				url= "http://192.168.24.92/android/Moonlight_aska/Theme01/res/values/strings.xml";
				msg = "res/values/strings.xml";
				break;
			case 4:
				url= "http://www.appli-info.jp/archives/202";
				msg = "Web Site";
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
}