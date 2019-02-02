// -*- mode: java -*-  Time-stamp: <2012-02-03 9:14:24 kahata>
/*================================================================
 * title: 
 * file: TextSize.java
 * created: Time-stamp: <2012-02-03 9:14:24 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%c6%a5%ad%a5%b9%a5%c8%a5%b5%a5%a4%a5%ba%a4%f2%a4%ab%a4%a8%a4%eb
 * description: テキストサイズをかえる
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:55:26履歴
 * 文字サイズをかえる
 * Paintクラスのインスタンスを生成する.
 *  Paint#setTextSizeメソッドで, 文字サイズを設定する.
 *  文字列サイズをかえる
 *  Paintクラスのインスタンスを生成する.
 *  各文字の幅を取得し, 文字列の幅を計算する.
 *  Paint#setTextScaleXメソッドで, 文字スケールを設定する.
 *================================================================*/

package com.moonlight_aska.graphic.textsize;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class TextSize extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MyView view = new MyView(getApplication());
		setContentView(view);
	}
}

class MyView extends View {
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		// 文字サイズの設定
		paint.setTextSize(20);
		canvas.drawText("あいうえお", 50, 50, paint);
		// 文字列サイズの設定
		String str = "アイウエオ";
		float[] widths = new float[str.length()];
		int charNum = paint.getTextWidths(str, widths);	// 各文字の幅取得
		int sum = 0;
		for(int i=0; i<charNum; i++){
			sum += widths[i];
		}
		paint.setTextScaleX(250/sum);	// スケールを設定
		canvas.drawText(str, 50, 100, paint);
	}
}