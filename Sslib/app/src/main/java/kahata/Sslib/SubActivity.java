package kahata.Sslib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		String data = intent.getStringExtra("keyword");
		Button btn = (Button)findViewById(R.id.button02_id);
		btn.setText(data);
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
