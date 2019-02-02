// -*- mode: java -*-  Time-stamp: <2012-02-03 8:46:46 kahata>
/*================================================================
 * title: 
 * file: DrawCircle.java
 * created: Time-stamp: <2012-02-03 8:46:46 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%b1%df%2c%20%c2%ca%b1%df%a4%f2%c9%c1%a4%af
 * description: 円, 楕円を描く
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:46:27履歴
 *  円や楕円を描画するには, Canvasオブジェクトを取得して, このCanvasに描画する.
 *  円を描く
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setStyleメソッドで, 線のみか, 内部を塗りつぶすか, 線で描きその内部を塗りつぶすかを指定する.
 *  Canvas#drawCircleメソッドで, 中心座標と半径を指定して円を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawcircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DrawCircle extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MyView view = new MyView(getApplication());
		setContentView(view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを追加
		menu.add(Menu.NONE, 0, Menu.NONE, "DrawCircle.java");
		menu.add(Menu.NONE, 1, Menu.NONE, "AndroidManifest.xml");
		menu.add(Menu.NONE, 2, Menu.NONE, "res/layout/main.xml");
		menu.add(Menu.NONE, 3, Menu.NONE, "res/values/strings.xml");
		return super.onCreateOptionsMenu(menu);
	}
	// メニューが選択されたときに実行される
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String url = "http://www.google.co.jp/";
		String msg = "Google";
		// 選択されたIDを確認
		switch (item.getItemId()) {
			case 0:
				url = "http://192.168.24.92/android/Moonlight_aska/DrawCircle/src/com/moonlight_aska/android/drawcircle/DrawCircle.java";
				msg = "DrawCircle.java";
				break;
			case 1:
				url= "http://192.168.24.92/android/Moonlight_aska/DrawCircle/AndroidManifest.xml";
				msg = "AndroidManifest.xml";
				break;
			case 2:
				url= "http://192.168.24.92/android/Moonlight_aska/DrawCircle/res/layout/main.xml";
				msg = "res/layout/main.xml";
				break;
			case 3:
				url= "http://192.168.24.92/android/Moonlight_aska/DrawCircle/res/values/strings.xml";
				msg = "res/values/strings.xml";
				break;
			default:
				break;
		}
		// 指定したURLをWebviewに読み込む
		Uri uri = Uri.parse(url);
		Intent i = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(i);
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
		return true;
	}

}

class MyView extends View {
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(5);
		/*
		 * http://www.att42.com/menu/memo/android/class/paint.html
		 * グラフィックの描画を滑らかにする
		 * void Paint.setAntiAlias(boolean flg)
		 * 概要	グラフィックへのアンチエイリアス（ピクセルのギザギザを滑らかに。）を設定
		 * 引数	flg　アンチエイリアスを適用するか否かの設定
		 * true　適用する
		 * false　適用しない
		 * 
		 */
		paint.setAntiAlias(true);
		// 線で円を描く
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawCircle(50, 50, 30, paint);
		// 円の内部を塗りつぶす
		paint.setStyle(Paint.Style.FILL);
		canvas.drawCircle(150, 50, 30, paint); 
		// 線で円を描き, 内部を塗りつぶす
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		canvas.drawCircle(250, 50, 30, paint);
	}
}
