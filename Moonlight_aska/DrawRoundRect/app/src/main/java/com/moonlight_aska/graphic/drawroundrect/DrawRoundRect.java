// -*- mode: java -*-  Time-stamp: <2012-02-03 8:59:13 kahata>
/*================================================================
 * title: 
 * file: DrawRoundRect.java
 * created: Time-stamp: <2012-02-03 8:59:13 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%b6%eb%b7%c1%a4%f2%c9%c1%a4%af
 * description: 角が丸くなった矩形を描く
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setStyleメソッドで, 線のみか, 中を塗りつぶすか指定する.
 *  Canvas#drawRoundRectメソッドで, 矩形の座標値と角の丸みを指定して矩形を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawroundrect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class DrawRoundRect extends Activity {
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
		paint.setColor(Color.BLUE);
		// 線で矩形を描く
		paint.setStyle(Paint.Style.STROKE);
		RectF rect = new RectF(50, 50, 200, 100);
		canvas.drawRoundRect(rect, 10, 10, paint);
		// 矩形の内部を塗りつぶす
		paint.setStyle(Paint.Style.FILL);
		rect = new RectF(50, 120, 200, 170);
		canvas.drawRoundRect(rect, 10, 10, paint);
	}
}
