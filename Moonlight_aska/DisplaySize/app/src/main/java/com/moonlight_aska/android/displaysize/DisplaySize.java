// -*- mode: java -*-  Time-stamp: <2012-02-04 18:10:02 kahata>
/*================================================================
 * title: 
 * file: DisplaySize.java
 * created: Time-stamp: <2012-02-04 18:10:02 kahata>
 * revision: $Id$
 * link: 
 * description: 画面サイズを取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:32:59履歴
 * 端末の画面サイズを取得するには, Displayクラスを使用する.
 * 注) 取得できる画面サイズは, タイトルバー及びステータスバーを含んだものである.
 * Activity継承クラスの場合
 * DisplaySize.java
 * getSystemServiceメソッドで, WINDOW_SERVICEを指定してWindowManagerのインスタンスを取得する.
 * WindowManager#getDefaultDisplayメソッドで, Displayクラスのインスタンスを生成する.
 * Display#getWidth/getHeightメソッドで, 画面サイズ情報を取得する.
 *================================================================*/

package com.moonlight_aska.android.displaysize;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class DisplaySize extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView txWidth = (TextView)findViewById(R.id.editText1);
		TextView txHeight = (TextView)findViewById(R.id.editText2);
		// ウィンドウマネージャのインスタンス取得
		WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
		// ディスプレイのインスタンス生成
		Display disp = wm.getDefaultDisplay();
		String width = "Width = " + disp.getWidth();
		String height = "Highht = " + disp.getHeight();
		txWidth.setText(width);
		txHeight.setText(height);
	}
}
