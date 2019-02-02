// -*- mode: java -*-  Time-stamp: <2012-02-04 18:14:01 kahata>
/*================================================================
 * title: 
 * file: MemoryInfo02.java
 * created: Time-stamp: <2012-02-04 18:14:01 kahata>
 * link: 
 * description: ヒープの使用量を取得する
 * 最終更新：moonlight_aska 2011年09月26日(月) 23:26:03履歴
 * アプリケーションの中でヒープの使用量を調べるには, ランタイム(Runtime)クラスを利用する.
 * ヒープの使用量を取得
 * MemoryInfo02.java
 * Runtime#getRuntimeメソッドで, Runtimeのインスタンスを取得する.
 * Runtime#totalMemory, freeMemory, maxMemoryメソッドで, 必要な情報を取得する.
 * 注) メモリ不足になると, OutOfMemoryErrorが投げられ, アクティビティが終了する.
 *================================================================*/

package com.moonlight_aska.android.memoryinfo02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MemoryInfo02 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// アプリのメモリ情報を取得
		Runtime runtime = Runtime.getRuntime();
		// トータルメモリ
		Log.v("Runtime", "totalMemory[KB] = " + (int)(runtime.totalMemory()/1024));
		// 空きメモリ
		Log.v("Runtime", "freeMemory[KB] = " + (int)(runtime.freeMemory()/1024));
		// 現在使用しているメモリ
		Log.v("Runtime", "usedMemory[KB] = " + (int)( (runtime.totalMemory() - runtime.freeMemory())/1024) );
		// Dalvikで使用できる最大メモリ
		Log.v("Runtime", "maxMemory[KB] = " + (int)(runtime.maxMemory()/1024));

		String inf =// "こんいちわ";
			"トータルメモリ　totalMemory[KB] = " + (int)(runtime.totalMemory()/1024) +"\n"
		   + "空きメモリ　freeMemory[KB] = " + (int)(runtime.freeMemory()/1024) +"\n"
		   + "現在使用しているメモリ　usedMemory[KB] = " + (int)( (runtime.totalMemory() - runtime.freeMemory())/1024) + "\n"
		   + "Dalvikで使用できる最大メモリ　maxMemory[KB] = " + (int)(runtime.maxMemory()/1024);

			TextView memInfo = (TextView)findViewById(R.id.textView1);	
			memInfo.setText(inf);	
	
	}
}
