package gudon.sample.dialog03;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dialog03Activity extends Activity {
    /** Called when the activity is first created. */
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
                //AlertDialog.Builder dlg;
                //dlg = new AlertDialog.Builder(Dialog03Activity.this);
                //dlg.setTitle("簡単なサンプル");
                //dlg.setMessage("Hello, AlertDialog!");
                //dlg.show();
                new AlertDialog.Builder(Dialog03Activity.this)
                   	.setTitle("簡単なサンプル")
                   	.setMessage("Hello, AlertDialog!")
                   	.show();
            }
        });
    	layout.addView(button);
    }
}
