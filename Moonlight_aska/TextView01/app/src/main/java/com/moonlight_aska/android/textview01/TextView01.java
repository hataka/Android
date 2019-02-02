// -*- mode: java -*-  Time-stamp: <2012-02-06 9:09:55 kahata>
/*================================================================
 * title: 
 * file: TextView01.java
 * path: F:\android\Moonlight_aska\download\Widget\TextView01\TextView01.java
 * url:  http://localhost/android/Moonlight_aska/download/Widget/TextView01/TextView01.java
 * created: Time-stamp: <2012-02-06 9:09:55 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: 
 * description: テキストビューを作成する
最終更新：moonlight_aska 2010年07月23日(金) 22:30:50履歴
テキストビュー(TextView)を作成する方法は2通りある.
静的に決定しているものはXMLで定義して, 動的に決定するものはコードで定義するというのが一般的である.
XMLファイルにより定義
res/values/strings.xml
テキストビューに表示する文字列を定義する.
<?xml version="1.0" encoding="utf-8"?>
<resources>
	<string name="app_name">テキストビューを作成する</string>
	<string name="textview_label">This is a TextView sample.</string>
</resources>
res/layout/main.xml
"@+id/textview_id"でプログラムからアクセスするIDを定義する.
テキストビューをどれくらいの大きさで配置するかを指定する.
"@string/textview_label"で表示する文字列を指定する.
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:orientation="vertical"
	android:layout_width="fill_parent"
	android:layout_height="fill_parent"
	>
	<TextView android:id="@+id/textview_id"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="@string/textview_label"
	/>
</LinearLayout>

コードにより定義
Activity#onCreateメソッドをオーバーライドして, テキストビューを定義するコードを記述する.
TextViewクラスとLinearLayoutクラスをインポートする.
テキストビューを生成し, 表示する文字列をセットする.
テキストビューを配置するレイアウトを生成し, テキストビューをレイアウトに追加する. このとき, テキストビューをどれくらいの大きさで配置するかを指定する.
setContentViewメソッドに, UIツリーのルートノードを表すウィジェットとしてレイアウトを渡して, アクティビティに関連付ける.
 *================================================================*/

package com.moonlight_aska.android.textview01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextView01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// テキストビューを生成
		TextView text = new TextView(this);
		text.setText("This is a TextView sample.");
		// レイアウトにテキストビューを追加
		LinearLayout layout = new LinearLayout(this);
		layout.addView(text, new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.WRAP_CONTENT,
			LinearLayout.LayoutParams.WRAP_CONTENT));

		setContentView(layout);
	}
}