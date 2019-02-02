// -*- mode: java -*-  Time-stamp: <2012-02-03 8:55:19 kahata>
/*================================================================
 * title: 矩形を描く
 * file: DrawRect.java
 * created: Time-stamp: <2012-02-03 8:55:19 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%b6%eb%b7%c1%a4%f2%c9%c1%a4%af
 * description: 矩形を描く
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:48:19履歴
 * 矩形を描画するには, Canvasオブジェクトを取得して, このCanvasに描画する.
 *  矩形を描く
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setStyleメソッドで, 線のみか, 内部を塗りつぶすか, 線で描く内部を塗りつぶすかを指定する.
 *  Canvas#drawRectメソッドで, 矩形の座標値(left, top, right, buttom)を指定して矩形を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawrect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class DrawRect extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MyView view = new MyView(getApplication());
		setContentView(view);
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
		paint.setColor(Color.RED);
		// 線で矩形を描く
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRect(50, 50, 200, 100, paint);
		// 矩形の内部を塗りつぶす
		paint.setStyle(Paint.Style.FILL);
		canvas.drawRect(50, 120, 200, 170, paint);
	}
}