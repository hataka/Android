/*
キーイベントを取得する
最終更新：moonlight_aska 2011年10月09日(日) 14:19:45履歴
キーを操作すると, キーイベント(Key Event)がACTION(繰返し)→ACTION_UPの順に発生する.
このキーイベントを取得するには, onKeyDownメソッド又はonKeyUpメソッドをオーバーライドする.
また, dispathKeyEventメソッドをオーバーライドしても, 同様の情報を取得することができる. 
dispatchKeyEventメソッドは, onKeyDownメソッドやonKeyUpメソッドよりも先にコールされる.

onKeyDown/onKeyUpメソッドで取得する
onKeyDownメソッドはキーを押したとき又は押し続けたときにコールされ, 
onKeyUpメソッドはキーを押すのをやめたときにコールされる.

onKeyDownメソッド及びonKeyUpメソッドをオーバーライドする.
引数のkeyCodeには, 押されたキーのキーコードが入っている.
dispatchKeyEventメソッドで取得する
dispatchKeyEventメソッドはキーを押したとき, 押し続けたとき, 
あるいはキーを押すのをやめたときににコールされる.

dispatchメソッドをオーバーライドする.
KeyEvent#getActionメソッドで, キーアクション(DOWN/UP/MULTIPLE)を取得できる.
KeyEvent#getKeyCodeメソッドで, 押されたキーのキーコードが取得できる.
*/

package com.moonlight_aska.keytouch.keyevent01;

import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.view.KeyEvent; 

//import android.content.Intent;
//import android.net.Uri;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.Toast;

public class KeyEvent01 extends Activity {
	String msg = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		msg = "KeyDown: " + "KeyCode=" + keyCode;
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
		//Log.v("KeyDown", "KeyCode=" + keyCode);
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		msg = "KeyUp: " +  "KeyCode=" + keyCode;
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
		//Log.v("KeyUp", "KeyCode=" + keyCode);
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		String action="";

		switch(event.getAction()) {
		case KeyEvent.ACTION_DOWN:
			action = "Key Down";
			break;
		case KeyEvent.ACTION_UP:
			action = "Key Up";
			break;
		case KeyEvent.ACTION_MULTIPLE:
			action = "Key Multiple";
			break;
		}
		msg = "KeyEvent: " + action + ": KeyCode=" + event.getKeyCode();
		Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
		
		//Log.v("KeyEvent", action + ": KeyCode=" + event.getKeyCode());
		return super.dispatchKeyEvent(event);
	}
}
