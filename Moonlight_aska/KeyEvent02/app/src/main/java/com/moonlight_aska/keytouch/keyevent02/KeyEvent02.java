/*
キーを無効にする
最終更新：moonlight_aska 2011年10月09日(日) 14:22:42履歴

特定のキー(例えば BACKキー)を無効にするには, 無効にしたいキーのイベントが発生したときに,
 dispatchKeyEventメソッドにおいてtrueを返す.

特定のキーの無効化
dispatchKeyEventメソッドはキーを押したとき, 押し続けたとき, 
あるいはキーを押すのをやめたときににコールされる.
以下, BACK(戻る)キーを無効にする場合を例に説明する.
dispatchメソッドをオーバーライドする.
KeyEvent#getActionメソッドで, キーアクション(DOWN/UP/MULTIPLE)を取得し, 
DOWNの処理の場合キーコードを調べる.
KeyEvent#getKeyCodeメソッドで, 押されたキーのキーコードを取得し, 
キーコードがBACK(戻る)キーの場合trueを返す.
注1) BACKキーは, 他のキーと異なり, キーUP時にdispatchKeyEventメソッドがコールされない.
注2) HOMEキーは, キーを押してもdispatchKeyEventメソッドがコールされないので, 無効化できない.
*/

package com.moonlight_aska.keytouch.keyevent02;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent; 

public class KeyEvent02 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction() == KeyEvent.ACTION_DOWN) {
			if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) {	// BACKキー
				return true;
			}
		}
		return super.dispatchKeyEvent(event);
	}
}
