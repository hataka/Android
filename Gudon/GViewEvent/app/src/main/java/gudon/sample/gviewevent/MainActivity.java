package gudon.sample.gviewevent;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
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

	private float x0 = 0, y0 = 0;
	private float dx = 0, dy = 0;
	private float xOffset = 0, yOffset = 0;

	public CustomView(Context context) {
		super(context);

		setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.GREEN);

		canvas.drawRect(xOffset + dx, yOffset + dy, xOffset + dx + rectWidth,
				yOffset + dy + rectHeight, paint);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_LEFT:
			xOffset--;
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			xOffset++;
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			yOffset--;
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			yOffset++;
			break;
		default:
			return true;
		}

		invalidate();
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x0 = x;
			y0 = y;
			break;
		case MotionEvent.ACTION_MOVE:
			dx = x - x0;
			dy = y - y0;
			break;
		case MotionEvent.ACTION_UP:
			xOffset += (x - x0);
			yOffset += (y - y0);
			dx = 0;
			dy = 0;
			break;
		default:
			return true;
		}

		invalidate();
		return true;
	}
}
