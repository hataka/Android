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

アクティビティで取得する
Activity#onTouchEventメソッドをオーバーライドする.
MotionEvent#getActionメソッドで, タッチアクション情報を取得する.
MotionEvent#getPointerCountメソッドで, タッチ座標点数を取得する.
タッチアクション情報をMotionEvent.ACTION_POINTER_ID_MASKでマスクし, 
MotionEvent.ACTION_POINTER_ID_SHIFT分シフトすることで, 
ポインタIDを取得するためのインデックスを取得する.
タッチアクション情報をMotionEvent.ACTION_MASKでマスクし, タッチアクションを取得する.
MotionEvent#getXメソッド, getYメソッドで, タッチされたx, y座標を取得する.
MotionEvent#getPointerIdメソッドで, ポインタIDを取得する.
*/

package com.moonlight_aska.keytouch.multitouch01;

import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.view.MotionEvent;

import android.widget.Toast;

public class MultiTouch01 extends Activity {
	String msg ="";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		int count = event.getPointerCount();
		int id = (action & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;

		switch(action & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			//Log.v("Multi", "Touch Down" + " count=" + count + ", id=" + id);
			msg = "Multi: Touch Down" + " count=" + count + ", id=" + id;
			Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			//Log.v("Multi", "Touch PTR Down" + " count=" + count + ", id=" + id);
			msg = "Multi: Touch PTR Down" + " count=" + count + ", id=" + id;
			Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_UP:
			//Log.v("Multi", "Touch Up" + " count=" + count + ", id=" + id);
			msg = "Multi: Touch Up" + " count=" + count + ", id=" + id;
			Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_POINTER_UP:
			//Log.v("Multi", "Touch PTR Up" + " count=" + count + ", id=" + id);
			msg = "Multi: Touch PTR Up" + " count=" + count + ", id=" + id;
			Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_MOVE:
			//Log.v("Multi", "Touch Move" + " count=" + count + ", id=" + id);
			msg = "Multi: Touch Move" + " count=" + count + ", id=" + id;
			Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
			break;
		}
		for(int i=0; i<count; i++) {
			msg += "Multi:  X=" + event.getX(i) + ", Y=" + event.getY(i) + ", id=" + event.getPointerId(i);
			//Log.v("Multi", " X=" + event.getX(i) + ", Y=" + event.getY(i) + ", id=" + event.getPointerId(i) );
		}
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();		
		return super.onTouchEvent(event);
	}
}
