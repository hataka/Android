// -*- mode: java -*-  Time-stamp: <2012-02-03 9:10:44 kahata>
/*================================================================
 * title: 
 * file: SetColor.java
 * created: Time-stamp: <2012-02-03 9:10:44 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%c9%c1%b2%e8%bf%a7%2c%20%c7%d8%b7%ca%bf%a7%a4%f2%c0%df%c4%ea%a4%b9%a4%eb
 * description:  描画色, 背景色を設定する
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:54:06履歴
 * 描画色を設定する
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setColorメソッドまたはsetARGBメソッドで, 描画色を設定する.
 *  背景色を設定する
 *  Canvas#drawColorメソッドで, 背景色を設定する.
 *================================================================*/

package com.moonlight_aska.graphic.setcolor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class SetColor extends Activity {
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
		// 背景色を設定
		canvas.drawColor(Color.WHITE);
		// 描画色を設定
		Paint paint = new Paint();
		paint.setTextSize(20);
		// Colorで色を設定
		paint.setColor(Color.BLUE);
		canvas.drawText("半透明図形の描画", 80, 30, paint);
		// ARGBで色を設定
		paint.setARGB(50, 255, 0, 0);
		for(int i=0; i<5; i++) {
			canvas.drawCircle(30*i+100, 30*i+150, 100, paint);
		}
	}
}
