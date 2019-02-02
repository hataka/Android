package gudon.sample.DatePickerDialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		Calendar c = Calendar.getInstance();
		final int year = c.get(Calendar.YEAR);
		final int month = c.get(Calendar.MONTH);
		final int day = c.get(Calendar.DAY_OF_MONTH);

		final TextView text = new TextView(this);
		text.setText(String.format("%d 年 %d 月 %d 日", year, month + 1, day));
		layout.addView(text);

		final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

			public void onDateSet(DatePicker view, int year, int month, int day) {
				text.setText(String.format("%d 年 %d 月 %d 日", year, month + 1, day));
			}
		};

		final Button button = new Button(this);
		button.setText("ダイアログの表示");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(
						MainActivity.this, dateSetListener, year, month, day);
				datePickerDialog.show();
			}
		});
		layout.addView(button);
	}
}
