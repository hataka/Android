// -*- mode: java -*-  Time-stamp: <2012-02-03 8:39:47 kahata>
/*================================================================
 * title: DrawPoint.java
 * file: DrawPoint.java
 * created: Time-stamp: <2012-02-03 8:39:47 kahata>
 * revision: $Id$
 * Programmed By: kahata
 * To compile:
 * To run: 
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%c5%c0%2c%20%c4%be%c0%fe%a4%f2%c9%c1%a4%af
 * description: 点を描く
 * Paintクラスのインスタンスを生成する.
 * Canvas#drawPointメソッドまたはdrawPointsメソッドで, 座標点を指定して点を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawpoint;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class DrawPoint extends Activity {
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
		//paint.setStrokeWidth(3);
		paint.setStrokeWidth(10);
		// 点を描く
		canvas.drawPoint(50, 50, paint);
		// 複数の点を描く
		float[] pts = new float[20];
		for(int i=0; i<10; i+=2) {
			pts[i] = 10 * i + 100;
			pts[i+1] = 100;
		}
		canvas.drawPoints(pts, paint);
	}
}
