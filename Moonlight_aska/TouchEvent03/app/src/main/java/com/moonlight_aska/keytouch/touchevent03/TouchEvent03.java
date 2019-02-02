/*
複雑なタッチイベントを取得する
最終更新：moonlight_aska 2011年09月04日(日) 22:00:21履歴

タッチパネルを操作するとタッチイベント(Touch Event)が発生する.
onTouchEventメソッドは, "タッチダウン","移動", "タッチアップ"などの
イベントが発生するたびにコールされるので, 基本的な動作はここで処理することができる.
 (タッチイベントを取得するを参照)
しかし, "ダブルタップ", "ロングタップ", "フリック"など少し複雑なタッチイベントを処理するには,
GestureDetector.SimpleOnGestureListenerクラスを使う.
GestureDetector.SimpleOnGestureListenerクラスの代わりに, 
GestureDetector.OnGestureListenerクラスとGestureDetector.OnDoubleTapListenerクラスを併用して
実装することも可能である.

複雑なタッチイベントを取得
GestureDetectorクラスのインスタンスを生成する. 
インスタンスを生成する際に, SimpleOnGestureListenerメソッドを登録する.
onTouchEventメソッドをオーバーライドし, タッチイベントを
GestureDetector#onTouchEventメソッドに渡す.
SimpleOnGestureListenerクラスのインスタンスを生成する.
onGestureListenerにおいて, 各イベントを処理するメソッドをオーバーライドする.
*/
package com.moonlight_aska.keytouch.touchevent03;


import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.Toast;

public class TouchEvent03 extends Activity {
	private GestureDetector gesDetect;
	String msg;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// GestureDetecotorクラスのインスタンス生成
		gesDetect = new GestureDetector(this, onGestureListener); 
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		// タッチイベントをGestureDetector#onTouchEventメソッドに
		gesDetect.onTouchEvent(event);
		return false;
	}

	// 複雑なタッチイベントを取得
	private final SimpleOnGestureListener onGestureListener = new SimpleOnGestureListener() {
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			//Log.v("Gesture: ", "onDoubleTap");
			
			msg = "Gesture" + "onDoubleTap";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onDoubleTap(e);
		}

		@Override
		public boolean onDoubleTapEvent(MotionEvent e) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onDoubleTapEvent");

			msg = "Gesture: " + "onDoubleTapEvent";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onDoubleTapEvent(e);
		}

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			// Log.v("Gesture", "onDown");
			msg = "Gesture: " + "onDown";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onDown(e);
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onFling");

			msg = "Gesture: " + "onFling";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onLongPress");

			msg = "Gesture: " + "onLongPress";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			super.onLongPress(e);
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onScroll");

			msg = "Gesture: " + "onScroll";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onScroll(e1, e2, distanceX, distanceY);
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onShowPress");

			msg = "Gesture: " + "onShowPress";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			super.onShowPress(e);
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onSingleTapConfirmed");
			
			msg = "Gesture: " + "onSingleTapConfirmed";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onSingleTapConfirmed(e);
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			//Log.v("Gesture", "onSingleTapUp");

			msg = "Gesture: " + "onSingleTapUp";
			Toast.makeText(TouchEvent03.this,msg, Toast.LENGTH_SHORT).show();			
			return super.onSingleTapUp(e);
		}
	};
}