// -*- mode: java -*-  Time-stamp: <2012-02-03 8:50:36 kahata>
/*================================================================
 * title: 
 * file: DrawOval.java
 * created: Time-stamp: <2012-02-03 8:50:36 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%b1%df%2c%20%c2%ca%b1%df%a4%f2%c9%c1%a4%af
 * description: 楕円を描く
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setStyleメソッドで, 線のみか, 中を塗りつぶすか指定する.
 *  楕円の外接矩形の座標値を設定する.
 *  Canvas#drawOvalメソッドで, 楕円を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawoval;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class DrawOval extends Activity {
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
		paint.setStrokeWidth(5);
		paint.setAntiAlias(true);
		// 楕円を描く
		paint.setStyle(Paint.Style.STROKE);
		RectF rect = new RectF(30, 30, 1500, 1000);
		canvas.drawOval(rect, paint); 
		// 楕円の内部を塗りつぶす
		paint.setStyle(Paint.Style.FILL);
		rect.set(180, 30, 300, 100);
		canvas.drawOval(rect, paint);
	}
}
