// -*- mode: java -*-  Time-stamp: <2012-02-04 18:12:02 kahata>
/*================================================================
 * title: 
 * file: MemoryInfo01.java
 * created: Time-stamp: <2012-02-04 18:12:02 kahata>
 * link: 
 * description: システムのメモリ情報を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:31:45履歴
 * アクティビティマネージャ(ActivityManager)クラスを利用することで, システムのメモリ情報を取得することができる.
 * メモリ情報の取得
 * MemoryInfo01.java
 * getSystemServiceメソッドで, ActivityManagerのインスタンスを取得する.
 * ActivityManager.MemoryInfoクラスのインスタンスを生成する.
 * AcrivityManager#getMemoryInfoメソッドで, メモリ情報を取得する.
 * 注) availMem < thresholdとなった時, Activity#onLowMemoryメソッドがコールされる.
 *================================================================*/

package com.moonlight_aska.android.memoryinfo01;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MemoryInfo01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// メモリ情報を取得
		ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
		ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
		activityManager.getMemoryInfo(memoryInfo);

		// システムの利用可能な空きメモリ
		Log.v("MemoryInfo", "memoryInfo.availMem[MB] = " + (int)(memoryInfo.availMem/1024/1024));
		// 低メモリ(LowMemory)状態の閾値
		Log.v("MemoryInfo", "memoryInfo.threshold[MB] = " + (int)(memoryInfo.threshold/1024/1024));
		// 低メモリ状態を示すフラグ(trueでメモリ不足状態)
		Log.v("MemoryInfo", "memoryInfo.lowMemory = " + memoryInfo.lowMemory);
		String inf = "システムの利用可能な空きメモリ　　　　　　　　 memoryInfo.availMem[MB] = " + (int)(memoryInfo.availMem/1024/1024) +"\n"
				   + "低メモリ(LowMemory)状態の閾値　　　　　　　　 memoryInfo.threshold[MB] = " + (int)(memoryInfo.threshold/1024/1024) + "\n"
				   + "低メモリ状態を示すフラグ(trueでメモリ不足状態)　memoryInfo.lowMemory = " + memoryInfo.lowMemory;
		
		TextView memInfo = (TextView)findViewById(R.id.textView1);	
		memInfo.setText(inf);
	}
}
