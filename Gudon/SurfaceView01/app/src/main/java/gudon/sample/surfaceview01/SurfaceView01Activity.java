package gudon.sample.surfaceview01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceView01Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new CustomSurfaceView(this));
	}
}

class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	public CustomSurfaceView(Context context) {
		super(context);
		
		getHolder().addCallback(this);
	}

	@Override
	public void surfaceChanged (SurfaceHolder holder, int format, int width, int height) {
		// SurfaceViewが変化（画面の大きさ，ピクセルフォーマット）した時のイベントの処理を記述
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// SurfaceViewが作成された時の処理（初期画面の描画等）を記述
		Canvas canvas = holder.lockCanvas();

		// この間にグラフィック描画のコードを記述する。

		Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		canvas.drawRect(0, 0, 50, 50, paint);

		// この間にグラフィック描画のコードを記述する。

		holder.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// SurfaceViewが廃棄された時の処理を記述
	}
}
