package gudon.sample.fileaccess09;

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
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout, new LinearLayout.LayoutParams(FP, FP));

        HorizontalScrollView hsv = new HorizontalScrollView(this);
		ScrollView sv = new ScrollView(this);
		sv.addView(hsv);
		
		final TextView tv = new TextView(this);
		tv.setBackgroundColor(Color.WHITE);
		tv.setTextSize(16.0f);
	    tv.setTypeface(Typeface.MONOSPACE);
		tv.setTextColor(Color.BLACK);

		hsv.addView(tv);

		Button btn = new Button(this);//(Button)findViewById(R.id.button02_id);
		btn.setText("メイン画面に戻る");

		
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		String data = intent.getStringExtra("keyword");
		tv.setPadding(10, 10, 10, 10);
		tv.setText(data);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 次画面のアクティビティ終了
				finish();
			}
		});
		layout.addView(btn);
		layout.addView(sv);
	
	}
}
