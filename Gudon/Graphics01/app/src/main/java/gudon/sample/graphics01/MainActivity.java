package gudon.sample.graphics01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new CustomView(this));
	}
}

class CustomView extends View {

	public CustomView(Context context) {
		super(context);
		setFocusable(true);
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// この間にグラフィック描画のコードを記述する。

		Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		canvas.drawRect(10, 10, 500, 200, paint);

		// この間にグラフィック描画のコードを記述する。
	}
}

