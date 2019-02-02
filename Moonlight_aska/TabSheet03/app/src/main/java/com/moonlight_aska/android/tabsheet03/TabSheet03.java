// -*- mode: java -*-  Time-stamp: <2012-02-04 10:41:12 kahata>
/*================================================================
 * title: 
 * file: TabSheet02.java
 * created: Time-stamp: <2012-02-04 10:41:12 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%bf%a5%d6%a4%cb%a5%a2%a5%a4%a5%b3%a5%f3%a4%f2%c5%bd%a4%ea%c9%d5%a4%b1%a4%eb
 * description: タブにアイコンを貼り付ける
 * 最終更新：moonlight_aska 2011年07月23日(土) 18:20:11履歴
 * タブ画面のタブにアイコンを設定するには, TabSpec.setIndicatorメソッドを使用する.
 * アイコンを貼り付ける
 * res/drawable-xx/画像ファイル
 * res/drawable-Xdpiディレクトリに, タブに貼り付ける画像を置く.
 * 例では, Android Robotの画像を"androidrobot.png"として置いている.
 * Androidがサポートしている画像フォーマットは, 以下の4つである.
 *  Bitmap(.bmp)
 *  JPEG(.jpg)
 *  PNG(.png)
 *  GIF(.gif)
 * 但し, 推奨はPNGとのこと.
 * TabSheet01.java
 * タブ画面の作成は, タブ画面を作成するを参照.
 * タブシートの設定で, TabSpec.setIndicatorメソッドにアイコンデータを渡す.
 *================================================================*/

package com.moonlight_aska.android.tabsheet03;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class TabSheet03 extends TabActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// TabHostのインスタンスを取得
		TabHost tabs = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.main, tabs.getTabContentView(), true);
		// タブシートの設定
		TabSpec tab01 = tabs.newTabSpec("TabSheet1");
		tab01.setIndicator("TabSheet1");
		tab01.setContent(R.id.sheet01_id);
		tabs.addTab(tab01);
		TabSpec tab02 = tabs.newTabSpec("TabSheet2");
		tab02.setIndicator("TabSheet2", getResources().getDrawable(R.drawable.ic_launcher));
		tab02.setContent(R.id.sheet02_id);
		tabs.addTab(tab02);
		TabSpec tab03 = tabs.newTabSpec("TabSheet3");
		tab03.setIndicator("TabSheet3");
		tab03.setContent(R.id.sheet03_id);
		tabs.addTab(tab03);
		// 初期表示のタブ設定
		tabs.setCurrentTab(0);
	}
}