/*
タッチイベントを取得する
最終更新：moonlight_aska 2011年10月09日(日) 14:23:34履歴

タッチパネルを操作すると, 
タッチイベント(Touch Event)がACTION_DOWN→ACTION_MOVE(繰返し)→ACTION_UP
の順に発生する.
このタッチイベントを取得するには, onTouchEventメソッドをオーバーライドする.
また, dispatchTouchEventメソッドをオーバーライドしても, 同様の情報を取得することができる. 
dispatchTouchEventメソッドは, onTouchEventメソッドよりも先にコールされる.

アクティビティで取得する
Activity#onTouchEventメソッドをオーバーライドする.
MotionEvent#getXメソッド, getYメソッドで, タッチされたx, y座標を取得できる.
MotionEvent#getActionメソッドの値をMotionEvent.ACTION_MASKでマスクすることにより, 
タッチアクション(DOWN/MOVE/UP/CANCEL)を取得できる.
MotionEvent#getEventTimeメソッドで, イベント発生時刻(ms)を取得できる. 
(サンプルコードでは未使用)
*/

package com.moonlight_aska.keytouch.touchevent01;

import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.view.MotionEvent;

//import android.content.Intent;
//import android.net.Uri;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.Toast;

public class TouchEvent01 extends Activity {
	String msg = "";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float x = event.getX();
		float y = event.getY();
		String action = "";

		switch(event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			action = "Touch Down";
			break;
		case MotionEvent.ACTION_MOVE:
			action = "Touch Move";
			break;
		case MotionEvent.ACTION_UP:
			action = "Touch Up";
			break;
		case MotionEvent.ACTION_CANCEL:
			action = "Touch Cancel";
			break;
		}
		//Log.v("Touch", action + " x=" + x + ", y=" + y);

		msg = "Touch: " +  action + " x=" + x + ", y=" + y;
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
		return super.onTouchEvent(event);
	}
}
