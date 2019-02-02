package gudon.sample.ProgressDialog;
//package gudon.sample.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		final Button button = new Button(this);
		button.setText("ダイアログの表示");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final ProgressDialog progressDialog = new ProgressDialog(
						MainActivity.this);
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressDialog.setMessage("Loading...");
				progressDialog.setMax(100);

				// progressDialog.setIndeterminate(true);

				progressDialog.setButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								progressDialog.cancel();
							}
						});

				final Handler handler = new Handler() {
					public void handleMessage(Message msg) {
						int total = msg.arg1;
						progressDialog.setProgress(total);
						if (total >= 100) {
							progressDialog.dismiss();
						}
					}
				};

				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int total = 1; total < 101; total++) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								Log.e("ERROR", "Thread Interrupted");
							}
							Message msg = handler.obtainMessage();
							msg.arg1 = total;
							handler.sendMessage(msg);
						}
					}
				}).start();

				progressDialog.show();

			}
		});
		layout.addView(button);
	}
}


/*
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	/ ** Called when the activity is first created. * /
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
*/
