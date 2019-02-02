package gudon.sample.layout32;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Layout32 extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.button).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						ShowPadding("layout", findViewById(R.id.layout));
						ShowPadding("tv", findViewById(R.id.tv));
						ShowPadding("tvLeft", findViewById(R.id.tvLeft));
						ShowPadding("tvTop", findViewById(R.id.tvTop));
						ShowPadding("tvRight", findViewById(R.id.tvRight));
						ShowPadding("tvBottom", findViewById(R.id.tvBottom));
						ShowPadding("tvNone", findViewById(R.id.tvNone));
						ShowPadding("button", findViewById(R.id.button));
					}
				});
	}

	void ShowPadding(String viewName, View v) {
		int paddingLeft = v.getPaddingLeft();
		int paddingTop = v.getPaddingTop();
		int paddingRight = v.getPaddingRight();
		int paddingBottom = v.getPaddingBottom();
		String s = String.format("%s : [ 左 : %d , 上 : %d , 右 : %d , 下 : %d ]", viewName,
				paddingLeft, paddingTop, paddingRight, paddingBottom);

		Log.v("LogSample", s);
	}
}

