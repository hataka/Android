// -*- mode: java -*-  Time-stamp: <2012-02-07 14:52:23 kahata>
/*================================================================
 * title: 
 * file: Preference01.java
 * created: Time-stamp: <2012-02-07 14:52:23 kahata>
 * link: 
 * description: 設定画面を作成する
 * 最終更新：moonlight_aska 2011年07月23日(土) 18:28:14履歴
 * アプリケーションをカスタマイズするための設定情報は, 
 * プリファレンスアクティビティ(PreferenceActivity)を使うことで簡単に作成できる.
 * 設定された設定情報は, 「/data/data/アプリケーションのパッケージ名/shared_prefs」の下に登録される.
 *================================================================*/

package com.moonlight_aska.android.preference01;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Preference01 extends PreferenceActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.pref);
	}
}
