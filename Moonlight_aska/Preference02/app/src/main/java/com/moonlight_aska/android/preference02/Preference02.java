// -*- mode: java -*-  Time-stamp: <2012-02-04 10:23:15 kahata>
/*================================================================
 * title: 
 * file: Preference02.java
 * created: Time-stamp: <2012-02-04 10:23:15 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%c0%df%c4%ea%be%f0%ca%f3%a4%f2%c6%c9%a4%df%bd%d0%a4%b9
 * description: 設定情報を読み出す
 * 最終更新：moonlight_aska 2011年07月23日(土) 18:27:03履歴
 * プリファレンスアクティビティを使って設定された設定情報は, 
 *「/data/data/アプリケーションのパッケージ名/shared_prefs」の下に登録されている. 
 * ("設定画面を作成する"の項を参照)
 * この設定情報の読み出しには, PreferenceManagerクラスを使用する.
 * 設定情報を読み出す
 * PreferenceManager.getDefaultSharedPreferencesメソッドで, SharedPreferencesクラスの
 * インスタンスを取得する.
 * SharedPreferences.getBooleanメソッドにチェックボックスのキーを渡し, 値を取得する.
 * SharedPreferences.getStringメソッドにエディットテキストのキーを渡し, 値を取得する.
 * SharedPreferences.getStringメソッドにリストのキーを渡し, 値を取得する.
 *================================================================*/

/*
package com.moonlight_aska.android.preference02;
import android.app.Activity;
import android.os.Bundle;

public class Preference02 extends Activity {
    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
*/

package com.moonlight_aska.android.preference02;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

public class Preference02 extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView text = (TextView)findViewById(R.id.editText1);

		try {
			String settingInfo = new String("設定情報\n");
			SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
			// チェックボックスによる設定の内容
			boolean checkbox = pref.getBoolean("checkbox_key", false);
			settingInfo += "CheckBox : " + String.valueOf(checkbox) + "\n";
			// エディットテキストによる設定の内容
			String edittext = pref.getString("edittext_key", "なし");
			settingInfo += "EditText : " + edittext + "\n";
			// リストによる設定の内容
			String list = pref.getString("list_key", "0");
			settingInfo += "List : " + list;
			text.setText(settingInfo);
			} catch (Exception e) {
				// 失敗した場合の処理
				Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_LONG).show();
			}

		}
}
