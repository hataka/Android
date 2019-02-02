package gudon.sample.dialog08;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dialog08Activity extends Activity {
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

            	final CharSequence[] items = {"Red", "Green", "Blue"};
            	final boolean[] checkedItems = {true, false, true};

            	TextView tv=new TextView(Dialog08Activity.this);
            	tv.setText("setView");

            	new AlertDialog.Builder(Dialog08Activity.this)
            	.setIcon(R.drawable.ic_launcher)
            	.setTitle("ダイアログのサンプル")
            	.setView(tv)
                .setMessage("Hello, World!")
            	.setItems(items, new DialogInterface.OnClickListener() {
            	    public void onClick(DialogInterface dialog, int item) { }
            	})
            	.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            	    public void onClick(DialogInterface dialog, int item) {
            	    }
            	})
            	.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            		public void onClick(DialogInterface dialog, int which,
            				boolean isChecked) { }
            		})
            		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            			public void onClick(DialogInterface dialog, int id) {
            				Dialog08Activity.this.finish();
            			}
            		})
            		.setNegativeButton("No", new DialogInterface.OnClickListener() {
            			public void onClick(DialogInterface dialog, int id) {
            				dialog.cancel();
            			}
            		})
            	.show();
            }
        });
    	layout.addView(button);
    }
}


