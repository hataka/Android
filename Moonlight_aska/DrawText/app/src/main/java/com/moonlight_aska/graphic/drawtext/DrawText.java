// -*- mode: java -*-  Time-stamp: <2012-02-03 9:06:33 kahata>
/*================================================================
 * title: 
 * file: DrawText.java
 * created: Time-stamp: <2012-02-03 9:06:33 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%c6%a5%ad%a5%b9%a5%c8%a4%f2%c9%c1%a4%af
 * description: テキストを描く
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:52:45履歴
 *  グラフィック画面上にテキストを描画するには, Canvasオブジェクトを取得して, このCanvasに描画する.
 *  指定した位置に文字列を描く
 *  Paintクラスのインスタンスを生成する.
 *  Canvas#drawTextメソッドで, 表示位置を指定して文字列を描く.
 *  １文字ずつ指定した位置に描く
 *  Paintクラスのインスタンスを生成する.
 *  各文字の表示位置をposに設定する.
 *  Canvas#drawPosTextメソッドで, 表示位置を指定して文字列を描く.
 *  指定した経路上に文字列を描く
 *  Paintクラスのインスタンスを生成する.
 *  Pathクラスで, 文字列を表示するパスを設定する.
 *  Canvas#drawTextOnPathメソッドで, 表示経路を指定して文字列を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawtext;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.os.Bundle;
import android.view.View;

public class DrawText extends Activity {
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
		// 指定した位置に文字列を描く
		canvas.drawText("グラフィック文字", 50, 30, paint);
		// １文字ずつ指定した位置に描く
		paint.setColor(Color.RED);
		String str = "テキスト";
		int len = str.length() * 2;
		float[] pos = new float[len];
		for(int i=0; i<len; i+=2) {
			pos[i] = 15 * i + 100;	 // x座標
			pos[i+1] = 5 * i + 50;	 // y座標
		}
		canvas.drawPosText(str, pos, paint);
		// 指定した経路上に文字列を描く
		paint.setColor(Color.GREEN);
		paint.setTextSize(20);
		Path path = new Path();
		path.addCircle(100, 200, 80, Direction.CW);
		canvas.drawTextOnPath("グラフィック文字", path, 300, 20, paint);
	}
}
