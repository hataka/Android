/*
タッチイベントを取得する
最終更新：moonlight_aska 2011年10月09日(日) 14:23:34履歴

タッチパネルを操作すると, 
タッチイベント(Touch Event)がACTION_DOWN→ACTION_MOVE(繰返し)→ACTION_UP
の順に発生する.
このタッチイベントを取得するには, onTouchEventメソッドをオーバーライドする.
また, dispatchTouchEventメソッドをオーバーライドしても, 同様の情報を取得することができる. 
dispatchTouchEventメソッドは, onTouchEventメソッドよりも先にコールされる.

Viewで取得する
View#onTouchEventメソッドをオーバーライドする.
MotionEvent#getXメソッド, getYメソッドで, タッチされたx, y座標を取得できる.
MotionEvent#getActionメソッドやgetEventTimeメソッドもActivity同様使用できる.
*/

package com.moonlight_aska.keytouch.touchevent02;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class TouchEvent02 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MyView view = new MyView(this);
		setContentView(view);
	}
}

class MyView extends View {
	private ArrayList<Point> points = new ArrayList<Point>();

	public MyView(Context context) {
		super(context);
		setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(3);
		Point po = null;
		for(int i=0; i<points.size(); i++) {
			po = points.get(i);
			canvas.drawPoint(po.x, po.y, paint);
		}
		super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int x = (int)event.getX();
		int y = (int)event.getY();
		points.add(new Point(x, y));
		invalidate(); // 通知
		return true;
	}
}
