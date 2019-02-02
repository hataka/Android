// -*- mode: java -*-  Time-stamp: <2012-02-03 9:17:41 kahata>
/*================================================================
 * title: 
 * file: StrokeWidth.java
 * created: Time-stamp: <2012-02-03 9:17:41 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%c0%fe%c9%fd%a4%f2%a4%ab%a4%a8%a4%eb
 * description: 線幅をかえる
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:55:59履歴
 * 線幅をかえる
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setStrokeWidthメソッドで, 線幅を設定する.
 *  Canvas#drawXXXXメソッドで, 図形を描画する.
 *================================================================*/

package com.moonlight_aska.graphic.strokewidth;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class StrokeWidth extends Activity {
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
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.STROKE);
		// 線幅をかえる
		for(int i=0; i<8; i++) {
			paint.setStrokeWidth(i+1);
			canvas.drawLine(10, 20*i+10, 310, 20*i+10, paint);
			canvas.drawRect(20*i+50, 20*i+200, 20*i+150, 20*i+250, paint);
		}
	}
}
