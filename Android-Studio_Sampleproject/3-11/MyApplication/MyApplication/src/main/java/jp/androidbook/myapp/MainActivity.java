package jp.androidbook.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.OnClickListener;

public class MainActivity extends Activity {
	private TextView textView;
	private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		createContent();
	}

	private void createContent(){
		final MainActivity activity = this;
		// FrameLayout作成
		FrameLayout fl = new FrameLayout(this);
		this.setContentView(fl);
		// LinearLayout作成
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		fl.addView(ll);
		// TextView作成
		textView = new TextView(this);
		textView.setText("Your name:");
		textView.setTextSize(36.0f);
		ll.addView(textView);
		// EditText作成
		editText = new EditText(this);
		editText.setTextSize(24.0f);
		ll.addView(editText);
		// Button作成
		Button btn = new Button(this);
		btn.setText("Click");
		btn.setTextSize(24.0f);
		ll.addView(btn);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				activity.button_onClick(view);
			}
		});
	}

	public void button_onClick(View view){
		Editable s = editText.getText();
		textView.setText("Hi," + s + "!");
	}

}