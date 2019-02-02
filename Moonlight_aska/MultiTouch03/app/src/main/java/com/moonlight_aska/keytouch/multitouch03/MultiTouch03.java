/*
ピンチイン・アウトを認識する
最終更新：moonlight_aska 2011年09月10日(土) 00:33:25履歴

Android2.0(API 5)以降でマルチタッチ(Multi-touch)がサポートされた. 
(マルチタッチイベントを取得する参照)
そして, Android2.2(API 8)からは, マルチタッチの特徴的な操作である
ピンチイン・アウトをモーションジェスチャー(ScaleGestureDetector)クラスで
簡単に認識できるようになった.

ピンチイン・アウトを認識
ScaleGestureDetectorクラスのインスタンスを生成する. 
インスタンスを生成する際に, SimpleOnScaleGestureListenerメソッドを登録する.
onTouchEventメソッドをオーバーライドし, タッチイベントを
ScaleGestureDetector#onTouchEvenetメソッドに渡す.
SimpleOnScaleGestureListenerクラスのインスタンスを生成する.
onScaleGestureListenerにおいて, 各イベントを処理するメソッドをオーバーライドする.
*/

package com.moonlight_aska.keytouch.multitouch03;

import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

import android.widget.Toast;

public class MultiTouch03 extends Activity {
	String msg ="";
	
	private ScaleGestureDetector gesDetect = null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ScaleGestureDetecotorクラスのインスタンス生成
		gesDetect = new ScaleGestureDetector(this, onScaleGestureListener);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		// タッチイベントをScaleGestureDetector#onTouchEventメソッドに
		gesDetect.onTouchEvent(event);
		return false;
	}

	// スケールジェスチャーイベントを取得
	private final SimpleOnScaleGestureListener onScaleGestureListener = new SimpleOnScaleGestureListener(){
		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			// TODO Auto-generated method stub
			//Log.v("ScaleGesture", "onScale");
			msg = "ScaleGesture: onScale";
			Toast.makeText(MultiTouch03.this,msg, Toast.LENGTH_SHORT).show();
			return super.onScale(detector);
		}

		@Override
		public boolean onScaleBegin(ScaleGestureDetector detector) {
			// TODO Auto-generated method stub
			//Log.v("ScaleGesture", "onScaleBegin");
			msg = "ScaleGesture: onScaleBegin";
			Toast.makeText(MultiTouch03.this,msg, Toast.LENGTH_SHORT).show();
			return super.onScaleBegin(detector);
		}

		@Override
		public void onScaleEnd(ScaleGestureDetector detector) {
			// TODO Auto-generated method stub
			//Log.v("ScaleGesture", "onScaleEnd");
			msg = "ScaleGesture: onScaleEnd";
			Toast.makeText(MultiTouch03.this,msg, Toast.LENGTH_SHORT).show();
			super.onScaleEnd(detector);
		}
	};
}
/*
イベント発生
SHARP SH-03Cで試すと, ピンチイン・アウトの操作で, 以下の順にイベントが発生した.
　onScaleBegin -> onScale * n -> onScaleEnd

onScaleBeginイベント
		複数のタッチを検出した際に, onScaleBeginが発生する.　
		更に, 複数タッチした状態で, 新たにタッチしてもonScaleBeginが発生する.
onScaleイベント
		複数タッチした状態で, タッチ位置に変化があった場合にonScaleが発生する.
onScaleEndイベント
		複数タッチした状態で, 1つでもタッチアップするとonScaleEndが発生する. 
		onScaleEndが発生した後, 更に複数のタッチが残っていてもonScaleは発生しない. 
		(例えば, 3本タッチしていて, 1本タッチアップする.)
*/
