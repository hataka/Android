package jp.androidbook.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void button_onClick(View view){
		TextView text = (TextView)this.findViewById(R.id.textView);
		EditText edit = (EditText)this.findViewById(R.id.editText);
		Editable s = edit.getText();
		text.setText("Hi," + s + "!");
	}

}