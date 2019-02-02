// -*- mode: java -*-  Time-stamp: <2012-02-03 9:02:39 kahata>
/*================================================================
 * title: 
 * file: DrawPolygon.java
 * created: Time-stamp: <2012-02-03 9:02:39 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%c2%bf%b3%d1%b7%c1%a4%f2%c9%c1%a4%af
 * description: 多角形を描く
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:51:49履歴
 * 多角形を描画するには, Canvasオブジェクトを取得して, このCanvasに描画する.
 * 多角形を描く
 *  Paintクラスのインスタンスを生成する.
 *  Paint#setStyleメソッドで, 線のみか, 内部を塗りつぶすか, 線で描く内部を塗りつぶすかを指定する.
 *  Pathクラスのインスタンスを生成する.
 *  Path#moveToメソッドとlineToメソッドを使って, 多角形のパスを設定する.
 *  Canvas#drawPathメソッドで, 多角形のパスを指定して多角形を描く.
 *================================================================*/

package com.moonlight_aska.graphic.drawpolygon;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
public class DrawPolygon extends Activity {
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
		paint.setAntiAlias(true);
		// 三角形を描く
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.STROKE);
		Path path = new Path();
		path.moveTo(160f, 30f);
		path.lineTo(110f, 100f);
		path.lineTo(210f, 100f);
		path.lineTo(160f, 30f);
		canvas.drawPath(path, paint);
		// 星形を描く
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		path.reset();
		float theta = (float)(Math.PI * 72 / 180);
		float r = 50f;
		PointF center = new PointF(160f, 200f);
		float dx1 = (float)(r*Math.sin(theta));
		float dx2 = (float)(r*Math.sin(2*theta));
		float dy1 = (float)(r*Math.cos(theta));
		float dy2 = (float)(r*Math.cos(2*theta));
		path.moveTo(center.x, center.y-r);
		path.lineTo(center.x-dx2, center.y-dy2);
		path.lineTo(center.x+dx1, center.y-dy1);
		path.lineTo(center.x-dx1, center.y-dy1);
		path.lineTo(center.x+dx2, center.y-dy2);
		path.lineTo(center.x, center.y-r);
		canvas.drawPath(path, paint);
	}
}
