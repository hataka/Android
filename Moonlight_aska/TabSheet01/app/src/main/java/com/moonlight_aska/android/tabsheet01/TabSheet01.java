//-*- mode: java -*-  Time-stamp: <2012-02-04 10:34:56 kahata>
/*================================================================
 * title: 
 * file: TabSheet01.java
 * created: Time-stamp: <2012-02-04 10:34:56 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%bf%a5%d6%b2%e8%cc%cc%a4%f2%ba%ee%c0%ae%a4%b9%a4%eb
 * description: タブ画面を作成する
 * 最終更新：moonlight_aska 2011年07月23日(土) 18:24:05履歴
 * タブ画面を作成する方法は2通りある.
 * TabActivityを継承する
 * TabSheet01.java
 * getTabHostメソッドで, TabHostのインスタンスを取得する.
 * LayoutInflaer.from().inflateメソッドで, レイアウトを設定する.
 * タブシートを設定する.
 * 初期表示のタブ画面を設定する.
 *================================================================*/

package com.moonlight_aska.android.tabsheet01;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec; 

@SuppressWarnings("deprecation")
public class TabSheet01 extends TabActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// TabHostのインスタンスを取得
		TabHost tabs = getTabHost();
		// レイアウトを設定 
		LayoutInflater.from(this).inflate(R.layout.main, tabs.getTabContentView(), true);
		// タブシートの設定
		TabSpec tab01 = tabs.newTabSpec("TabSheet1");
		tab01.setIndicator("TabSheet1");
		tab01.setContent(R.id.sheet01_id);
		tabs.addTab(tab01);
		TabSpec tab02 = tabs.newTabSpec("TabSheet2");
		tab02.setIndicator("TabSheet2");
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
