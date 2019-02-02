package gudon.sample.graphics03;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new CustomView(this));
	}
}

class CustomView extends View {

	private static final float rectWidth = 50;
	private static final float rectHeight = 50;
	private static final long delay_milisec = 1;

	private float dx = 5, dy = 5;
	private float screenWidth, screenHeight;
	private float xOffset = 0, yOffset = 0;

	private boolean isAttached;

	public CustomView(Context context) {
		super(context);

		setFocusable(true);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		screenWidth = w;
		screenHeight = h;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();

		int width = getWidth();
		int height = getHeight();

		paint.setColor(Color.BLACK);
		canvas.drawRect(new Rect(0, 0, width / 2, height), paint);

		paint.setColor(Color.WHITE);
		canvas.drawRect(new Rect(width / 2, 0, width, height), paint);

		paint.setStrokeWidth(4);
		for (int alpha = 0; alpha <= 0xff; alpha += 0x11) {
			paint.setColor(Color.argb(alpha, 0, 0xff, 0));
			canvas.drawLine(10, alpha, width - 10, alpha, paint);
		}
	}

	protected void onAttachedToWindow() {
		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				Log.v("GraphicsSample2",
						String.format("isAttached=%b", isAttached));
				if (isAttached) {
					if (xOffset < 0 || xOffset + rectWidth > screenWidth)
						dx = -dx;
					if (yOffset < 0 || yOffset + rectHeight > screenHeight)
						dy = -dy;
					xOffset += dx;
					yOffset += dy;
					invalidate();
					sendEmptyMessageDelayed(0, delay_milisec);
				}
			}
		};

		isAttached = true;
		handler.sendEmptyMessageDelayed(0, delay_milisec);

		super.onAttachedToWindow();
	}

	protected void onDetachedFromWindow() {
		isAttached = false;

		super.onDetachedFromWindow();
	}
}
