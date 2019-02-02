// -*- mode: java -*-  Time-stamp: <2012-02-04 11:55:05 kahata>
/*================================================================
 * title: 
 * file: ImageView.java
 * created: Time-stamp: <2012-02-04 11:55:05 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%ae%a5%e3%a5%e9%a5%ea%a1%bc%a4%f2%b8%c6%a4%d3%bd%d0%a4%b9
 * description: ギャラリーを呼び出す
 * 最終更新：moonlight_aska 2011年07月30日(土) 09:20:24履歴
 * インテント(Intent)を利用することで, ギャラリーを呼び出して端末内の画像の一覧を表示することができる.
 * (出典：Android版「美人時計」より)
 * 画像の一覧を表示
 * ImageView.java
 * Intentのインスタンスを生成する.
 * Intentntent#setTypeメソッドで, 画像全般("image/*")を指定する. jpegに限定する場合は, "image/jpeg"と指定.
 *		　ここの指定により, 他のメディアも一覧が表示できる.
 * Intent#setActionメソッドで, Intent.ACTION_PICKを指定する.
 * startActivityメソッドで, インテント呼出しする.
 *================================================================*/

package com.moonlight_aska.android.imageview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ImageView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ギャラリー呼び出し
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_PICK);
		startActivity(intent);
	}
}
