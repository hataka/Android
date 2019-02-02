package gudon.sample.toast01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Toast01Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("トーストを表示");
        setContentView(button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Context context = getApplicationContext();
        		CharSequence text = "Hello toast!";
        		int duration = Toast.LENGTH_SHORT;

        		Toast toast = Toast.makeText(context, text, duration);
        		toast.show();
            }
        });

	}
}
