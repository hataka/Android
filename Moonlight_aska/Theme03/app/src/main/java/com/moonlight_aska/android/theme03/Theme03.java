// -*- mode: java -*-  Time-stamp: <2012-02-17 14:45:06 kahata>
/*================================================================
 * title: 
 * file: Theme03.java
 * path: F:\android\Moonlight_aska\Theme03\src\com\moonlight_aska\android\theme03\Theme03.java
 * url:  http://localhost/android/Moonlight_aska/Theme03/src/com/moonlight_aska/android/theme03/Theme03.java
 * created: Time-stamp: <2012-02-17 14:45:06 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: 
 * description:  タイトルバーも消す
 * AndroidManifest.xml
 * Activityのtheme属性に, "Theme.Translucent.NoTitleBar"を定義する.
 *================================================================*/

package com.moonlight_aska.android.theme03;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Theme03 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "Web Site");
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
				url= "http://wiki.livedoor.jp/moonlight_aska/d/%a5%a2%a5%af%a5%c6%a5%a3%a5%d3%a5%c6%a5%a3%a4%f2%c6%a9%cc%c0%a4%cb%a4%b9%a4%eb";
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