package kahata.YaLauncher;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SubActivity extends Activity {
	/** Called when the activity is first created. */

	private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
    //private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);

		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 次画面のアクティビティ終了
				finish();
			}
		});
	
	}
}
