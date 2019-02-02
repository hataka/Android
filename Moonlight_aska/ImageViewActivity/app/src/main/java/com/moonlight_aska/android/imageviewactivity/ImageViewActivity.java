// -*- mode: java -*-  Time-stamp: <2012-02-04 12:28:16 kahata>
/*================================================================
 * title: 
 * file: ImageViewActivity.java
 * created: Time-stamp: <2012-02-04 12:28:16 kahata>
 * link:http://wiki.livedoor.jp/moonlight_aska/d/%a5%ae%a5%e3%a5%e9%a5%ea%a1%bc%a4%ab%a4%e9%b2%e8%c1%fc%a4%f2%bc%e8%c6%c0%a4%b9%a4%eb 
 * description: ギャラリーから画像を取得する
 * 最終更新：moonlight_aska 2011年07月30日(土) 11:38:55履歴
 * インテント(Intent)で呼び出したギャラリーから選択された画像を取得することができる.
 * (出典:Android版「美人時計」より)
 * ギャラリーから画像を取得
 * ImageView.java
 * Intentのインスタンスを生成する.
 * Intent#setTypeメソッドで, 画像全般("image/*")を指定する. jpegに限定する場合は, "image/jpeg"と指定.
 * Intent#setActionメソッドで, Intent.ACTION_GET_CONTENTを指定する.
 * startActivityForResuitメソッドで, リクエストコードを指定してインテント呼出しする.
 * ギャラリーでの選択結果を受け取るために, onActivityResultメソッドをオーバーライドする.
 * リクエストコードをチェックし, ギャラリーからのイベントか判断する.
 * Intent#getDataメソッドを使って選択された画像へのパスを取得する.
 * ContentResolver#openInputStremaメソッドで, InputStreamをオープンする.
 * BitmapFactory#decodeStreamメソッドで, ビットマップに変換する.
 * InputStream#closeメソッドで, InputStreamをクローズする.
 *================================================================*/

package com.moonlight_aska.android.imageviewactivity;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
	private static final int REQUEST_GALLERY = 0;
	private ImageView imgView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imgView = (ImageView)findViewById(R.id.imageView1);
		// ギャラリー呼び出し
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(intent, REQUEST_GALLERY);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
			try {
				InputStream in = getContentResolver().openInputStream(data.getData());
				Bitmap img = BitmapFactory.decodeStream(in);
				in.close();
				// 選択した画像を表示
				imgView.setImageBitmap(img); 
			} catch (Exception e) {

			}
		} 
	}
}
