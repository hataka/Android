package com.nea.nehe.lesson05;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
/**
 * The initial Android Activity, setting and initiating
 * the OpenGL ES Renderer Class @see Lesson05.java
 * 
 * @author Savas Ziplies (nea/INsanityDesign)
 */
public class Run extends Activity {

	/** The OpenGL View */
	private GLSurfaceView glSurface;

	/**
	 * Initiate the OpenGL View and set our own
	 * Renderer (@see Lesson05.java)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Create an Instance with this Activity
		glSurface = new GLSurfaceView(this);
		//Set our own Renderer
		glSurface.setRenderer(new Lesson05());
		//Set the GLSurface as View to this Activity
		setContentView(glSurface);
	}

	/**
	 * Remember to resume the glSurface
	 */
	@Override
	protected void onResume() {
		super.onResume();
		glSurface.onResume();
	}

	/**
	 * Also pause the glSurface
	 */
	@Override
	protected void onPause() {
		super.onPause();
		glSurface.onPause();
	}

	// メニュー作成
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lesson051_menu, menu);

		return true;
	}

	// メニューアイテム選択イベント
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.lesson09:
				// コードを追加
				// インテントのインスタンス生成
				Intent intent = new Intent();
				// パッケージ名, クラス名をセット
				intent.setClassName("com.nea.nehe.lesson09", "com.nea.nehe.lesson09.Run");
				// アプリを起動
				startActivity(intent);
				break;
			case R.id.finish:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}



}