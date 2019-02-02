package gudon.sample.surfaceview03;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceView03Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		setContentView(new CustomSurfaceView(this));
	}
}

class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	Thread thread;
	boolean isAttached;


	private static final float rectWidth = 50;
	private static final float rectHeight = 50;

	private float dx = 5, dy = 5;
	private float screenWidth, screenHeight;
	private float xOffset = 0, yOffset = 0;

	public CustomSurfaceView(Context context) {
		super(context);

		getHolder().addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		screenWidth = width;
		screenHeight = height;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		isAttached=true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		isAttached = false;
		while (thread.isAlive());
	}

	@Override
	public void run() {
		while (isAttached) {
			Log.v("SurfaceViewSample3","run");

			if (xOffset < 0 || xOffset + rectWidth > screenWidth)
				dx = -dx;
			if (yOffset < 0 || yOffset + rectHeight > screenHeight)
				dy = -dy;
			xOffset += dx;
			yOffset += dy;

			doDraw(getHolder());
		}
	}

	private void doDraw(SurfaceHolder holder){
		Canvas canvas = holder.lockCanvas();

		// この間にグラフィック描画のコードを記述する。

		Paint paint = new Paint();
		paint.setColor(Color.GREEN);

		canvas.drawColor(Color.BLACK);
		canvas.drawRect(xOffset, yOffset, xOffset + rectWidth, yOffset
				+ rectHeight, paint);

		// この間にグラフィック描画のコードを記述する。

		holder.unlockCanvasAndPost(canvas);
	}
}


/*
import android.app.Activity;
import android.os.Bundle;

public class SurfaceView03Activity extends Activity {
    / ** Called when the activity is first created. * /
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
*/