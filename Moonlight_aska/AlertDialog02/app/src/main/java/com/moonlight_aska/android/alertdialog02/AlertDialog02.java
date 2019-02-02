// -*- mode: java -*-  Time-stamp: <2012-02-03 16:03:29 kahata>
/*================================================================
 * title: 
 * file: AlertDialog02.java
 * created: Time-stamp: <2012-02-03 16:03:29 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%a2%a5%e9%a1%bc%a5%c8%a5%c0%a5%a4%a5%a2%a5%ed%a5%b0%a4%f2%c9%bd%bc%a8%a4%b9%a4%eb
 * link: 
 * description: リストを配置したアラートダイアログ
 * AlertDialog.Builderを生成する.
 * setTitleメソッドでタイトルを設定する.
 * 　注) setMessageメソッドによる本文の設定はできないもよう.
 * setItemsメソッドでリスト表示する文字列の配列を設定する.
 * createメソッドでアラートダイアログを生成する.
 * showメソッドでアラートダイアログを表示する.
 *================================================================*/

package com.moonlight_aska.android.alertdialog02;

//import com.moonlight_aska.android.alertdialog01.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AlertDialog02 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// リスト表示する文字列
				final String[] ITEM = new String[]{"白", "赤", "青", "緑", "黄", "紫"};
				new AlertDialog.Builder(AlertDialog02.this)
				.setTitle("色を選択してください.")
				.setItems(ITEM, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						// アイテムが選択されたときの処理. whichが選択されたアイテムの番号.
						Log.v("Alert", "Item No : " + which);
					}
				})
				.create()
				.show();
			}
		});
	} 
}
