/*
マルチタッチイベントを取得する
最終更新：moonlight_aska 2011年10月09日(日) 14:24:28履歴

Android 2.0(API 5)以降でマルチタッチ(Multi-touch)がサポートされた.
複数の指でタッチパネルを操作すると, タッチイベント(Touch Event)が
ACTION_DOWN/ACTION_POINTER_DOWN→ACTION_MOVE(繰返し)→ACTION_UP/ACTION_POINTER_UP
の順に発生する. 
ACTION_POINTER_DOWNは, 画面の1点以上をタッチしている状態で, さらに画面にタッチした際に発生する.
また, ACTION_POINTER_UPは, 画面の2点以上をタッチしている状態で, その内の1点を離した際に発生する.
マルチタッチのタッチイベントを取得するには, タッチイベントを取得すると同様に
onTouchEventメソッドをオーバーライドする.

Viewで取得する
View#onTouchEventメソッドをオーバーライドする.
MotionEvent#getPointerCountメソッドで, タッチ座標点数を取得する.
MotionEvent#getPointerIdメソッドで, ポインタIDを取得する.
MotionEvent#getXメソッド, getYメソッドで, タッチされたx, y座標を取得する.
*/

package com.moonlight_aska.keytouch.multitouch02;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouch02 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MyView view = new MyView(this);
		setContentView(view);
	}

	class MyView extends View {
		final static int MULTI_TOUCH_MAX = 5;
		private PointF [] points = new PointF[MULTI_TOUCH_MAX];
		private int[] color = {Color.BLUE, Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW};

		public MyView(Context context) {
			super(context);
			setBackgroundColor(Color.WHITE);
			setFocusable(true);

			for(int i=0; i<MULTI_TOUCH_MAX; i++) {
				points[i] = new PointF(-1.0F, -1.0F);
			}
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setStyle(Paint.Style.FILL_AND_STROKE);
			// タッチ位置の描画
			for(int i=0; i<MULTI_TOUCH_MAX; i++) {
				if(points[i].x < 0.0 && points[i].y < 0.0)
					continue;
				paint.setColor(color[i]);
				canvas.drawCircle(points[i].x, points[i].y, 20, paint);
			}
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			int count = event.getPointerCount();
			for(int i=0; i<count; i++) {
				int id = event.getPointerId(i);
				points[id].x = event.getX(i);
				points[id].y = event.getY(i);
			}
			invalidate();
			return true;
		}
	}
}
