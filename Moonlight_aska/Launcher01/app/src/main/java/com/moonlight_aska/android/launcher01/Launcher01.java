// -*- mode: java -*-  Time-stamp: <2012-02-03 7:22:16 kahata>
/*================================================================
 * title: ランチャーアクティビティを作成する
 * file: Launcher01.java
 * created: Time-stamp: <2012-02-03 7:22:16 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%e9%a5%f3%a5%c1%a5%e3%a1%bc%a5%a2%a5%af%a5%c6%a5%a3%a5%d3%a5%c6%a5%a3%a4%f2%ba%ee%c0%ae%a4%b9%a4%eb
 * description: ランチャーアクティビティを作成する
 * << URIの一例 >>
 * Uri								対象			例
 * http://web_address	ブラウザ	http://www.google.com
 * tel:phone_number		電話			tel:080-0001-0001
 * content://contacts/people	連絡先	content://contacts/people/
 * geo:latitude,longitude	地図	geo:0,0?q=Osaka
 *================================================================*/

package com.moonlight_aska.android.launcher01;

import android.app.LauncherActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Launcher01 extends LauncherActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	protected Intent getTargetIntent() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Osaka"));
		return intent;
	}
}
