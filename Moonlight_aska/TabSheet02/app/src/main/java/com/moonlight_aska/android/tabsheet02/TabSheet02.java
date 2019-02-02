// -*- mode: java -*-  Time-stamp: <2012-02-04 10:52:43 kahata>
/*================================================================
 * title: 
 * file: TabSheet03.java
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%bf%a5%d6%a4%ac%c1%aa%c2%f2%a4%b5%a4%ec%a4%eb%a4%c8....
 * description: タブが選択されると....
 * 最終更新：moonlight_aska 2011年07月23日(土) 18:21:09履歴
 * タブがクリックされると, TabChangeイベントが発生する.
 * TabChangeイベントを処理する
 * タブをクリックするとTabChangeイベントが発生するので, 
 * このTabChangeイベントを処理するイベントリスナを設定する.
 * getTabHostメソッドで, TabHostのインスタンスを取得する.
 * TabHost.OnTabChangeListenerインタフェースを実装したオブジェクトをイベントリスナとして設定する.
 * onTabChangedメソッドにクリックされたときの処理を記述する.
 *================================================================*/

package com.moonlight_aska.android.tabsheet02;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class TabSheet02 extends TabActivity {
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
		tab02.setIndicator("TabSheet2");
		tab02.setContent(R.id.sheet02_id);
		tabs.addTab(tab02);
		TabSpec tab03 = tabs.newTabSpec("TabSheet3");
		tab03.setIndicator("TabSheet3");
		tab03.setContent(R.id.sheet03_id);
		tabs.addTab(tab03);
		// 初期表示のタブ設定
		tabs.setCurrentTab(0);

		tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			// タブがクリックされた時のハンドラ
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				// クリックされた時の処理を記述
				TextView text;
				if(tabId == "TabSheet1") {
					text = (TextView)findViewById(R.id.textview01_id);
					text.setTextColor(Color.BLUE);
				}
				else if(tabId == "TabSheet2") {
					text = (TextView)findViewById(R.id.textview02_id);
					text.setTextColor(Color.RED);
				}
				else if(tabId == "TabSheet3") {
					text = (TextView)findViewById(R.id.textview03_id);
					text.setTextColor(Color.GREEN);
				}
			}
		});
	}
}
