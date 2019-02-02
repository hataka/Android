package gudon.sample.TimePickerDialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR_OF_DAY);
        final int minute = c.get(Calendar.MINUTE);

		final TextView text = new TextView(this);
		text.setText(String.format("%d 時 %d分", hour, minute));
		layout.addView(text);

		final TimePickerDialog.OnTimeSetListener timeSetListener =
		    new TimePickerDialog.OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		    		text.setText(String.format("%d 時 %d分", hourOfDay, minute));
				}
		    };

		final Button button = new Button(this);
		button.setText("ダイアログの表示");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
		        new TimePickerDialog(MainActivity.this,
		        		timeSetListener, hour, minute, false).show();
			}
		});
		layout.addView(button);
	}
}
